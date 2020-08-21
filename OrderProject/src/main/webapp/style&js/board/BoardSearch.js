/**
 * 게시판 검색 전용
 */
$(function(){
	
	var boardKind = $("#boardKind").val();
	
	// 자유게시판
	if(boardKind == "freeboard"){
	
	$("#searchBtn").click(function(){
		var searchParam = $("#boardSearchParam").val();
		if(searchParam == "" || searchParam == null){
			alert("검색어가 입력되지않았습니다.");
			$("#boardSearchParam").focus();
			return false;
		}
		$("#boardSearchFrm").prop("action","/board/FreeBoard.board");
		$("#boardSearchFrm").prop("method","post");	
	});
	
	$("#searchListBtn").click(function(){
		$("#boardSearchFrm").prop("action","/board/FreeBoard.board");
		$("#boardSearchFrm").prop("method","post");	
	});
	
	}
	
	// QnA게시판
	else{
	$("#searchBtn").click(function(){
		var searchParam = $("#boardSearchParam").val();
		if(searchParam == "" || searchParam == null){
			alert("검색어가 입력되지않았습니다.");
			$("#boardSearchParam").focus();
			return false;
		}
		$("#boardSearchFrm").prop("action","/board/Qboard/QuestionBoard.board");
		$("#boardSearchFrm").prop("method","post");	
	});
	
	$("#searchListBtn").click(function(){
		$("#boardSearchFrm").prop("action","/board/Qboard/QuestionBoard.board");
		$("#boardSearchFrm").prop("method","post");	
	});
	}
});