package com.yedam.emp.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired EmpService empService;
	/** 
	 * 분명 @Service로 등록한 클래스는 EmpServiceImpl 인데, 
	 * EmpService 클래스를 호출하는 이유는?
	 * - EmpServiceImpl은 EmpService 인터페이스의 구현체에 불과하다.
	 * 	 따라서 EmpService 등록 시 해당 클래스를 상속한 클래스는 자동으로 등록된다.
	 * 
	 */
	
	@RequestMapping("/")
	public String main() { // 뷰 페이지 설정 / 리턴값은 항상 String 
		return "main";
	}
	
	@GetMapping("/insertEmp") // 등록 페이지 이동
	public String insertEmp(EmpVO vo) {
		return "/emp/insertEmp";
	}
	
	@PostMapping("/insertEmp") // 등록 처리
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:getSearchEmp";
	}
	
	@GetMapping("/updateEmp") // 수정 페이지 이동
	public String updateEmp(EmpVO vo) {
		return "/emp/updateEmp";
	}
	
	@PostMapping("/updateEmp") // 수정 처리
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:getSearchEmp";
	}
	
	@PostMapping("/getEmp") // 단건 조회
	public String getEmp(EmpVO vo) {
		return "emp/getEmp";
	}
	
	@GetMapping("/getSearchEmp") // 검색 조회
	public String getSearchEmp(EmpVO vo, Model model) {
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "emp/getSearchEmp";
	}
	
}
