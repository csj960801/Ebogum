package com.project._SermonController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
	public ModelAndView download(@RequestParam HashMap<Object, Object> params, @RequestParam("userPoint") String point,
			@RequestParam("duplicateid") String id, Map<String, Object> paramMap, ModelAndView mv) {

		String FILE_SERVER_PATH = "C:/SermonFile";
		String fileName = (String) params.get("fileName");
		String fullPath = FILE_SERVER_PATH + "/" + fileName;

		File file = new File(fullPath);

		// Map으로 포인트와 회원명을 입력받아서 myBatis에 값을 대입한다.
		paramMap.put("point", Integer.parseInt(point));
		paramMap.put("duplicateid", id);

		int sermonPoint = sermonservice.sundaySermonPoint(paramMap);
		if (sermonPoint > 0) {
			mv.addObject("pointEffect", sermonPoint);
		}

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

	/**
	 * 강해 설교 리스트
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/Ganghae/GanghaeSermon.sermon")
	public List<SermonVO> gangaeSermonList(Model model, @ModelAttribute("svo") SearchVO svo,
			HttpServletRequest request) {
		List<SermonVO> fileboardList = sermonservice.ganghaeSermonList(svo);
		model.addAttribute("GanghaeSermonlist", fileboardList);

		if (fileboardList.size() > 0) {
			sermonLog.info("==========================");
			sermonLog.info("강해설교 " + fileboardList.size() + "데이터 존재합니다");
			sermonLog.info("==========================");
		}
		return fileboardList;
	}

	/**
	 * 강해 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Ganghae/GanghaeSermonInsert.sermon")
	public Map<String, Object> GanghaeSermonInsert(@RequestParam("sermonFile") MultipartFile multi,
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

		int ganghaensert = sermonservice.ganghaeSermonInsert(svo);
		fileMap.put("ganghaeinsert", ganghaensert);

		if (ganghaensert > 0) {
			sermonLog.info("==========================");
			sermonLog.info("강해설교 데이터 저장 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 강해 설교 데이터 수정
	 * 
	 * @param svo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Ganghae/GanghaeSermonUpdate.sermon")
	public Map<String, Object> GanghaeSermonUpdate(@RequestParam("sermonFile") MultipartFile multi,
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

		int ganghaeupdate = sermonservice.ganghaeSermonUpdate(svo);
		fileMap.put("ganghaeupdate", ganghaeupdate);
		if (ganghaeupdate > 0) {
			sermonLog.info("==========================");
			sermonLog.info("강해 설교 데이터 수정 되었습니다.");
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
	@RequestMapping("/Ganghae/GanghaeSermonDelete.sermon")
	public Map<String, Object> GanghaeSermonDelete(SermonVO svo) {
		Map<String, Object> delMap = new HashMap<String, Object>();
		int ganghaedel = sermonservice.ganghaeSermonDelete(svo);
		delMap.put("ganghaedel", ganghaedel);
		return delMap;
	}
	
}