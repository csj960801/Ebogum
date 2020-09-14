package com.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.project.vo.SearchVO;
import com.project.vo.SermonVO;

interface SermonService {
	// 주일 설교
	List<SermonVO> sundaySermonList(SearchVO svo);

	int sundaySermonInsert(SermonVO svo);

	int sundaySermonUpdate(SermonVO svo);

	int sundaySermonDelete(SermonVO svo);

	int sundaySermonPoint(Map<String, Object> paramMap);

	// 강해 설교
	List<SermonVO> ganghaeSermonList(SearchVO svo);

	int ganghaeSermonInsert(SermonVO svo);

	int ganghaeSermonUpdate(SermonVO svo);

	int ganghaeSermonDelete(SermonVO svo);

	// 인물 설교
	List<SermonVO> personSermonList(SearchVO svo);

	int personSermonInsert(SermonVO svo);

	int personSermonUpdate(SermonVO svo);

	int personSermonDelete(SermonVO svo);

}// end of interface