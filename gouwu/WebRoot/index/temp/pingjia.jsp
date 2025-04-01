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
<script charset="utf-8" src="<%=basePath%>plugins/kindeditor-4.1.4/kindeditor-min.js"></script>
<script charset="utf-8" src="<%=basePath%>plugins/kindeditor-4.1.4/lang/zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>plugins/kindeditor-4.1.4/simple.js"></script>
<!-- 引入JQuery支持的库 -->
<script language="JavaScript" src="<%=basePath%>resource/admin/js/jquery.js"></script>
<!-- 引入artDailog支持的库 -->
<link rel="stylesheet" href="<%=basePath%>resource/admin/artDialog/css/ui-dialog.css">
<script language="JavaScript" src="<%=basePath%>resource/admin/artDialog/dist/dialog-plus.js"></script>
<script type="text/javascript">
		function toClose(){
        	var dialog = top.dialog.get(window);
        	dialog.close();
        	dialog.remove();
        	return false;
        }
	
	</script>
</head>
<body>
<div id="xiugai">
	<div class="content">
		<div class="mid">
			<div class="xg">
				<p>评价</p>
			</div>
			<form action="<%=basePath%>web/user/savePj" method="post">
			<input type="hidden" name="sId" value="${dd.sId}"/>
			<input type="hidden" name="id" value="${dd.id}"/>
				<label></label>
				<br/>
				 <textarea name="content" id="editor_id" cols="100" rows="8" style="width:500px;height:200px" class="dfinput required" ></textarea><br/>
				<br />
				<input type="submit"  value="确认评价"  class="submit" />
				<input type="button"  value="取消" onclick="toClose()"  class="submit" />
			</form>
		</div>
	</div>
	
</div>
</body>
</html>
