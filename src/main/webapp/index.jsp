<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head> 
		<%@ include file = '/public/head.jspf' %>
	</head>
	<body>
		<a href='category/returnAindex'>后台管理</a>
		<!-- 产品列表 -->
	    <c:forEach items="${applicationScope.productsList}" var="list">
	     <div class="products_list products_slider clear">
	     	<!-- 显示类别名称 -->
	         <h2 class="sub_title">${list[0].category.type}</h2>
	         <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
	             <c:forEach items="${list}" var="product">
	              <li> 
	              	<a href="#" class="product_image"><img src="${shop}${product.productPicturePath}" /></a>
	                  <div class="product_info">
	                      <h3><a href="#">商品名称：${product.productName }</a></h3>
	                      <small>简单描述：${product.productSimDesc}</small> </div>
	                  <div class="price_info"> 
	                      <a href="#"><button><span class="product_add">添加购物车</span></button></a>
	                      <button class="price_add" title="" type="button">
	                      	<span class="product_price">￥${product.productPrice}</span>
	                      </button>
	                  </div>
	              </li>
	             </c:forEach>
	         </ul>
	     </div>
	    </c:forEach>  
        <!--产品列表结束  -->
	</body>
</html>