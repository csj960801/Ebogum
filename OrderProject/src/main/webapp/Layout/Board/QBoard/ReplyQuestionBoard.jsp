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
			<li><span class="arrow_span"></span><a
				href="/board/FreeBoard.board">자유게시판</a></li>
	<!-- 		<li><span class="arrow_span"></span><a
				href="/board/Qboard/QuestionBoard.board">Q&amp;A게시판</a></li>-->	</ul>
	</div>
	<div class="main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper">
			<img src="/pictures/board/qna_sub_title.gif"
				class="img-responsive QuestionBoard" />

			<div class="clearfix"></div>

			<div class="table_wrapper">
				<h5 class="freeboard_title">⊙답변하기</h5>
				<form id="WriteBoardFrm" name="WriteBoardFrm" class="WriteBoardFrm">
					
					<input type="hidden" id="boardCnt" value="8" />
					
					<table class="table Writefreeboard_tbl">
						<tbody class="tbody">
							<tr>
								<th class="th_writer">작성자</th>
								<td><input type="text" name="boardWriter" id="revWriter">
								</td>
							</tr>
							<tr>
								<th class="th">E-mail</th>
								<td><input type="email" class="email" id="email"
									name="boardEmail" value=" "></td>
							</tr>
							<tr>
								<th class="th">제목</th>
								<td><input type="text" value="[RE]" class="title"
									id="title" name="boardTitle"></td>
							</tr>
							<tr>
								<th class="th">내용</th>
								<td><textarea id="content" class="content"
										name="boardContent" rows="10" cols="70"></textarea></td>
							</tr>
							<tr>
								<th class="th">비밀번호</th>
								<td><input type="password" class="password"
									name="boardPassword" id="password">(게시물의 수정,삭제 시 필요한
									비밀번호입니다.)</td>
							</tr>
							<tr>
								<td>
									<!-- QnA게시글에 대한 답변 파라미터 --> 
									<input type="hidden" id="boardParam" name="boardParam" value="${param.boardParam}">
								</td>
							</tr>
						</tbody>
					</table>

					<div class="bottom_wrapper">
						<div class="board_number_wrapper">
							<button id="FreeBoardListBtn" class="btn btn-sm">목록</button>

							<span class="btn_span">
								<button id="boardRegBtn" class="btn btn-sm">등록</button>
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

<!-- Footer -->
<jsp:include page="/Layout/Footer.jsp" />