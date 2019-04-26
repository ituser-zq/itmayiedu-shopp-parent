package com.itmayiedu.controller;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.constants.Constants;
import com.itmayiedu.entity.UserEntity;
import com.itmayiedu.fegin.MemberServiceFegin;
import com.itmayiedu.utils.CookieUtil;
import com.netflix.discovery.converters.Auto;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;

@Controller
public class LoginController {
	@Autowired
	private MemberServiceFegin memberServiceFegin;
	private static final String LOGIN = "login";
	private static final String INDEX = "redirect:/";
	private static final String qqrelation = "qqrelation";
	// 跳转登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return LOGIN;
	}

	// 登录请求具体提交实现
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(UserEntity userEntity, HttpServletRequest request, HttpServletResponse response) {
		// 1.验证参数
		// 2.调用登录接口，获取token信息
		ResponseBase loginBase = memberServiceFegin.login(userEntity);
		if (!loginBase.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
			request.setAttribute("error", "账号或者密码错误!");
			return LOGIN;
		}

		LinkedHashMap loginData = (LinkedHashMap) loginBase.getData();
		String memberToken = (String) loginData.get("memberToken");
		if (StringUtils.isEmpty(memberToken)) {
			request.setAttribute("error", "会话已经失效!");
			return LOGIN;
		}
		// 3.将token信息存放在cookie里面
		setCookie(memberToken, response);
		return INDEX;
	}
	public void setCookie(String memberToken, HttpServletResponse response){
		CookieUtil.addCookie(response, Constants.COOKIE_MEMBER_TOKEN, memberToken, Constants.COOKIE_TOKEN_MEMBER_TIME);
	}

	// 生成qq授权登录链接
	@RequestMapping("/locaQQLogin")
	public String locaQQLogin(HttpServletRequest reqest) throws QQConnectException {
		String authorizeURL = new Oauth().getAuthorizeURL(reqest);
		return "redirect:" + authorizeURL;

	}
	@RequestMapping("/qqLoginCallback")
	public String qqLoginCallback(HttpServletRequest reqest, HttpServletResponse response,HttpSession httpSession) throws QQConnectException {

		// 1.获取授权码COde
		// 2.使用授权码Code获取accessToken
		AccessToken accessTokenOj = new Oauth().getAccessTokenByRequest(reqest);
		if (accessTokenOj == null) {
			reqest.setAttribute("error", "QQ授权失败");
			return "error";
		}
		String accessToken = accessTokenOj.getAccessToken();
		if (accessToken == null) {
			reqest.setAttribute("error", "accessToken为null");
			return "error";
		}
		// 3.使用accessToken获取openid
		OpenID openidOj = new OpenID(accessToken);
		String userOpenId = openidOj.getUserOpenID();
		// 4.调用会员服务接口 使用userOpenId 查找是否已经关联过账号
		ResponseBase openUserBase = memberServiceFegin.findByOpenIdUser(userOpenId);
		if(openUserBase.getRtnCode().equals(Constants.HTTP_RES_CODE_201)){
			// 5.如果没有关联账号，跳转到关联账号页面
			httpSession.setAttribute("qqOpenid", userOpenId);
			return qqrelation;
		}
		//6.已经绑定账号  自动登录 将用户token信息存放在cookie中
		LinkedHashMap dataTokenMap = (LinkedHashMap) openUserBase.getData();
		String memberToken=(String) dataTokenMap.get("memberToken");
		setCookie(memberToken, response);
		return INDEX;
	}

	// 登录请求具体提交实现
	@RequestMapping(value = "/qqRelation", method = RequestMethod.POST)
	public String qqRelation(UserEntity userEntity, HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) {
		// 1.获取openid
		String qqOpenid=(String) httpSession.getAttribute("qqOpenid");
		if(StringUtils.isEmpty(qqOpenid)){
			request.setAttribute("error", "没有获取到openid");
			return "error";
		}
		
		// 2.调用登录接口，获取token信息
		userEntity.setOpenid(qqOpenid);
		ResponseBase loginBase = memberServiceFegin.qqLogin(userEntity);
		if (!loginBase.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
			request.setAttribute("error", "账号或者密码错误!");
			return LOGIN;
		}

		LinkedHashMap loginData = (LinkedHashMap) loginBase.getData();
		String memberToken = (String) loginData.get("memberToken");
		if (StringUtils.isEmpty(memberToken)) {
			request.setAttribute("error", "会话已经失效!");
			return LOGIN;
		}
		// 3.将token信息存放在cookie里面
		setCookie(memberToken, response);
		return INDEX;
	}
}
