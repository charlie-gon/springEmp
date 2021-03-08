package com.yedam.emp.comtroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;

@Controller
public class EmpController {
	
	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobService jobService;
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
	public String insertEmp(EmpVO vo, Model model, DeptSearchVO deptVo, JobVO jobVo) {
		model.addAttribute("deptList", deptService.getSearchDept(deptVo));
		model.addAttribute("jobList", jobService.getSearchJob(jobVo));
		return "/emp/insertEmp";
	}
	
	@PostMapping("/insertEmp") // 등록 처리
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:getSearchEmp";
	}
	
	@GetMapping("/updateEmp") // 수정 페이지 이동
	public String updateEmp(EmpVO vo, Model model,DeptSearchVO deptVo, JobVO jobVo) {
		model.addAttribute("empVo", empService.getEmp(vo));
		model.addAttribute("deptList", deptService.getSearchDept(deptVo));
		model.addAttribute("jobList", jobService.getSearchJob(jobVo));
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
	
	@GetMapping("/getEmp") // 단건 조회 //PathVariable = /getEmp/{id}
	public String getEmp(Model model
			//, HttpServletRequest request
			//, @RequestParam("id") String employee_id // 변수값 employee_id 대신 "id" 사용으로 설정
			//, @RequestParam(value="id", required=false ,defaultValue="100") String employee_id // id 없으면 초기값으로 100 주겠다(교재 p.276)
			//, @PathVariable String id // 교재 p.396(PathVariable)
			, @ModelAttribute("employee")EmpVO vo // 교재 p.286
			) {
		// 요청 파라미터 접근(교재 p.274)
		// 1. getParameter - 옛날 방식
//		String employee_id = request.getParameter("employee_id");
//		vo.setEmployee_id(employee_id);
		
//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(id);
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
