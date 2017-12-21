<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link   type="text/css" rel="stylesheet" href="css/01.css"/>
<link   type="text/css" rel="stylesheet" href="css/set_8.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/demo.js"></script>
<script type="text/javascript">
$(function(){
	if("${msg}")$('#msg').text("${msg}").fadeTo(2000, 0.70,"linear",function(){$(this).hide()});//显示删除信息
}) 
</script>
<style type="text/css">
td{background-color:#BCFFFE00;}
#createWorkFlow{width: 100%;height: 50px;margin-bottom: 20px;}
#startWorkFlow{width: 100%;height: 50px;margin-bottom: 20px;}
form{margin-left: 20px;}
span{margin-left: 10px}
</style>
</head>
<body class="background-2">
	<h2>demo页面</h2>
	<div id="msg"></div>
	<c:if test="${empty user.manager }">
		<div id="createWorkFlow">
		<div id="createWorkFlowButton" class="set_button set_8_button outline" onclick="newEmps(this,'createWorkFlowFrom');">部署流程<span class="lines"></span></div>
			<form method="post" action="${pageContext.request.contextPath}/activiti/createWorkFlow.do" style="display: none"
			enctype="multipart/form-data" class="social-touch" id="createWorkFlowFrom">
				<span style="margin: 5px">部署流程</span><br>
					<font> 部署名称：</font>
					<input name='name' value=''>
					<font>部署资源：</font>
					   <input type="file" name="file" class="file"/>
				<input  class ='sunmit save-touch' type='submit' value=''>
				<a class='linkedin-touch' onclick="hideNewEpmsFrom('createWorkFlowButton','createWorkFlowFrom');"></a>
			</form>
		</div>
	</c:if>
	
	<div id="startWorkFlow">
	<div id="startWorkFlowButton" class="set_button set_8_button outline" onclick="newEmps(this,'startWorkFlowFrom');">申请请假<span class="lines"></span></div>
	<form action="${pageContext.request.contextPath}/activiti/startWorkFlow.do" style="display: none"
		 class="social-touch" method="post" id='startWorkFlowFrom'>
		 <span style="margin: 5px">开启流程</span><br>
		 	<input name="key" value="LeaveBill" type="hidden">
			<font>请假天数:</font><input name='days' value=''>
			<font>请假原因:</font><input name='content' value=''>
			<font>请假描述:</font><input name='remark' value=''>
			<input  class ='sunmit save-touch' type='submit' value=''>
		<a class='linkedin-touch' onclick="hideNewEpmsFrom('startWorkFlowButton','startWorkFlowFrom');"></a>
	</form>
	</div>
	
	
	<div id="myWorkFlow">
	<div id="myWorkFlowButton"  class="set_button set_8_button outline" onclick="newEmps(this,'myWorkFlowFrom');myTask();">我的任务<span class="lines"></span></div>
	<form action="${pageContext.request.contextPath}/activiti/myWorkFlow.do" style="display: none"
		 class="social-touch" method="post" id='myWorkFlowFrom'>
		 <span style="margin: 5px">我的任务</span><br>
		<div id="myTaskDiv"></div>	
		<a class='linkedin-touch' onclick="hideNewEpmsFrom('myWorkFlowButton','myWorkFlowFrom');"></a>
	</form>
	</div>
</body>
</html>