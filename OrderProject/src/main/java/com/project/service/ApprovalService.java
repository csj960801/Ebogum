package com.project.service;

import java.util.List;

import com.project.vo.SearchVO;
import com.project.vo.UserVO;

public interface ApprovalService {

	/**
	 * 회원가입
	 * 
	 * @param user
	 * @return
	 */
	int MemberReg(UserVO user);

	/**
	 * 로그인
	 * 
	 * @param loginvo
	 * @return
	 */
	boolean MemberLogin(UserVO loginvo);

	/**
	 * 아이디/비번 찾기
	 * 
	 * @param uservo
	 * @return
	 */
	UserVO findInfo(UserVO uservo);

	/**
	 * 아이디 중복검사
	 * 
	 * @param id
	 * @return
	 */
	boolean DuplicateCheck(String id);
	
	/**
	 * (관리자전용)회원 목록출력
	 * @return
	 */
	List<UserVO> memberList(SearchVO svo);
	
	/**
	 * (관리자전용)회원 삭제
	 * @param uservo
	 * @return
	 */
	boolean DelMember(UserVO uservo);
}