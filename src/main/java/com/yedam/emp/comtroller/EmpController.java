package com.yedam.emp.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired EmpService empService;
	
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
	public String updateEmp(EmpVO vo, Model model) {
		model.addAttribute("empVo", empService.getEmp(vo));
		return "/emp/updateEmp";
	}
	
	@PostMapping("/updateEmp") // 수정 처리
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:getSearchEmp";
	}
	
	@GetMapping("/deleteEmp") // 삭제 처리
	public String deleteEmp(EmpVO vo) {
		empService.deleteEmp(vo);
		return "redirect:getSearchEmp";
	}
	
	@GetMapping("/getEmp") // 단건 조회
	public String getEmp(EmpVO vo, Model model) {
		model.addAttribute("emp", empService.getEmp(vo));
		return "emp/getEmp";
	}
	
	@GetMapping("/getSearchEmp") // 검색 조회
	public String getSearchEmp(EmpSearchVO vo, Paging paging ,Model model) {
		paging.setPageUnit(3); // 한 페이지에 표시되는 레코드 건수
		paging.setPageSize(3); // 페이지 번호
		// 페이징
		if(vo.getPage() == null) {
			vo.setPage(1); // 페이지 넘어오지 않으면 1로 세팅
		}
		
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(empService.getCount(vo));
		//model.addAttribute("empSearchVO", vo); // 따로 설정 해주지 않아도 자동 생성 된다
		model.addAttribute("paging", paging);
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "emp/getSearchEmp";
	}
	
}
