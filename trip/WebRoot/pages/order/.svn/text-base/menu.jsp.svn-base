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
				<span><img src="${otapp}/images/leftico08.png" /></span><spring:message code="system.order.module.tripOrder" />
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a href="orderList.html"
					target="rightFrame"><spring:message code="system.order.menu.tripOrderList" /></a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico01.png" /></span><spring:message code="system.order.module.airportOrder" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="order_list.html"
					target="rightFrame"><spring:message code="system.order.menu.airportOrderList" /></a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico09.png" /></span><spring:message code="system.order.module.statistic" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="user/user_list.html"
					target="rightFrame"><spring:message code="system.order.menu.tripOrderStatistic" /></a><i></i></li>
				<li><cite></cite><a href="user/user_add.html"
					target="rightFrame"><spring:message code="system.order.menu.airportOrderStatistic" /></a><i></i></li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico07.png" /></span><spring:message code="system.order.module.couponManager" />
			</div>
			<ul class="menuson">
				<li><cite></cite>
					<a href="order_list.html"
					target="rightFrame"><spring:message code="system.order.menu.couponInfo" /></a><i></i></li>
				<li><cite></cite><a href="order_list.html"
					target="rightFrame"><spring:message code="system.order.menu.receiveStatistic" /></a><i></i></li>
			</ul>
		</dd>
	</dl>
</body>
</html>