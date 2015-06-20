<%@include file="../../general/header.jsp"%>
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
		location.replace("${otapp}/system/menu/include_menu.html?ma.fsId=${ma.fsParentId}");
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

function selectResource(){
	$('#wr').window('open')
}

function closeResourceWindow(){
	$('#wr').window('close')
}

</script>
<body>

	<div class="rightinfo">
		<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
			<tr><td>
				<h5>
		        	<span><spring:message code="system.setting.menu.manager.childmenu.titile" /></span>
		        </h5>
			</td></tr>
			<tr><td>
				<form id="addForm" method="post" action="${otapp}/system/menu/save_child_menu.html">
				<table width="100%" cellpadding="0" cellspacing="0" bgColor="#cccccc" class="table" style="width: 100%; top: 0px;"  >
					<tr>
		    			<th class="tdleft" width="20%"><spring:message code="system.setting.menu.manager.childmenu.lab.fsName" /></th>
		    			<td class="tdright" width="30%">
		    				<input  type="text" name="ma.fsName" data-options="required:true" style="width:150px;" />
		    			</td>
		    			<th class="tdleft" width="20%"><spring:message code="system.setting.menu.manager.childmenu.lab.fsType" /></th>
		    			<td  class="tdright" width="30%">
		    				<select class="easyui-combobox" name="ma.sysMenuType.fsId">		    				
		    					<c:if test="${menuTypeList!=null&&menuTypeList.size()>0 }">
		    						<c:forEach items="${menuTypeList}" var="mt">
		    							<option value="${mt.fsId}">${mt.fsName}</option>
		    						</c:forEach>
		    					</c:if>		    				
		    				</select>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th class="tdleft" width="20%"><spring:message code="system.setting.menu.manager.childmenu.lab.fsParent" /></th>
		    			<td width="30%" class="tdright">
		    				<input  type="hidden" name="ma.fsParentId" value="${parentMenu.fsId}" />
		    				${parentMenu.fsName}
		    			</td>
		    			<th width="20%" class="tdleft"><spring:message code="system.setting.menu.manager.childmenu.lab.fsOrder" /></th>
		    			<td width="30%" class="tdright"><input  type="text" name="ma.fnOrder" data-options="required:true" style="width:150px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th width="20%" class="tdleft" ><spring:message code="system.setting.menu.manager.childmenu.lab.fsStatus" /></th>
		    			<td width="30%" class="tdright">
		    				<select class="easyui-combobox" name="ma.fsStatus">		
		    					<option value="1"><spring:message code="system.setting.menu.manager.display.status.yes" /></option>		 
		    					<option value="0"><spring:message code="system.setting.menu.manager.display.status.no" /></option>		    				
		    				</select>
		    			</td>
		    			<th width="20%" class="tdleft"><spring:message code="system.setting.menu.manager.childmenu.lab.fsResource" /></th>
		    			<td width="30%" class="tdright">
		    				<input  id="resourceId" type="hidden" name="ma.sysResource.fsId" data-options="required:false" style="width:150px;" />
		    				<input  id="resourcePath" type="text" name="resourcePath" readonly="readonly" data-options="required:false" style="width:150px;" />
		    				<img src="${otapp}/plug/jquery-easyui/themes/icons/btnsel.gif" onclick="javascript:selectResource();" alt="<spring:message code="system.setting.menu.manager.childmenu.button.selectResource" />"/>
		    				
		    			</td>
		    		</tr>
		    		<tr>
		    			<th width="20%" class="tdleft"><spring:message code="system.setting.menu.manager.childmenu.lab.fsDescription" /></th>
		    			<td width="80%" colspan="3" class="tdright">
		    				<textarea name="ma.fsDescription" data-options="multiline:true" style="height:60px;width:350px;" cols="3" rows="4"></textarea>
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
	
	<div id="wr" align="center" class="easyui-window" title='<spring:message code="system.setting.menu.manager.childmenu.lab.title.selectResource"/>'  data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:800px;height:350px;padding:0px;">
		<br>
		<iframe id="selectList" src="${otapp}/system/requiredpath/select_list.html" width="765px" height="100%" frameborder="0" border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" ></iframe>
	</div>
	
</body>
</html>