<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人资料</title>
<link href="<%=basePath%>index/temp/style/all.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>index/temp/style/ty.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
	  <script type="text/javascript">
	  	function seek(){
	  	     $("#seek").submit();
	  	}
	  </script>
</head>
<body>
<div id="xiugai">
	<div class="header">
		<h1 class="fl"><img src="<%=basePath%>index/temp/img/logo.png" alt="" /></h1>
		<a href=""></a>
		<a href=""></a>
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
				<li><a href="#this">个人资料</a></li>
				<li><a href="#this">编辑个人资料</a></li>
				<li><a href="<%=basePath%>web/oper/showUser">个人主页</a></li>
			</ul>
		</div>
		<div class="mid">
			<div class="xg">
				<p>修改个人信息</p>
			</div>
			<form action="<%=basePath%>upload.do?method=saveUpdateUser" enctype="multipart/form-data" method="post">
			<input  type="hidden" name="number" value="${user.number}" />
				<label class="fl">当前头像</label>
				<input type="image" src="<%=basePath%>image/${user.photo}" width="20%" height="15%" name="photo" class="img" />
				<input type="file"  class="bb" name="photo"/>
				<br />
				<label>用户名称</label>
				<input  type="text" name="name" value="${user.name}" />
				<br />
				<label>密码</label>
				<input class="aa" type="text" name="password" value="${user.password}" />
				<br />
				<label>邮箱</label>
				<input class="aa" type="text" name="email" value="${user.email}"  />
				<br />
				
				<input type="submit"  value="提交"  class="submit" />
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
