<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="id" value="${id}"/>
	<input type="hidden" name="state" value="1"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('feedbackAction_resolve','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/note_edit.png"/>
   处理信息
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
	            <td class="columnTitle">意见分类</td><%--1管理   2安全   3建议   4其他：if遍历判断--%>
	            <td class="tableContent">
	                <c:if test="${classType==1}">管理意见</c:if>
					<c:if test="${classType==2}">安全意见</c:if>
					<c:if test="${classType==3}">建议意见</c:if>
					<c:if test="${classType==4}">其他意见</c:if>
	            </td>
				 <td class="columnTitle">是否公开</td><%--0不公开1公开：--%>
	             <td class="tableContentAuto"><%--添加if标签${isShare}比较是否相等默认选--%>
	            	<c:if test="${isShare==0}">不公开</c:if>
					<c:if test="${isShare==1}">公开</c:if>
				</td>
	        </tr>
			<tr>
			  <td class="columnTitle">处理人</td>
				<td class="tableContent"><input type="text" name="answerBy" value=""/></td>
	            <td class="columnTitle">处理时间:</td>
				<td class="tableContent">
					<input type="text" style="width:90px;" name="answerTime"
	            	 value=""
	             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	        </tr>	
			 <tr>
	            <td class="columnTitle">解决难度</td><%--1极难   2比较难   3有难度   4一般：--%>
				<%--星星级别--%>
				 <td class="tableContentAuto">
	            	<input type="radio" name="difficulty" value="1" class="input">★★★★&nbsp;&nbsp;
	            	<input type="radio" name="difficulty" value="2" class="input">★★★&nbsp;&nbsp;
	            	<input type="radio" name="difficulty" value="3" class="input">★★&nbsp;&nbsp;
	            	<input type="radio" name="difficulty" value="4" class="input">★
	            </td>
				<td class="columnTitle">解决办法:</td>
				<td class="tableContent"><textarea name="solveMethod"  rows="50" cols="50" style="height: 50px"></textarea></td>
	        </tr>	
		</table>
	</div>
</form>
</body>
</html>

