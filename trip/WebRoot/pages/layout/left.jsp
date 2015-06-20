<%@include file="../general/header.jsp" %>
<script type="text/javascript">
$(function(){	
	//导航切换
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
				<span><img src="${otapp}/images/leftico01.png" /></span><spring:message code="system.left.work.lab.manager" />
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a href="index.html" target="rightFrame"><spring:message code="system.left.work.lab.homeTemplate" /></a><i></i></li>
				<li><cite></cite><a href="right.html" target="rightFrame"><spring:message code="system.left.work.lab.dataList" /> </a><i></i></li>
				<li><cite></cite><a href="error.html" target="rightFrame"><spring:message code="system.left.work.lab.404Page" /> </a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico02.png" /></span><spring:message code="system.left.work.lab.otherSetting" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="#">编辑内容</a><i></i></li>
				<li><cite></cite><a href="#">发布信息</a><i></i></li>
				<li><cite></cite><a href="#">档案列表显示</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico03.png" /></span><spring:message code="system.left.work.lab.editMachin" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="#">自定义</a><i></i></li>
				<li><cite></cite><a href="#">常用资料</a><i></i></li>
				<li><cite></cite><a href="#">信息列表</a><i></i></li>
				<li><cite></cite><a href="#">其他</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${otapp}/images/leftico04.png" /></span><spring:message code="system.left.work.lab.dateManager" />
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="#">自定义</a><i></i></li>
				<li><cite></cite><a href="#">常用资料</a><i></i></li>
				<li><cite></cite><a href="#">信息列表</a><i></i></li>
				<li><cite></cite><a href="#">其他</a><i></i></li>
			</ul>
		</dd>
	</dl>
</body>
</html>