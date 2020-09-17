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

	// 철야기도회 설교
	List<SermonVO> chulyaSermonList(SearchVO svo);

	int chulyaSermonInsert(SermonVO svo);

	int chulyaSermonUpdate(SermonVO svo);

	int chulyaSermonDelete(SermonVO svo);

	// 심방설교
	List<SermonVO> simbangSermonList(SearchVO svo);

	int simbangSermonInsert(SermonVO svo);

	int simbangSermonUpdate(SermonVO svo);

	int simbangSermonDelete(SermonVO svo);

	// 헌신설교
	List<SermonVO> hunshinSermonList(SearchVO svo);

	int hunshinSermonInsert(SermonVO svo);

	int hunshinSermonUpdate(SermonVO svo);

	int hunshinSermonDelete(SermonVO svo);

	// 특별설교
	List<SermonVO> specialSermonList(SearchVO svo);

	int specialSermonInsert(SermonVO svo);

	int specialSermonUpdate(SermonVO svo);

	int specialSermonDelete(SermonVO svo);

	// 컬럼형예화 설교
	List<SermonVO> columnSermonList(SearchVO svo);

	int columnSermonInsert(SermonVO svo);

	int columnSermonUpdate(SermonVO svo);

	int columnSermonDelete(SermonVO svo);
}// end of interface