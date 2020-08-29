package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.vo.UserVO;

public class Interceptor extends HandlerInterceptorAdapter {

	private Logger interceptorLog = LoggerFactory.getLogger(this.getClass());

	/**
	 * 컨트롤러 접근 전
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String id = request.getParameter("duplicateid");
		String pw = request.getParameter("pass1");

		UserVO uvo = new UserVO(id, pw);

		interceptorLog.info("=======================");
		interceptorLog.info("인터셉터 탔음.");
		interceptorLog.info("=======================");
		if ((uvo.getDuplicateid().equals("logos")) && (uvo.getPass1().equals("popos"))) {
			interceptorLog.info("=======================");
			interceptorLog.info("관리자확인: " + uvo.getDuplicateid() + " , " + uvo.getPass1());
			interceptorLog.info("=======================");
			return true;
		} else if ((uvo.getDuplicateid() != null) && (uvo.getPass1() != null)) {
			interceptorLog.info("============================================================");
			interceptorLog.info("일반계정 확인: " + uvo.getDuplicateid() + " , " + uvo.getPass1());
			interceptorLog.info("============================================================");
			return true;
		} else {
			return false;
		}
	}// end of preHandle()

	/**
	 * 컨트롤러 접근 후
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HttpSession session = request.getSession();
		if (preHandle(request, response, handler)) {
			session.setAttribute("admin", "운영자");
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
