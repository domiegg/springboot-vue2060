<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于我们</title>
<link rel="stylesheet" href="<%=basePath%>index/temp/style/ty.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>index/temp/style/all.css" type="text/css" />
<script type="text/javascript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
	  <script type="text/javascript">
	  	function seek(){
	  	     $("#seek").submit();
	  	}
	  </script>
</head>
<body>
<div id="header">
	<div class="link">
		 <p class="fl pl8">您好  <font color="blue" size="2">${sessionScope.name}</font>,欢迎来到农大购物商城</p>
		 <a href="<%=basePath%>web/oper/selMyGwc" class="fr mr24">购物车</a>
		   <a href="<%=basePath%>web/oper/selMyCollect" class="fr mr24">收藏夹</a>  
		 <a href="<%=basePath%>web/oper/showUser" class="fr mr24">个人主页</a> 
		 <a href="<%=basePath%>index/temp/zc.jsp" class="fr mr24">免费注册</a> 
		 <a href="<%=basePath%>index/temp/login.jsp" class="fr mr24">请登录</a>
	</div>
	<div class="mid">
		<h1 class="fl"><img src="<%=basePath%>index/temp/img/logo.png" alt="" /></h1>
		<div class="right fl">
			<div class="ss">
			<form action="<%=basePath%>web/goods/search" method="post" id="seek" >
				<input  class="fl input" type="text" name="sname" id="sname" placeholder="请输入商品名" />
				<a class="fl pl8" href="javascript:void(0);" onclick="seek();">搜索</a>
			</form>
			</div>
		</div>
	</div>
	<div class="menu fl">
		<div class="left">
			<p class="font14">全部商品分类</p>
		</div>
		<ul class="fl">
			<li><a href="<%=basePath%>web/goods/home"><span>网站首页</span></a></li>
			<li><a href="<%=basePath%>web/goods/selWebSp?id=46"><span>特价商品</span></a></li>
			<li><a href="<%=basePath%>index/temp/gywm.jsp"><span>关于我们</span></a></li>
			<li><a href="<%=basePath%>index/temp/liuyan.jsp"><span>留言板</span></a></li>
			<li><a href="<%=basePath%>index/temp/gonggao.jsp"><span>网站公告</span></a></li>
		</ul>
	</div>
	<div id="gywm">
		<div class="content">
			<div class="left">
				<div class="tit">网易云百科</div>
				<ul>
				</ul>
			</div>
			<div class="right">
				<h2>${gg.title}</h2>
				<p>发布人: ${gg.fname}</p>
				<p>发布时间: ${gg.date}</p>
				<p>内容: ${gg.content}</p>
			</div>
		</div>
	</div>
	<div id="footer">
		<ul>
			<li><a href="#this">关于我们</a><>
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
</div>
</body>
</html>
