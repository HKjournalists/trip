 <%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>

<script language="javascript" type="text/javascript" src="${otapp}/plug/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
/*
function init()
{
	var dd=documnet.getElementById("fsDestinationContinent").value=${actv.getFsDestinationContinent().getFsId()}.selected;
	alert(dd);
	dd=true;
	alert(dd);
}
*/

$(document).ready(function(){
	
	
	
	$("#otActiTypeId").val("${actv.getOtActiType().getFsId()}");
	$("#otActiDestinationTypeId").val("${actv.getOtActiDestinationType().getFsId()}");
	//$("#fdUpperTime").val("${actv.getFormatFdUpperTime()}");
	//$("#fdUnderTime").val("${actv.getFormatFdUnderTime()}");
	
	var statusCode="${operatorStateCode}";
	if(statusCode!=null&&"success"==statusCode){
		alert('<spring:message code="common.operator.message.code.add.success" />');
		location.replace("${otapp}/trip/activity/acti/manager.html");
	}
	
	
});
function initSelect(fsId,namelab,selId)
{
	 $.post('${otapp}/trip/activity/acti/getDestinationOpt.html?json',{"parentId":fsId},function(data, textStatus){  
	    	if(data!=null&&data!=""){
				var str = eval(data); 
				$.each(str, function() { 
					//alert("value: "+this.value);
					$("#"+namelab+" option[value='"+this.value+"']").remove();
					$("#"+namelab+"").append("<option value='"+this.value+"' id='"+this.value+"' > "+this.name+"</option>");
					
					//alert("name :"+this.name);
				 }); 
			}
	    	
		},"json");
	 //$("#"+namelab+" option[value=' "+selId+"']").attr("selected",true);
	// ($("#"+namelab+" option[value=' "+selId+"']"));
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
						$("#"+namelab).append("<option value='"+this.value+"' id='"+this.value+"' > "+this.name+"</option>");
						
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
	{
		$("#modifyForm").submit(); 
		
	}
		
	
	else
		return false;
}

function resetForm(){
	$("#modifyForm").reset(); 
}


/**
 * 验证
 */
 function validate()
 {
	//输入框
	var no=document.getElementById("tripno").value;
		
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
	if(continent=="-\u8BF7\u9009\u62E9-")
	{
		alert("\u8bf7\u9009\u62e9\u5dde");
		return false;
	}
	if(country=="-\u8BF7\u9009\u62E9-")
	{
		alert("\u8bf7\u9009\u62e9\u56fd\u5bb6");
		return false;
	}
	if(scenic=="-\u8BF7\u9009\u62E9-")
	{
		alert("\u8bf7\u9009\u62e9\u666f\u533a");
		return false;
	}
	if(type=="-\u8BF7\u9009\u62E9-")
	{
		alert("\u8bf7\u9009\u62e9\u6d3b\u52a8\u7c7b\u578b");
		return false;
	}
	if(desType=="-\u8BF7\u9009\u62E9-")
	{
		alert("\u8bf7\u9009\u62e9\u666f\u533a\u7c7b\u578b");
		return false;
	}
	if(season=="-\u8BF7\u9009\u62E9-")
	{
		alert("\u8bf7\u9009\u62e9\u5b63\u8282\u7c7b\u578b");
		return false;
	}
	if(holiday=="-\u8BF7\u9009\u62E9-")
	{
		alert("\u8bf7\u9009\u62e9\u8282\u5047\u65e5");
		return false;
	}
	return true;;
 }
 
/**
 * 默认选中项
 */
 
 
 
 
 
 
</script>
<body >
	<div class="place">
		<span><spring:message code="common.content.lab.position" /></span>
		<ul class="placeul">
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.modul" /></a></li>
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.travel.activity" /></a></li>
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.activity.public" /></a></li>
			<li><spring:message code="trip.manager.activity.public.modify.title" /></li>
		</ul>
	</div>
	<a href="${otapp}/trip/activity/acti/manager.html" class="easyui-linkbutton" data-optinons="iconCls:'icon-search'" style="height:20px;"><spring:message code="common.button.return.submit"></spring:message></a>
	<div class="rightinfo">
		<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
			<tr><td>
				<h5>
		        	<span><spring:message code="trip.manager.activity.public.modify.title" /></span>
		        </h5>
			</td></tr>
			<tr><td>
				<form id="modifyForm" method="post" action="${otapp}/trip/activity/acti/save_modifyActi.html">
				<input type="hidden" value="${actv.getFsId()}" id="fsId" name=a.fsId />
				<table width="100%" cellpadding="0" cellspacing="0" class="table" style="width: 100%; top: 0px;"  >
					<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsNo" /></th>
		    			<td width="80%" colspan="3">
		    				<input  type="text" id="tripno" class="easyui-textbox"  name="a.fsNo"  data-options="required:false"   style="width:250px;" value="${actv.getFsNo() }"></input>
		    				<a href="javascript:getLineNo();" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:120px"><spring:message code="trip.manager.activity.public.add.btn.getNo" /></a>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsTitle" /></th>
		    			<td width="80%" colspan="3"><input class="easyui-textbox" type="text" name="a.fsTitle" id="title" data-options="required:true" style="width:450px;" value="${actv.getFsTitle()}"></input></td>
		    		</tr>
		    		<tr>
		    		<!-- 景区下拉列表 -->
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsDestination" /></th>
		    			<td width="80%" colspan="3">
		    			<otrip:initDestination countryParent="${actv.getFsDestinationContinent().getFsId()}" continentParent="root" countryName="a.fsDestinationCountry.fsId" continentName="a.fsDestinationContinent.fsId"
		    			continentChangeName="getDestination('fsDestinationCountry',this);" countryChangeName="getDestination('fsDestinationScenic',this);" 
		    			scenicParent="${actv.fsDestinationCountry.fsId  }" scenicChangeName="" scenicName="a.fsDestinationScenic.fsId"
		    			continentInit="${actv.getFsDestinationContinent().getFsId() }" countryInit="${actv.getFsDestinationCountry().getFsId() }" scenicInit="${actv.getFsDestinationScenic().getFsId() }"
		    			>
		    			</otrip:initDestination>
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
		    			<td width="30%" ><input class="easyui-textbox" type="text" id="distance" name="a.fnTripDistance" data-options="required:true" style="width:150px;" value="${actv.getFnTripDistance().toString() }"></input></td>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fnDay" /></th>
		    			<td width="30%" ><input class="easyui-textbox" type="text" name="a.fnDay" id="day" data-options="required:true" style="width:150px;" value="${actv.getFnDay() }"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="15%"><spring:message code="trip.manager.activity.public.add.lab.fdUpperTime" /></th>
		    			<td width="35%" ><input class="easyui-datetimebox"  type="text" name="a.fdUpperTime" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="fdUpperTime" style="width:150px;" value="${actv.getFormatFdUpperTime()}"></input></td>
		    			<th  width="15%"><spring:message code="trip.manager.activity.public.add.lab.fdUnderTime" /></th>
		    			<td width="35%" ><input class="easyui-datetimebox"  type="text" name="a.fdUnderTime" onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="fdUnderTime"  style="width:150px;" value="${actv.getFormatFdUnderTime()}"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsSeason" /></th>
		    			<td width="30%" >
		    				<otrip:distionarySelectByTypeSign typesign="SEASON_TYPE" selname="a.fsSeason" selid="fsSeason" initValue="${actv.getFsSeason()}" />
		    			</td>
		    			<th  width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsHoliday" /></th>
		    			<td width="30%" >
		    				<otrip:distionarySelectByTypeSign typesign="HOLIDAY_TYPE" selname="a.fsHoliday" selid="fsHoliday" initValue="${actv.getFsHoliday() }"/>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsLineRoad" /></th>
		    			<td width="80%" colspan="3">
		    				<!-- <input class="easyui-textbox" type="text" name="at.fsName" data-options="required:true" style="width:350px;"></input> -->
		    				<input class="easyui-textbox" name="a.fsLineRoad" data-options="multiline:true" style="height:100px;width:600px;" value="${actv.getFsLineRoad() }"></input>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsCostNotes" /></th>
		    			<td width="80%" colspan="3">
		    				<input class="easyui-textbox" name="a.fsCostNotes" id="costNotes" data-options="multiline:true" style="height:100px;width: 600px;" value="${actv.getFsCostNotes() }"></input>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsRefundNotes" /></th>
		    			<td width="80%" colspan="3">
		    				<input class="easyui-textbox" name="a.fsRefundNotes" id="refundNotes" data-options="multiline:true" style="height:100px;width: 600px;" value="${actv.getFsRefundNotes() }"></input>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsEquipList" /></th>
		    			<td width="80%" colspan="3">
		    				<input class="easyui-textbox" name="a.fsEquipList" id="equip" data-options="multiline:true" style="height:100px;width: 600px;"  value="${actv.getFsEquipList() }"
		    				></input>
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