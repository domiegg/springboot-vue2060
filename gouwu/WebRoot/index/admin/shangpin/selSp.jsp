<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>无标题文档</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
	 <link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
   <!-- 引入JQuery支持的库 -->
<script language="JavaScript" src="<%=basePath%>resource/admin/js/jquery.js"></script>
<!-- 引入artDailog支持的库 -->
<link rel="stylesheet" href="<%=basePath%>resource/admin/artDialog/css/ui-dialog.css">
<script language="JavaScript" src="<%=basePath%>resource/admin/artDialog/dist/dialog-plus.js"></script>
  <script type="text/javascript">
  		//显示头像
		 function toShowPhoto(id){
  			
			 var d = dialog({
				 id:'photo',//唯一的弹出框
				 title:'头像显示',
				 content:'<img width="200" src="<%=basePath%>shangpin/show/'+id+'" alt="暂无头像" onerror="this.src=\'upload/guest.png\'"/>'
			 });
			 d.show();
			
		 }
	</script>
</head>
		

<body>
<form action="shangpin/selSp" method="post" rel="page">
<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">查看商品信息</a></li>
	</ul>
</div>
<div class="formbody">
	<div class="formtitle" style="cursor: pointer;" id="formtitle"><span>条件查询</span></div>
	<ul class="forminfo" style="display: none;" id="forminfo">
		<li>
			<label>商品名</label>
			<input name="sname"  type="text" class="dfinput" placeholder="请输入商品名称" />
		</li>
		
		<li>
			<label>&nbsp;</label>
			<input name="" type="submit" class="btn" value="查询"/>
			<input name="" type="reset" class="btn" value="重置"/>
		</li>
	</ul>
</div>

		<table class="imgtable"border = "5" >
			<thead>
			<tr>
				<th>id</th>
				<th>图片</th>
				<th>商品名</th>
				<th>价格</th>
				<th>库存数量</th>
				<th>颜色 </th>
				<th>属性</th>
				<th>描述</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
		<c:if test="${!empty shangPinList}">
			<c:forEach items="${shangPinList}" var="list" varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td class="imgtd"><img src="image/${list.photo}" width="60" height="60" /></td>
				<td>${list.sname}</td>
				<td>${list.price}</td>
				<td>${list.number}
				<font color="red"><c:if test="${list.number<5}">库存不足</c:if></font>
				</td>
				<td>${list.color}</td>
				<td>${list.sx}</td>
				<td>${list.miaoshu}</td>
				<td>
					<%--<a href = "shangpin/updateJstate?id=${list.id}"><font color="blue">上架</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					--%><a href = "shangpin/showSp?id=${list.id}"><font color="blue">修改</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href = "shangpin/deleteSp?id=${list.id}" onclick="deleteUser()"><font color="blue">删除</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>	
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty shangPinList}">
			<tr>
				<td colspan="8" align="center">
					<strong><font color="red">暂时没有数据，请添加</font></strong>
				</td>
			</tr>
		</c:if>
		</tbody>
		</table>
		<div class="rightinfo">
			<div class="tools">
				<ul class="toolbar1">
					<li class="click"><span><img src="<%=basePath %>resource/admin/images/t01.png"/></span><a href="shangpin/addSp">添加商品</a></li>
				</ul>
			</div>
		</div>
	<jsp:include page="/plugins/page/page.jsp"></jsp:include>
</form>

<script type="text/javascript" src="<%=basePath %>resource/admin/jQuery/jquery.js"></script>
<script type="text/javascript">
	/**
	 * 这个使用的单选框选择判断
	 */
	  function deleteUser(){
		alert("删除成功");
		}
	function toUpdate(){
		var id = $("input[name='id']:checked").val();
		if(!id){
			alert("请选择要操作的记录");
			return false;
		}else{
			alert( "您操作的值为："+$("input[name='id']:checked").val())
		}
	}
	$(function(){
		$('.tablelist tbody tr:odd').addClass('odd');
		
		$("#formtitle").click(function(){
			$("#forminfo").slideToggle("slow");
		});
	});
</script>
<script type="text/javascript">
	$(function(){
		$('.imgtable tbody tr:odd').addClass('odd');
	});
    
</script>

</body>

</html>

