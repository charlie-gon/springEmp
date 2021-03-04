package com.yedam.emp.service.impl;

import java.util.List;

import com.yedam.emp.JobVO;

public interface JobMapper {
	// 등록
	public int insertDept(JobVO vo);

	// 수정
	public int updateDept(JobVO vo);

	// 삭제
	public int deleteDept(JobVO vo);

	// 단건 조회
	public JobVO getDept(JobVO vo);

	// 전체&검색 조회
	public List<JobVO> getSearchDept(JobVO vo);
}
