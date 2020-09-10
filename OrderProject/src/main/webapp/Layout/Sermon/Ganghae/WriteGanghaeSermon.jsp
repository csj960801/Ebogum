<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 관리자 로그인 확인  -->
<jsp:include page="/Layout/LoginNeed/AdminLogin.jsp" />
<%
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String getToday = dateformat.format(date);
%>

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
		<div class="table_wrapper table-responsive">

			<input type="hidden" id="SermonKind" value="ganghae" />

			<form name="sermonFrm" id="sermonFrm" enctype="multipart/form-data">
				<table class="sermontbl table">
					<tbody class="tbody">
						<tr>
							<th>분류</th>
							<td>
							 ${param.sermonkind}
							 <input type="hidden" name="sermonkind" value="${param.sermonkind}" />
							</td>
						</tr>
						<tr>
							<th>주제</th>
							<td><input type="text" name="sermonSubject" id="sermonSubject" class="sermonform"></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="sermonTitle" id="sermonTitle"
								class="sermonform"></td>
						</tr>
						<tr>
							<th>본문</th>
							<td><input type="text" name="sermonMain" id="sermonMain"
								class="sermonform"></td>
						</tr>
						<tr>
							<th>편수</th>
							<td><input type="text" name="sermonPage" id="sermonPage"
								class="sermonform"></td>
						</tr>
						<tr>
							<th>포인트</th>
							<td><input type="text" name="sermonPoint" id="sermonPoint"
								class="sermonform"></td>
						</tr>
						<tr>
							<th>파일</th>
							<td><input type="file" name="sermonFile" class="sermonform"></td>
						</tr>
						<tr>
							<th>신약/구약</th>
							<td>
							  <select name="sermonBibleType" id="sermonBibleType">
							     <option value="구약">구약</option>
							     <option value="신약">신약</option>							 
							  </select>
							</td>
						</tr>
						<tr>
							<td><input type="hidden" name="sermonDate" value="<%=getToday%>" class="sermonform"></td>
						</tr>
					</tbody>
				</table>

				<div class="clearfix"></div>

				<div class="bottom_wrapper">
					<div class="board_number_wrapper">
						<span class="btn_span">
							<button id="WriteSermonBtn" class="btn btn-sm">등록</button>
						</span>
						<span class="btn_span">
							<button id="sermonListBtn" class="btn btn-sm">목록</button>
						</span>
					</div>

				</div>
			</form>
		</div>

	</div>
</div>

<!-- footer here -->
<jsp:include page="/Layout/Footer.jsp" />