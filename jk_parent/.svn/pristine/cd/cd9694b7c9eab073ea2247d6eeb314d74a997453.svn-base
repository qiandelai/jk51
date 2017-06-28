<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
		<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js""></script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('financeAction_insert','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   新增财务报运单
  </div> 
  
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">制单日期：</td>
	            <td class="tableContent">	<input type="text" style="width:90px;" name="inputDate"  value="" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">制单人：</td>
	            <td class="tableContent"><input type="text" style="width:500px;" name="inputBy" value=""/></td>
	        </tr>	
		</table>
	</div>
	<div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    	装箱单列表
 	 </div>
		<div class="pcTable">
			<table id=" pc_table" class="tableRegion" width="98%">
				<thead>
					<tr>
						<td class="tableHeader">选择</td>
						<td class="tableHeader">序号</td>
						<td class="tableHeader">报运单号</td>
						<td class="tableHeader">发票号</td>
						<td class="tableHeader">提货号</td>
						<td class="tableHeader">贸易条款</td>
						<td class="tableHeader">状态</td>
					</tr>
				</thead>
				 <tbody class="tableBody">
					 ${links }
					<c:forEach items="${results}" var="invo" varStatus="status">
						<tr bgcolor="#c3f3c3" height="30" class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
							<td><input type="radio" name="id" value="${invo.id}"/></td>	
							<td>${status.index+1}</td>
							<td>${invo.id}</td>
							<td>${invo.scNo}</td>
							<td>${invo.blNo}</td>
							<td>${invo.tradeTerms}</td>
							<td><c:if test="${invo.state==0.0}">草稿</c:if>
							<c:if test="${invo.state==1.0}"><font color="green">已发票</font></c:if>
							</td>
						</tr>
					</c:forEach> 
				</tbody>
			</table>
		</div> 
	</form>
</body>
</html>

