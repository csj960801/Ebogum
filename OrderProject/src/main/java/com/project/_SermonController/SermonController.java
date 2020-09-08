package com.project._SermonController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.SermonServiceImpl;
import com.project.vo.SearchVO;
import com.project.vo.SermonVO;

@Controller
@RequestMapping("/sermon")
public class SermonController {

	@Autowired
	private SermonServiceImpl sermonservice;

	private Logger sermonLog = LoggerFactory.getLogger(this.getClass());

	/**
	 * 설교파일 다운로드
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/Sunday/SermonFiledownload.sermon")
	public ModelAndView download(@RequestParam HashMap<Object, Object> params, ModelAndView mv) {
		String FILE_SERVER_PATH = "C:/test";
		String fileName = (String) params.get("fileName");
		String fullPath = FILE_SERVER_PATH + "/" + fileName;

		File file = new File(fullPath);

		// BeanNameViewResolver
		mv.setViewName("downloadView");
		mv.addObject("downloadFile", file);
		return mv;
	}

	/**
	 * 주일 설교 리스트 출력
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/Sunday/SundaySermon.sermon")
	public List<SermonVO> FileBoard(Model model, @ModelAttribute("svo") SearchVO svo, HttpServletRequest request)
			throws IOException {
		List<SermonVO> fileboardList = sermonservice.sundaySermonList(svo);
		model.addAttribute("SundaySermonlist", fileboardList);

		if (fileboardList.size() > 0) {
			sermonLog.info("==========================");
			sermonLog.info("설교 " + fileboardList.size() + "데이터 존재합니다");
			sermonLog.info("==========================");
		}

		return fileboardList;
	}

	/**
	 * 주일 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Sunday/SundaySermonInsert.sermon")
	public Map<String, Object> SundaySermonInsert(@RequestParam("sermonFile") MultipartFile multi,
			HttpServletRequest request) throws Exception {
		Map<String, Object> fileMap = new HashMap<String, Object>();

		// 파일이 저장되어있는 곳 경로 입력
		String filePath = "";

		String subject = request.getParameter("sermonSubject");
		String title = request.getParameter("sermonTitle");
		String main = request.getParameter("sermonMain");
		String page = request.getParameter("sermonPage");
		String point = request.getParameter("sermonPoint");
		String date = request.getParameter("sermonDate");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date);

		int sundayinsert = sermonservice.sundaySermonInsert(svo);
		fileMap.put("sundayinsert", sundayinsert);

		if (sundayinsert > 0) {
			sermonLog.info("==========================");
			sermonLog.info("설교 데이터 저장 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 주일 설교 데이터 수정
	 * 
	 * @param svo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Sunday/SundaySermonUpdate.sermon")
	public Map<String, Object> SundaySermonUpdate(@RequestParam("sermonFile") MultipartFile multi,
			HttpServletRequest request) throws Exception {

		Map<String, Object> fileMap = new HashMap<String, Object>();

		String subject = request.getParameter("sermonSubject");
		String title = request.getParameter("sermonTitle");
		String main = request.getParameter("sermonMain");
		String page = request.getParameter("sermonPage");
		String point = request.getParameter("sermonPoint");
		String date = request.getParameter("sermonDate");
		String cnt = request.getParameter("sermonCnt");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, cnt);

		int sundayupdate = sermonservice.sundaySermonUpdate(svo);
		fileMap.put("sundayupdate", sundayupdate);
		if (sundayupdate > 0) {
			sermonLog.info("==========================");
			sermonLog.info("설교 데이터 수정 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 주일설교 데이터 삭제
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/Sunday/SundaySermonDelete.sermon")
	public Map<String, Object> SundaySermonDelete(SermonVO svo) {
		Map<String, Object> delMap = new HashMap<String, Object>();
		int sundaydel = sermonservice.sundaySermonDelete(svo);
		delMap.put("sundaydelete", sundaydel);
		return delMap;
	}

}