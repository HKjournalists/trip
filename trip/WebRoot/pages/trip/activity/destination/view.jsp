<%@include file="../../../general/header.jsp"%>
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

function deleteDestination(id){
	 $.post('${otapp}/system/menu/deleteChild.html?json',{"id":id},function(data, textStatus){  
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
    	<h3 class="title">${ad.fsName}</h3>
  	</div>
     
	<div class="col-md-12">    
        <div class="col-md-4">
        <h4>
        	<span><spring:message code="trip.manager.destination.view.title" /></span>
	        <ul class="toolbar1">
	        	<a href="javascript:del('${ad.fsId}');" class="easyui-linkbutton" data-options="iconCls:'icon-delExtBtn'"><spring:message code="common.button.del" /></a>
	        	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-editExtBtn'"><spring:message code="common.button.edit" /></a>
		        &nbsp;
		         <a href="${otapp}/trip/activity/destination/add_child_destination.html?ad.fsParentId=root" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="trip.manager.destination.view.button.addRootDestination" /></a>
		        <a href="${otapp}/trip/activity/destination/add_child_destination.html?ad.fsParentId=${ad.fsId}" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="trip.manager.destination.view.button.addChildDestination" /></a>
		        &nbsp;
	        </ul>
        </h4>
  
        <div class="con-right-right">         	
	       	<table width="90%" cellpadding="0" cellspacing="0" class="table">
	          <tr>
	            <th scope="row" width="20%"><spring:message code="trip.manager.destination.view.fsName" /></th>
	            <td width="30%">${ad.fsName}</td>
	            <th scope="row" width="20%"><spring:message code="trip.manager.destination.view.fsValue" /></th>
	            <td width="30%">${ad.fsValue}</td>
	          </tr>
	          <tr>
	            <th scope="row" width="20%"><spring:message code="trip.manager.destination.view.parentName" /></th>
	            <td width="30%">
	            	<c:if test="${pad!=null}">${pad.fsName}</c:if>
	            	<c:if test="${pad==null}"><spring:message code="trip.manager.destination.view.isRoot"></spring:message></c:if>
	            </td>
	            <th scope="row" width="20%"><spring:message code="trip.manager.destination.view.type" /></th>
	            <td width="30%">
	            	<c:if test="${ad.otActiDestinationType!=null&&ad.otActiDestinationType.fsName!=null&&ad.otActiDestinationType.fsName!=''}">
	            		${ad.otActiDestinationType.fsName}
	            	</c:if>
				</td>
	          </tr>
	           <tr>
	            <th scope="row" width="20%"><spring:message code="trip.manager.destination.view.latitude" /></th>
	            <td width="30%">${ad.fsLatitude}</td>
	            <th scope="row" width="20%"><spring:message code="trip.manager.destination.view.longititude" /></th>
	            <td width="30%">${ad.fsLongitudel}</td>
	          </tr>
	       </table>
	   </div>       
       </div>
    </div>
         
	<div class="col-md-12">    
        <div class="col-md-4">
        <h4>
        	<span><spring:message code="trip.manager.destination.view.lab.childDestination" /></span>
        </h4>
        <div class="con-right-right">   
        	<form id="queryform" method="post" action="${otapp}/trip/activity/destination/view.html?ad.fsId=${ad.fsId}">	
	       	<table width="90%" cellpadding="0" cellspacing="0" class="table">
	          <tr>
	            <th scope="row" width="20%"><spring:message code="trip.manager.destination.view.fsName" /></th>
	            <td width="80%" colspan="3"><input name="queryDestinationName" type="text" class="scinput" value="${queryDestinationName}" /></td>
	          </tr>
	          <tr>
	            <td width="100%" colspan="4" align="center">
	            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
	            </td>
	          </tr>
	       </table>
	       </form>      
			<ec:table 
				items="listChildsDestination" var="lad"
				action="${otapp}/trip/activity/destination/view.html"
				imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
				rowsDisplayed="10" autoIncludeParameters="true" cellpadding="1"
				filterable="false" locale="zh_CN">
				<ec:row>
					<ec:column property="fsId"
						title="trip.manager.destination.list.select" width="4%">
						<input type="checkbox" id="childDestinationId" name="childDestinationId" value="${lad.fsId}" />
					</ec:column>
					<ec:column property="fsName" title="trip.manager.destination.list.fsName" width="10%" />
					<ec:column property="fsValue" title="trip.manager.destination.list.fsValue" width="10%" />
					<ec:column property="selDestination.otActiDestinationType.fsName" title="trip.manager.destination.list.fsType" width="20%" />
					<ec:column property="fsLatitude" title="trip.manager.destination.list.fsLatitude" width="20%" />
					<ec:column property="fsLongitudel" title="trip.manager.destination.list.fsLongitudel" width="10%" >
					</ec:column>
					<ec:column property="tt" title="common.column.lab.operator" width="10%" style="align:center;" >
						<a href="#"><spring:message code="common.button.edit" /></a>
						<a href="javascript:deleteDestination('${lad.fsId}');"><spring:message code="common.button.del" /></a>
					</ec:column>
				</ec:row>
			</ec:table>
	   </div>       
       </div><!--/col-md-4-->
    </div>


</body>
</html>