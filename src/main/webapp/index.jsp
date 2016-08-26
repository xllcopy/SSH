<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
	<head> 
		<%@ include file = '/public/head.jspf' %>
		<link rel="stylesheet" href="${shop}/resources/css/index.css" type="text/css"></link> 
		<script type='text/javascript'>
			$(function(){
				if($('.mark').text() == ""){
					$('.mark').html("<a href='user/loginFrame'>欢迎，请登录!</a>");
				}
			})
		</script>
	</head>
	<body>
		<div>
			<a href='category/returnAindex'>后台管理</a>
			<span class='mark'>${sessionScope.user.loginName}</span>
		</div>
		
		<!-- 产品列表 -->
	    <c:forEach items='${applicationScope.productsList}' var='list'>
	     <div class='products_list products_slider clear'>
	     	<!-- 显示类别名称 -->
	         <h2 class='sub_title'>${list[0].category.type}</h2>
	         <ul id='first-carousel' class='first-and-second-carousel jcarousel-skin-tango'>
	             <c:forEach items='${list}' var='product'>
	              <li> 
	              	  <a href='#' class='product_image'><img src='${shop}${product.productPicturePath}' /></a>
	                  <div class='product_info'>
	                      <h3><a href='#'>商品名称：${product.productName }</a></h3>
	                      <small>简单描述：${product.productSimDesc}</small> 
	                  </div>
	                  <div class='price_info'>
	                      <a href='${shop}/cart/addProduct?id=${product.id}'>
	                      	<span class='product_add_into_cart'>添加购物车</span>
	                      </a>
	                      <span class='product_price'>￥${product.productPrice}</span>
	                  </div>
	                  <input type='hidden' name='id' value='${product.id}'/>
	              </li>
	             </c:forEach>
	         </ul>
	     </div>
	    </c:forEach>  
        <!--产品列表结束  -->
	</body>
</html>