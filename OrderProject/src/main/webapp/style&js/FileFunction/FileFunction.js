/**
 * 파일 업로드&다운로드 관련 js
 */
$(function() {

	// 해당하는 파일다운로드 페이지로 이동하는 기능
	var movePage = "";

	$("#file1, #sermonListBtn").click(function() {
		movePage = "Sunday/SundaySermon.sermon"; // 주일 설교
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file2, #sermonListBtn").click(function() {
		movePage = "Ganghae/GanghaeSermon.sermon"; // 강해설교
	    document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file3, #sermonListBtn").click(function() {
		movePage = "Person/PersonSermon.sermon";// 인물설교
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file4, #sermonListBtn").click(function() {
		movePage = "Chulya/ChulyaSermon.sermon";// 철야기도회 설교
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file5, #sermonListBtn").click(function() {
		movePage = "Simbang/SimbangSermon.sermon"; // 심방 설교
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file6, #sermonListBtn").click(function() {
		movePage = "Hunshin/HunshinSermon.sermon"; // 헌신예배 설교
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file7, #sermonListBtn").click(function() {
		movePage = "Special/SpecialSermon.sermon";// 각종특별설교
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file8, #sermonListBtn").click(function() {
		movePage = "Column/ColumnSermon.sermon"; // 칼럼형예화
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});

	// 새벽설교
	$("#file9, #sermonListBtn").click(function() {
		movePage = "Dawn/Ganghaebyol/GanghaebyolSermon.sermon"; // 강해별
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file10, #sermonListBtn").click(function() {
		movePage = "Dawn/Sagunbyol/SagunbyolSermon.sermon"; // 사건별
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	$("#file11, #sermonListBtn").click(function() {
		movePage = "Dawn/Jujebyol/JujebyolSermon.sermon"; // 주제별
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
	});
	// /////////////////////////////////////

	// 절기 설교
	$("#file12, #sermonListBtn").click(function() {
		movePage = "Julgi/JulgiSermon.sermon";
		document.sermonFrm.action="/sermon/" + movePage;
		document.sermonFrm.submit();
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
				window.location.href = "/Layout/Sermon/Sunday/WriteSundaySermon.jsp?sermonkind="
			    + encodeURI(SermonKind);

			}else if(SermonKind == "ganghae"){
				
				SermonKind = "강해설교";
				window.location.href = "/Layout/Sermon/Ganghae/WriteGanghaeSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			
			}else if(SermonKind == "person"){
				
				SermonKind = "인물설교";
				window.location.href = "/Layout/Sermon/Person/WritePersonSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			
			}else if(SermonKind == "chulya"){
				
				SermonKind = "철야기도회 설교";
				window.location.href = "/Layout/Sermon/Chulya/WriteChulyaSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			
			}
			else if(SermonKind == "simbang"){
				
				SermonKind = "심방설교";
				window.location.href = "/Layout/Sermon/Simbang/WriteSimbangSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			
			}
			else if(SermonKind == "hunshin"){
				
				SermonKind = "헌신설교";
				window.location.href = "/Layout/Sermon/Hunshin/WriteHunshinSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			
			}
			else if(SermonKind == "special"){
				
				SermonKind = "특별설교";
				window.location.href = "/Layout/Sermon/Special/WriteSpecialSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			
			}
			else if(SermonKind == "column"){
				
				SermonKind = "컬럼형예화";
				window.location.href = "/Layout/Sermon/Column/WriteColumnSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			}
			
			//새벽 설교
			else if(SermonKind == "ganghaebyol"){
				
				SermonKind = "새벽설교강해별";
				window.location.href = "/Layout/Sermon/Dawn/Ganghaebyol/WriteGanghaebyolSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			}
			else if(SermonKind == "sagunbyol"){
				
				SermonKind = "새벽설교사건별";
				window.location.href = "/Layout/Sermon/Dawn/Sagunbyol/WriteSagunbyolSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			}
			else if(SermonKind == "jujebyol"){
				
				SermonKind = "새벽설교주제별";
				window.location.href = "/Layout/Sermon/Dawn/Jujebyol/WriteJujebyolSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			}
			else if(SermonKind == "julgi"){
				
				SermonKind = "절기설교";
				window.location.href = "/Layout/Sermon/Julgi/WriteJulgiSermon.jsp?sermonkind="
			    + encodeURI(SermonKind);
			}
			
	});
    
	// 설교 데이터 저장
	$("#WriteSermonBtn").click(function(){
		var sermonFrm = document.sermonFrm;
		
		if(SermonKind == "sunday"){
			sermonFrm.action = "/sermon/Sunday/SundaySermonInsert.sermon";
		}	    
		if(SermonKind == "ganghae"){
			sermonFrm.action = "/sermon/Ganghae/GanghaeSermonInsert.sermon";
		}
		if(SermonKind == "person"){
			sermonFrm.action = "/sermon/Person/PersonSermonInsert.sermon";
		}	
		if(SermonKind == "chulya"){
			sermonFrm.action = "/sermon/Chulya/ChulyaSermonInsert.sermon";
		}	
		if(SermonKind == "simbang"){
			sermonFrm.action = "/sermon/Simbang/SimbangSermonInsert.sermon";
		}	
		if(SermonKind == "hunshin"){
			sermonFrm.action = "/sermon/Hunshin/HunshinSermonInsert.sermon";
		}	
		if(SermonKind == "special"){
			sermonFrm.action = "/sermon/Special/SpecialSermonInsert.sermon";
		}	
		if(SermonKind == "column"){
			sermonFrm.action = "/sermon/Column/ColumnSermonInsert.sermon";
		}
		if(SermonKind == "ganghaebyol"){
			sermonFrm.action = "/sermon/Dawn/Ganghaebyol/GanghaebyolSermonInsert.sermon";
		}
		if(SermonKind == "sagunbyol"){
			sermonFrm.action = "/sermon/Dawn/Sagunbyol/SagunbyolSermonInsert.sermon";
		}
		if(SermonKind == "jujebyol"){
			sermonFrm.action = "/sermon/Dawn/Jujebyol/JujebyolSermonInsert.sermon";
		}
		if(SermonKind == "julgi"){
			sermonFrm.action = "/sermon/Julgi/JulgiSermonInsert.sermon";
		}
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
				
		if(SermonKind == "sunday"){		
			sermonFrm.action = "/Layout/Sermon/Sunday/UpdateSundaySermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}	
		if(SermonKind == "ganghae"){		
			sermonFrm.action = "/Layout/Sermon/Ganghae/UpdateGanghaeSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
		if(SermonKind == "person"){		
			sermonFrm.action = "/Layout/Sermon/Person/UpdatePersonSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
		if(SermonKind == "chulya"){		
			sermonFrm.action = "/Layout/Sermon/Chulya/UpdateChulyaSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}		
	  	if(SermonKind == "simbang"){		
			sermonFrm.action = "/Layout/Sermon/Simbang/UpdateSimbangSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
	  	if(SermonKind == "hunshin"){		
			sermonFrm.action = "/Layout/Sermon/Hunshin/UpdateHunshinSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
		if(SermonKind == "special"){		
			sermonFrm.action = "/Layout/Sermon/Special/UpdateSpecialSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
		if(SermonKind == "column"){		
			sermonFrm.action = "/Layout/Sermon/Column/UpdateColumnSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
		if(SermonKind == "ganghaebyol"){		
			sermonFrm.action = "/Layout/Sermon/Dawn/Ganghaebyol/UpdateGanghaebyolSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
		if(SermonKind == "sagunbyol"){		
			sermonFrm.action = "/Layout/Sermon/Dawn/Sagunbyol/UpdateSagunbyolSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
		if(SermonKind == "jujebyol"){		
			sermonFrm.action = "/Layout/Sermon/Dawn/Jujebyol/UpdateJujebyolSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
		if(SermonKind == "julgi"){		
			sermonFrm.action = "/Layout/Sermon/Julgi/UpdateJulgiSermon.jsp?"
				+"revSubject="+encodeURI(revSubject)
				+"&revTitle="+encodeURI(revTitle)
				+"&revMain="+encodeURI(revMain)
				+"&revPage="+encodeURI(revPage)
				+"&revPoint="+encodeURI(revPoint)
				+"&revDate="+encodeURI(revDate)
				+"&revFileDown="+encodeURI(revFileDown)
				+"&revCnt="+encodeURI(revCnt);
		}
	    sermonFrm.method = "post";
	    sermonFrm.submit();
	});

	// 설교 데이터 수정
	$("#ReviseSermonBtn").click(function(){
		var sermonFrm = document.sermonFrm;
		if (SermonKind == "sunday") {
			sermonFrm.action = "/sermon/Sunday/SundaySermonUpdate.sermon";
		}
		else if (SermonKind == "ganghae") {
	   		sermonFrm.action = "/sermon/Ganghae/GanghaeSermonUpdate.sermon";
		}
		else if (SermonKind == "person") {
	   		sermonFrm.action = "/sermon/Person/PersonSermonUpdate.sermon";
		}
		else if (SermonKind == "chulya") {
	   		sermonFrm.action = "/sermon/Chulya/ChulyaSermonUpdate.sermon";
		}
		else if (SermonKind == "simbang") {
	   		sermonFrm.action = "/sermon/Simbang/SimbangSermonUpdate.sermon";
		}	
		else if (SermonKind == "hunshin") {
	   		sermonFrm.action = "/sermon/Hunshin/HunshinSermonUpdate.sermon";
		}
		else if (SermonKind == "special") {
	   		sermonFrm.action = "/sermon/Special/SpecialSermonUpdate.sermon";
		}
		else if (SermonKind == "column") {
	   		sermonFrm.action = "/sermon/Column/ColumnSermonUpdate.sermon";
		}
		else if (SermonKind == "ganghaebyol") {
	   		sermonFrm.action = "/sermon/Dawn/Ganghaebyol/GanghaebyolSermonUpdate.sermon";
		}
		else if (SermonKind == "sagunbyol") {
	   		sermonFrm.action = "/sermon/Dawn/Sagunbyol/SagunbyolSermonUpdate.sermon";
		}
		else if (SermonKind == "jujebyol") {
	   		sermonFrm.action = "/sermon/Dawn/Jujebyol/JujebyolSermonUpdate.sermon";
		}
		else if (SermonKind == "julgi") {
	   		sermonFrm.action = "/sermon/Julgi/JulgiSermonUpdate.sermon";
		}
		sermonFrm.method = "post";
	    sermonFrm.submit();
	});
	
	// 설교 데이터 삭제
	$("#SermonDelBtn").click(function(){
		var sermonFrm = document.sermonFrm;
		var delSermon = confirm("정말삭제하시겠습니까?");
		if(delSermon){
			if (SermonKind == "sunday") {
			 	sermonFrm.action = "/sermon/Sunday/SundaySermonDelete.sermon";
			}
			else if (SermonKind == "ganghae") {
	   			sermonFrm.action = "/sermon/Ganghae/GanghaeSermonDelete.sermon";
			}
			else if (SermonKind == "person") {
	   			sermonFrm.action = "/sermon/Person/PersonSermonDelete.sermon";
			}
			else if (SermonKind == "chulya") {
	   			sermonFrm.action = "/sermon/Chulya/ChulyaSermonDelete.sermon";
			}
			else if (SermonKind == "simbang") {
	   			sermonFrm.action = "/sermon/Simbang/SimbangSermonDelete.sermon";
			}
			else if (SermonKind == "hunshin") {
	   			sermonFrm.action = "/sermon/Hunshin/HunshinSermonDelete.sermon";
			}
			else if (SermonKind == "special") {
	   			sermonFrm.action = "/sermon/Special/SpecialSermonDelete.sermon";
			}
			else if (SermonKind == "column") {
	   			sermonFrm.action = "/sermon/Column/ColumnSermonDelete.sermon";
			}
			else if (SermonKind == "ganghaebyol") {
	   			sermonFrm.action = "/sermon/Dawn/Ganghaebyol/GanghaebyolSermonDelete.sermon";
			}
			else if (SermonKind == "sagunbyol") {
	   			sermonFrm.action = "/sermon/Dawn/Sagunbyol/SagunbyolSermonDelete.sermon";
			}
			else if (SermonKind == "jujebyol") {
	   			sermonFrm.action = "/sermon/Dawn/Jujebyol/JujebyolSermonDelete.sermon";
			}
			else if (SermonKind == "julgi") {
	   			sermonFrm.action = "/sermon/Julgi/JulgiSermonDelete.sermon";
			}

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
	    /*if(sermonData.length <= 0){
	    	alert("검색어를 입력해주세요.");
	    	$("#sermonSearchParam").focus();
	    	return false;
	    }*/
		
		if(SermonKind == "sunday"){	
	    	sermonSearchFrm.action = "/sermon/Sunday/SundaySermon.sermon";
 	    }
        else if(SermonKind == "ganghae"){
			sermonSearchFrm.action = "/sermon/Ganghae/GanghaeSermon.sermon";
		}
        else if(SermonKind == "person"){
			sermonSearchFrm.action = "/sermon/Person/PersonSermon.sermon";					
		}
		else if(SermonKind == "chulya"){
			sermonSearchFrm.action = "/sermon/Chulya/ChulyaSermon.sermon";					
		}
		else if(SermonKind == "simbang"){
			sermonSearchFrm.action = "/sermon/Simbang/SimbangSermon.sermon";					
		}
		else if(SermonKind == "hunshin"){
			sermonSearchFrm.action = "/sermon/Hunshin/HunshinSermon.sermon";					
		}
		else if(SermonKind == "special"){
			sermonSearchFrm.action = "/sermon/Special/SpecialSermon.sermon";					
		}
		else if(SermonKind == "column"){
			sermonSearchFrm.action = "/sermon/Column/ColumnSermon.sermon";					
		}	
		else if(SermonKind == "ganghaebyol"){
			sermonSearchFrm.action = "/sermon/Dawn/Ganghaebyol/GanghaebyolSermon.sermon";					
		}
		else if(SermonKind == "sagunbyol"){
			sermonSearchFrm.action = "/sermon/Dawn/Sagunbyol/SagunbyolSermon.sermon";					
		}
		else if(SermonKind == "jujebyol"){
			sermonSearchFrm.action = "/sermon/Dawn/Jujebyol/JujebyolSermon.sermon";					
		}
		else if(SermonKind == "julgi"){
			sermonSearchFrm.action = "/sermon/Julgi/JulgiSermon.sermon";					
		}
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
	
	// 설교 종료 구분
	var sermonType = $("#SermonKind").val();
	switch(sermonType){
	case "sunday":
		sermonType = "주일설교";
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
		break;
	case "ganghae":
		sermonType = "강해설교";
		window.location.href="/Layout/Sermon/Ganghae/ReadGanghaeSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;		
	case "person":
		sermonType = "인물설교";
		window.location.href="/Layout/Sermon/Person/ReadPersonSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;		
	case "chulya":
		sermonType = "철야기도회 설교";
		window.location.href="/Layout/Sermon/Chulya/ReadChulyaSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;	
	case "simbang":
		sermonType = "심방설교";
		window.location.href="/Layout/Sermon/Simbang/ReadSimbangSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;
	case "hunshin":
		sermonType = "헌신설교";
		window.location.href="/Layout/Sermon/Hunshin/ReadHunshinSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;	
	case "special":
		sermonType = "각종틀별설교";
		window.location.href="/Layout/Sermon/Special/ReadSpecialSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;	
	case "column":
		sermonType = "컬럼형예화";
		window.location.href="/Layout/Sermon/Column/ReadColumnSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;	
	case "ganghaebyol":
		sermonType = "새벽설교강해별";
		window.location.href="/Layout/Sermon/Dawn/Ganghaebyol/ReadGanghaebyolSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;	
    case "sagunbyol":
		sermonType = "새벽설교사건별";
		window.location.href="/Layout/Sermon/Dawn/Sagunbyol/ReadSagunbyolSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;	
	case "jujebyol":
		sermonType = "새벽설교주제별";
		window.location.href="/Layout/Sermon/Dawn/Jujebyol/ReadJujebyolSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;
	case "julgi":
		sermonType = "절기설교";
		window.location.href="/Layout/Sermon/Julgi/ReadJulgiSermon.jsp?"+
		"sermonType="+encodeURI(sermonType)
		+"&sermonSubject="+encodeURI(sermonSubject)
		+"&sermonMain="+encodeURI(sermonMain)
		+"&sermonTitle="+encodeURI(sermonTitle)
		+"&sermonPage="+encodeURI(sermonPage)
		+"&sermonDate="+encodeURI(sermonDate)
		+"&sermonPoint="+encodeURI(sermonPoint)
		+"&sermonFileDown="+encodeURI(downloadData)
		+"&sermonCnt="+encodeURI(dataCnt);
		break;		
	}//end of switch
	
};

/**
 * 파일 다운로드
 * @param filename
 * @param filepoint
 * @param duplicateid
 * @returns
 */
function Filedownload(filename, filepoint, duplicateid){
	var downloadFile = document.sermonFrm;
	
	//설교 종류
	var sermonType = $("#SermonKind").val();

	downloadFile.method="post";
	downloadFile.action="/sermon/SermonFiledownload.sermon?fileName=" + encodeURI(filename)
		+ "&userPoint="+encodeURI(filepoint)
		+ "&duplicateid=" +encodeURI(duplicateid)
		+ "&sermonType="+encodeURI(sermonType);
	
	downloadFile.submit();
};