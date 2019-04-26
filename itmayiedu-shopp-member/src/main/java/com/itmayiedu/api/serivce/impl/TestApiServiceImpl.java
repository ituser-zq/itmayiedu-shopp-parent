package com.itmayiedu.api.serivce.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.itmayiedu.api.service.TestApiService;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;

import lombok.extern.slf4j.Slf4j;

@RestController
public class TestApiServiceImpl extends BaseApiService implements TestApiService {

	@Override
	public Map<String, Object> test(Integer id, String name) {
		Map<String, Object> result = new HashMap<>();
		result.put("rtnCode", "200");
		result.put("rtnMsg", "success");
		result.put("data", "id:" + id + ",name:" + name);
		return result;
	}

	@Override
	public ResponseBase testResponseBase() {
		return setResultSuccess();
	}

	@Override
	public ResponseBase settestRedis(String key, String value) {
		baseRedisService.setString(key, value, null);
		return setResultSuccess();
	}

}
