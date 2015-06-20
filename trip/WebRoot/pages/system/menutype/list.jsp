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
 * @see 删除菜单类型
 */
function del(id){
    $.post('${otapp}/system/menutype/delete.html?json',{"id":id},function(data, textStatus){  
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
			<li><a href="#"><spring:message code="system.setting.position.menutype.config" /></a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
		        <h4>
		        	<span><spring:message code="system.setting.position.menutype.config" /></span>
		        	<ul class="toolbar1">
			        <a href="${otapp}/system/menutype/toAdd.html" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="system.setting.menutype.button.add" /></a>
			        &nbsp;
			        </ul>
		        </h4>
				<form action="${otapp}/system/menutype/list.html" method="post" id="subform">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		            <th scope="row" width="20%"><spring:message code="system.setting.menutype.query.condition.name" /></th>
		            <td width="80%" colspan="3"><input name="mt.fsName" type="text" class="scinput" value="${sysMenuType.fsName}" /></td>
		          </tr>
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				<ec:table 
					items="menuTypeList" var="m"
					action="${otapp}/system/menutype/list.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="6" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<%-- <ec:column property="fsId"
							title="system.setting.menutype.select" width="5%">
							<input type="checkbox" id="fsId" name="fsId" value="${m.fsId}" />
						</ec:column> --%>
						<ec:column property="fsName"
							title="system.setting.menutype.fsName" width="45%" />
						<ec:column property="fsSign"
							title="system.setting.menutype.fsSign" width="35%" >
						</ec:column>
						<ec:column property="tt" title="common.column.lab.operator" width="20%" style="align:center;" >
							<a href="#"><spring:message code="common.button.edit" /></a>
							<a href="javascript:del('${m.fsId}');"><spring:message code="common.button.del" /></a>
						</ec:column>
						
					</ec:row>
				</ec:table>
			</div>
		</div>
	</div>
</body>
</html>