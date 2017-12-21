<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>hello struts2</title>
</head>
<body>
	<s:debug></s:debug>
	<s:property value="message"/>
	<form action="">
		 <s:text name="username"/><input type="text" name="username"><br/>
		 <s:text name="password"/><input type="text" name="password"><br/>
	</form>
	<a href="changelan?request_locale=zh_CN">简体中文</a>&nbsp;&nbsp;&nbsp;
  	<a href="changelan?request_locale=en_US">English</a><br/>
  	${msg}<br>
  	<s:textfield name="postalCode" key="postalCode.label"/>
</body>
</html>