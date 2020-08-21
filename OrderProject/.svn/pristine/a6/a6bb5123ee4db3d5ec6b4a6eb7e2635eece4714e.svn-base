<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 로그인 여부  -->
<jsp:include page="/Layout/LoginNeed/LoginNeed.jsp" />

<!-- Top -->
<jsp:include page="/Layout/Top.jsp" />

<!-- 로그인 삽입 -->
<div class="login_wrapper">
	<jsp:include page="/Layout/loginInput/login_input.jsp" />
</div>

<div class="custom_container freeboard_wrapper">
	<div class="side_col col-md-3 col-xs-3">
		<ul class="side_menu_ul board_menu_ul">
			<li class="emphasize"></li>
			<li><span class="arrow_span"></span><a href="/board/FreeBoard.board">자유게시판</a></li>
			<li><span class="arrow_span"></span><a href="/board/Qboard/QuestionBoard.board">Q&amp;A게시판</a></li>
		</ul>
	</div>
	<div class="main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper">
			<img src="/pictures/board/freeBoard_sub_title.gif"
				class="img-responsive freeBoard" />

			<div class="clearfix"></div>

			<div class="table_wrapper table-responsive">
				<h5 class="freeboard_title">⊙글 삭제하기</h5>
					<input type="hidden" id="boardCnt" value="3" />
			
				    <form id="WriteBoardFrm" name="WriteBoardFrm" class="WriteBoardFrm">
					<table class="table freeboard_tbl">
						<tbody class="tbody">
							<tr>
								<th class="delFreeBoardTh">비밀번호</th>
								<td class="delFreeBoardTd"><input type="password" class="password" id="password"
									name="boardPassword">(게시물 삭제에 사용한 비밀번호를 입력하세요.) </td>
							</tr>
						</tbody>
					</table>

					<div class="bottom_wrapper">
						<div class="board_number_wrapper">
							<button id="FreeBoardListBtn" class="btn btn-sm">목록</button>

							<span class="btn_span">
								<button id="boardDelBtn" class="btn btn-sm">삭제</button>
							</span> 
							
							<span class="btn_span">
								<button id="boardCancelBtn" class="btn btn-sm" onclick="javascript:document.WriteBoardFrm.reset();">취소</button>
							</span>
						</div>
					</div>
					</form>
			</div>

		</div>
	</div>
</div>

<!-- Top -->
<jsp:include page="/Layout/Footer.jsp" />