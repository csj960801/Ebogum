<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Top -->
<jsp:include page="/Layout/Top.jsp" />

<!-- 로그인 삽입 -->
<div class="login_wrapper">
	<jsp:include page="/Layout/loginInput/login_input.jsp" />
</div>

<!-- 자유게시글 목록 -->
<div class="custom_container">
	<div class="side_col col-md-3 col-xs-3">
		<ul class="side_menu_ul board_menu_ul">
			<li class="emphasize"></li>
			<li><span class="arrow_span"></span><a
				href="/board/FreeBoard.board">자유게시판</a></li>
			<!-- 	<li><span class="arrow_span"></span><a href="/board/Qboard/QuestionBoard.board">Q&amp;A게시판</a></li>-->
		</ul>
	</div>
	<div class="main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper">
			<img src="/pictures/board/freeBoard_sub_title.gif"
				class="img-responsive freeBoard" />

			<div class="clearfix"></div>

			<div class="table_wrapper table-responsive">
				<h5 class="freeboard_title">⊙ 글내용보기</h5>
				<form id="WriteBoardFrm" name="WriteBoardFrm" class="WriteBoardFrm">

					<table class="table freeboard_tbl">
						<tbody class="tbody">
							<tr>
								<th>번호</th>
								<td>${param.boardCnt}</td>

								<th>작성자</th>
								<td>${param.boardWriter}</td>

								<th>등록일자</th>
								<td>${param.boarddate}</td>
							</tr>
							<tr>
								<th>제목</th>
								<td colspan="5">${param.boardlistTitle}</td>
							</tr>
							<tr class="select_tr">
								<td colspan="9">
									<div class="select_wrapper">${param.boardContent}</div>
								</td>
							</tr>
							<tr>
								<td>
									<!-- 답변 게시글에 적용시킬 값  -->
									<input type="hidden" name="boardParam" id="boardAnswerParam" value="${param.boardParam}">
								</td>
							</tr>
						</tbody>
						<tfoot class="tfoot">
							<tr>
								<td align="left"><button id="FreeBoardListBtn" class="btn btn-sm">목록</button></td>
								<td colspan="3">&nbsp;</td>
								<td colspan="3" class="tfoot_btn_td">
									<ul class="btn_ul">
										<li><button id="FreeboardReviseBtn" class="btn btn-sm">수정</button></li>
										<li><button id="FreeboardDelBtn" class="btn btn-sm">삭제</button></li>
										<li><button id="FreeboardAnswerBtn" class="btn btn-sm">답변</button></li>
									</ul>
								</td>
							</tr>
						</tfoot>
					</table>
				</form>

				<input type="hidden" id="boardWriter" value="${param.boardWriter}">
				<input type="hidden" id="boardTitle" value="${param.boardlistTitle}">
				<input type="hidden" id="boardContent" value="${param.boardContent}">
				<input type="hidden" id="boardHit" value="${param.boardHit}">
				<input type="hidden" id="boarddate" value="${param.boarddate}">

			</div>

		</div>
	</div>
</div>

<!-- Footer -->
<jsp:include page="/Layout/Footer.jsp" />