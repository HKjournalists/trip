<%@include file="../../../general/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
<link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>

<script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.form.js"></script>
<link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
<script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${otapp}/plug/upload/ajaxfileupload.js"></script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
   <script type="text/javascript">
   
   		$(document).ready(function(){
   			var msg1="\u56fe\u7247\u5927\u5c0f\u4e0d\u5f97\u8d85\u8fc7";//图片大小不得超过
   			var msg2="\u56fe\u7247\u683c\u5f0f\u5e94\u4e3a";//图片格式应为
   			$('#Imgmsg').text(msg1+"1M,"+msg2+"jpg,png");
   			//$('#pic').attr("placeholder",msg1+"1M,"+msg2+"jpg,jpn");
   		});
   
   		$(function(){
   			var msg1="\u4e0d\u586b\u5219\u4f7f\u7528\u539f\u56fe\u7247\u540d\u79f0";
   			$('#newImageName').attr("placeholder",msg1);
   			turl=document.getElementById("typeurl").value;
   			durl=document.getElementById("detailurl").value;
   			
   			$("#type").combobox(
   					{
   						url:turl,
   						editable:false,
   						cache:false,
   						panelHeight:"auto",
   						valueField:"typeValue",
   						textField:"typeText",
   						onSelect:function(){
   							//alert($("#type").combobox("getValue"));
   							//var url=durl+$("#type").combobox("getValue");
   							//alert(url);
   							$.ajax({
   								type:"POST",
								url:durl+$("#type").combobox("getValue"),
								cache:false,
								dataType:"json",
								success:function(data){
									$("#detail").combobox("loadData",data);
								}
   							}
   							);
   						}
   					}
   					);
			
   			$("#detail").combobox({
   				editable:false,
   				cache:false,
   				panelHeight:"auto",
   				valueField:"detailValue",
   				textField:"detailText",
   				onSelect:function(){
   					var typeId=$("#type").combobox("getValue");
   					var detailId=$("#detail").combobox("getValue");
   					//alert(typeId+"::::"+detailId);
   					document.getElementById("tabName").value=typeId;
   					document.getElementById("fsId").value=detailId;
   					//alert(document.getElementById("tabName").value+":"+document.getElementById("fsId").value);
   				}
   			});
   			
   			
   		}
   		 )
   		
 	
   	/**
 * @see 上传附件
 */
function uploadFile(){
   	if(imageCheck)
  {
   
   	var tab=document.getElementById("tabName").value;
   	var fsid=document.getElementById("fsId").value;
   
	 $.ajaxFileUpload({ 
         url             : "${otapp}/common/image/upload.html", //需要链接到服务器地址 
         type			 : 'post',
         data: { 
        	 'im.fsObjId': fsid ,
        	 'im.fsObjTabName': tab ,
        	 'im.fsObjSign': 'trip_Type_image'
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
   	else
   		{
   		return false;
   		}
}	
   
   
   	function del(fsId)
   	{
   	 $.post('${otapp}/common/image/delete.html?json',{"id":fsId},function(data, textStatus){  
     	if("success"==textStatus&&data!=null&&"success"==data['operatorStateCode']){
     		alert('<spring:message code="common.operator.message.code.del.success" />');
     		location.reload(true);
     	}else{
     		alert('<spring:message code="common.operator.message.code.del.fail" />');
     	}
 	},"json");
   	}
   	
   	function refulsh()
   	{
   		location.reload();
   	}
   	
   	
   	var imageCheck=false;
   	function checkImageSize(obj)
   	{
   		if(obj.files[0].type=="image/jpeg"||obj.files[0].type=="image/png")
   		{
   			if(obj.files[0].size<4*1024*1024)
   			{
   				imageCheck= true;	
   			}
   			else
   			{
   				alert("\u56fe\u7247\u592a\u5927");	
   			}
   		}
   		else
   		{
   			alert("\u56fe\u7247\u683c\u5f0f\u4e0d\u652f\u6301");	
   		}
   	}
   </script>

  </head>
  
  <body>
  	<table>
  		<tr>
  		<td>
  			<th  width="20%"><spring:message code="trip.manager.activity.public.view.otherImageType" /></th>
  			<td width="20%" colspan="2">
  				<select id="type" class="type" name="type" style="width:80px" >
  				</select>
  			</td>
  			<td>
  				<select id="detail" class="detail" name="detail" style="width:80px">
  				</select>
  			</td>
  		</td>
  		</tr>
  	</table>
	<input type="hidden" id="typeurl" name="typeurl" value="${otapp}/trip/activity/acti/getImageType.html?json="/>
	<input type="hidden" id="detailurl" name="detailurl" value="${otapp}/trip/activity/acti/getImageDetail.html?json=&typeId="/>
	<input type="hidden" id="tabName" name="tabName" value="${otapp}/trip/activity/acti/delTimePrice.html?json="/>
	<input type="hidden" id="fsId" name="fsId" value="${otapp}/trip/activity/acti/delTimePrice.html?json="/>
	
	
	<input type="hidden" id="objName" value=""><!-- 与存放文件夹相关 -->
	<input type="hidden" id="objId" value="" />
	<input type="hidden" id="objSign" value="" />
	<tr>
		<form action="${otapp}/common/image/upload.html?json" method="post" id="picform" enctype="multipart/form-data">
				<table width="100%" cellpadding="0" cellspacing="0" class="table">
				<!--  
				<tr>
					<td scope="row" width="20%"><spring:message code="common.image.newName"></spring:message></td>
					<td width="50%" colspan="1" align="left"><input id="newImageName" type="text" name="picName" value=""/></td>
				</tr>
				-->
		          <tr>
		          	<th scope="row" width="20%"><spring:message code="trip.manager.activity.public.view.otherImageName" /></th>
		            <td width="50%" colspan="1" align="left">
		            	<!--   <input class="easyui-filebox"  type="file" id="pic" name="pic" data-options="prompt:'<spring:message code="common.button.select.pic" />'" style="width:50%" /> --> 
		            	<input  type="file" id="pic" name="pic" style="width:50%" onchange="checkImageSize(this)"  />  
		            	<span id="Imgmsg" style="float:right"></span>
		            </td>
		            <td>
		            	<a href="javascript:uploadFile();" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" style="height: 20px;"><spring:message code="common.button.upload.pic" /></a>
		            </td>
		           </tr>
		           
		 </form>
	</tr>
</table>
				
	
	<div>
			<input type="button" style="background-image: url('${otapp}/images/menu/reflush.png'); background-repeat: no-repeat;" onclick="refulsh()" value='<spring:message code="common.image.reflush" />'>
		      <ec:table 
					items="images" var="al"
					action="${otapp}/trip/activity/acti/list_otherImage.html"
					imagePath="${otapp}/plug/eXtremeComponents/images/table/*.gif"
					rowsDisplayed="8" autoIncludeParameters="true" cellpadding="1"
					filterable="false" locale="zh_CN">
					<ec:row>
						<ec:column property="fsName" title="trip.manager.otherImage.uploadIamge.fsName" width="10%" />
						<ec:column property="imageObjType" title="trip.manager.otherImage.uploadImage.fsywType" width="15%" />
						<ec:column property="imageObjName" title="trip.manager.otherIamge.uploadImage.fsywName" width="15%" />
					
						<ec:column property="tt" title="common.column.lab.operator" width="15%" style="align:center;" >
							<a href="javascript:del('${al.fsId}');"><spring:message code="common.button.del" /></a>
							<a href="${otapp}${al.fsUrl}" target="_blank"><spring:message code="common.button.view" /></a>
						</ec:column>
						<ec:column property="fsUrl" width="10%" ><img src="${otapp}${al.fsUrl}" width="30%" height="150%" /></ec:column>
					</ec:row>
				</ec:table>
	</div>
  </body>
</html>
