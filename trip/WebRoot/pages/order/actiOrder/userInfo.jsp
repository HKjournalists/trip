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
 <script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
 <script type="text/javascript" src="${otapp}/plug/upload/ajaxfileupload.js"></script>
 
</head>
<script>
		$(document).ready(function(){
			$('#tab').datagrid({
	 			title:'\u7528\u6237\u5206\u6790',
	 			height:340,
	 			url:"",
	 			method:"POST",
	 			queryParams:{},
	 			idFile:"ID",
	 			striped:true,
	 			fitColumns:true,
	 			singleSelect:false,
	 			rownumbers:true,
	 			pagination:false,
	 			nowrap:false,
	 			pageSize:10,
	 			pageList:[10,20,50,100],
	 			showFooter:true,
	 			//toolbar: "#tool",
	 			onClickRow:function(){alert("haja");},
	 			columns:[[
	 			          {filed:'userId',checkbox:true},
	 			          {filed:"userName",title:"\u7528\u6237\u540d",width:150,align:'left'},
	 			          {filed:"orders",title:"\u4e0b\u5355\u6b21\u6570",width:50,align:'left'},
	 			          {filed:"firstOrder",title:"\u9996\u6b21\u4e0b\u5355\u65f6\u95f4",width:50,align:'left'},
	 			          {filed:"lastOrder",title:"\u672b\u6b21\u4e0b\u5355\u65f6\u95f4",width:50,align:'left'},
	 			          {filed:"sumMoney",title:"\u7d2f\u8ba1\u6d88\u8d39",width:50,align:'left'},
	 			          {filed:"rate",title:"\u8ba2\u5355\u6298\u6263",width:50,align:'left'},
	 			          {filed:"sumScore",title:"\u7d2f\u8ba1\u79ef\u5206",width:50,align:'left'},
	 			          {filed:"destinate",title:"\u65c5\u884c\u76ee\u7684\u5730",width:150,align:'left'}
	 			          ]]
	 		});
				
		});



</script>


<body>

				

	
	<div id="tab" >
	</div>
</body>

</html>、
