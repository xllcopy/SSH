<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
    <%@ include file="/public/head.jspf" %>  
    <style type="text/css">  
        #menu {  
            width:200px;  
            /*border:1px solid red;*/  
        }  
        #menu ul {  
            list-style: none;  
            padding: 0px;  
            margin: 0px;  
        }  
        #menu ul li {  
            border-bottom: 1px solid #fff;  
              
        }  
        #menu ul li a {  
            /*先将a标签转换为块级元素，才能设置宽和内间距*/  
            display: block;  
            background-color: #00a6ac;  
            color: #fff;  
            padding: 5px;  
            text-decoration: none;  
        }  
        #menu ul li a:hover {  
            background-color: #008792;  
        }  
          
    </style>  
  </head>  
    
  <body>  
    <div id="menu">     
        <ul>  
            <li><a href="#">类别管理</a>  
            <li><a href="#">商品管理</a>  
        </ul>  
    </div>  
  </body>  
</html>