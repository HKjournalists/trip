<%@include file="../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var statusCode="${operatorStateCode}";
	if(statusCode!=null&&"success"==statusCode){
		alert('<spring:message code="common.operator.message.code.add.success" />');
		location.replace("${otapp}/system/menutype/list.html");
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
		<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
			<tr><td>
				<h5>
		        	<span><spring:message code="system.setting.menutype.add.lab.title" /></span>
		        </h5>
			</td></tr>
			<tr><td>
				<form id="addForm" method="post" action="${otapp}/system/menutype/save.html">
				<table width="100%" cellpadding="0" cellspacing="0" class="table" style="width: 100%; top: 0px;"  >
					<tr>
		    			<th width="30%"><spring:message code="system.setting.menutype.add.lab.name" /></th>
		    			<td width="70%"><input class="easyui-textbox" type="text" name="mt.fsName" data-options="required:true" style="width:350px;"></input></td>
		    		</tr>
		    		<tr>
		    			<th  width="30%"><spring:message code="system.setting.menutype.add.lab.sign" /></th>
		    			<td width="70%" ><input class="easyui-textbox" type="text" name="mt.fsSign" data-options="required:true" style="width:350px;"></input></td>
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
</body>
</html>