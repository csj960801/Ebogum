<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="login_warpper row">
	<div class="col-md-2 col-xs-3 login_md_2">
		<c:if test="${sessionScope.login == null}">
			<form name="form" class="loginFrm" onsubmit="javascript:return chk();">

				<table class="login_tbl">
					<tbody>
						<tr valign="top">
							<td height="5"></td>
							<td height="5"></td>
							<td height="5"></td>
						</tr>
						<tr>
							<td width="70" height="20" align="right"><img
								src="/pictures/login/login_id.gif" width="54" height="13"></td>
							<td width="6" height="20">&nbsp;</td>
							<td height="20"><input id="id" name="duplicateid"
								type="text" autocomplete="off" class="login_id"></td>
						</tr>
						<tr>
							<td height="2"></td>
							<td height="2"></td>
							<td height="2"></td>
						</tr>
						<tr>
							<td width="70" height="20" align="right"><img
								src="/pictures/login/login_pw.gif" width="55" height="13"></td>
							<td width="6" height="20">&nbsp;</td>
							<td height="20"><input id="pass" name="pass1"
								autocomplete="off" type="password" class="login_pw"></td>
						</tr>
						<tr>
							<td height="3"></td>
							<td height="4"></td>
							<td height="4"></td>
						</tr>
						<tr>
							<td height="19" align="right">&nbsp;</td>
							<td height="19">&nbsp;</td>
							<td height="19"><input type="image" id="login_enter"
								src="/pictures/login/login_enter.gif" width="76" height="19"></td>
						</tr>
						<tr>
							<td height="5"></td>
							<td height="5"></td>
							<td height="5"></td>
						</tr>
						<tr>
							<td width="70" height="17" align="right"><a
								href="/Layout/MemberReg/login_join.jsp" class="login_join">
									<img src="/pictures/login/login_join.gif" width="53"
									height="17" style="cursor: hand;">
							</a></td>
							<td width="6" height="17">&nbsp;</td>
							<td height="17"><a href="/Layout/FindInfo/FindInfo.jsp" class="login_lost"> <img
									src="/pictures/login/login_lost.gif" width="73" height="17"
									style="cursor: hand;">
							</a></td>
						</tr>
						<tr valign="bottom">
							<td colspan="3"><img src="/pictures/login/login_sun.gif"
								width="170" height="1"></td>
						</tr>

					</tbody>
				</table>
			</form>
		</c:if>
		<c:choose>
			<c:when test="${sessionScope.login != null }">
				<div class="login_success">
					<div class="login_success_wrapper">					
						<p class="login_success_id">
							<c:if test="${sessionScope.login == 'logos'}">
								 관리자
							</c:if>
							<c:choose>
								 <c:when test="${sessionScope.login != 'logos'}">
								 	${sessionScope.login}
								 </c:when>
							</c:choose>
						</p>
						<span class="point_span">POINT</span> ${sessionScope.point}
	
						<br>
	
						2020-08-31<span class="point_span_other">까지</span>
						<button id="logoutBtn" class="logoutBtn">로그아웃</button>
					</div>
				</div>
			</c:when>
		</c:choose>
	</div>

	<!-- main 게시판 컨텐츠  -->
	<div class="col-md-10 col-xs-9 login_md_10">
		<div id="main_carousel" class="carousel slide" data-ride="carousel">

			<!-- Wrapper for slides -->
			<div class="carousel-inner carousel_img_wrapper">
				<div class="item active"></div>
			</div>
		</div>
	</div>
</div>