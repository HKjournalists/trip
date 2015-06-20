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
				<span><img src="${otapp}/images/leftico04.png" /></span><spring:message code="system.airport.module.airportManager" />
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a href="order/order_list.html"
					target="rightFrame"><spring:message code="system.airport.menu.airportInfo" /></a><i></i></li>
			</ul>
		</dd>


		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico05.png" /></span><spring:message code="system.airport.module.airportComment" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="activity/activity_list.html"
					target="rightFrame"><spring:message code="system.airport.menu.commentInfo" /></a><i></i></li>
				<li><cite></cite><a href="activity/activity_add.html"
					target="rightFrame"><spring:message code="system.airport.menu.commentStatistic" /></a><i></i></li>
			</ul>
		</dd>
	</dl>
</body>
</html>