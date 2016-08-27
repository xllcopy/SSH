<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file='/public/head.jspf' %>
		<link rel="stylesheet" href="${shop}/resources/css/payInfo.css" type="text/css"></link>
	</head>
	<body>
		<div class='index'>
			<span class='index_text'><a href='${shop}/index.jsp'>商城首页</a></span>
		</div>
		<div class='person-info-wrapper'>
			<div class='person-info-title'>
				<span>填写订购人信息</span>
			</div>
			<div class='person-infos'>
				<div class='person-info'>
					<label>配送姓名：</label>
					<input type='text' name='name' class='name'>
				</div>
				<div class='person-info'>
					<label>联系方式：</label>
					<input type='text' name='mobile' class='mobile'>
				</div>
				<div class='person-info'>
					<label>地区邮编：</label>
					<input type='text' name='postcode' class='postcode'>
				</div>
				<div class='person-info'>
					<label>配送地址：</label>
					<input type='text' name='address' class='address'>
				</div>
			</div>
		</div>
		<div class='order-submit-wrapper'>
			<a class='order-submit'>提交订单</a>
		</div>
		<input type='hidden' class='token' name='token' value='${sessionScope.token}'/>
		<script type="text/javascript">
			$(function(){
				$('.order-submit').click(function(){
					var name = $('.name').val();
					var mobile = $('.mobile').val();
					var postcode = $('.postcode').val();
					var address = $('.address').val();
					var token = $('.token').val();
					$.ajax({
						url:'orderSubmit',
						type:'POST',
						data:{
							'name':name,
							'mobile':mobile,
							'postcode':postcode,
							'address':address,
							'token':token
						},
						success : function(result) {
							if (result == "success") {
								 <!--ajax中进行跳转-->
								 window.location.href="showCart";
							}else{
								alert('请不要重复提交表单!');
							}		
						}
					});
				});
			})
		</script>
	</body>
</html>