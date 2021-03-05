package com.yedam.emp;

import lombok.Data;

@Data
public class UserVO {

	private String id;
	private String[] ids; // id 여러건 삭제 시 필요
	private String password;
	private String name;
	private String role;
}
