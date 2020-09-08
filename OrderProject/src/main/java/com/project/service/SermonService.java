package com.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.project.vo.SearchVO;
import com.project.vo.SermonVO;

interface SermonService {

	List<SermonVO> sundaySermonList(SearchVO svo);

	int sundaySermonInsert(SermonVO svo);

	int sundaySermonUpdate(SermonVO svo);

	int sundaySermonDelete(SermonVO svo);
}