package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.ApprovalServiceImpl;
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
		controllerLog.info("========================");
		controllerLog.info(loginvo.getDuplicateid());
		controllerLog.info(loginvo.getPass1());
		controllerLog.info("========================");

		if (lvo) {
			session.setAttribute("login", loginvo.getDuplicateid());
			model.addObject("loginFlag", lvo);
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
		if(usvo != null) {
			findInfoMap.put("findId", usvo.getDuplicateid());
	        findInfoMap.put("findPw", usvo.getPass1());	      	
		}
		   
		return findInfoMap;
	}
	
	/**
	 * 아이디 중복검사
	 * @param id
	 * @return
	 */
	@RequestMapping("/DuplicateCheck/DuplicateCheck.app")
	public Map<String, Object> CheckDuplicateId(@RequestParam("id") String id){
		Map<String, Object> duplicateMap = new HashMap<String, Object>();
	    boolean duplicateFlag = aServiceApprovalServiceImpl.DuplicateCheck(id);
		duplicateMap.put("duplicateCheck", duplicateFlag); 	
		return duplicateMap;
	}
}