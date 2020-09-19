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

			<li><a class="thick">절기 설교</a></li>
			<li>
				<ul class="option_ul">
					<li><a href="#" id="file12">성탄절</a></li>
					<li><a href="#" id="file13">사순절</a></li>
					<li><a href="#" id="file14">부활절</a></li>
					<li><a href="#" id="file15">성림강림절</a></li>
					<li><a href="#" id="file16">추석추수맥추절</a></li>
					<li><a href="#" id="file17">종교개혁주일</a></li>
					<li><a href="#" id="file18">송구영신예배</a></li>
					<li><a href="#" id="file19">국가기념일</a></li>
					<li><a href="#" id="file20">가정의달</a></li>
					<li><a href="#" id="file21">수련회 설교</a></li>
					<li><a href="#" id="file22">창립및 전도</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div class="main_col col-md-9 col-xs-9">
		<div class="main_board_wrapper">

			<div class="sermonTitle_wrapper">
				<h3 class="sermonTitle">⊙다운로드</h3>
			</div>

			<div class="table_wrapper table-responsive">
				<form id="sermonFrm" name="sermonFrm">
				
				<input type="hidden" id="SermonKind" value="ganghaebyol">
				
					<table class="table freeboard_tbl sermon_tbl">
						<tbody class="tbody">
							<tr>
								<th>구분</th>
								<td>${param.sermonType}</td>
							</tr>
							<tr>
								<th>주제</th>
								<td>${param.sermonSubject}</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>${param.sermonTitle}</td>
							</tr>
							<tr>
								<th>본문</th>
								<td>${param.sermonMain}</td>
							</tr>
							<tr>
								<th>제공시기</th>
								<td>${param.sermonDate}</td>
							</tr>
							<tr>
								<th>포인트</th>
								<td>${param.sermonPoint}</td>
							</tr>
							<tr>
								<th>파일다운</th>
							    <c:if test="${sessionScope.login != null && sessionScope.point > 0}">
								   <td><a href="javascript:Filedownload('${param.sermonFileDown}','${param.sermonPoint}','${sessionScope.login}')">다운로드</a></td>
							    </c:if>
							    <c:if test="${sessionScope.login == null || sessionScope.point <= 0}">
						           <td><a href="#" onclick="javascript:alert('포인트가 부족하거나 로그인되어 있지 않습니다.');">다운로드</a></td>							   
						        </c:if>
							</tr>
							<tr>
								<td colspan="2">
									<p class="download_warn">(다운로드아이콘 클릭시 포인트 차감되므로 유의하시기바랍니다.)</p>
								</td>
							</tr>
							<tr>
								<td><input type="hidden" name="sermonCnt" id="sermonCnt" value="${param.sermonCnt}" /></td>
							</tr>

						</tbody>
						<tfoot class="tfoot">
							<tr>
								<td colspan="2" class="tfoot_btn_td">
									<ul class="sermon_btn_ul">
										<c:if test="${sessionScope.login == 'logos'}">
											<li><button id="SermonReviseBtn" class="btn btn-sm">수정</button></li>
											<li><button id="SermonDelBtn" class="btn btn-sm">삭제</button></li>
										</c:if>
										<li><button id="sermonListBtn" class="btn btn-sm">목록</button></li>
									</ul>
								</td>
							</tr>
						</tfoot>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>

<input type="hidden" id="revSubject" value="${param.sermonSubject}">
<input type="hidden" id="revTitle" value="${param.sermonTitle}">
<input type="hidden" id="revMain" value="${param.sermonMain}">
<input type="hidden" id="revPage" value="${param.sermonPage}">
<input type="hidden" id="revPoint" value="${param.sermonPoint}">
<input type="hidden" id="revDate" value="${param.sermonDate}">
<input type="hidden" id="revFileDown" value="${param.sermonFileDown}">
<input type="hidden" id="revCnt" value="${param.sermonCnt}">

<!-- footer here -->
<jsp:include page="/Layout/Footer.jsp" />