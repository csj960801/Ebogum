<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Top -->
<jsp:include page="/Layout/Top.jsp" />

<!-- 로그인 삽입 -->
<div class="login_wrapper">
	<jsp:include page="/Layout/LoginNeed/LoginNeed.jsp" />
	<jsp:include page="/Layout/loginInput/login_input.jsp" />
</div>

<div class="custom_container Admin_wrapper">
	<div class="side_col col-md-2 col-xs-2">
		<ul class="side_menu_ul admin_menu_ul" id="admin_menu_ul">
			<li class="emphasize"></li>
			<li><span class="arrow_span"></span> <a href="#" id="memberManageBtn">회원관리</a></li>
			<li><span class="arrow_span"></span> <a href="#" id="memberDelBtn">회원삭제</a></li>
			<li><span class="arrow_span"></span> <a href="#">결제현황</a></li>
			<li><span class="arrow_span"></span> <a href="#">서비스종료일정렬</a></li>
		</ul>
	</div>

	<div class="main_col col-md-10 col-xs-10">
		<div class="main_board_wrapper">
			<div class="table-responsive admin_wrapper">

				<input type="hidden" id="adminPageCnt" value="2" />

				<form id="adminFrm" class="adminFrm" name="adminFrm">
					<table class="table admin_table">
						<colgroup>
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />

						</colgroup>
						<tbody class="Admintbody">
							<tr>
								<td colspan="9">
								  <h4 class="adminManage_table_title">회원삭제</h4>
								</td>
							</tr>
							<tr class="search_tr">
								<td>
								  <input type="text" placeholder="검색하실 ID를 입력해주세요." name="adminSearchId" class="adminform" id="adminSearchId" />
								  <button id="manager_SearchbyId_btn" class="adminBtn btn btn-sm">아이디로 검색</button>
								</td>
								<td>
								  <input type="text" placeholder="검색하실 이름을 입력해주세요." name="adminSearchName" class="adminform" id="adminSearchName" />
								  <button id="manager_SearchbyName_btn" class="adminBtn btn btn-sm">이름으로 검색</button>
								</td>
								<!-- 	<td><input type="text" placeholder="검색하실 주소를 입력해주세요." name="adminSearchAddress" class="adminform" id="adminSearchAddr" /><button id="manager_SearchbyAddr_btn" class="adminBtn btn btn-sm">주소로 검색</button></td> -->
							</tr>
							<tr>
								<td colspan="9">
									<div class="manageData_wrapper table-responsive">
										<table class="table inner_admin_table">
											<colgroup>
												<col width="10%" />
												<col width="10%" />
												<col width="10%" />
												<col width="10%" />
												<col width="10%" />
												<col width="10%" />
												<col width="10%" />
												<col width="10%" />
											</colgroup>

											<thead class="thead">
												<tr>
													<th>순번</th>
													<th>아이디</th>
													<th>패스워드</th>
													<th>성명</th>
													<th>가입</th>
													<th>서비스시작일</th>
													<th>서비스종료일</th>
													<th>삭제</th>
												</tr>
											</thead>
											<tbody class="tbody">
												<c:if test="${memberlist != null}">
													<c:forEach items="${memberlist}" var="managingMember" varStatus="status">
														<tr>
															<td>${status.count}</td>
															<td>
															  ${managingMember.duplicateid}
															  <input type="hidden" name="duplicateid" id="duplicateid" value="${managingMember.duplicateid}" />
															</td>
															<td>
															  ${managingMember.pass1} 
															  <input type="hidden" name="pass1" id="pass" value="${managingMember.pass1}" />
															</td>
															<td>
															  ${managingMember.name} 
															  <input type="hidden" name="name" id="name" value="${managingMember.name}" />
															</td>
															<td>
															  ${managingMember.date} 
															  <input type="hidden" name="date" id="date" value="${managingMember.date}" />
															</td>
															<td></td>
															<td></td>
															<td><a href="javascript:DelMember('${managingMember.duplicateid}','${managingMember.pass1}','${managingMember.name}');" class="btn btn-default">삭제하기</a></td>
														</tr>
													</c:forEach>
												</c:if>
												<c:if test="${memberlist == null}">
													<tr>
														<td colspan="8">존재하는 계정이 없습니다.</td>
													</tr>
												</c:if>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- footer here -->
<jsp:include page="/Layout/Footer.jsp" />