package com.jxau.fegin;

import com.itmayeidu.api.service.CallBackService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient("pay")
@Component
public interface CallBackServiceFegin extends CallBackService {

}
