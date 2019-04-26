package com.itmayiedu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.constants.Constants;
import com.itmayiedu.entity.UserEntity;
import com.itmayiedu.fegin.MemberServiceFegin;

@Controller
public class RegisterController {
	@Autowired
	private MemberServiceFegin memberServiceFegin;
	private static final String REGISTER = "register";
	private static final String LOGIN = "login";
	// 跳转注册页面
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {
		return REGISTER;
	}

	// 注册业务具体实现
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(UserEntity userEntity,HttpServletRequest reqest) {
		// 1. 验证参数
		// 2. 调用会员注册接口
		ResponseBase regUser = memberServiceFegin.regUser(userEntity);
		// 3. 如果失败，跳转到失败页面
		if(!regUser.getRtnCode().equals(Constants.HTTP_RES_CODE_200)){
			reqest.setAttribute("error", "註冊失敗");
			 return REGISTER;
		}
		// 4. 如果成功,跳转到成功页面
		return LOGIN;
	}
}
