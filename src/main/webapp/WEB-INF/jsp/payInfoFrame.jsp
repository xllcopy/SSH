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
					<input type='text' name='name'>
				</div>
				<div class='person-info'>
					<label>联系方式：</label>
					<input type='text' name='mobile'>
				</div>
				<div class='person-info'>
					<label>地区邮编：</label>
					<input type='text' name='postcode'>
				</div>
				<div class='person-info'>
					<label>配送地址：</label>
					<input type='text' name='address'>
				</div>
			</div>
		</div>
		<div class='order-submit-wrapper'>
			<a class='order-submit'>提交订单</a>
		</div>
	</body>
</html>