<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>QQ授权登录</title>
<link rel="stylesheet" href="/view/default/css/common.css" />
<link rel="stylesheet" href="/view/default/css/loginregister.css" />
<link rel="stylesheet" href="/view/default/css/valifrom.css" />
<style>
.form-box .input-box {
	overflow: hidden;
}
</style>
</head>

<body
	onkeypress="if(event.keyCode==13){document.getElementById('login').click();return false;}">
	<div class="ny-header">
		<div class="nb">
			<div class="logo">
				<a href="/index.html"><img src="view/default/images/logo.png"
					alt="" style="width: 200px; height: 60px" /></a>
			</div>
			<div class="right login-right">
				<span>您好！欢迎光临云EC电商系统 ！</span> <a href="/n-help.html">帮助中心</a>
			</div>
		</div>
	</div>
	<div class="nb">
		<div class="ny-body ny-zsy">
			<div class="left">
				<img src="/view/default/images/login-pic.jpg" alt="" />
			</div>
			<div class="right">
				<div class="form-box">

					<form action="qqRelation" method="post">
						<h3>电商系统QQ关联账户</h3>
						<div class="bind">
							<a href="register" class="blue">注册账号</a>
						</div>
						<div class="input-box input-box1 onfocusstyle user-word">
							<label for="loginname" class="icon-user"></label> <input
								type="text" name="username" id="loginname" value=""
								placeholder="用户名/手机号码" class="position-input" maxlength="20"
								datatype="*" autocomplete="off" />
							<div class="Validform_checktip formtip">
								<span class=""><i></i><label></label></span>
							</div>
						</div>
						<div class="input-box onfocusstyle passw-word">
							<label for="passw" class="icon-passw"></label> <input
								type="password" name="password" id="passw" value=""
								placeholder="密码" class="position-input" maxlength="20"
								datatype="*" autocomplete="off" />
							<div class="Validform_checktip formtip">
								<span class=""><i></i><label></label></span>
							</div>
						</div>
						<div class="input-box onfocusstyle yanm-div"
							style="display: none;">
							<label for="authcode" class="icon-passw"></label> <input
								type="text" maxlength="4" name="authcode" id="authcode" value=""
								placeholder="验证码" class="position-input" nullmsg="请输入验证码！"
								datatype="*" onclick="showvode();" /> <img id="mx"
								style="cursor: pointer;" src="" alt="看不清？点击更换另一个验证码" border="1"
								onClick="refreshimage(this)" title="看不清？点击更换另一个验证码">
							<div class="Validform_checktip formtip">
								<span class=""><i></i><label></label></span>
							</div>
						</div>
						<div class="check">
							<span class="mh-checkbox checkbox-stylemh"><input
								type="checkbox" id="autologin" value="1" class="zdlogin-btn"
								checked="checked" /></span>&nbsp;&nbsp;<label for="autologin">自动登录</label>
							<a href="findpwd.html" target="_blank">忘记密码？</a>
						</div>
						<div class="input-box sub-box">
							<input type="submit" id="login" value="登录" /> <#if error ?? > <span
								style="color: red; font-size: 18px;"> ${error} </span> </#if>
						</div>
					</form>
					
				</div>
			</div>
		</div>
		<div class="ny-footer">
			<div class="link">
				<a href="/" target="_blank">首页</a>| <a href="/n-help.html">关于我们</a>
				| <a href="/n-help.html">联系我们</a> | <a href="/timespike.html">限时抢购</a>
				| <a href="/user.html">会员中心</a> | <a href="/n-help.html">帮助中心</a>
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
	<script src="/view/default/js/jquery-1.9.1.min.js"
		type="text/javascript"></script>
	<script src="/view/default/js/main.js" type="text/javascript"></script>
	<script src="/view/default/js/users.js" type="text/javascript"></script>


	<script>
		$(function() {
			loadLayer();
		});
		var return_url = '';

		$(".hezuo li:last-child").css("margin-right", 0);
		$(".position-input").focus(function() {
			$(this).parent(".onfocusstyle").css({
				"border-color" : "#abcdef"
			}).siblings().css({
				"border-color" : "#dedede"
			});
		});
		$(".position-input").blur(function() {
			$(this).parent(".onfocusstyle").css({
				"border-color" : "#dedede"
			}).siblings().css({
				"border-color" : "#dedede"
			});
		});
		$(".mh-checkbox").on("click", function() {
			if ($(this).hasClass("checkbox-stylemh")) {
				$(this).removeClass("checkbox-stylemh");
				$(".zdlogin-btn").attr("checked", false);
			} else {
				$(this).addClass("checkbox-stylemh");
				$(".zdlogin-btn").attr("checked", true);
			}
		});
		if ((navigator.userAgent.indexOf('MSIE') >= 0 && navigator.userAgent
				.indexOf('MSIE 10') == -1)
				&& (navigator.userAgent.indexOf('Opera') < 0)) {
			var a = navigator.userAgent;
			$(".passw-word").append("<span>密码</span>");
			$(".user-word").append("<span>用户名</span>");
			$("#passw,#loginname").blur(function() {
				if ($("#passw").val() == "") {
					$(".passw-word").append("<span>密码</span>");
				}
			});
			$("#loginname")
					.blur(
							function() {
								$(".user-word")
										.append(
												$("#loginname").val() == "" ? "<span>用户名</span>"
														: "");
							});

			$("#passw").focus(function() {
				$(".passw-word span").remove();
			});
			$("#loginname").focus(function() {
				$(".user-word span").remove();
			});
		}

		function refreshimage(clickidimg) {
			clickidimg.src = '/vcode-M.html' + '?' + Date.parse(new Date());
		}
		function showvode() {
			document.getElementById('mx').style.display = 'block';
		}
		document.getElementById('mx').src = '/vcode-M.html' + '?'
				+ Date.parse(new Date());
		function refreshimage(clickidimg) {
			clickidimg.src = clickidimg.src + '?' + Date.parse(new Date());
		}
	</script>
	<p style="display: none;"></p>
</body>

</html>