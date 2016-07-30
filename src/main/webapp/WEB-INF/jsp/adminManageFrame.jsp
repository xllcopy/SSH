<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/public/head.jspf" %>
		<style>
		
		</style>
		<script type="text/javascript">
			$(function(){
				$('#dg').datagrid({
					url:'queryAdminAccounts',
					loadMsg:'Loading......',
					fitColumns : true,//水平自动展开，如果设置此属性，则不会有水平滚动条
					striped : true,//显示斑马线
					nowrap : true,//当数据多的时候不换行
					singleSelect : false,//如果为真，只允许单行显示，checkbox全选功能失效
					queryParams : {
						loginName : ''
					},
					pagination : true,//设置分页
					pageSize: 5, //页容量，必须和pageList对应起来，否则会报错  
		            pageList: [5, 10, 15],//分页中下拉选项的数值
					rowStyler : function(index, row) {
						if (index % 2 == 0) {
							return 'background-color:#fff;';
						} else {
							return 'background-color:#ff0;';
						}
					},
					frozenColumns : [[ {
						field : 'checkbox',
						checkbox : true
					}, {
						field : 'id',
						title : '编号',
						width : 200
					} ]],
					
					columns : [[
						{
							field : 'loginName',
							title : '登录名',
							width : 100,
						},
						{
							field : 'name',
							title : '管理员名',
							width : 100,
						},
						{
							field : 'pwd',
							title : '登录密码',
							width : 100,
						}
					]],
					toolbar: [{
				            text: '添加管理员', 
				            iconCls: 'icon-add', 
				            handler: function() {
				            	parent.$("#adminAddWin").window({
				                    title:"添加管理员",  
				                    width:280,  
				                    height:210,  
				                    content:'<iframe src="../adminAccount/adminAddFrame" frameborder="0" width="100%" height="100%"/>' 
				                }); 
				            }
						},'-',{
				        	text : '修改密码',
				        	iconCls : 'icon-edit',
				        	handler : function(){
				        		var rows = $('#dg').datagrid('getSelections')
				            	if(rows.length == 0 || rows.length > 1){
				            		$.messager.show({
				            			title:'错误提示',
				            			msg:'必须只能选择一行数据进行修改',
				            			timeout:2000,
				            			showType:'slide'
				            		});
				            	}else{
				        		parent.$('#adminModifyWin').window({
					        			title : '修改密码',
					        			width : 300,
					        			height : 246,
					        			 content:'<iframe src="../adminAccount/adminModifyFrame" frameborder="0" width="100%" height="100%"/>'   
					        		});
				            	}
				        	}
				        },'-',{
				        	text : '删除管理员',
				        	iconCls : 'icon-remove',
				        	handler : function(){
				        		var rows = $('#dg').datagrid('getSelections');
				        		if(rows.length == 0){
				            		$.messager.show({ 
			                            title:'错误提示',  
			                            msg:'至少要选择一条记录',  
			                            timeout:2000,  
			                            showType:'slide'  
			                        });
				            	}else{
				            		$.messager.confirm('删除确认' , '您确定要删除此项吗？' , function(isDelete){
				            			if(isDelete){
				            				var ids = "";
				            				for(var i = 0 ; i < rows.length ; i++){
				            					ids += rows[i].id + ",";
				            				}
				            				ids = ids.substr(0, ids.lastIndexOf(","));
				            				$.post("deleteAdminAccounts" , {ids:ids} , function(result){
				            					if(result == "true"){
				            						$("#dg").datagrid("uncheckAll");
				            						$.messager.alert("操作提示", " 删除成功！","info");
				            						$("#dg").datagrid("reload");
				            						
				            					}else{
				    	            				$.messager.show({ 
				    	                                title:'删除异常',  
				    	                                msg:'删除记录失败，请检查！',  
				    	                                timeout:2000,  
				    	                                showType:'slide',  
				    	                            });
				    	            			}
				            				} , "text");
				            			}
				            		});
				            	}
				        	}
				        }
			       ]
				});
			})
		</script>
	</head>
	<body>
		<table id='dg'></table>
	</body>
</html>