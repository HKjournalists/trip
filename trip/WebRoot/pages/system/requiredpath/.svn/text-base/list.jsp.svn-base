<%@include file="../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

/**
 * @see 提交查询
 */
function queryForm(){
	$("#subform").submit(); 
}

/**
 * @see 删除配置地址
 */
function del(id){
    $.post('${otapp}/system/requiredpath/delete.html?json',{"id":id},function(data, textStatus){  
    	if("success"==textStatus&&data!=null&&"success"==data['operatorStateCode']){
    		alert('<spring:message code="common.operator.message.code.del.success" />');
    		location.reload(true);
    	}else{
    		alert('<spring:message code="common.operator.message.code.del.fail" />');
    	}
	},"json");
}
</script>
<body>
	<div class="place">
		<span><spring:message code="common.content.lab.position" /></span>
		<ul class="placeul">
			<li><a href="#"><spring:message code="system.setting.position.system.config" /></a></li>
			<li><a href="#"><spring:message code="system.setting.position.resources.config" /></a></li>
			<li><a href="#"><spring:message code="system.setting.position.requiredpath.config" /></a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
		        <h4>
		        	<span><spring:message code="system.setting.position.requiredpath.config" /></span>
		        	<ul class="toolbar1">
			        <a href="${otapp}/system/requiredpath/toAdd.html" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="system.setting.requiredpath.button.add" /></a>
			        &nbsp;
			        </ul>
		        </h4>
				<form action="${otapp}/system/requiredpath/list.html" id="subform" method="post">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		            <th scope="row" width="20%"><spring:message code="system.setting.requiredpath.query.condition.name" /></th>
		            <td width="80%" colspan="3"><input name="reso.fsName" type="text" class="scinput" style="width: 200px;" value="${sysResource.fsName}" /></td>
		          </tr>
		          <tr>
		            <th scope="row" width="20%"><spring:message code="system.setting.requiredpath.query.condition.key" /></th>
		            <td width="30%" ><input name="reso.fsKey" type="text" class="scinput" value="${sysResource.fsKey}" /></td>
		            <th scope="row" width="20%"><spring:message code="system.setting.requiredpath.query.condition.path" /></th>
		            <td width="30%" ><input name="reso.fsUrl" type="text" class="scinput" value="${sysResource.fsUrl}" /></td>
		          </tr>
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				<ec:table 
					items="resourceList" var="r"
					action="${otapp}/system/requiredpath/list.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="6" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fsName" title="system.setting.requiredpath.fsName" width="30%" />
						<ec:column property="fsKey" title="system.setting.requiredpath.fsKey" width="25%" />
						<ec:column property="fsUrl" title="system.setting.requiredpath.fsUrl" width="35%" />
						<ec:column property="tt" title="common.column.lab.operator" width="10%" style="align:center;" >
							<a href="#"><spring:message code="common.button.edit" /></a>
							<a href="javascript:del('${r.fsId}');"><spring:message code="common.button.del" /></a>
						</ec:column>
					</ec:row>
			</ec:table>
			</div>
		</div>
	</div>
</body>
</html>