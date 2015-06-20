<%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
 <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/demo.css " />
  <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/dlg.css " />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.form.js"></script>
   <script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script language="javascript" type="text/javascript" src="${otapp}/plug/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	//$('#tt').tabs(onSelect:function(title)){alert(title+"is selected");};
	
	 
	 $("#coverId").load(function(){
	    $(this).height(0); //ç¨äºæ¯æ¬¡å·æ°æ¶æ§å¶IFRAMEé«åº¦åå§å
	    var height = $(this).contents().height() + 10;
	    $(this).height( height < 300 ? 300 : height );
	}); 
	
	$("#scheduleId").load(function(){
	    $(this).height(0); //ç¨äºæ¯æ¬¡å·æ°æ¶æ§å¶IFRAMEé«åº¦åå§å
	    var height = $(this).contents().height() + 10;
	    $(this).height( height < 300 ? 300 : height );
	}); 
	$("#addDayImage").load(function(){
		$(this).height(0); //ç¨äºæ¯æ¬¡å·æ°æ¶æ§å¶IFRAMEé«åº¦åå§å
	    var height = $(this).contents().height() + 10;
	    $(this).height( height < 300 ? 300 : height );
	})
	
	
});


</script>
<style>
*{font-size:9pt;border:0;margin:0;padding:0;}
body{font-family:'微软雅黑'; margin:0 auto;min-width:980px;}
</style>

<body>
	<div class="place">
		<span><spring:message code="common.content.lab.position" /></span>
		<ul class="placeul">
			<li><a href="#"><spring:message code="trip.manager.position.modul" /></a></li>
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.travel.activity" /></a></li>
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.activity.public" /></a></li>
			<li><spring:message code="trip.manager.activity.public.view.title" /></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div id="tt" class="easyui-tabs" style="width:90%;font-weight: bold;height:auto;">
			<div title="<spring:message code="trip.manager.activity.public.view.title" />" style="padding:10px">
				<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
					<tr><td>
						<h5>
				        	<!--  <span><spring:message code="trip.manager.activity.public.view.title" /></span>-->
							<span><spring:message code="trip.manager.activity.public.view.title" />:<font color="red">${actiTitle }</font></span>
				        </h5>
					</td></tr>
					<tr><td>
						<form id="addForm" method="post" action="${otapp}/trip/activity/acti/save_public.html">
						<table width="100%" cellpadding="0" cellspacing="0" class="table" style="width: 100%; top: 0px;"  >
							<tr>
				    			<th width="20%"><spring:message code="trip.manager.activity.public.add.lab.fsNo" /></th>
				    			<td width="80%" colspan="3">${actv.fsNo}</td>
				    		</tr>
				    		<tr>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsTitle" /></th>
				    			<td width="80%" colspan="3">
				    				${actv.fsTitle}
				    			</td>
				    		</tr>
				    		<tr>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsDestination" /></th>
				    			<td width="80%" colspan="3">
				    				<otrip:viewDestinationNameById id="${actv.fsDestinationContinent.fsId}" />
				    				&nbsp;
				    				<otrip:viewDestinationNameById id="${actv.fsDestinationCountry.fsId}" />
				    				&nbsp;
				    				<otrip:viewDestinationNameById id="${actv.fsDestinationProvince.fsId}" />
				    				&nbsp;
				    				<otrip:viewDestinationNameById id="${actv.fsDestinationCity.fsId}" />
				    				&nbsp;
				    				<otrip:viewDestinationNameById id="${actv.fsDestinationScenic.fsId}" />
				    				&nbsp;
				    			</td>
				    		</tr>
				    		<tr>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsActivityType" /></th>
				    			<td width="30%" >
				    				<otrip:viewActivityTypeNameById id="${actv.otActiType.fsId}"></otrip:viewActivityTypeNameById>
				    			</td>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsDestinationType" /></th>
				    			<td width="30%" >
				    				<otrip:viewDestinationTypeNameById id="${actv.otActiDestinationType.fsId}" />
				    			</td>
				    		</tr>
				    		<tr>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fnTripDistance" /></th>
				    			<td width="30%" >${actv.fnTripDistance} &nbsp;<spring:message code="unit.away.km" /></td>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fnDay" /></th>
				    			<td width="30%" >${actv.fnDay} &nbsp;<spring:message code="unit.time.day" /></td>
				    		</tr>
				    		<tr>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fdUpperTime" /></th>
				    			<td width="30%" >
				    				<fmt:formatDate value="${actv.fdUpperTime }" pattern="yyyy-MM-dd" type="date" />
				    			</td>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fdUnderTime" /></th>
				    			<td width="30%" >
				    				<fmt:formatDate value="${actv.fdUnderTime }" pattern="yyyy-MM-dd" type="date" />
				    			</td>
				    		</tr>
				    		<tr>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsSeason" /></th>
				    			<td width="30%" >
				    				<otrip:viewDictionaryNameById id="${actv.fsSeason }"></otrip:viewDictionaryNameById>
				    			</td>
				    			<th  width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsHoliday" /></th>
				    			<td width="30%" >
				    				<otrip:viewDictionaryNameById id="${actv.fsHoliday }"></otrip:viewDictionaryNameById>
				    				
				    			</td>
				    		</tr>
				    		<tr>
				    			<th width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsLineRoad" /></th>
				    			<td width="80%" colspan="3">
									<div><pre>${actv.fsLineRoad }</pre></div>
				    				<!-- <input class="easyui-textbox" name="a.fsLineRoad" readonly="readonly" data-options="multiline:true" style="height:70px;width:700px;" value="${actv.fsLineRoad }"></input> -->
				    			</td>
				    		</tr>
				    		<tr>
				    			<th width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsCostNotes" /></th>
				    			<td width="80%" colspan="3">
				    				<!--  <input class="easyui-textbox" name="a.fsCostNotes" value="${actv.fsCostNotes }" data-options="multiline:true" readonly="readonly" style="height:70px;width7600px;"></input>-->
				    				<div><pre>${actv.fsCostNotes }</pre></pre></div>
				    			</td>
				    		</tr>
				    		<tr>
				    			<th width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsRefundNotes" /></th>
				    			<td width="80%" colspan="3">
				    				<!--  <input class="easyui-textbox" name="a.fsRefundNotes" readonly="readonly" value="${actv.fsRefundNotes }" data-options="multiline:true" style="height:70px;width: 700px;"></input>-->
				    				<div><pre>${actv.fsRefundNotes }</pre></div>
				    			</td>
				    		</tr>
				    		<tr>
				    			<th width="20%"><spring:message code="trip.manager.activity.public.view.lab.fsEquipList" /></th>
				    			<td width="80%" colspan="3">
				    				<!--  <input class="easyui-textbox" name="a.fsEquipList" value="${actv.fsEquipList }" readonly="readonly" data-options="multiline:true" style="height:70px;width: 700px;"></input>-->
				    				<div><pre>${actv.fsRefundNotes }</pre></div>
				    			</td>
				    		</tr>
				    		
						</table>
						</form> 
					</td></tr>
				</table>
			</div>
			<div title="<spring:message code="trip.manager.activity.public.view.cover.title" />" style="padding:10px">
				<iframe id="coverId" src="${otapp}/trip/activity/acti/list_cover.html?1=1&imageName=&actId=${actv.fsId}" width="100%" height="600px" frameborder="0"  border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  ></iframe>
			</div>
			<div title="<spring:message code="trip.manager.activity.public.view.schedule.title"/>" style="padding:10px">
				<iframe id="days" src="${otapp}/trip/activity/acti/list_days.html?1=1&actId=${actv.fsId}" width="100%" height="600px" frameborder="0"  border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  ></iframe>
			</div>
			
			<div title="<spring:message code="trip.manager.activity.public.view.schedule.addPriceTime"/>" style="padding:4px">
				<iframe id="Actiprice"  src="${otapp}/trip/activity/acti/list_TimePrice.html?1=1&actId=${actv.fsId}" width="100%" height="650px" frameborder="0"  border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  >
				</iframe>
			</div>
			
			<div title="<spring:message code="trip.manager.activity.public.view.otherImage" />" style="padding:10px" >
				<iframe id="OtherImage" src="${otapp}/trip/activity/acti/list_otherImage.html"  width="100%" height="650px" frameborder="0"  border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no" ></iframe>
			</div>
		</div>
	</div>
	
	
</body>
</html>