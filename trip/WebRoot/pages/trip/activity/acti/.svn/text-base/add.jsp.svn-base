 <%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.validatebox.js" ></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>

<script language="javascript" type="text/javascript" src="${otapp}/plug/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	var msg1="\u8f93\u5165\u5185\u5bb9\u9650\u5236\u5728";//输入内容限制在
	var msg2="\u4ee5\u5185";//以内
	var equ1="\u591a\u4e2a\u88c5\u5907\u7528";//装备清单用
	var equ2="\u4f8b\u5982"//例如
	var equ3="\u5206\u9694"//分隔
	var list1="\u76f8\u673a";var list2="\u80cc\u5305";var list3="\u671b\u8fdc\u955c";
	
	$('#lineRoad').attr("placeholder",msg1+500+msg2);
	$('#RefundNotes').attr("placeholder",msg1+225+msg2);
	$('#Prompt').attr("placeholder",msg1+225+msg2);
	$('#CostNotes').attr("placeholder",msg1+225+msg2);
	$('#EquipList').attr("placeholder",msg1+225+msg2+"  "+equ1+"\'-\'"+equ3+". "+equ2+":"+list1+"-"+list2+"-"+list3);
	
	
	var statusCode="${operatorStateCode}";
	if(statusCode!=null&&"success"==statusCode){
		alert('<spring:message code="common.operator.message.code.add.success" />');
		location.replace("${otapp}/trip/activity/acti/manager.html");
	}
});


function calc(str,event,total)
{
	var tal=Number(total);
	 var msg3="\u5b57"//字
	 var msg4="\u8fd8\u5269\u4f59";//还剩余
	 var len=Number($(str).val().length);
	 $(str+'msg').html("<font color='red'>"+msg4+(tal-len)+msg3+"</font>");
}

/**
 * @see 获取编号
 */
function getLineNo(){
	$.post('${otapp}/trip/activity/acti/get_trip_line_no.html?json',{"getNo":'getNo'},function(data, textStatus){  
    	if(data!=null&&data!=""){
    		var tripno=JSON.stringify(data.tripno);
    		$("#tripno").textbox('setValue',tripno.substring(1, tripno.length - 1));
		}
	},"json");
	
}

/**
 * @see 景区国家
 */
function getDestination(namelab,pobj){
	if(namelab=="fsDestinationCountry")
	{
		$("#fsDestinationScenic").empty();
		$("#fsDestinationScenic").prepend("<option value='0'>\u8bf7\u9009\u62e9</option>");
	}
	if(pobj!=null&&pobj.value!=''){
	    $.post('${otapp}/trip/activity/acti/getDestinationOpt.html?json',{"parentId":pobj.value},function(data, textStatus){  
	    	if(data!=null&&data!=""){
	    		var str = eval(data); 
				$("#"+namelab+"").empty();
				
				$("#"+namelab+"").prepend("<option value='0'>\u8bf7\u9009\u62e9</option>");
				$.each(str, function() { 
					$("#"+namelab+" option[value='"+this.value+"']").remove();
					$("#"+namelab).append("<option value='"+this.value+"'> "+this.name+"</option>");
				 });  
			}
	    	
		},"json");
		
	}
}

/**
 * @see æäº¤æ°æ®
 */
function submitForm(){
	if(validate())
		//; 
	{
		$("#addForm").submit();
	}
		
	else
		{
		
			return false;	
		}
		
}

function resetForm(){
	$("#addForm").reset(); 
}


/**
 * 验证
 */
 function validate()
 {
	//输入框
	//var no=document.getElementById("tripno").value;
	var no=$("#tripno").val();	
	var title=document.getElementById("title").value;
	var distance=document.getElementById("distance").value;
	var day=document.getElementById("day").value;
	var fdUpperTime=document.getElementById("fdUpperTime").value;
	var fdUnderTime=document.getElementById("fdUnderTime").value;
	var costNotes=document.getElementById("costNotes").value;
	var refundNotes=document.getElementById("refundNotes").value;
	var equip=document.getElementById("equip").value;
	//选择框
	var continent=document.getElementById("fsDestinationContinent").value; //Continen
	var country=document.getElementById("fsDestinationCountry").value;
	var scenic=document.getElementById("fsDestinationScenic").value;
	var type=document.getElementById("otActiTypeId").value;
	var desType=document.getElementById("otActiDestinationTypeId").value;
	var season=document.getElementById("fsSeason").value;
	var holiday=document.getElementById("fsHoliday").value;
	
	if(no=="")
	{
		alert("\u7f16\u53f7\u4e0d\u80fd\u4e3a\u7a7a");
		return false;
	}
	if(title=="")
	{
		alert("\u6807\u9898\u4e0d\u80fd\u4e3a\u7a7a");
		return false;
	}
	if(distance=="")
	{
		alert("\u8ddd\u79bb\u4e0d\u80fd\u4e3a\u7a7a");
		return false;
	}
	if(day=="")
	{
		alert("\u5929\u6570\u4e0d\u80fd\u4e3a\u7a7a");
		return false;
	}
	if(fdUpperTime=="")
	{
		alert("\u4e0a\u67b6\u65f6\u95f4\u4e0d\u80fd\u4e3a\u7a7a");
		return false;
	}
	if(fdUnderTime=="")
	{
		alert("\u4e0b\u67b6\u65f6\u95f4\u4e0d\u80fd\u4e3a\u7a7a");
		return false;
	}
	if(costNotes=="")
	{
		alert("\u8d39\u7528\u6e05\u5355\u4e0d\u80fd\u4e3a\u7a7a");
		return false;
	}
	if(refundNotes=="")
	{
		alert("\u8d39\u7528\u8bf4\u660e\u4e0d\u80fd\u4e3a\u7a7a");
		return false;
	}
	if(equip=="")
	{
		alert("\u88c5\u5907\u6e05\u5355\u4e0d\u80fd\u4e3a\u7a7a");
		return false;
	}
	//选择框验证
	if(continent=="0")
	{
		alert("\u8bf7\u9009\u62e9\u5dde");
		return false;
	}
	if(country=="0")
	{
		alert("\u8bf7\u9009\u62e9\u56fd\u5bb6");
		return false;
	}
	if(scenic=="0")
	{
		alert("\u8bf7\u9009\u62e9\u666f\u533a");
		return false;
	}
	if(type=="0")
	{
		alert("\u8bf7\u9009\u62e9\u6d3b\u52a8\u7c7b\u578b");
		return false;
	}
	if(desType=="0")
	{
		alert("\u8bf7\u9009\u62e9\u666f\u533a\u7c7b\u578b");
		return false;
	}
	if(season=="0")
	{
		alert("\u8bf7\u9009\u62e9\u5b63\u8282\u7c7b\u578b");
		return false;
	}
	if(holiday=="0")
	{
		alert("\u8bf7\u9009\u62e9\u8282\u5047\u65e5");
		return false;
	}
	return true;;
 }
 
 
 
 function checkNull(param)
 {
	 if(param=="")
		 {
		 	return true;
		 }
	 else
		 {
		 	return false;
		 }
 }
 
 function checkLength(param,len)
 {
	 if(param.length<=len)
 	{
		 return true;
 	}
	 else
	{
		 return false;
	}
 }
 
 
 function CheckDate(strDate)
 {
	 if(strDate.length>0)
		 {
		 	var patt1=/^\d{4}-\d{1,2}-\d{1,2}:\d{1,2}:\d{1,2}$/;
		 	alert(patt1.test(strDate));
		 	return patt1.test(strDate);
		 }
	 return null;
	 
 }
 function dateCompare(date1,date2)
 {
	 
 }
/**
 * 提示效果
 */

 
 
 
 
 
</script>
<body>
	<div class="place">
		<span><spring:message code="common.content.lab.position" /></span>
		<ul class="placeul">
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.modul" /></a></li>
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.travel.activity" /></a></li>
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.activity.public" /></a></li>
			<li><spring:message code="trip.manager.activity.public.add.title" /></li>
		</ul>
	</div>
	<a href="${otapp}/trip/activity/acti/manager.html" class="easyui-linkbutton" data-optinons="iconCls:'icon-search'" style="height:20px;"><spring:message code="common.button.return.submit"></spring:message></a>
	<div class="rightinfo">
		<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
			<tr><td>
				<h5>
		        	<span><spring:message code="trip.manager.activity.public.add.title" /></span>
		        </h5>
			</td></tr>
			<tr><td>
				<form id="addForm" method="post" action="${otapp}/trip/activity/acti/save_public.html">
				<table width="100%" cellpadding="0" cellspacing="0" class="table" style="width: 100%; top: 0px;"  >
					<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsNo" /></th>
		    			<td width="80%" colspan="3">
		    				<input  type="text" id="tripno" class="easyui-textbox"  name="a.fsNo"  data-options="required:false"   style="width:250px;" value=""></input>
		    				<a href="javascript:getLineNo();" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:120px"><spring:message code="trip.manager.activity.public.add.btn.getNo" /></a>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsTitle" /></th>
		    			<td width="80%" colspan="3"><input class="easyui-textbox" type="text" name="a.fsTitle" id="title" data-options="required:true" style="width:450px;"></input></td>
		    		</tr>
		    		<tr>
		    		<!-- 景区下拉列表 -->
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsDestination" /></th>
		    			<td width="80%" colspan="3">
		    				<otrip:destinationSelectByParent selname="a.fsDestinationContinent.fsId" parentid="root" onchangename="getDestination('fsDestinationCountry',this);" selid="fsDestinationContinent" />
		    				<select name="a.fsDestinationCountry.fsId" id="fsDestinationCountry" onchange="getDestination('fsDestinationScenic',this);" >
		    					<option value="0"><spring:message code="taglib.common.select.default.option.pls" /></option>
		    				</select>
		    				<!-- 
		    				<select name="a.fsDestinationProvince.fsId" id="fsDestinationProvince" onchange="getDestination('fsDestinationCity',this);" >
		    					<option><spring:message code="taglib.common.select.default.option.pls" /></option>
		    				</select>
		    				<select name="a.fsDestinationCity.fsId" id="fsDestinationCity" onchange="getDestination('fsDestinationScenic',this);">
		    					<option><spring:message code="taglib.common.select.default.option.pls" /></option>
		    				</select>
		    				 -->
		    				<select name="a.fsDestinationScenic.fsId" id="fsDestinationScenic">
		    					<option value="0"><spring:message code="taglib.common.select.default.option.pls" /></option>
		    				</select> 
		    				&nbsp;
		    			</td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsActivityType" /></th>
		    			<td width="30%" >
		    				<otrip:activityTypeSelect selname="a.otActiType.fsId" selid="otActiTypeId"></otrip:activityTypeSelect>
		    			</td>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsDestinationType" /></th>
		    			<td width="30%" >
		    				<otrip:destinationTypeSelect selname="a.otActiDestinationType.fsId" selid="otActiDestinationTypeId"></otrip:destinationTypeSelect>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fnTripDistance" /></th>
		    			<td width="30%" ><input class="easyui-numberspinner" type="text" id="distance" name="a.fnTripDistance" required="required" data-options="min:1,max:100,editable:true" style="width:150px;"></input></td>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fnDay" /></th>
		    			<td width="30%" ><input class="easyui-numberspinner" type="text" name="a.fnDay" id="day" required="required" data-options="min:1,max:100,editable:true" style="width:50px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fdUpperTime" /></th>
		    			<td width="30%" ><input class="Wdate"  type="text" name="a.fdUpperTime" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="fdUpperTime" style="width:150px;" value=""></input></td>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fdUnderTime" /></th>
		    			<td width="30%" ><input class="Wdate"  type="text" name="a.fdUnderTime" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="fdUnderTime"  style="width:150px;" value=""></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsSeason" /></th>
		    			<td width="30%" >
		    				<otrip:distionarySelectByTypeSign typesign="SEASON_TYPE" selname="a.fsSeason" selid="fsSeason" />
		    			</td>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsHoliday" /></th>
		    			<td width="30%" >
		    				<otrip:distionarySelectByTypeSign typesign="HOLIDAY_TYPE" selname="a.fsHoliday" selid="fsHoliday" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsLineRoad" /></th>
		    			<td width="80%" colspan="3">
		    				<!-- <input class="easyui-textbox" type="text" name="at.fsName" data-options="required:true" style="width:350px;"></input> -->
		    				<!--  <input id="lineRoad" class="easyui-textbox" name="a.fsLineRoad" data-options="multiline:true" style="height:100px;width:600px;"></input>-->
		    				<textarea rows="7" cols="10" id="lineRoad"   name="a.fsLineRoad" style="height:100px;width:600px;" onkeyup="calc('#lineRoad',event,500)" 
		    				></textarea>
		    				<span id="lineRoadmsg"></span>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsCostNotes" /></th>
		    			<td width="80%" colspan="3">
		    				<!--  <input class="easyui-textbox" name="a.fsCostNotes" id="costNotes" data-options="multiline:true" style="height:100px;width: 600px;"></input>-->
		    				<textarea rows="7" cols="10" id="CostNotes"   name="a.fsCostNotes" style="height:100px;width:600px;" onkeyup="calc('#CostNotes',event,255)"
		    				></textarea>
		    				<span id="CostNotesmsg"></span>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.prompt" /></th>
		    			<td width="80%" colspan="3">
		    				<!-- <input class="easyui-textbox" name="a.fsPrompt" id="fsPrompt" data-options="multiline:true" style="height:100px;width: 600px;"></input> -->
		    				<textarea rows="7" cols="10" id="Prompt"   name="a.fsPrompt" style="height:100px;width:600px;" onkeyup="calc('#Prompt',event,255)"
		    				></textarea>
		    				<span id="Promptmsg"></span>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsRefundNotes" /></th>
		    			<td width="80%" colspan="3">
		    				<!--  <input class="easyui-textbox" name="a.fsRefundNotes" id="refundNotes" data-options="multiline:true" style="height:100px;width: 600px;"></input>-->
		    				<textarea rows="7" cols="10" id="RefundNotes"   name="a.fsRefundNotes" style="height:100px;width:600px;" onkeyup="calc('#RefundNotes',event,255)"
		    				></textarea>
		    				<span id="RefundNotesmsg"></span>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsEquipList" /></th>
		    			<td width="80%" colspan="3">
		    				<!-- <input class="easyui-textbox" name="a.fsEquipList" id="equip" data-options="multiline:true" style="height:100px;width: 600px;" /> -->
		    				
		    				<textarea rows="7" cols="10" id="EquipList"   name="a.fsEquipList" style="height:100px;width:600px;" onkeyup="calc('#EquipList',event,255)"
		    				></textarea>
		    				<span id="EquipListmsg"></span>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td colspan="4" align="center" >
		    				<div style="text-align:center;padding:5px">
		    				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()"><spring:message code="common.button.add.submit" /></a>
		    				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="resetForm()"><spring:message code="common.button.add.clear" /></a>
		    				</div>
		    			</td>
		    		</tr>
				</table>
				</form> 
			</td></tr>
		</table>
	</div>
</body>
</html>