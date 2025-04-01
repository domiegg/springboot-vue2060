<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="<%=basePath%>index/temp/style/all.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>index/temp/style/ty.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="dl">
	<div class="header">
		<h1><img src="<%=basePath%>index/temp/img/logo.png" alt="" /></h1>
		<a href="<%=basePath%>web/goods/home" class="fr font14">返回首页</a><a href="zc.jsp" class="fr font14 pr8">注册</a> </div>
	<div class="content">
		<div class="left"> <img src="<%=basePath%>index/temp/img/dl1.png" alt="" /> </div>
		<div class="right">
			<form action="<%=basePath%>web/user/userLogin" method="post">
				<label><strong class="font14">用户登录</strong></label>
				<br/>
				<input type="text" name="name" placeholder="请输入账号" />
				<br/>
				<input type="password" name="password"  placeholder="请输入密码" />
				<%--<br/>
				<input type="text" class="yzm fl" />
				<div class="pt25"><img class="yyy" src="<%=basePath%>index/temp/img/yzm.png" alt=""><span>看不清，<a href="#this" class=" colorlan">换一张？</a></span></div>
				--%><br /><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label style="color: red;">${message } </label>
				<input type="submit" value="登录" class="dl font14" />
				<input type="reset" value="重置" class="dl font14" />
				<br /><br />
				
			</form>
		</div>
	</div>
</div>
<div id="footer">
	<ul>
		<li><a href="gywm.html">关于我们</a><>
		<li><a href="#this">合作伙伴</a><>
		<li><a href="#this">营销中心</a><>
		<li><a href="#this">廉政举报</a><>
		<li><a href="#this">联系客服</a><>
		<li><a href="#this">开放平台</a><>
		<li><a href="#this">诚信英才</a><>
		<li><a href="#this">联系我们</a><>
		<li><a href="#this">网站地图</a><>
		<li><a href="#this">法律声明</a><>
	</ul>
	<div class="copyright">2003-2015 农大购物商城，All Rights Reserved</div>
</div>
</body>
</html>
