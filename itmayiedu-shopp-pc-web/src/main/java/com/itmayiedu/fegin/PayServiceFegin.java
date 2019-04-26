package com.itmayiedu.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.itmayeidu.api.service.PayService;

@Component
@FeignClient("pay")
public interface PayServiceFegin extends PayService {

}
