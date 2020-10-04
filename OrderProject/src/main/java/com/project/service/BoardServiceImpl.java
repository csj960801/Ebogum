package com.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dao.BoardDAO;
import com.project.vo.BoardVO;
import com.project.vo.SearchVO;

public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boarddao;

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return boarddao.getListCount();
	}

	/**
	 * 자유게시판 데이터 저장
	 */
	@Override
	public int boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.boardInsert(bvo);
	}

	/**
	 * QnA게시판 데이터 저장
	 */
	@Override
	public int QuestionboardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.QboardInsert(bvo);
	}

	/**
	 * 자유게시판 답변 데이터 저장
	 */
	@Override
	public int AnswerboardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.answerboardInsert(bvo);
	}

	/**
	 * QnA게시판 답변 데이터 저장
	 */
	@Override
	public int QAnswerboardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.QanswerboardInsert(bvo);
	}

	/**
	 * 공지사항 게시판 데이터 저장
	 */
	@Override
	public int NoticeboardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.NoticeboardInsert(bvo);
	}

	/**
	 * 자유게시판 데이터 리스트 출력
	 */
	@Override
	public List<BoardVO> boardlist(int idx, SearchVO svo) {
		// boardHit(idx);
		return boarddao.boardList(svo);
	}

	/**
	 * QnA게시판 데이터 리스트 출력
	 */
	@Override
	public List<BoardVO> Questionboardlist(int idx, SearchVO svo) {
		// TODO Auto-generated method stub
		return boarddao.qboardList(svo);
	}

	/**
	 * 공지게시글 데이터 리스트 출력
	 */
	@Override
	public List<BoardVO> noticeboardList() {
		// TODO Auto-generated method stub
		return boarddao.noticeboardList();
	}

	/**
	 * 자유게시판 게시글 조회수
	 */

	@Override
	public int boardHit(Map<String, Object> boardHit) { 
		// TODO Auto-generated method stub
		int idx = boarddao.boardHit(boardHit);
		return idx;
	}

	/**
	 * 공지게시글 조회수
	 */
	@Override
	public int noticeboardHit(Map<String, Object> boardHit) {
		// TODO Auto-generated method stub
		return boarddao.noticeboardHit(boardHit);
	}
	
	/**
	 * 자유게시판 데이터 수정
	 */
	@Override
	public int boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.boardUpdate(bvo);
	}

	/**
	 * QnA게시판 데이터 수정
	 */
	@Override
	public int QboardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.QboardUpdate(bvo);
	}

	/**
	 * 자유게시판 답변 게시글 수정
	 */
	@Override
	public int AnswerboardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.AnswerboardUpdate(bvo);
	}

	/**
	 * QnA게시판 답변 게시글 수정
	 */
	@Override
	public int QAnswerboardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.QAnswerboardUpdate(bvo);
	}

	/**
	 * 공지게시글 수정
	 */
	@Override
	public int NoticeboardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.NoticeboardUpdate(bvo);
	}

	/**
	 * 자유게시판 데이터 삭제
	 */
	@Override
	public int boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.boardDel(bvo);
	}

	/**
	 * QnA게시판 데이터 삭제
	 */
	@Override
	public int QboardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.QboardDel(bvo);
	}

	/**
	 * 자유게시판 답변 게시글 삭제
	 */
	@Override
	public int AnswerboardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.AnswerboardDel(bvo);
	}

	/**
	 * QnA게시판 답변 게시글 삭제
	 */
	@Override
	public int QAnswerboardDel(BoardVO bvo) {
		// TODO Auto-generated method stub
		return boarddao.QAnswerboardDel(bvo);
	}

	/**
	 * 공지게시글 삭제
	 */
	@Override
	public int NoticeboardDel(String boardCnt) {
		// TODO Auto-generated method stub
		return boarddao.NoticeboardDel(boardCnt);
	}

	/**
	 * 자유게시판 게시글 답변
	 */
	@Override
	public List<BoardVO> boardAnswer() {
		// TODO Auto-generated method stub
		return boarddao.boardAnswer();
	}

	/**
	 * QnA게시판 게시글 답변
	 */
	@Override
	public List<BoardVO> QboardAnswer() {
		// TODO Auto-generated method stub
		return boarddao.QboardAnswer();
	}

	/*
	 * @Override public List<BoardVO> boardSearch(SearchVO svo) { // TODO
	 * Auto-generated method stub return boarddao.boardSearch(svo); }
	 */
}