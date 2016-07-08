<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/public/head.jspf" %>
		<script type="text/javascript">
			$(function(){
				$('#dg').datagrid({
					url:'queryProducts',
					loadMsg:'Loading......',
					fitColumns : true,//水平自动展开，如果设置此属性，则不会有水平滚动条
					striped : true,//显示斑马线
					nowrap : true,//当数据多的时候不换行
					singleSelect : false,//如果为真，只允许单行显示，checkbox全选功能失效
					queryParams : {
						name : ''
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
					//同列属性，但是这些列将会冻结在左侧,大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内  
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
						field : 'productName',
						title : '商品名称',
						width : 100,
					}, 
					{
						field : 'productPrice',
						title : '商品价格',
						width : 100,
					},
					{
						field : 'productSimDesc',
						title : '简单描述',
						width : 100,
					} ,
					{
						field : 'productDeDesc',
						title : '详细描述',
						width : 100,
					} ,
					{
						field : 'productProduceDate',
						title : '上架时间',
						width : 100,
					} ,
					{field:'productDisplay',title:'推荐商品',width:100,    
                       formatter: function(value,row,index){  
                           if(value) {  
                               return "<input type='checkbox' checked='checked' disabled='true'";  
                           } else {  
                               return "<input type='checkbox' disabled='true'";  
                           }  
                        }  
                    },  
                    {field:'productIsValid',title:'有效商品',width:100,    
                        formatter: function(value,row,index){  
                            if(value) {  
                                return "<input type='checkbox' checked='checked' disabled='true'";  
                            } else {  
                                return "<input type='checkbox' disabled='true'";  
                            }  
                        }  
                    },  
                    {field:'category.type',title:'所属商品类别',width:200,  
                        formatter: function(value,row,index){  
                            if(row.category != null && row.category.type != null) {  
                                return row.category.type;
                            } else {  
                                return "此商品暂时未分类";  
                            }  
                         }    
                    },
	                {
                    	field:'productPicturePath',
                    	title : '商品图片路径',
						width : 100,
	                }
					]],
					
					toolbar: [{
			            text: '添加商品', 
			            iconCls: 'icon-add', 
			            handler: function() {
			            	parent.$("#productAddWin").window({
			                    title:"添加商品",  
			                    width:450,  
			                    height:400,  
			                    content:'<iframe src="../product/productAddFrame" frameborder="0" width="100%" height="100%"/>'  
			                }); 
			            } 
				        },'-',{
				        	text : '修改商品',
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
				        		parent.$('#productModifyWin').window({
					        			title : '修改商品', 
					        			width : 450,
					        			height : 400,
					        			 content:'<iframe src="../product/productModifyFrame" frameborder="0" width="100%" height="100%"/>'   
					        		});
				            	}
				        	}
				        },'-',{
				        	text : '删除商品',
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
				            				$.post("deleteProducts" , {ids:ids} , function(result){
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
				$('#dg').datagrid('hideColumn', 'productPicturePath');
			})
		</script>
	</head>
	<body>
		<table id = "dg"></table>
	</body>
</html>