<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Top -->
<jsp:include page="/Layout/Top.jsp" />

<!-- 로그인 삽입 -->
<div class="login_wrapper">
	<jsp:include page="/Layout/loginInput/login_input.jsp" />
</div>

<div class="custom_container SiteMap_wrapper">
	<div class="side_col col-md-3 col-xs-3">
		<ul class="side_menu_ul sitemap_menu_ul">
			<li class="emphasize"></li>
			<li><span class="arrow_span"></span><a
				href="/Layout/SiteMap/SiteMap.jsp">사이트맵</a></li>
		</ul>
	</div>

	<div class="main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper">

			<img src="/pictures/SiteMap/sitemap_sub_title.gif"
				class="img-responsive SiteMap" />

			<div class="clearfix"></div>

			<div class="table-responsive sitemap_wrapper">
				<table class="table sitemap_table">
					<tbody class="tbody">
						<tr class="emphasize_tr">
							<th>홈으로</th>
							<td><a class="sitemap_a" href="/">| 홈으로 |</a></td>
						</tr>
						<tr>
							<th>추가결제</th>
							<td><a class="sitemap_a" href="#">| 추가결제 |</a></td>
						</tr>
						<tr>
							<th>게시판</th>
							<td><a class="sitemap_a" href="/board/FreeBoard.board">| 자유게시판</a> | <!-- <a class="sitemap_a" href="/board/Qboard/QuestionBoard.board"> Q&amp;A게시판 |</a> --></td>
						</tr>
						<tr>
							<th>ID/PW 찾기</th>
							<td><a class="sitemap_a" href="/Layout/FindInfo/FindInfo.jsp">| ID/PW 찾기 |</a></td>
						</tr>
						<tr>
							<th>사이트 소개</th>
							<td><a class="sitemap_a" href="/Layout/Introduce/Introduce.jsp">| 사이트 소개 |</a></td>
						</tr>
						<tr>
							<th>자료실</th>
							<td><a class="sitemap_a" href="#">| 자료실 |</a></td>
						</tr>
						<tr>
							<th>사이트맵</th>
							<td><a class="sitemap_a" href="/Layout/SiteMap/SiteMap.jsp">| 사이트맵 |</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- Footer -->
<jsp:include page="/Layout/Footer.jsp" />
