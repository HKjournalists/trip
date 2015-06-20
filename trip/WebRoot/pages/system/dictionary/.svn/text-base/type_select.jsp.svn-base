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


function selectDttype(tid,tname){
	$('#selDivTypeId', window.parent.document).val(tid);
	$('#disType', window.parent.document).val(tname);
	/* $('#wr',window.parent).window('close'); */
	window.parent.closeDicttypeWindow();
}
</script>
<body style="margin: 0px;padding: 0px;">
	<div style="width:100%;margin: 0px;padding: 0px;left: 2px;border: 0px;top: 10px;" >
		<form action="${otapp}/system/dictionary_type/select.html" method="post" id="subform">
		<table cellpadding="0" cellspacing="0"  bgColor="#cccccc" class="table" style="width:100%; top:2px;padding-top:1px;margin: 0px;border: 0px;">
          <tr>
            <th scope="row" class="tdleft" width="20%"><spring:message code="system.configure.manager.dictionary.type.query.fsName" /></th>
            <td width="30%" colspan="1" class="tdright" ><input name="dt.fsName" type="text" class="scinput" value="${dt.fsName}" /></td>
            <th scope="row" class="tdleft" width="20%"><spring:message code="system.configure.manager.dictionary.type.query.fsSign" /></th>
            <td width="30%" colspan="1" class="tdright" ><input name="dt.fsSign" type="text" class="scinput" value="${dt.fsSign}" /></td>
          </tr>
          <tr>
            <td width="100%" colspan="4" align="center" class="tdright">
            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
            </td>
          </tr>
        </table>
		</form>
		<ec:table 
			items="dtList" var="dtv"
			action="${otapp}/system/dictionary_type/select.html"
			imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
			rowsDisplayed="6" autoIncludeParameters="true" cellpadding="1"
			filterable="false" locale="zh_CN">
			<ec:row>
				<ec:column property="fsId" title="system.configure.manager.dictionary.value.select.type" width="5%">
					<input type="radio" id="fsId" name="fsId" class="radioSel" value="${dtv.fsId}" onclick="javascript:selectDttype('${dtv.fsId}','${dtv.fsName}');" />
				</ec:column> 
				<ec:column property="fsName"
					title="system.configure.manager.dictionary.type.fsName" width="45%" />
				<ec:column property="fsSign" title="system.configure.manager.dictionary.type.fsSign" width="35%" >
				</ec:column>
				<ec:column property="fsStatus" title="system.configure.manager.dictionary.type.fsStatus" width="10%" >
					<c:if test="${dtv.fsStatus==0 }"><spring:message code="common.code.status.no"></spring:message></c:if>
					<c:if test="${dtv.fsStatus==1 }"><spring:message code="common.code.status.yes"></spring:message></c:if>
				</ec:column>
				
				
			</ec:row>
		</ec:table>
	</div>
</body>
</html>