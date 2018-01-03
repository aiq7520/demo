<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/static/css/template/common.css?2014-03-07-1" media="all" />
<link rel="stylesheet" type="text/css"
	href="/static/css/template/home-19.css?2014-03-07-1" media="all" />
<link rel="stylesheet" type="text/css"
	href="/static/css/template/home-menu-2.css?2014-03-07-1"
	media="all" />
<title>汽车行业</title>
</head>
<style type="text/css">

td{background-color:#BCFFFE00;}
#createWorkFlow{width: 100%;height: 50px;margin-bottom: 20px;}
#startWorkFlow{width: 100%;height: 50px;margin-bottom: 20px;}
form{margin-left: 20px;}
span{margin-left: 10px}
</style>
<body>
	<div class="body" style='text-align:center;'>
		<section>
			<span class="link_tel icon-phone">你好，${user.name}</span>
		</section>
		<!--用户分类管理-->
		<table style='margin:0px auto;width: 100%'>
			<thead>
				<tr>
					<th>id</th>
					<th >vin</th>
					<th>standard</th>
					<th>color</th>
				</tr>
			</thead>
			<tbody >
					<c:forEach items="${list}" var="car">
					<tr>
						<td>${car.id}</td>
						<td>${car.vin}</td>
						<td>${car.standard}</td>
						<td>${car.color}</td>
					</tr>
					</c:forEach>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
	</div>
	<!--导航菜单后台设置的快捷菜单-->
	<div class="top_bar footer_bar"
		style="-webkit-transform: translate3d(0, 0, 0)">
		<nav>
			<ul class="top_menu">
				<li onClick="location.reload();"><span></span></li>
				<!-- 首页：刷新 -->
				<li>
				<a href=""> 
				<label class="homemenu_text">入库</label>
				</a>
				</li>
			</ul>
		</nav>
	</div>
</body>
</html>


