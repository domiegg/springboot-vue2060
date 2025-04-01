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
	
	 
</head>
			
<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">修改商品</a></li>
	</ul>
</div>

<form action = "upload.do?method=saveUpdateSp" method = "post" enctype="multipart/form-data"  class="validate"  onsubmit="" >
	<input type="hidden" name="id" value="${sp.id}"/>
	<div class="formbody">
		<div class="formtitle"><span>基本信息</span></div>
		<ul class="forminfo">
			
			<li>
				<label>商品名字</label>
				<input name="sname" id="sname" type="text" value="${sp.sname}"  class="dfinput required" />&nbsp;&nbsp;
			</li>
			<li>
				<label>价格</label>
				<input name="price" id="price" type="text" value="${sp.price}"  class="dfinput required"  />（元）
			</li>
			<li>
				<label>属性</label>
				<input name="sx" id="sx" type="text" value="${sp.sx}" class="dfinput required  " />
			</li>
			<li>
				<label>添加数量</label>
				<input name="number" id="price" type="text" value="${sp.number}" class="dfinput required"  />
			</li>
			<li>
				<label>颜色</label>
				<input name="color" id="sx" type="text" value="${sp.color}" class="dfinput required  " />
			</li>
			<li>
				<label>描述</label>
				<input name="miaoshu" id="sx" type="text" value="${sp.miaoshu}" class="dfinput required  " />
			</li>
			 <li>
				<label>图片</label>
				<input name="photo" id="photo" type="file" onchange="preview(this,'preview','imghead',150,100)"/>
				<div id="preview">
					<img id="imghead" width="150" height="50" src = "<%=basePath %>image/${sp.photo}" />
				</div>
			</li>
			<li>
				<label>&nbsp;</label>
				<input type="submit" class="btn" value="保存"/>
			</li>
		</ul>
	</div>
</form>

<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate.js"></script>
<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>
</body>
</html>
	