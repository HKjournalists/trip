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
    $.post('${otapp}/system/manager_log/delete_login_log.html?json',{"id":id},function(data, textStatus){  
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
			<li><a href="#"><spring:message code="system.log.manager.position.title" /></a></li>
			<li><a href="#"><spring:message code="system.log.manager.login.position.title" /></a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
		        <h4>
		        	<span><spring:message code="system.log.manager.login.position.title" /></span>
		        	<ul class="toolbar1"> </ul>
		        </h4>
				<form action="${otapp}/system/manager_log/manager_login_log.html" method="post" id="subform">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <%-- <tr>
		            <th scope="row" width="20%"><spring:message code="system.log.manager.login.query.logintime" /></th>
		            <td width="30%" colspan="1"><input name="lh.fdLoginTime" type="text" class="scinput" value="${lh.fdLoginTime}" /></td>
		            <th scope="row" width="20%"><spring:message code="system.log.manager.login.query.logouttime" /></th>
		            <td width="30%" colspan="1"><input name="lh.fdLogoutTime" type="text" class="scinput" value="${lh.fdLogoutTime}" /></td>
		          </tr> --%>
		          <tr>
		            <th scope="row" width="20%"><spring:message code="system.log.manager.login.query.loginIp" /></th>
		            <td width="30%" colspan="1"><input name="lh.fsIp" type="text" class="scinput" value="${lh.fsIp}" /></td>
		            <th scope="row" width="20%"><spring:message code="system.log.manager.login.query.loginUserName" /></th>
		            <td width="30%" colspan="1">
		            	<c:if test="${lh!=null&&lh.sysUser!=null }"><input name="lh.sysUser.fsName" type="text" class="scinput" value="${lh.sysUser.fsName}" /></c:if>
		            	<c:if test="${lh==null||lh.sysUser==null }"><input name="lh.sysUser.fsName" type="text" class="scinput"  /></c:if>
		            </td>
		          </tr>
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				<ec:table 
					items="lhList" var="lhv"
					action="${otapp}/system/manager_log/manager_login_log.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="6" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fdLoginTime" title="system.log.manager.login.list.logintime" width="20%" />
						<ec:column property="fdLogoutTime" title="system.log.manager.login.list.logouttime" width="20%" />
						<ec:column property="fsIp" title="system.log.manager.login.list.loginIp" width="20%" ></ec:column>
						<ec:column property="sysUser.fsName" title="system.log.manager.login.list.loginUserName" width="20%" ></ec:column>
						<ec:column property="tt" title="common.column.lab.operator" width="10%" style="align:center;" >
							<a href="javascript:del('${lhv.fsId}');"><spring:message code="common.button.del" /></a>
						</ec:column>
						
					</ec:row>
				</ec:table>
			</div>
		</div>
	</div>
</body>
</html>