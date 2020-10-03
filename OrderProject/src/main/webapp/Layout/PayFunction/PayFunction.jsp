<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 로그인 여부 -->
<jsp:include page="/Layout/LoginNeed/LoginNeed.jsp" />

<!-- Top -->
<jsp:include page="/Layout/Top.jsp" />

<!-- 로그인 삽입 -->
<div class="login_wrapper">
	<jsp:include page="/Layout/loginInput/login_input.jsp" />
</div>

<div class="pay_wrapper">
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
				<div class="pay_title_wrapper">
					<h3 class="pay_title">MemberShip</h3>
				</div>
				<div class="pay_board_wrapper table-responsive form-group">
					<p class="pay_word">추가결제를 하시게 되면 추가결제된 부분이 반영이 됩니다.</p>
					<p class="pay_word">무통장입금을 선택하신경우 입금까지 완료되어야 추가결제가 반영됩니다.</p>
					<p class="pay_word">정회원(새자료이용)과 부회원(과거자료이용)을 모두다 선택 하시면 스페셜 회원의
						자격이 부여 됩니다.</p>

					<form id="sermonFrm" name="sermonFrm" class="sermonFrm">
						
						<input type="hidden" name="member" value="${sessionScope.login}">
						
						<table class="table pay_table">
							<thead class="thead">
								<tr>
									<th colspan="2">금액선택</th>
								</tr>
							</thead>
							<tbody class="tbody">
								<tr>
									<td>최근 자료를 이용 하시 겠습니까.?(정회원)</td>
									<td><input type="checkbox" id="RegularUserbox">
									    <input type="text" class="payform form-control" value="170000" readonly="readonly" id="RegularUserVal" name="RegularUser">

									</td>
								</tr>
								<tr>
									<td>과거 자료를 이용 하시 겠습니까.?(부회원)</td>
									<td><input type="checkbox" id="unRegularUserbox">
									 <select class="payform form-control" id="unRegularUser" name="unRegularUser">
											<c:forEach begin="0" end="99" var="payValue">
												<option value="${payValue}">${payValue}</option>
											</c:forEach>
									</select></td>
								</tr>
							</tbody>
						</table>

						<div class="clearfix"></div>

						<table class="table pay_table">
							<thead class="thead">
								<tr>
									<th colspan="2">결제방법</th>
								</tr>
							</thead>
							<tbody class="tbody">
								<tr>
									<td>선택: 무통장입금/카드결제</td>
									<td><select class="pay_way" name="paySelector"
										 id="paySelector" class="form-control">
											<option value="무통장입금" id="unDeposit">무통장입금</option>
											<option value="카드결제" id="card">카드결제</option>
									</select></td>
								</tr>
							</tbody>
						</table>

						<div class="clearfix"></div>

                        <div class="position_change_wrapper">
						<table class="table pay_table">
							<thead class="thead">
								<tr>
									<th colspan="2">무통장입금</th>
								</tr>
							</thead>
							<tbody class="tbody">
								<tr>
									<td>입금은행</td>
									<td><select class="pay_way" name="saveUnpay"
										class="form-control">
											<option value="농협 193-12-236211(예금주: 유병춘)">농협
												193-12-236211(예금주: 유병춘)</option>
											<option value="국민 253402-04-014975(예금주: 유병춘)">국민
												253402-04-014975(예금주: 유병춘)</option>
											<option value="우체국 100529-02-166428(예금주: 유병춘)">우체국
												100529-02-166428(예금주: 유병춘)</option>
									</select></td>
								</tr>
							</tbody>
							<tfoot class="tfoot">
								<tr>
									<td colspan="2" align="right">
										<button id="paySubmit" class="btn btn-sm">결제</button>
										<button id="payCancel" class="btn btn-sm">취소</button>
									</td>
								</tr>
							</tfoot>
						</table>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</div>
<!-- Footer -->
<jsp:include page="/Layout/Footer.jsp" />