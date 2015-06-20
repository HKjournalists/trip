<%@include file="../../general/header.jsp"%>
<link href="${otapp}/plug/eXtremeComponents/script/extremecomponents.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common.css" /> 
 
<script type="text/javascript">
$(document).ready(function(){
	$("#menuSettingTree").load(function(){
	    $(this).height(0); //用于每次刷新时控制IFRAME高度初始化
	    var height = $(this).contents().height() + 10;
	    $(this).height( height < 450 ? 450 : height );
	}); 
	
	$("#menuSettingConetnt").load(function(){
	    $(this).height(0); //用于每次刷新时控制IFRAME高度初始化
	    var height = $(this).contents().height() + 10;
	    $(this).height( height < 450 ? 450 : height );
	});
	
}); 

/**
 * @see 刷新菜单树
 */
function reloadTree(){
	$('#menuSettingTree').attr('src', $('#menuSettingTree').attr('src'));
}
</script>  

<body >
<div class="place">
	<span><spring:message code="common.content.lab.position" /></span>
	<ul class="placeul">
		<li><a href="#"><spring:message
					code="system.setting.position.system.config" /></a></li>
		<li><a href="#"><spring:message
					code="system.setting.position.resources.config" /></a></li>
		<li><a href="#"><spring:message
					code="system.setting.position.menu.manager" /></a></li>
	</ul>
</div>
<div id="container">   
	<div id="menu">
	<h4 class="con-tlt"><span></span><spring:message code="system.setting.menu.manager.treeLab" /></h4>
	<iframe id="menuSettingTree" src="${otapp}/system/menu/menu_manager.html" width="100%" height="420px" frameborder="0" border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  ></iframe> 
	</div>  
	<div id="content">
		<iframe id="menuSettingConetnt" src="${otapp}/system/menu/include_menu.html?ma.fsId=${mainMenu.fsId}" width="100%" height="445px" frameborder="0" border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  ></iframe> 
	</div>
</div>
</body>
</html>