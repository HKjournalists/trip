<%@include file="../general/header.jsp" %>

<body>
	<div class="place">
		<span><spring:message code="common.content.lab.position" /> </span>
		<ul class="placeul">
			<li><a href="#"><spring:message code="system.main.welcome.position.home"></spring:message></a></li>
		</ul>
	</div>

	<div class="mainindex">
		<div class="welinfo">
			<span><img src="${otapp}/images/sun.png" alt="天气" /></span> <b><spring:message code="system.main.welcome.content.info"></spring:message>
			<a href="#"><spring:message code="system.main.welcome.account.setting"></spring:message></a>
		</div>

		<div class="welinfo">
			<span><img src="${otapp}/images/time.png" alt="时间" /></span> <i><spring:message code="system.main.welcome.lastLoginDate"></spring:message> </i> <spring:message code="system.main.welcome.notYouLogin"></spring:message>
		</div>

		<div class="xline"></div>
	</div>
</body>
</html>