<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file='/public/head.jspf'%>
		<style>
			div {
				margin:5px;
			}
		</style>
		
		<script type='text/javascript'>
			$(function(){
				$('#loginName').validatebox({
					required:true,
					missingMessage:'请输入登录名'
				});
				$('#loginName').validatebox('disableValidation');
				$('#pwd').validatebox({
					required:true,
					missingMessage:'请输入密码'
				});
				$('#pwd').validatebox('disableValidation');
				$('#btn').click(function(){
					$('#loginName').validatebox('enableValidation');
					$('#pwd').validatebox('enableValidation');
					if($('#loginName').validatebox('validate') && $('#pwd').validatebox('validate')){
						var loginName = $('#loginName').val();
						var name = $('#name').val();
						var pwd = $('#pwd').val();
						$.ajax({
							type:'POST',
							url:'save',
							contentType:'application/json',
							dataType:'json',
							data:JSON.stringify({
				                'loginName' : loginName,
				                'name' : name,
				                'pwd' : pwd
				            }),
							success:function(result){
								if(result){
				                	//如果成功了，关闭当前窗口  
		                            parent.$("#adminAddWin").window("close");
		                            //刷新页面，刚刚添加的就显示出来了。  
		                            //获取aindex-->iframe-->datagrid 
		                            parent.$("iframe[title='管理员管理']").get(0).contentWindow.$("#dg").datagrid("reload");
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
			<label>登录名:&nbsp;</label><input type='text' id='loginName' name='loginName'/>
		</div>
		<div>
			<label>真实姓名:</label><input type='text' id='name' name='name'/>
		</div>
		<div>
			<label>密码:&nbsp;&nbsp;</label><input type='password' id='pwd' name='pwd'/>
		</div>
		<div>  
            <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>  
        </div> 	
	</body>
</html>