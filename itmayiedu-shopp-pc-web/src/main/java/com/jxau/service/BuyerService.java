package com.jxau.service;

import com.jxau.dto.OrderDTO;

/**
 * @PackageName:com.jxau.service
 * @ClassName:BuyerService
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/03 02:59
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);


    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);

}
