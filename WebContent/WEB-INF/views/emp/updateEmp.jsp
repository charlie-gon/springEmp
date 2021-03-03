<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
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
<form action="updateEmp" method="post" name="frm">
	employee_id <input type="number" name="employee_id" value="${empVo.employee_id }"<c:if test="${not empty empVo.employee_id }"> readonly="readonly"</c:if> ><br>
	<!-- http://localhost/jsp/EmpUpdate?employee_id=101  입력하여 구현 체크 -->
	
	first_name  <input name="first_name" value="${empVo.first_name }"><br>
	last_name   <input name="last_name" value="${empVo.last_name }"><br>

	email       <input type="email" name="email" value="${empVo.email }">
				<button type="button" id="btnEmail">중복체크</button>
				<span id="emailResult"></span><br>

	phone_number<input type="text" name="phone_number" value="${empVo.phone_number }"><br>
	hire_date   <input type="date" name="hire_date" value="${empVo.hire_date }"><br>
	job_id     
	<select name="job_id">
		<option value="AC_ACCOUNT">Account Manager</option>
		<c:forEach var="job" items="${jobList }" step="1">
			<option value="${job.job_id }" <c:if test="${job.job_id==empVo.job_id }"> selected="selected" </c:if> >${job.job_title }</option>
		</c:forEach>
	</select><br>
	department_id 
	<input type="radio" name="department_id" value="10">기획 
	<c:forEach var="dept" items="${deptList }">
		<input type="radio" value="${dept.department_id }"> 
		<c:if test="${dept.department_id == empVo.department_id }">checked="checked"</c:if> >
		<!-- 부서번호 동일할 때 체크! -->
		${dept.department_name }
	</c:forEach>
	<br>
	Search Employee
	<input type="text" name="manager_id">
	<input type="text" name="manager_name">
	<button type="button" onclick="window.open('empSearch', 'emp', 'width=400, height=400')">사원검색</button><br>	

<c:if test="${empty empVo.employee_id }">
	<button type="submit">등록</button>
</c:if>
<c:if test="${not empty empVo.employee_id }">
	<button type="submit">수정</button>
</c:if>
	<button type="reset">초기화</button>
</form>

</body>
</html>
