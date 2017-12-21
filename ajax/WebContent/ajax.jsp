<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>AJAX练习</title>
<script  src="createXMLHttpReqquest.js"></script>
<script type="text/javascript">
		var xmlrequest = createXMLHttpRequest();
		//get请求
		function doGet(){
		var params = document.getElementById("g").value;
		xmlrequest.onreadystatechange=readCallBack;
		xmlrequest.open("GET","AServlet?m="+params,true);//创建一个新的http请求，并指定此请求的方法、URL以及验证信息
		xmlrequest.send();//发送请求到http服务器并接收回应
		}
		//post请求
		function doPost(){
		var params = "m="+document.getElementById("p").value;
		xmlrequest.onreadystatechange=readCallBack;
		xmlrequest.open("post","AServlet",false);//创建一个新的http请求，并指定此请求的方法、URL以及验证信息
		xmlrequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");//设置请求头
		xmlrequest.send(params);//发送请求到http服务器并接收回应
		}
		
		//回调
		function readCallBack(){
		  if (xmlrequest.readyState==4 && xmlrequest.status==200){
		    document.getElementById("myDiv").innerHTML="aaa";
		    }
		  else{
			  document.getElementById("myDiv").innerHTML="sss";
		  }
		}
</script>
</head>
<body>
	get:<input type="text" id="g"><button onclick="doGet();">提交</button><br>
	post:<input type="text" id="p"><button onclick="doPost();">提交</button><br>
	<div id="myDiv"></div>
</body>
</html>