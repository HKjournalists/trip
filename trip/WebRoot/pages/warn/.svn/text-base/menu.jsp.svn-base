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
		    <span><img src="${otapp}/images/leftico05.png" /></span><spring:message code="system.warn.module.messageWarn" />
		    </div>
		    	<ul class="menuson">
		    	<li class="active"><cite></cite><a href="order/order_list.html" target="rightFrame"><spring:message code="system.warn.menu.waitScheduleActiveWarn" /></a><i></i></li>
		        <li><cite></cite><a href="order/order_list.html" target="rightFrame"><spring:message code="system.warn.menu.waitAriportOrderWarn" /></a><i></i></li>
		        </ul>    
		 </dd>
		 <dd>
		    <div class="title">
		    <span><img src="${otapp}/images/leftico06.png" /></span><spring:message code="system.warn.module.problemTrackWarn" />
		    </div>
		    <ul class="menuson">
		        <li><cite></cite><a href="activity/activity_list.html" target="rightFrame"><spring:message code="system.warn.menu.waitReplyActive" /></a><i></i></li>
		        </ul>     
		 </dd> 
		 <dd><div class="title"><span><img src="${otapp}/images/leftico07.png" /></span><spring:message code="system.warn.module.couponReceiveWarn" /></div>
		    <ul class="menuson">
		        <li><cite></cite><a href="user/user_list.html" target="rightFrame"><spring:message code="system.warn.menu.toDateNoReceiveWarn" /></a><i></i></li>   
		        <li><cite></cite><a href="user/user_add.html" target="rightFrame"><spring:message code="system.warn.menu.toDateNoUserWarn" /></a><i></i></li>
		    </ul>    
	    </dd>  
	</dl>
</body>
</html>