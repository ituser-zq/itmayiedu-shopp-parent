package com.jxau.controller;

import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.constants.Constants;
import com.itmayiedu.entity.UserEntity;
import com.jxau.config.ProjectUrlConfig;
import com.jxau.fegin.MemberServiceFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @PackageName: com.itmayiedu.controllerimpl
 * @ClassName: RegisterController.java
 * @Description:
 * @Author: ZQ
 * @Date: 2019/04/26 17:26
 *
 */


@Controller
public class RegisterController {
	@Autowired
	private MemberServiceFegin memberServiceFegin;
	@Autowired
	private ProjectUrlConfig projectUrlConfig;
	private static final String REGISTER = "register";
	private static final String LOGIN = "login";
	// 跳转注册页面
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerGet() {
		return new ModelAndView("register");
	}

	// 注册业务具体实现
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPost(UserEntity userEntity, HttpServletRequest reqest) {
		// 1. 验证参数
		// 2. 调用会员注册接口
		ResponseBase regUser = memberServiceFegin.regUser(userEntity);
		// 3. 如果失败，跳转到失败页面
		if(!regUser.getRtnCode().equals(Constants.HTTP_RES_CODE_200)){
			reqest.setAttribute("error", "注册失败");
			 return new ModelAndView("register");
		}
		// 4. 如果成功,跳转到成功页面
		return new ModelAndView("redirect:" +projectUrlConfig.getSell() +"/sell/login");
	}
}
