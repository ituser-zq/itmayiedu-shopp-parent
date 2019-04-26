package com.itmayiedu.api.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import com.itmayiedu.base.ResponseBase;

@RequestMapping("/member")
public interface TestApiService {
	@RequestMapping("/test")
	 Map<String, Object> test(Integer id, String name);

	@RequestMapping("/testResponseBase")
	 ResponseBase testResponseBase();

	@RequestMapping("/testRedis")
	 ResponseBase settestRedis(String key,String value);
}
