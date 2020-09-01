<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	Date today = new Date();
	String getToday = date.format(today);
%>
<!-- 로그인 여부  -->
<jsp:include page="/Layout/LoginNeed/LoginNeed.jsp" />

<jsp:include page="/style&js/style&js.jsp" />

<body>
<div class="custom_container noticeboard_wrapper">
	<div class="main_col col-md-12 col-xs-12">
		<div class="main_board_wrapper">
			<img src="/pictures/board/notice_title.gif" class="img-responsive noticeBoard" />

			<div class="clearfix"></div>

			<div class="table_wrapper">
				<h5 class="freeboard_title">⊙글 수정하기</h5>
				<form id="WriteBoardFrm" name="WriteBoardFrm" class="WriteBoardFrm">
					
					<input type="hidden" id="boardCnt" value="16"/>
					
					<table class="table Writefreeboard_tbl">
						<tbody class="tbody">
							<tr>
								<th class="th">제목</th>
								<td><input type="text" value="${param.revTitle}" class="title" id="title" name="boardTitle"></td>
							</tr>
							<tr>
								<th class="th">내용</th>
								<td><textarea id="content" class="content"
										name="boardContent" rows="10" cols="70">${param.revContent}</textarea></td>
							</tr>
							<tr>
								<td><input name="boarddate" type="hidden" value="<%=getToday%>"></td>
							</tr>
							<tr>
								<td><input name="boardParam" type="hidden" value="${param.revParam}"></td>
								<td><input name="bno" type="hidden" value="${param.revCnt}"></td>
							</tr>
						</tbody>
					</table>
					
                    <input type="hidden" id="revHit" value="${param.revHit}" />

					<div class="bottom_wrapper">
						<div class="board_number_wrapper">
							<button id="NoticeBoardListBtn" class="btn btn-sm">목록</button>

							<span class="btn_span">
								<button id="NoticeBoardRegBtn" class="btn btn-sm">등록</button>
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

</body>