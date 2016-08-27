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
					$('.mark').text("请登录!");
					$('.mark').attr('href' , 'user/loginFrame')
				}
			})
		</script>
	</head>
	<body>
		<div>
			<a href='category/returnAindex'>后台管理</a>
			<a class='mark' href='#'>${sessionScope.user.loginName}</a>
			<span class='welcome'>欢迎，</span>
		</div>
		
	    <c:forEach items='${applicationScope.productsList}' var='list'>
	     <div class='products-list'>
	         <h2 class='sub-title'>${list[0].category.type}</h2>
	         <ul class='product-list-wrapper'>
	             <c:forEach items='${list}' var='product'>
	              <li class='product-list'> 
	              	  <a href='#' class='product-image'><img src='${shop}${product.productPicturePath}'/></a>
	                  <div class='product-info'>
	                      <h3><a href='#'>商品名称：${product.productName }</a></h3>
	                      <small>简单描述：${product.productSimDesc}</small> 
	                  </div>
	                  <div class='price-info'>
	                      <a href='${shop}/cart/addProduct?id=${product.id}'>
	                      	<span class='product-add-into-cart'>添加购物车</span>
	                      </a>
	                      <span class='product-price'>￥${product.productPrice}</span>
	                  </div>
	                  <input type='hidden' name='id' value='${product.id}'/>
	              </li>
	             </c:forEach>
	             <li class='clear'></li>
	         </ul>
	     </div>
	    </c:forEach>  
	</body>
</html>