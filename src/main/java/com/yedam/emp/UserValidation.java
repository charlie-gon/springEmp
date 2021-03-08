package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidation implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO userVO = (UserVO)target;
		if(userVO.getPassword() == null || userVO.getPassword().isEmpty())
				errors.rejectValue("password", null, "email not null!");
		if(userVO.getNewPwd() == null || userVO.getNewPwd().isEmpty())
				errors.rejectValue("newPwd", null, "newPwd not null!");
		if(userVO.getPassword() != userVO.getNewPwd())
				errors.rejectValue("password", null, "비밀번호가 일치하지 않습니다!");
		
	}
	
}
