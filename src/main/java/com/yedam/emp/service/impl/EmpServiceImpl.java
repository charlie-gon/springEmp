package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service // 이 클래스가 Service 역할을 수행한다는 것을 알려주는 Annotation!
public class EmpServiceImpl implements EmpService {
	
	//@Autowired EmpSpringDAO dao;
	//@Autowired empMyBatisDAO dao; // mybatis로 설정
	@Autowired EmpMapper dao;
	
	// Transactional on(삽입X) / off(삽입o)
	//@Transactional
	public int insertEmp(EmpVO vo) {
				//dao.insertEmp(vo); // 트랜잭션 지정되어 있으면 자동커밋
		return dao.insertEmp(vo); // uk 에러 발생 / 트랜잭션 지정된 경우는 모든 쿼리가 롤백됨
	}

	public int updateEmp(EmpVO vo) {
		return dao.updateEmp(vo);
	}

	public int deleteEmp(EmpVO vo) {
		return dao.deleteEmp(vo);
	}

	public EmpVO getEmp(EmpVO vo) {
		return dao.getEmp(vo);
	}

	public List<EmpVO> getSearchEmp(EmpSearchVO vo) {
		return dao.getSearchEmp(vo);
	}

	public int getCount(EmpSearchVO vo) {
		return dao.getCount(vo);
	}

	

}
