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
 
</head>
<script>
	$(document).ready(function(){
		var flag=true;
		var sel=document.getElementById("cc");
		var sta=document.getElementById("dd");
		var pa={"state":sta.selectedIndex,"flag":sel.selectedIndex,"minDate":$('#minDate').val(),"maxDate":$('#maxDate').val(),"minNum":$('#minNum').val(),"maxNum":$('#maxNum').val(),"minPrice":$('#minPay').val(),"maxPrice":$("#maxPay").val()};
		//initGridData(sel.selectedIndex,pa);
		initData(sel.selectedIndex,pa);
		$('.to').text("\u5230");
		
	})
	
	function change(sel)
	{
		var sel=document.getElementById("cc");
		var sta=document.getElementById("dd");
		var pa={"state":sta.selectedIndex,"flag":sel.selectedIndex,"minDate":$('#minDate').val(),"maxDate":$('#maxDate').val(),"minNum":$('#minNum').val(),"maxNum":$('#maxNum').val(),"minPrice":$('#minPay').val(),"maxPrice":$("#maxPay").val()};
		initData(sel.selectedIndex,pa);
		
	}
	
	function postForm()
	{
		var sel=document.getElementById("cc");
		var sta=document.getElementById("dd");
		var pa={"state":sta.selectedIndex,"flag":sel.selectedIndex,"minDate":$('#minDate').val(),"maxDate":$('#maxDate').val(),"minNum":$('#minNum').val(),"maxNum":$('#maxNum').val(),"minPrice":$('#minPay').val(),"maxPrice":$("#maxPay").val()};
		initData(sel.selectedIndex,pa);	
	}
	
	
	function initData(num1,num2)
	{
		
		var url="${otapp}/order/getOrderAnalyseInitData.html?json=";
		$.post(url,{"sid":num1},function(data){
			$('#daNo').text(data.row4);
			$('#daNum').text(data.row1);
			$('#daPay').text(data.row3);
			loadGrid(data,num2);
		},'json');
		
	}
	
	
	
	
	function loadGrid(jdata,sta)
	{
		var url="${otapp}/order/getOrderQuery.html?json=";
		var str=eval(jdata);
		var row1=str.row1;
		$('#tab').datagrid({
			title:'',
			height:740,
			url:url,
			method:'POST',
			queryParams:sta,
			//idFile:'',
			striped:true,
			fitColumns:true,
			singleSelect:false,
			rownumbers:true,
			pagination:true,
			nowrap:false,
			pagesize:10,
			pageList:[10,20,50,100],
			showFooter:true,
			columns:[[
			          {field:'',checkbox:true},
			          {field:'no',title:str.row4,width:100,align:'left'},
			          {field:'count',title:str.row1,width:100,align:'left'},
			          {field:'states',title:str.row2,width:100,align:'left'},
			          {field:'sum',title:str.row3,width:100,align:'left'}
			          ]]
		});
	}
	
	
	
	
	
</script>
<style type="text/css">
	
</style>
<body>
		<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
        		<table>
        		<tr>
        		<td>
        			<select id="cc" class="" name="choose" onchange="change()" ><!-- 月，周 -->
        				<option value="a1"><spring:message code="common.manager.order.statistic.mouth"/></option>
        				<option value="a2"><spring:message code="common.manager.order.statistic.week"/></option>
        			</select>
        		</td>
        		<td>
        			<select id="dd" name="choose" onchange="change()"><!-- 已付款，未付款 -->
        				<option value="b1"><spring:message code="common.manager.order.statistic.allpayed"></spring:message></option>
        				<option value="b2"><spring:message code="common.manager.order.statistic.payed"></spring:message></option>
        				<option value="b3"><spring:message code="common.manager.order.statistic.notpayed"></spring:message></option>
        			</select>
        		</td>
        		</tr>
        		
        		<form id="form1">
        		<input type="hidden" id="paramDate"/>
        		<input type="hidden" id="paramPay"/>
        		<tr>
        		<td>
        			<span id="daNo"></span>
        		</td>
        		<td>
        				<input id="minDate" class="easyui-numberspinner" type="text" data-options="min:1,max:100,editable:true" style="width:60px;" />
        		</td>
        		<td><span class="to"></span></td>
        		<td>
        				<input id="maxDate" class="easyui-numberspinner" type="text" data-options="min:1,max:100,editable:true" style="width:60px;" />
        		</td>
        		
        		<td>
        			<span id="daNum"></span>
        		</td>
        		<td>
        				<input id="minNum" class="easyui-numberspinner" type="text" data-options="min:1,editable:true" style="width:60px;"  />
        		</td>
        		<td><span class="to"></span></td>
        		<td>
        				<input id="maxNum" class="easyui-numberspinner" type="text" data-options="min:1,max:100,editable:true" style="width:60px;" />
        		</td>
        		
        		
        		<td>
        			<span id="daPay"></span>
        		</td>
        		<td>
        				<input id="minPay" class="easyui-numberspinner" type="text" data-options="min:1,editable:true,precision:2" style="width:120px;" onchange="change()" />
        		</td>
        		<td><span class="to"></span></td>
        		<td>
        				<input id="maxPay" class="easyui-numberspinner" type="text" data-options="min:1,editable:true,precision:2" style="width:120px;" onchange="change()" />
        		</td>
        		<td>
        			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="postForm()"><spring:message code="common.button.add.submit" /></a>
        		</td>	
        	</tr>
        	</form>
        		</table>
        				<div id='tab'>
        				</div>
        		</div>
		</div>
	</div>
</body>
</html>