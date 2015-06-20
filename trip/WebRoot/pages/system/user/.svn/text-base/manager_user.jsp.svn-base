<%@include file="../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	
}); 

/**
 * @see æäº¤æ¥è¯¢
 */
function queryForm(){
	$("#subform").submit(); 
}

/**
 * @see æ°å¢è§è²
 */
function toAddUser(){
	location.replace("${otapp}/system/user/manager_user_to_add.html");
}


</script>
<body>
	<div class="place">
		<span><spring:message code="common.content.lab.position" /></span>
		<ul class="placeul">
			<li><a href="#"><spring:message code="system.setting.position.system.config" /></a></li>
			<li><a href="#"><spring:message code="system.user.manager.position.menu.user" /></a></li>
			<li><a href="#"><spring:message code="system.user.manager.position.lab.user" /></a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
		        <h4>
		        	<span><spring:message code="system.user.manager.position.lab.user" /></span>
		        	<ul class="toolbar1" >
			        <a href="javascript:toAddUser();" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="system.user.manager.btn.add.user" /></a>
			        &nbsp;
			        </ul>
		        </h4>
				<form action="${otapp}/system/user/manager_user.html" method="post" id="subform">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		            <th scope="row" width="20%"><spring:message code="system.user.manager.lab.name" /></th>
		            <td width="80%" colspan="3"><input name="su.fsName" type="text" class="scinput" value="${su.fsName}" /></td>
		          </tr>
		          <tr>
		            <th scope="row" width="20%"><spring:message code="system.user.manager.lab.email" /></th>
		            <td width="30%" >
		            	<input name="su.fsEmail" type="text" class="scinput" value="${su.fsEmail}" />
		            </td>
		             <th scope="row" width="20%"><spring:message code="system.user.manager.lab.phone" /></th>
		            <td width="30%" ><input name="su.fsPhone" type="text" class="scinput" value="${su.fsPhone}" /></td>
		          </tr>
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				<ec:table 
					items="managerUserList" var="mu"
					action="${otapp}/system/user/manager_user.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="6" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fsId" title="system.user.manager.list.select" width="5%"  >
							<input type="radio"  name="selFsId" value="${mu.fsId }" />
						</ec:column>
						<ec:column property="fsAccount" title="system.user.manager.list.account" width="25%" />
						<ec:column property="fsName" title="system.user.manager.list.name" width="5%" />
						<ec:column property="fsEmail" title="system.user.manager.list.email" width="15%" />
						<ec:column property="fsPhone" title="system.user.manager.list.phone" width="15%" />
						<ec:column property="tt" title="common.column.lab.operator" width="10%" style="align:center;" >
							<a href="#"><spring:message code="common.button.edit" /></a>
							<a href="javascript:del('${mu.fsId}');"><spring:message code="common.button.del" /></a>
							<a href="javascript:view('${mu.fsId}');"><spring:message code="common.button.view" /></a>
						</ec:column>
						
					</ec:row>
				</ec:table>
			</div>
		</div>
	</div>
</body>
</html>