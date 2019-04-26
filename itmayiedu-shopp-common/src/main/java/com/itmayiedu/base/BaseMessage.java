package com.itmayiedu.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseMessage {

	/**
	 * 开发者微信
	 */
	private String ToUserName;
	/**
	 * 发送方openid
	 */
	private String FromUserName;
	/**
	 * 创建时间
	 */
	private long CreateTime;
	/**
	 * 内容类型
	 */
	private String MsgType;
	// /**
	// * 消息id
	// */
	// private long MsgId ;
}
