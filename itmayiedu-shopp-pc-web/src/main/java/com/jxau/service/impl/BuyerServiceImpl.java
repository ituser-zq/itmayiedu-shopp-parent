package com.jxau.service.impl;

import com.jxau.Exception.SellException;
import com.jxau.dto.OrderDTO;
import com.jxau.enums.ResultEnum;
import com.jxau.service.BuyerService;
import com.jxau.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName:com.jxau.service.impl
 * @ClassName:BuyerServiceImpl
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/03 03:01
 */

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

       OrderDTO orderDTO = orderService.findOne(orderId);
       if(orderDTO == null){
           return null;
       }

       if(!orderDTO.getBuyerOpenid().equals(orderId)){
           log.info("######查询订单openID不符######");
           throw new SellException(ResultEnum.ORDER_OWNER_ERROR);

       }

        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            log.info("#####查询不到该订单#####");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDTO);
    }
}
