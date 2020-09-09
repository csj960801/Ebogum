package com.project.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.dao.SermonDAO;
import com.project.util.FileUtils;
import com.project.vo.SearchVO;
import com.project.vo.SermonVO;

@Service("com.project.service.SermonService")
public class SermonServiceImpl implements SermonService {

	@Autowired
	private SermonDAO sermondao;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 주일 설교 리스트
	 */
	@Override
	public List<SermonVO> sundaySermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.sundaySermonList(svo);
	}

	/**
	 * 주일 설교 데이터 저장
	 * 
	 * @throws Exception
	 */
	@Override
	public int sundaySermonInsert(SermonVO svo) {
		int sundayinsertFlag = sermondao.sundaySermonInsert(svo);
		return sundayinsertFlag;
	}

	/**
	 * 주일 설교 데이터 수정
	 */
	@Override
	public int sundaySermonUpdate(SermonVO svo) {
		int sundayupdateFlag = sermondao.sundaySermonUpdate(svo);
		return sundayupdateFlag;
	}

	/**
	 * 주일 설교 데이터 삭제
	 */
	@Override
	public int sundaySermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.sundaySermonDelete(svo);
	}

	/**
	 * 파일 다운로드 시 다운로드 받은 파일의 포인트만큼 회원의 포인트 감소
	 */
	@Override
	public int sundaySermonPoint(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sermondao.sundaySermonUserPoint(paramMap);
	}

	/**
	 * 강해 설교 리스트
	 */
	@Override
	public List<SermonVO> ganghaeSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.ganghaeSermonList(svo);
	}

	/**
	 * 강해 설교 데이터 저장
	 */
	@Override
	public int ganghaeSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.ganghaeSermonInsert(svo);
	}
	
	/**
	 * 강해 설교 데이터 수정
	 */
	@Override
	public int ganghaeSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.ganghaeSermonUpdate(svo);
	}
	
	/**
	 * 강해 설교 데이터 삭제
	 */
	@Override
	public int ganghaeSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.ganghaeSermonDelete(svo);
	}
}