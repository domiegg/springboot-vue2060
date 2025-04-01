<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath %>resource/admin/commons/utils.js"></script>
		<!-- 引入JQuery支持的库 -->
    <script language="JavaScript" src="<%=basePath %>resource/admin/admin/js/jquery.js"></script>
    
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">修改新闻</a></li>
	</ul>
</div>

<form action = "shangpin/updateGg" method = "post"   class="validate" onsubmit="return add();" >
	<input name="id" id="mname" type="text" value="${gg.id }"  />
	<div class="formbody">
		<div class="formtitle"><span>添加新闻</span></div>
		<ul class="forminfo">
			<li>
				<label>标题</label>
				<input name="title" id="mname" type="text" value="${gg.title }" class="dfinput required" />&nbsp;&nbsp;
			</li>
			<li>
				<label>内容</label>
				<input name="content" id="mname" type="text" value="${gg.content }"  class="dfinput required" />&nbsp;&nbsp;
			</li>
			<li>
				<label>&nbsp;</label>
				<input type="submit" class="btn" value="确认"/>
				<input type="reset" class="btn" value="重置"/>
			</li>
		</ul>
	</div>
</form>
<script type="text/javascript" src="<%=basePath %>resource/admin/jQuery/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/admin/js/validate.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/admin/imagePreview/imagePreview.js"></script>
</body>
</html>
	