package com.yedam.emp;

import lombok.Data;

@Data
public class EmpSearchVO extends EmpVO {
	
	// 페이징 관련 값 추가하는 VO
	Integer page = 1;
	int start = 1;
	int end = 5;
	
}
