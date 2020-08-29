<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>파워로고스.com</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style&js/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="/style&js/bootstrap/bootstrap.css" />
<link rel="stylesheet" href="/style&js/order.css" />
<link rel="stylesheet" href="/style&js/order_desktop.css" />
<link rel="stylesheet" href="/style&js/menu/menu.css" />
<link rel="stylesheet" href="/style&js/board/Board.css" />
<link rel="stylesheet" href="/style&js/sitemap/sitemap.css" />
<link rel="stylesheet" href="/style&js/Admin/admin.css" />

<script src="/style&js/jquery-3.2.1.js"></script>
<script src="/style&js/order.js"></script>
<script src="/style&js/board/Board.js"></script>
<script src="/style&js/board/BoardSearch.js"></script>
<script src="/style&js/login.js"></script>
<script src="/style&js/Admin/admin.js"></script>
<script src="/style&js/bootstrap/bootstrap.min.js"></script>
<script src="/style&js/bootstrap/bootstrap.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width" name="viewport" />
</head>
<body class="body">

	<!-- 메뉴 -->
	<div class="menu_tbl">
	<ul class="menu-option">
	   <c:if test="${sessionScope.login == 'logos'}">
	      <li><a href="#" id="toAdmin">관리자 페이지</a></li>
	   </c:if>
	</ul>
		<div class="menu_tbl_wrapper">
			<ul class="menu_tbl_ul">
				<li><img src="/pictures/logo.gif" class="menu_logo" /></li>
				<li><a class="home_a" href="/">홈으로</a></li>
				<li><a class="AddPay_a" href="/">추가결제</a></li>
				<li><a href="/board/FreeBoard.board" class="board_a">게시판</a></li>
				<li><a href="/" class="point_a">포인트/다운리스트</a></li>
				<li><a href="/Layout/Introduce/Introduce.jsp" class="intro_a">사이트소개</a></li>
				<li><a href="/" class="document_a">자료실</a></li>
				<li><a href="/Layout/SiteMap/SiteMap.jsp" class="siteMap_a">사이트맵</a></li>
			</ul>
		</div>
	</div>