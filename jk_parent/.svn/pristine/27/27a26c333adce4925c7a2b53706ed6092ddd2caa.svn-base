<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/note_view.png"/>
   反馈详情
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">提议人</td>
	            <td class="tableContent">${inputBy}</td>
	            <td class="columnTitle">提议时间</td>
	            <td class="tableContent">${inputTime}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">意见主题</td>
	            <td class="tableContent">${title}</td>
	            <td class="columnTitle">联系电话</td>
	            <td class="tableContent">${tel}</td>
	        </tr>	
			 <tr>
	            <td class="columnTitle">意见分类</td><%--1管理   2安全   3建议   4其他：--%>
	            <td class="tableContent">
			        <c:if test="${classType==1}">管理意见</c:if>
					<c:if test="${classType==2}">安全意见</c:if>
					<c:if test="${classType==3}">建议意见</c:if>
					<c:if test="${classType==4}">其他意见</c:if>
	            </td>
				<td class="columnTitle">是否公开</td><%--0不公开1公开：--%>
	            <td class="tableContent">
	          		 <!-- 0未处理  1已处理 -->
					<c:if test="${isShare==0}">不公开</c:if>
					<c:if test="${isShare==1}">公开</c:if>
	           </td>
	        </tr>	
			 <tr>
	            
	            <td class="columnTitle">处理人</td>
	            <td class="tableContent">${answerBy}</td>
				 <td class="columnTitle">处理时间:</td>
	            <td class="tableContent">${answerTime}</td>
	        </tr>	
			 <tr>
	            <td class="columnTitle">是否处理:</td><%--0未处理1已处理：--%>
	            <td class="tableContent">
		            <c:if test="${state==0}"><font color="red">未处理</font></c:if>
					<c:if test="${state==1}"><font color="green">已处理</font></c:if>
	           </td>
	            <td class="columnTitle">解决难度</td><%--1极难   2比较难   3有难度   4一般：★★★★--%>
	            <td class="tableContentAuto">
	            	 <c:if test="${difficulty==1}">★★★★</c:if>
	            	 <c:if test="${difficulty==2}">★★★</c:if>
	            	 <c:if test="${difficulty==3}">★★</c:if>
	            	 <c:if test="${difficulty==4}">★</c:if>
	            </td>
	        </tr>	
			 <tr>
	            <td class="columnTitle">解决办法:</td>
<!-- 	        <td class="tableContent"><textarea name="content" cols="50" style="height: 150px"></textarea></td> -->
	            
	            <td class="tableContent">${solveMethod}</td>
	            <td class="columnTitle">意见内容:</td>
	            <td class="tableContent">${content}</td>
	        </tr>	
		</table>
	</div>
</form>
</body>
</html>

