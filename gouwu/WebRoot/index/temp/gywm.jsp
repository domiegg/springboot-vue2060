<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于我们</title>
<link rel="stylesheet" href="style/ty.css" type="text/css" />
<link rel="stylesheet" href="style/all.css" type="text/css" />
<script type="text/javascript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
	  <script type="text/javascript">
	  	function seek(){
	  	     $("#seek").submit();
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
	<<div class="mid">
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
	<div id="gywm">
		<div class="content">
			<div class="left">
				<div class="tit">关于农大购物商城</div>
				<ul>
					<li>关于我们</li>
				</ul>
			</div>
			<div class="right">
				<h2>关于农大购物商城</h2>
				<p>根据第三方市场研究公司艾瑞咨询的数据，农大购物商城是中国最大的自营式电商企业，2015年第一季度在中国自营式B2C电商市场的占有率为56.3%。2014年，京东市场交易额达到2602亿元，净收入达到1150亿元。2015年第二季度，京东市场交易额达到1145亿元，同比增长82%；净收入达到459亿元，同比增长61%。</p>
				<p> 目前，京东集团旗下设有京东商城、京东金融、拍拍、京东智能、京东到家及海外事业部。2014年5月，京东在美国纳斯达克证券交易所正式挂牌上市，是中国第一个成功赴美上市的大型综合型电商平台，并跻身全球前十大互联网公司排行榜。2015年7月，京东因其高成长性入选纳斯达克100指数和纳斯达克100平均加权指数，成为纳斯达克100指数中仅有的2家中国互联网公司之一。</p>
				<p> 京东致力于为消费者提供愉悦的在线购物体验。通过内容丰富、人性化的网站（www.jd.com）和移动客户端，京东以富有竞争力的价格，提供具有丰富品类及卓越品质的商品和服务，以快速可靠的方式送达消费者，并且提供灵活多样的支付方式。另外，京东还为第三方卖家提供在线销售平台和物流等一系列增值服务。
					京东提供丰富优质的商品，品类包括：计算机、手机及其它数码产品、家电、汽车配件、服装与鞋类、奢侈品（如：手提包、手表与珠宝）、家居与家庭用品、化妆品与其它个人护理用品、食品与营养品、书籍、电子图书、音乐、电影与其它媒体产品、母婴用品与玩具、体育与健身器材以及虚拟商品（如：国内机票、酒店预订等）。
					京东拥有中国电商行业最大的仓储设施。截至2015年6月30日，京东在全国拥有7大物流中心，在全国44座城市运营166个大型仓库，拥有4142个配送站和自提点，覆盖全国2043个区县。京东专业的配送队伍能够为消费者提供一系列专业服务，如：211限时达、次日达、夜间配和三小时极速达，GIS包裹实时追踪、售后100分、快速退换货以及家电上门安装等服务，保障用户享受到卓越、全面的物流配送和完整的“端对端”购物体验。</p>
				<p> 京东是一家技术驱动的公司，从成立伊始就投入巨资开发完善可靠、能够不断升级、以电商应用服务为核心的自有技术平台。我们将继续增强公司的技术平台实力，以便更好地提升内部运营效率，同时为合作伙伴提供卓越服务。
					配送服务说明：
					211限时达：当日上午11：00前提交的现货订单（部分城市为上午10点前），以订单出库完成拣货时间点开始计算，当日送达；夜里11：00前提交的现货订单（以订单出库后完成拣货时间点开始计算），次日15：00前送达。截至2015年7月31日，“211限时达”已覆盖全国135个区县。</p>
				<p> 次日达：在一定时间点之前提交的现货订单（以订单出库后完成拣货的时间点开始计算），将于次日送达。截至2015年7月31日，“次日达”已覆盖全国951个区县。
					极速达：京东为消费者提供的一项个性化付费增值服务。消费者通过“在线支付”方式全额成功付款或“货到付款”方式成功提交订单，并勾选“极速达”服务后，京东会在服务时间内，3小时将商品送至消费者所留地址。目前，“极速达”业务在北京、上海、广州、成都、武汉、沈阳六个城市提供服务。</p>
				<p> 夜间配：京东为消费者提供更快速、更便利的一项增值服务。消费者下单时在日历中选择“19:00-22:00”时段，属“夜间配”服务范围内的商品，京东会尽可能安排配送员在消费者选定当日晚间19:00-22:00送货上门。目前，“夜间配”业务在北京、上海、广州、成都、武汉、沈阳六个城市提供服务。</p>
				<p>媒体垂询: media-contact@jd.com</p>
			</div>
		</div>
	</div>
	<div id="footer">
		<ul>
			<li><a href="#this">关于我们</a><>
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
</div>
</body>
</html>
