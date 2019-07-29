package com.jxau.controller;

import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.constants.Constants;
import com.jxau.fegin.CallBackServiceFegin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 *
 * @PackageName: com.itmayiedu.controllerimpl
 * @ClassName: CallBackController.java
 * @Description:
 * @Author: ZQ
 * @Date: 2019/04/26 17:25
 *
 */
@Slf4j
@RequestMapping("/alibaba/callBack")
@Controller
public class CallBackController {
	@Autowired
	private CallBackServiceFegin callBackServiceFegin;
	private static final String PAY_SUCCESS = "pay_success";

	// 同步通知
	@RequestMapping("/returnUrl")
	public void synCallBack(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		log.info("###支付宝同步回调CallBackController####synCallBack开始 params:{}", params);
		ResponseBase synCallBackResponseBase = callBackServiceFegin.synCallBack(params);
		PrintWriter writer = response.getWriter();
		if (!synCallBackResponseBase.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
			// 报错页面
			return;
		}
		LinkedHashMap data = (LinkedHashMap) synCallBackResponseBase.getData();
		String outTradeNo = (String) data.get("outTradeNo");
		// 支付宝交易号
		String tradeNo = (String) data.get("tradeNo");
		// 付款金额
		String totalAmount = (String) data.get("totalAmount");
	
		log.info("###支付宝同步回调CallBackController####synCallBack結束 params:{}", params);
		// 封装成html 浏览器模拟去提交
		String htmlFrom="<form name='punchout_form' "
				+ "method='post' "
				+ "action='http://127.0.0.1:8081/alibaba/callBack/synSuccessPage' >"
				+ "<input type='hidden' name='outTradeNo' value='"+outTradeNo+"'>"
				+ "<input type='hidden' name='tradeNo' value='"+tradeNo+"'>"
				+ "<input type='hidden' name='totalAmount' value='"+totalAmount+"'>"
				+ "<input type='submit' value='立即支付' style='display:none'>"
				+ "</form>"
				+ "<script>document.forms[0].submit();</script>";
		writer.println(htmlFrom);	
	}

	// 以post表达隐藏参数
	@RequestMapping(value = "/synSuccessPage", method = RequestMethod.POST)
	public String synSuccessPage(HttpServletRequest request, String outTradeNo, String tradeNo, String totalAmount) {
		request.setAttribute("outTradeNo", outTradeNo);
		request.setAttribute("tradeNo", tradeNo);
		request.setAttribute("totalAmount", totalAmount);
		return PAY_SUCCESS;
	}

	// 异步通知
	@RequestMapping("/notifyUrl")
	@ResponseBody
	public String asynCallBack(HttpServletRequest request,HttpServletResponse response) {
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
//			// 乱码解决，这段代码在出现乱码时使用
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		log.info("###支付宝异步回调CallBackController####synCallBack开始 params:{}", params);
		String result = callBackServiceFegin.asynCallBack(params);
		return result;

	}

}
