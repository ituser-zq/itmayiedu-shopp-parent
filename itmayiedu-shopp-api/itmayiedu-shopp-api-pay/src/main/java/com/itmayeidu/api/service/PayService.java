package com.itmayeidu.api.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.entity.PaymentInfo;

@RequestMapping("/pay")
public interface PayService {
    //创建支付令牌
	@RequestMapping("/createPayToken")
	 ResponseBase createToken(@RequestBody PaymentInfo PaymentInfo);
	// 使用支付令牌查找支付信息
	@RequestMapping("/findPayToken")
	 ResponseBase findPayToken(@RequestParam("payToken") String payToken);

}
