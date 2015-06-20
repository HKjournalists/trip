<%@include file="../general/header.jsp"%>
<script type="text/javascript">
$(function(){	
	//é¡¶é¨å¯¼èªåæ¢
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	

/**
 * @see æ¹åurlå°å
 */
function changeMain(leftUrl,mainDefaultUrl){
	$("#leftFrame",parent.document.body).attr("src","${otapp}/"+leftUrl+"?number="+Math.random());
	$("#rightFrame",parent.document.body).attr("src","${otapp}/"+mainDefaultUrl+"?number="+Math.random());  

}
</script>
<body style="background: url(${otapp}/images/topbg.gif) repeat-x;">
	<div class="topleft">
		<a href="main.html" target="_parent"><img src="${otapp}/images/logo.png" title='<spring:message code="system.top.lab.home" />' /></a>
	</div>
	<ul class="nav">
		<li>
	    	<a href="javascript:changeMain('trip/menu.html','trip/default.html');"  >
	    		<img src="images/icon04.png" title="<spring:message code="system.top.lab.tripManager"/>" />
	    		<h2><spring:message code="system.top.lab.tripManager"/></h2>
	    	</a>
	    </li>
		<li>
			<a href="javascript:changeMain('warn/menu.html','warn/default.html');"  class="selected">
				<img src="images/icon01.png" title="<spring:message code="system.top.lab.messageWarn"/>" />
				<h2><spring:message code="system.top.lab.messageWarn"/></h2>
			</a>
		</li>
	    <li>
	    	<a href="javascript:changeMain('order/menu.html','order/default.html');" >
	    		<img src="images/icon02.png" title="<spring:message code="system.top.lab.orderManager"/>" />
	    		<h2><spring:message code="system.top.lab.orderManager"/></h2></a>
	    	</li>
	    <li>
	    	<a href="javascript:changeMain('airport/menu.html','airport/default.html');"  >
	    		<img src="images/icon03.png" title="<spring:message code="system.top.lab.airportManager"/>" />
	    		<h2><spring:message code="system.top.lab.airportManager"/></h2>
	    	</a>
	    </li>
	    
		<li>
			<a href="javascript:changeMain('system/menu_left.html','system/main_content.html');" >
			<img src="${otapp}/images/icon06.png" title='<spring:message code="system.top.lab.systemManager"/> ' />
			<h2><spring:message code="system.top.lab.systemManager"/></h2>
			</a>
		</li>
	</ul>

	<div class="topright">
		<ul>
			<li>
				<span><img src="${otapp}/images/help.png" title='<spring:message code="system.top.lab.help" />' class="helpimg" /></span>
				<a href="#"><spring:message code="system.top.lab.help" /></a>
			</li>
			<li><a href="#"><spring:message code="system.top.lab.aboutUs" /></a></li>
			<li><a href="logout_exits.html" target="_parent"><spring:message code="system.top.lab.logout" /></a></li>
		</ul>
		<div class="user">
			<span>${loginUser.fsName}</span><i><spring:message code="system.top.lab.message" /></i> <b>5</b>
		</div>
	</div>
</body>
</html>