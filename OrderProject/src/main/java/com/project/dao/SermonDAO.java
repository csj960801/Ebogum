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
	public int sundaySermonInsert(SermonVO svo) {
		int insertflag = session.insert("sermoninsert", svo);
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
	public int sundaySermonUpdate(SermonVO svo) {
		int updateflag = session.update("sermonupdate", svo);
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

	/**
	 * 주일 설교 파일을 다운로드 받을경우 파일에 적용되어있는 포인트만큼 회원 포인트를 감소시킴
	 * 
	 * @param point
	 * @return
	 */
	public int sundaySermonUserPoint(Map<String, Object> paramMap) {
		// int pointFlag = session.update("sermonUserPoint", point);
		int pointFlag = session.update("sermonUserPoint", paramMap);
		if (pointFlag > 0) {
			session.commit();
		}
		return pointFlag;
	}

	/**
	 * 강해 설교 리스트
	 * 
	 * @param svo
	 * @return
	 */
	public List<SermonVO> ganghaeSermonList(SearchVO svo) {
		List<SermonVO> sermonlist = session.selectList("ganghaesermonlist", svo);
		return sermonlist;
	}

	/**
	 * 강해 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 */
	public int ganghaeSermonInsert(SermonVO svo) {
		int insertflag = session.insert("ganghaesermoninsert", svo);
		if (insertflag > 0) {
			session.commit();
		}
		return insertflag;
	}

	/**
	 * 강해 설교 데이터 수정
	 * 
	 * @param svo
	 * @return
	 */
	public int ganghaeSermonUpdate(SermonVO svo) {
		int updateflag = session.update("ganghaesermonupdate", svo);
		if (updateflag > 0) {
			session.commit();
		}
		return updateflag;
	}

	/**
	 * 강해 설교 데이터 삭제
	 * 
	 * @param svo
	 * @return
	 */
	public int ganghaeSermonDelete(SermonVO svo) {
		int delflag = session.delete("ganghaesermondelete", svo);
		if (delflag > 0) {
			session.commit();
		}
		return delflag;
	}

	/**
	 * 인물 설교 리스트
	 * 
	 * @param svo
	 * @return
	 */
	public List<SermonVO> personSermonList(SearchVO svo) {
		List<SermonVO> sermonlist = session.selectList("personsermonlist", svo);
		return sermonlist;
	}

	/**
	 * 인물 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 */
	public int personSermonInsert(SermonVO svo) {
		int insertflag = session.insert("personsermoninsert", svo);
		if (insertflag > 0) {
			session.commit();
		}
		return insertflag;
	}

	/**
	 * 인물 설교 데이터 수정
	 * 
	 * @param svo
	 * @return
	 */
	public int personSermonUpdate(SermonVO svo) {
		int updateflag = session.update("personsermonupdate", svo);
		if (updateflag > 0) {
			session.commit();
		}
		return updateflag;
	}

	/**
	 * 인물 설교 데이터 삭제
	 * 
	 * @param svo
	 * @return
	 */
	public int personSermonDelete(SermonVO svo) {
		int delflag = session.delete("personsermondelete", svo);
		if (delflag > 0) {
			session.commit();
		}
		return delflag;
	}

	/**
	 * 철야 설교 리스트
	 * 
	 * @param svo
	 * @return
	 */
	public List<SermonVO> chulyaSermonList(SearchVO svo) {
		List<SermonVO> sermonlist = session.selectList("chulyasermonlist", svo);
		return sermonlist;
	}

	/**
	 * 철야 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 */
	public int chulyaSermonInsert(SermonVO svo) {
		int insertflag = session.insert("chulyasermoninsert", svo);
		if (insertflag > 0) {
			session.commit();
		}
		return insertflag;
	}

	/**
	 * 철야 설교 데이터 수정
	 * 
	 * @param svo
	 * @return
	 */
	public int chulyaSermonUpdate(SermonVO svo) {
		int updateflag = session.update("chulyasermonupdate", svo);
		if (updateflag > 0) {
			session.commit();
		}
		return updateflag;
	}

	/**
	 * 철야 설교 데이터 삭제
	 * 
	 * @param svo
	 * @return
	 */
	public int chulyaSermonDelete(SermonVO svo) {
		int delflag = session.delete("chulyasermondelete", svo);
		if (delflag > 0) {
			session.commit();
		}
		return delflag;
	}

	/**
	 * 심방설교 리스트
	 * 
	 * @param svo
	 * @return
	 */
	public List<SermonVO> simbangSermonList(SearchVO svo) {
		List<SermonVO> sermonlist = session.selectList("simbangsermonlist", svo);
		return sermonlist;
	}

	/**
	 * 심방설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 */
	public int simbangSermonInsert(SermonVO svo) {
		int insertflag = session.insert("simbangsermoninsert", svo);
		if (insertflag > 0) {
			session.commit();
		}
		return insertflag;
	}

	/**
	 * 심방설교 데이터 수정
	 * 
	 * @param svo
	 * @return
	 */
	public int simbangSermonUpdate(SermonVO svo) {
		int updateflag = session.update("simbangsermonupdate", svo);
		if (updateflag > 0) {
			session.commit();
		}
		return updateflag;
	}

	/**
	 * 심방설교 데이터 삭제
	 * 
	 * @param svo
	 * @return
	 */
	public int simbangSermonDelete(SermonVO svo) {
		int delflag = session.delete("simbangsermondelete", svo);
		if (delflag > 0) {
			session.commit();
		}
		return delflag;
	}

	/**
	 * 헌신설교 리스트
	 * 
	 * @param svo
	 * @return
	 */
	public List<SermonVO> hunshinSermonList(SearchVO svo) {
		List<SermonVO> sermonlist = session.selectList("hunshinsermonlist", svo);
		return sermonlist;
	}

	/**
	 * 헌신설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 */
	public int hunshinSermonInsert(SermonVO svo) {
		int insertflag = session.insert("hunshinsermoninsert", svo);
		if (insertflag > 0) {
			session.commit();
		}
		return insertflag;
	}

	/**
	 * 헌신설교 데이터 수정
	 * 
	 * @param svo
	 * @return
	 */
	public int hunshinSermonUpdate(SermonVO svo) {
		int updateflag = session.update("hunshinsermonupdate", svo);
		if (updateflag > 0) {
			session.commit();
		}
		return updateflag;
	}

	/**
	 * 헌신설교 데이터 삭제
	 * 
	 * @param svo
	 * @return
	 */
	public int hunshinSermonDelete(SermonVO svo) {
		int delflag = session.delete("hunshinsermondelete", svo);
		if (delflag > 0) {
			session.commit();
		}
		return delflag;
	}
	
	/**
	 * 특별설교 리스트
	 * 
	 * @param svo
	 * @return
	 */
	public List<SermonVO> specialSermonList(SearchVO svo) {
		List<SermonVO> sermonlist = session.selectList("specialsermonlist", svo);
		return sermonlist;
	}

	/**
	 * 특별설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 */
	public int specialSermonInsert(SermonVO svo) {
		int insertflag = session.insert("specialsermoninsert", svo);
		if (insertflag > 0) {
			session.commit();
		}
		return insertflag;
	}

	/**
	 * 특별설교 데이터 수정
	 * 
	 * @param svo
	 * @return
	 */
	public int specialSermonUpdate(SermonVO svo) {
		int updateflag = session.update("specialsermonupdate", svo);
		if (updateflag > 0) {
			session.commit();
		}
		return updateflag;
	}

	/**
	 * 특별설교 데이터 삭제
	 * 
	 * @param svo
	 * @return
	 */
	public int specialSermonDelete(SermonVO svo) {
		int delflag = session.delete("specialsermondelete", svo);
		if (delflag > 0) {
			session.commit();
		}
		return delflag;
	}
	
	/**
	 * 컬럼형예화 설교 리스트
	 * 
	 * @param svo
	 * @return
	 */
	public List<SermonVO> columnSermonList(SearchVO svo) {
		List<SermonVO> sermonlist = session.selectList("columnsermonlist", svo);
		return sermonlist;
	}

	/**
	 * 컬럼형예화 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 */
	public int columnSermonInsert(SermonVO svo) {
		int insertflag = session.insert("columnsermoninsert", svo);
		if (insertflag > 0) {
			session.commit();
		}
		return insertflag;
	}

	/**
	 * 컬럼형예화 설교 데이터 수정
	 * 
	 * @param svo
	 * @return
	 */
	public int columnSermonUpdate(SermonVO svo) {
		int updateflag = session.update("columnsermonupdate", svo);
		if (updateflag > 0) {
			session.commit();
		}
		return updateflag;
	}

	/**
	 * 컬럼형예화 설교 데이터 삭제
	 * 
	 * @param svo
	 * @return
	 */
	public int columnSermonDelete(SermonVO svo) {
		int delflag = session.delete("columnsermondelete", svo);
		if (delflag > 0) {
			session.commit();
		}
		return delflag;
	}
}