<%@include file="../../../general/header.jsp"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/default/easyui.css" /> 
  <link rel="stylesheet" type="text/css" href="${otapp}/plug/jquery-easyui/themes/icon.css" />
  <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/demo.css " />
  <link rel="stylesheet" type="text/css"  href="${otapp}/plug/jquery-easyui/demo/dlg.css " />
   <script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.min.js"></script>
  <script type="text/javascript" src="${otapp}/plug/jquery-easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="${otapp}/plug/jquery-easyui/plugins/jquery.form.js"></script>
  <link href="${otapp}/plug/eXtremeComponents/script/ecside_simple.css" rel="stylesheet" type="text/css" />
 <link rel="stylesheet" type="text/css" href="${otapp}/css/self/common-form.css" /> 
 <script type="text/javascript" src="${otapp}/plug/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
 <script type="text/javascript" src="${otapp}/plug/upload/ajaxfileupload.js"></script>
    
   <script type="text/javascript">
   
  
        $(function () {
        	var acti=document.getElementById("bsId").value;
        	var url=document.getElementById("url").value;
        	var tabName=document.getElementById("tabTitle").value;
            $("#tab").datagrid({
                width: 800, //宽度
                height: 600, //高度
                singleSelect: true, //选中一行的设置
                rownumbers: true, //行号
                url: url, //请求路径
                title:tabName, //标题
                iconCls: "icon-save", //图标
                collapsible: true, //隐藏按钮
                cache:false,
                //冻结列
                frozenColumns: [[{ field: "JSON_Id", "checkbox": true}]],
                //列
                columns: [[
                { field: "JSON_no", title: "\u6d3b\u52a8\u540d\u79f0", width:60},
                { field: "JSON_orignal", title: "\u539f\u4ef7", width: 60 },
                { field: "JSON_special", title: "\u4f18\u60e0\u4ef7", width: 60 },
                { field: "JSON_start", title: "\u5f00\u59cb\u65f6\u95f4", width: 120 },
                { field: "JSON_end", title: "\u7ed3\u675f\u65f6\u95f4", width: 120 },
                { field: "JSON_create", title: "\u521b\u5efa\u65f6\u95f4", width: 120 },
				{ field: "JSON_update", title: "\u66f4\u65b0\u65f6\u95f4", width: 120 }
                ]],
                fitColumns:true,
                //传输参数
                queryParams: { "actId": acti },
                pagination: true,
                toolbar: "#tool"
//                toolbar: [{
//                    id: "btnadd",
//                    text: "添加",
//                    iconCls: "icon-add"
//                },
//                    {
//                        id: "btnEdit",
//                        text: "编辑",
//                        iconCls: "icon-edit"
//                    },
//                    {
//                        id: "btncut",
//                        text: "删除",
//                        iconCls: "icon-no",
//                        handler: function () {
//                            $("#btnsave").linkbutton("enable");
//                            delete_dg();
//                        }
//                    },
//                ]
            });
            $("#tab").datagrid('getPager').pagination({
                beforePageText: "\u7b2c",
                afterPageText: "\u9875",
                displayMsg: "\u5f53\u524d {from} - {to}\u6761\u6570\u636e   \u5171{total} \u6761\u6570\u636e",
                pageSize: 10,
                pageList: [5, 10, 15, 20, 30]

            });
        })
        /////////////////////////删除/////////////////
        function delete_dg() {
        	
            var selected = $("#tab").datagrid('getSelected');
            var url=document.getElementById("delurl").value;
            if (selected != null) {
                $.messager.confirm('\u63d0\u793a', '\u662f\u5426\u786e\u5b9a\u8981\u5220\u9664\uff1f', function (y) {
                    if (y) {
                    	/*
                        var v = "";
                        var checked = $("#tab").datagrid('getChecked');
                        alert(checked);delay
                        $.each(checked, function (i, j) {
                            v += j.JSON_id + ",";
                            
                        })
                        v = v.substring(0, v.length - 1);
                        */
                        $.post(url, { "fsId": selected.JSON_Id}, function (data) {
                        	if(data.error==1)
                        	{
                        		$.messager.alert("\u63d0\u793a","\u5220\u9664\u6210\u529f");
                    			location.reload();
                        		//$("#tab").datagrid('reload');
             
                        	}
                        	else
                        	{
                        		$.messager.alert("\u63d0\u793a", "\u5220\u9664\u5931\u8d25");
                                $("#tab").datagrid('reload');
                        	}
                            
                        },'json');
                    }
                })
            } else {
            $.messager.alert('\u63d0\u793a','\u60a8\u8fd8\u6ca1\u6709\u9009\u4e2d\u4e00\u884c\u6570\uff0c\u8bf7\u9009\u4e2d\u5728\u5220\u9664\uff01');
           }
    }
    /////////////////////添加///////////////////
    function add_dg() {
    //表单清空
        $("#fm_dg")[0].reset();
        //显示
        $("#dd_dg").show();
        var url=document.getElementById("addurl").value;
        //以窗体的形式展示
        $("#dd_dg").dialog({
            title: "\u6dfb\u52a0\u65f6\u95f4\u4ef7\u683c",//标题
            iconCls: "icon-add",//图标
            width: 500,//窗体的宽度
            height: 400,//窗体的高度
            modal: true, //遮罩层
            //按钮集合
            buttons: [
            {
                text: "\u6dfb\u52a0",//添加按钮的文本值
                iconCls: "icon-ok", //添加按钮的图标
                handler: function () {
                    //将数据序列化
                    var parm = $("#fm_dg").serialize();
                    //中文格式转换
                    var pp = decodeURIComponent(parm, true);
                    //post异步提交
                    $.post(url,  pp , function (data) {  
                        if(data.error==1)
                        	{
                        	//alert(data.error);
                        	$.messager.alert('\u63d0\u793a', '\u6dfb\u52a0\u6210\u529f\uff01' );
                        	}
                        	
                        else
                        	{
                        	//alert(data.error);
                        	$.messager.alert('\u63d0\u793a', '\u6dfb\u52a0\u5931\u8d25\uff01');
                        	}
                        	
                        //重新加载datagrid
                        $("#tab").datagrid('reload');
                        //关闭
                        $("#dd_dg").window('close');
                    },'json');
                }
            },
              {
                  text: "\u53d6\u6d88",
                  iconCls: "icon-cancel",
                  handler: function () {
                      $("#dd_dg").window("close");
                  }
              }
            ]
        });
      }
      //////////////////修改//////////////////
      function edit_dg() {
      //选中一行，获取这一行的属性的值
      	  var url="${otapp}/trip/activity/acti/modifyTimePrice.html?json=";
          var selected = $("#tab").datagrid('getSelected');
          //判断是否选中
          if (selected != null) {
        	  
              $("#original").val(selected.JSON_orignal);
              $("#special").val(selected.JSON_special);
              $("#tpid").val(selected.JSON_Id);
              //$("#start").datebox({value:function(){return selected.JSON_start}});
              $("#start").datetimebox('setValue', selected.JSON_start);
              $("#end").datetimebox('setValue', selected.JSON_end);
              //$("#end").val(selected.JSON_end);
              $("#dd_dg").show(); //显示修改窗体
        	 
              $("#dd_dg").dialog({
                  title: "\u7f16\u8f91\u4fe1\u606f",
                  iconCls: "icon-edit",
                  modal: true,//遮罩层
                  width: 300,
                  height: 200,
                  buttons: [
                  {
                      text: "\u7f16\u8f91",
                      iconCls: "icon-edit",
                      handler: function () {
                          var parm = $("#fm_dg").serialize();
                          //alert(parm);
                          var pp = decodeURIComponent(parm, true);
                          $.post(url,  pp , function (data) {
                              /*$.messager.show({
                                  title: "\u63d0\u793a",
                                  msg: data
                              });
                              */
                              var str = eval(data); 
                              if(data.error==1)
                          	{
                          	//alert(data.error);
                          	$.messager.alert('\u63d0\u793a', '\u4fee\u6539\u6210\u529f' );
                          	}
                          	
                          else
                          	{
                          	//alert(data.error);
                          	$.messager.alert('\u63d0\u793a', '\u4fee\u6539\u5931\u8d25');
                          	}
                              $("#tab").datagrid("reload");
                              $("#dd_dg").window("close");
                          },'json');
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
          } else {
              $.messager.alert('\u63d0\u793a','\u8bf7\u9009\u4e2d\u4e00\u884c\u5728\u8fdb\u884c\u7f16\u8f91');
          }

      }
    </script>
    
    <style type="text/css">
        input{ border:none; border-bottom:1px solid black;}
    </style>

  </head>
  
  <body>
		<table id="tab"></table>
			<input type="hidden" id="tabTitle" value='<font color="red">${actiTitle } </font>'>
			<input type="hidden" id="bsId" name="bsId" value="${actId}" />
			<input type="hidden" id="url" name="url" value="${otapp}/trip/activity/acti/getTimePrice.html?json="/>
			<input type="hidden" id="addurl" name="addurl" value="${otapp}/trip/activity/acti/addTimePrice.html?json="/>
			<input type="hidden" id="delurl" name="delurl" value="${otapp}/trip/activity/acti/delTimePrice.html?json="/>
			<input type="hidden" id="modurl" name="modurl" value="${otapp}/trip/activity/acti/modifyTimePrice.html?json=" >
<div id="tool">
       <table border="0" cellspacing="0" cellpadding="0" width="100%">
       	<tr>
       		<td style=" padding-left:2px">
                <a href="#" class="easyui-linkbutton" id="id_add" iconcls="icon-add"  plain="true" onclick="add_dg();" ><spring:message code="trip.manager.configure.manager.activity.price.add.addPrice" /></a>
                <a href="#" class="easyui-linkbutton" id="id_edit" iconCls="icon-edit"  plain="true" onclick="edit_dg();"><spring:message code="trip.manager.configure.manager.activity.price.add.modifyPrice" /></a>
                <a href="#" class="easyui-linkbutton" id="id_cancel " onclick="delete_dg();"  iconcls="icon-cancel" plain="true"><spring:message code="trip.manager.configure.manager.activity.price.add.delPrice" /></a>
            </td>
       	</tr>
       </table>
    </div>
    <br />
    <div id="dd_dg"  style=" display:none">
        <form id="fm_dg" action="${otapp}/trip/activity/acti/addTimePrice.html?" method="post">
        <input type="hidden" id="tpid" name="tpid" value="" />
        <input type="hidden" id="actid" name="actid" value="${ actId}" />
          <div>  <spring:message code="trip.manager.configure.manager.activity.price.add.originalPrice" /> :<input type="text" id="original" name="original" class="easyui-validatebox"  min="0.00" precision="2" required="true" missingMessage="<spring:message code="trip.manager.configure.manager.activity.price.add.MsgOriginalPrice" />" size="20" />
          </div>
          <div>
            <br />
             <spring:message code="trip.manager.configure.manager.activity.price.add.specialPrice" />:<input type="text" id="special" name="special" class="easyui-validatebox"  required="true" missingMessage="<spring:message code="trip.manager.configure.manager.activity.price.add.MsgSpecialPrice" />" size="20"/>
            </div>
            <div>
            <br />
            <spring:message code="trip.manager.configure.manager.activity.price.add.startTime" /><input type="text" id="start" name="start" class="easyui-datetimebox"  value="" />
            </div>
            <div>
            <br /> 
            <spring:message code="trip.manager.configure.manager.activity.price.add.endTime" /><input  type="text" id="end" class="easyui-datetimebox"  width="40px" name="end" value=""/>
            <br />
  			</div>
  	
        </form>
    </div>
  </body>
</html>
