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
<title>商品详细</title>
<link href="<%=basePath%>index/temp/style/all.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>index/temp/style/ty.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>index/temp/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
	  <script type="text/javascript">
	  	function seek(){
	  	     $("#seek").submit();
	  	}
	  	function buy(){
	  		var number = $("#number").val();
	  		var number1 =$("#number1").val();
        	var price = $("#price").val();
        	var sId = $("#sId").val();
        	if(number.length==0){
				alert("请输入购买数量");
				$("#number").focus();
				return false;
			}
        	if(number>number1){
					alert("请重新选择数量");
					$("#number").focus();
					return false;
			}
        	$.post("<%=basePath%>web/oper/buy",
        		{"number":number,"price":price,"sId":sId},
        		function(data){
        		if(data.flag=="1"){
        			alert("购买成功，请查看个人订单");
        			window.top.location.href="<%=basePath%>web/oper/selMyDd"
        		}else{
        			alert("购买失败");
        		}
        	});
	  	}
	  	
	  </script>
	  <script type="text/javascript">
		function add(){
			var number =$("#number").val();
			var number1 =$("#number1").val();
			if(number.length==0){
				alert("请输入购买数量");
				$("#number").focus();
				return false;
			}
			if(number>number1){
					alert("请重新选择数量");
					$("#number").focus();
					return false;
				}
			return true;
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
<div id="sp">
	<div class="content">
		<div class="right">
		<div class="js1 pl8">相关分类</div>
			<div>
				<ul class="ul1">
				<c:forEach items="${lbList}" var="list" >
					<li class="li1"><a href="<%=basePath%>web/goods/selWebSp?id=${list.id}">${list.mname}</a></li>
				</c:forEach>
				</ul>
			</div>
			
		</div>
		<div class="left">
			<div class="spxx">
				<div class="tp fl">
					<dl>
						<dt><img src="<%=basePath%>image/${sp.photo}"  width="80%" hight="80%" alt="" /></dt>
					</dl>
				</div>
				<div class="sx fl">
					<p class="font14">${sp.sname }</p>
					<div class="jiage">
						<p>原价 <span class="pl8">¥${sp.price }</span><br/>
							现价<strong class="colorlan"> ¥${sp.price }</strong></p>
					</div>
					<form action="<%=basePath%>web/oper/addGwc" method="post" onsubmit="return add();">
						<label>配送至：</label>
						<select>
							<option>北京</option>
						</select>
						<br/>
						<br/>
						<label>数量</label>
						<input class="sl" type="text"  name="number" id="number" />
						<input  type="hidden"  name="price" id="price" value="${sp.price }" />
						<input  type="hidden"  name="sId" id="sId" value="${sp.id }" />
						<input type="hidden"  id="number1" value="${sp.number }"   />
						<span class="pl16">限购<span class="colorlan">20</span>件，库存<span class="colorlan">${sp.number }件</span></span><br/>
						<br/>
						<a href="<%=basePath%>web/oper/collect?sid=${sp.id }"><img src="<%=basePath%>index/temp/img/collect.png" width="30" height="30" alt="图片" /><font color="black" size="2">收藏</font></a>
						<input type="button" value="立即购买" onclick="buy()" class="sub1" />
						<input type="submit" value="加入购物车" class="sub2" />
					</form>
				</div>
			</div>
			<div class="spjs">
				<div class="js pl8"><strong>商品介绍</strong></div>
				<br/>
				<p class="font12"><strong>核心参数</strong></p>
				<br/>
				<ul>
					<li>名称：${sp.sname }</li>
					<li>属性：${sp.sx }</li>
					<li>颜色：${sp.color }</li>
					<li>产品信誉：绝对保障</li>
					<li>售后服务：不能退换</li>
					<li>证书状态：有效 </li>
					<li>描述：${sp.miaoshu }</li>
				</ul>
				 </div>
			<div class="js pl8"><strong>商品评论</strong></div>
			<div class="pl">
				<ul>
					<li><strong><a href="#this">全部</a></strong>
						<ul>
						<c:if test="${!empty pjList}">
						   <c:forEach items="${pjList}" var="list" >
							<li>
								<div class="left"> <img src="<%=basePath%>index/temp/img/icon8.png" alt="" />
									<p>${list.name}</p>
										
								</div>
								<div class="mid">${list.content} <br/>
									<a class="fr" href="#this" >${list.date}</a></div>
							</li>
						</c:forEach>
				 	 </c:if>
				 	 <c:if test="${empty pjList}">
						<tr>
							<td colspan="8" align="center">
								<strong><font color="red">暂无评价</font></strong>
							</td>
						</tr>
				      </c:if>
							<%--<p class="fr pt16"><a  href="#this"class="fr pl8">下一页</a><a href="#this" class="fr pl8">上一页</a><a href="#this"class="fr pl8">3</a><a href="#this"class="fr pl8">2</a><span class="fr pl8"><strong>1</strong></span></p>
						--%></ul>
					</li>
					<li><a href="#this">好评</a></li>
					<li><a href="#this">中评</a></li>
					<li><a href="#this">差评</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div id="footer" class="fl">
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
