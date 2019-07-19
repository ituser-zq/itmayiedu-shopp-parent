package com.jxau.service;

import com.jxau.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @PackageName:com.jxau.service
 * @ClassName:PayService
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/04 17:03
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notity(String notityData);

    RefundResponse refund(OrderDTO orderDTO);

}
