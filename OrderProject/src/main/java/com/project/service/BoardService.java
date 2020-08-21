package com.project.service;

import java.util.List;

import com.project.vo.BoardVO;
import com.project.vo.SearchVO;

public interface BoardService {

	int getListCount();
	
	int boardInsert(BoardVO bvo);
	int QuestionboardInsert(BoardVO bvo);
	int AnswerboardInsert(BoardVO bvo);
	int QAnswerboardInsert(BoardVO bvo);

	List<BoardVO> boardlist(int idx, SearchVO svo);	
	List<BoardVO> Questionboardlist(int idx, SearchVO svo);	
	
	//int boardHit(int boardHit);
	int boardUpdate(BoardVO bvo);
	int QboardUpdate(BoardVO bvo);
	int AnswerboardUpdate(BoardVO bvo);
	int QAnswerboardUpdate(BoardVO bvo);
	
	int boardDelete(BoardVO bvo);
	int QboardDelete(BoardVO bvo);
	int AnswerboardDelete(BoardVO bvo);
	int QAnswerboardDel(BoardVO bvo);
	
	List<BoardVO> boardAnswer();
	List<BoardVO> QboardAnswer();

	//List<BoardVO> boardSearch(SearchVO svo);

}