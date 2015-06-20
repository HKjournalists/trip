<%@include file="../../../general/headernocss.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/css/display/display.css" /> 
<script src="http://webapi.amap.com/maps?v=1.3&key=e18d7cfe65ea634648a9c0943f10f1f0" type="text/javascript"></script>  
<script type="text/javascript">
$(document).ready(function(){

});


function confirmCoordinate(){
	$('#fsLatitude', window.parent.document).val($("#latitude").val());
	$('#fsLongitudel', window.parent.document).val($("#longitudel").val());
	window.parent.closeCoordinateWindow();
}
</script>
<style type="text/css">
body{
			margin:0;
			height:100%;
			width:100%;
			position:absolute;
		}
#btnDiv{
	position:absolute;
	bottom:50px;
	right:20px;
}

#btnDiv input{
	height:20px;
	line-height:20px;
	background-color: #0D9BF2;
	color:#FFF;
	border:0;
	outline:none;
	padding-left: 5px;
	padding-right:5px;
	border-radius:3px;
	cursor:pointer;
      }

</style>

<body style="margin: 0px;padding: 0px;">
<div style="width:100%;margin: 0px;padding: 0px;left:0px;border: 0px;top: 10px;">
<table   cellpadding="0" cellspacing="0"  bgColor="#cccccc" class="table" style="width:100%; top:2px;padding-top:1px;margin: 0px;border: 0px;">
  <tr>
  	<td  colspan="5"  width="100%">
  		<div id="mapContainer" style="height:350px;width:100%;margin: 0px;padding: 0px;top:0px;overflow:hidden; ">
  		
  		</div> 
  		<div id="btnDiv"> 
	        <input id="enMapBtn" type="button" value="<spring:message code="trip.manager.destination.add.map.en" />"/> 
	        <input id="zh_enMapBtn" type="button" value="<spring:message code="trip.manager.destination.add.map.cnAndEn" />"/>
	        <input id="zhMapBtn" type="button" value="<spring:message code="trip.manager.destination.add.map.cn" />"/>
	    </div>  
	    <script type="text/javascript">
	    var map = new AMap.Map('mapContainer',{
			resizeEnable: true,
	        rotateEnable:true,
	        dragEnable:true,
	        zoomEnable:true,
	        //二维地图显示视口
	        //设置地图中心点
	        //设置地图显示的缩放级别
	        view: new AMap.View2D({
	            center: new AMap.LngLat(-18.159617, 65.052937),
	            zoom: 2 
	        })
	    });
	 	
	 	AMap.event.addListener(map,'click',getLnglat);	
	 	
	 	document.getElementById('enMapBtn').onclick = function(){
	 		map.setLang('en');
	 	};

	 	document.getElementById('zh_enMapBtn').onclick = function(){
	 		map.setLang('zh_en');
	 	};

	 	document.getElementById('zhMapBtn').onclick = function(){
	 		map.setLang('zh_cn');
	 	};
	 	
	 	//鼠标在地图上点击，获取经纬度坐标
	 	function getLnglat(e){  
	 		$("#latitude").val(e.lnglat.getLng());
	 		$("#longitudel").val(e.lnglat.getLat());
	 	}
	    </script>
  	</td>
  </tr>
  <tr>
    <th scope="row" class="tdleft" width="15%"><spring:message code="trip.manager.destination.add.fsLatitude" /></th>
    <td  colspan="1" class="tdright" width="25%" >
    	<input id="latitude" name="latitude" type="text" class="scinput"  value="" />
    </td>
    <th scope="row" class="tdleft" width="15%"><spring:message code="trip.manager.destination.add.fsLongitudel" /></th>
    <td  colspan="1" class="tdright"width="25%" >
    	<input id="longitudel" name="longitudel" type="text" class="scinput"  value="" />
    </td>
    <td  colspan="1" class="tdright" width="20%">
		<a href="javascript:confirmCoordinate();" class="easyui-linkbutton"><spring:message code="trip.manager.destination.add.map.btn.confirm"></spring:message></a>
    </td>
  </tr>
</table>
</div>
</body>
</html>