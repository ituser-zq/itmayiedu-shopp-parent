package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

		// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
		public static String app_id = "2016100100635831";

		// 商户私钥，您的PKCS8格式RSA2私钥
		public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCrMIBLIPy6rjLDpTj1/z/r7xqQ0MYOfpzTKIJRhg9bCL/RthaY33jNU+Cx+s8rUcq6jDvj71ciAlvUlkTewSTH2WJyg1dui5ufA8MChFJgdLyawcPxwwuZFd0cTelYtR80hg4KxslrstoSYi4cAeTfVsqdyB9tBOHwJtEGJeTo+eeEaI1fk2DQLa8v4pixvD8Qvc6h5N1KxmtDH3fLVjo2Asp4NqanzCTA6XQIlXPKbmaHWrwTIFsnmoxfLB30Ymkq0zHanwJ0AeO8w3ow9YEjEkuozrLEY4/9FjWBid1Xv5SbPqMHLYKIhg7eQviZs2NdJ65fxl8lnndNDOJ3GYWzAgMBAAECggEAWAZ5gag1rDxUqBt2PbABi20IaPyhSuS5+S40TH01uia2k7wgxHzsnhAKUxpXmrvVFbV0OlFgqYEy/Q5D3ZLNOeJC6AU3WQV6gPqrNMkbnrOII7+M5OzZMt92Mc6yNUX1BMoFwG7VNYbi8V8AvLAQovL6/sTfu+wtzZH4G0Qy/8RgGTFzddQAm0aQ3VduczX+o9tVyRimYepfdoG08QIWQqF1JGOf/0ZWD21j8HohWZYAEO68Y/WPAj4aXRRf+ReN0JwEwdJcYql1MVS/+W4LtkgZQpE4rGol0k+Cq/JPEIa9cgEkAmFWyejUi4PpswlJPCeA15VzvRuCAEBpUEpdsQKBgQDq8O1atyIk5zy/C2xffyjLaVupxeb3nnglcpsUOhZz2ZCmrNlxKOCWjpRTBS6ht/5bedUZImup5APbprNPh7PoQ/EQb9VYSsDWFb7pl5em9xI1wkAtFE3zA3cY7jYIwSdduL3PI/yxHZbb3potOmsJjypRPqt+JS8AKKx2ATtVOwKBgQC6iLKI3ODquOYHNtX9EpsYW7aTdqgU47+BduXjgzfGBXs8GOevhZKBOxxhC+ywuY3VFDs7d+liFeLhWG/Vk7l5S9/o1qENJUB6Imc+QenlSnjUlkd0Hpguz/dsSKj1ZFQ1ko8f33ko6Beh/54uJPiB/sj6KrpM0SENQvkPJS+p6QKBgQDGuv1LWtWa+a68u2D0do9/YKOUvD5e/sEKjCL5vRj47fQZyOQ1gCpZsElu4FdNnGGf5zKGjEMd9i39QskyYMuhkLb8/FwuzyzG6qYO2ZgCN8RDjQjUGPTGtwurHvS9+wTdlkOYUAyTlT/ixC0OTPf1ohBdoPFXRwS20bDwMKKLuQKBgAU3l46+ZsgJ3d0rynZmk9HtlsCvG+phqFSNp8ZiQCgYtSasJ6bAHKXiqluIgtk6h14DT9jM9MkahZr55z7Y/+IFnkCb6Cs+9Hu2BJ84JruUBqcjgOIdjPIaPPhZW+hpIvXQoJIqpO/g9fBA/wKZZB32q1Zb5ZQKcVs2mVK0Ho4pAoGAUYeuBFvDQ/t7BTq0a2UPyyoRUXDEGlViQrlnccSfEUeaNkjaWAt/paoftKnzQA6N3mDsWrOE5U8ieotoRT37kNfaNNyBXjNACj1Wt5T8sNBOXAQ1fwrB0MPIv9nOopAprti0x/g8Z60HHSfJiHN5/O7C2mxnicAckzb2uJy0XjI=" ;
		// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
		// 对应APPID下的支付宝公钥。
		public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApzD35QrrCp3QE1B+q2b+WovouUCcQx7VkWiI6lNiiSVXb7/SfeYffbm4Z0DRTAxmxao32mCZBsxiUh+h44CnsWhIvY0cHoXXmsuOytWl5w3bi0jk3++yybgt68wi9i3ZDrRN/EzH7RNA5+tOVK+S1zY4sxHASVrdUWIX9aDP944dJfR3i7jTHze1AkQSvgimEAItJG+TZDh+V+t1s12onzviYd5G8Iq/7Xyofq675rXzbyKF/HOWK1S7hkWCaEsZ+nh8mzH99MUB5yowPoICpl+endSQnAhF7gAKXdG3+y4wd8bEg0OVkjRRymJ+ONm9QvD7dsURW24WYZLIvUmqmwIDAQAB";
		// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String notify_url = "http://comjxau.natapp1.cc//alibaba/callBack/notifyUrl";
		
		// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String return_url = "http://comjxau.natapp1.cc/alibaba/callBack/returnUrl";

		// 签名方式
		public static String sign_type = "RSA2";

		// 字符编码格式
		public static String charset = "utf-8";

		// 支付宝网关
		public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

		// 支付宝网关
		public static String log_path = "C:\\";

		// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

		/**
		 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
		 * 
		 * @param sWord
		 *            要写入日志里的文本内容
		 */
		public static void logResult(String sWord) {
			FileWriter writer = null;
			try {
				writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
				writer.write(sWord);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
}
