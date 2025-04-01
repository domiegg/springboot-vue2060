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
<link href="<%=basePath%>index/temp/style/all.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>index/temp/style/ty.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath%>resource/admin/js/jquery.js"></script>
<script type="text/javascript">
	  	function seek(){
	  	     $("#seek").submit();
	  	}
	  </script>
<title>我的购物车</title>
</head>
<body>
<div id="xiugai">
	<div class="header">
		<h1 class="fl"><img src="<%=basePath%>index/temp/img/logo.png" alt="" /></h1>
		<a href="grzy.html"></a><a href="xiugai.html"></a>
		<div class="ss fl">
			<form action="<%=basePath%>web/goods/search" method="post" id="seek" >
				<input  class="fl " type="text" name="sname" id="sname" placeholder="请输入商品名" />
				<a class="fl pl6" href="javascript:void(0);" onclick="seek();">搜索</a>
			</form>
		</div>
		<a href="<%=basePath%>web/user/userZx" class="fl a">退出登录</a> <a href="<%=basePath%>web/goods/home" class="fl a1">返回主页</a> </div>
	<div class="content">
		<div class="left">
			<ul>
				<li><a href="<%=basePath%>web/oper/selMyGwc">我的购物车</a></li>
				<li><a href="<%=basePath%>web/oper/selMyDd">我的订单</a></li>
				<li><a href="<%=basePath%>web/oper/selMyCollect">我的收藏</a></li>
				<li><a href="<%=basePath%>web/oper/showUser">个人主页</a></li>
				
			</ul>
		</div>
		<div class="mid2">
			<div class="xg1">购物车</div>
			<ul>
				<li>
					<table cellpadding="0" cellspacing="0">
						<tr style="height:24px">
							<td style="border-right:none">商品信息</td>
							<td style="border-right:none">商品属性</td>
							<td style="border-right:none">单价</td>
							<td style="border-right:none">数量</td>
							<td style="border-right:none">总价</td>
							<td >操作</td>
						</tr>
						
					<c:if test="${!empty gwcList}">
						<c:forEach items="${gwcList}" var="list" >
						<tr>
							<td><dl>
									<dt class="fl"><img src="<%=basePath%>image/${list.photo}" alt="" /></dt>
									<dd class="fl">${list.sname}</dd>
								</dl></td>
							<td>作者：${list.color}<br />
							</td>
							<td style="border-right:none">¥${list.sprice}</td>
							<td style="border-right:none">${list.number}</td>
							<td style="border-right:none">¥${list.tPrice}</td>
							<td><%--<a href="#this">购买<br />
								--%></a><a href="<%=basePath%>web/oper/deleteGwc?id=${list.id}">删除</a></td>
						</tr>
						</c:forEach>
				  </c:if>
			      <c:if test="${empty gwcList}">
					<tr>
						<td colspan="8" align="center">
							<strong><font color="red">购物车竟然是空的，快去购物吧</font></strong>
						</td>
					</tr>
				   </c:if>
						
					</table>
					<div class="xg2">
						<a href="<%=basePath%>web/oper/emptyGwc" class="fl">清空购物车</a>
						<a href="<%=basePath%>web/oper/jsGwc" class="fr colorlan  font14">结算</a>
						<p class="fr">总价为<span class="font14 colorlan ">${count}</span>元</p>
					</div>
				</li>
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
	<div class="copyright">2003-2015 农大购物商城，All Rights Reserved</div>
</div>
</body>
</html>
