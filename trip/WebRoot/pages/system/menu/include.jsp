<%@include file="../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
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
/**
 * @see 提交查询
 */
function queryForm(){
	$("#queryform").submit(); 
}

/**
 * @see 删除对象
 */
function del(id){
    $.post('${otapp}/system/menu/delete.html?json',{"id":id},function(data, textStatus){  
    	if("success"==textStatus&&data!=null&&"success"==data['operatorStateCode']){
    		alert('<spring:message code="common.operator.message.code.del.success" />');
    		parent.window.reloadTree();
    		location.replace("${otapp}/system/menu/include_menu.html?ma.fsId="+data['parentId']);
    	}else{
    		alert('<spring:message code="system.setting.menu.manager.delete.message.fail" />');
    	}
	},"json");
}

function deleteLinkButton(id){
	 $.post('${otapp}/system/menu/deleteLink.html?json',{"id":id},function(data, textStatus){  
    	if("success"==textStatus&&data!=null&&"success"==data['operatorStateCode']){
    		alert('<spring:message code="common.operator.message.code.del.success" />');
    		location.reload(true);
    	}else{
    		alert('<spring:message code="system.setting.menu.manager.delete.message.fail" />');
    	}
	},"json");
	
}

</script>
<body >
	<div class="col-md-12">
    	<h3 class="title">${cma.fsName}</h3>
  	</div>
    
	<div class="col-md-12">    
        <div class="col-md-4">
        <h4>
        	<span><spring:message code="system.setting.menu.manager.lab.menuInfo" /></span>
	        <ul class="toolbar1">
	        	<a href="javascript:del('${cma.fsId}');" class="easyui-linkbutton" data-options="iconCls:'icon-delExtBtn'"><spring:message code="common.button.del" /></a>
	        	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-editExtBtn'"><spring:message code="common.button.edit" /></a>
		        &nbsp;
		        <a href="${otapp}/system/menu/add_child_menu.html?parentMenuId=${cma.fsId}" class="easyui-linkbutton" data-options="iconCls:'icon-addMenuChild'"><spring:message code="system.setting.menu.manager.button.addChildMenu" /></a>
		        &nbsp;
	        </ul>
        </h4>
        <div class="con-right-right">         	
	       	<table width="90%" cellpadding="0" cellspacing="0" class="table">
	          <tr>
	            <th scope="row" width="20%"><spring:message code="system.setting.menu.manager.lab.name" /></th>
	            <td width="30%">${cma.fsName}</td>
	            <th scope="row" width="20%"><spring:message code="system.setting.menu.manager.lab.type" /></th>
	            <td width="30%">${cmat.fsName}</td>
	          </tr>
	          <tr>
	            <th scope="row" width="20%"><spring:message code="system.setting.menu.manager.lab.order" /></th>
	            <td width="30%">${cma.fnOrder}</td>
	            <th scope="row" width="20%"><spring:message code="system.setting.menu.manager.lab.status" /></th>
	            <td width="30%">
	            	<c:if test="${cma.fsStatus==1 }">
						<spring:message code="system.setting.menu.manager.display.status.yes" />
					</c:if>
					<c:if test="${cma.fsStatus==0 }">
						<spring:message code="system.setting.menu.manager.display.status.no" />
					</c:if>
				</td>
	          </tr>
	          <tr>
	            <th scope="row" width="20%"><spring:message code="system.setting.menu.manager.lab.resources" /></th>
	            <td width="80%" colspan="3">
					<spring:message code="system.setting.menu.manager.display.resources" arguments="${cmar.fsName},${cmar.fsKey},${cmar.fsUrl}" argumentSeparator="," />
				</td>
	          </tr>  
	          <tr>
	            <th scope="row" width="20%"><spring:message code="system.setting.menu.manager.lab.description" /></th>
	            <td width="80%" colspan="3">
	            	${cma.fsDescription}
	            </td>
	          </tr>  
	       </table>
	   </div>       
       </div>
    </div>
	<div class="col-md-12">    
        <div class="col-md-4">
        <h4>
        	<span><spring:message code="system.setting.menu.manager.required.lab.menuInfo" /></span>
        	
        </h4>
        <div class="con-right-right">   
        	<form id="queryform" method="post" action="${otapp}/system/menu/include_menu.html?ma.fsId=${cma.fsId}">	
	       	<table width="90%" cellpadding="0" cellspacing="0" class="table">
	          <tr>
	            <th scope="row" width="20%"><spring:message code="system.setting.menu.manager.required.condition.menuName" /></th>
	            <td width="80%" colspan="3"><input name="mv.menuName" type="text" class="scinput" value="${mv.menuName}" /></td>
	          </tr>
	          <tr>
	            <td width="100%" colspan="4" align="center">
	            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
	            </td>
	          </tr>
	       </table>
	       </form>      
			<ec:table 
				items="mvList" var="m"
				action="${otapp}/system/menu/include_menu.html"
				imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
				rowsDisplayed="5" autoIncludeParameters="true" cellpadding="1"
				filterable="false" locale="zh_CN">
				<ec:row>
					<ec:column property="menuId"
						title="system.setting.menu.select" width="4%">
						<input type="checkbox" id="menuId" name="menuId" value="${m.menuId}" />
					</ec:column>
					<ec:column property="menuName"
						title="system.setting.menu.menuName" width="10%" />
					<ec:column property="menuType"
						title="system.setting.menu.menuType" width="10%" />
					<ec:column property="menuResourceKey"
						title="system.setting.menu.menuResourceKey" width="20%" />
					<ec:column property="menuUrl"
						title="system.setting.menu.menuUrl" width="20%" />
					<ec:column property="menuStatus"
						title="system.setting.menu.menuStatus" width="10%" >
						<c:if test="${m.menuStatus==1 }">
							<spring:message code="system.setting.menu.manager.display.status.yes" />
						</c:if>
						<c:if test="${m.menuStatus==0 }">
							<spring:message code="system.setting.menu.manager.display.status.no" />
						</c:if>
					</ec:column>
					<ec:column property="tt" title="common.column.lab.operator" width="10%" style="align:center;" >
						<a href="#"><spring:message code="common.button.edit" /></a>
						<a href="javascript:deleteLinkButton('${m.menuId}');"><spring:message code="common.button.del" /></a>
					</ec:column>
				</ec:row>
			</ec:table>
	   </div>       
       </div><!--/col-md-4-->
    </div>

</body>
</html>