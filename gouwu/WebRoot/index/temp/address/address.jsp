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
<script type="text/javascript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
	  <script type="text/javascript">
	  	function seek(){
	  	     $("#seek").submit();
	  	}
	  </script>
<title>我的收货地址</title>
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
				<li><a href="<%=basePath%>web/user/selMyAdd">我的收货地址</a></li>
				<li><a href="<%=basePath%>web/oper/selMyInfo">我的信息</a></li>
				<li><a href="<%=basePath%>web/oper/selMyGwc">我的购物车</a></li>
				<li><a href="<%=basePath%>web/oper/selMyDd">我的订单</a></li>
				
			</ul>
		</div>
		<div class="mid2">
			<div class="xg1">我的收货地址</div>
			<ul>
				<li>
					<table cellpadding="0" cellspacing="0">
						<tr style="height:24px">
							<td style="border-right:none">收货人姓名</td>
							<td style="border-right:none">电话</td>
							<td style="border-right:none">邮编</td>
							<td style="border-right:none">所在省</td>
							<td style="border-right:none">所在地市</td>
							<td style="border-right:none">所在县/区</td>
							<td style="border-right:none">详细地址</td>
							<td style="border-right:none">是否为默认地址</td>
							<td >操作</td>
						</tr>
						
					<c:if test="${!empty addList}">
						<c:forEach items="${addList}" var="list" >
						<tr>
							<td style="border-right:none">${list.sname}</td>
							<td style="border-right:none">${list.stel}</td>
							<td style="border-right:none">${list.youbian}</td>
							<td style="border-right:none">${list.sheng}</td>
							<td style="border-right:none">${list.shi}</td>
							<td style="border-right:none">${list.xian}</td>
							<td style="border-right:none">${list.address}</td>
							<td style="border-right:none">
							<c:if test="${list.moren==0}">否</c:if>
							<c:if test="${list.moren==1}">是</c:if>
							</td>
							<td>
								 <a href="<%=basePath%>web/user/showAdd?id=${list.id}" >编辑</a>
				                 <a href="<%=basePath%>web/user/deleteAdd?id=${list.id}" >删除</a>
							 	 <a href="<%=basePath%>web/user/mrAdd?dId=${list.id}">设置默认</a>
							</td>
						</tr>
						</c:forEach>
				  </c:if>
			      <c:if test="${empty addList}">
					<tr>
						<td colspan="8" align="center">
							<strong><font color="red">暂时没有收货地址信息</font></strong>
						</td>
					</tr>
				   </c:if>
					</table>
					<div class="xg2">
						<a href="<%=basePath%>city/addDd" class="fl">添加收货地址</a>
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
