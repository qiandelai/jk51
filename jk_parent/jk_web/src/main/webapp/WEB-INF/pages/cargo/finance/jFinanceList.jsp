<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>

	<script type="text/javascript" src="${ctx }/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript">
	/* 判断是否在前台页面上勾选 */
	function isOnlyChecked() {
		var checkBoxArray = document.getElementsByName('id');
		var count = 0;
		for (var index = 0; index < checkBoxArray.length; index++) {
			if (checkBoxArray[index].checked) {
				count++;
			}
		}
		if (count >0){
			return true;
		}else{
			return false;
		}
	}
	
	 function toCancel(){
			if (isOnlyChecked()) {
				formSubmit('financeAction_cancel','_self');
			} else {
				alert("请至少选择一条数据！");
			}  
		}    
	 
	 function toView(){
			if (isOnlyChecked()) {
					formSubmit('financeAction_toview','_self');
			} else {
				alert("请至少选择一条数据！");
			}  
		}    
	 function toCreate(){
			if (isOnlyChecked()) {
					formSubmit('financeAction_tocreate','_self');
			} else {
				alert("请至少选择一条数据！");
			}  
		}    
	 function toUpdate(){
			if (isOnlyChecked()) {
					formSubmit('financeAction_toupdate','_self');
			} else {
				alert("请至少选择一条数据！");
			}  
		}    
	 function toSubmit(){
			if (isOnlyChecked()) {
					formSubmit('financeAction_submit','_self');
			} else {
				alert("请至少选择一条数据！");
			}  
		}    
	
	
	function toDelete(){
		if (isOnlyChecked()) {
		var checkBoxArray = document.getElementsByName('id');
		var count = 0;
		for (var index = 0; index < checkBoxArray.length; index++) {
			if (checkBoxArray[index].checked) {
				var nextType = checkBoxArray[index].nextSibling;
				var span = nextType.nextSibling;
				var state = span.lastChild.nodeValue;
				if(state==1.0){
					count++;
				}
			}
			if (count ==0){
				formSubmit('financeAction_delete', '_self');
			}else{
				alert("报运单已提交，请取消再操作！");
			}
		}
		}else{
			alert("请至少选择一条数据！");
		}

	}
	</script>

	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>

</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="javascript:toView()">查看</a></li>
<li id="new"><a href="#" onclick="javascript:toCreate()">新增</a></li>
<li id="update"><a href="#" onclick="javascript:toUpdate()">修改</a></li>
<li id="submit"><a href="#" onclick="javascript:toSubmit()">提交</a></li>
<li id="delete"><a href="#" onclick="javascript:toCancel()">取消</a></li>
<li id="delete"><a href="#" onclick="javascript:toDelete()">删除</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    财务报运单列表
  </div> 
  
<div>
<div>
	<table>
		<tr>
			<td>
				<form id="paramsSelect" method="post">
					 	制单人:<input type="text" name="inputBy" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
					 	制单日期:<input type="text" style="width:90px;" name="inputDate" value="" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
					 	&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" onclick="formSubmit('financeAction_paramsSelect','_self');this.blur();" value="提交查询"/>
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
		<td class="tableHeader">报运单号</td>
		<td class="tableHeader">制单人</td>
		<td class="tableHeader">制单日期</td>
		<td class="tableHeader">报运单状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
${links}
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td>
		<input id="one" type="checkbox" name="id" value="${o.id}"/>
		<span id="two"  style="display: none;">${o.state}</span>
		</td>
		<td>${o.id}</td>
		<td>${o.inputBy}</td>
		<td>${o.inputDate}</td>
		<td>
			<c:if test="${o.state==0.0}">草稿</c:if>
			<c:if test="${o.state==1.0}"><font color="green">已报运</font></c:if>
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

