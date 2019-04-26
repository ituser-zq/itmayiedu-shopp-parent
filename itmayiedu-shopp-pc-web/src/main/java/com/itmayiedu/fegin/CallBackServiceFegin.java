package com.itmayiedu.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.itmayeidu.api.service.CallBackService;

@FeignClient("pay")
@Component
public interface CallBackServiceFegin extends CallBackService {

}
