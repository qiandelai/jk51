<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <script type="text/javascript" src="${ctx}/layer/jquery-1.11.0.min.js"></script> --%>
  <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/layer/skin/layer.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/layer/skin/demo.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/default.css" media="all"/>
<!-- <script type="text/javascript" src="/components/jquery-ui/jquery-1.2.6.js"></script> -->
	<script language="javascript" src="${ctx}/js/common.js"></script> 
	<script type="text/javascript" src="${ctx}/layer/jquery-1.11.0.min.js" ></script>
		<script type="text/javascript" src="${ctx}/layer/layer.js" ></script>
</head>
<script type="text/javascript">
$(function(){
	
	//alert(1);
	//alert(prompt("请输入密码，并确认"));
	/*  if(prompt("请输入密码，并确认")){
		window.location = "${ctx}/sysadmin/userAction_verify.action?password="+pass;
	}else{
		window.location = "${ctx}/homeAction_tomain?moduleName=home";
	} */
	 /* layer.prompt(
		{
			title : '请输入密码，并确认',
			formType : 1,
			
		},
		function(pass, index) {
			window.location = "${ctx}/sysadmin/userAction_verify.action?password="+pass;
			/* var url = "${ctx}/sysadmin/userAction_verify.action";
			var params = {"password":pass};
			//发ajax
			$.post(url,params,function(data){
				if(data == 1){
					
				}else{
					
				}
			}); 
			layer.close(index);
		});*/
		if("${not empty info}"!="false"){
			layer.msg("${info}");
			setTimeout("promptLayer()",1000);
		}else{
			promptLayer();
		}
		
	/* 	var ff = "0";
		layer.prompt(
				{
					title : '请输入密码，并确认',
					formType : 1,
					end:function(){
						if(ff == "0"){
							alert(0);
							
						}else{
							alert(1);
						}
					}
				},
				function(pass, index) {
					var url = "${ctx}/sysadmin/userAction_verify.action";
					var params = {"password":pass};
					//发ajax
					$.post(url,params,function(data){
						if(data == 1){
							alert(11);
							ff = "1";
						}else{
							
						}
					}); 
					layer.close(index);
				}); */
		
}) 
function promptLayer(){
	layer.prompt(
			{
				title : '请输入原密码',
				formType : 1,
				btn2: function(){
					window.location = "${ctx}/homeAction_tomain?moduleName=home";
				},
				cancel:function(){
					window.location = "${ctx}/homeAction_tomain?moduleName=home";
				}
			},
			function(pass, index) {
				
				
				window.location = "${ctx}/sysadmin/userAction_verify.action?password="+pass;
				layer.close(index);
			});
}
</script>
<body>

</body>
</html>