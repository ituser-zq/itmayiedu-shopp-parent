package com.itmayiedu.api.service;

import java.util.Map;

import com.itmayeidu.api.service.CallBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;

import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.constants.Constants;
import com.itmayiedu.dao.PaymentInfoDao;
import com.itmayiedu.entity.PaymentInfo;
import com.itmayiedu.fegin.OrderServiceFegin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CallBackServiceImpl extends BaseApiService implements CallBackService {
	@Autowired
	private PaymentInfoDao paymentInfoDao;
	@Autowired
	private OrderServiceFegin orderServiceFegin;

	@Override
	public ResponseBase synCallBack(@RequestParam Map<String, String> params) {
		// 1.日志记录
		log.info("#####支付宝同步通知synCallBack#####开始,params:{}", params);
		// 2.验签操作
		try {
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key,
					AlipayConfig.charset, AlipayConfig.sign_type); // 调用SDK验证签名
			log.info("#####支付宝同步通知signVerified:{}######", signVerified);
			// ——请在这里编写您的程序（以下代码仅作参考）——
			if (!signVerified) {
				return setResultError("验签失败!");
			}
			// 商户订单号
			String outTradeNo = params.get("out_trade_no");
			// 支付宝交易号
			String tradeNo = params.get("trade_no");
			// 付款金额
			String totalAmount = params.get("total_amount");
			JSONObject data = new JSONObject();
			data.put("outTradeNo", outTradeNo);
			data.put("tradeNo", tradeNo);
			data.put("totalAmount", totalAmount);
			return setResultSuccess(data);
		} catch (Exception e) {
			log.error("####支付宝同步通知出现异常,ERROR:", e);
			return setResultError("系统错误!");
		} finally {
			log.info("#####支付宝同步通知synCallBack#####结束,params:{}", params);
		}

	}

	@Override
	public String asynCallBack(@RequestParam Map<String, String> params) {
		// 1.日志记录
		log.info("#####支付宝异步通知synCallBack#####开始,params:{}", params);
		// 2.验签操作
		try {
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key,
					AlipayConfig.charset, AlipayConfig.sign_type); // 调用SDK验证签名
			log.info("#####支付宝异步通知signVerified:{}######", signVerified);
			// ——请在这里编写您的程序（以下代码仅作参考）——
			if (!signVerified) {
				return Constants.PAY_FAIL;
			}
			// 商户订单号
			String outTradeNo = params.get("out_trade_no");
			PaymentInfo paymentInfo = paymentInfoDao.getByOrderIdPayInfo(outTradeNo);
			if (paymentInfo == null) {
				return Constants.PAY_FAIL;
			}

			// 支付宝重试机制
			Integer state = paymentInfo.getState();
			if (state == 1) {
				return Constants.PAY_SUCCESS;
			}

			// 支付宝交易号
			String tradeNo = params.get("trade_no");
			// 付款金额
			// String totalAmount = params.get("total_amount");
			// 判断实际付款金额与商品金额是否一致
			// 修改 支付表状态
			// 标识为已经支付
			paymentInfo.setState(1);
			paymentInfo.setPayMessage(params.toString());
			paymentInfo.setPlatformorderId(tradeNo);
			// 手动 begin begin
			Integer updateResult = paymentInfoDao.updatePayInfo(paymentInfo);
			if (updateResult <= 0) {
				return Constants.PAY_FAIL;
			}
			// 调用订单接口通知 支付状态
			ResponseBase orderResult = orderServiceFegin.updateOrderIdInfo(1L, tradeNo, outTradeNo);
			if (!orderResult.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
				// 回滚 手动回滚 rollback
				return Constants.PAY_FAIL;
			} // 2PC 3PC TCC MQ
				// 手动 提交 comiit;
			return Constants.PAY_SUCCESS;
		} catch (Exception e) {
			log.error("####支付宝异步通知出现异常,ERROR:", e);
			// 回滚 手动回滚 rollback
			return Constants.PAY_FAIL;
		} finally {
			log.info("#####支付宝异步通知synCallBack#####结束,params:{}", params);
		}
	}

}
