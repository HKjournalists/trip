<%@include file="header.jsp" %>
<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
</script> 
<body style="background:#edf6fa;">
	<div class="place">
    <span><spring:message code="common.content.lab.position"></spring:message></span>
    <ul class="placeul">
    <li><a href="#"><spring:message code="error.message.code.404"></spring:message></a></li>
    </ul>
    </div>
    
    <div class="error">
    
    <h2><spring:message code="error.message.info.404.noAccessPage"></spring:message></h2>
    <p><spring:message code="error.message.info.404.badMy"></spring:message></p>
    <div class="reindex"><a href="index.html" target="_parent"><spring:message code="error.message.info.404.backHome"></spring:message> </a></div>
    
    </div>


</body>
</html>