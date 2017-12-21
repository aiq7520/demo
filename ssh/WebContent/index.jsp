<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<form action="">
		 <s:text name="username"/><input type="text" name="username"><br/>
		 <s:text name="password"/><input type="text" name="password"><br/>
		</form>
		<a href="changelan?request_locale=zh_CN">简体中文</a>&nbsp;&nbsp;&nbsp;
  		<a href="changelan?request_locale=en_US">English</a>
</body>
</html>