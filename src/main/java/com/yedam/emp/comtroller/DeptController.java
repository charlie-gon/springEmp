package com.yedam.emp.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired DeptService deptService;
	
	// 전체 조회
	@RequestMapping("/getSearchDept")
	public String getSearchDept(DeptSearchVO vo ,Paging paging ,Model model) {
		paging.setPageUnit(3);
		paging.setPageSize(3);
		//페이징
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(deptService.getCount(vo));
		model.addAttribute("paging", paging);
		model.addAttribute("list", deptService.getSearchDept(vo));
		return "emp/getSearchDept";
	}
	
	// 단건 조회
	@GetMapping("/getDept")
	public String getDept(DeptVO vo, Model model) {
		model.addAttribute("dept", deptService.getDept(vo));
		return "emp/getDept";
	}

}
