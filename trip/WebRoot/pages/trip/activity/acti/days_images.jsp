<%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.form.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${otapp}/plug/upload/ajaxfileupload.js"></script>

<script type="text/javascript">
/**
 * @see 查询旅游活动
 */
function queryForm(){
	$("#subform").submit(); 
}

/**
 * @see 上传附件
 */
function uploadFile(){
	 $.ajaxFileUpload({ 
         url             : "${otapp}/common/image/upload.html", //需要链接到服务器地址 
         type			 : 'post',
         data: { 
        	 'im.fsObjId': '${actId}' ,
        	 'im.fsObjTabName': 'ot_acti_days' ,
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

/**
 * @see 删除id
 */
function del(id){
    $.post('${otapp}/common/image/delete.html?json',{"id":id},function(data, textStatus){  
    	if("success"==textStatus&&data!=null&&"success"==data['operatorStateCode']){
    		alert('<spring:message code="common.operator.message.code.del.success" />');
    		location.reload(true);
    	}else{
    		alert('<spring:message code="common.operator.message.code.del.fail" />');
    	}
	},"json");
}

</script>
<body>
	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
        		<h4>
		        	<span><spring:message code="trip.manager.activity.public.view.days.cover" /></span>
		        	<ul class="toolbar1" ></ul>
		        </h4>
        		<form action="${otapp}/common/image/upload.html?json" method="post" id="picform" enctype="multipart/form-data">
				<input type="hidden" id="bsId" name="bsId" value="${daysId}" />
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.days.pic.lab" /></th>
		            <td width="80%" colspan="1" align="left">
		            	<%-- <input class="easyui-filebox"  type="file" id="pic" name="pic" data-options="prompt:'<spring:message code="common.button.select.pic" />'" style="width:50%" />   --%>
		            	<input  type="file" id="pic" name="pic" style="width:50%" />  
		            	<a href="javascript:uploadFile();" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" style="height: 20px;"><spring:message code="common.button.upload.pic" /></a>
		            </td>
		           
		          </tr>
		        </table>
				</form>
				<form action="${otapp}/trip/activity/acti/list_cover.html" method="post" id="subform">
				<input type="hidden" name="actId" value="${actId}" />
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.days.query.fsName" /></th>
		            <td width="80%" colspan="3"><input name="imageName" type="text" class="scinput" value="${imageName}" /></td>
		          </tr>
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				<ec:table 
					items="actCoverImages" var="al"
					action="${otapp}/trip/activity/acti/list_cover.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="10" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fsName" title="trip.manager.activity.cover.list.fsName" width="10%" />
						<ec:column property="fsPath" title="trip.manager.activity.cover.list.fsPath" width="60%" />
						<ec:column property="fsObjTabName" title="trip.manager.activity.cover.list.fsTableName" width="15%" />
						<ec:column property="tt" title="common.column.lab.operator" width="15%" style="align:center;" >
							<a href="javascript:del('${al.fsId}');"><spring:message code="common.button.del" /></a>
							<a href="${otapp}${al.fsPath}" target="_blank"><spring:message code="common.button.view" /></a>
						</ec:column>
					</ec:row>
				</ec:table>
			</div>
		</div>
	</div>
</body>
</html>