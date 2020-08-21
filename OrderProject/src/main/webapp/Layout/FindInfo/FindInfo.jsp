<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Top -->
<jsp:include page="/Layout/Top.jsp" />

<!-- 로그인 삽입 -->
<div class="login_wrapper">
	<jsp:include page="/Layout/loginInput/login_input.jsp" />
</div>

<div class="custom_container">
	<div class="side_col col-md-3 col-xs-3">
		<ul class="side_menu_ul findinfo_menu_ul">
			<!-- 			<li class="emphasize"></li>
			<li><span class="arrow_span"></span>
			  <a href="#">&nbsp;</a>
			</li>
			<li><span class="arrow_span"></span>
			  <a href="#">&nbsp;</a>
			</li>
 -->
		</ul>
	</div>
	<div class="main_col col-md-9 col-xs-9">
		<div class="FindInfo_main_wrapper main_board_wrapper">
			<img src="/pictures/FindInfo/member_id_pw_find_title.gif"
				class="img-responsive freeBoard" />

			<div class="clearfix"></div>

			<div class="findinfo_table_wrapper table-responsive">
				<h5 class="findinfo_title">⊙ 이름과 Email을 입력해 주십시요.</h5>
				<form id="findinfoFrm" name="findinfoFrm" class="findinfoFrm">
					<div class="Findinfo_wrapper">
						<table class="table find_table">
							<tbody class="tbody">
								<tr class="Findinfo_tr">
									<th>이름</th>
									<td><input type="text" name="name" id="name" class="name"></td>
								</tr>
								<tr>
									<th>E-mail</th>
									<td><input type="email" name="email" id="email"
										class="email"></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="clearfix"></div>

					<div class="findinfo_btnWrapper">
						<button id="findinfoBtn">확인</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>

<!-- Footer -->
<jsp:include page="/Layout/Footer.jsp" />