<%@include file="../general/header.jsp" %>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="${otapp}/otrip_top.html" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
    <frame src="${otapp}/warn/menu.html" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="${otapp}/warn/default.html" name="rightFrame" id="rightFrame" title="rightFrame" />
  </frameset>
</frameset>
<noframes><body>
</body></noframes>
</html>