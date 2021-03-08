package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired UserMapper dao;

	public List<UserVO> getSearchUser(UserVO vo) {
		return dao.getSearchUser(vo);
	}

	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

	public int insertUser(UserVO vo) {
		return dao.insertUser(vo);
	}

	public int deleteUser(UserVO vo) {
		return dao.deleteUser(vo);
	}

	public int updateUser(UserVO vo) {
		return dao.updateUser(vo);
	}

	public boolean loginUser(UserVO vo) {
		// 단건조회
		// id 값으로 해당 유저 정보 호출하는 메소드 호출
		UserVO userVO = dao.getUser(vo); 
		
		// id 일치여부 확인(유저 존재 여부 확인)
		if(userVO == null) {
			return false; // 유저 없음. 로그인 실패.
		}
		// pwd 일치여부 확인
		if(userVO.getPassword().equals(vo.getPassword())) {
			return true;
		}else {
			return false;
		}
	}

	public int updatePwd(UserVO vo) {
		// 단건조회 -> 기존 패스워드와 일치 여부 확인
		// 기존 패스워드와의 일치 여부(Validation)
		
		
		UserVO userVO = dao.getUser(vo);
		
		if(userVO.getPassword().equals(vo.getOldPwd())) { // 현재/기존 패스워드가 같아야 변경 가능하니까 true
			return dao.updateUser(vo);
		}else {
			// 패스워드 업데이트
			return 0;
		}
	}
	
}
