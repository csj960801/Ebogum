package com.project._SermonController;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	private static final String FILE_SERVER_PATH = "C:/test";

	/**
	 * 설교파일 다운로드
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/SermonFiledownload.sermon")
	public ModelAndView download(@RequestParam HashMap<Object, Object> params, ModelAndView mv) {
		String fileName = (String) params.get("fileName");
		String fullPath = FILE_SERVER_PATH + "/" + fileName;
	
		File file = new File(fullPath);
		
		mv.setViewName("downloadView");
		mv.addObject("downloadFile", file);
		return mv;
	}

	/**
	 * 주일 설교 리스트 출력
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/SundaySermon.sermon")
	public List<SermonVO> FileBoard(Model model, @ModelAttribute("svo") SearchVO svo) {
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
	@RequestMapping("/SundaySermonInsert.sermon")
	public Map<String, Object> SundaySermonInsert(SermonVO svo, HttpServletRequest request) throws Exception {
		Map<String, Object> fileMap = new HashMap<String, Object>();

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;

		String filePath = "C:\\";// 가지고 올 파일경로
		String originalFileName = null;

		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());

			if (!multipartFile.isEmpty()) {
				originalFileName = multipartFile.getOriginalFilename();
				File file = new File(filePath + originalFileName);

				System.out.println(file.getPath());

				/*
				 * file.getParentFile().mkdir(); if (!file.exists()) { file.createNewFile(); }
				 */
				fileMap.put("sermonFileName", originalFileName); // 업로드할 파일명
			}
		}

		fileMap.put("sermonSubject", svo.getSermonSubject());
		fileMap.put("sermonTitle", svo.getSermonTitle());
		fileMap.put("sermonMain", svo.getSermonMain());
		fileMap.put("sermonPage", svo.getSermonPage());
		fileMap.put("sermonPoint", svo.getSermonPoint());
		fileMap.put("sermonDate", svo.getSermonDate());

		int sundayinsert = sermonservice.sundaySermonInsert(fileMap, request);
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
	@RequestMapping("/SundaySermonUpdate.sermon")
	public Map<String, Object> SundaySermonUpdate(SermonVO svo, HttpServletRequest request) throws Exception {
		Map<String, Object> fileMap = new HashMap<String, Object>();

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;

		// String filePath = "C:\\";// 가지고 올 파일경로
		String originalFileName = null;

		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());

			if (!multipartFile.isEmpty()) {
				originalFileName = multipartFile.getOriginalFilename();
				fileMap.put("sermonFileName", originalFileName); // 업로드할 파일명
			}
		}

		fileMap.put("sermonSubject", svo.getSermonSubject());
		fileMap.put("sermonTitle", svo.getSermonTitle());
		fileMap.put("sermonMain", svo.getSermonMain());
		fileMap.put("sermonPage", svo.getSermonPage());
		fileMap.put("sermonPoint", svo.getSermonPoint());
		fileMap.put("sermonDate", svo.getSermonDate());
		fileMap.put("sermonCnt", svo.getSermonCnt());

		int sundayupdate = sermonservice.sundaySermonUpdate(fileMap, request);
		fileMap.put("sundayupdate", sundayupdate);
		if (sundayupdate > 0) {
			sermonLog.info("==========================");
			sermonLog.info("설교 데이터 저장 되었습니다.");
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
	@RequestMapping("/SundaySermonDelete.sermon")
	public Map<String, Object> SundaySermonDelete(SermonVO svo) {
		Map<String, Object> delMap = new HashMap<String, Object>();
		int sundaydel = sermonservice.sundaySermonDelete(svo);
		delMap.put("sundaydelete", sundaydel);
		return delMap;
	}

}