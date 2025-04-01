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
<!-- 引入JQuery支持的库 -->
<script language="JavaScript" src="<%=basePath%>resource/admin/js/jquery.js"></script>
<!-- 引入artDailog支持的库 -->
<link rel="stylesheet" href="<%=basePath%>resource/admin/artDialog/css/ui-dialog.css">
<script language="JavaScript" src="<%=basePath%>resource/admin/artDialog/dist/dialog-plus.js"></script>
 <script type="text/javascript">
	function pingjia(id){
          var d = top.dialog({
        	  title:'  ',
                width:600,
                height:380,
                url:'<%=basePath%>web/user/showPj?id='+id,//可以是一个访问路径Action|Servlet等或者jsp页面资源
                onclose: function () {
                if (this.returnValue="success") {
                    window.location.href= window.location.href;
                }
            }
          });
           d.showModal();
        }
		function toClose(){
        	var dialog = top.dialog.get(window);
        	dialog.close();
        	dialog.remove();
        	return false;
        }
	
	</script>
	<script type="text/javascript">
	  	function seek(){
	  	     $("#seek").submit();
	  	}
	  </script>
<title>我的订单</title>
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
				<li><a href="<%=basePath%>web/oper/selMyDd">我的订单</a></li>
				<li><a href="<%=basePath%>web/oper/selMyGwc">我的购物车</a></li>
				<li><a href="<%=basePath%>web/oper/selMyCollect">我的收藏</a></li>
				<li><a href="<%=basePath%>web/oper/showUser">个人主页</a></li>
			</ul>
		</div>
		<div class="mid2">
			<div class="xg1">我的订单</div>
			<ul>
				<li>
					<table cellpadding="0" cellspacing="0">
						<tr style="height:24px">
							<td style="border-right:none">订单编号</td>
							<td style="border-right:none">商品信息</td>
							<td style="border-right:none">单价</td>
							<td style="border-right:none">数量</td>
							<td style="border-right:none">实付款</td>
							<td style="border-right:none">交易状态</td>
							<td >交易操作</td>
						</tr>
						
					<c:if test="${!empty ddList}">
						<c:forEach items="${ddList}" var="list" >
						<tr>
							<td style="border-right:none">${list.id}000010</td>
							<td><dl>
									<dt class="fl"><img src="<%=basePath%>image/${list.photo}" alt="" /></dt>
									<dd class="fl">${list.sname}</dd>
								</dl></td>
							</td>
							<td style="border-right:none">${list.sprice}元</td>
							<td style="border-right:none">${list.number}</td>
							<td style="border-right:none">${list.tPrice}元</td>
							<td style="border-right:none">
								 
								<font color="red" ><c:if test="${list.state==0}">卖家已接单</c:if></font>
			                    <font color="red" ><c:if test="${list.state==1}">卖家已发货</c:if></font>
			                    <font color="red" ><c:if test="${list.state==2}">交易完成</c:if></font>
			                    <font color="red" ><c:if test="${list.state==3}">交易完成</c:if></font>
							</td>
							<td>
								 <font color="blue" ><c:if test="${list.state==0}"> <a href="<%=basePath%>web/user/deleteDd?id=${list.id}"><font color="blue" >取消订单</font></a> </c:if></font>
				                 <font color="blue" ><c:if test="${list.state==1}"><a href="<%=basePath%>web/user/shouhuo?id=${list.id}"><font color="blue" >确认收货</font></a></a></c:if>
				                 <c:if test="${list.state==2}"><a href="javascript:void(0);" onclick="pingjia('${list.id}')"><font color="blue" >评价</font></a></c:if></font>
								 <font color="black" ><c:if test="${list.state==3}">暂无操作</c:if></font>
							</td>
						</tr>
						</c:forEach>
				  </c:if>
			      <c:if test="${empty ddList}">
					<tr>
						<td colspan="8" align="center">
							<strong><font color="red">暂时没有订单信息</font></strong>
						</td>
					</tr>
				   </c:if>
						
					</table>
					<div class="xg2">
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
