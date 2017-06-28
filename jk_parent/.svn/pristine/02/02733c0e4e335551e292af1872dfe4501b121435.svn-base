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
<li id="save"><a href="#" onclick="formSubmit('feedbackAction_insert','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/note_edit.png"/>
   新增意见反馈
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
			<tr>
	            <td class="columnTitle">提议人:</td>
	            <td class="tableContent"><input type="text" name="inputBy" value=""/></td>
	            <td class="columnTitle">提议时间:</td>
	             <td class="tableContent">
					<input type="text" style="width:90px;" name="inputTime"
	            	 value=""
	             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">意见主题:</td>
	            <td class="tableContent"><input type="text" name="title" value=""/></td>
	            <td class="columnTitle">联系电话:</td>
	            <td class="tableContent"><input type="text" name="tel" value=""/></td>
	        </tr>	
			 <tr>
	            <td class="columnTitle">意见分类:</td><%-- 1管理2安全3建议4其他：--%>
	            <td class="tableContent">
				<select name="classType">
					<option value="0" selected>--请选择--</option>
					<option value="1">管理意见</option>
					<option value="2">安全意见</option>
					<option value="3">建议意见</option>
					<option value="4">其他意见</option>
				</select>
	            <td class="columnTitle">是否公开:</td><%-- 0 不公开    1公开--%>
	            <td class="tableContentAuto">
				<input type="radio" name="isShare" value="1">公开&nbsp; &nbsp;
				<input type="radio" name="isShare" value="0">不公开
				</td>
	        </tr>	
			 <tr>
	            <td class="columnTitle">意见内容:</td>
	            <td class="tableContent"><textarea name="content" cols="50" style="height: 150px"></textarea></td>
	        </tr>	

		</table>
	</div>
 
 
</form>
</body>
</html>

