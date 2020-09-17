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
	 * 전체 설교파일 다운로드
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/SermonFiledownload.sermon")
	public ModelAndView download(@RequestParam HashMap<Object, Object> params, @RequestParam("userPoint") String point,
			@RequestParam("duplicateid") String id, @RequestParam("sermonType") String sermonType,
			Map<String, Object> paramMap, ModelAndView mv) {

		// sermonType변수로 받은 설교 타입에 해당하는 파일 경로 생성
		StringBuffer FILE_SERVER_PATH = new StringBuffer("C:/SermonFile");
		switch (sermonType) {
		case "sunday":
			FILE_SERVER_PATH.append("/sunday");
			break;
		case "ganghae":
			FILE_SERVER_PATH.append("/ganghae");
			break;
		case "person":
			FILE_SERVER_PATH.append("/person");
			break;
		case "chulya":
			FILE_SERVER_PATH.append("/chulya");
			break;
		case "simbang":
			FILE_SERVER_PATH.append("/simbang");
			break;
		case "hunshin":
			FILE_SERVER_PATH.append("/hunshin");
			break;
		case "special":
			FILE_SERVER_PATH.append("/special");
			break;
		}

		String fileName = (String) params.get("fileName");
		String fullPath = FILE_SERVER_PATH.toString() + "/" + fileName;

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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, bibleType);

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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, cnt,
				bibleType);

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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, bibleType);

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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, cnt,
				bibleType);

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
	 * 강해설교 데이터 삭제
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

	/**
	 * 인물 설교 리스트
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/Person/PersonSermon.sermon")
	public List<SermonVO> personSermonList(Model model, @ModelAttribute("svo") SearchVO svo,
			HttpServletRequest request) {
		List<SermonVO> fileboardList = sermonservice.personSermonList(svo);
		model.addAttribute("PersonSermonlist", fileboardList);
		if (fileboardList.size() > 0) {
			sermonLog.info("==========================");
			sermonLog.info("인물설교 " + fileboardList.size() + "데이터 존재합니다");
			sermonLog.info("==========================");
		}

		return fileboardList;
	}

	/**
	 * 인물 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Person/PersonSermonInsert.sermon")
	public Map<String, Object> PersonSermonInsert(@RequestParam("sermonFile") MultipartFile multi,
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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, bibleType);

		int personinsert = sermonservice.personSermonInsert(svo);
		fileMap.put("personinsert", personinsert);

		if (personinsert > 0) {
			sermonLog.info("==========================");
			sermonLog.info("인물설교 데이터 저장 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 인물 설교 데이터 수정
	 * 
	 * @param svo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Person/PersonSermonUpdate.sermon")
	public Map<String, Object> PersonSermonUpdate(@RequestParam("sermonFile") MultipartFile multi,
			HttpServletRequest request) throws Exception {

		Map<String, Object> fileMap = new HashMap<String, Object>();

		String subject = request.getParameter("sermonSubject");
		String title = request.getParameter("sermonTitle");
		String main = request.getParameter("sermonMain");
		String page = request.getParameter("sermonPage");
		String point = request.getParameter("sermonPoint");
		String date = request.getParameter("sermonDate");
		String cnt = request.getParameter("sermonCnt");
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, cnt,
				bibleType);

		int personupdate = sermonservice.personSermonUpdate(svo);
		fileMap.put("personupdate", personupdate);
		if (personupdate > 0) {
			sermonLog.info("==========================");
			sermonLog.info("인물 설교 데이터 수정 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 인물설교 데이터 삭제
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/Person/PersonSermonDelete.sermon")
	public Map<String, Object> PersonSermonDelete(SermonVO svo) {
		Map<String, Object> delMap = new HashMap<String, Object>();
		int persondel = sermonservice.personSermonDelete(svo);
		delMap.put("persondel", persondel);
		return delMap;
	}

	/**
	 * 철야기도 설교 리스트
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/Chulya/ChulyaSermon.sermon")
	public List<SermonVO> chulyaSermonList(Model model, @ModelAttribute("svo") SearchVO svo,
			HttpServletRequest request) {
		List<SermonVO> fileboardList = sermonservice.chulyaSermonList(svo);
		model.addAttribute("ChulyaSermonlist", fileboardList);
		if (fileboardList.size() > 0) {
			sermonLog.info("==========================");
			sermonLog.info("철야설교 " + fileboardList.size() + "데이터 존재합니다");
			sermonLog.info("==========================");
		}

		return fileboardList;
	}

	/**
	 * 철야 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Chulya/ChulyaSermonInsert.sermon")
	public Map<String, Object> chulyaSermonInsert(@RequestParam("sermonFile") MultipartFile multi,
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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, bibleType);

		int chulyainsert = sermonservice.chulyaSermonInsert(svo);
		fileMap.put("chulyainsert", chulyainsert);

		if (chulyainsert > 0) {
			sermonLog.info("==========================");
			sermonLog.info("철야설교 데이터 저장 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 철야 설교 데이터 수정
	 * 
	 * @param svo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Chulya/ChulyaSermonUpdate.sermon")
	public Map<String, Object> ChulyaSermonUpdate(@RequestParam("sermonFile") MultipartFile multi,
			HttpServletRequest request) throws Exception {

		Map<String, Object> fileMap = new HashMap<String, Object>();

		String subject = request.getParameter("sermonSubject");
		String title = request.getParameter("sermonTitle");
		String main = request.getParameter("sermonMain");
		String page = request.getParameter("sermonPage");
		String point = request.getParameter("sermonPoint");
		String date = request.getParameter("sermonDate");
		String cnt = request.getParameter("sermonCnt");
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, cnt,
				bibleType);

		int chulyaupdate = sermonservice.chulyaSermonUpdate(svo);
		fileMap.put("chulyaupdate", chulyaupdate);
		if (chulyaupdate > 0) {
			sermonLog.info("==========================");
			sermonLog.info("철야 설교 데이터 수정 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 철야설교 데이터 삭제
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/Chulya/ChulyaSermonDelete.sermon")
	public Map<String, Object> ChulyaSermonDelete(SermonVO svo) {
		Map<String, Object> delMap = new HashMap<String, Object>();
		int chulyadel = sermonservice.chulyaSermonDelete(svo);
		delMap.put("chulyadel", chulyadel);
		return delMap;
	}

	/**
	 * 심방 설교 리스트
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/Simbang/SimbangSermon.sermon")
	public List<SermonVO> simbangSermonList(Model model, @ModelAttribute("svo") SearchVO svo,
			HttpServletRequest request) {
		List<SermonVO> fileboardList = sermonservice.simbangSermonList(svo);
		model.addAttribute("SimbangSermonlist", fileboardList);
		if (fileboardList.size() > 0) {
			sermonLog.info("==========================");
			sermonLog.info("심방설교 " + fileboardList.size() + "데이터 존재합니다");
			sermonLog.info("==========================");
		}

		return fileboardList;
	}

	/**
	 * 심방 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Simbang/SimbangSermonInsert.sermon")
	public Map<String, Object> SimbangSermonInsert(@RequestParam("sermonFile") MultipartFile multi,
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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, bibleType);

		int simbanginsert = sermonservice.simbangSermonInsert(svo);
		fileMap.put("simbanginsert", simbanginsert);

		if (simbanginsert > 0) {
			sermonLog.info("==========================");
			sermonLog.info("심방설교 데이터 저장 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 심방 설교 데이터 수정
	 * 
	 * @param svo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Simbang/SimbangSermonUpdate.sermon")
	public Map<String, Object> SimbangSermonUpdate(@RequestParam("sermonFile") MultipartFile multi,
			HttpServletRequest request) throws Exception {

		Map<String, Object> fileMap = new HashMap<String, Object>();

		String subject = request.getParameter("sermonSubject");
		String title = request.getParameter("sermonTitle");
		String main = request.getParameter("sermonMain");
		String page = request.getParameter("sermonPage");
		String point = request.getParameter("sermonPoint");
		String date = request.getParameter("sermonDate");
		String cnt = request.getParameter("sermonCnt");
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, cnt,
				bibleType);

		int simbangupdate = sermonservice.simbangSermonUpdate(svo);
		fileMap.put("simbangupdate", simbangupdate);
		if (simbangupdate > 0) {
			sermonLog.info("==========================");
			sermonLog.info("심방 설교 데이터 수정 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 심방설교 데이터 삭제
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/Simbang/SimbangSermonDelete.sermon")
	public Map<String, Object> SimbangSermonDelete(SermonVO svo) {
		Map<String, Object> delMap = new HashMap<String, Object>();
		int simbangdel = sermonservice.simbangSermonDelete(svo);
		delMap.put("simbangdel", simbangdel);
		return delMap;
	}

	/**
	 * 헌신 설교 리스트
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/Hunshin/HunshinSermon.sermon")
	public List<SermonVO> HunshinSermonList(Model model, @ModelAttribute("svo") SearchVO svo,
			HttpServletRequest request) {
		List<SermonVO> fileboardList = sermonservice.hunshinSermonList(svo);
		model.addAttribute("HunshinSermonlist", fileboardList);
		if (fileboardList.size() > 0) {
			sermonLog.info("==========================");
			sermonLog.info("헌신설교 " + fileboardList.size() + "데이터 존재합니다");
			sermonLog.info("==========================");
		}

		return fileboardList;
	}

	/**
	 * 헌신 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Hunshin/HunshinSermonInsert.sermon")
	public Map<String, Object> HunshinSermonInsert(@RequestParam("sermonFile") MultipartFile multi,
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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, bibleType);

		int hunshininsert = sermonservice.hunshinSermonInsert(svo);
		fileMap.put("hunshininsert", hunshininsert);

		if (hunshininsert > 0) {
			sermonLog.info("==========================");
			sermonLog.info("헌신설교 데이터 저장 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 헌신 설교 데이터 수정
	 * 
	 * @param svo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Hunshin/HunshinSermonUpdate.sermon")
	public Map<String, Object> HunshinSermonUpdate(@RequestParam("sermonFile") MultipartFile multi,
			HttpServletRequest request) throws Exception {

		Map<String, Object> fileMap = new HashMap<String, Object>();

		String subject = request.getParameter("sermonSubject");
		String title = request.getParameter("sermonTitle");
		String main = request.getParameter("sermonMain");
		String page = request.getParameter("sermonPage");
		String point = request.getParameter("sermonPoint");
		String date = request.getParameter("sermonDate");
		String cnt = request.getParameter("sermonCnt");
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, cnt,
				bibleType);

		int hunshinupdate = sermonservice.hunshinSermonUpdate(svo);
		fileMap.put("hunshinupdate", hunshinupdate);
		if (hunshinupdate > 0) {
			sermonLog.info("==========================");
			sermonLog.info("헌신 설교 데이터 수정 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 헌신설교 데이터 삭제
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/Hunshin/HunshinSermonDelete.sermon")
	public Map<String, Object> HunshinSermonDelete(SermonVO svo) {
		Map<String, Object> delMap = new HashMap<String, Object>();
		int hunshindel = sermonservice.hunshinSermonDelete(svo);
		delMap.put("hunshindel", hunshindel);
		return delMap;
	}

	/**
	 * 특별 설교 리스트
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/Special/SpecialSermon.sermon")
	public List<SermonVO> SpecialSermonList(Model model, @ModelAttribute("svo") SearchVO svo,
			HttpServletRequest request) {
		List<SermonVO> fileboardList = sermonservice.specialSermonList(svo);
		model.addAttribute("SpecialSermonlist", fileboardList);
		if (fileboardList.size() > 0) {
			sermonLog.info("==========================");
			sermonLog.info("특별설교 " + fileboardList.size() + "데이터 존재합니다");
			sermonLog.info("==========================");
		}

		return fileboardList;
	}

	/**
	 * 특별 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Special/SpecialSermonInsert.sermon")
	public Map<String, Object> SpecialSermonInsert(@RequestParam("sermonFile") MultipartFile multi,
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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, bibleType);

		int specialinsert = sermonservice.specialSermonInsert(svo);
		fileMap.put("specialinsert", specialinsert);

		if (specialinsert > 0) {
			sermonLog.info("==========================");
			sermonLog.info("특별설교 데이터 저장 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 특별 설교 데이터 수정
	 * 
	 * @param svo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Special/SpecialSermonUpdate.sermon")
	public Map<String, Object> SpecialSermonUpdate(@RequestParam("sermonFile") MultipartFile multi,
			HttpServletRequest request) throws Exception {

		Map<String, Object> fileMap = new HashMap<String, Object>();

		String subject = request.getParameter("sermonSubject");
		String title = request.getParameter("sermonTitle");
		String main = request.getParameter("sermonMain");
		String page = request.getParameter("sermonPage");
		String point = request.getParameter("sermonPoint");
		String date = request.getParameter("sermonDate");
		String cnt = request.getParameter("sermonCnt");
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, cnt,
				bibleType);

		int specialupdate = sermonservice.specialSermonUpdate(svo);
		fileMap.put("specialupdate", specialupdate);
		if (specialupdate > 0) {
			sermonLog.info("==========================");
			sermonLog.info("특별설교 데이터 수정 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 특별 설교 데이터 삭제
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/Special/SpecialSermonDelete.sermon")
	public Map<String, Object> SpecialSermonDelete(SermonVO svo) {
		Map<String, Object> delMap = new HashMap<String, Object>();
		int specialdel = sermonservice.specialSermonDelete(svo);
		delMap.put("specialdel", specialdel);
		return delMap;
	}

	/**
	 * 컬럼형예화 설교 리스트
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/Column/ColumnSermon.sermon")
	public List<SermonVO> ColumnSermonList(Model model, @ModelAttribute("svo") SearchVO svo,
			HttpServletRequest request) {
		List<SermonVO> fileboardList = sermonservice.columnSermonList(svo);
		model.addAttribute("ColumnSermonlist", fileboardList);
		if (fileboardList.size() > 0) {
			sermonLog.info("==========================");
			sermonLog.info("컬럼형예화설교 " + fileboardList.size() + "데이터 존재합니다");
			sermonLog.info("==========================");
		}

		return fileboardList;
	}

	/**
	 * 컬럼형예화 설교 데이터 저장
	 * 
	 * @param svo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Column/ColumnSermonInsert.sermon")
	public Map<String, Object> ColumnSermonInsert(@RequestParam("sermonFile") MultipartFile multi,
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
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, bibleType);

		int columninsert = sermonservice.columnSermonInsert(svo);
		fileMap.put("columninsert", columninsert);

		if (columninsert > 0) {
			sermonLog.info("==========================");
			sermonLog.info("컬럼형예화설교 데이터 저장 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 컬럼형예화 설교 데이터 수정
	 * 
	 * @param svo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/Column/ColumnSermonUpdate.sermon")
	public Map<String, Object> ColumnSermonUpdate(@RequestParam("sermonFile") MultipartFile multi,
			HttpServletRequest request) throws Exception {

		Map<String, Object> fileMap = new HashMap<String, Object>();

		String subject = request.getParameter("sermonSubject");
		String title = request.getParameter("sermonTitle");
		String main = request.getParameter("sermonMain");
		String page = request.getParameter("sermonPage");
		String point = request.getParameter("sermonPoint");
		String date = request.getParameter("sermonDate");
		String cnt = request.getParameter("sermonCnt");
		String bibleType = request.getParameter("sermonBibleType");

		SermonVO svo = new SermonVO(subject, title, main, page, point, multi.getOriginalFilename(), date, cnt,
				bibleType);

		int columnupdate = sermonservice.columnSermonUpdate(svo);
		fileMap.put("columnupdate", columnupdate);
		if (columnupdate > 0) {
			sermonLog.info("==========================");
			sermonLog.info("컬럼형예화설교 데이터 수정 되었습니다.");
			sermonLog.info("==========================");
		}

		return fileMap;
	}

	/**
	 * 컬럼형예화 설교 데이터 삭제
	 * 
	 * @param svo
	 * @param request
	 * @return
	 */
	@RequestMapping("/Column/ColumnSermonDelete.sermon")
	public Map<String, Object> ColumnSermonDelete(SermonVO svo) {
		Map<String, Object> delMap = new HashMap<String, Object>();
		int columndel = sermonservice.columnSermonDelete(svo);
		delMap.put("columndel", columndel);
		return delMap;
	}

}