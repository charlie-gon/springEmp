<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function (){
		$('#insertBtn').on('click', function(){
			location.href = "insertEmp";
		});	
	});
</script>
<style>
div{
	border-width: 1px;
	border-style: solid;
	margin: 10px
}
img:hover{
	transform: scale(1.3);
}
img{
	width: 400px;
	height: 300px
}
</style>
</head>
<body>
<!-- Controller = Service - DAO -->

<h3>사원 목록</h3>
<img src="./resources/images/julmi.jpg" id="insertBtn" title="이미지 클릭 시 사원 추가 페이지로 이동">

<c:forEach var="emp" items="${list }">
	<div>
	<a href="getEmp?employee_id=${emp.employee_id }">${emp.first_name }</a>
	<b>${emp.last_name } 부서 이름: ${emp.department_name } 직무: ${emp.job_title }</b><br>
	</div>
</c:forEach>
</body>
</html>