<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx}/layer/jquery-1.11.0.min.js" ></script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('memorandumAction_insert','_parent');this.blur();">保存</a></li>
<!-- <li id="back"><a href="#" onclick="history.go(-1);">返回</a></li> -->
</ul>

  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/enter.png"/>
   新建备忘
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
		<tr>
	            <td class="columnTitle">备忘内容：</td>
	            <td class="tableContent" colspan="3">
	            	<textarea style="height: 100px" cols="100" name="context"></textarea>
	            </td>
	        </tr>
	        <script type="text/javascript">
				function changeColor(){
					var color = $("#background :selected").val();
					var obj = document.getElementById("x2");
					obj.style.backgroundColor = color;
					//obj.style.backgroundColor = "#EDFEB7";
				}
			</script>
	        <tr>
	            <td class="columnTitle">背景颜色：</td>
	            <td class="tableContent">
	            	<div id="x2" style="background-color: #C0FFE5;height: 25px;width: 60px;display: inline-block;" ></div>
					<SELECT id="background" name="background" onChange="changeColor()">
							
								<option value="#C0FFE5">1</option>
								<option value="#C9FFC7">2</option>
								<option value="#CBF3FF">3</option>
								<option value="#EDFEB7">4</option>
								<option value="#FFE0FB">5</option>
								<option value="#FFE7E8">6</option>
								<option value="#FFEDCC">7</option>
								<option value="#FFFFFF">8</option>
							
					</SELECT>
	            </td>
	            <td class="columnTitle">图标：</td>
					<td class="tableContent">
					<img src="${ctx}/images/olmsg/0.gif" name="x1"> 
					<SELECT name="icon" onChange="document.x1.src=options[selectedIndex].value">
							<c:forEach begin="0" end="8" var="i">
								<option value="${ctx}/images/olmsg/${i}.gif">${i}.jpg</option>
							</c:forEach>
					</SELECT>
					</td>
				</tr>	
	        	
		</table>
	</div>
 
 
</form>
</body>
</html>

