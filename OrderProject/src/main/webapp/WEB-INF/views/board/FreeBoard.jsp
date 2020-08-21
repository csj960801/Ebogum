<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.project.PageNavigation.Paging"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	Date date = new Date();
%>
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
			<li><span class="arrow_span"></span><a href="/board/FreeBoard.board">자유게시판</a></li>
			<li><span class="arrow_span"></span><a
				href="/board/Qboard/QuestionBoard.board">Q&amp;A게시판</a></li>
		</ul>
	</div>
	<div class="FreeBoard_col main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper">
			<img src="/pictures/board/freeBoard_sub_title.gif"
				class="img-responsive freeBoard" />

			<div class="clearfix"></div>

			<div class="table_wrapper table-responsive">
				<input type="hidden" id="boardKind" value="freeboard" />
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
							<th>작성자</th>
							<th>일자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody class="tbody">
						<c:if test="${!empty boardlist}">
							<c:forEach varStatus="status" items="${boardlist}" var="freeboardlist">
								<tr>
									<td>${status.count}</td>
									<td><a href="#" class="boardlist_title" onclick="javascript:freeboard_Read('${status.count}','${freeboardlist.boardWriter}', '${freeboardlist.boardTitle}','7-26','${freeboardlist.boardContent}','1','${status.count}')">${freeboardlist.boardTitle}</a>
									</td>
									<td>${freeboardlist.boardWriter}</td>
									<td><%=date.toString()%></td>
									<td>${freeboardlist.boardHit}</td>
								</tr>
							</c:forEach>
			
							<!-- 답변된 게시글이 존재할 경우 -->
							<c:if test="${!empty boardanswerlist}">
								<c:forEach varStatus="status" items="${boardanswerlist}" var="freeanswerlist">
									<tr class="answer_row">
										<td>${status.count}</td>
										<td><a href="javascript:Answer_Read('${status.count}','${freeanswerlist.boardWriter}', '${freeanswerlist.boardTitle}','7-26','${freeanswerlist.boardContent}','1','${status.count}')" class="boardlist_title">${freeanswerlist.boardTitle}</a>
										</td>
										<td>${freeanswerlist.boardWriter}</td>
										<td><%=date.toString()%></td>
										<td>&nbsp;</td>
									</tr>
								</c:forEach>
							</c:if>
						</c:if>
						<c:choose>
							<c:when test="${empty boardlist}">
								<tr>
									<td colspan="5">작성된 게시글이 없습니다.</td>
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
							 
							  <!-- 자유게시판에 데이터가 없을 경우 -->
							  <c:if test="${fn:length(boardlist) == 0}">
							     <button id="boardWriteBtn" onclick="javascript:window.location.href='/Layout/Board/WriteFreeBoard.jsp?boardParam=1'" class="btn btn-sm">쓰기</button>
							  </c:if>
							    
							  <!-- 자유게시판에 데이터가 존재할 경우 -->
							  <c:set var="listflag" value="false" />
							  <c:forEach varStatus="status" items="${boardlist}" var="freeboardlistCnt">  
							  	  <input type="hidden" id="statusCount" value="${status.count}"/>
							      <c:if test="${not listflag}">
								     <c:if test="${status.count >= 1}">
								       <button id="boardWriteBtn" class="btn btn-sm">쓰기</button>
							  		   <c:set var="listflag" value="true" />    
							         </c:if>
							      </c:if>		  	
							   </c:forEach>
							</c:if>
							<c:choose>
								<c:when test="${sessionScope.login == null}">
									<button id="noneLoginBtn" onclick="javascript:alert('회원전용!!!')" class="btn btn-sm">쓰기</button>
								</c:when>
							</c:choose>
						</span>
					</div>

				</div>
				
				<div class="clearfix"></div>
			
				<div class="board_search_wrapper">
				   <form id="boardSearchFrm" name="boardSearchFrm">
				      <select name="board_title_kind" id="board_title_kind">
				        <option value="title">제목</option>
				        <option value="content">내용</option>
				        <option value="writer">작성자</option>
				      </select>
				    
				      <input type="text" name="boardSearchParam" id="boardSearchParam" />
				    
				      <button id="searchBtn" class="btn btn-sm">검색</button>
				      <button id="searchListBtn" class="btn btn-sm">전체목록</button>
				    </form>
				</div>
			</div>

		</div>
	</div>
</div>

<!-- Footer -->
<jsp:include page="/Layout/Footer.jsp" />