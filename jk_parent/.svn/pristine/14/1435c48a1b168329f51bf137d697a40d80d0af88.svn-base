<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx}/layer/jquery-1.11.0.min.js" ></script>
</head>

<body>
<form name="icform" method="post">

	<input type="hidden" name="id" value="${id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('memorandumAction_update','_parent');this.blur();">保存</a></li>

<!-- <li id="back"><a href="#" onclick="history.go(-1);">返回</a></li> -->
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
		<img src="${ctx }/skin/default/images/icon/enter.png"/>
   修改备忘录
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
		<tr>
	            <td class="columnTitle">备忘内容：</td>
	            <td class="tableContent" colspan="3">
	            	<textarea style="height: 100px" cols="100" name="context" >${context }</textarea>
	            </td>
	        </tr>
	        <script type="text/javascript">
				function changeColor(){
					var color = $("#background :selected").val();
					var obj = document.getElementById("x2");
					obj.style.backgroundColor = "#"+color;
					//obj.style.backgroundColor = "#EDFEB7";
				}
			</script>
	        <tr>
	            <td class="columnTitle">背景颜色：</td>
	            <td class="tableContent">
	            	<div id="x2" style="background-color: #${background};height: 25px;width: 60px;display: inline-block;" ></div>
					<SELECT id="background" name="background" onChange="changeColor()">
<%-- 							<c:if test="${background =  }">selected</c:if> --%>
		<option <c:if test="${background == 'C0FFE5' }">selected</c:if> value="C0FFE5">1</option>
		<option <c:if test="${background == 'C9FFC7' }">selected</c:if> value="C9FFC7">2</option>
		<option <c:if test="${background == 'CBF3FF' }">selected</c:if> value="CBF3FF">3</option>
		<option <c:if test="${background == 'EDFEB7' }">selected</c:if> value="EDFEB7">4</option>
		<option <c:if test="${background == 'FFE0FB' }">selected</c:if> value="FFE0FB">5</option>
		<option <c:if test="${background == 'FFE7E8' }">selected</c:if> value="FFE7E8">6</option>
		<option <c:if test="${background == 'FFEDCC' }">selected</c:if> value="FFEDCC">7</option>
		<option <c:if test="${background == 'FFFFFF' }">selected</c:if> value="FFFFFF">8</option>
							
					</SELECT>
	            </td>
	            <td class="columnTitle">图标：</td>
					<td class="tableContent">
					<img src="${icon }" name="x1"> 
					<SELECT name="icon" onChange="document.x1.src=options[selectedIndex].value">
						<%-- 	<c:forEach begin="0" end="8" var="i">
<option <c:if test="${icon   }" ==  "/jk_web/images/olmsg/'${i}'.gif" >selected</c:if>  value="${ctx}/images/olmsg/${i}.gif">${i}.jpg</option>
							</c:forEach> --%>
<option <c:if test="${icon =='/jk_web/images/olmsg/0.gif'  }" >selected</c:if>  value="${ctx}/images/olmsg/0.gif">0.jpg</option>
<option <c:if test="${icon =='/jk_web/images/olmsg/1.gif'  }" >selected</c:if>  value="${ctx}/images/olmsg/1.gif">1.jpg</option>
<option <c:if test="${icon =='/jk_web/images/olmsg/2.gif'  }" >selected</c:if>  value="${ctx}/images/olmsg/2.gif">2.jpg</option>
<option <c:if test="${icon =='/jk_web/images/olmsg/3.gif'  }" >selected</c:if>  value="${ctx}/images/olmsg/3.gif">3.jpg</option>
<option <c:if test="${icon =='/jk_web/images/olmsg/4.gif'  }" >selected</c:if>  value="${ctx}/images/olmsg/4.gif">4.jpg</option>
<option <c:if test="${icon =='/jk_web/images/olmsg/5.gif'  }" >selected</c:if>  value="${ctx}/images/olmsg/5.gif">5.jpg</option>
<option <c:if test="${icon =='/jk_web/images/olmsg/6.gif'  }" >selected</c:if>  value="${ctx}/images/olmsg/6.gif">6.jpg</option>
<option <c:if test="${icon =='/jk_web/images/olmsg/7.gif'  }" >selected</c:if>  value="${ctx}/images/olmsg/7.gif">7.jpg</option>
<option <c:if test="${icon =='/jk_web/images/olmsg/8.gif'  }" >selected</c:if>  value="${ctx}/images/olmsg/8.gif">8.jpg</option>
							
					</SELECT>
					</td>
				</tr>	
	        	
		</table>
	</div>
 
 
</form>
</body>
</html>

