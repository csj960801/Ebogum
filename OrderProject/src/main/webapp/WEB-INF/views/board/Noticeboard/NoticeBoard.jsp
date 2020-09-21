<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.project.PageNavigation.Paging"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/style&js/style&js.jsp" />

<body>
<!-- 공지게시글 목록 -->
<div class="custom_container">
	<div class="noticeboard_wrapper col-md-9 col-xs-9">
		<div class="main_board_wrapper">

			<div class="table_wrapper table-responsive">

				<input type="hidden" id="boardKind" value="noticeboard" />

				<table class="table freeboard_tbl">
					<colgroup>
						<col width="10%" />
						<col width="30%" />
						<col width="25%" />
						<col width="25%" />
						<col width="10%" />
					</colgroup>
					<thead class="thead">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>일자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody class="tbody">
						<c:if test="${!empty noticeList}">
							<c:forEach varStatus="status" items="${noticeList}" var="noticeboardlist">
								<tr>
									<td>${status.count}</td>
									<td><a
										href="javascript:Noticeboard_Read('${status.count}','${noticeboardlist.boardTitle}','${noticeboardlist.boardContent}','${noticeboardlist.boardHit}','${status.count}','${noticeboardlist.boarddate}')"
										class="boardlist_title">${noticeboardlist.boardTitle}</a></td>
									<td>${noticeboardlist.boarddate}</td>
									<td>${noticeboardlist.boardHit}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:choose>
							<c:when test="${empty noticeList}">
								<tr>
									<td colspan="4">작성된 게시글이 없습니다.</td>
								</tr>
							</c:when>
						</c:choose>
					</tbody>
				</table>

				<div class="clearfix"></div>

				<div class="bottom_wrapper">
					<div class="board_number_wrapper">

						<%
							/*총 게시글 수 작업 */
						Paging boardpage = (Paging) request.getAttribute("pageNavigation");
						%>
						<div class="boardCntShow_wrapper">
							<%
							out.println(boardpage.getNavigationStr());
							out.println(boardpage.getMakeParaForm());
							%>
						</div>

						<span class="btn_span"> 
						   <c:if test="${sessionScope.login != null}">

								<!-- 공지사항게시판에 데이터가 없을 경우 -->
								<c:if test="${fn:length(noticeList) == 0 && sessionScope.login == 'logos'}">
									<button id="EmptyboardWriteBtn" onclick="boardBtnEffect('${fn:length(boardlist)}')" class="btn btn-sm">쓰기</button>
								</c:if>

								<!-- 공지사항게시판에 데이터가 존재할 경우 -->
								<c:set var="listflag" value="false" />
								<c:forEach varStatus="status" items="${noticeList}" var="NoticeboardlistCnt">

									<input type="hidden" id="statusCount" value="${status.count}" />

									<c:if test="${!listflag}">
										<c:if test="${status.count >= 1 && sessionScope.login == 'logos'}">
											<button id="boardWriteBtn" class="btn btn-sm">쓰기</button>
											<c:set var="listflag" value="true" />
										</c:if>
									</c:if>
								</c:forEach>

							</c:if>
							<c:choose>
								<c:when test="${sessionScope.login == null}">
									&nbsp;
								</c:when>
							</c:choose>
						</span>
					</div>

				</div>

			</div>

		</div>
	</div>
</div>
</body>