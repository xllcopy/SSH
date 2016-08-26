<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file='/public/head.jspf' %>
	<link rel="stylesheet" type="text/css" href="../resources/css/login.css" />
</head>
<body>
	<div class="login">
		<div class="login-title">登录界面</div>
		<div class="login-main">
			<label>用户名:</label><input class="uname" type="text" /><br /> <label>密码:</label><input
				class="pwd" type="text" /><br /> <input type="button"
				class="loginButton" value="登录" />
		</div>
	</div>
	<div class="hint"></div>
	<script type="text/javascript">
		$(function(){
			$(".loginButton").click(
				function() {
					var loginName = $('.uname').val();
					var password = $('.pwd').val();
					$.ajax({
						type : "POST",
						url : "/SSH/user/login",
						data : {
							'loginName':loginName,
							'password':password
						},
						success : function(result) {
							if (result == "success") {
								 <!--ajax中进行跳转-->
								 window.location.href="../index.jsp";
							} else {
								$(".hint").html(result);
								$(".hint").css("boder" , "solid 1px red");
							}
						}
					});
				}
			);
		})
	</script>
</body>
</html>