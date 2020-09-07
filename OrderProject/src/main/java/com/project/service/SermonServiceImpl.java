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
	public int sundaySermonInsert(Map<String, Object> map, HttpServletRequest req) throws Exception {
		int sundayinsertFlag = sermondao.sundaySermonInsert(map);

		List<Map<String, Object>> list = FileUtils.parseInsertFileInfo(map, req);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			sermondao.sundaySermonInsert(list.get(i));
			log.info("==================================");
			log.info("설교 저장 데이터: " + list.get(i));
			log.info("==================================");
		}
		return sundayinsertFlag;
	}

	@Override
	public int sundaySermonUpdate(Map<String, Object> map, HttpServletRequest req) throws Exception {
		int sundayupdateFlag = sermondao.sundaySermonUpdate(map);

		List<Map<String, Object>> list = FileUtils.parseInsertFileInfo(map, req);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			sermondao.sundaySermonUpdate(list.get(i));
			log.info("==================================");
			log.info("설교 수정 데이터: " + list.get(i));
			log.info("==================================");
		}
		return sundayupdateFlag;
	}

	@Override
	public int sundaySermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.sundaySermonDelete(svo);
	}
}