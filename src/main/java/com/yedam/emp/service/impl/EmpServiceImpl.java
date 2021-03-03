package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	
	//@Autowired EmpSpringDAO dao;
	//@Autowired empMyBatisDAO dao; // mybatis로 설정
	@Autowired EmpMapper dao;
	
	@Override
	public int insertEmp(EmpVO vo) {
		return dao.insertEmp(vo);
	}

	@Override
	public int updateEmp(EmpVO vo) {
		return dao.updateEmp(vo);
	}

	@Override
	public int deleteEmp(EmpVO vo) {
		return dao.deleteEmp(vo);
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return dao.getEmp(vo);
	}

	@Override
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		return dao.getSearchEmp(vo);
	}

	

}
