<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<script type="text/javascript">
	$(function() {
		$('#dg').datagrid({
			url:"queryJoinAdminAccount",
			loadMsg : 'Loading......',
			fitColumns : true,//水平自动展开，如果设置此属性，则不会有水平滚动条
			striped : true,//显示斑马线
			nowrap : true,//当数据多的时候不换行
			singleSelect : false,//如果为真，只允许单行显示，checkbox全选功能失效
			queryParams : {
				type : ''
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
			//配置datagrid的列字段 
			//field：列字段的名称，与json的key捆绑  
			//title：列标题，是显示给人看的  
			columns : [[ 
			{
				field : 'type',
				title : '类别名称',
				width : 100,
				//用来格式化当前列的值，返回的是最终的数据  
				formatter : function(value, row, index) {
					return "<span title=" +　value + ">" + value + "</span>";
				}
			}, 
			{
				field : 'adminAccount.loginName',
				title : '所属管理员',
				width : 100,
				 formatter: function(value,row,index){  
                     if(row.adminAccount != null && row.adminAccount.loginName != null) {  
                         return row.adminAccount.loginName; //如果登录名不为空，显示登录名  
                     } else {  
                         return "此类别没有管理员";  
                     }  
             	}     
			},
			{
				field : 'hot',
				title : '热卖',
				width : 100,
				formatter: function(value,row,index){  
                    if(value == 1) { 
                    	//如果是hot，该值为true，value是boolean型变量  
                        return "<input type='checkbox' checked='checked' disabled='true'"; //勾选  
                    } else {  
                        return "<input type='checkbox' disabled='true'"; //不勾选  
                    }  
                } 
			} 
			]],
			toolbar: [{
	            text: '添加类别', 
	            iconCls: 'icon-add', 
	            handler: function() {
	            	parent.$("#categoryAddWin").window({
	                    title:"添加类别",  
	                    width:400,  
	                    height:150,  
	                    content:'<iframe src="addFrame" frameborder="0" width="100%" height="100%"/>'  
	                }); 
	            } 
	        }, '-', { 
	            text: '修改类别', 
	            iconCls: 'icon-edit', 
	            handler: function() {
	            	var rows = $('#dg').datagrid('getSelections')
	            	if(rows.length == 0 || rows.length > 1){
	            		$.messager.show({
	            			title:'错误提示',
	            			msg:'必须只能选择一行数据进行修改',
	            			timeout:2000,
	            			showType:'slide'
	            		});
	            	}else{
	            		parent.$("#categoryModifiedWin").window({
		                    title:"修改类别",  
		                    width:400,  
		                    height:150,  
		                    content:'<iframe src="modifiedFrame" frameborder="0" width="100%" height="100%"/>'  
		                });
	            	}
	            } 
	        }, '-',{ 
	            text: '删除类别', 
	            iconCls: 'icon-remove', 
	            handler: function(){
	            	var rows = $('#dg').datagrid('getSelections')
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
	            				$.post("deleteCategory" , {ids:ids} , function(result){
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
	        } ,'-',{
	        	text:"<input id='categorySearch' name='serach' />"
	        }]
		});
	  	$('#categorySearch').searchbox({
        	searcher:function(value , name){
        		//load从第一页刷新 , reload刷新当前页
      			$('#dg').datagrid('load',{  
      	            type: value  
      	    	}); 
        	},
        	prompt:'搜索关键字'
        });
	});
</script>
</head>
<body>
	<table id="dg"></table>
</body>
</html>