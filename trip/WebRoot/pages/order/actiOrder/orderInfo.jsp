<%@include file="../../general/header.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
  <link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
  <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/demo.css " />
  <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/dlg.css " />
   <script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.min.js"></script>
  <script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.form.js"></script>
  <link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
 <link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
 <script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/datagrid-filter.js"></script>
 <script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
 <script type="text/javascript" src="${otapp}/plug/upload/ajaxfileupload.js"></script>
 
 <script type="text/javascript">
 	$(document).ready(function(){
 		
 		//$.post("${otapp}/order/getOrderInfo.html?json=",{"page":"0","num":"10"},function(){},'json');
 		
 		
 		$('#tab').datagrid({
 			title:'\u8ba2\u5355\u4fe1\u606f',
 			height:840,
 			url:"${otapp}/order/getOrderInfo.html?json=",
 			method:"POST",
 			//queryParams:{},
 			//idFile:"ID",
 			striped:true,
 			singleSelect: true,
 			fitColumns:true,
 			singleSelect:false,
 			rownumbers:true,
 			pagination:true,
 			nowrap:false,
 			pageSize:10,
 			pageList:[10,20,50,100],
 			showFooter:true,
 			//toolbar: "#tool",
 			//remoteSort:false,
 			columns:[[
 			  
 			          {field:"actiNo",title:"\u6d3b\u52a8\u7f16\u53f7",width:150,align:'left'},
 			          {field:"orderState",title:"\u8ba2\u5355\u72b6\u6001",width:50,align:'left'},
 			          {field:"orderCreateTime",title:"\u8ba2\u5355\u65f6\u95f4",width:150,align:'left'},
 			          {field:"orderMoney",title:"\u8ba2\u5355\u91d1\u989d",width:50,align:'left'},
 			          {field:"orderPrice",title:"\u8ba2\u5355\u62a5\u4ef7",width:50,align:'left',sortable:true},
 			          {field:"orderRate",title:"\u8ba2\u5355\u6298\u6263",width:50,align:'left'},
 			          {field:"pepoleNum",title:"\u8ba2\u5355\u4eba\u6570",width:50,align:'left'},
 			          {field:"supplyNo",title:"\u4f9b\u5e94\u5546\u7f16\u53f7",width:150,align:'left'}
 			          ]]
 		});
 		var dg=$('#tab');
 		dg.datagrid();
 		dg.datagrid('enableFilter',[{field:'orderState',
 									type:'combobox',
 									options:{panelHeight:'auto',
 											 data:[{value:'a0',text:'\u5168\u90e8'},
 									               {value:'a1',text:'\u672a\u4ed8\u6b3e'},
 									               {value:'a2',text:'\u5df2\u4ed8\u6b3e'}],
 									         onChange:function(value){
 									        
 									        	 console.info(value);
 									        	 if(value=='a0')
 									        		 {
 									        			
 									        		 	dg.datagrid('removeFilterRule','orderState');
 									        		 }
 									        	 else if(value=='a1')
 									        		 {
 									        		
 									        		 	dg.datagrid('addFilterRule',{field:'orderState',op:'equal',value:'\u672a\u4ed8\u6b3e'});
 									        		 }
 									        	 else if(value=='a2')
 									        		 {
 									        		
 									        		 	dg.datagrid('addFilterRule',{field:'orderState',op:'equal',value:'\u5df2\u4ed8\u6b3e'});
 									        		 }
 									        	 
 									        	 dg.datagrid('doFilter');
 									         }
 											}
 		},{
 			field:'orderMoney',type:'numberbox',options:{precision:2},op:['equal','notequal','less','greater']
 		}
 		,{
 			field:'orderPrice',type:'numberbox',options:{precision:2},op:['equal','notequal','less','greater']
 		},{
 			field:'pepoleNum',type:'numberbox',options:{precision:2},op:['equal','notequal','less','greater']
 		}]);
 		dg.datagrid('addFilterRule',{field:'actiNo',op:'contains',value:''})
 		
 	})
 	
 	var data="[{'orderId':'12','orderId':'54','orderState':'52','orderCreateTime':'54','orderMoney':'12','orderRate':'43','peopleNum':'23','supplyNo':'12'}]";
 </script>
 
  <style type="text/css">
        input{ border:none; border-bottom:1px solid black;}
    </style>
  </head>
  
  
  <body>
  <div class="rightinfo">
  
  
  		
		<div id="tt" class="easyui-tabs" style="width:90%;font-weight: bold;height:auto;">
			<div title="<spring:message code="common.manager.order.infoList" />" style="padding:10px">
  			
  			
  		
  			
  			
  		<div id="tab">

  		</div>
  		</div>
  		
  		<div title="<spring:message code="common.manager.order.infoAnalyse" />" style="padding:10px">
				<iframe id="coverId" src="${otapp}/order/orderAnalyse.html?1=1" width="100%" height="600px" frameborder="0"  border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  ></iframe>
			</div>
			<div title="<spring:message code="common.manager.order.userAnalyse"/>" style="padding:10px">
				<iframe id="days" src="${otapp}/order/listUserInfo.html" width="100%" height="600px" frameborder="0"  border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  ></iframe>
			</div>
			
			<div title="<spring:message code="common.manager.order.userActivity"/>" style="padding:4px">
				<iframe id="Actiprice"  src="${otapp}/order/userInfoAnalyse.html" width="100%" height="650px" frameborder="0"  border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  >
				</iframe>
			</div>
			
			
			
		</div>
	</div>
  </body>
 </html>