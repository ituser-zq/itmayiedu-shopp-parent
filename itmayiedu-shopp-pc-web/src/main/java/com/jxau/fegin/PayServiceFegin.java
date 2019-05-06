package com.jxau.fegin;

import com.itmayeidu.api.service.PayService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("pay")
public interface PayServiceFegin extends PayService {

}
