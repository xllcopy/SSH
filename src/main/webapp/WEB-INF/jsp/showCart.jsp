<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
	<head>
		<meta http-equiv='pragma' content='no-cache'>
		<meta http-equiv='cache-control' content='no-cache'>
		<meta http-equiv='expires' content='0'>
		<%@ include file='/public/head.jspf' %>
		<link rel='stylesheet' href='${shop}/resources/css/cart.css' type='text/css'></link>
	</head>
	<body>
		<div class='index'>
			<span class='index_text'><a href='${shop}/index.jsp'>商城首页</a></span>
		</div>
		<div id='shopping_cart'>
			<div class='cart_title'>
				<img class='cart_img' src='../resources/images/message_cart.png'/>
				<span class='cart_text'>我的购物车</span>
			</div>
			<table class='data-table cart-table'>
				<tr>
					<th class='align_center'>商品编号</th>
					<th class='align_center'>商品名称</th>
					<th class='align_center'>销售价格</th>
					<th class='align_center'>数量</th>
					<th class='align_center'>小计</th>
					<th class='align_center'>删除</th>
				</tr>
				<c:forEach items='${sessionScope.order.goodsBuyInfos}' var='goodsBuyInfo' varStatus='num'>
					<tr>
						<td class='align_center'><span class='num'>${num.count}</span></td>
						<td class='align_center'><span class='product_name'>${goodsBuyInfo.name}</span></td>
						<td class='align_center'><span class='product_price'>${goodsBuyInfo.price}</span></td>
						<td class='align_center'>
							<div class='number_input'>
								<input type='text' class='product_number' value='${goodsBuyInfo.number}'/>
							</div>
						</td>
						<td class='align_center'><span class='product_amount_price'>￥${goodsBuyInfo.price  * goodsBuyInfo.number}</span></td>
						<td class='align_center'><a href='#' class='remove'><img src='../resources/images/remove.png'></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class='cart-total'>
			<div class='cart-total-price'>
				<span class='text-price'>总计：￥${sessionScope.order.total}</span>
			</div>
			<ul class='cart-total-tabs'>
				<li class='cart-square-accounts-tab'><a href='payInfoFrame'>结账</a></li>
				<li class='cart-total-tab'><a href='#'>继续购物</a></li>
				<li class='cart-total-tab'><a href='#'>清空购物车</a></li>
			</ul>
		</div>
	</body>
</html>