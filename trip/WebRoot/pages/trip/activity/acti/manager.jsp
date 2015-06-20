<%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
 <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/demo.css " />
  <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/dlg.css " />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
 <script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.form.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
  <link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
/**
 * @see 查询旅游活动
 */
function queryForm(){
	$("#subform").submit(); 
}


/**
 * @see 删除旅游活动
 */


function del(id)
{
 
	$.post('${otapp}/trip/activity/acti/delActiInfo.html?json=',{"actiId":id},function(data, textStatus){  
    	if(data.error==1)
		{
			$.messager.alert("\u63d0\u793a","\u5220\u9664\u5931\u8d25");
            
    		location.reload(true);
		}
		else
		{
			$.messager.alert("\u63d0\u793a", "\u5220\u9664\u6210\u529f");
			location.reload(true);
		}
	},"json");
	
	
}

//获取景区
function getDestination(namelab,pobj){
	if(pobj!=null&&pobj.value!=''){
	    $.post('${otapp}/trip/activity/acti/getDestinationOpt.html?json',{"parentId":pobj.value},function(data, textStatus){  
	    	if(data!=null&&data!=""){
				var str = eval(data); 
				$.each(str, function() { 
					$("#"+namelab+" option[value='"+this.value+"']").remove();
					$("#"+namelab).append("<option value='"+this.value+"'> "+this.name+"</option>");
				 });  
			}
	    	
		},"json");
		
	}
}

function modifyActi(fsId)
{
	alert(fsId);
	$("#dd_dg").show();
	$("#dd_dg").dialog({
		 title: "\u7f16\u8f91\u4fe1\u606f",
         iconCls: "icon-edit",
         modal: true,//遮罩层
         width: 900,
         height: 500,
         buttons: [
         {
             text: "\u7f16\u8f91",
             iconCls: "icon-edit",
             handler: function () {
                 var parm = $("#fm_dg").serialize();
                 var pp = decodeURIComponent(parm, true);
                 $.post("grid1.ashx", { "action": "edit", data: pp }, function (data) {
                     $.messager.show({
                         title: "\u63d0\u793a",
                         msg: data
                     });
                     $("#tab").datagrid("reload");
                     $("#dd_dg").window("close");
                 });
             }

         },
          {
              text: "\u53d6\u6d88",
              iconCls: "icon-cancel",
              handler: function () {
                  $("#dd_dg").window('close');
              }
          }
         ]

	});
	alert("ma");
}


</script>
<body>
	<div class="place">
		<span><spring:message code="common.content.lab.position" /></span>
		<ul class="placeul">
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.modul" /></a></li>
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.travel.activity" /></a></li>
			<li><a href="${otapp}/trip/activity/acti/manager.html"><spring:message code="trip.manager.position.activity.public" /></a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="col-md-12">    
        	<div class="col-md-4">
		        <h4>
		        	<span><spring:message code="trip.manager.position.activity.public" /></span>
		        	<ul class="toolbar1">
			        <a href="${otapp}/trip/activity/acti/add_public.html" class="easyui-linkbutton" data-options="iconCls:'icon-addExtBtn'"><spring:message code="trip.manager.activity.public.btn.add" /></a>
			        &nbsp;
			        </ul>
		        </h4>
				<form action="${otapp}/trip/activity/acti/manager.html" method="post" id="subform">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.query.no" /></th>
		            <td width="30%" colspan="1"><input name="a.fsNo" type="text" class="scinput" value="${a.fsNo}" /></td>
		            <th scope="row" width="20%"><spring:message code="trip.manager.activity.public.query.title" /></th>
		            <td width="30%" colspan="1"><input name="a.fsTitle" type="text" class="scinput" value="${a.fsTitle}" /></td>
		          </tr>
		          <tr>
		            <td width="100%" colspan="4" align="center">
		            	<a href="javascript:queryForm();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="height: 20px;"><spring:message code="common.button.query" /></a>
		            </td>
		          </tr>
		        </table>
				</form>
				<ec:table 
					items="actiList" var="a"
					action="${otapp}/trip/activity/acti/manager.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="10" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fsNo" title="trip.manager.activity.list.no" width="20%" />
						<ec:column property="fsTitle" title="trip.manager.activity.list.title" width="40%" />
						<ec:column property="otActiType.fsName" title="trip.manager.activity.list.type" width="15%" />
						<ec:column property="fnDay" title="trip.manager.activity.list.dayNum" width="10%" />
						<ec:column property="tt" title="common.column.lab.operator" width="15%" style="align:center;"  sortable="false">
							<a href="${otapp}/trip/activity/acti/modifyActi.html?a.fsId=${a.fsId}"><spring:message code="common.button.edit" /></a>
							<a href="javascript:del('${a.fsId}');"><spring:message code="common.button.del" /></a>
							<a href="${otapp}/trip/activity/acti/view_public.html?a.fsId=${a.fsId}"><spring:message code="common.button.view" /></a>
						</ec:column>
						
					</ec:row>
				</ec:table>
			</div>
		</div>
	</div>
	
	
	
	
	
</body>
</html>