/**
 * 게시판 전용 js
 */
$(function() {
	// 게시판 특유 번호
	/**
	 * 자유게시판
	 * 1 -> insert
	 * 2 -> update 
	 * 3 -> delete 
	 * 4 -> Reply
	 */
	var boardPageCnt = parseInt($("#boardCnt").val());

	$("#boardRegBtn").click(function() {
		var email = $("#email").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var password = $("#password").val();

				var boardArr = [ email, title, content, password ];
				for (var i = 0; i < boardArr.length; i++) {
					if (boardArr[i] == "" || boardArr[i] == null) {
						alert("입력되지않은 폼이 있습니다.");
						return false;
					}
				}
				if (boardPageCnt == 1) {
					$("#WriteBoardFrm").prop("action","/board/WriteBoardinsert.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
				else if (boardPageCnt == 2) {
					$("#WriteBoardFrm").prop("action","/board/WriteBoardupdate.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
				else if (boardPageCnt == 4) {
					$("#WriteBoardFrm").prop("action","/board/WriteBoardreply.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
				
				/**
				 * QnA 게시판
				 * 5 - insert
				 * 6 - update
				 * 7 - delete
				 * 8 - reply
				 */
				else if (boardPageCnt == 5) {
					$("#WriteBoardFrm").prop("action","/board/Qboard/WriteQBoardinsert.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
				else if (boardPageCnt == 6) {
					$("#WriteBoardFrm").prop("action","/board/Qboard/WriteQBoardupdate.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
				else if (boardPageCnt == 8) {
					$("#WriteBoardFrm").prop("action","/board/Qboard/WriteQBoardreply.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
				
				/**
				 * 자유글 답변 게시판
				 * 9 - update
				 * 10 - delete
				 * 11 - reply(보류)
				 */
				else if (boardPageCnt == 9) {
					$("#WriteBoardFrm").prop("action","/board/Answerboard/free/WriteAnswerBoardupdate.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
				else if (boardPageCnt == 11) {
					$("#WriteBoardFrm").prop("action","/board/Qboard/WriteQBoardreply.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
				
				/**
				 * QnA글 답변 게시판
				 * 12 - update
				 * 13 - delete
				 * 14 - reply(보류)
				 */
				else if (boardPageCnt == 12) {
					$("#WriteBoardFrm").prop("action","/board/Answerboard/question/WriteQAnswerBoardupdate.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
				else if (boardPageCnt == 14) {
					$("#WriteBoardFrm").prop("action","/board/Qboard/WriteQBoardreply.board");
					$("#WriteBoardFrm").prop("method", "post");
				}
							
				document.WriteBoardFrm.submit();
			});

    			/**
				 * 공지사항 게시판
				 * 15 - insert
				 * 16 - update
				 * 17 - delete
				 */
			$("#NoticeBoardRegBtn").click(function(){
				
				if (boardPageCnt == 15) {
					var boardFrm = document.WriteBoardFrm;
					boardFrm.method="post";
					boardFrm.action="/board/Noticeboard/NoticeBoardinsert.board";
				}
				else if (boardPageCnt == 16) {
					var boardFrm = document.WriteBoardFrm;
					boardFrm.method="post";
					boardFrm.action="/board/Noticeboard/NoticeBoardupdate.board";
				}
			});


	// boardPageCnt = 3
	$("#boardDelBtn").click(function() {
		var password = $("#password").val();
		
		if (password != "" && password != null) {
			$("#WriteBoardFrm").prop("action","/board/WriteBoarddelete.board");
			$("#WriteBoardFrm").prop("method", "post");
			document.WriteBoardFrm.submit();
		}else{
			alert("암호를 입력해주세요.");
			$("#password").focus();
			return false;
		}
	});
    
	// boardPageCnt = 7
	$("#qboardDelBtn").click(function(){
    	var password = $("#password").val();
		if (password != "" && password != null) {
			$("#WriteBoardFrm").prop("action","/board/Qboard/WriteQBoarddelete.board");
			$("#WriteBoardFrm").prop("method", "post");
			document.WriteBoardFrm.submit();
		}else{
			alert("암호를 입력해주세요.");
			$("#password").focus();
			return false;
		}
    });

	// boardPageCnt = 10
	$("#AnswerboardDelBtn").click(function(){
    	var password = $("#password").val();
		if (password != "" && password != null) {
			$("#WriteBoardFrm").prop("action","/board/Answerboard/free/WriteAnswerBoarddelete.board");
			$("#WriteBoardFrm").prop("method", "post");
			document.WriteBoardFrm.submit();
		}else{
			alert("암호를 입력해주세요.");
			$("#password").focus();
			return false;
		}
    });
	
	// boardPageCnt = 13
	$("#qAnswerboardDelBtn").click(function(){
    	var password = $("#password").val();
		if (password != "" && password != null) {
			$("#WriteBoardFrm").prop("action","/board/Answerboard/question/WriteQAnswerBoarddelete.board");
			$("#WriteBoardFrm").prop("method", "post");
			document.WriteBoardFrm.submit();
		}else{
			alert("암호를 입력해주세요.");
			$("#password").focus();
			return false;
		}
    });


	// 공지게시글 삭제폼(boardPageCnt = 17)
	$("#NoticeboardDelBtn").click(function() {
		var boardCnt = $("#boardCnt").val();
		var flag = confirm("삭제하시겠습니까?");
		if(flag){
		  
		   $("#WriteBoardFrm").prop("action","/board/Noticeboard/NoticeBoarddelete.board?boardCnt=" + encodeURI(boardCnt));
		   $("#WriteBoardFrm").prop("method", "post");
           document.WriteBoardFrm.submit();
		
		}else{
			return false;
		}
		
	});
	// 게시판에 있는 버튼마다 기능 부여
	boardBtnEffect();

	// index에 보일 자유게시판
	indexFreeBoard();
});

/**
 * 자유게시판 데이터를 클라이언트에서 읽을 수 있도록하는 함수
 * @param boardCnt
 * @param boardWriter
 * @param boardlistTitle
 * @param boardContent
 * @param boardHit
 * @param boarddate
 * @returns
 */
function freeboard_Read(boardCnt,
					    boardWriter,
					    boardlistTitle,
						boardContent,
						boardHit,
						boardParam, 
						boardDate) {
	window.location.href = "/board/Readboard/ReadFreeBoard.board?" 
		    +"boardCnt=" + encodeURI(boardCnt)
			+ "&boardWriter=" + encodeURI(boardWriter)
			+ "&boardlistTitle=" + encodeURI(boardlistTitle) 
			+ "&boardContent=" + encodeURI(boardContent)
			+ "&boardHit=" + encodeURI(boardHit)
			+ "&boardParam=" + encodeURI(boardParam)
			+ "&boarddate=" + encodeURI(boardDate);
};

/**
 * QnA 게시글을 읽어오는 함수 
 *
 * @param boardCnt
 * @param boardWriter
 * @param boardlistTitle
 * @param boardContent
 * @param boardHit
 * @param boarddate
 * @returns
 */
function Questionboard_Read(boardCnt, 
		                    boardWriter, boardlistTitle,
		                    boardContent, boardHit,
		                    boardParam, boardDate) {
	
	if(boardContent.length <= 10){
		boardContent.trim();
	}
	
	window.location.href = "/board/Readboard/ReadQuestionBoard.board?" 
		    +"boardCnt=" + encodeURI(boardCnt)
			+ "&boardWriter=" + encodeURI(boardWriter)
			+ "&boardlistTitle=" + encodeURI(boardlistTitle) 
			+ "&boardContent=" + encodeURI(boardContent)
			+ "&boardHit=" + encodeURI(boardHit)
			+ "&boardParam=" + encodeURI(boardParam)
			+ "&boarddate=" + encodeURI(boardDate);
};

/**
 * 공지게시판 
 * @param boardCnt
 * @param boardlistTitle
 * @param boardContent
 * @param boardHit
 * @param boardParam
 * @param boardDate
 * @returns
 */function Noticeboard_Read(boardCnt, boardlistTitle,
		boardContent, boardHit, boardParam, boardDate) {
	
	if(boardContent.length <= 10){
		boardContent.trim();
	}
	var url="/board/Readboard/ReadNoticeBoard.board?" 
		    +"boardCnt=" + encodeURI(boardCnt)
			+ "&boardlistTitle=" + encodeURI(boardlistTitle) 
			+ "&boardContent=" + encodeURI(boardContent)
			+ "&boardHit=" + encodeURI(boardHit)
			+ "&boardParam=" + encodeURI(boardParam)
			+ "&boarddate=" + encodeURI(boardDate);
	
	window.open(url,"www.파워로고스.com","width=800,height=800,resizable=yes");
};
/**
* 답변 게시글을 읽어오는 함수
*/
function Answer_Read(boardCnt, boardWriter, boardlistTitle,
		boardContent, boardHit, boardParam, boardDate){
	
	var boardKind = $("#boardKind").val();
	
	if(boardContent.length <= 10){
		boardContent.trim();
	}
	
	// 자유게시판 일 경우
	if(boardKind == "freeboard"){
		
	window.location.href = "/Layout/Board/Answer/free/ReadAnswerFreeBoard.jsp?" 
		    +"boardCnt=" + encodeURI(boardCnt)
			+ "&boardWriter=" + encodeURI(boardWriter)
			+ "&boardlistTitle=" + encodeURI(boardlistTitle) 
			+ "&boardContent=" + encodeURI(boardContent)
			+ "&boardHit=" + encodeURI(boardHit)
			+ "&boardParam=" + encodeURI(boardParam);
			+ "&boarddate=" + encodeURI(boardDate);
	}
	
	// QnA게시판 일 경우
    else if(boardKind == "questionboard"){

	window.location.href = "/Layout/Board/Answer/question/ReadAnswerQuestionBoard.jsp?" 
		    +"boardCnt=" + encodeURI(boardCnt)
			+ "&boardWriter=" + encodeURI(boardWriter)
			+ "&boardlistTitle=" + encodeURI(boardlistTitle) 
			+ "&boardDate=" + encodeURI(boardDate) 
			+ "&boardContent=" + encodeURI(boardContent)
			+ "&boardHit=" + encodeURI(boardHit)
			+ "&boardParam=" + encodeURI(boardParam);	
			+ "&boarddate=" + encodeURI(boarddate);	
	}

};

/**
 * 게시판에 있는 버튼마다 기능 부여
 * 
 * @returns
 */
function boardBtnEffect(functionCnt) {
		
	//게시판 종류 판별 변수
	var boardKind = $("#boardKind").val();
	
	// 게시글이 존재 하지 않을 때 글쓰기 폼버튼
	$("#EmptyboardWriteBtn").click(function(){
	   //자유게시판
	   if(boardKind == "freeboard"){

		 window.location.href="/Layout/Board/WriteFreeBoard.jsp?boardParam="+encodeURI(functionCnt); 		
      
	    //공지사항
	   }else if(boardKind == "noticeboard"){
		 var url = "/Layout/Board/Notice/WriteNoticeBoard.jsp?boardParam="+encodeURI(functionCnt);
    	 window.open(url,"www.파워로고스.com","width=800,height=800, scrollbars=yes,resizable=yes");
	   }	
	});
	
	// 게시글이 존재할 때 글쓰기 폼버튼
	$("#boardWriteBtn").click(function(){
		
		var idx = parseInt($("#statusCount").val());
    
    	// 질문게시판일 경우
		if(boardKind == "questionboard"){
			window.location.href="/Layout/Board/QBoard/WriteQuestionBoard.jsp?boardParam=" + encodeURI(idx);
		}
		// 자유게시판일 경우
		else if(boardKind == "freeboard"){
			window.location.href="/Layout/Board/WriteFreeBoard.jsp?boardParam=" + encodeURI(idx);
	    }
   		//공지사항    
		else if(boardKind == "noticeboard"){
		 	var url = "/Layout/Board/Notice/WriteNoticeBoard.jsp?boardParam="+encodeURI(idx);
    	 	window.open(url,"www.파워로고스.com","width=800,height=800, scrollbars=yes,resizable=yes");
	   }	
		
	});
	
	// 자유게시판 목록폼
	$("#FreeBoardListBtn").click(function() {
		var idx = $("#boardHit").val();
	    //window.location.href="/board/FreeBoard.board";
		$("#WriteBoardFrm").prop("action","/board/FreeBoard.board");
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});

	// QnA게시판 목록폼
	$("#QuestionBoardListBtn").click(function() {
		var idx = $("#boardHit").val();
	    //window.location.href="/board/Qboard/QuestionBoard.board";
		$("#WriteBoardFrm").prop("action","/board/Qboard/QuestionBoard.board");
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});

	// 공지사항게시판 목록폼
	$("#NoticeBoardListBtn").click(function() {
		var idx = $("#boardHit").val();
	    //window.location.href="/board/Qboard/QuestionBoard.board";
		$("#WriteBoardFrm").prop("action","/board/Noticeboard/NoticeBoard.board");
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});

	// 자유게시판 수정폼
	$("#FreeboardReviseBtn").click(function() {
						var boardWriter = $("#boardWriter").val();
						var boardTitle = $("#boardTitle").val();
						var boardContent = $("#boardContent").val();
						var boardHit = $("#boardHit").val();
												
							$("#WriteBoardFrm").prop("action","/Layout/Board/RevisionFreeBoard.jsp?revWriter="			+ encodeURI(boardWriter)
								+ "&revTitle="
								+ encodeURI(boardTitle)
								+ "&revContent="
								+ encodeURI(boardContent)
								+ "&revHit="
								+ encodeURI(boardHit));
						
							$("#WriteBoardFrm").prop("method", "post");
							document.WriteBoardFrm.submit();						
	});

	// QnA게시판 수정폼
	$("#QuestionboardReviseBtn").click(function() {
						var boardWriter = $("#boardWriter").val();
						var boardTitle = $("#boardTitle").val();
						var boardContent = $("#boardContent").val();
						var boardHit = $("#boardHit").val();
								
								$("#WriteBoardFrm").prop("action","/Layout/Board/QBoard/RevisionQuestionBoard.jsp?revWriter="	
										+ encodeURI(boardWriter)
										+ "&revTitle="
										+ encodeURI(boardTitle)
										+ "&revContent="
										+ encodeURI(boardContent)
										+ "&revHit="
										+ encodeURI(boardHit));
								
									$("#WriteBoardFrm").prop("method", "post");
									document.WriteBoardFrm.submit();						
	});

	// 공지사항게시판 수정폼
	$("#NoticeboardReviseBtn").click(function() {
						var boardTitle = $("#boardTitle").val();
						var boardContent = $("#boardContent").val();
						var boardHit = $("#boardHit").val();
						var boardParam=$("#boardParam").val();	
						var boardCnt=$("#boardCnt").val();	
							
								$("#WriteBoardFrm").prop("action","/Layout/Board/Notice/RevisionNoticeBoard.jsp?revTitle="	
										+ encodeURI(boardTitle)
										+ "&revContent="
										+ encodeURI(boardContent)
										+ "&revHit="
										+ encodeURI(boardHit)
										+ "&revParam="
										+ encodeURI(boardParam)
										+ "&revCnt="
										+ encodeURI(boardCnt)
										);
								
									$("#WriteBoardFrm").prop("method", "post");
									document.WriteBoardFrm.submit();						
	});

	// 자유게시판 답변 수정폼
	$("#AnswerboardReviseBtn").click(function() {
						var boardWriter = $("#boardWriter").val();
						var boardTitle = $("#boardTitle").val();
						var boardContent = $("#boardContent").val();
						var boardHit = $("#boardHit").val();
								
								$("#WriteBoardFrm").prop("action","/Layout/Board/Answer/free/RevisionAnswerFreeBoard.jsp?revWriter="	
										+ encodeURI(boardWriter)
										+ "&revTitle="
										+ encodeURI(boardTitle)
										+ "&revContent="
										+ encodeURI(boardContent)
										+ "&revHit="
										+ encodeURI(boardHit));
								
									$("#WriteBoardFrm").prop("method", "post");
									document.WriteBoardFrm.submit();						
	});
	
	// QnA게시판 답변 수정폼
	$("#QuestionboardAnswerReviseBtn").click(function() {
						var boardWriter = $("#boardWriter").val();
						var boardTitle = $("#boardTitle").val();
						var boardContent = $("#boardContent").val();
						var boardHit = $("#boardHit").val();
								
								$("#WriteBoardFrm").prop("action","/Layout/Board/Answer/question/RevisionAnswerQuestionBoard.jsp?revWriter="	
										+ encodeURI(boardWriter)
										+ "&revTitle="
										+ encodeURI(boardTitle)
										+ "&revContent="
										+ encodeURI(boardContent)
										+ "&revHit="
										+ encodeURI(boardHit));
								
									$("#WriteBoardFrm").prop("method", "post");
									document.WriteBoardFrm.submit();						
	});
	
	// 자유게시판 삭제폼
	$("#FreeboardDelBtn").click(function() {
		$("#WriteBoardFrm").prop("action","/Layout/Board/DelFreeBoard.jsp");
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});

	// QnA게시판 삭제폼
	$("#QuestionboardDelBtn").click(function() {
		$("#WriteBoardFrm").prop("action","/Layout/Board/QBoard/DelQuestionBoard.jsp");
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});
	
	// 자유게시판 답변 삭제폼
	$("#AnswerboardDeleteBtn").click(function() {
		$("#WriteBoardFrm").prop("action","/Layout/Board/Answer/free/DelAnswerFreeBoard.jsp");
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});
	
	// QnA게시판 답변 삭제폼
	$("#QuestionboardAnswerDelBtn").click(function() {
		$("#WriteBoardFrm").prop("action","/Layout/Board/Answer/question/DelAnswerQuestionBoard.jsp");
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});
	
	// 자유게시판 게시글 답변폼
	$("#FreeboardAnswerBtn").click(function() {
		var boardAnswerParam = $("#boardAnswerParam").val();
		$("#WriteBoardFrm").prop("action","/Layout/Board/ReplyFreeBoard.jsp?boardParam="+ encodeURI(boardAnswerParam));
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});

	// QnA게시판 게시글 답변폼
	$("#QuestionboardAnswerBtn").click(function() {
		var qboardAnswerParam = $("#boardAnswerParam").val();
		$("#WriteBoardFrm").prop("action","/Layout/Board/QBoard/ReplyQuestionBoard.jsp?boardParam=" + encodeURI(qboardAnswerParam));
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});
	
	// 자유게시판 재 답변폼
	$("#AnswerboardAnswerBtn").click(function() {
		var qboardAnswerParam = $("#boardAnswerParam").val();
		$("#WriteBoardFrm").prop("action","/Layout/Board/Answer/free/ReplyAnswerFreeBoard.jsp?boardParam=" + encodeURI(qboardAnswerParam));
		$("#WriteBoardFrm").prop("method", "post");
        document.WriteBoardFrm.submit();
	});
	
	//공지 게시글 팝업 닫기
	$("#NoticeboardCloseBtn").click(function(){
		self.close();
	});
};

/**
 * 메인에 출력되는 자유게시판
 * 
 * @returns
 */
function indexFreeBoard() {
	$.ajax({
		url : "/Layout/Board/indexFreeBoard.jsp",
		type : "post",
		dataType : "html",
		success : function(freeboard) {
			$(".freeboard_here").html(freeboard);
		},
		error : function() {
			alert("자유게시판을 불러오지 못했습니다.");
		}
	});
};