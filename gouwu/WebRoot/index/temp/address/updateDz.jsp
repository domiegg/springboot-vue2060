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
<title>编辑收货地址</title>
<link href="<%=basePath%>index/temp/style/all.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>index/temp/style/ty.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>resource/commons/utils.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
	  <script type="text/javascript">
	  	function city(){
	  		var sid = $("#sheng").val();
	  		var url = "<%=basePath%>city/shi";
	  		var param = {
	  			"sid":sid
	  			};
	  			$.post(url,param,function(citys){
	  				var $shi = $("#shi");
	  				$shi.empty();
	  				for(var i=0;i<citys.length;i++){
	  					$shi.append("<option value='" + citys[i].id + "'>"+ citys[i].cName + "</option>");
	  				}
	  			});
	  	}
	  	function city1(){
	  		var sid = $("#shi").val();
	  		var url = "<%=basePath%>city/xian";
	  		var param = {
	  			"sid":sid
	  			};
	  			$.post(url,param,function(citys){
	  				var $xian = $("#xian");
	  				$xian.empty();
	  				for(var i=0;i<citys.length;i++){
	  					$xian.append("<option value='" + citys[i].id + "'>"+ citys[i].cName + "</option>");
	  				}
	  			});
	  	}
	  </script>
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
				<li><a href="#this">添加收货地址</a></li>
				<li><a href="#this">我的收货地址</a></li>
				<li><a href="<%=basePath%>web/oper/showUser">个人主页</a></li>
			</ul>
		</div>
		<div class="mid">
			<div class="xg">
				<p>编辑收货地址</p>
			</div>
			<form action="<%=basePath%>web/user/saveUpdateAdd" method="post">
			<input class="aa" type="hidden" name="id" value="${sh.id}"  />
				<label>姓名</label>
				<input class="aa" type="text" name="sname" value="${sh.sname}"  />
				<br />
				<label>电话</label>
				<input class="aa" type="text" name="stel" value="${sh.stel}"  />
				<br />
				<label>邮编</label>
				<input class="aa" type="text" name="youbian" value="${sh.youbian}"  />
				<br />
				<label>送货地址</label>
				<select onchange="city();" name="sheng" id="sheng" style="width: 100px">
					<option value="-1">省份 </option>
					<c:forEach items="${listSheng}" var="list" >
						<option value="${list.id}">${list.cName}</option>
					</c:forEach>
				</select>
				<select name="shi" onchange="city1();"  id="shi" style="width: 100px"> 
					<option value="-1">地市 </option>
				</select>
				<select name="xian" id="xian" style="width: 100px"> 
					<option value="-1">县/区 </option>
				</select>
				<br />
				<label>详细地址</label>
				<input type="text" name="address" value="${sh.address}"  />
				<br />
				<input type="submit"  value="提交"  class="submit" />
				<input type="reset"  value="重置"  class="submit" />
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
