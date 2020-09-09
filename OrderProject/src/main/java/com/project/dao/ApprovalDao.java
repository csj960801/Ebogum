package com.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.Session.SqlSessionInstance;
import com.project.vo.SearchVO;
import com.project.vo.UserVO;

@Repository
public class ApprovalDao {

	private static Logger daolog = LoggerFactory.getLogger(ApprovalDao.class);

	// SqlSession 인스턴스는 앞으로 분리해서 사용하도록 하자!
	private static SqlSession session;

	/**
	 * 회원가입
	 * 
	 * @param user
	 * @return
	 */
	public int MemberReg(UserVO user) {
		session = SqlSessionInstance.getInstanceSession().openSession();

		int flag = session.insert("userReg", user);
		if (flag > 0) {
			daolog.info("=====================================");
			daolog.info(flag + "개 데이터 회원가입 되었습니다.");
			daolog.info("=====================================");
			session.commit(true);
		}
		return flag;
	}

	/**
	 * 로그인
	 * 
	 * @param login
	 * @return
	 */
	public boolean MemberLogin(UserVO login) {
		session = SqlSessionInstance.getInstanceSession().openSession();

		boolean flag = true;
		try {
			UserVO loginvo = session.selectOne("loginCheck", login);

			if (loginvo == null) {
				flag = false;
				daolog.info("=====================================");
				daolog.info("존재하지않는 아이디입니다.");
				daolog.info("=====================================");
			}
		} catch (Exception e) {
			daolog.info("=====================================");
			daolog.info("로그인 예외발생");
			daolog.info("=====================================");
		}

		return flag;
	}

	/**
	 * 아이디/비번 찾기
	 * 
	 * @param uservo
	 * @return
	 */
	public UserVO findInfo(UserVO uservo) {
		session = SqlSessionInstance.getInstanceSession().openSession();

		UserVO uvo = session.selectOne("findInfo", uservo);
		if (uvo != null) {
			daolog.info("=====================================");
			daolog.info("검색결과가 존재합니다.");
			daolog.info("=====================================");
		}
		return uvo;
	}

	/**
	 * 아이디 중복검사
	 * 
	 * @param id
	 * @return
	 */
	public boolean duplicateCheck(String id) {
		boolean duplicateCheck = false;
		session = SqlSessionInstance.getInstanceSession().openSession();

		UserVO uvo = session.selectOne("duplicateCheck", id);
		if (uvo != null) {
			duplicateCheck = true;
		}
		return duplicateCheck;
	}

	/**
	 * 회원 포인트 가져오기
	 * 
	 * @return
	 */
	public UserVO getPoint(UserVO uvo) {
		session = SqlSessionInstance.getInstanceSession().openSession();
		UserVO point = session.selectOne("pointValue", uvo);
		daolog.info("=====================================");
		daolog.info("포인트값: " + point.getPoint());
		daolog.info("=====================================");
		return point;
	}

	/**
	 * (관리자전용)회원 목록출력
	 * 
	 * @return
	 */
	public List<UserVO> memberList(SearchVO uvo) {
		session = SqlSessionInstance.getInstanceSession().openSession();

		List<UserVO> memberlist = session.selectList("adminMemberlist", uvo);
		if (memberlist.size() > 0) {
			daolog.info("=====================================");
			daolog.info(memberlist.size() + " 명의 회원이 존재합니다!");
			daolog.info("=====================================");
		}

		return memberlist;
	}

	/**
	 * (관리자전용)회원 삭제
	 * 
	 * @param id
	 * @param pass
	 * @return
	 */
	public boolean DelMember(UserVO bvo) {
		session = SqlSessionInstance.getInstanceSession().openSession();

		int delCnt = session.delete("adminDel", bvo);
		boolean delFlag = false;
		if (delCnt > 0) {
			session.commit();
			delFlag = true;
		}
		return delFlag;
	}
}// end of class