<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertEmp.jsp</title>
</head>
<body>
<h3>사원 등록</h3>
<form action="insertEmp" method="post" name="frm">

	employee_id
	<input name="employee_id">
	<br> 

	first_name
	<input name="first_name">
	<br> 
	
	last_name
	<input name="last_name">
	<br> 
	
	email
	<input type="email" name="email">
	<button type="button" id="btnEmail">중복체크</button>
	<span id="emailResult"></span>
	<br> 
	
	hire_date
	<input type="date" name="hire_date">
	<br>
	
	job_id     
	<select name="job_id">
		<option value="AC_ACCOUNT">Account Manager</option>
		<c:forEach var="job" items="${jobList }" step="1">
			<option value="${job.job_id }" <c:if test="${job.job_id==empVo.job_id }"> selected="selected" </c:if> >${job.job_title }</option>
		</c:forEach>
	</select><br>
	
	<button type="submit">등록</button>
</form>
</body>
</html>