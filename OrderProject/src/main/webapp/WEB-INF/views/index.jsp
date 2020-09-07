<%@page import="java.sql.*"%>
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
		<ul class="side_menu_ul">
			<li class="emphasize"><a>부회원[과거자료]</a></li>
			<li><a href="#" id="file1">주일 설교</a></li>
			<li><a href="#" id="file2">강해 설교</a></li>
			<li><a href="#" id="file3">인물 설교</a></li>
			<li><a href="#" id="file4">철야기도회 설교</a></li>
			<li><a href="#" id="file5">심방설교</a></li>
			<li><a href="#" id="file6">헌신예배 설교</a></li>
			<li><a href="#" id="file7">각종특별 설교</a></li>
			<li><a href="#" id="file8">칼럼형예화</a></li>

			<li><a class="thick">새벽설교</a></li>
			<li>
				<ul class="option_ul">
					<li><a href="#" id="file9">강해별</a></li>
					<li><a href="#" id="file10">사건별</a></li>
					<li><a href="#" id="file11">주제별</a>
				</ul>
			</li>

			<li><a class="thick">절기 설교</a></li>
			<li>
				<ul class="option_ul">
					<li><a href="#" id="file12">성탄절</a></li>
					<li><a href="#" id="file13">사순절</a></li>
					<li><a href="#" id="file14">부활절</a></li>
					<li><a href="#" id="file15">성림강림절</a></li>
					<li><a href="#" id="file16">추석추수맥추절</a></li>
					<li><a href="#" id="file17">종교개혁주일</a></li>
					<li><a href="#" id="file18">송구영신예배</a></li>
					<li><a href="#" id="file19">국가기념일</a></li>
					<li><a href="#" id="file20">가정의달</a></li>
					<li><a href="#" id="file21">수련회 설교</a></li>
					<li><a href="#" id="file22">창립및 전도</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div class="main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper index_wrapper">
			<div class="main_board_1">
				<img src="/pictures/main/imgpow.gif" class="main_board_title" />

				<div class="clearfix"></div>

				<div class="board1">
					<h5 class="board_title">
						<a href="#" class="member_a">정 스페셜 회원</a>
					</h5>
					<span class="main_board_span"> 파워로고스 선교회에서 제공하는 ‘목회와 정보’ 자료는
						전문 집필진 들로부터 매주 새롭게 작성한 원 고를 선교회에서 다시 수정하고 보완하여 정성껏 다듬은 자료들로 서
						다른사이트에서 제공하는 자료 와는 차별화된 자료들 입니다....</span>
				</div>
				<div class="board2">
					<h5 class="board_title">
						<a href="#" class="sermon_a">견본설교 </a>
					</h5>
					<span class="main_board_span"> 견본설교자료는 파워로고스 선교 회의 ‘목회와 정보’
						자료의 수준을 가늠할 수 있도록 출간된 자료 중 에서 평균 수준의 자료를 각각의 설교자료별로 올려놓은 것입니다. 따라서
						방문하신 목회자님께서는 주저하지 마시고 일단한번 다운..</span>
				</div>
				<div class="board3">
					<!-- 자유게시판 -->
					<div class="freeboard_here"></div>
				</div>
			</div>

			<div class="clearfix"></div>

			<div class="main_board_2">
				<img src="/pictures/main/board_sub_title_1_a.gif" class="main_board_title" />
			    <jsp:include page="/board/Noticeboard/NoticeBoard.board"/>
			</div>
		</div>
	</div>
</div>

<!-- footer here -->
<jsp:include page="/Layout/Footer.jsp" />