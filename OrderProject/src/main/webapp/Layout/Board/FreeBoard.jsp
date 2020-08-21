<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Top -->
<jsp:include page="/Layout/Top.jsp" />

<!-- 로그인 삽입 -->
<div class="login_wrapper">
	<jsp:include page="/Layout/loginInput/login_input.jsp" />
</div>

<div class="custom_container">
	<div class="side_col col-md-3 col-xs-3">
		<ul class="side_menu_ul board_menu_ul">
			<li class="emphasize"></li>
			<li><span class="arrow_span"></span><a href="#">자유게시판</a></li>
			<li><span class="arrow_span"></span><a href="#">Q&amp;A게시판</a></li>
		</ul>
	</div>
	<div class="main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper">
			<img src="/pictures/board/freeBoard_sub_title.gif" class="img-responsive freeBoard" />

			<div class="clearfix"></div>
		</div>
	</div>
</div>

<!-- Top -->
<jsp:include page="/Layout/Footer.jsp" />