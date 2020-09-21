<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

			<li><a class="thick" href="#" id="file12">절기 설교</a></li>
		</ul>
	</div>
	<div class="main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper">

			<div class="sermonTitle_wrapper">
				<h3 class="sermonTitle">각종특별설교</h3>
			</div>

			<div class="table_wrapper table-responsive">
			
			 <form id="sermonFrm" name="sermonFrm">
			 
				<input type="hidden" id="SermonKind" value="special" />

				<table class="table freeboard_tbl">
					<thead class="thead">
						<tr>
							<th>다운</th>
							<th>주제</th>
							<th>제목</th>
							<th>본문</th>
							<th>편수</th>
							<th>제공일자</th>
							<th>포인트</th>
						</tr>
					</thead>
					<tbody class="tbody">
						<c:if test="${!empty SpecialSermonlist}">
							<c:forEach varStatus="status" items="${SpecialSermonlist}" var="sermonlist">
								<tr>
									<c:if test="${sessionScope.login != null && sessionScope.point > 0}">
									   <td><a href="javascript:Filedownload('${sermonlist.sermonFile}','${sermonlist.sermonPoint}','${sessionScope.login}');">다운로드</a></td>
									</c:if>
									<c:if test="${sessionScope.login == null || sessionScope.point <= 0}">
									   <td><a href="javascript:alert('로그인이 되지않았거나 포인트가 부족합니다.');">다운로드</a></td>
								    </c:if>	
									<td>${sermonlist.sermonSubject}</td>
									<td>
									 <a href="javascript:Sermon_read('${sermonlist.sermonSubject}',
									                                 '${sermonlist.sermonMain}',
									                                 '${sermonlist.sermonTitle}',
									                                 '${sermonlist.sermonPage}',
									                                 '${sermonlist.sermonDate}',
									                                 '${sermonlist.sermonPoint}',
									                                 '${sermonlist.sermonFile}',
									                                 '${status.count}')"
									 class="boardlist_title">${sermonlist.sermonTitle}</a>
									<td>${sermonlist.sermonMain}</td>
									<td>${sermonlist.sermonPage}</td>
									<td>${sermonlist.sermonDate}</td>
									<td>${sermonlist.sermonPoint}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:choose>
							<c:when test="${empty SpecialSermonlist}">
								<tr>
									<td colspan="7">업로드된 자료가 없습니다.</td>
								</tr>
							</c:when>
						</c:choose>
					</tbody>
				</table>
                </form>
                
				<div class="clearfix"></div>

				<div class="bottom_wrapper">
					<div class="board_number_wrapper">
						<c:if test="${sessionScope.login == 'logos'}">
							<span class="btn_span">
								<button id="sermonWriteBtn" class="btn btn-sm">쓰기</button>
							</span>
						</c:if>
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="board_search_wrapper">
					<form id="sermonSearchFrm" name="sermonSearchFrm">
						
						<select name="search_title_kind" id="search_title_kind">
							<option value="subject">주제</option>
							<option value="title">제목</option>
							<option value="main">본문</option>				
						</select>
					
						<input type="text" name="sermonSearchParam" id="sermonSearchParam" />

						<button id="sermonsearchBtn" class="btn btn-sm">검색</button>
						<button id="sermonListBtn" class="btn btn-sm">전체목록</button>
					</form>
				</div>
			</div>

		</div>
	</div>

</div>

<!-- footer here -->
<jsp:include page="/Layout/Footer.jsp" />