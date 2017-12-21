<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link   type="text/css" rel="stylesheet" href="/ssm/css/01.css"/>
<link   type="text/css" rel="stylesheet" href="/ssm/css/set_8.css"/>
<script type="text/javascript" src="/ssm/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	if("${msg}")$('#msg').text("${msg}").fadeTo(2000, 0.70,"linear",function(){$(this).hide()});//显示删除信息
}) 
</script>
<style type="text/css">
table{width: 15%;margin-left:43% ;}
td{background-color:#BCFFFE00;}
form{
	padding-top: 10%
}
</style>
</head>
<body class="background-2">
	<h2>登录ddddd页面</h2>
	<div id="msg"></div>
	<form action="${pageContext.request.contextPath}/activiti.do"  method="post" id='newemps'>
		<table>
			<tbody class="social-touch">
				<tr>
					<td><font> 登录名:</font></td>
					<td><input name='name' value=''></td>
				</tr>
				<tr>
					<td><font>密&nbsp;&nbsp;码:</font></td>
					<td><input name='pwd' value='' type="password"></td>
				</tr>
				<tr><td colspan="2"><input  class ='sunmit save-touch' type='submit' value=''></td></tr>
			</tbody>
		</table>
	</form>
</body>
</html>