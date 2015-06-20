<%@include file="../general/header.jsp" %>
<script type="text/javascript">
$(function(){	
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
<body style="background:#f0f9fd;">
	<div class="lefttop">
		<span></span><spring:message code="common.left.menu.title"/>
	</div>
	<dl class="leftmenu">
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico03.png" /></span><spring:message code="system.setting.module.userManager" />
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a href="${otapp}/system/user/manager_user.html" target="rightFrame"><spring:message code="system.setting.menu.manager.user" /></a><i></i></li>
				<li ><cite></cite><a href="${otapp}/system/user/travel_user.html" target="rightFrame"><spring:message code="system.setting.menu.traver.user" /></a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico11.png" /></span><spring:message code="system.setting.module.authorityConfig" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${otapp}/system/role/manager.html" target="rightFrame"><spring:message code="system.setting.menu.roleConfig" /></a><i></i></li>
				<li><cite></cite><a href="menu/manager.html" target="rightFrame" ><spring:message code="system.setting.menu.menuManager" /></a><i></i></li>
				<li><cite></cite><a href="requiredpath/list.html" target="rightFrame" ><spring:message code="system.setting.menu.pathConfig" /></a><i></i></li>
				<li><cite></cite><a href="menutype/list.html" target="rightFrame" ><spring:message code="system.setting.menu.menuType" /></a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico10.png" /></span><spring:message code="system.setting.module.configManager" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${otapp}/system/dictionary_value/manager.html" target="rightFrame"><spring:message code="system.setting.menu.dictionaryManager" /></a><i></i></li>
				<li><cite></cite><a href="${otapp}/system/dictionary_type/manager.html" target="rightFrame"><spring:message code="system.setting.menu.dictionaryTypeManager" /></a><i></i></li>
        		<li><cite></cite><a href="${otapp}/system/interface_conf/manager.html" target="rightFrame"><spring:message code="system.setting.menu.interfaceConfigure" /></a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico12.png" /></span><spring:message code="system.setting.module.logManager" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${otapp}/system/manager_log/manager_login_log.html" target="rightFrame"><spring:message code="system.setting.menu.managerLoginLog" /></a><i></i></li>
        		<li><cite></cite><a href="${otapp}/system/travel_log/travel_login_log.html" target="rightFrame"><spring:message code="system.setting.menu.travelLoginLog" /></a><i></i></li>
			</ul>
		</dd>
	</dl>
</body>
</html>