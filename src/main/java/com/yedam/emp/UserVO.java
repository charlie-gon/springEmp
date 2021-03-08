package com.yedam.emp;

import lombok.Data;

@Data
public class UserVO {

	private String id;
	private String[] ids; // id 여러건 삭제 시 필요
	private String password;
	private String name;
	private String role;
	private String oldPwd; // 현재 패스워드
	private String newPwd; // 변경 패스워드 확인
	
}
