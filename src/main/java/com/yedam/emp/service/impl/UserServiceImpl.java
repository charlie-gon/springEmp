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
	
}
