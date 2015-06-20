<%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/upload/ajaxfileupload.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.form.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script language="javascript" type="text/javascript" src="${otapp}/plug/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){

//console.log("abcddd");
//( " =====  ");
	
});

function uploadFile(){
	 $.ajaxFileUpload({ 
         url             : "${otapp}/common/image/upload.html", //需要链接到服务器地址 
         type			 : 'post',
         data: { 
        	 'im.fsObjId': '${d.fsId}' ,
        	 'im.fsObjTabName': 'ot_acti_day' ,
        	 'im.fsObjSign': 'trip_days_image' 
        	 }, //此参数非常严谨，写错一个引号都不行
         secureuri       : false,  
         fileElementId   : "pic", //文件选择框的id属性 
         dataType        : 'json', //服务器返回的格式 
         success     : function(data,status) {    //相当于java中try语句块的用法             
            if(data!=null&&"success"==data['operatorStateCode']){
        		alert('<spring:message code="common.upload.msg.success" />');
        		location.reload(true);
        	}
         }, 
         error : function(data,status,e) { 
        	 alert('<spring:message code="common.upload.msg.fail" />');
         } 
     }); 
}


</script>
<style>
*{font-size:9pt;border:0;margin:0;padding:0;}
body{font-family:'微软雅黑'; margin:0 auto;min-width:980px;}
</style>

<body>


	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
        		<h4>
        		
        	
		        	<span><spring:message code="trip.manager.activity.public.view.schedule.view.title" /></span>
		        	<ul class="toolbar1" >
			        &nbsp;
			        </ul>
		        </h4>
		        <a href="${otapp}/trip/activity/acti/list_days.html?1=1&actId=${d.otActiInfo.fsId}" class="easyui-linkbutton" data-optinons="iconCls:'icon-search'" style="height:20px;"><spring:message code="common.button.return.submit"></spring:message></a>
				<form action="${otapp}/trip/activity/acti/save_days.html" method="post" id="subform">
				<input type="hidden" name="d.otActiInfo.fsId" value="${d.otActiInfo.fsId}" />
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.add.fsName" /></th>
		            <td width="30%" colspan="1">
		            	${d.fsName}
		            </td>
		            <th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.add.fnDays" /></th>
		            <td width="30%" colspan="1">${d.fnDays}</td>
		          </tr>
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.add.position" /></th>
		            <td width="80%" colspan="3">
		            	<table style="width: 100%;height: 100%;border: 0px;margin: 0px;padding: 0px;">
		    					<tr>
			    					<td width="50%">
			    						<spring:message code="trip.manager.destination.add.fsLatitude"></spring:message>
			    						${d.fsLatitude}
			    					</td>
		    					</tr>
		    					<tr>
		    						<td colspan="1">
			    						<spring:message code="trip.manager.destination.add.fsLongitudel"></spring:message>
			    						${d.fsLongitude}
			    					</td>
			    					<td colspan="1" rowspan="2" valign="top">
			    						
			    					</td>
		    					</tr>
		    				</table>
		            </td>
		          </tr>
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.add.fsDescription" /></th>
		            <td width="80%" colspan="3">
		            	<input class="easyui-textbox" name="d.fsDescription" data-options="multiline:true" readonly="readonly" style="height:100px;width: 300px;" value="${d.fsDescription }"></input>
		            </td>
		          </tr>
		        </table>
				</form>
				
				<form action="${otapp}/common/image/upload.html?json" method="post" id="picform" enctype="multipart/form-data">
			    <input type="hidden" id="bsId" name="bsId" value="${actId}" />
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.schedule.add.Dayimage" /></th>
		            <td width="50%" colspan="1" align="left">
		            	<!--   <input class="easyui-filebox"  type="file" id="pic" name="pic" data-options="prompt:'<spring:message code="common.button.select.pic" />'" style="width:50%" /> --> 
		            	<input  type="file" id="pic" name="pic" style="width:50%" />  
		            </td>
		            <td>
		            	<a href="javascript:uploadFile();" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" style="height: 20px;"><spring:message code="common.button.upload.pic" /></a>
		            </td>
		          </tr>
		          
		        </table>
				</form>
				
				
				
				
				<ec:table  
					items="actDayImages" var="al"
					action="${otapp}/trip/activity/acti/days_image.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="10" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fsName" title="trip.manager.activity.cover.list.fsName" width="10%" />
						<ec:column property="fsUrl" title="trip.manager.activity.cover.list.fsPath" width="60%" />
						<ec:column property="fsObjTabName" title="trip.manager.activity.cover.list.fsTableName" width="15%" />
						<ec:column property="tt" title="common.column.lab.operator" width="15%" style="align:center;" >
							<a href="javascript:del('${al.fsId}');"><spring:message code="common.button.del" /></a>
							<a href="${otapp}${al.fsUrl}" target="_blank"><spring:message code="common.button.view" /></a>
						</ec:column>
					</ec:row>
				</ec:table>
			</div>
		</div>
	</div>
	
</body>
</html>