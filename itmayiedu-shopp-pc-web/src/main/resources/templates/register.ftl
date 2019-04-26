<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>云EC电商系统-欢迎注册会员</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="/view/default/css/common.css" />
<link rel="stylesheet" href="/view/default/css/loginregister.css" />
<link rel="stylesheet" href="/view/default/css/valifrom.css" />
</head>
<style>
.form-box .input-box {
	overflow: visible;
}
</style>
<body>
	<div class="ny-header">
		<div class="nb">
			<div class="logo">
				<a href="../index.html"><img src="static/images/logo.png" alt="" /></a>
				<span>&middot; 欢迎注册</span>
			</div>
			<div class="right">
				<span>我已经注册，马上</span> <a href="login.html" class="blue">登录 &gt;</a>
			</div>
		</div>
	</div>
	<div class="nb">
		<div class="ny-body ny-register">
			<div class="left">
				<div class="form-box">
					<form action="/register" method="post">
						<div class="input-box input-box1 onfocusstyle user-word">
							<label for="username" class="icon-user"></label> <input
								type="text" name="username" id="username" value=""
								placeholder="用户名" maxlength="20" autocomplete="off" />
							<div class="Validform_checktip formtip">
								<span class="i-tip"><i></i><label>支持中文、字母、数字、“-”“_”的组合</label></span>
							</div>
						</div>
						<div class="input-box input-box1 onfocusstyle user-word">
							<label for="username" class="icon-user"></label> <input
								type="text" name="email" id="email" value=""
								placeholder="邮&nbsp箱" maxlength="50" autocomplete="off" />

						</div>
						<div class="input-box onfocusstyle position-input p-w">
							<label class="icon-phone" for="mobile"></label> <input
								type="text" id="mobile" value="" placeholder="手机号码"
								maxlength="11" autocomplete="off" />
							<div class="Validform_checktip formtip">
								<span class=""><i></i><label></label></span>
							</div>
						</div>

						<div class="input-box onfocusstyle  pass-w">
							<label class="icon-setpassw" for="password"></label> <input
								type="password" name="password" id="password" value=""
								placeholder="请输入密码" maxlength="20" min="8" autocomplete="off" />
							<div class="Validform_checktip formtip">
								<span class="i-tip"><i></i><label>建议使用字母、数字和符号两种及以上的组合，6-20个字符</label></span>
							</div>
						</div>
						<div class="input-box onfocusstyle position-input  pass-w2">
							<label class="icon-setpassw" for="repassword"></label> <input
								type="password" name="repassword" id="repassword" value=""
								placeholder="请再次输入密码" maxlength="20" />
							<div class="Validform_checktip formtip">
								<span class=""><i></i><label></label></span>
							</div>
						</div>
						<div class="check onfocusstyle" style="position: relative;">
							<input type="checkbox" nullmsg="请阅读并选择" name="agree" id="agree"
								value="1" />&nbsp;&nbsp;<label for="agree">我已阅读并同意</label> <a
								href="javascript:void(0);" class="blue" id="rule">《云EC电商系统用户协议》</a>
							<div class="Validform_checktip formtip" style="top: 0px;">
								<span class=""><i></i><label></label></span>
							</div>
						</div>
						<div class="input-box sub-box">
							<input type="submit" id="reg" value="注册" />
						</div>
					</form>
				</div>

			</div>
			<div class="right">
				<div class="hezuo oauth">
					<!--<h4>如果您已注册，请<a href="login.html" class="blue">直接登录</a></h4>
<p style="border-top: dashed 1px #ddd;margin: 15px auto; "></p>-->
					<h4>合作网站帐号登录：</h4>
					<ul>
						<li><a href="/plugin.html?mod=oauth&c=wx" class="wx">微信</a></li>

						<li><a href="/plugin.html?mod=oauth&c=qq" class="qq">QQ</a></li>

					</ul>
				</div>
			</div>
		</div>
		<div class="ny-footer">
			<div class="link">
				<a href="/">首页</a> | <a href="/n-help.html">关于我们</a> | <a
					href="/n-help.html">联系我们</a> | <a href="/timespike.html">限时抢购</a> |
				<a href="/user.html">会员中心</a> | <a href="/n-help.html">帮助中心</a>
			</div>
			<div class="copyright">
				<p>
				<p>
					Copy@2017 <a href="http://www.yunec.cn/" target="_blank">云EC电商系统</a>
					<a href="http://www.yunec.cn/" target="_blank">www.yunec.cn</a>&nbsp;All
					Rights Reserved 粤ICP备16042138号-1
				</p>
				</p>
			</div>
		</div>
	</div>

	<div class="pass-rule">
		<div class="pass-rule-box">
			<div class="rule-title">
				<h3>用户协议</h3>
				<a href="javascript:void(0);" class="btn-close"></a>
				<div class="rule-nr">
					<h4
						style="white-space: normal; margin: 0px; padding: 0px; color: #333333; font-size: 14px; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; line-height: 20px; background-color: #FFFFFF;">
						云EC用户注册协议aaaaaaaaaaaaaa</h4>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						本协议是您与云EC网站（简称"本站"，网址：www.yunec.cn）所有者（以下简称为"云EC"）之间就云EC网站服务等相关事宜所订立的契约，请您仔细阅读本注册协议，您点击"同意并继续"按钮后，本协议即构成对双方有约束力的法律文件。
					</p>
					<h5
						style="white-space: normal; margin: 10px 0px; padding: 0px; color: #333333; font-size: 14px; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; line-height: 20px; background-color: #FFFFFF;">
						第1条 本站服务条款的确认和接纳</h5>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="margin: 0px; padding: 0px;">1.1</strong>本站的各项电子服务的所有权和运作权归云EC所有。用户同意所有注册协议条款并完成注册程序，才能成为本站的正式用户。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。
					</p>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="margin: 0px; padding: 0px;">1.2</strong>用户点击同意本协议的，即视为用户确认自己具有享受本站服务、下单购物等相应的权利能力和行为能力，能够独立承担法律责任。
					</p>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="margin: 0px; padding: 0px;">1.3</strong>如果您在18周岁以下，您只能在父母或监护人的监护参与下才能使用本站。
					</p>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="margin: 0px; padding: 0px;">1.4</strong>云EC保留在中华人民共和国大陆地区法施行之法律允许的范围内独自决定拒绝服务、关闭用户账户、清除或编辑内容或取消订单的权利。
					</p>
					<h5
						style="white-space: normal; margin: 10px 0px; padding: 0px; color: #333333; font-size: 14px; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; line-height: 20px; background-color: #FFFFFF;">
						第2条 本站服务</h5>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="margin: 0px; padding: 0px;">2.1</strong>云EC通过互联网依法为用户提供互联网信息等服务，用户在完全同意本协议及本站规定的情况下，方有权使用本站的相关服务。
					</p>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="margin: 0px; padding: 0px;">2.2</strong>用户必须自行准备如下设备和承担如下开支：（1）上网设备，包括并不限于电脑或者其他上网终端、调制解调器及其他必备的上网装置；（2）上网开支，包括并不限于网络接入费、上网设备租用费、手机流量费等。
					</p>
					<h5
						style="white-space: normal; margin: 10px 0px; padding: 0px; color: #333333; font-size: 14px; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; line-height: 20px; background-color: #FFFFFF;">
						第3条 用户信息</h5>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="margin: 0px; padding: 0px;">3.1</strong>用户应自行诚信向本站提供注册资料，用户同意其提供的注册资料真实、准确、完整、合法有效，用户注册资料如有变动的，应及时更新其注册资料。如果用户提供的注册资料不合法、不真实、不准确、不详尽的，用户需承担因此引起的相应责任及后果，并且云EC保留终止用户使用云EC各项服务的权利。
					</p>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="margin: 0px; padding: 0px;">3.2</strong>用户在本站进行浏览、下单购物等活动时，涉及用户真实姓名/名称、通信地址、联系电话、电子邮箱等隐私信息的，本站将予以严格保密，除非得到用户的授权或法律另有规定，本站不会向外界披露用户隐私信息。
					</p>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<br />
					</p>
					<p
						style="margin-top: 0px; margin-bottom: 0px; white-space: normal; padding: 0px; color: #666666; font-family: 'Microsoft YaHei', 'Hiragino Sans GB'; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
					<h4
						style="box-sizing: border-box; margin: 0px; padding: 0px; font-weight: normal; font-size: 14px; color: #333333; text-align: justify; white-space: normal; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; line-height: 20px; background-color: #FFFFFF;">
						云EC用户注册协议aaaaaaaaaaaaaa</h4>
					<p
						style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: justify; white-space: normal; color: #666666; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						本协议是您与云EC网站（简称"本站"，网址：www.yunec.cn）所有者（以下简称为"云EC"）之间就云EC网站服务等相关事宜所订立的契约，请您仔细阅读本注册协议，您点击"同意并继续"按钮后，本协议即构成对双方有约束力的法律文件。
					</p>
					<h5
						style="box-sizing: border-box; margin: 10px 0px; padding: 0px; font-weight: normal; font-size: 14px; color: #333333; text-align: justify; white-space: normal; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; line-height: 20px; background-color: #FFFFFF;">
						第1条 本站服务条款的确认和接纳</h5>
					<p
						style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: justify; white-space: normal; color: #666666; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="box-sizing: border-box; margin: 0px; padding: 0px;">1.1</strong>本站的各项电子服务的所有权和运作权归云EC所有。用户同意所有注册协议条款并完成注册程序，才能成为本站的正式用户。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。
					</p>
					<p
						style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: justify; white-space: normal; color: #666666; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="box-sizing: border-box; margin: 0px; padding: 0px;">1.2</strong>用户点击同意本协议的，即视为用户确认自己具有享受本站服务、下单购物等相应的权利能力和行为能力，能够独立承担法律责任。
					</p>
					<p
						style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: justify; white-space: normal; color: #666666; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="box-sizing: border-box; margin: 0px; padding: 0px;">1.3</strong>如果您在18周岁以下，您只能在父母或监护人的监护参与下才能使用本站。
					</p>
					<p
						style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: justify; white-space: normal; color: #666666; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="box-sizing: border-box; margin: 0px; padding: 0px;">1.4</strong>云EC保留在中华人民共和国大陆地区法施行之法律允许的范围内独自决定拒绝服务、关闭用户账户、清除或编辑内容或取消订单的权利。
					</p>
					<h5
						style="box-sizing: border-box; margin: 10px 0px; padding: 0px; font-weight: normal; font-size: 14px; color: #333333; text-align: justify; white-space: normal; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; line-height: 20px; background-color: #FFFFFF;">
						第2条 本站服务</h5>
					<p
						style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: justify; white-space: normal; color: #666666; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="box-sizing: border-box; margin: 0px; padding: 0px;">2.1</strong>云EC通过互联网依法为用户提供互联网信息等服务，用户在完全同意本协议及本站规定的情况下，方有权使用本站的相关服务。
					</p>
					<p
						style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: justify; white-space: normal; color: #666666; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="box-sizing: border-box; margin: 0px; padding: 0px;">2.2</strong>用户必须自行准备如下设备和承担如下开支：（1）上网设备，包括并不限于电脑或者其他上网终端、调制解调器及其他必备的上网装置；（2）上网开支，包括并不限于网络接入费、上网设备租用费、手机流量费等。
					</p>
					<h5
						style="box-sizing: border-box; margin: 10px 0px; padding: 0px; font-weight: normal; font-size: 14px; color: #333333; text-align: justify; white-space: normal; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; line-height: 20px; background-color: #FFFFFF;">
						第3条 用户信息</h5>
					<p
						style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: justify; white-space: normal; color: #666666; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="box-sizing: border-box; margin: 0px; padding: 0px;">3.1</strong>用户应自行诚信向本站提供注册资料，用户同意其提供的注册资料真实、准确、完整、合法有效，用户注册资料如有变动的，应及时更新其注册资料。如果用户提供的注册资料不合法、不真实、不准确、不详尽的，用户需承担因此引起的相应责任及后果，并且云EC保留终止用户使用云EC各项服务的权利。
					</p>
					<p
						style="box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: justify; white-space: normal; color: #666666; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; font-size: 14px; line-height: 20px; background-color: #FFFFFF;">
						<strong style="box-sizing: border-box; margin: 0px; padding: 0px;">3.2</strong>用户在本站进行浏览、下单购物等活动时，涉及用户真实姓名/名称、通信地址、联系电话、电子邮箱等隐私信息的，本站将予以严格保密，除非得到用户的授权或法律另有规定，本站不会向外界披露用户隐私信息。
					</p>
					</p>
					<div>
						<br />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="mask"></div>
	<script src="/view/default/js/jquery-1.9.1.min.js"
		type="text/javascript"></script>
	<script src="/view/default/js/main.js" type="text/javascript"></script>
	<script src="/view/default/js/users.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
		
		});
	</script>
	<p style="display: none;"></p>
</body>

</html>