package com.itmayiedu.adapter;

import com.alibaba.fastjson.JSONObject;

// 统一发送消息接口
public interface MessageAdapter {
	public void sendMsg(JSONObject body);
}
