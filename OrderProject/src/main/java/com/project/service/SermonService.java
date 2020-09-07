package com.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.project.vo.SearchVO;
import com.project.vo.SermonVO;

interface SermonService {

	List<SermonVO> sundaySermonList(SearchVO svo);

	int sundaySermonInsert(Map<String, Object> map, HttpServletRequest req) throws Exception;

	int sundaySermonUpdate(Map<String, Object> map, HttpServletRequest req) throws Exception;

	int sundaySermonDelete(SermonVO svo);
}