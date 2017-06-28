<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
	
	<script type="text/javascript" src="${ctx}/components/zTree/js/jquery-1.4.4.min.js"></script>
	
	
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="look('toview')">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('invoiceAction_tocreate','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="ddd('toupdate');">修改</a></li>
<li id="update"><a href="#" onclick="ddd('submit')"">提交</a></li>
<li id="update"><a href="#" onclick="ccc('cancel')">取消</a></li>
<li id="delete"><a href="#" onclick="ddd('delete')">删除</a></li>
<li id="new"><a href="#" onclick="print('print')">打印</a></li>




<script type="text/javascript">
function isOnlyChecked(){
	 var checkBoxArray = document.getElementsByName('id');
		var count=0;
		for(var index=0; index<checkBoxArray.length; index++) {
			if (checkBoxArray[index].checked) {
				count++;
			}	
		}
	//jquery
	//var count = $("[input name='id']:checked").size();
	if(count==1)
		return true;
	else if (count==0)
		return 0;
	else
		return false;
}
/* //实现更新
function to2222Update(){
	 if(isOnlyChecked()){
		 formSubmit('deptAction_toupdate','_self');
	 }else{
		 alert("请先选择一项并且只能选择一项，再进行操作！");
	 }
} */





	function ddd(str) {
		/*  if(isOnlyChecked()==0){
			 alert("至少勾选一个");
			 
		 }else  */if(isOnlyChecked()){
			
			
			
		
		
		var array = new Array();
		$.each($("input:checkbox:checked"),function(){
		
			array.push($(this).val())
			
		}) 
		
		
		var url = "${ctx}/cargo/invoiceAction_getState";
		var param = {"id":array.toString()};
		
		$.post(url,param,function(data){
		
		if(data=="0.0"){
			document.forms['icform'].action = "${ctx}/cargo/invoiceAction_"+str;
			document.forms['icform'].submit();
		}else if(data=="1.0"){
				alert("发票已上报,仅草稿状态允许操作");
					
		}else if(data=="2.0"){
				alert("发票已上报财务,不允许操作");
					
		}
		})
		
		
		
		}else{
			alert("请先选择一项并且只能选择一项，再进行操作！")
		}
	}
	
	
	
function ccc(str) {
	
	if(isOnlyChecked()){
		
		var array = new Array();
		$.each($("input:checkbox:checked"),function(){
		
			array.push($(this).val())
			
		}) 
		
		
		var url = "${ctx}/cargo/invoiceAction_getState";
		var param = {"id":array.toString()};
		
		$.post(url,param,function(data){
		
		if(data=="0.0"){
			alert("已为草稿状态");
		}else if(data=="1.0"){
			document.forms['icform'].action = "${ctx}/cargo/invoiceAction_"+str;
			document.forms['icform'].submit();
					
		}else if(data=="2.0"){
				alert("发票已上报财务,不允许操作");
					
		}
		})
		
		
	}else{
		alert("请先选择一项并且只能选择一项，再进行操作！")
	}
	}
	
	
//查看
function look(str) {
	if(isOnlyChecked()){
	var array = new Array();
	$.each($("input:checkbox:checked"),function(){
	
		array.push($(this).val())
	}) 
	var url = "${ctx}/cargo/invoiceAction_getState";
	var param = {"id":array.toString()};
	$.post(url,param,function(data){
		document.forms['icform'].action = "${ctx}/cargo/invoiceAction_"+str;
		document.forms['icform'].submit();
	
	})
	}else{
		alert("请先选择一项并且只能选择一项，再进行操作！")
	}
}
//打印
function print(str) {
	if(isOnlyChecked()){
	var array = new Array();
	$.each($("input:checkbox:checked"),function(){
	
		array.push($(this).val())
	}) 
	var url = "${ctx}/cargo/invoiceAction_getState";
	var param = {"id":array.toString()};
	$.post(url,param,function(data){
		document.forms['icform'].action = "${ctx}/cargo/invoiceAction_"+str;
		document.forms['icform'].submit();
	
	})
	}else{
		alert("请先选择一项并且只能选择一项，再进行操作！")
	}
}
</script>



</ul>



  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    发票列表
  </div> 
  
<div>
<div>
	<table>
		<tr>
			<td>
				<form id="paramsSelect" method="post">
					 	创建人:<input type="text" name="createBy" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
					 	创建部门:<input type="text" name="createDept" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
					 	创建日期:<input type="text" style="width:90px;" name="createTime" value="" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
					 	&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" onclick="formSubmit('invoiceAction_paramsSelect','_self');this.blur();" value="提交查询"/>
				</form>
			</td>
		</tr>
	</table>
</div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">SC_NO</td>
		<td class="tableHeader">BL_NO</td>
		<td class="tableHeader">贸易条款</td>
		<td class="tableHeader">创建人</td>
		<td class="tableHeader">创建部门</td>
		<td class="tableHeader">创建日期</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
${links}
	
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.scNo}</td>
		<td>${o.blNo}</td>
		<td>${o.tradeTerms}</td>
		<td>${o.createBy}</td>
		<td>${o.createDept}</td>
		<td>${o.createTime}</td>
		<td>
		<c:if test="${o.state == 0}">草稿</c:if>
		<c:if test="${o.state == 1}">
			<font color="green">已上报</font>
		</c:if>
		<c:if test="${o.state == 2}">
			<font color="green">已上报财务</font>
		</c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

