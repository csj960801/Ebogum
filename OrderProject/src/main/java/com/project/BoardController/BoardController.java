package com.project.BoardController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.PageNavigation.Paging;
import com.project.service.BoardServiceImpl;
import com.project.vo.BoardVO;
import com.project.vo.SearchVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardServiceImpl boardservice;

	private Logger boardlog = LoggerFactory.getLogger(this.getClass());

	/**
	 * 페이지 수 출력
	 * 
	 * @param req
	 * @return
	 */
	public Paging getPaging(HttpServletRequest req) {

		Paging page = new Paging();
		String currPageNo = req.getParameter("pageNo");

		if (currPageNo == null || currPageNo.equals("")) {
			currPageNo = "1";
		}

		int currentPageNo = Integer.parseInt(currPageNo);
		int pageRowCnt = 10;
		page.setCurrentPageNo(currentPageNo);
		int totalCnt = boardservice.getListCount();

		page.setNavigationInfo(totalCnt, pageRowCnt, currentPageNo, req);

		return page;
	}

	/**
	 * 자유게시판 리스트 페이지(중요)
	 * 
	 * @return
	 */
	@RequestMapping("/FreeBoard.board")
	public List<BoardVO> FreeBoard(Model boardmodel, HttpServletRequest req, @ModelAttribute("svo") SearchVO svo) {
		// 자유게시판 게시글 출력
		List<BoardVO> freeboardlist = boardservice.boardlist(1, svo);

		// 자유게시판 답변 데이터 출력
		List<BoardVO> freeboardanswerlist = boardservice.boardAnswer();

		boardmodel.addAttribute("boardlist", freeboardlist);
		boardmodel.addAttribute("boardanswerlist", freeboardanswerlist);
		boardmodel.addAttribute("pageNavigation", getPaging(req));

		return freeboardlist;
	}

	/**
	 * QnA게시판 리스트 페이지(중요)
	 * 
	 * @return
	 */
	@RequestMapping("/Qboard/QuestionBoard.board")
	public List<BoardVO> QuestionBoard(Model boardmodel, HttpServletRequest req, @ModelAttribute("svo") SearchVO svo) {

		// QnA 게시글 리스트
		List<BoardVO> Questionboardlist = boardservice.Questionboardlist(1, svo);

		// QnA 게시글 답변 리스트
		List<BoardVO> Questionanswerboardlist = boardservice.QboardAnswer();

		boardmodel.addAttribute("qboardlist", Questionboardlist);
		boardmodel.addAttribute("qboardanswerlist", Questionanswerboardlist);
		boardmodel.addAttribute("qpageNavigation", getPaging(req));

		return Questionboardlist;
	}

	/**
	 * 공지게시글 출력
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/Noticeboard/NoticeBoard.board")
	public List<BoardVO> NoticeBoard(Model boardmodel, HttpServletRequest req) {
		List<BoardVO> noticeList = boardservice.noticeboardList();

		boardmodel.addAttribute("noticeList", noticeList);
		boardmodel.addAttribute("pageNavigation", getPaging(req));

		return noticeList;
	}

	/**
	 * 공지게시글 저장
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Noticeboard/NoticeBoardinsert.board", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String, Object> NoticeBoardinsert(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> BoardinsertMap = new HashMap<String, Object>();

		int boardinsert = boardservice.NoticeboardInsert(bvo);
		BoardinsertMap.put("boardinsert", boardinsert);
		boardlog.info("================================");
		boardlog.info("공지게시글 데이터 저장 성공");
		boardlog.info("================================");
		return BoardinsertMap;

	}

	/**
	 * 자유게시판 저장
	 * 
	 * @return
	 */
	@RequestMapping(value = "/WriteBoardinsert.board", method = RequestMethod.POST)
	public Map<String, Object> WriteBoardinsert(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> BoardinsertMap = new HashMap<String, Object>();

		int boardinsert = boardservice.boardInsert(bvo);
		BoardinsertMap.put("boardinsert", boardinsert);
		boardlog.info("================================");
		boardlog.info("게시판 데이터 저장 성공");
		boardlog.info("================================");
		return BoardinsertMap;
	}

	/**
	 * QnA게시판 저장
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Qboard/WriteQBoardinsert.board", method = RequestMethod.POST)
	public Map<String, Object> QWriteBoardinsert(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> qBoardinsertMap = new HashMap<String, Object>();
		int qboardinsert = boardservice.QuestionboardInsert(bvo);
		qBoardinsertMap.put("Qboardinsert", qboardinsert);
		boardlog.info("================================");
		boardlog.info("QnA게시판 데이터 저장 성공");
		boardlog.info("================================");
		return qBoardinsertMap;
	}

	/**
	 * 자유게시판 데이터 수정
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/WriteBoardupdate.board", method = RequestMethod.POST)
	public Map<String, Object> WriteBoardupdate(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> BoardupdateMap = new HashMap<String, Object>();
		int boardupdate = boardservice.boardUpdate(bvo);
		BoardupdateMap.put("boardupdate", boardupdate);
		boardlog.info("================================");
		boardlog.info("게시판 데이터 수정 성공");
		boardlog.info("================================");
		return BoardupdateMap;
	}

	/**
	 * QnA게시판 데이터 수정
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Qboard/WriteQBoardupdate.board", method = RequestMethod.POST)
	public Map<String, Object> WriteQBoardupdate(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> qBoardupdateMap = new HashMap<String, Object>();
		int boardupdate = boardservice.QboardUpdate(bvo);
		qBoardupdateMap.put("qboardupdate", boardupdate);
		boardlog.info("================================");
		boardlog.info("QnA게시판 데이터 수정 성공");
		boardlog.info("================================");
		return qBoardupdateMap;
	}

	/**
	 * 공지게시글 데이터 수정
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping("/Noticeboard/NoticeBoardupdate.board")
	public Map<String, Object> NoticeBoardupdate(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> noticeboardupdateMap = new HashMap<String, Object>();
		int noticeupdateFlag = boardservice.NoticeboardUpdate(bvo);
		noticeboardupdateMap.put("boardupdate", noticeupdateFlag);
		boardlog.info("================================");
		boardlog.info("공지게시판 데이터 수정 성공");
		boardlog.info("================================");

		return noticeboardupdateMap;
	}

	/**
	 * 자유 게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/WriteBoarddelete.board")
	public Map<String, Object> WriteBoarddelete(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> BoarddelMap = new HashMap<String, Object>();
		int boarddel = boardservice.boardDelete(bvo);
		BoarddelMap.put("boarddel", boarddel);
		boardlog.info("================================");
		boardlog.info("게시판 데이터 삭제 성공");
		boardlog.info("================================");
		return BoarddelMap;
	}

	/**
	 * QnA 게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Qboard/WriteQBoarddelete.board")
	public Map<String, Object> WriteQBoarddelete(@ModelAttribute("qboardvo") BoardVO bvo) {
		Map<String, Object> qBoarddelMap = new HashMap<String, Object>();
		int qboarddel = boardservice.QboardDelete(bvo);
		qBoarddelMap.put("qboarddel", qboarddel);
		boardlog.info("================================");
		boardlog.info("QnA 게시판 데이터 삭제 성공");
		boardlog.info("================================");
		return qBoarddelMap;
	}

	/**
	 * 공지게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Noticeboard/NoticeBoarddelete.board")
	public Map<String, Object> NoticeBoarddelete(@RequestParam("boardCnt") String boardCnt) {
		Map<String, Object> NoticeBoarddelMap = new HashMap<String, Object>();
		int boarddel = boardservice.NoticeboardDel(boardCnt);
		NoticeBoarddelMap.put("boarddel", boarddel);
		boardlog.info("================================");
		boardlog.info("공지게시글 데이터 삭제 성공");
		boardlog.info("================================");
		return NoticeBoarddelMap;
	}

	/**
	 * 자유게시판 게시글 답장데이터 저장
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/WriteBoardreply.board", method = RequestMethod.POST)
	public Map<String, Object> WriteBoardReply(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> BoardReplyInsertMap = new HashMap<String, Object>();
		int boardAnswerInsert = boardservice.AnswerboardInsert(bvo);
		BoardReplyInsertMap.put("boardReply", boardAnswerInsert);
		boardlog.info("================================");
		boardlog.info("자유게시판 게시글 답변 데이터 저장 성공");
		boardlog.info("================================");
		return BoardReplyInsertMap;
	}

	/**
	 * QnA게시판 게시글 답장하기
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Qboard/WriteQBoardreply.board", method = RequestMethod.POST)
	public Map<String, Object> WriteQBoardReply(@ModelAttribute("qboardvo") BoardVO bvo) {
		Map<String, Object> qBoardReplyMap = new HashMap<String, Object>();
		int qboardanswerinsert = boardservice.QAnswerboardInsert(bvo);
		qBoardReplyMap.put("qboardReply", qboardanswerinsert);
		boardlog.info("================================");
		boardlog.info("QnA게시판 게시글 답글 데이터 저장 성공");
		boardlog.info("================================");
		return qBoardReplyMap;
	}

	/**
	 * 자유게시판 답변 게시글 수정
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Answerboard/free/WriteAnswerBoardupdate.board", method = RequestMethod.POST)
	public Map<String, Object> WriteAnswerBoardUpdate(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> AnswerBoardUpdateMap = new HashMap<String, Object>();
		int boardAnswerupdate = boardservice.AnswerboardUpdate(bvo);
		AnswerBoardUpdateMap.put("Answerboardupdate", boardAnswerupdate);
		boardlog.info("================================");
		boardlog.info("자유게시판 게시글 답변 데이터 수정 성공");
		boardlog.info("================================");
		return AnswerBoardUpdateMap;
	}

	/**
	 * 자유게시판 답변 게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Answerboard/free/WriteAnswerBoarddelete.board", method = RequestMethod.POST)
	public Map<String, Object> WriteAnswerBoardDel(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> AnswerBoarddelMap = new HashMap<String, Object>();
		int boardAnswerdel = boardservice.AnswerboardDelete(bvo);
		AnswerBoarddelMap.put("Answerboarddel", boardAnswerdel);
		boardlog.info("================================");
		boardlog.info("자유게시판 게시글 답변 데이터 삭제 성공");
		boardlog.info("================================");
		return AnswerBoarddelMap;
	}

	/**
	 * 자유게시판 답변된 게시글 재답변
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Answerboard/free/WriteAnswerBoardreply.board", method = RequestMethod.POST)
	public Map<String, Object> WriteAnswerBoardReply(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> AnswerBoardreplyMap = new HashMap<String, Object>();
		int boardAnswerreply = boardservice.AnswerboardDelete(bvo);
		AnswerBoardreplyMap.put("Answerboardreply", boardAnswerreply);
		boardlog.info("================================");
		boardlog.info("자유게시판 답변된게시글 재답변 성공");
		boardlog.info("================================");
		return AnswerBoardreplyMap;
	}

	/**
	 * QnA게시판 답변 게시글 수정
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Answerboard/question/WriteQAnswerBoardupdate.board", method = RequestMethod.POST)
	public Map<String, Object> WriteQAnswerBoardUpdate(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> qAnswerQBoardUpdateMap = new HashMap<String, Object>();
		int qboardAnswerupdate = boardservice.QAnswerboardUpdate(bvo);
		qAnswerQBoardUpdateMap.put("qAnswerboardupdate", qboardAnswerupdate);
		boardlog.info("================================");
		boardlog.info("QnA게시판 게시글 답변 데이터 수정 성공");
		boardlog.info("================================");
		return qAnswerQBoardUpdateMap;
	}

	/**
	 * QnA게시판 답변 게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	@RequestMapping(value = "/Answerboard/question/WriteQAnswerBoarddelete.board", method = RequestMethod.POST)
	public Map<String, Object> WriteQAnswerBoardDel(@ModelAttribute("boardvo") BoardVO bvo) {
		Map<String, Object> qAnswerBoarddelMap = new HashMap<String, Object>();
		int qboardAnswerdel = boardservice.QAnswerboardDel(bvo);
		qAnswerBoarddelMap.put("qAnswerboarddel", qboardAnswerdel);
		boardlog.info("================================");
		boardlog.info("QnA게시판 게시글 답변 데이터 삭제 성공");
		boardlog.info("================================");
		return qAnswerBoarddelMap;
	}

}