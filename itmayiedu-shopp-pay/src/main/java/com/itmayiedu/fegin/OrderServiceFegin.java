package com.itmayiedu.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.itmayiedu.api.order.OrderService;

@Component
@FeignClient("order")
public interface OrderServiceFegin extends OrderService {

}
