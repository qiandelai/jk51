<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> --%>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
	<title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/layer/skin/layer.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/layer/skin/demo.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/default.css" media="all"/>
<!-- <script type="text/javascript" src="/components/jquery-ui/jquery-1.2.6.js"></script> -->
	<script language="javascript" src="${ctx}/js/common.js"></script> 
	<script type="text/javascript" src="${ctx}/layer/jquery-1.11.0.min.js" ></script>
		<script type="text/javascript" src="${ctx}/layer/layer.js" ></script>
			
<style> 
	.curbody{ CURSOR: url(${ctx}/images/olmsg/shubiao.ani);background:url(${ctx}/images/olmsg/pic738x571.jpg); }
	.msgcontent{ width:218px;overflow:hidden;word-break:break-all;padding:10px;font-size:14px;color:#339966;font-family:Tahoma;line-height:180%; }
	.msgcontent p{ text-indent:0px;}
	.msgcontent ul( margin:0px;}
	.msgbackcontent{ width:218px;overflow:hidden;word-break:break-all;padding:10px;font-size:14px;color:#339966;font-family:Tahoma;line-height:180%; }
	.msgbackcontent p{ text-indent:0px;}
	.msgbackcontent ul( margin:0px;}
	li{ text-indent:0px;margin:0px;list-style:default; }
</style>
	
</head>
<script language="javascript"> 
if(top.location!=top.location){
	top.location = main.location;
}
//-- 控制层移动start of script -->
var Obj='';
var index=10000;//z-index;
var color='';
var str='';

document.onmouseup=MUp
document.onmousemove=MMove
function MMove(){
	if(Obj!=''){
		document.getElementById(Obj).style.left=event.x-pX+"px";
		document.getElementById(Obj).style.top=event.y-pY+"px";
	}
}
 
function MUp(){
	if(Obj!=''){
		//div.releaseCapture();
		/* var left = document.getElementById(Obj).style.left;
		$("#mr_left").val(left);
		var top = document.getElementById(Obj).style.top;
		$("#mr_top").val(top);
		alert(Obj);
		alert(left);
		alert(top); */
		Obj='';
	}
	var srcEle = event.srcElement;
	
	var children = srcEle.children;
	if(children.length>0){
		children[1].value = "1";		//isChange
		children[2].value = event.x-pX;
		children[3].value = event.y-pY;
	}
}
 
function MDown(objtd,id){
	Obj=id
	//document.all(Obj).setCapture()
	pX = event.x-document.getElementById(Obj).style.left.split("px")[0];
	pY = event.y-document.getElementById(Obj).style.top.split("px")[0];
}

//-- 控制层移动end of script -->
//获得焦点;
function getFocus(obj)
{
       if(obj.style.zIndex!=index)
       {
               index = index + 2;
               var idx = index;
               obj.style.zIndex=idx;
               //obj.nextSibling.style.zIndex=idx-1;
       }
}
 
//针对未已阅的、未回复的、工作任务
function msgrevoke( id ){
	if(confirm("是否确定要撤销此条信息?")){
		//_Submit("/home/olmsgRevokeAction.do?flag=revoke&id="+id,null,"撤销");
	}
}
 
//需回复的留言
function msgback( id ){
	//_Submit("/home/olmsgUpdateAction.do?flag=back&id="+id,null,"回复");
}
 
/* function msgupdate( id , flag ){
	if(flag=="read"){
		if(!confirm("是否确定已阅此条信息?")){
			return false;
		}
	}else if(flag=="accept"){
		if(!confirm("是否确定接受此任务?")){
			return false;
		}
	}else if(flag=="fail"){
		if(!confirm("是否确定此任务未完成?")){
			return false;
		}
	}else if(flag=="success"){
		if(!confirm("是否确定此任务已完成?")){
			return false;
		}
	}else if(flag=="finished"){
		if(!confirm("是否确定完成?")){
			return false;
		}
	}
	//_Submit("/home/olmsgUpdateAction.do?flag="+flag+"&id="+id,null,"修改");
	
} */
 
function msgdel( id ){
	if(confirm("是否确定要删除此条信息?")){
		window.location = "${ctx}/memorandumAction_deleteById.action?id="+id;
	}
}
 
function msgstate( id , flag ){
	if(flag=="read"){
		if(!confirm("是否确定已阅此条信息?")){
			return false;
		}
	}else if(flag=="accept"){
		if(!confirm("是否确定接受此任务?")){
			return false;
		}
	}else if(flag=="fail"){
		if(!confirm("是否确定此任务未完成?")){
			return false;
		}
	}else if(flag=="success"){
		if(!confirm("是否确定此任务已完成?")){
			return false;
		}
	}else if(flag=="finished"){
		if(!confirm("是否确定完成?")){
			return false;
		}
	}
	//_Submit("/home/olmsgStateAction.do?flag="+flag+"&delId="+id,null,"已阅");
}
 
function changRowColor(obj){
	//obj.removeAttribute("className");
	//alert(obj.className);
	//obj.setAttribute("bgcolor","#FFECB0");
	//obj.sytle.backgroundColor = "#FFECB0";
}
 
function removeOverRowColor(obj){
	//alert(obj.getAttribute("style"));
}
 
function killErrors() {
	return true;
}
 
window.onerror = killErrors;


function updateMemorandum(id){
	layer.open({
        type: 2,//0:信息框; 1:页面; 2:iframe层;	3:加载层;	4:tip层
        title:"修改备忘",//标题
        area: ['800px', '350px'],//大小
        //skin: 'layui-layer-demo', //样式类名
        shadeClose: false, //点击弹层外区域 遮罩关闭
        content: '${ctx}/memorandumAction_toupdate.action?id='+id//内容
    });  
}
</script>
 
<body class="curbody">
 
<form name="form2" method="post">
<!-- 工具栏部分 ToolBar -->
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
 
<li id="new"><a href="#" onclick="newMemorandum()">新建</a></li>
<script language="javascript">
	function newMemorandum(){
		 layer.open({
	        type: 2,//0:信息框; 1:页面; 2:iframe层;	3:加载层;	4:tip层
	        title:"新建备忘",//标题
	        area: ['800px', '350px'],//大小
	        //skin: 'layui-layer-demo', //样式类名
	        shadeClose: false, //点击弹层外区域 遮罩关闭
	        content: '${ctx}/memorandumAction_tocreate.action'//内容
	    });  
	
	}
</script>
<li id="save"><a href="#" title="保存留言窗口的位置信息"
onclick="formSubmit('memorandumAction_updateLocation','_self');this.blur();"
>位置</a></li>
 
<!-- <li id="stat"><a href="#">历史</a></li> -->
 
</ul>
    </div>
</div>
</div>
</div>
 
<logic:notEmpty name="olmsgList">
 
 	<c:forEach items="${mList }" var="m">
 	
 	<input type="hidden" name="mr_id" value="${m.id }">
 <%-- 	<input type="hidden" name="mr_left" value="${m.left }">
 	<input type="hidden" name="mr_top" value="${m.top }"> --%>
 	
	<div id='${m.id }'
		style='position: absolute; left: ${m.left}px; top: ${m.top }px; z-index: 1001; height: 164px; background: none;'
		onmousedown='getFocus(this)'>
		<table border=0 cellspacing="0" cellpadding="0" width="220">
			<tr>
				<td style='cursor: move;'
					onmousedown="MDown(this,'${m.id}')"
					background="${ctx}/images/olmsg/${m.background}1.gif" height="45"><input
					type="hidden" name="id" class="input"
					value="${m.id }" /> <input type="hidden"
					name="isChange" class="input" value="0" /> <input type="hidden"
					name="posX" class="input" value="${m.left }" /> <input type="hidden"
					name="posY" class="input" value="${m.top }" /> &nbsp;</td>
			</tr>
			<tr>
				<td style='cursor: move; white-space: nowrap;' width='100%'
					onmousedown="MDown('${m.id}')"
					background="${ctx}/images/olmsg/${m.background}2.gif">
					<div
						style="float: left; width: 130px; padding-left: 7px; font-family: Tahoma; color: gray; font-style: oblique;">
						${m.createtime}</div>
					<div
						style="float: right; width: 80px; text-align: right; padding-right: 7px;">
						<a style='cursor: pointer;' title="编辑" onclick="updateMemorandum('${m.id}')" ><img
							src="${ctx}/images/olmsg/doc_edit.gif" /></a>
							
							 <a style='cursor: pointer;' title="删除"
							onclick="msgdel('${m.id}')"><img
							src="${ctx}/images/olmsg/doc_del.gif" /></a>
					</div>
				</td>
			</tr>
			<tr>
				<td background="${ctx}/images/olmsg/${m.background}2.gif">
					<div class="msgcontent">${m.context }</div>
				</td>
			</tr>
			<tr>
				<td id="tagBPic" background="${ctx}/images/olmsg/${m.background}3.gif"
					height="63">
					<table border="0" width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td width="50" align="center"><img border="0"
								src="${m.icon }"></td>
							<td style="text-align: right; padding-right: 8px;" nowrap>
								[备忘] <!-- [回复] --> <!-- [回执] --> <!-- [撤销原因] --> <!-- state==99[完成] -->
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
	</c:forEach>
	
	
		
		<%-- <div id='ff8080813d00613e013d0067909e0009' style='position:absolute;left:122px;top:97px;z-index:1001; height:164px;background:none;' onmousedown='getFocus(this)'>
			<table border=0 cellspacing="0" cellpadding="0" width="220">
				<tr>
					<td style='cursor:move;' onmousedown="MDown(this,'ff8080813d00613e013d0067909e0009')" background="${ctx}/images/olmsg/C0FFE51.gif" height="45">
						<input type="hidden" name="id" class="input" value="ff8080813d00613e013d0067909e0009" />
						<input type="hidden" name="isChange" class="input" value="0" />
						<input type="hidden" name="posX" class="input" value="122" />
						<input type="hidden" name="posY" class="input" value="97" />
						&nbsp;
						
					</td>
				</tr>
				<tr>
					<td style='cursor:move;white-space:nowrap;' width='100%' onmousedown="MDown('ff8080813d00613e013d0067909e0009')" background="${ctx}/images/olmsg/C0FFE52.gif" >
						<div style="float:left;width:130px;padding-left:7px;font-family:Tahoma;color:gray;font-style : oblique;">
							2013-02-22 13:37
						</div>
						<div style="float:right;width:80px;text-align:right;padding-right:7px;">
							
							
							
							
							
							
							
							
							
							
							
																					
							
							<a style='cursor:pointer;' title="编辑" onclick="msgupdate('ff8080813d00613e013d0067909e0009','edit')"><img src="${ctx}/images/olmsg/doc_edit.gif"/></a>
							
							
							
							
							
							
							
							<a style='cursor:pointer;' title="删除" onclick="msgdel('ff8080813d00613e013d0067909e0009')"><img src="${ctx}/images/olmsg/doc_del.gif"/></a>
							
							
							
						</div>
					</td>
				</tr>
				<tr>
					<td background="${ctx}/images/olmsg/C0FFE52.gif">
					<div class="msgcontent">
					欢迎使用杰管理平台
					</div>
					
					
					</td>
				</tr>
				<tr>
					<td id="tagBPic" background="${ctx}/images/olmsg/C0FFE53.gif" height="63">
						<table border="0" width="100%" cellspacing="0" cellpadding="0">
							<tr>
								<td width="50" align="center">
								<img border="0" src="${ctx}/images/olmsg/2.gif">
								</td>
								<td style="text-align:right;padding-right:8px;" nowrap>
								[备忘]
								
								
								
								 <!-- [回复] -->
								
								
										<!-- [回执] -->
								
								
													<!-- [撤销原因] -->
								
								<!-- state==99[完成] -->
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	
		
		<div id='ff8080813d00613e013d00681494000a' style='position:absolute;left:442px;top:91px;z-index:1002; height:164px;background:none;' onmousedown='getFocus(this)'>
			<table border=0 cellspacing="0" cellpadding="0" width="220" >
				<tr>
					<td style='cursor:move;' onmousedown="MDown(this,'ff8080813d00613e013d00681494000a')"  background="${ctx}/images/olmsg/FFE7E81.gif" height="45">
						<input type="hidden" name="id" class="input" value="ff8080813d00613e013d00681494000a" />
						<input type="hidden" name="isChange" class="input" value="0" />
						<input type="hidden" name="posX" class="input" value="442" />
						<input type="hidden" name="posY" class="input" value="91" />
						&nbsp;
						
					</td>
				</tr>
				<tr>
					<td style='cursor:move;white-space:nowrap;' width='100%' onmousedown="MDown('ff8080813d00613e013d00681494000a')" background="${ctx}/images/olmsg/FFE7E82.gif" >
						<div style="float:left;width:130px;padding-left:7px;font-family:Tahoma;color:gray;font-style : oblique;">
							2013-02-22 13:37
						</div>
						<div style="float:right;width:80px;text-align:right;padding-right:7px;">
							
							
							
							
							
							
							
							
							
							
							
																					
							
							<a style='cursor:pointer;' title="编辑" onclick="msgupdate('ff8080813d00613e013d00681494000a','edit')"><img src="${ctx}/images/olmsg/doc_edit.gif"/></a>
							
							
							
							
							
							
							
							<a style='cursor:pointer;' title="删除" onclick="msgdel('ff8080813d00613e013d00681494000a')"><img src="${ctx}/images/olmsg/doc_del.gif"/></a>
							
							
							
						</div>
					</td>
				</tr>
				<tr>
					<td background="${ctx}/images/olmsg/FFE7E82.gif">
					<div class="msgcontent">
					本系统实现货运企业日常管理<br />
包括合同、报运、装箱、委托、发票等业务
					</div>
					
					
					</td>
				</tr>
				<tr>
					<td id="tagBPic" background="${ctx}/images/olmsg/FFE7E83.gif" height="63">
						<table border="0" width="100%" cellspacing="0" cellpadding="0">
							<tr>
								<td width="50" align="center">
								<img border="0" src="${ctx}/images/olmsg/0.gif">
								</td>
								<td style="text-align:right;padding-right:8px;" nowrap>
								[备忘]
								
								
								
								 <!-- [回复] -->
								
								
										<!-- [回执] -->
								
								
													<!-- [撤销原因] -->
								
								<!-- state==99[完成] -->
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div> --%>
<!-- 	<div style=": "></div> -->
</logic:notEmpty>
 
 
</form>
</body>
</html>

