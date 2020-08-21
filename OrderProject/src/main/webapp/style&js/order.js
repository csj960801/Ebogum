/**
 * 
 */
$(function() {

	// 중복확인 관련 함수
	duplicatedCheck();

	// 아이디 중복체크 관련 함수
	MemberReg();

	// 아이디 비번 참기 함수
	FindInfo();
});

function chk() {

	// **************************************************************************************
	// 아이디 체크부
	// **************************************************************************************
	var strid = eval("document.form.id");
	if (strid.value == "") {
		alert("아이디를 입력하세요");
		strid.focus();
		return false
	}

	for (i = 0; i < strid.value.length; i++) {
		var a = strid.value.charCodeAt(i);
		if (a > 128) {
			alert('아이디는 영문 또는 영문,숫자를 혼합하여 입력하세요');
			strid.value = "";
			strid.focus();
			return false;
		}
	}

	for (var i = 0; i < strid.value.length; i++) {
		var ch = strid.value.charAt(i);
		if (ch == " " || ch == "!" || ch == "@" || ch == "#" || ch == "$"
				|| ch == "%" || ch == "^" || ch == "&" || ch == "*"
				|| ch == "+" || ch == "=" || ch == "|" || ch == "~"
				|| ch == "`" || ch == "/" || ch == "?" || ch == ";"
				|| ch == ":" || ch == "'" || ch == "<" || ch == ">"
				|| ch == "," || ch == ".") {
			alert("아이디에 특수문자 또는 공백이 올수 없습니다.");
			strid.focus();
			return false;
		}
	}

	if (strid.value.length < 4) {
		alert("아이디를 4자이상 입력하세요");
		strid.focus();
		return false;
	}

	var strpass1 = eval("document.form.pass");
	if (strpass1.value == "") {
		alert("비밀번호를 입력하세요");
		strpass1.focus();
		return false
	}

	for (i = 0; i < strpass1.value.length; i++) {
		var a = strpass1.value.charCodeAt(i);
		if (a > 128) {
			alert('비밀번호는 영문 또는 영문,숫자를 혼합하여 입력하세요');
			strpass1.value = "";
			strpass1.focus();
			return false;
		}
	}

	if (strpass1.value == strid.value) {
		alert("비밀번호가 아이디와 같을 수 없습니다.");
		strpass1.value = "";
		strpass1.focus();
		return false
	}

	for (var i = 0; i < strpass1.value.length; i++) {
		var ch = strpass1.value.charAt(i);
		if (ch == " " || ch == "!" || ch == "@" || ch == "#" || ch == "$"
				|| ch == "%" || ch == "^" || ch == "&" || ch == "*"
				|| ch == "+" || ch == "=" || ch == "|" || ch == "~"
				|| ch == "`" || ch == "/" || ch == "?" || ch == ";"
				|| ch == ":" || ch == "'" || ch == "<" || ch == ">"
				|| ch == "," || ch == ".") {
			alert("비밀번호에 특수문자 또는 공백이 올수 없습니다.");
			strpass1.focus();
			return false;
		}
	}

	if (strpass1.value.length < 4) {
		alert("비밀번호를 4자이상 입력하세요");
		strpass1.focus();
		return false;
	}

	document.querySelector(".loginFrm").setAttribute("action", "/login.app");
	document.querySelector(".loginFrm").setAttribute("method", "post");

	return true;

};

/**
 * MemberReg.jsp 전용 함수
 * 
 * @returns
 */
function duplicatedCheck() {
	// 아이디 중복
	$("#duplicateBtn").click(
			function() {
				var duplicateId = $("#duplicateid").val();

				if (duplicateId.length <= 0) {
					alert("우선 아이디를 입력하세요.");
					$("#duplicateid").focus();
				} else {
					window.open("/DuplicateCheck/DuplicateCheck.app?id="
							+ encodeURI(duplicateId), "아이디중복검사",
							"width=500, height=350, resizable=yes");
				}
				return false;

			});
};

// 회원가입
function MemberReg() {
	$("#regBtn").click(
			function() {
				var id = $("#duplicateid").val();
				var pass1 = $("#pass1").val();
				var pass2 = $("#pass2").val();
				var name = $("#name").val();

				// 암호 특수문자 및 공백여부
				for (var i = 0; i < pass1.length; i++) {
					var passcheck = pass1.charAt(i);
					if (passcheck == "!" || passcheck == "@"
							|| passcheck == "#" || passcheck == "$"
							|| passcheck == "%" || passcheck == "^"
							|| passcheck == "&" || passcheck == "*"
							|| passcheck == "(" || passcheck == ")"
							|| passcheck == "") {

						alert("비밀번호에 특수문자 또는 공백이 올수 없습니다");
						$("#pass1").focus();
						return false;
					}
				}

				// 암호확인 특수문자 및 공백여부
				for (var i = 0; i < pass2.length; i++) {
					var passcheck2 = pass2.charAt(i);
					if (passcheck2 == "!" || passcheck2 == "@"
							|| passcheck2 == "#" || passcheck2 == "$"
							|| passcheck2 == "%" || passcheck2 == "^"
							|| passcheck2 == "&" || passcheck2 == "*"
							|| passcheck2 == "(" || passcheck2 == ")"
							|| passcheck2 == "") {

						alert("비밀번호에 특수문자 또는 공백이 올수 없습니다");
						$("#pass2").focus();
						return false;
					}
				}

				var birth = $("#birth").val();
				var post_address = $("#post_address").val();
				var address = $("#address").val();
				var church_name = $("#church_name").val();
				var email = $("#email").val();

				var home_tel = $("#home_tel").val();
				var church_tel = $("#church_tel").val();
				var phone_tel = $("#phone_tel").val();
				var fax_number = $("#fax_number").val();

				// 회원가입 데이터 저장 Array
				var regArr = [ id, pass1, pass2, name, birth, post_address,
						address, church_name, email, home_tel, church_tel,
						phone_tel, fax_number ];

				for (var i = 0; i < regArr.length; i++) {
					if (regArr[i] === null || regArr[i].length <= 0) {
						alert("입력되지않은 폼이 있습니다.");
						return false;
					}
				}// end of for

				$("#memberRegFrm").attr("method", "post");
				$("#memberRegFrm").attr("action", "/memberReg/memberReg.app");
				document.memberRegFrm.submit();
			});
};

/**
 * 아이디/비번 찾기 기능
 * 
 * @returns
 */
function FindInfo() {
	$("#findinfoBtn").click(function() {
		var name = $("#name").val();
		var email = $("#email").val()
		// var socialNum1 = $("#socialNum1").val();
		// var socialNum2 = $("#socialNum2").val();

		// 회원가입 데이터 저장 Array
		var findArr = [ name, email ];

		for (var i = 0; i < findArr.length; i++) {
			if (findArr[i] === null || findArr[i].length <= 0) {
				alert("입력되지않은 폼이 있습니다.");
				return false;
			}
		}// end of for

		$("#findinfoFrm").prop("action", "/findInfo/findInfo.app");
		$("#findinfoFrm").prop("method", "post");
		document.findinfoFrm.submit();
	});
};