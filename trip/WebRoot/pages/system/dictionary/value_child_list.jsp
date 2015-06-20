<%@include file="../../general/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript"
	src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${otapp}/css/self/common-form.css" />
<script type="text/javascript"
	src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	
}); 

/**
 * @see 查询字典
 */
function queryForm(){
	$("#subform").submit(); 
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

//Math.random()
</script>
<body style="width: 100%;height: auto;">
<div class="col-md-12">    
	        	<div class="col-md-4">
	<h4>
		<span><spring:message code="system.configure.manager.dictionary.value.child.title" arguments="${parentDivName}" /></span>
		<ul class="toolbar1">&nbsp;</ul>
	</h4>
	<form action="${otapp}/system/dictionary_value/child_list.html"
		method="post" id="subform">
		<input type="hidden" id="parentDivId" name="parentDivId" value="${parentDivId}" />
		<table width="100%" cellpadding="0" cellspacing="0" class="table">
			<tr>
				<th scope="row" width="20%"><spring:message
						code="system.configure.manager.dictionary.value.query.name" /></th>
				<td width="30%" colspan="1"><input name="dv。fsName" type="text"
					class="scinput" value="${dv.fsName}" /></td>
				<th scope="row" width="20%"><spring:message
						code="system.configure.manager.dictionary.value.query.value" /></th>
				<td width="30%" colspan="1"><input name="dv.fsValue"
					type="text" class="scinput" value="${dv.fsName}" /></td>
			</tr>
			<tr>
				<th scope="row" width="20%"><spring:message
						code="system.configure.manager.dictionary.value.query.type" /></th>
				<td width="80%" colspan="3"><select
					name="dv.sysDictionaryType.fsId" id="typeId">
						<option value=""><spring:message code="common.select.opt.pls" /></option>
						<c:if test="${selTypeList!=null&&selTypeList.size()>0}">
							<c:forEach items="${selTypeList}" var="st">
								<option value="${st.fsId}">${st.fsName}</option>
							</c:forEach>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<td width="100%" colspan="4" align="center"><a
					href="javascript:queryForm();" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message
							code="common.button.query" /></a></td>
			</tr>
		</table>
	</form>
	<ec:table items="childDvList" var="dvv"
		action="${otapp}/system/dictionary_value/child_list.html"
		imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
		rowsDisplayed="6" autoIncludeParameters="true" cellpadding="1"
		filterable="false" locale="zh_CN">
		<ec:row>
			<ec:column property="fsId"
				title="system.configure.manager.dictionary.value.select" width="5%">
				<input type="radio" id="fsId" name="fsId" class="radioSel"
					value="${dvv.fsId}" />
			</ec:column>
			<ec:column property="fnSort"
				title="system.configure.manager.dictionary.value.fnSort" width="10%" />
			<ec:column property="fsName"
				title="system.configure.manager.dictionary.value.fsName" width="35%" />
			<ec:column property="fsValue"
				title="system.configure.manager.dictionary.value.fsValue"
				width="20%" />
			<ec:column property="sysDictionaryType.fsName" title="system.configure.manager.dictionary.value.fsTypeName" width="20%" />
			<ec:column property="tt" title="common.column.lab.operator"
				width="10%" style="align:center;">
				<a href="#"><spring:message code="common.button.edit" /></a>
				<a href="javascript:del('${dvv.fsId}');"><spring:message
						code="common.button.del" /></a>
			</ec:column>

		</ec:row>
	</ec:table>
	</div>
</div>
</body>
</html>