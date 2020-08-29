/**
 * 관리자 전용
 */
$(function(){
	
	//관리자 회원관리 기능 페이지
	$(".menu-option #toAdmin, #memberManageBtn").click(function(){
		window.location.href="/Admin/Admin.app";
	});
	
	//관리자 회원삭제 기능 페이지
	$("#memberDelBtn").click(function(){
		$("#adminFrm").prop("action","/Admin/delete/AdminDelete.app");
		$("#adminFrm").prop("method","post");
		document.adminFrm.submit();
	});
	/*$("#adminDeleteBtn").click(function(){
	  	$("#adminFrm").prop("action","/Admin/delete/AdminDeleteActivate.app");
	  	$("#adminFrm").prop("method","post");
        document.adminFrm.submit(); 
	});*/

	AdminBtnAction();
	
});

/**
 * 관리자 전용 버튼마다의 액션 담당
 * @returns
 */
function AdminBtnAction(){
	
	//관리자 페이지 번호 
	/**
	 * 1 - 회원관리
	 * 2 - 회원삭제
	 * 3 - 
	 */
	var AdminPageCnt = parseInt($("#adminPageCnt").val());
	
	$("#manager_SearchbyId_btn").click(function(){
		var adminSearchId = $("#adminSearchId").val();
		if(adminSearchId == "" || adminSearchId.length <= 0){
			alert("찾으실 아이디를 입력해주세요.");
			$("#adminSearchId").focus();
			return false;
		}
		if(AdminPageCnt == 1){
			$("#adminFrm").prop("action","/Admin/Admin.app");
			$("#adminFrm").prop("method","post");
		}
		else if(AdminPageCnt == 2){
			$("#adminFrm").prop("action","/Admin/delete/AdminDelete.app");
			$("#adminFrm").prop("method","post");
		}
	    document.adminFrm.submit();
	});
	
	$("#manager_SearchbyName_btn").click(function(){
		var adminSearchName = $("#adminSearchName").val();
		if(adminSearchName == "" || adminSearchName.length <= 0){
			alert("찾으실 이름를 입력해주세요.");
			$("#adminSearchName").focus();
		    return false;
		}
	
		if(AdminPageCnt == 1){
			$("#adminFrm").prop("action","/Admin/Admin.app");
			$("#adminFrm").prop("method","post");
		}
		else if(AdminPageCnt == 2){
			$("#adminFrm").prop("action","/Admin/delete/AdminDelete.app");
			$("#adminFrm").prop("method","post");
		}
	    document.adminFrm.submit();
	});
	
	$("#manager_SearchbyAddr_btn").click(function(){
		var adminSearchAddr = $("#adminSearchAddr").val();
		if(adminSearchAddr == "" || adminSearchAddr.length <= 0){
			alert("찾으실 이름를 입력해주세요.");
			$("#adminSearchAddr").focus();
		    return false;
		}
	
		if(AdminPageCnt == 1){
			$("#adminFrm").prop("action","/Admin/Admin.app");
			$("#adminFrm").prop("method","post");
		}
		
	    document.adminFrm.submit();
	});
	
};

function DelMember(duplicateid, pass, name){
	 // var duplicateid = $("#duplicateid").val();	
     // var pass = $("#pass1").val();	  
	 // var name = $("#name").val();	  
	
	  window.location.href = "/Admin/delete/AdminDeleteActivate.app?duplicateid="+encodeURI(duplicateid)
      +"&pass1="+encodeURI(pass)
	  +"&name="+encodeURI(name)
	
}