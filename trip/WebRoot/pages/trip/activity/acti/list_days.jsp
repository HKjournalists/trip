<%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
/**
 * @see 查询旅游活动
 */
function queryForm(){
	$("#subform").submit(); 
}

function changeDay(dayIs){
	
}

function del(fsId)
{
	
	var url=document.getElementById("delUrl").value;
	$.post(url,{"dayId":fsId},function(data){
			if(data.error==1)
			{
				$.messager.alert("\u63d0\u793a","\u5220\u9664\u5931\u8d25");
                
        		location.reload();
			}
			else
			{
				$.messager.alert("\u63d0\u793a", "\u5220\u9664\u6210\u529f");
				location.reload();
			}
			
	},'json');
}
</script>
<body>
	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
        		<h4>
		        	<!--  <span><spring:message code="trip.manager.activity.public.view.schedule.title" /></span>-->
		        	<span><spring:message code="trip.manager.activity.public.view.schedule.title" />: <font color="red">${actiTitle }</font></span>
		        	<ul class="toolbar1" >
			        <a href="${otapp}/trip/activity/acti/to_days.html?d.otActiInfo.fsId=${actId}" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'">
			        	<spring:message code="trip.manager.activity.public.view.schedule.btn.add" />
			        </a>
			        &nbsp;
			        </ul>
		        </h4>
				<form action="${otapp}/trip/activity/acti/list_days.html" method="post" id="subform">
				<input type="hidden" name="actId" value="${actId}" />
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.lab.fsName" /></th>
		            <td width="80%" colspan="3"><input name="d.fsName" type="text" class="scinput" value="${otActiDay.fsName}" /></td>
		          </tr>
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				<ec:table 
					items="actDays" var="ad"
					action="${otapp}/trip/activity/acti/list_days.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="10" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fsId" title="common.list.column.select" width="5%" >
							<input type="radio" id="selFsId" name="selFsId" class="radioSel" value="${ad.fsId}" onclick="javascript:changeDay('${ad.fsId}');" />
						</ec:column>
						<ec:column property="fsName" title="trip.manager.activity.day.list.fsName" width="40%" />
						<ec:column property="fnDays" title="trip.manager.activity.day.list.fsDays" width="10%" />
						<ec:column property="fsLatitude" title="trip.manager.activity.day.list.fsLatitude" width="15%" />
						<ec:column property="fsLongitude" title="trip.manager.activity.day.list.fsLongitude" width="15%" />
						<ec:column property="tt" title="common.column.lab.operator" width="20%" style="align:center;" >
							<a href="${otapp}/trip/activity/acti/change_days.html?daysFsId=${ad.fsId}&actiFsId=${actId}"><spring:message code="common.button.edit" /></a>
							<a href="javascript:del('${ad.fsId}');"><spring:message code="common.button.del" /></a>
							<a href="${otapp}/trip/activity/acti/view_days.html?d.fsId=${ad.fsId}"><spring:message code="common.button.view" /></a>
						</ec:column>
						
					</ec:row>
				</ec:table>
				<input type="hidden" value="${otapp}/trip/activity/acti/delDay.html?json=" id="delUrl">
			</div>
		</div>
	</div>
	<!-- 
	<div class="rightinfo">
		<iframe id="daysImg" src="${otapp}/trip/activity/acti/days_image.html?1=1&daysId=${actId}&imageName=" width="100%" height="600px" frameborder="0"  border="0" marginheight="0" marginwidth="0" style="margin: 0xp;border: 0px;padding:0px;" scrolling="no"  ></iframe>
	</div>
	 -->
</body>
</html>