package com.jxau.service.impl;

import com.jxau.Exception.SellException;
import com.jxau.dto.OrderDTO;
import com.jxau.enums.ResultEnum;
import com.jxau.service.OrderService;
import com.jxau.service.PayService;
import com.jxau.until.JsonUtil;
import com.jxau.until.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName:com.jxau.service.impl
 * @ClassName:PayServiceImpl
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/04 17:04
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    private static final String ORDER_NAME = "微信点餐";

    @Override
    public PayResponse create(OrderDTO orderDTO) {

        PayRequest request = new PayRequest();
        request.setOpenid(orderDTO.getBuyerOpenid());
        request.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        request.setOrderId(orderDTO.getOrderId());
        request.setOrderName(ORDER_NAME);
        request.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("#######request={}", JsonUtil.toJson(request));


        PayResponse payResponse =  bestPayService.pay(request);
        log.info("#######payResponse={}", JsonUtil.toJson(payResponse));

        return payResponse;
    }

    @Override
    public PayResponse notity(String notityData) {

        //验证签名
        //支付的状态
        //支付金额
        //支付人（下单人 == 支付人）


        PayResponse payResponse = bestPayService.asyncNotify(notityData);
        log.info("######异步通知######payResponse={}", JsonUtil.toJson(payResponse));

        //修改支付状态
        //查询订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        //判断订单是否存在
        if(orderDTO == null){
            log.error("##########异步通知订单不存在#######orderId={}",payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //判断金额是否一致,注意微信端设置的总价类型为double,数据库类型精度为BigDecimal
        if (MathUtil.equals(payResponse.getOrderAmount(),orderDTO.getOrderAmount().doubleValue())){
            log.error("#######校验金额不通过#####");
            throw new SellException(ResultEnum.WXPAY_NOTITY_MONEY_VERIFY_ERROR);
        }
        //进行修改订单
        orderService.paid(orderDTO);

        return payResponse;


    }

    /**
     * 退款
     * @param orderDTO
     * @return
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {

        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("######微信退款 request-{}", JsonUtil.toJson(refundRequest));

        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("#####微信退款###response={}", JsonUtil.toJson(refundResponse));

        return refundResponse;

    }
}
