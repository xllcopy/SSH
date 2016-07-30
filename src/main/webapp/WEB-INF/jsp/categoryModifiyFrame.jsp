<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file = "/public/head.jspf" %>
		<script type = text/javascript>
			$(function(){
				var dg = parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
				var rows = dg.datagrid('getSelections');
				if(rows[0].adminAccount != null){
					$('#adminAccount').val(rows[0].adminAccount.id);
				}
				$('input[name=type]').val(rows[0].type);
				if(rows[0].hot){
					$('input[name=hot]').get(0).checked = true;
				}else{
					$('input[name=hot]').get(1).checked = true;
				}
				$("input[name=categoryID]").val(rows[0].id);
				$("input[name=type]").validatebox({
					required:true,
					missingMessage:'请输入类别名称'
				});
				$("#modifiedForm").form("disableValidation");
				$("#adminAccount").combobox({
					  url:'../adminAccount/queryAllAdminAccount',  
	                  valueField:'id',    
	                  textField:'loginName', //我们下拉列表中显示的是管理员的登录名  
	                  panelHeight:'auto', //自适应高度  
	                  panelWidth:120,//下拉列表是两个组件组成的  
	                  width:120, //要同时设置两个宽度才行  
	                  editable:false //下拉框不允许编辑 
				});
				$("#btn").click(function(){
					$("#modifiedForm").form("enableValidation");
					//如果验证成功，则提交数据  
	                if($("#modifiedForm").form("validate")) {  
	                    //调用submit方法提交数据  
	                    $("#modifiedForm").form('submit', {
	                        url: 'updateCategory',
	                        success: function(result){
	                        	if(result == 'true'){
		                            //如果成功了，关闭当前窗口  
		                            $.messager.alert("操作提示" , "更新成功" , "info");
		                            parent.$("#categoryModifiedWin").window("close");
		                            dg.datagrid("uncheckAll");
		                            //刷新页面  
		                            dg.datagrid("reload"); 
	                        	}else{
	                        		$.messager.show({
	                        			title : '更新异常',
                        				msg:'更新记录异常，请检查！',
    	                                timeout:2000,  
    	                                showType:'slide', 
	                        		});
	                        	}
	                        }  
	                    });  
	                } 
				});	
			});
		</script>
	</head>
	<body>
		<form id="modifiedForm" method="post">     
	        <div>     
	            <label for="name">类别名称:</label> <input type="text" name="type" />     
	        </div>     
	        <div>     
	            <label for="hot">热点:</label>     
	               	 是<input type="radio" name="hot" value="true" />   
	               	 否<input type="radio" name="hot" value="false" />  
	        </div>    
	        <div>     
	            <label for="adminAccount">所属管理员:</label>  
	             <!-- 下拉列表我们采用远程加载的方法加载管理员数据 -->  
	             <input id="adminAccount" name="adminID" />
	        </div>  
	        <div>  
	            <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>    
	            <input type="hidden" name="categoryID" />
	        </div>  
    	</form>  	
	</body>
</html>