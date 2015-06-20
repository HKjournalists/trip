<%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
 <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/demo.css " />
  <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/dlg.css " />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.form.js"></script>
   <script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script language="javascript" type="text/javascript" src="${otapp}/plug/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
</script>

<style>
*{font-size:9pt;border:0;margin:0;padding:0;}
body{font-family:'微软雅黑'; margin:0 auto;min-width:980px;}
</style>

<body>
	<div class="place">
		<span><spring:message code="common.content.lab.position" /></span>
		<ul class="placeul">
			<li><a href="#"><spring:message code="trip.manager.position.modul" /></a></li>
			<li><a href="#"><spring:message code="system.trip.module.tripStatistics" /></a></li>
			<li><a href="#"><spring:message code="system.trip.menu.storeStatistics" /></a></li>
		</ul>
	</div>
	
	<div class="rightinfo">
		<div id="tt" class="easyui-tabs" style="width:90%;font-weight: bold;height:auto;">
			<div title="<spring:message code="system.trip.menu.storeStatistics" />" style="padding:10px">
				<table  width="100%" cellpadding="0" cellspacing="0"  style="width: 100%; top: 0px;margin: 0px;padding: 0px;border: 0xp;">
					<tr>
					<td>
						<h5>
				        	<span><spring:message code="trip.manager.statistics.favouriteInfo.statistics" /></span>
				        </h5>
				     </td>
				    </tr>
				    
				    <tr>
				    	<form action="${otapp}/trip/activity/acti/manager.html" method="post" id="subform">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.statistics.favouriteInfo.actiLineNo" /></th>
		            <td width="30%" colspan="1"><input name="fsNo" type="text" class="scinput" value="" /></td>
		            <th scope="row" width="20%"><spring:message code="trip.manager.statistics.favouriteInfo.actiTitle" /></th>
		            <td width="30%" colspan="1"><input name="fsTitle" type="text" class="scinput" value="" /></td>
		            
		          </tr>
		          <!-- 用户扩展查询条件 
		          <tr>
		          		<th scope="row" width="20%"><spring:message code="trip.manager.statistics.favouriteInfo.actiTitle" /></th>
		            <td width="30%" colspan="1"><input name="fsTitle" type="text" class="scinput" value="" /></td>
		          </tr>
		          -->
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				    </tr>
				</table>
				
				
				<ec:table
					items="favList" var="fl" action="${otapp}/trip/statistics/favourite/statistics.html?top=10"  
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif" 
					rowsDisplayed="10" 
					autoIncludeParameters="true"
					cellpadding="1" filterable="false" locale="zh_CN"
				>
					<ec:row>
						<ec:column property="fsNo" title="trip.manager.activity.list.no" width="15%"></ec:column>
						<ec:column property="fsTitle" title="trip.manager.activity.statistics.list.fsTitle" width="15%"></ec:column>
						<ec:column property="fnDay" title="trip.manager.activity.statistics.list.fsDay" width="15%"></ec:column>
						<ec:column property="fnTripDistance" title="trip.manager.activity.statistics.list.fsTripDistance" width="15%"></ec:column>
						<ec:column property="FavoriteNum" title="trip.manager.activity.statistics.list.fsFavouriteNum" width="15%"></ec:column>
					</ec:row>
				</ec:table>
			</div>
		</div>
	</div>
</body>  
</html>