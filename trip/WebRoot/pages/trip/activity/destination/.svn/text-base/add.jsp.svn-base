<%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/css/display/display.css" /> 
<style>
.body:ACTIVE{
	width: 100%;
    height: 100%;
    top:0px;
    margin: 0px auto;
    position: relative;
    background: #e9f2f7;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	var statusCode="${operatorStateCode}";
	if(statusCode!=null&&"success"==statusCode){
		alert('<spring:message code="common.operator.message.code.add.success" />');
		parent.window.reloadTree();
		var parentId="${ad.fsParentId}";
		if("root"==parentId){
			location.replace("${otapp}/trip/activity/destination/view.html?ad.fsId=${ad.fsId}");
		}else{
			location.replace("${otapp}/trip/activity/destination/view.html?ad.fsId=${ad.fsParentId}");
		}
		
	}
});
/**
 * @see 提交数据
 */
function submitForm(){
	$("#addForm").submit(); 
}

function resetForm(){
	$("#addForm").reset(); 
}

function getCoordinate(){
	$('#coordinateWin').window('open')
}

function closeCoordinateWindow(){
	$('#coordinateWin').window('close')
}

</script>
<body>

	<div class="rightinfo">
		<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
			<tr><td>
				<h5>
		        	<span><spring:message code="trip.manager.destination.add.title" /></span>
		        </h5>
			</td></tr>
			<tr><td>
				<form id="addForm" method="post" action="${otapp}/trip/activity/destination/save.html">
				<table width="100%" cellpadding="0" cellspacing="0" bgColor="#cccccc" class="table" style="width: 100%; top: 0px;"  >
					<tr>
		    			<th class="tdleft" width="20%"><spring:message code="trip.manager.destination.add.fsName" /></th>
		    			<td class="tdright" width="30%">
		    				<input  type="text" name="ad.fsName" data-options="required:true" style="width:150px;" />
		    			</td>
		    			<th class="tdleft" width="20%"><spring:message code="trip.manager.destination.add.fsValue" /></th>
		    			<td  class="tdright" width="30%">
		    				<input  type="text" name="ad.fsValue" data-options="required:true" style="width:150px;" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<th class="tdleft" width="20%"><spring:message code="trip.manager.destination.add.fsType" /></th>
		    			<td width="30%" class="tdright">
		    				<otrip:destinationTypeSelect selname="ad.otActiDestinationType.fsId" selid="typeId"></otrip:destinationTypeSelect>
		    			</td>
		    			<th width="20%" class="tdleft"><spring:message code="trip.manager.destination.add.fsParent" /></th>
		    			<td width="30%" class="tdright">
		    				<c:if test="${pad!=null}">
		    					${pad.fsName}
		    					<input  type="hidden" name="ad.fsParentId" data-options="required:true" style="width:150px;" value="${pad.fsId }" />
		    				</c:if>
	            			<c:if test="${pad==null}">
	            				<spring:message code="trip.manager.destination.view.isRoot"></spring:message>
	            				<input  type="hidden" name="ad.fsParentId" data-options="required:true" style="width:150px;" value="root" />
	            			</c:if>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%" class="tdleft" ><spring:message code="trip.manager.destination.add.coordinate" /></th>
		    			<td width="30%" class="tdright" colspan="3">
		    				<table style="width: 100%;height: 100%;border: 0px;margin: 0px;padding: 0px;">
		    					<tr>
			    					<td width="50%">
			    						<spring:message code="trip.manager.destination.add.fsLatitude"></spring:message>
			    						<input  type="text" id="fsLatitude" name="ad.fsLatitude" data-options="required:true" style="width:150px;" />
			    					</td>
			    					
		    					</tr>
		    					<tr>
		    						<td colspan="1">
			    						<spring:message code="trip.manager.destination.add.fsLongitudel"></spring:message>
			    						<input  type="text" id="fsLongitudel" name="ad.fsLongitudel" data-options="required:true" style="width:150px;" />
			    					</td>
			    					<td colspan="1" rowspan="2" valign="top">
			    						<a href="javascript:getCoordinate();" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="trip.manager.destination.add.btn.coordinateWin" /></a>
			    					</td>
		    					</tr>
		    				</table>
		    				
		    			</td>
		    		</tr>
		    		<tr>
		    			<th colspan="4" align="center" class="tdleft">
		    				<div style="text-align:center;padding:5px">
		    				<input type="button" class="button1"  value="<spring:message code="common.button.add.submit" />" onclick="javascript:submitForm();" />
		    				<input type="button" class="button1"  value="<spring:message code="common.button.add.clear" />" onclick="javascript:resetForm();" />
		    				</div>
		    			</th>
		    		</tr>
				</table>
				</form>
			</td></tr>
		</table>
	</div>
	
	<div id="coordinateWin" align="center" class="easyui-window" title='<spring:message code="trip.manager.destination.add.title.map"/>'  data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:900px;height:450px;padding:0px;margin: 0px;border: 0px;overflow:hidden;">
		<br>
		<iframe id="coordinateMap" src="${otapp}/trip/activity/destination/coordinate.html" width="850px" height="400px;" frameborder="0" border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;overflow:hidden;" ></iframe>
	</div> 
	
</body>
</html>