package com.yedam.emp;

import lombok.Data;

@Data
public class DeptSearchVO extends DeptVO {
	// 페이징
	Integer page = 1; // null 값도 받을 수 있도록 하기 위해 Integer 설정
	int start = 1;
	int end = 5;
}
