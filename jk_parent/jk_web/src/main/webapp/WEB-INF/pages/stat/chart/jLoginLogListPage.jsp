<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<!-- <li id="view"><a href="#" onclick="formSubmit('loginLogAction_toview','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('loginLogAction_tocreate','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('loginLogAction_toupdate','_self');this.blur();">修改</a></li> 
<li id="delete"><a href="#" onclick="formSubmit('loginLogAction_delete','_self');this.blur();">删除</a></li>-->
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
日志列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<!-- <td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td> -->
		<td class="tableHeader">序号</td>
		<td class="tableHeader">账号</td>
		<td class="tableHeader">IP地址</td>
		<td class="tableHeader">登录时间</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
${links}
	
	<c:forEach items="${page.results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<%-- <td><input type="checkbox" name="id" value="${o.id}"/></td> --%>
		<td>${status.index+1}</td>
		<td>${o.loginName}</td>
		<td>${o.ipAddress}</td>
		<td>${o.loginTime}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

