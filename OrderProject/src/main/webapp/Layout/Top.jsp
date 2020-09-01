<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/style&js/style&js.jsp" />
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