package com.itmayiedu.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.itmayiedu.api.service.MemberService;

@Component
@FeignClient("member")
public interface MemberServiceFegin extends MemberService {

}
