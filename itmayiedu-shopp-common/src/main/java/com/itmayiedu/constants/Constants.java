package com.itmayiedu.constants;

public interface Constants {
	// 响应请求成功
	String HTTP_RES_CODE_200_VALUE = "success";
	// 系统错误
	String HTTP_RES_CODE_500_VALUE = "fial";
	// 响应请求成功code
	Integer HTTP_RES_CODE_200 = 200;
	// 系统错误
	Integer HTTP_RES_CODE_500 = 500;
	// 未关联QQ账号
	Integer HTTP_RES_CODE_201 = 201;
	// 发送邮件
	String MSG_EMAIL = "email";
	// 会员token
	String TOKEN_MEMBER = "TOKEN_MEMBER";
	// 支付token
	String TOKEN_PAY = "TOKEN_pay";
	// 支付成功
	String PAY_SUCCESS = "success";
	// 支付白
	String PAY_FAIL = "fail";
	// 用户有效期 90天
	Long TOKEN_MEMBER_TIME = (long) (60 * 60 * 24 * 90);
	int COOKIE_TOKEN_MEMBER_TIME = (60 * 60 * 24 * 90);
	Long PAY_TOKEN_MEMBER_TIME = (long) (60 * 15);
	// cookie 会员 totoken 名称
	String COOKIE_MEMBER_TOKEN = "cookie_member_token";

}
