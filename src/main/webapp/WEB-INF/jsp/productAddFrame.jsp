<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/public/head.jspf" %>
		<style type="text/css"> 
		    div {  
		        margin:5px;  
		    }  
		</style>
		<script type="text/javascript">
			$(function(){
				$("#productName").validatebox({
					required:true,
					missingMessage:'请输入商品名称'
				});
				$("#productName").validatebox('disableValidation');
				$("#productPrice").validatebox({
					required:true,
					missingMessage:'请输入商品价格'
				});
				$("#productPrice").validatebox('disableValidation');
				$("input[name=uploadProductPicture]").validatebox({
					required:true,
					missingMessage:'选择图片上传'
				});
				$("#uploadProductPic").form("disableValidation");
				$('#category').combobox({
					url:'../category/queryAllCategories',
					valueField:'id',     
	                textField:'type', //我们下拉列表中显示的是管理员的登录名  
	                panelHeight:'auto', //自适应高度  
	                panelWidth:120,//下拉列表是两个组件组成的  
	                width:120, //要同时设置两个宽度才行  
	                editable:false //下拉框不允许编辑 
				});
				$('#upload_btn').click(function(){
					$("#uploadProductPic").form("enableValidation");
					if($("#uploadProductPic").form('validate')){
						//调用submit方法提交数据  
	                    $("#uploadProductPic").form('submit', {
	                        url: 'uploadProductPic',                
	                        success: function(result){
	                        	$('#productPicturePath').val(result);
	                        	$.messager.alert("操作提示" , "图片上传成功" , "info");
	                        }  
	                    }); 
					}
				});
				$('#btn').click(function(){
					$("#productName").validatebox('enableValidation');
					$("#productPrice").validatebox('enableValidation');
					if($("#productName").validatebox('validate') && $("#productPrice").validatebox('validate')){
						var productName = $('#productName').val();
						var productPrice = $('#productPrice').val();
						var productPicturePath = $('#productPicturePath').val();
						var productSimDesc = $('#productSimDesc').val();
						var productDeDesc = $('#productDeDesc').val();
						var productProduceDate = $('#productProduceDate').val();
						var productDisplay = $("input[name='productDisplay']:checked").val();
						var productIsValid = $("input[name='productIsValid']:checked").val();
						var categoryID = $('#category').combobox('getValue');
						$.ajax({
							type : 'POST',
				            url : 'save',
				            //必须加否则报415错误
				            contentType : 'application/json',
				            dataType : 'json',
				            data : JSON.stringify({
				                'productName' : productName,
				                'productPrice' : productPrice,
				                'productPicturePath' : productPicturePath,
				                'productSimDesc' : productSimDesc,
				                'productDeDesc' :  productDeDesc,
				                'productProduceDate' : productProduceDate,
				                'productDisplay' : productDisplay,
				                'productIsValid' : productIsValid,
				                'category' : {'id' : categoryID}
				            }),
				            success : function(msg) {
				                if(msg){
				                	//如果成功了，关闭当前窗口  
		                            parent.$("#productAddWin").window("close");
		                            //刷新页面，刚刚添加的就显示出来了。  
		                            //获取aindex-->iframe-->datagrid 
		                            parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg").datagrid("reload");
				                }
				            }
						});
					}
				});
			})	
		</script>
	</head>
	<body>   
        <div>     
            <label>商品名称:</label> <input type="text" name="productName" id="productName"/>     
        </div>     
           <div> 
           	<!-- 后台传参是id : value (name的值为参数名)-->   
               <label>商品价格:</label> <input type="text" name="productPrice" id='productPrice'/>
           </div>
        <form id="uploadProductPic" enctype="multipart/form-data" method="post">
           <div> 
           	<!-- 后台传参是id : value (name的值为参数名)-->   
               <label>图片上传:</label> <input type="file" name="uploadProductPicture"/><input type="button" value="上传图片" id="upload_btn"/>
               <input type="hidden" name="productPicturePath" id="productPicturePath"> 
           </div>
        </form>
        <div>     
            <label>简单描述:</label>     
			<textarea rows="4" cols="25" id="productSimDesc"></textarea>  
        </div>
        <div>     
            <label>详细描述:</label>     
			<textarea rows="4" cols="25" id="productDeDesc"></textarea>
        </div>
        <div>     
            <label>上架时间:</label>     
			<input type="text" name='productProduceDate' id='productProduceDate' readonly="readonly"/>
        </div>
        <div>
        	<label for="productDisplay">推荐商品:</label>     
			             是<input type="radio" name="productDisplay" value="true" checked="checked"/>   
			             否 <input type="radio" name="productDisplay" value="false" />
        </div>
         <div>
        	<label for="productIsValid">有效商品:</label>     
			             是<input type="radio" name="productIsValid" value="true" checked="checked"/>   
			             否 <input type="radio" name="productIsValid" value="false" />
        </div>
        <div>  
               <label>所属类别:</label>
               <!-- 后台传参是id : value (name的值为参数名)-->   
               <input id="category" name="id"/>
        </div>
        <div>  
            <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>  
        </div>    
	</body>
</html>