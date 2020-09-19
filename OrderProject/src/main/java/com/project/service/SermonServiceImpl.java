package com.project.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dao.SermonDAO;
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

	/**
	 * 인물설교 리스트 출력
	 */
	@Override
	public List<SermonVO> personSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.personSermonList(svo);
	}

	/**
	 * 인물설교 데이터 저장
	 */
	@Override
	public int personSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.personSermonInsert(svo);
	}

	/**
	 * 인물설교 데이터 수정
	 */
	@Override
	public int personSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.personSermonUpdate(svo);
	}

	/**
	 * 인물설교 데이터 삭제
	 */
	@Override
	public int personSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.personSermonDelete(svo);
	}

	/**
	 * 철야설교 리스트
	 */
	@Override
	public List<SermonVO> chulyaSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.chulyaSermonList(svo);
	}

	/**
	 * 철야설교 데이터 저장
	 */
	@Override
	public int chulyaSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.chulyaSermonInsert(svo);
	}

	/**
	 * 철야설교 데이터 수정
	 */
	@Override
	public int chulyaSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.chulyaSermonUpdate(svo);
	}

	/**
	 * 철야설교 데이터 삭제
	 */
	@Override
	public int chulyaSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.chulyaSermonDelete(svo);
	}

	/**
	 * 심방설교 리스트
	 */
	@Override
	public List<SermonVO> simbangSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.simbangSermonList(svo);
	}

	/**
	 * 심방설교 데이터 저장
	 */
	@Override
	public int simbangSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.simbangSermonInsert(svo);
	}

	/**
	 * 심방설교 데이터 수정
	 */
	@Override
	public int simbangSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.simbangSermonUpdate(svo);
	}

	/**
	 * 심방설교 데이터 삭제
	 */
	@Override
	public int simbangSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.simbangSermonDelete(svo);
	}

	/**
	 * 헌신설교 리스트
	 */
	@Override
	public List<SermonVO> hunshinSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.hunshinSermonList(svo);
	}

	/**
	 * 헌신설교 데이터 저장
	 */
	@Override
	public int hunshinSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.hunshinSermonInsert(svo);
	}

	/**
	 * 헌신설교 데이터 수정
	 */
	@Override
	public int hunshinSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.hunshinSermonUpdate(svo);
	}

	/**
	 * 헌신설교 데이터 삭제
	 */
	@Override
	public int hunshinSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.hunshinSermonDelete(svo);
	}

	/**
	 * 특별설교 리스트
	 */
	@Override
	public List<SermonVO> specialSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.specialSermonList(svo);
	}

	/**
	 * 특별설교 데이터 저장
	 */
	@Override
	public int specialSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.specialSermonInsert(svo);
	}

	/**
	 * 특별설교 데이터 수정
	 */
	@Override
	public int specialSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.specialSermonUpdate(svo);
	}

	/**
	 * 특별설교 데이터 삭제
	 */
	@Override
	public int specialSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.specialSermonDelete(svo);
	}

	/**
	 * 컬럼형예화 리스트
	 */
	@Override
	public List<SermonVO> columnSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.columnSermonList(svo);
	}

	/**
	 * 컬럼형예화 데이터 저장
	 */
	@Override
	public int columnSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.columnSermonInsert(svo);
	}

	/**
	 * 컬럼형예화 데이터 수정
	 */
	@Override
	public int columnSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.columnSermonUpdate(svo);
	}

	/**
	 * 컬럼형예화 데이터 삭제
	 */
	@Override
	public int columnSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.columnSermonDelete(svo);
	}

	/**
	 * 새벽 강해별 설교 리스트
	 */
	@Override
	public List<SermonVO> ganghaebyolSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.ganghaebyolSermonList(svo);
	}

	/**
	 * 새벽 강해별 설교 데이터 저장
	 */
	@Override
	public int ganghaebyolSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.ganghaebyolSermonInsert(svo);
	}

	/**
	 * 새벽 강해별 설교 데이터 수정
	 */
	@Override
	public int ganghaebyolSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.ganghaebyolSermonUpdate(svo);
	}

	/**
	 * 새벽 강해별 설교 데이터 삭제
	 */
	@Override
	public int ganghaebyolSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.chulyaSermonDelete(svo);
	}

	/**
	 * 새벽 사건별 설교 리스트
	 */
	@Override
	public List<SermonVO> sagunbyolSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.sagunSermonList(svo);
	}

	/**
	 * 새벽 사건별 설교 데이터 저장
	 */
	@Override
	public int sagunbyolSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.sagunbyolSermonInsert(svo);
	}

	/**
	 * 새벽 사건별 설교 데이터 수정
	 */
	@Override
	public int sagunbyolSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.sagunbyolSermonUpdate(svo);
	}

	/**
	 * 새벽 사건별 설교 데이터 삭제
	 */
	@Override
	public int sagunbyolSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.sagunbyolSermonDelete(svo);
	}

	/**
	 * 새벽 주제별 설교 리스트
	 */
	@Override
	public List<SermonVO> jujebyolSermonList(SearchVO svo) {
		// TODO Auto-generated method stub
		return sermondao.jujeSermonList(svo);
	}

	/**
	 * 새벽 주제별 설교 데이터 저장
	 */
	@Override
	public int jujebyolSermonInsert(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.jujebyolSermonInsert(svo);
	}

	/**
	 * 새벽 주제별 설교 데이터 수정
	 */
	@Override
	public int jujebyolSermonUpdate(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.jujebyolSermonUpdate(svo);
	}

	/**
	 * 새벽 주제별 설교 데이터 삭제
	 */
	@Override
	public int jujebyolSermonDelete(SermonVO svo) {
		// TODO Auto-generated method stub
		return sermondao.jujebyolSermonDelete(svo);
	}

}