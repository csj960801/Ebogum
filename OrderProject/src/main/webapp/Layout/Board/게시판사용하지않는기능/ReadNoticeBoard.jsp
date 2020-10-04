<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/style&js/style&js.jsp" />

<body>
	<!-- 공지게시글 읽기 -->
	<div class="custom_container">
		<div class="main_col col-md-12 col-xs-12">
			<div class="main_board_wrapper">
				<img src="/pictures/board/notice_title.gif"
					class="img-responsive noticeBoard" />

				<div class="clearfix"></div>

				<div class="table_wrapper table-responsive">
					<h5 class="freeboard_title">⊙ 글내용보기</h5>
					<form id="WriteBoardFrm" name="WriteBoardFrm" class="WriteBoardFrm">

						<table class="table freeboard_tbl">
							<tbody class="tbody">
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
										<!-- 답변 게시글에 적용시킬 값  --> <input type="hidden"
										name="boardParam" id="boardAnswerParam"
										value="${param.boardParam}">
									</td>
								</tr>
							</tbody>
							<tfoot class="tfoot">
								<tr>
									<td align="left" class="tfoot_btn_td"><button id="NoticeBoardListBtn" class="btn btn-sm">목록</button></td>
									<c:if test="${sessionScope.login == 'logos'}">
										<td class="tfoot_btn_td" colspan="3" align="right">
											<ul class="btn_ul">
												<li><button id="NoticeboardReviseBtn" class="btn btn-sm">수정</button></li>
												<li><button id="NoticeboardDelBtn" class="btn btn-sm">삭제</button></li>
												<li><button id="NoticeboardCloseBtn" class="btn btn-sm">닫기</button></li>
											</ul>
										</td>
									</c:if>

									<c:if test="${sessionScope.login != 'logos'}">
										<td align="right">
											<button id="NoticeboardCloseBtn" class="btn btn-sm">닫기</button>
										</td>
									</c:if>

								</tr>
								<tr></tr>
								<tr></tr>
							</tfoot>
						</table>
					</form>

					<input type="hidden" id="boardCnt" value="${param.boardCnt}">
					<input type="hidden" id="boardTitle"
						value="${param.boardlistTitle}"> <input type="hidden"
						id="boardContent" value="${param.boardContent}"> <input
						type="hidden" id="boardHit" value="${param.boardHit}"> <input
						type="hidden" id="boardParam" value="${param.boardParam}">
					<input type="hidden" id="boarddate" value="${param.boarddate}">

				</div>

			</div>
		</div>
	</div>
</body>