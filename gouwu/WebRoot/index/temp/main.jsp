<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站首页</title>
<link href="<%=basePath%>index/temp/style/all.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>index/temp/style/ty.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>index/temp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
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
</div>
<div id="main">
	<div id="banner">
		<ul>
			<c:forEach items="${lbList}" var="list" >
				<li class="li1"><a href="<%=basePath%>web/goods/selWebSp?id=${list.id}">${list.mname}</a></li>
			</c:forEach>
		</ul>
		<div class="banner">
		<img src="<%=basePath%>index/temp/img/pit_show1.png" alt="" width="95%" height="100%"/>
		</div>
		<div class="right">
			<div class="bk pt16" style="clear:both;">
				<div class="tit">
					<h2>网易云百科</h2>
					<h3>有不懂的问网易云</h3>
				</div>
				<ul>
				<c:forEach items="${ggList}" var="list" >
					<li><a href="<%=basePath%>web/goods/selGg?id=${list.id}">${list.title}</a></li>
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div id="phb">
		<div class="phb">
			<div class="tit">
				<h2>销售<span >排行榜</span></h2>
				<h3>我们有最好的商品</h3>
			</div>
			<ul>
			<c:forEach items="${countList}" var="list" >
				<li class="li${list.saleNumber}">
					<dl>
					<a href="<%=basePath%>web/goods/selSpDetail?id=${list.sId }">
						<dt class="fl"><img src="<%=basePath%>image/${list.photo}" alt="" width="60%" height="15%" /></dt>
						<dd class="fl">
							<p ><a href="<%=basePath%>web/goods/selSpDetail?id=${list.sId }">${list.sname}<br/>
								<span>¥${list.price}</span><br/>
							</a></p>
						</dd>
					</dl>
				</li>
			</c:forEach>
			</ul>
		</div>
		<div  class="xpss">
			<div class="tit">
				<h2><span >新品</span>上市</h2>
				<h3>新品到货，不来看看嘛</h3>
			</div>
			<ul>
				<c:forEach items="${spList}" var="list" >
				<li>
					<dl>
					<a href="<%=basePath%>web/goods/selSpDetail?id=${list.id }">
						<dt> <img src="<%=basePath%>image/${list.photo}" alt=""	 /> </dt>
						<dd> ${list.sname}<br />
							<span class="colorlan">¥${list.price}</span></a> </dd>
					</dl>
				</li>
				</c:forEach>
			</ul>
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
</div>
</body>
</html>
