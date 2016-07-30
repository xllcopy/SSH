<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file='/public/head.jspf' %>
		<style type="text/css">
			div {
				margin:5px;
			}
		</style>
		
		<script type="text/javascript">
			$(function(){
				var dg = parent.$("iframe[title='管理员管理']").get(0).contentWindow.$("#dg");
				var rows = dg.datagrid('getSelections');
				$('#id').val(rows[0].id);
				$('#loginName').val(rows[0].loginName);
				$('#name').val(rows[0].name);
				$('#npwd').validatebox({
					required:true,
					missingMessage:'请输入新密码'
				});
				$('#npwd').validatebox('disableValidation');
				$('#cpwd').validatebox({
					required:true,
					missingMessage:'请确认密码'
				});
				$('#cpwd').validatebox('disableValidation');
				$('#btn').click(function(){
					$('#npwd').validatebox('enableValidation');
					$('#cpwd').validatebox('enableValidation');
					if($('#npwd').validatebox('validate') && $('#cpwd').validatebox('validate')){
						if($('#npwd').val() != $('#cpwd').val()){
							$('#hint').text('密码输入不一致,请重新输入!').css({'font-size':'12px','color':'red'});
						}else{
							$.ajax({
								url:'updateAdminAccount',
								type:'POST',
								contentType:'application/json',
								dataType:'json',
								data:JSON.stringify({
									'id' : $('#id').val(),
					                'loginName' : $('#loginName').val(),
					                'name' : $('#name').val(),
					                'pwd' : $('#npwd').val()
					            }),
					            success: function(result){
				   	            	if(result){
					   	                 //如果成功了，关闭当前窗口  
					   	                 $.messager.alert("操作提示" , "更新成功" , "info");
					   	                 parent.$("#adminModifyWin").window("close");
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
					   	            		parent.$("#adminModifyWin").window("close");
						   	                dg.datagrid("uncheckAll");
					   	            	}
					   	            }
							});
						}
					}
				});
			})
		</script>
	
	</head>
	<body>
		<div>
			<input type='hidden' id='id' name='id'/>
		</div>
		<div>
			<label>登录名:&nbsp;</label><input type='text' id='loginName' name='loginName'/>
		</div>
		<div>
			<label>真实姓名:</label><input type='text' id='name' name='name'/>
		</div>
		<div>
			<label>新密码:&nbsp;</label><input type='password' id='npwd' name='npwd'/>
		</div>
		<div>
			<label>确认密码:</label><input type='password' id='cpwd' name='cpwd'/>
		</div>
		<div>  
            <a id='btn' href='#' class='easyui-linkbutton' data-options="iconCls:'icon-edit'">修改</a>  
        </div> 
        <div>
			<span id='hint'></span>
		</div>
	</body>
</html>