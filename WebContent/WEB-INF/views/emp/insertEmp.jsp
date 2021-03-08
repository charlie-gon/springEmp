<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertEmp.jsp</title>
<style>
.error{color:red}
</style>
</head>
<body>
<h3>사원 등록</h3>
<form:form modelAttribute="empVO" action="insertEmp" method="post" name="frm">

	employee_id
	<form:input path="employee_id" />
	<form:errors path="employee_id" cssClass="error" />
	<br> 

	first_name
	<form:input path="first_name" />
	<form:errors path="first_name" cssClass="error" />
	<br> 
	
	last_name
	<form:input path="last_name" />
	<form:errors path="last_name" cssClass="error" />
	<br> 
	
	email
	<form:input path="email" />
	<button type="button" id="btnEmail">중복체크</button>
	<form:errors path="email" cssClass="error" />
	<br> 
	
	hire_date
	<form:input type="date" path="hire_date" />
	<form:errors path="hire_date" cssClass="error" />
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
