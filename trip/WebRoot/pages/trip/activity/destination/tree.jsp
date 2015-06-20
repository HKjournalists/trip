<%@include file="../../../general/headerztree.jsp"%>
<script type="text/javascript">
 /**
 * @see ztree树设置
 */
var setting = {  
    view: {  
        selectedMulti: false  
    },data: {  
        simpleData: {  
            enable: true  
        }  
    },callback: {  
        onClick: clickMenuNode  
    }  
}; 

/**
 * @see 初始化
 */
$(document).ready(function(){
	$.post('${otapp}/trip/activity/destination/json_tree.html?json',{},function(data, textStatus){  
		 $.fn.zTree.init($("#destinationTree"), setting,data);  
	},"json"); 
	
	
});

/**
 * @see 点击菜单节点
 */
function clickMenuNode(event, treeId, treeNode){
	$("#destinationConetnt",parent.document.body).attr("src","${otapp}/trip/activity/destination/view.html?ad.fsId="+treeNode.id);
} 


</script>
<style>
.body:ACTIVE{
	width: 100%;
    height: 100%;
    top:0px;
    margin: 0px auto;
    position: relative;
    background: #e9f2f7;
}
</style>
<body>
<ul id="destinationTree" class="ztree"></ul>
</body>
</html>