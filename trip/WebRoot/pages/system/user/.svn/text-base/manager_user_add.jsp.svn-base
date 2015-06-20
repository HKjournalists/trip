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
		location.replace("${otapp}/system/user/manager_user.html");
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
			<li><a href="#"><spring:message code="system.user.manager.position.menu.user" /></a></li>
			<li><a href="#"><spring:message code="system.user.manager.position.lab.user.add" /></a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<form id="addForm" method="post" action="${otapp}/system/user/manager_user_save.html">
		<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
			<tr><td>
				<h5>
		        	<span><spring:message code="system.user.manager.position.lab.user.add" /></span>
		        </h5>
			</td></tr>
			<tr><td>
				<table width="100%" cellpadding="0" cellspacing="0" class="table" style="width: 100%; top: 0px;"  >
					<tr>
		    			<th width="20%"  align="right"><spring:message code="system.user.manager.add.lab.account" /></th>
		    			<td width="30%" ><input class="easyui-textbox" type="text" name="su.fsAccount" data-options="required:true" style="width:150px;"></input></td>
		    			<th  width="20%"><spring:message code="system.user.manager.add.lab.password" /></th>
		    			<td width="30%" class="tdright" ><input class="easyui-textbox" type="text" name="su.fsPassword" data-options="required:true" style="width:150px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="system.user.manager.add.lab.confirmpassword" /></th>
		    			<td width="30%" >
		    				<input class="easyui-textbox" type="text" name="confirmPassword" data-options="required:true" style="width:150px;">
		    			</td>
		    			<th  width="20%"><spring:message code="system.user.manager.add.lab.name" /></th>
		    			<td width="30%" ><input class="easyui-textbox" type="text" name="su.fsName" data-options="required:false" style="width:150px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="system.user.manager.add.lab.email" /></th>
		    			<td width="30%" >
		    				<input class="easyui-textbox" type="text" name="su.fsEmail" data-options="required:true" style="width:150px;">
		    			</td>
		    			<th  width="20%"><spring:message code="system.user.manager.add.lab.phone" /></th>
		    			<td width="30%" ><input class="easyui-textbox" type="text" name="su.fsPhone" data-options="required:false" style="width:150px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="system.user.manager.add.lab.status" /></th>
		    			<td width="30%" colspan="1" >
		    				<select name="su.fsStatus">
		    					<option value="1">YES</option>
		    					<option value="0">NO</option>
		    				</select>
		    			</td>
		    			<th  width="20%"><spring:message code="system.user.manager.add.lab.typeSign" /></th>
		    			<td width="30%" colspan="1" >
		    				<input type="hidden" id="fsTypeSign" name="su.fsTypeSign" value="0" />
		    				<spring:message code="system.user.manager.add.lab.type_sign_value.managerUser" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<th  width="20%"><spring:message code="system.user.manager.add.lab.description" /></th>
		    			<td width="30%" colspan="3" >
		    				<textarea name="su.fsDescription" data-options="multiline:true" style="height:60px;width:350px;" cols="3" rows="4"></textarea>
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
					    		<spring:message code="system.user.manager.title.add.sel.role.lab" />
					    	</a></li> 
					  	</ul>
				    </div> 
				    <div id="tab1" class="tabson">
				    	<div class="easyui-accordion" style="width:100%;height:300px;">
				    		<c:if test="${optRoles!=null&&optRoles.size()>0 }">
							<div title="<spring:message code="system.user.manager.add.role.configure"  />" data-options="iconCls:'icon-role'" style="overflow:auto;padding:10px;width: 100%;">
								<c:if test="${optRoles!=null&&optRoles.size()>0}">
								<c:forEach items="${optRoles}"  var="r" varStatus="statusMal">
									<input type="checkbox" name="roleIds" value="${r.fsId}" style="margin: 0px;padding: 0px;border: 0px;height:13px;" />${r.fsName}&nbsp;&nbsp;
								</c:forEach>
								</c:if>
							</div>
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