package com.project.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.Session.SqlSessionInstance;
import com.project.vo.SearchVO;
import com.project.vo.SermonVO;

@Repository
public class SermonDAO {

	private Logger sermondaoLog = LoggerFactory.getLogger(this.getClass());
	private SqlSession session = SqlSessionInstance.getInstanceSession().openSession();

	/**
	 * 주일 설교 리스트
	 * 
	 * @return
	 */
	public List<SermonVO> sundaySermonList(SearchVO svo) {
		List<SermonVO> sermonlist = session.selectList("sermonlist", svo);
		return sermonlist;
	}

	/**
	 * 주일 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 */
	public int sundaySermonInsert(Map<String, Object> map) {
		int insertflag = session.insert("sermoninsert", map);
		if (insertflag > 0) {
			session.commit();
		}
		return insertflag;
	}

	/**
	 * 주일 설교 데이터 수정
	 * 
	 * @param svo
	 * @return
	 */
	public int sundaySermonUpdate(Map<String, Object> map) {
		int updateflag = session.update("sermonupdate", map);
		if (updateflag > 0) {
			session.commit();
		}
		return updateflag;
	}

	/**
	 * 주일 설교 데이터 삭제
	 * 
	 * @param svo
	 * @return
	 */
	public int sundaySermonDelete(SermonVO svo) {
		int delflag = session.delete("sermondelete", svo);
		if (delflag > 0) {
			session.commit();
		}
		return delflag;
	}
}