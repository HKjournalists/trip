<%@include file="../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	if("${r.fsStatus}"!=null){
		$("#fsStatus  option[value='${r.fsStatus}'] ").attr("selected",true);
	}
	
}); 

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

/**
 * @see 查看角色
 */
function view(id){
	alert(id);
}

/**
 * @see 新增角色
 */
function toAddRole(){
	var message='<spring:message code="system.setting.authority.message.select.parentRole" />';
	var selectParentRoleId=$('input[name="selFsId"]:checked').val();
	if(selectParentRoleId!=null&&selectParentRoleId.length>0){
		location.replace("${otapp}/system/role/toAdd.html?r.fsId="+selectParentRoleId);
	}else{
		alert(message);
	}
}

/**
 * @see 删除配置地址
 */
function del(id){
    $.post('${otapp}/system/role/delete.html?json',{"roleId":id},function(data, textStatus){  
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
			<li><a href="#"><spring:message code="system.setting.position.authority.config" /></a></li>
			<li><a href="#"><spring:message code="system.setting.position.authority.role.config" /></a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
		        <h4>
		        	<span><spring:message code="system.setting.position.authority.role.config" /></span>
		        	<ul class="toolbar1" >
			        <a href="javascript:toAddRole();" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="system.setting.authority.button.role.add" /></a>
			        &nbsp;
			        </ul>
		        </h4>
				<form action="${otapp}/system/role/manager.html" method="post" id="subform">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		            <th scope="row" width="20%"><spring:message code="system.setting.authority.role.query.fsName" /></th>
		            <td width="80%" colspan="3"><input name="r.fsName" type="text" class="scinput" value="${r.fsName}" /></td>
		          </tr>
		          <tr>
		            <th scope="row" width="20%"><spring:message code="system.setting.authority.role.query.fsStatus" /></th>
		            <td width="30%" >
		            	<%-- <input name="r.fnOrder" type="text" class="scinput" value="${r.fnOrder}" /> --%>
		            	<select name="r.fsStatus" id="fsStatus">
		            		<option value="0"><spring:message code="system.setting.authority.role.status.no" /></option>
		            		<option value="1"><spring:message code="system.setting.authority.role.status.yes" /></option>
		            	</select>
		            </td>
		             <th scope="row" width="20%"><spring:message code="system.setting.authority.role.query.fsSign" /></th>
		            <td width="30%" ><input name="r.fsSign" type="text" class="scinput" value="${r.fsSign}" /></td>
		          </tr>
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				<ec:table 
					items="roleList" var="rl"
					action="${otapp}/system/role/manager.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="6" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fsId" title="system.setting.role.list.select" width="5%"  >
							<input type="radio"  name="selFsId" value="${rl.fsId }" />
						</ec:column>
						<ec:column property="fsName" title="system.setting.role.list.fsName" width="25%" />
						<ec:column property="fnOrder" title="system.setting.role.list.fnOrder" width="5%" />
						<ec:column property="fsSign" title="system.setting.role.list.fsSign" width="15%" />
						<ec:column property="fsStatus" title="system.setting.role.list.fsStatus" width="15%" >
							<c:if test="${rl.fsStatus==0 }">
								<spring:message code="system.setting.authority.role.status.no" />
							</c:if>
							<c:if test="${rl.fsStatus==1 }">
								<spring:message code="system.setting.authority.role.status.yes" />
							</c:if>
						</ec:column>
						<ec:column property="fsParentName" title="system.setting.role.list.fsParent" width="25%" />
						<ec:column property="tt" title="common.column.lab.operator" width="10%" style="align:center;" >
							<a href="#"><spring:message code="common.button.edit" /></a>
							<a href="javascript:del('${rl.fsId}');"><spring:message code="common.button.del" /></a>
							<a href="javascript:view('${rl.fsId}');"><spring:message code="common.button.view" /></a>
						</ec:column>
						
					</ec:row>
				</ec:table>
			</div>
		</div>
	</div>
</body>
</html>