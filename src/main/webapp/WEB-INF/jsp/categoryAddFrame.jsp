<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/public/head.jspf"%>
		<style type="text/css"> 
		    form div {  
		        margin:5px;  
		    }  
		</style>
		<script type="text/javascript">
		$(function(){
			$("input[name=type]").validatebox({
				required:true,
				missingMessage:'请输入类别名称'
			});
			$("#admin").combobox({
				  url:'../adminAccount/queryAllAdminAccount',  
                  valueField:'id',     
                  textField:'loginName', //我们下拉列表中显示的是管理员的登录名  
                  panelHeight:'auto', //自适应高度  
                  panelWidth:120,//下拉列表是两个组件组成的  
                  width:120, //要同时设置两个宽度才行  
                  editable:false //下拉框不允许编辑 
			});
			$("#categoryAddForm").form("disableValidation");
			$("#btn").click(function(){
				$("#categoryAddForm").form("enableValidation");
				//如果验证成功，则提交数据  
                if($("#categoryAddForm").form("validate")) {  
                    //调用submit方法提交数据  
                    $("#categoryAddForm").form('submit', {
                        url: 'save',
                        success: function(){
                            //如果成功了，关闭当前窗口  
                            parent.$("#categoryAddWin").window("close");
                            //刷新页面，刚刚添加的就显示出来了。  
                            //获取aindex-->iframe-->datagrid 
                            parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");  
                        }  
                    });  
                } 
			});
		});
		</script>
	</head>
	<body>
		<form id="categoryAddForm" method="post">     
	        <div>     
	            <label for="name">商品名称:</label> <input type="text" name="type" />     
	        </div>     
            <div>  
                <label>所属管理员:</label>
                <!-- 后台传参是id : value (name的值为参数名)-->   
                <input id="admin" name="id"/>
            </div>  
	        <div>     
	            <label for="hot">热点:</label>     
				             是<input type="radio" name="hot" value="true" />   
				             否 <input type="radio" name="hot" value="false" />
	        </div>    
	        <div>  
	            <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>    
	        </div>    
	    </form>
	</body>
</html>