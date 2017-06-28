<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
<%-- 	<script type="text/javascript" src="${ctx}/components/jquery-ui/jquery-1.2.6.js"></script> --%>
    <script type="text/javascript" src="${ctx}/js/tabledo.js"></script>	
	<script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/layer/jquery-1.11.0.min.js" ></script>
		
		  <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/layer/skin/layer.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/layer/skin/demo.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/default.css" media="all"/>
<!-- <script type="text/javascript" src="/components/jquery-ui/jquery-1.2.6.js"></script> -->
	<script language="javascript" src="${ctx}/js/common.js"></script> 
		<script type="text/javascript" src="${ctx}/layer/layer.js" ></script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="id" value="${id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" id="save1" onclick="ckeckedpasswordtwo();this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
<script type="text/javascript">
	function ckeckedpasswordtwo(){
		if($("#pass").val() == ""){
			layer.msg('新密码不能为空！请输入新密码');
			return false;
		}
		if($("#pass").val() != $("#repass").val()){
			layer.msg('两次输入的密码不一致，请重新输入');
			return false;
		}else{
			formSubmit('userAction_updateSelf','_self');
		}
	}
</script>

</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/enter.png"/>
   修改个人信息
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">新密码：</td>
	            <td class="tableContent"><input id="pass" type="password" name="password" value=""/></td>
	            <td class="columnTitle">再次输入密码：</td>
	            <td class="tableContent"><input type="password" 
	            	id="repass"
	             name="repassword" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">真实名称：</td>
	            <td class="tableContent"><input type="text" name="userInfo.name" value="${userInfo.name}"/></td>
	            <td class="columnTitle">生日：</td>
	            <td class="tableContent">
	            		<input type="text" style="width:90px;" name="userInfo.birthday"
	            	 value="<fmt:formatDate value="${userInfo.birthday}" pattern="yyyy-MM-dd"/>"
	             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">电话：</td>
	            <td class="tableContent"><input type="text" name="userInfo.telephone" value="${userInfo.telephone}"/></td>
	            <td class="columnTitle">性别：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" <c:if test="${userInfo.gender == 1 }">checked</c:if> name="userInfo.gender" value="1" class="input"/>男&nbsp;&nbsp;
	            	<input type="radio" <c:if test="${userInfo.gender == 0 }">checked</c:if> name="userInfo.gender" value="0" class="input"/>女
	            </td>
	        </tr>	
	        
		</table>
	</div>
 
 
</form>
</body>
<script type="text/javascript">
	$(function(){
		$("#repass").blur(function(){
			//alert($("#pass").val());
			//alert($("#repass").val());
			if($("#pass").val() != $("#repass").val()){
				layer.msg('两次输入的密码不一致，请重新输入');
				//$("#save1").prop("disabled","disabled");
			}
		})
	})
</script>
</html>

