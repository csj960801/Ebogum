package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.ApprovalServiceImpl;
import com.project.vo.PayVO;
import com.project.vo.SearchVO;
import com.project.vo.UserVO;

@Controller
public class ApprovalController {

	private Logger controllerLog = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ApprovalServiceImpl aServiceApprovalServiceImpl;

	/***
	 * to Index
	 * 
	 * @return
	 */
	@RequestMapping("/index.app")
	public String index() {
		return "index";
	}

	/**
	 * (관리자전용)회원 목록출력
	 * 
	 * @return
	 */
	@RequestMapping("/Admin/Admin.app")
	public List<UserVO> memberList(Model model, @ModelAttribute("svo") SearchVO svo) {
		List<UserVO> memberlist = aServiceApprovalServiceImpl.memberList(svo);
		model.addAttribute("memberlist", memberlist);
		return memberlist;
	}

	/**
	 * 회원가입
	 * 
	 * @return
	 */
	@RequestMapping(value = "/memberReg/memberReg.app", method = RequestMethod.POST)
	public Map<String, Object> memberReg(@ModelAttribute("uservo") UserVO vo) {
		Map<String, Object> regMap = new HashMap<String, Object>();

		int regFlag = aServiceApprovalServiceImpl.MemberReg(vo);
		if (regFlag > 0) {
			regMap.put("regFlag", regFlag);
		}

		return regMap;
	}

	/**
	 * login(POST방식으로 요청 받아야 정상 플로우 진행.)
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/login/login.app", "/login.app" }, method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, @ModelAttribute("logvo") UserVO loginvo) {
		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView();

		boolean lvo = aServiceApprovalServiceImpl.MemberLogin(loginvo);
		UserVO getPoint = aServiceApprovalServiceImpl.getPoint(loginvo);

		if (lvo) {
			controllerLog.info("========================");
			controllerLog.info(loginvo.getDuplicateid());
			controllerLog.info(loginvo.getPass1());
			controllerLog.info(getPoint.getDate());
			controllerLog.info("========================");

			// 만약 포인트가 null이거나 입력되어 있지않을 경우 0으로 초기화
			if (getPoint.getPoint() == null || getPoint.getPoint().equals("")) {
				getPoint.setPoint("0");
			}

			session.setAttribute("login", loginvo.getDuplicateid());
			session.setAttribute("point", Integer.parseInt(getPoint.getPoint()));

			model.addObject("loginFlag", lvo); // 로그인 성공 여부
			model.setViewName("/login/login");
			controllerLog.info("========================");
			controllerLog.info("로그인 성공");
			controllerLog.info("========================");
		} else {
			model.setViewName("/login/login");
			controllerLog.info("========================");
			controllerLog.info("로그인 실패");
			controllerLog.info("========================");
		}

		return model;
	}// end of login

	/**
	 * 로그아웃
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/logout.app")
	public String LogOut(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();

		controllerLog.info("========================");
		controllerLog.info("로그아웃 성공.");
		controllerLog.info("========================");

		return "/index";
	}

	/**
	 * 아이디/비번찾기
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findInfo/findInfo.app", method = RequestMethod.POST)
	public Map<String, Object> findInfo(@ModelAttribute("uvo") UserVO uservo) {
		Map<String, Object> findInfoMap = new HashMap<String, Object>();

		UserVO usvo = aServiceApprovalServiceImpl.findInfo(uservo);
		if (usvo != null) {
			findInfoMap.put("findId", usvo.getDuplicateid());
			findInfoMap.put("findPw", usvo.getPass1());
		}

		return findInfoMap;
	}

	/**
	 * 아이디 중복검사
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/DuplicateCheck/DuplicateCheck.app")
	public Map<String, Object> CheckDuplicateId(@RequestParam("id") String id) {
		Map<String, Object> duplicateMap = new HashMap<String, Object>();
		boolean duplicateFlag = aServiceApprovalServiceImpl.DuplicateCheck(id);
		duplicateMap.put("duplicateCheck", duplicateFlag);
		return duplicateMap;
	}

	/**
	 * (관리자)회원삭제
	 * 
	 * @param svo
	 * @return
	 */
	@RequestMapping("/Admin/delete/AdminDelete.app")
	public Map<String, Object> adminDelete(@ModelAttribute("svo") SearchVO svo) {
		Map<String, Object> adminDelMap = new HashMap<String, Object>();
		List<UserVO> userList = aServiceApprovalServiceImpl.memberList(svo);
		adminDelMap.put("memberlist", userList);
		return adminDelMap;
	}

	@RequestMapping("/Admin/delete/AdminDeleteActivate.app")
	public Map<String, Object> DelMember(@ModelAttribute("uvo") UserVO uservo) {
		Map<String, Object> adminDelMap = new HashMap<String, Object>();

		boolean delFlag = aServiceApprovalServiceImpl.DelMember(uservo);
		adminDelMap.put("memberDel", delFlag);
		return adminDelMap;
	}

	/**
	 * 결제 기능
	 * 
	 * @param model
	 * @param pvo
	 * @return
	 */
	@RequestMapping(value = "/PayFunction.app", method = RequestMethod.POST)
	public ModelAndView payFunction(@ModelAttribute("pvo") PayVO pvo) {

		ModelAndView payview = new ModelAndView();
		boolean payinsertFlag = aServiceApprovalServiceImpl.PayInsert(pvo);
		
		payview.addObject("payinsert", payinsertFlag);
	
		payview.addObject("payRegularUser", pvo.getRegularUser());
		payview.addObject("payunRegularUser", pvo.getUnRegularUser());
		payview.addObject("paySelector", pvo.getPaySelector());
		payview.addObject("saveUnpay", pvo.getSaveUnpay());
			
		payview.setViewName("/PayFunction/PayFunction");
		return payview;
	}

}