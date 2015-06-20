<%@include file="../../general/headernocss.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${otapp}/css/display/display.css" />
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript">

/**
 * @see 提交查询
 */
function queryForm(){
	$("#subform").submit(); 
}

function seleResource(resId,resName){
	$('#resourceId', window.parent.document).val(resId);
	$('#resourcePath', window.parent.document).val(resName);
	/* $('#wr',window.parent).window('close'); */
	window.parent.closeResourceWindow();
}

</script>
<body style="margin: 0px;padding: 0px;">
	
	<div style="width:100%;margin: 0px;padding: 0px;left: 2px;border: 0px;top: 10px;">
		<form action="${otapp}/system/requiredpath/select_list.html" id="subform" method="post">
		<table  cellpadding="0" cellspacing="0"  bgColor="#cccccc" class="table" style="width:100%; top:2px;padding-top:1px;margin: 0px;border: 0px;">
	         <tr>
	           <th scope="row" class="tdleft" width="20%"><spring:message code="system.setting.requiredpath.query.condition.name" /></th>
	           <td width="80%" colspan="3" class="tdright" ><input name="reso.fsName" type="text" class="scinput" style="width: 200px;" value="${sysResource.fsName}" /></td>
	         </tr>
	         <tr>
	           <th scope="row" width="20%" class="tdleft"><spring:message code="system.setting.requiredpath.query.condition.key" /></th>
	           <td width="30%" class="tdright"><input name="reso.fsKey" type="text" class="scinput" value="${sysResource.fsKey}" /></td>
	           <th scope="row" width="20%" class="tdleft"><spring:message code="system.setting.requiredpath.query.condition.path" /></th>
	           <td width="30%" class="tdright"><input name="reso.fsUrl" type="text" class="scinput" value="${sysResource.fsUrl}" /></td>
	         </tr>
	         <tr>
	           <td width="100%" colspan="4" align="center" class="tdright">
	           	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
	           </td>
	         </tr>
	       </table>
		</form>
		<ec:table 
			items="resourceList" var="r"
			action="${otapp}/system/requiredpath/select_list.html"
			imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
			rowsDisplayed="5" autoIncludeParameters="true" cellpadding="1"
			filterable="false" locale="zh_CN" styleClass="table"
			style="width:100%;top: 0px;padding: 0px;margin: 0px;border: 0px;"
			>
			<ec:row>
				<ec:column property="fsId" title="system.setting.requiredpath.select" width="5%">
				<input type="radio" id="fsId" name="fsId" class="radioSel" value="${r.fsId}" onclick="javascript:seleResource('${r.fsId}','${r.fsName}');" />
				</ec:column> 
				<ec:column property="fsName" title="system.setting.requiredpath.fsName" width="30%" />
				<ec:column property="fsKey" title="system.setting.requiredpath.fsKey" width="25%" />
				<ec:column property="fsUrl" title="system.setting.requiredpath.fsUrl" width="35%" />
			</ec:row>
		</ec:table>
	
	</div>
</body>
</html>