<%@include file="../../../general/header.jsp"%>
<link href="${otapp}/plug/eXtremeComponents/script/extremecomponents.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common.css" /> 
 
<script type="text/javascript">
$(document).ready(function(){
	$("#destinationFrameTree").load(function(){
	    $(this).height(0); //用于每次刷新时控制IFRAME高度初始化
	    var height = $(this).contents().height() + 10;
	    $(this).height( height < 450 ? 450 : height );
	}); 
	
	$("#destinationConetnt").load(function(){
	    $(this).height(0); //用于每次刷新时控制IFRAME高度初始化
	    var height = $(this).contents().height() + 10;
	    $(this).height( height < 450 ? 450 : height );
	});
	
}); 

/**
 * @see 刷新菜单树
 */
function reloadTree(){
	$('#destinationFrameTree').attr('src', $('#destinationFrameTree').attr('src'));
}
</script>  

<body >
<div class="place">
	<span><spring:message code="common.content.lab.position" /></span>
	<ul class="placeul">
		<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message
					code="trip.manager.position.modul" /></a></li>
		<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message
					code="trip.manager.position.travel.activity" /></a></li>
		<li><a href="#"><spring:message
					code="trip.manager.position.destination.manager" /></a></li>
	</ul>
</div>
<div id="container">   
	<div id="menu">
	<h4 class="con-tlt"><span></span><spring:message code="trip.manager.destination.Distribute" /></h4>
	<iframe id="destinationFrameTree" src="${otapp}/trip/activity/destination/tree.html" width="100%" height="420px" frameborder="0" border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  ></iframe> 
	</div>  
	<div id="content">
		<iframe id="destinationConetnt" src="${otapp}/trip/activity/destination/view.html?ad.fsId=${ad.fsId}" width="100%" height="445px" frameborder="0" border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  ></iframe> 
	</div>
</div>
</body>
</html>