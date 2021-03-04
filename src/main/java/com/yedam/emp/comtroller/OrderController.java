package com.yedam.emp.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.OrderMasterVO;

@Controller
public class OrderController {
	
	@GetMapping("/insertOrder") // 주문폼
	public String insertOrder(OrderMasterVO vo) {
		System.out.println(vo);
		return "order/insertOrder";
	}
	
	@PostMapping("/insertOrder") // 주문처리
	public String insertOrderProc(OrderMasterVO vo) {
		System.out.println(vo);
		// master 테이블 등록
		// 주문상세(detail) / list 수만큼 loop하여 등록
		return "redirect:/";
	}
}
