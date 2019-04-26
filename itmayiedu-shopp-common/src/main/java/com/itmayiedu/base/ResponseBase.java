package com.itmayiedu.base;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class ResponseBase {

	private Integer rtnCode;
	private String msg;
	private Object data;

	public ResponseBase() {

	}

	public ResponseBase(Integer rtnCode, String msg, Object data) {
		super();
		this.rtnCode = rtnCode;
		this.msg = msg;
		this.data = data;
	}

	public static void main(String[] args) {
		ResponseBase responseBase = new ResponseBase();
		responseBase.setData("123456");
		responseBase.setMsg("success");
		responseBase.setRtnCode(200);
		System.out.println(responseBase.toString());
		log.info("itmayiedu...");
	}

	@Override
	public String toString() {
		return "ResponseBase [rtnCode=" + rtnCode + ", msg=" + msg + ", data=" + data + "]";
	}

}
