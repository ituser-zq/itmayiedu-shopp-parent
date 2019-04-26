package com.itmayiedu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

	@RequestMapping("/index")
	public String index(){
		return "外网可以访问啦!";
	}
	@RequestMapping("/test")
	public String test(String userName){
		System.out.println("userName:"+userName);
		return "userName:"+userName;
	}
}
