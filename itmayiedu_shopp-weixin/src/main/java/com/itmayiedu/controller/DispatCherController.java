package com.itmayiedu.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.itmayiedu.base.TextMessage;
import com.itmayiedu.utils.CheckUtil;
import com.itmayiedu.utils.HttpClientUtil;
import com.itmayiedu.utils.XmlUtils;

import ch.qos.logback.core.joran.spi.XMLUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DispatCherController {
	private static final String REQESTURL = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";

	// 服务器验证接口地址
	@RequestMapping(value = "/dispatCher", method = RequestMethod.GET)
	public String dispatCherGet(String signature, String timestamp, String nonce, String echostr) {
		// 1.验证参数
		boolean checkSignature = CheckUtil.checkSignature(signature, timestamp, nonce);
		// 2.参数验证成功之后，返回随机数
		if (!checkSignature) {
			return null;
		}
		return echostr;
	}

	// 微信动作推送
	@RequestMapping(value = "/dispatCher", method = RequestMethod.POST)
	public void dispatCherGet(HttpServletRequest reqest, HttpServletResponse response) throws Exception {
		reqest.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 1.将xml转换成Map格式
		Map<String, String> resultMap = XmlUtils.parseXml(reqest);
		log.info("###收到微信消息####resultMap:" + resultMap.toString());
		// 2.判断消息类型
		String msgType = resultMap.get("MsgType");
		// 3.如果是文本类型，返回结果给微信服务端
		PrintWriter writer = response.getWriter();
		switch (msgType) {
		case "text":
			// 开发者微信公众号
			String toUserName = resultMap.get("ToUserName");
			// 消息来自公众号
			String fromUserName = resultMap.get("FromUserName");
			// 消息内容
			String content = resultMap.get("Content");
			String resultJson = HttpClientUtil.doGet(REQESTURL + content);
			JSONObject jsonObject = JSONObject.parseObject(resultJson);
			Integer resultCode = jsonObject.getInteger("result");
			String msg = null;
			if (resultCode == 0) {
				String resultContent = jsonObject.getString("content");
				msg = setText(resultContent, toUserName,fromUserName);
			}else {
				msg = setText("我现在有点忙.稍后回复您!", toUserName,fromUserName);
			}
			writer.println(msg);
			break;

		default:
			break;
		}
		writer.close();
	}

	public String setText(String content, String fromUserName, String toUserName) {
		TextMessage textMessage = new TextMessage();
		textMessage.setContent(content);
		textMessage.setMsgType("text");
		textMessage.setCreateTime(System.currentTimeMillis());
		textMessage.setFromUserName(fromUserName);
		textMessage.setToUserName(toUserName);
		// 将实体类转换成xml格式
		String msg = XmlUtils.messageToXml(textMessage);
		return msg;
	}
}
