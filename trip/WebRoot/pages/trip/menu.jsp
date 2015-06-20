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
				<span><img src="${otapp}/images/leftico02.png" /></span><spring:message code="system.trip.module.tripActive" />
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a href="${otapp}/trip/activity/acti/manager.html" target="rightFrame"><spring:message code="system.trip.menu.tripActivePublic" /></a><i></i></li>
				<li><cite></cite><a href="${otapp}/trip/activity/destination/manager.html" target="rightFrame"><spring:message code="system.trip.menu.tripActiveDestinationManager" /></a><i></i></li>
			</ul>
		</dd>

		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico08.png" /></span><spring:message code="system.trip.module.tripStatistics" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${otapp}/trip/statistics/favourite/statistics.html" target="rightFrame"><spring:message code="system.trip.menu.storeStatistics" /></a><i></i></li>
				<li><cite></cite><a href="${otapp}/trip/statistics/praise/statistics.html" target="rightFrame"><spring:message code="system.trip.menu.clickPriaseStatistics" /></a><i></i></li>
				<li><cite></cite><a href="${otapp}/trip/statistics/comment/statistics.html" target="rightFrame"><spring:message code="system.trip.menu.commentStatistics" /></a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico05.png" /></span><spring:message code="system.trip.module.tripComment" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="user/user_list.html" target="rightFrame"><spring:message code="system.trip.menu.commentInfo" /></a><i></i></li>
				<li><cite></cite><a href="user/user_add.html" target="rightFrame"><spring:message code="system.trip.menu.activeProblem" /></a><i></i></li>
			</ul>
		</dd>

		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico10.png" /></span><spring:message code="system.trip.module.configManager" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="${otapp}/trip/configure/destination/type_manager.html" target="rightFrame"><spring:message code="system.trip.menu.destinationType" /></a><i></i></li>
				<li><cite></cite><a href="${otapp}/trip/configure/activity/type_manager.html" target="rightFrame"><spring:message code="system.trip.menu.activeType" /></a><i></i></li>
			</ul>

		</dd>
	</dl>
</body>
</html>