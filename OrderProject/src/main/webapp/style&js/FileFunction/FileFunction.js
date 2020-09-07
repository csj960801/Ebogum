/**
 * 파일 업로드&다운로드 관련 js
 */
$(function() {

	// 해당하는 파일다운로드 페이지로 이동하는 기능
	var movePage = "";

	$("#file1, #sermonListBtn").click(function() {
		// #file1
		movePage = "SundaySermon.sermon"; // 주일 설교
		window.location.href = "/sermon/" + movePage;
		
		// #sermonListBtn
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file2").click(function() {
		movePage = "ganghae"; // 강해설교
	});
	$("#file3").click(function() {
		movePage = "person";// 인물설교
	});
	$("#file4").click(function() {
		movePage = "chulya";// 철야기도회 설교
	});
	$("#file5").click(function() {
		movePage = "symbang"; // 심방 설교
	});
	$("#file6").click(function() {
		movePage = "devote"; // 헌신예배 설교
	});
	$("#file7").click(function() {
		movePage = "special";// 각종특별설교
	});
	$("#file8").click(function() {
		movePage = "colmn"; // 칼럼형예화
	});

	// 새벽설교
	$("#file9").click(function() {
		movePage = "ganghaebyol"; // 강해별
	});
	$("#file10").click(function() {
		movePage = "occurency"; // 사건별
	});
	$("#file11").click(function() {
		movePage = "subject"; // 주제별
	});
	// /////////////////////////////////////

	// 절기 설교
	$("#file12").click(function() {
		movePage = "christmas"; // 성탄절
	});
	$("#file13").click(function() {
		movePage = "sasunjeol"; // 사순절
	});
	$("#file14").click(function() {
		movePage = "resurrect"; // 부활절
	});
	$("#file15").click(function() {
		movePage = "ganglim"; // 성림강림절
	});
	$("#file16").click(function() {
		movePage = "ganghae";
	});
	$("#file17").click(function() {
		movePage = "ganghae";
	});
	$("#file18").click(function() {
		movePage = "ganghae";
	});
	$("#file19").click(function() {
		movePage = "ganghae";
	});
	$("#file20").click(function() {
		movePage = "ganghae";
	});
	$("#file21").click(function() {
		movePage = "ganghae";
	});
	$("#file22").click(function() {
		movePage = "ganghae";
	});

	// 설교 페이지에서 사용되는 모든 버튼기능들을 관리하는 함수
	sermonBtnEffect();
});

/**
 * 설교 페이지 버튼 기능 담당(관리자 전용)
 * 
 * @returns
 */
function sermonBtnEffect() {
	// 설교 종류
	var SermonKind = $("#SermonKind").val();

	// 설교 데이터 작성 폼으로 이동
	$("#sermonWriteBtn").click(function() {
			if (SermonKind == "sunday") {
				SermonKind = "주일설교";
			}
			window.location.href = "/Layout/Sermon/Sunday/WriteSundaySermon.jsp?sermonkind="
			+ encodeURI(SermonKind);
	});
    
	// 설교 데이터 저장
	$("#WriteSermonBtn").click(function(){
		var sermonFrm = document.sermonFrm;
		sermonFrm.action = "/sermon/SundaySermonInsert.sermon";
	    sermonFrm.method = "post";
	    sermonFrm.submit();
	});

	// 설교 데이터 수정폼으로 이동
	$("#SermonReviseBtn").click(function(){
		var sermonFrm = document.sermonFrm;
		
		var revSubject = $("#revSubject").val();
		var revTitle = $("#revTitle").val();
		var revMain = $("#revMain").val();
		var revPage = $("#revPage").val();
		var revPoint = $("#revPoint").val();
		var revDate = $("#revDate").val();
		var revFileDown = $("#revFileDown").val();
		var revCnt = $("#revCnt").val();
				
		sermonFrm.action = "/Layout/Sermon/Sunday/UpdateSundaySermon.jsp?"
			+"revSubject="+encodeURI(revSubject)
			+"&revTitle="+encodeURI(revTitle)
			+"&revMain="+encodeURI(revMain)
			+"&revPage="+encodeURI(revPage)
			+"&revPoint="+encodeURI(revPoint)
			+"&revDate="+encodeURI(revDate)
			+"&revFileDown="+encodeURI(revFileDown)
			+"&revCnt="+encodeURI(revCnt);
			
	    sermonFrm.method = "post";
	    sermonFrm.submit();
	});

	// 설교 데이터 수정
	$("#ReviseSermonBtn").click(function(){
		var sermonFrm = document.sermonFrm;
		sermonFrm.action = "/sermon/SundaySermonUpdate.sermon";
	    sermonFrm.method = "post";
	    sermonFrm.submit();
	});
	
	// 설교 데이터 삭제
	$("#SermonDelBtn").click(function(){
		var sermonFrm = document.sermonFrm;
		var delSermon = confirm("정말삭제하시겠습니까?");
		if(delSermon){
			//var sermonCnt = $("#revCnt").val();
			sermonFrm.action = "/sermon/SundaySermonDelete.sermon";
		    sermonFrm.method = "post";
		    sermonFrm.submit();
			
		}else{
			return false;
		}
	});
	
	// 설교 데이터 검색
	$("#sermonsearchBtn").click(function(){
		var sermonSearchFrm = document.sermonSearchFrm;
		var sermonData = $("#sermonSearchParam").val();
	    if(sermonData.length <= 0){
	    	alert("검색어를 입력해주세요.");
	    	$("#sermonSearchParam").focus();
	    	return false;
	    }
	    sermonSearchFrm.action = "/sermon/SundaySermon.sermon";
	    sermonSearchFrm.method = "post";
	    sermonSearchFrm.submit();
	    
	});
};

/**
 * 해당 설교 데이터 읽는 함수
 * @param sermonSubject
 * @param sermonMain
 * @param sermonTitle
 * @param sermonPage
 * @param sermonDate
 * @param sermonPoint
 * @param downloadData
 * @returns
 */
function Sermon_read(
		sermonSubject,
		sermonMain,
		sermonTitle,
		sermonPage,
		sermonDate,
		sermonPoint,
		downloadData,
		dataCnt){
	
	// 설교 구분
	var sermonType = $("#SermonKind").val();
	switch(sermonType){
	case "sunday":
		sermonType = "주일설교";
		break;
	}
	
	window.location.href="/Layout/Sermon/Sunday/ReadSundaySermon.jsp?"+
	"sermonType="+encodeURI(sermonType)
	+"&sermonSubject="+encodeURI(sermonSubject)
	+"&sermonMain="+encodeURI(sermonMain)
	+"&sermonTitle="+encodeURI(sermonTitle)
	+"&sermonPage="+encodeURI(sermonPage)
	+"&sermonDate="+encodeURI(sermonDate)
	+"&sermonPoint="+encodeURI(sermonPoint)
	+"&sermonFileDown="+encodeURI(downloadData)
	+"&sermonCnt="+encodeURI(dataCnt);
};

/**
 * 파일 다운로드
 * @param fileName
 * @returns
 */
function Filedownload(filename){
	var downloadFile = document.sermonFrm;
	downloadFile.method="post";
	downloadFile.action="/sermon/SermonFiledownload.sermon?fileName=" + encodeURI(filename);
	downloadFile.submit();
};