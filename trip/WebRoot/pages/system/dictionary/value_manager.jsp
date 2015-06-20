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
 * @see 查询字典
 */
function queryForm(){
	$("#subform").submit(); 
}

/**
 * @see  新增字典值
 */
function toAddValue(){
	
	var selFsId=$('input[name="selFsId"]:checked').val();
	if(typeof(selFsId)!='undefined'&&selFsId!=null&&selFsId!=''&&selFsId.length>0){
		$("#subform").attr("action","${otapp}/system/dictionary_value/to_add.html?parentDivId="+selFsId+"");
		$("#subform").submit(); 
	}else{
		if(confirm('<spring:message code="system.configure.manager.dictionary.value.btn.noParentId" />')){
			$("#subform").attr("action", "${otapp}/system/dictionary_value/to_add.html?parentDivId=''");
			$("#subform").submit(); 
		}	
	}
}
//Math.random()

function changeChildDictionary(dvid) {
	if(typeof(dvid)!='undefined'&&dvid!=null&&dvid!=''&&dvid.length>0){
		$("#childDictValueList").attr("src","${otapp}/system/dictionary_value/child_list.html?parentDivId="+dvid+"");
	}else{
		$("#childDictValueList").attr("src","${otapp}/system/dictionary_value/child_list.html?parentDivId=0");
	}
	
}

function del(id){
    $.post('${otapp}/system/dictionary_value/delete.html?json',{"id":id},function(data, textStatus){  
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
		<li><a href="#"><spring:message
					code="system.setting.position.system.config" /></a></li>
		<li><a href="#"><spring:message
					code="system.configure.manager.position.title" /></a></li>
		<li><a href="#"><spring:message
					code="system.configure.manager.dictionary.value.position.title" /></a></li>
	</ul>
</div>
<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
		        <h4>
		        	<span><spring:message code="system.configure.manager.dictionary.value.position.title" /></span>
		        	<ul class="toolbar1">
		        	<a href="javascript:toAddValue();" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="system.configure.manager.dictionary.value.btn.add" /></a>
			        &nbsp;
			        </ul>
		        </h4>
				<form action="${otapp}/system/dictionary_value/manager.html" method="post" id="subform">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		            <th scope="row" width="20%"><spring:message code="system.configure.manager.dictionary.value.query.name" /></th>
		            <td width="30%" colspan="1"><input name="dv。fsName" type="text" class="scinput" value="${dv.fsName}" /></td>
		            <th scope="row" width="20%"><spring:message code="system.configure.manager.dictionary.value.query.value" /></th>
		            <td width="30%" colspan="1"><input name="dv.fsValue" type="text" class="scinput" value="${dv.fsName}" /></td>
		          </tr>
		           <tr>
		            <th scope="row" width="20%"><spring:message code="system.configure.manager.dictionary.value.query.type" /></th>
		            <td width="80%" colspan="3">
		            	<otrip:dictionaryTypeSelect selname="dv.sysDictionaryType.fsId" selid="typeId"></otrip:dictionaryTypeSelect>
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
					items="allDvList" var="dvv"
					action="${otapp}/system/dictionary_value/manager.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="6" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fsId" title="system.configure.manager.dictionary.value.select" width="5%" >
							<input type="radio" id="selFsId" name="selFsId" class="radioSel" value="${dvv.fsId}" onclick="javascript:changeChildDictionary('${dvv.fsId}');" />
						</ec:column>
						<ec:column property="fnSort" title="system.configure.manager.dictionary.value.fnSort" width="5%" />
						<ec:column property="fsName" title="system.configure.manager.dictionary.value.fsName" width="25%" />
						<ec:column property="fsValue" title="system.configure.manager.dictionary.value.fsValue" width="20%" />
						<ec:column property="sysDictionaryType.fsName" title="system.configure.manager.dictionary.value.fsTypeName" width="20%" />
						<ec:column property="tt" title="common.column.lab.operator" width="10%" style="align:center;" >
							<a href="#"><spring:message code="common.button.edit" /></a>
							<a href="javascript:del('${dvv.fsId}');"><spring:message code="common.button.del" /></a>
						</ec:column>
						
					</ec:row>
				</ec:table>
			</div>
		</div>
		<!-- 子字典关系字典 -->
		<iframe id="childDictValueList" src="${otapp}/system/dictionary_value/child_list.html?parentDivId=0" width="100%" height="500px;" frameborder = "0", border="0" marginheight="0",marginwidth = "0" style="margin: 0xp;border: 0px;padding: 0px;" scrolling="no"></iframe>

</body>
</html>