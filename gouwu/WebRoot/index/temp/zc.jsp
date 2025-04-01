<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>index/temp/style/all.css" rel="stylesheet" type="text/css" />

<link href="<%=basePath%>index/temp/style/ty.css" rel="stylesheet" type="text/css" />
</head><body>
<div id="zc">
	<div class="header">
		<h1><img src="<%=basePath%>index/temp/img/logo.png" alt="" /></h1>
		<a href="<%=basePath%>web/goods/home" class="fr font14">返回首页</a> <a href="<%=basePath%>index/temp/login.jsp" class="fr font14 link">登录</a>
		<p href="#this" class="fr font14">我已经注册，现在就</p>
	</div>
	<div class="content">
		<div class="none"></div>
		<div class="mid">
			<div class="left fl">
				<form action="<%=basePath%>upload.do?method=saveUser" enctype="multipart/form-data" method="post">
					<ul>
						<li>
							<dl>
								<dt><span>*</span>用户名:</dt>
								<dd>
									<input type="text" name="name" />
								</dd>
							</dl>
						</li>
						<li>
							<dl>
								<dt><span>*</span>请设置密码:</dt>
								<dd>
									<input type="password" name="password" />
								</dd>
							</dl>
						</li>
						<li>
							<dl>
								<dt><span>*</span>请确认密码:</dt>
								<dd>
									<input type="text" name="zpassword"/>
								</dd>
							</dl>
						</li>
						<li>
							<dl>
								<dt><span>*</span>邮箱:</dt>
								<dd>
									<input type="text" name="email" />
								</dd>
							</dl>
						</li>
						<li>
							<dl>
								<dt><span>*</span>头像:</dt>
								<dd>
									<input type="file" name="photo" />
								</dd>
							</dl>
						</li>
						<li>
							<input type="submit" value="立即注册" class="ljzc font14" />
						</li>
					</ul>
				</form>
			</div>
			
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
