<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertEmp.jsp</title>
</head>
<body>
<h3>사원 등록</h3>
<form:form modelAttribute="empVO" action="insertEmp" method="post" name="frm">

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
	<br>
	<p>
	<button type="submit">등록</button>
</form:form>
</body>
</html>
