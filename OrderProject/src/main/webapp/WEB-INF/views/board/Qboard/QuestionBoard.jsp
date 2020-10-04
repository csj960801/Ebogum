<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.project.PageNavigation.Paging"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Top -->
<jsp:include page="/Layout/Top.jsp" />

<!-- 로그인 삽입 -->
<div class="login_wrapper">
	<jsp:include page="/Layout/loginInput/login_input.jsp" />
</div>

<!-- QnA게시글 목록 -->
<div class="custom_container">
	<div class="side_col col-md-3 col-xs-3">
		<ul class="side_menu_ul board_menu_ul">
			<li class="emphasize"></li>
			<li><span class="arrow_span"></span><a
				href="/board/FreeBoard.board">자유게시판</a></li>
<!-- 			<li><span class="arrow_span"></span><a href="/board/Qboard/QuestionBoard.board">Q&amp;A게시판</a></li>
 -->		</ul>
	</div>
	<div class="FreeBoard_col main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper">
			<img src="/pictures/board/qna_sub_title.gif"
				class="img-responsive questionBoard" />

			<div class="clearfix"></div>

			<div class="table_wrapper table-responsive">
			
				<input type="hidden" id="boardKind" value="questionboard" />
		
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
						<c:if test="${!empty qboardlist}">
							<c:forEach varStatus="status" items="${qboardlist}" var="Questionboardlist">
								<tr>
									<td>${status.count}</td>
									<td><a href="javascript:Questionboard_Read('${status.count}',
																			   '${Questionboardlist.boardWriter}',
																			   '${Questionboardlist.boardTitle}',
																			   '${Questionboardlist.boardContent}',
																			    '1' ,
																			    '${status.count}',
																			    '${Questionboardlist.boarddate}')" class="boardlist_title"> ${Questionboardlist.boardTitle} </a>
									</td>

									<td>${Questionboardlist.boardWriter}</td>
									<td>${Questionboardlist.boarddate}</td>
									<td>${Questionboardlist.boardHit}</td>
								</tr>
							</c:forEach>

							<!-- 답변된 게시글이 존재할 경우 -->
							<c:if test="${!empty qboardanswerlist}">
								<c:forEach varStatus="status" items="${qboardanswerlist}" var="qnaanswerlist">
									<tr class="answer_row">
										<td>${status.count}</td>
										<td><a href="javascript:Answer_Read('${status.count}','${qnaanswerlist.boardWriter}', '${qnaanswerlist.boardTitle}','7-26','${qnaanswerlist.boardContent}', '1' ,'${status.count}','${qnaanswerlist.boarddate}');" class="boardlist_title">${qnaanswerlist.boardTitle}</a>
										</td>
										<td>${qnaanswerlist.boardWriter}</td>
										<td>${qnaanswerlist.boarddate}</td>
										<td>&nbsp;</td>
									</tr>
								</c:forEach>
							</c:if>

						</c:if>
						<c:choose>
							<c:when test="${empty qboardlist}">
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
							Paging boardpage = (Paging) request.getAttribute("qpageNavigation");
						%>
						<div class="boardCntShow_wrapper">
							<%
								out.println(boardpage.getNavigationStr());
								out.println(boardpage.getMakeParaForm());
							%>
						</div>
						<span class="btn_span">
						 	<c:if test="${sessionScope.login != null}">
						 	 
						 	  	<!-- QnA게시판에 데이터가 없을 경우 -->
							  	<c:if test="${fn:length(qboardlist) == 0}">
							   	   <button id="EmptyboardWriteBtn" onclick="boardBtnEffect('${fn:length(qboardlist)}')" class="btn btn-sm">쓰기</button>
							  	</c:if>
								
							  	<!-- QnA게시판에 데이터가 존재할 경우 -->
								<c:set var="qlistflag" value="false" />
							  	<c:forEach varStatus="status" items="${qboardlist}" var="qnaboardlistCnt">  
							
							      <input type="hidden" id="statusCount" value="${status.count}"/>
							
							      <c:if test="${not qlistflag}">
								     <c:if test="${status.count >= 1}">								
										<button id="boardWriteBtn" class="btn btn-sm">쓰기</button>							  		   
										<c:set var="qlistflag" value="true" />    
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