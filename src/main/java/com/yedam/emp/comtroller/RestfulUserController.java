package com.yedam.emp.comtroller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@RestController
public class RestfulUserController {
	
	@Autowired UserService userService;
	
	// 조회
	@GetMapping("/users")
	public List<UserVO> getSearchUser(UserVO vo) {
		return userService.getSearchUser(vo);
	}
	// 단건 조회
	@GetMapping("/users/{id}")
	public UserVO getUser(UserVO vo, @PathVariable String id) {
		vo.setId(id);
		return userService.getUser(vo);
	}
	
	// 등록
	// RequestBody = JSON 활용하여 호출
	@PostMapping("/users")
	public UserVO insertUser(@RequestBody UserVO vo) {
		userService.insertUser(vo);
		return userService.getUser(vo);
	}
	
	// 수정
	// RequestBody = JSON 활용하여 호출
	@PutMapping("/users")
	public UserVO updateUser(@RequestBody UserVO vo) {
		userService.updateUser(vo);
		return userService.getUser(vo);
	}
	
	// 삭제
	@DeleteMapping(value = "/users/{id}")
	public Map deleteUser(UserVO vo, @PathVariable String id) {
		int r = userService.deleteUser(vo);
		return Collections.singletonMap("cnt", r);
		
		/*
		 *  singletonMap 
		 *  - immutable map(불변의 맵) 데이터 리턴(변경 불가, 읽기 전용, null 허용 X)
		 *  - 지정된 값으로 지정된 객체만 매핑하는 맵 리턴(Serializable)
		 */
		
	}
	
}
