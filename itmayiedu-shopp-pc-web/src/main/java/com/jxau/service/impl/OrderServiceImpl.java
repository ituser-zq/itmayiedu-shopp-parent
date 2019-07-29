package com.jxau.service.impl;

import com.jxau.Exception.SellException;
import com.jxau.converter.OrderMasterToOrderDTOConverter;
import com.jxau.domain.OrderDetail;
import com.jxau.domain.OrderMaster;
import com.jxau.domain.ProductInfo;
import com.jxau.dto.CartDTO;
import com.jxau.dto.OrderDTO;
import com.jxau.enums.OrderStatusEnum;
import com.jxau.enums.PayStatusEnum;
import com.jxau.enums.ResultEnum;
import com.jxau.repository.OrderDetailDao;
import com.jxau.repository.OrderMasterDao;
import com.jxau.service.OrderService;
import com.jxau.service.ProductService;
import com.jxau.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @PackageName:com.jxau.service.impl
 * @ClassName:OrderServiceImpl
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 14:44
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService
{

   @Autowired
   private ProductService productService;

   @Autowired
   private OrderDetailDao orderDetailDao;

   @Autowired
   private OrderMasterDao orderMasterDao;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        BigDecimal orderAmount =new BigDecimal(BigInteger.ZERO);

        String orderId = KeyUtil.getUniqueKey();

        //查询商品（数量价格）
        for(OrderDetail orderDetail: orderDTO.getOrderDetailList()){
                    ProductInfo productInfo = productService.findOne(orderDetail.getProductId());

                if(productInfo ==null){
                    throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
                }

                //计算总价
               orderAmount =  productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);

                //订单详情入库

                //先拷贝再设置，如果拷贝值为null就为空
                BeanUtils.copyProperties(productInfo,orderDetail);

                orderDetail.setDetailId(KeyUtil.getUniqueKey());
                orderDetail.setOrderId(orderId);
                orderDetailDao.save(orderDetail);

        }


        //写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        //先进行拷贝，但是拷贝的状态码被覆盖
        BeanUtils.copyProperties(orderDTO,orderMaster);

        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmount);


        orderMasterDao.save(orderMaster);

        //扣库存
        List<CartDTO> cartDTOList =
                orderDTO.getOrderDetailList()
                        .stream()
                        .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                        .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {

        OrderMaster orderMaster = orderMasterDao.findOne(orderId);
        if(orderMaster ==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

       List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {

            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIT);
        }

        OrderDTO orderDTO =new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {

        Page<OrderMaster> orderMasterPage = orderMasterDao.findByBuyerOpenid(buyerOpenId, pageable);

        List<OrderDTO> orderDTOList =  OrderMasterToOrderDTOConverter.convert(orderMasterPage.getContent());
        Page<OrderDTO> orderDTOPage =new PageImpl<OrderDTO>(orderDTOList,pageable,orderMasterPage.getTotalElements());

        return orderDTOPage;
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {

        OrderMaster orderMaster =new OrderMaster();

        //判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.info("##########q取消订单，订单状态不正确#########");
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);

        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateMaster = orderMasterDao.save(orderMaster);

        if(updateMaster == null){
            log.info("##########订单修改失败############");
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        //返回库存
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.info("#########订单详情为空######");
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList =orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(cartDTOList);


        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {

        //判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改状态
        OrderMaster orderMaster =new OrderMaster();
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHEN.getCode());
        BeanUtils.copyProperties(orderDTO,orderMaster);

        OrderMaster result =  orderMasterDao.save(orderMaster);
        if(result == null){
            log.info("#########完结订单，失败#########");
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {

        //判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
           log.info("#########订单状态不正确######");
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //判断支付状态
        if(!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())){
            log.info("###########支付状态不正确########");
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }

        //修改支付状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
       OrderMaster result =  orderMasterDao.save(orderMaster);
        if(result == null){
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {

        Page<OrderMaster> pageableResult = orderMasterDao.findAll(pageable);

        List<OrderDTO> orderDTOList = OrderMasterToOrderDTOConverter.convert(pageableResult.getContent());

        return new PageImpl<>(orderDTOList,pageable,pageableResult.getTotalElements());
    }
}
