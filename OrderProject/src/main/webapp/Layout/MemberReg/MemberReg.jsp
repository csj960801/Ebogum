<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.login != null}">
	<script type="text/javascript">
		alert("이미 로그인 성공하였습니다.");
		window.location.href = "/";
	</script>
</c:if>

<!-- Top -->
<jsp:include page="/Layout/Top.jsp" />

<!-- 로그인 삽입 -->
<div class="login_wrapper">
	<jsp:include page="/Layout/loginInput/login_input.jsp" />
</div>

<div class="custom_container">
	<div class="side_col col-md-3">&nbsp;</div>
	<div class="main_col col-md-9">
		<div class="Member_RegWrapper">
			<img src="/pictures/memberReg/member_register_title.gif"
				class="memberReg" />

			<div class="clearfix"></div>

			<div class="login_info">

				<form class="memberRegFrm" id="memberRegFrm" name="memberRegFrm">
					<h5 class="login_info_title">⊙로그인정보</h5>
					<div class="login_info_form_wrapper">
						<div class="login_info_form">
							<table class="login_info_form_tbl">
								<tbody class="login_info_form_tbl_tbody">
									<tr>
										<th>아이디</th>
										<td>
										    <input name="duplicateid" id="duplicateid" type="text" class="field" size="15" maxlength="15">
											<button id="duplicateBtn" class="duplicateBtn">중복확인</button>
											<span class="duplicate_span">아이디 중복을 확인 하세요.</span>
										</td>
									</tr>
									<tr>
										<th>비밀번호</th>
										<td><input name="pass1" id="pass1" type="password"
											class="field" value="" size="15" maxlength="15"></td>
									</tr>
									<tr>
										<th>비밀번호 확인</th>
										<td><input name="pass2" id="pass2" type="password"
											class="field" value="" size="15" maxlength="15"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

					<div class="clearfix"></div>
					<h5 class="login_info_title">⊙신상정보</h5>
					<div class="login_info_form_wrapper">
						<div class="login_info_form">
							<table class="login_info_form_tbl">
								<tbody class="login_info_form_tbl_tbody">
									<tr>
										<th>이름</th>
										<td><input name="name" id="name" type="text"
											class="field"></td>
									</tr>
									<tr>
										<th>생년월일</th>
										<td><input name="birth" id="birth" type="text"
											class="field" value="" size="15" maxlength="15" /> (ex:
											570220)</td>
									</tr>
									<tr>
										<th>목회자 구분</th>
										<td><select class="field" id="man_type" name="manType">
												<option value="목사">목사</option>
												<option value="강도사">강도사</option>
												<option value="전도사">전도사</option>
												<option value="심방전도사">심방전도사</option>
												<option value="교육전도사">교육전도사</option>
												<option value="기타">기타</option>
										</select></td>
									</tr>
									<tr>
										<th>우편번호</th>
										<td>
										  <input name="postAddress" id="post_address" type="text" class="field" value="" size="15">
										  <span class="post_span">-</span>
										  <input name="postAddress" id="post_address" type="text" class="field" value="" size="15">
										</td>
									</tr>
									<tr>
										<th rowspan="2">주소</th>
										<td><input name="address" id="address" type="text"
											class="field" value="" size="50"></td>
									</tr>
									<tr>
										<td><input name="address" id="address" type="text"
											class="field" value="" size="50"></td>
									</tr>
									<tr>
										<th>교회명</th>
										<td><input name="churchName" id="church_name" type="text"
											class="field" value="" size="15" maxlength="15"></td>
									</tr>
									<tr>
										<th>이메일</th>
										<td><input name="email" id="email" type="email"
											class="field" value="" maxlength="25"></td>
									</tr>
									<tr>
										<th>자택 전화번호</th>
										<td><input name="homeTel" id="home_tel" type="tel"
											class="field" value="" size="15" maxlength="15"></td>
									</tr>
									<tr>
										<th>교회 전화번호</th>
										<td><input name="churchTel" id="church_tel" type="tel"
											class="field" value="" size="15" maxlength="15"></td>
									</tr>
									<tr>
										<th>핸드폰</th>
										<td><input name="phoneTel" id="phone_tel" type="tel"
											class="field" value="" size="15" maxlength="15"></td>
									</tr>
									<tr>
										<th>팩스번호</th>
										<td><input name="faxNumber" id="fax_number" type="tel"
											class="field" value="" size="15" maxlength="15"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="btn_wrapper">
			<button id="regBtn" class="submitBtn">확인</button>
		</div>

	</div>

</div>

<!-- footer Here -->
<jsp:include page="/Layout/Footer.jsp" />