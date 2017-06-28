<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/components/jquery-ui/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="ccc('toview')">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('packingListAction_tocreate','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="bbb('toupdate')">修改</a></li>
<li id="delete"><a href="#" onclick="aaa('delete')">删除</a></li>
<li id="submit"><a href="#" onclick="aaa('delete')">提交</a></li>
<li id="delete"><a href="#" onclick="aaa('delete')">删除</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    装箱单列表
  </div> 
  
<div>
<div>
	<table>
		<tr>
			<td>
				<form id="paramsSelect" method="post">
					 	买方:<input type="text" name="buyer" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
					 	发票号:<input type="text" name="invoiceNo" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
					 	发票日期:<input type="text" style="width:90px;" name="invoiceDate" value="" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
					 	&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" onclick="formSubmit('packingListAction_paramsSelect','_self');this.blur();" value="提交查询"/>
				</form>
			</td>
		</tr>
	</table>
</div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" value = "" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">卖方</td>
		<td class="tableHeader">买方</td>
		<td class="tableHeader">发票号</td>
		<td class="tableHeader">发票日期</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
${links}
	
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.seller}</td>
		<td>${o.buyer}</td>
		<td>${o.invoiceNo}</td>
		<td>${o.invoiceDate}</td>
		<td>
		<c:if test="${o.state==0}">草稿</c:if>
		<c:if test="${o.state==1}"><b><font color="green">已上报</font></b></c:if>
		<c:if test="${o.state==2}"><b><font color="red">已委托</font></b></c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
<script type="text/javascript">
	function aaa(str){
		var myArray = getArray();
		if(a1(myArray)){
			alert("请至少选择一个在删除");
		}else{
			var url = "${ctx }/cargo/packingListAction_getJsonStr";
			var param = {"id":myArray.toString()};
			$.post(url,param,function(data){
				if(data == "false"){
					alert("装箱单已上报,请修改后在试!");
				}else{
					document.forms['icform'].action = "${ctx}/cargo/packingListAction_"+str;
					document.forms['icform'].submit();
				}
			})
		} 
	}
	
	function ccc(str){
		var myArray = getArray();
		if(a1(myArray)){
			alert("请至少选择一个在查看");
		}else{
			document.forms['icform'].action = "${ctx}/cargo/packingListAction_"+str;
			document.forms['icform'].submit();
		}
	}
	
	function getArray(){
		var myArray=new Array();
		$.each($("input:checkbox:checked"),function(){
			myArray.push($(this).val());
		});
		return myArray;
	}
	
	function a1(array){
		if(array.length==0){
			return true;
		}else{
			return false;
		}
	}
	
	function bbb(str){
		var myArray = getArray();
		if(a1(myArray)){
			alert("请至少选择一个在修改");
		}else if(myArray.length>1){
			alert("请不要选择多个");
		}else{
			var url = "${ctx }/cargo/packingListAction_getJsonStr";
			var param = {"id":myArray.toString()};
			$.post(url,param,function(data){
				if(data == "false"){
					alert("装箱单已上报,请修改后在试!");
				}else{
					document.forms['icform'].action = "${ctx}/cargo/packingListAction_"+str;
					document.forms['icform'].submit();
				}
			})
		}
	}
</script>
</body>
</html>

