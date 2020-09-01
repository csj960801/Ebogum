package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ApprovalDao;
import com.project.vo.SearchVO;
import com.project.vo.UserVO;

@Service("com.project.service.ApprovalService")
public class ApprovalServiceImpl implements ApprovalService {

	// @Autowired
	// private SqlSessionTemplate sqlSession;

	@Autowired
	private ApprovalDao approvalDao;

	@Override
	public int MemberReg(UserVO user) {
		// TODO Auto-generated method stub
		return approvalDao.MemberReg(user);
	}

	@Override
	public boolean MemberLogin(UserVO loginvo) {
		// TODO Auto-generated method stub
		return approvalDao.MemberLogin(loginvo);
	}

	@Override
	public UserVO findInfo(UserVO uservo) {
		// TODO Auto-generated method stub
		return approvalDao.findInfo(uservo);
	}
	
	@Override
	public boolean DuplicateCheck(String id) {
		// TODO Auto-generated method stub
		return approvalDao.duplicateCheck(id);
	}
	
	@Override
	public UserVO getPoint(UserVO uvo) {
		// TODO Auto-generated method stub
		return approvalDao.getPoint(uvo);
	}
	
	@Override
	public List<UserVO> memberList(SearchVO svo) {
		// TODO Auto-generated method stub
		return approvalDao.memberList(svo);
	}
	
	@Override
	public boolean DelMember(UserVO uservo) {
		// TODO Auto-generated method stub
		return approvalDao.DelMember(uservo);
	}
}