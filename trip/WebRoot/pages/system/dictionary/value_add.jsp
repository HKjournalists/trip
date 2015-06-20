<%@include file="../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/css/display/display.css" /> 
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
$(document).ready(function(){
	var statusCode="${operatorStateCode}";
	if(statusCode!=null&&"success"==statusCode){
		alert('<spring:message code="common.operator.message.code.add.success" />');
		location.replace("${otapp}/system/dictionary_value/manager.html");
	}
});
/**
 * @see 提交数据
 */
function submitForm(){
	$("#addForm").submit(); 
}

function resetForm(){
	$("#addForm").reset(); 
}

function selectDicttype(){
	$('#wr').window('open')
}

function closeDicttypeWindow(){
	$('#wr').window('close')
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
		<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
			<tr><td>
				<h5>
		        	<span><spring:message code="system.configure.manager.dictionary.value.add.title" /></span>
		        </h5>
			</td></tr>
			<tr><td>
				<form id="addForm" method="post" action="${otapp}/system/dictionary_value/save.html">
				<table width="100%" cellpadding="0" cellspacing="0" class="table" style="width: 100%; top: 0px;"  >
					<tr>
		    			<th width="30%"><spring:message code="system.configure.manager.dictionary.value.add.fsName" /></th>
		    			<td width="70%"><input class="easyui-textbox" type="text" name="dv.fsName" data-options="required:true" style="width:350px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="30%"><spring:message code="system.configure.manager.dictionary.value.add.fsValue" /></th>
		    			<td width="70%" ><input class="easyui-textbox" type="text" name="dv.fsValue" data-options="required:true" style="width:350px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="30%"><spring:message code="system.configure.manager.dictionary.value.add.fnSort" /></th>
		    			<td width="70%" ><input class="easyui-textbox" type="text" name="dv.fnSort" data-options="required:true" style="width:350px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="30%"><spring:message code="system.configure.manager.dictionary.value.add.fsDType" /></th>
		    			<td width="70%" >
		    				<input  id="selDivTypeId" type="hidden" name="dv.sysDictionaryType.fsId" data-options="required:false" style="width:150px;" />
		    				<input  id="disType" type="text" name="disType" readonly="readonly" data-options="required:false" style="width:150px;" />
		    				<img src="${otapp}/plug/jquery-easyui/themes/icons/btnsel.gif" onclick="javascript:selectDicttype();" alt="<spring:message code="system.configure.manager.dictionary.value.btn.selectDictType" />"/>
		    			</td>
		    		</tr>
		    		<tr>
		    			<th  width="30%"><spring:message code="system.configure.manager.dictionary.value.add.parentDicv" /></th>
		    			<td width="70%" >
		    				<c:if test="${parentDicv!=null&&parentDicv.fsId!=null}">
		    					<input type="hidden" id="dv.fsParentId" name="dv.fsParentId" value="${parentDicv.fsId }" />
		    					${parentDicv.fsName}
		    				</c:if>
		    				<c:if test="${parentDicv==null||parentDicv.fsId==null}">
		    					<spring:message code="system.configure.manager.dictionary.value.root.msg" />
		    				</c:if>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td colspan="2" align="center" >
		    				<div style="text-align:center;padding:5px">
		    				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()"><spring:message code="common.button.add.submit" /></a>
		    				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="resetForm()"><spring:message code="common.button.add.clear" /></a>
		    				</div>
		    			</td>
		    		</tr>
				</table>
				</form>
			</td></tr>
		</table>
	</div>
	
	<div id="wr" align="center" class="easyui-window" title='<spring:message code="system.configure.manager.dictionary.value.btn.selectDictType"/>'  data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:800px;height:350px;padding:0px;">
		<br>
		<iframe id="selectList" src="${otapp}/system/dictionary_type/select.html" width="765px" height="100%" frameborder="0" border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" ></iframe>
	</div>
</body>
</html>