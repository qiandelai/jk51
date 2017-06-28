<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
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
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   浏览财务报运单
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">海运/空运：</td>
	            <td class="tableContent">${orderType }</td>
	  
	            <td class="columnTitle">货主：</td>
	            <td class="tableContent">${shipper }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">提单抬头：</td>
	            <td class="tableContent">${consignee }</td>
	           
	            <td class="columnTitle">正本通知人：</td>
	            <td class="tableContent">${notifyParty }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">信用证：</td>
	            <td class="tableContent">${lcNo }</td>
	            <td class="columnTitle">装运港：</td>
	            <td class="tableContent">${portOfLoading }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">转船港：</td>
	            <td class="tableContent">${portOfTrans }</td>
	            <td class="columnTitle">卸货港：</td>
	            <td class="tableContent">${portOfDischarge }</td>
	        </tr>	
	     <tr>
	            <td class="columnTitle">装期：</td>
	            <td class="tableContent">${loadingDate }</td>
	            <td class="columnTitle">效期：</td>
	            <td class="tableContent">${limitDate }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">是否分批：</td>
	            <td class="tableContentAuto">
	           ${isBatch==1?'是':'否' }
	            </td>
	            <td class="columnTitle">是否转船：</td>
	            <td class="tableContentAuto">${isTrans==1?'是':'否' }
	            </td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">份数：</td>
	            <td class="tableContent">${copyNum }</td>
	            <td class="columnTitle">扼要说明：</td>
	            <td class="tableContent">${remark }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">运输要求：</td>
	            <td class="tableContent">${specialCondition }</td>
	            <td class="columnTitle">运费说明：</td>
	            <td class="tableContent">${freight }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">复核人：</td>
	            <td class="tableContent">${checkBy }</td>
	        </tr>	
		</table>
	</div>
 <div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">卖方</td>
		<td class="tableHeader">买方</td>
		<td class="tableHeader">发票号</td>
		<td class="tableHeader">发票日期</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	${page.links}
	
	<c:forEach items="${page.results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="radio" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.seller}</td>
		<td>${o.buyer}</td>
		<td>${o.invoiceNo}</td>
		<td>${o.invoiceDate}</td>
		<td>
		<c:if test="${o.state==0}">草稿</c:if>
		<c:if test="${o.state==1}"><b><font color="green">已装箱</font></b></c:if>
		<c:if test="${o.state==2}"><b><font color="red">已委托</font></b></c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</form>
</body>
</html>

