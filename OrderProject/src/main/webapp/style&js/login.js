/**
 * 로그인 전용 js
 */
$(function() {
	login_join_Chk();
});

/**
 * login_join.jsp 이용약관동의 체크여부
 * 
 * @returns
 */
function login_join_Chk() {
	/**
	 * 이용약관 동의
	 * 
	 * @returns
	 */
	$("#submitBtn").click(function() {
		var agreeY = document.getElementById("agree_y").checked;
		var agreeN = document.getElementById("agree_n").checked;

		if (agreeY) {
			window.location.href = "/Layout/MemberReg/MemberReg.jsp";
		} else if (agreeN) {
			alert("약관에 [동의]하셔야 회원가입 하실 수 있습니다.");
			return false;
		}
	});

	$("#logoutBtn").click(function() {
		window.location.href = "/logout.app";
	});

	/**
	 * 로그인
	 * 
	 * @returns
	 * 
	 * $("#login_enter").click(function() { var loginid = $("#id").val(); var
	 * loginpw = $("#pass").val();
	 * 
	 * if (loginid.length <= 0 || loginpw.length <= 0) { alert("아이디와 비밀번호를
	 * 확인해주세요"); return false; } $(".loginFrm").prop("method", "post");
	 * $(".loginFrm").prop("action", "/login/login.app");
	 * document.form.submit(); });
	 */
};