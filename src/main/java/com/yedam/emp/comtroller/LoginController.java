package com.yedam.emp.comtroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@Controller
public class LoginController { // 로그인 확인
	
	@Resource UserService userService; 
	
	@GetMapping("/login") // 로그인 페이지 이동
	public String login() { 
		return "user/login";
	}
	
	@PostMapping("/login") // 로그인 처리
	public String loginProc(UserVO vo, HttpSession session) {
		if(userService.loginUser(vo)) {
			// 로그인 성공 = 로그인 값 세션에 저장
			session.setAttribute("loginId", vo.getId());
			return "redirect:/";
		}else {
			return "user/login";
		}
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate(); // 세션 무효화
		return "redirect:/";
	}
	
	@GetMapping("/changePwd") // 비밀번호 변경 페이지
	public String changePwd() {
		return "user/changePwd";
	}
	
	@PostMapping("/changePwd") // 비밀번호 변경 호출
	public String changePwdProc(HttpSession session, UserVO vo, BindingResult result) {
		// 일치 여부 확인
		// 패스워드변경서비스
		
		
		
		String id = session.getAttribute("loginId").toString();
		vo.setId(id);
		userService.updatePwd(vo);
		return "redirect:/";
	}
}
