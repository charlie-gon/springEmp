package com.yedam.emp;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

	private String id;
	private String[] ids; // id 여러건 삭제 시 필요
	private String name;
	private String role;
	
	@NotEmpty(message="패스워드 입력하세요")
	private String password;
	@NotEmpty(message="현재 패스워드 입력하세요")
	private String oldPwd; // 현재 패스워드
	@NotEmpty(message="변경 패스워드 입력하세요")
	private String newPwd; // 변경 패스워드 확인
}
