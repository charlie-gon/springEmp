<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		// 이메일 중복 검사
		$('#btnEmail').on('click', function(){
			//var param = "email="+$('[name=email]').val();
			param = {email: $('[name=email]').val()}
			$.ajax({
				url: "EmailCheck?",
				data: param, // 서버에 보낼 파라미터
				//dataType: "xml",
				dataType: "json", // 결과 type(String, json ..)
				success: function(obj){
					
					// json 방식
					if(obj.email == true){
						$('#emailResult').html("<font color='blue'>사용가능</font>");
					}else{
						$('#emailResult').html("<font color='red'>사용불가능</font>");
					}
					
					// xml 방식
					//$('#emailResult').html($(obj).find("email").text());
					
				}
			});
		});	
	});
</script>
</head>
<body>
<h3>사원 이메일 수정</h3>
<form:form modelAttribute="empVo" action="updateEmp" method="post" name="frm">

	employee_id
	<form:input path="employee_id" />
	<br> 

	first_name
	<form:input path="first_name" />
	<br> 
	
	last_name
	<form:input path="last_name" />
	<br> 
	
	email
	<form:input path="email" />
	<button type="button" id="btnEmail">중복체크</button>
	<span id="emailResult"></span>
	<br> 
	
	hire_date
	<form:input type="date" path="hire_date" />
	<br>
	
	job_id     
	<form:select path="job_id">
		<option value="">선택</option>
		<form:options items="${jobList }" itemLabel="job_title" itemValue="job_id"/>
	</form:select><br>
	
	department_id
	<form:radiobuttons items="${deptList }" path="department_id" itemLabel="department_name" itemValue="department_id"/>
	
	<button type="submit">등록</button>
</form:form>

</body>
</html>
