<%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/upload/ajaxfileupload.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.form.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="http://webapi.amap.com/maps?v=1.3&key=e18d7cfe65ea634648a9c0943f10f1f0" type="text/javascript"></script> 
<script type="text/javascript">
$(document).ready(function(){
	var statusCode="${operatorStateCode}";
	if(statusCode!=null&&"success"==statusCode){
		alert('<spring:message code="common.operator.message.code.add.success" />');
		// location.replace("${otapp}/trip/activity/acti/list_days.html?actId=${actId}");
	}
});
/**
 * @see 查询旅游活动
 */
function submitForm(){
	$("#subform").submit(); 
}
 

/**
 * @see 删除旅游活动
 */
/* function del(id){
    $.post('${otapp}/trip/configure/destination/delete.html?json',{"id":id},function(data, textStatus){  
    	if("success"==textStatus&&data!=null&&"success"==data['operatorStateCode']){
    		alert('<spring:message code="common.operator.message.code.del.success" />');
    		location.reload(true);
    	}else{
    		alert('<spring:message code="common.operator.message.code.del.fail" />');
    	}
	},"json");
} */
function getCoordinate(){
	/* $('#coordinateWin').window('open') */
	 // window.showModalDialog("${otapp}/common/map/get_position.html",window,"dialogWidth=1000px;dialogHeight=400px");
	$('#coordinateWin').window('open')
}
function closeCoordinateWindow(){
	$('#coordinateWin').window('close')
}

/**
 * @see 上传附件
 */
 

</script>
<body>

	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
        		<h4>
		        	<span><spring:message code="trip.manager.activity.public.view.schedule.change.title" /></span>
		        	<ul class="toolbar1" >
			        &nbsp;
			        </ul>
		        </h4>
		        <a href="${otapp}/trip/activity/acti/list_days.html?1=1&actId=${actiId}" class="easyui-linkbutton" data-optinons="iconCls:'icon-search'" style="height:20px;"><spring:message code="common.button.return.submit"></spring:message></a>
				<form action="${otapp}/trip/activity/acti/save_Changedays.html" method="post" id="subform">
				<input type="hidden" name="d.otActiInfo.fsId" value="${actiId}" />
				<input type="hidden" name="d.fsId" value="${actiDay.fsId }">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.add.fsName" /></th>
		            <td width="30%" colspan="1"><input name="d.fsName" type="text" class="scinput" value="${actiDay.fsName} " /></td>
		            <th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.add.fnDays" /></th>
		            <td width="30%" colspan="1"><input name="d.fnDays" type="text" class="scinput" value="${actiDay.fnDays }" /></td>
		          </tr>
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.add.position" /></th>
		            <td width="80%" colspan="3">
		            	<table style="width: 100%;height: 100%;border: 0px;margin: 0px;padding: 0px;">
		    					<tr>
			    					<td width="50%">
			    						<spring:message code="trip.manager.destination.add.fsLatitude"></spring:message>
			    						<input  type="text" id="latitude" name="d.fsLatitude" data-options="required:true" style="width:150px;" value="${actiDay.fsLatitude }" />
			    					</td>
		    					</tr>
		    					<tr>
		    						<td colspan="1">
			    						<spring:message code="trip.manager.destination.add.fsLongitudel"></spring:message>
			    						<input  type="text" id="longitudel" name="d.fsLongitude" data-options="required:true" style="width:150px;" value="${actiDay.fsLongitude }" />
			    					</td>
			    					<td colspan="1" rowspan="2" valign="top">
			    						<a href="javascript:getCoordinate();" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="trip.manager.destination.add.btn.coordinateWin" /></a>
			    					</td>
		    					</tr>
		    				</table>
		            </td>
		          </tr>
		          <tr>
		          	
		          </tr>
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.add.fsDescription" /></th>
		            <td width="80%" colspan="3">
		            	<input class="easyui-textbox" name="d.fsDescription" data-options="multiline:true" style="height:100px;width: 300px;" value="${actiDay.fsDescription }"></input>
		            </td>
		          </tr>
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:submitForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.add.submit" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				 
				<div id="coordinateWin" align="center" class="easyui-window" title='<spring:message code="trip.manager.destination.add.title.map"/>'  data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:900px;height:450px;padding:0px;margin: 0px;border: 0px;overflow:hidden;">
				<br>
					<iframe id="coordinateMap" src="${otapp}/trip/activity/destination/coordinate.html" width="850px" height="400px;" frameborder="0" border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;overflow:hidden;" ></iframe>
				</div> 
			
				
				
				
				
			</div>
		</div>
	</div>
	<div>
		
	</div>
</body>
</html>