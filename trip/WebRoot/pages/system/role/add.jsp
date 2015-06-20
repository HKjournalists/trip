<%@include file="../../general/header.jsp"%>

<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/css/display/display.css" /> 
<script type="text/javascript" src="${otapp}/js/jquery.idTabs.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	var statusCode="${operatorStateCode}";
	if(statusCode!=null&&"success"==statusCode){
		alert('<spring:message code="common.operator.message.code.add.success" />');
		location.replace("${otapp}/system/role/manager.html");
	}
	$("#usual1 ul").idTabs(); 
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
</script>
<body>
	<div class="place">
		<span><spring:message code="common.content.lab.position" /></span>
		<ul class="placeul">
			<li><a href="#"><spring:message code="system.setting.position.system.config" /></a></li>
			<li><a href="#"><spring:message code="system.setting.position.authority.config" /></a></li>
			<li><a href="#"><spring:message code="system.setting.position.authority.role.config" /></a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<form id="addForm" method="post" action="${otapp}/system/role/save.html">
		<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
			<tr><td>
				<h5>
		        	<span><spring:message code="system.setting.authority.button.role.add" /></span>
		        </h5>
			</td></tr>
			<tr><td>
				<table width="100%" cellpadding="0" cellspacing="0" class="table" style="width: 100%; top: 0px;"  >
					<tr>
		    			<th width="20%"  align="right"><spring:message code="system.setting.authority.add.fsName" /></th>
		    			<td width="30%" ><input class="easyui-textbox" type="text" name="r.fsName" data-options="required:true" style="width:150px;"></input></td>
		    			<th  width="20%"><spring:message code="system.setting.authority.add.fnOrder" /></th>
		    			<td width="30%" class="tdright" ><input class="easyui-textbox" type="text" name="r.fnOrder" data-options="required:false" style="width:150px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="system.setting.authority.add.fsParentName" /></th>
		    			<td width="30%" >
		    				<input type="hidden" name="r.sysRole.fsId" value="${p.fsId}"/>
		    				${p.fsName}
		    			</td>
		    			<th  width="20%"><spring:message code="system.setting.authority.add.fsSign" /></th>
		    			<td width="30%" ><input class="easyui-textbox" type="text" name="r.fsSign" data-options="required:false" style="width:150px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="system.setting.authority.add.fsStatus" /></th>
		    			<td width="80%" colspan="3" >
		    				<select name="r.fsStatus">
		    					<option value="1"><spring:message code="system.setting.authority.role.status.yes" /></option>
		    					<option value="0"><spring:message code="system.setting.authority.role.status.no" /></option>
		    				</select>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td colspan="4" align="center" class="tdleft">
		    				<div style="text-align:center;padding:5px">
		    				<input type="button" class="button1"  value="<spring:message code="common.button.add.submit" />" onclick="javascript:submitForm();" />
		    				<input type="button" class="button1"  value="<spring:message code="common.button.add.clear" />" onclick="javascript:resetForm();" />
		    				</div>
		    			</td>
		    		</tr>
				</table>
			</td></tr>
			<tr><td>
				<div id="usual1" class="usual"> 
				    <div class="itab">
					  	<ul> 
					    	<li><a href="#tab1" class="selected">
					    		<spring:message code="system.setting.authority.add.config.title" />
					    	</a></li> 
					  	</ul>
				    </div> 
				    <div id="tab1" class="tabson">
				    	<div class="easyui-accordion" style="width:100%;height:300px;">
				    		<c:if test="${menuTypeList!=null&&menuTypeList.size()>0 }">
				    		<c:forEach items="${menuTypeList}"  var ="mtl" varStatus="statusMtl">
							<div title="<spring:message code="system.setting.authority.config.key.title" arguments="${mtl.fsName}" argumentSeparator="," />" data-options="iconCls:'icon-authority'" style="overflow:auto;padding:10px;width: 100%;">
								<c:if test="${mtl.sysMenuAuths!=null&&mtl.sysMenuAuths.size()>0}">
								<c:forEach items="${mtl.sysMenuAuths}"  var="mav" varStatus="statusMal">
									<input type="checkbox" name="authId" value="${mav.fsId}" style="margin: 0px;padding: 0px;border: 0px;height:13px;" />${mav.fsName}&nbsp;&nbsp;
								</c:forEach>
								</c:if>
							</div>
				    		</c:forEach>
				    		</c:if>
				    	</div>
				    </div>
			    </div> 
			</td></tr>
		</table>
		</form>
	</div>
</body>
</html>