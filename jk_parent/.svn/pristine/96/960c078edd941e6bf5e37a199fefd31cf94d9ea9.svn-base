<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx }/components/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css" />

	<script type="text/javascript" src="${ctx }/components/zTree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${ctx }/components/zTree/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="${ctx }/components/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
	<script type="text/javascript">
		var setting = {
			check:{
				enable:true
			},
			data:{
				simpleData:{
					enable:true
				}
			}
		}
		var zNodes =[
			{ id:11, pId:1, name:"系统管理", open:true,checked:true},
			{ id:111, pId:11, name:"部门管理",checked:true},
			{ id:112, pId:11, name:"用户管理"},
			{ id:12, pId:1, name:"货运管理", open:true},
			{ id:121, pId:12, name:"购销合同"},
			{ id:122, pId:12, name:"装箱管理"}
		];
	
	
		function zTree(){
			$.fn.zTree.init($("#jkTree"), setting, zNodes);
		}
	</script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="id" value="${id}"/>
	<input type="hidden" id="moduleIds" name="moduleIds" value="" />
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="submitCheckedNodes();formSubmit('roleAction_module','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="formSubmit('roleAction_list','_self');this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    配置 [${name}] 角色的模块  
  </div> 
  </div>
  </div>
  </div>
  	<div>
  		<input type="button" value="生成" onclick="zTree()"></input>
	</div>
<div>  
	<ul id="jkTree" class="ztree"></ul>  
</div>
 
 
</form>
</body>
</html>

