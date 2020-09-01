package com.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.Session.SqlSessionInstance;
import com.project.vo.BoardVO;
import com.project.vo.SearchVO;

@Repository
public class BoardDAO {

	private SqlSession session = SqlSessionInstance.getInstanceSession().openSession();

	/**
	 * 게시판 전체글수
	 * 
	 * @return
	 */
	public int getListCount() {
		int getListCnt = session.selectOne("getListCount");
		return getListCnt;
	}

	/**
	 * 게시판 데이터 저장
	 * 
	 * @param bvo
	 * @return
	 */
	public int boardInsert(BoardVO bvo) {
		int insertFlag = session.insert("boardinsert", bvo);
		if (insertFlag > 0) {
			session.commit();
		}
		return insertFlag;
	}

	/**
	 * QnA게시판 데이터 저장
	 * 
	 * @param bvo
	 * @return
	 */
	public int QboardInsert(BoardVO bvo) {
		int qinsertFlag = session.insert("qboardinsert", bvo);
		if (qinsertFlag > 0) {
			session.commit();
		}
		return qinsertFlag;
	}

	/**
	 * 공지사항 게시글 저장
	 * 
	 * @param bvo
	 * @return
	 */
	public int NoticeboardInsert(BoardVO bvo) {
		int insertFlag = session.insert("noticeboardinsert", bvo);
		if (insertFlag > 0) {
			session.commit();
		}
		return insertFlag;
	}

	/**
	 * 자유게시판 리스트 출력
	 * 
	 * @return
	 */
	public List<BoardVO> boardList(SearchVO svo) {
		List<BoardVO> boardlist = session.selectList("boardlist", svo);
		return (boardlist != null) ? boardlist : null;
	}

	/**
	 * QnA게시판 리스트 출력
	 * 
	 * @return
	 */
	public List<BoardVO> qboardList(SearchVO svo) {
		List<BoardVO> qboardlist = session.selectList("qboardlist", svo);
		return (qboardlist != null) ? qboardlist : null;
	}

	/**
	 * 공지게시판 리스트 출력
	 * 
	 * @return
	 */
	public List<BoardVO> noticeboardList() {
		List<BoardVO> boardlist = session.selectList("noticeboardlist");
		return (boardlist != null) ? boardlist : null;
	}

	/**
	 * 게시글 조회수 출력
	 * 
	 * @param boardHit
	 * @return
	 */
	public int boardHit(int boardHit) {
		int idx = session.update("boardHit", boardHit);
		return idx;
	}

	/**
	 * 자유게시판 게시글 수정
	 * 
	 * @param bvo
	 * @return
	 */
	public int boardUpdate(BoardVO bvo) {
		int updateFlag = session.update("boardUpdate", bvo);
		if (updateFlag > 0) {
			session.commit();
		}
		return updateFlag;
	}

	/**
	 * QnA게시판 게시글 수정
	 * 
	 * @param bvo
	 * @return
	 */
	public int QboardUpdate(BoardVO bvo) {
		int qupdateFlag = session.update("qboardUpdate", bvo);
		if (qupdateFlag > 0) {
			session.commit();
		}
		return qupdateFlag;
	}

	/**
	 * 자유게시판 답변 게시글 수정
	 * 
	 * @param bvo
	 * @return
	 */
	public int AnswerboardUpdate(BoardVO bvo) {
		int AnswerupdateFlag = session.update("answerboardUpdate", bvo);
		if (AnswerupdateFlag > 0) {
			session.commit();
		}
		return AnswerupdateFlag;
	}

	/**
	 * QnA게시판 답변 게시글 수정
	 * 
	 * @param bvo
	 * @return
	 */
	public int QAnswerboardUpdate(BoardVO bvo) {
		int qAnswerupdateFlag = session.update("qanswerboardUpdate", bvo);
		if (qAnswerupdateFlag > 0) {
			session.commit();
		}
		return qAnswerupdateFlag;
	}

	/**
	 * 공지게시글 수정
	 * 
	 * @param bvo
	 * @return
	 */
	public int NoticeboardUpdate(BoardVO bvo) {
		int noticeupdateFlag = session.update("noticeboardUpdate", bvo);
		if (noticeupdateFlag > 0) {
			session.commit();
		}
		return noticeupdateFlag;
	}

	/**
	 * 자유게시판 게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	public int boardDel(BoardVO bvo) {
		int delFlag = session.delete("boardDel", bvo);
		if (delFlag > 0) {
			session.commit();
		}
		return delFlag;
	}

	/**
	 * QnA게시판 게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	public int QboardDel(BoardVO bvo) {
		int qdelFlag = session.delete("qboardDel", bvo);
		if (qdelFlag > 0) {
			session.commit();
		}
		return qdelFlag;
	}

	/**
	 * 자유게시판 답변 게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	public int AnswerboardDel(BoardVO bvo) {
		int AnswerdelFlag = session.delete("answerboardDel", bvo);
		if (AnswerdelFlag > 0) {
			session.commit();
		}
		return AnswerdelFlag;
	}

	/**
	 * QnA게시판 답변 게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	public int QAnswerboardDel(BoardVO bvo) {
		int qAnswerdelFlag = session.delete("qanswerboardDel", bvo);
		if (qAnswerdelFlag > 0) {
			session.commit();
		}
		return qAnswerdelFlag;
	}

	/**
	 * 공지게시글 삭제
	 * 
	 * @param bvo
	 * @return
	 */
	public int NoticeboardDel(String boardCnt) {
		int noticedelFlag = session.delete("noticeboardDel", boardCnt);
		if (noticedelFlag > 0) {
			session.commit();
		}
		return noticedelFlag;
	}

	/**
	 * 자유게시판 답변 데이터 저장
	 * 
	 * @param bvo
	 * @return
	 */
	public int answerboardInsert(BoardVO bvo) {
		int answerinsertFlag = session.insert("boardanswerInsert", bvo);
		if (answerinsertFlag > 0) {
			session.commit();
		}
		return answerinsertFlag;
	}

	/**
	 * QnA게시판 답변 데이터 저장
	 * 
	 * @param bvo
	 * @return
	 */
	public int QanswerboardInsert(BoardVO bvo) {
		int qanswerinsertFlag = session.insert("qboardanswerInsert", bvo);
		if (qanswerinsertFlag > 0) {
			session.commit();
		}
		return qanswerinsertFlag;
	}

	/**
	 * 자유게시글 답변 리스트 출력
	 * 
	 * @param bvo
	 * @return
	 */
	public List<BoardVO> boardAnswer() {
		List<BoardVO> answerboardList = session.selectList("freeboardanswerlist");
		System.out.println("-----------------------------------------------");
		System.out.println(answerboardList.size() + " 만큼 답변 글이 존재합니다.");
		System.out.println("-----------------------------------------------");
		return answerboardList;
	}

	/**
	 * QnA게시글 답변 리스트 출력
	 * 
	 * @param bvo
	 * @return
	 */
	public List<BoardVO> QboardAnswer() {
		List<BoardVO> qanswerboardList = session.selectList("questionboardanswerlist");
		System.out.println("-----------------------------------------------");
		System.out.println(qanswerboardList.size() + " 만큼 QnA 답변 글이 존재합니다.");
		System.out.println("-----------------------------------------------");
		return qanswerboardList;
	}

}