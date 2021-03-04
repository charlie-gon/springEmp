<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
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
img:hover{
	transform: scale(1.3);
}
img{
	width: 300px;
	height: 200px;
	margin: 0 auto
}
</style>
</head>
<body>
<!-- Controller = Service - DAO -->

<h3>사원 목록</h3>
<img src="./resources/images/julmi.jpg" id="insertBtn" title="이미지 클릭 시 사원 추가 페이지로 이동">

<!-- 검색 구현 -->
<form action="getSearchEmp" name="searchFrm">
	<input type="hidden" name="page" value="1">
	부서 <input name="department_id" value="${empSearchVO.department_id }">
	Job <input name="job_id" value="${empSearchVO.job_id }">
	Name <input name="first_name" value="${empSearchVO.first_name}">
	<button>검색</button>
</form>

<c:forEach var="emp" items="${list }">
	<div>
	<a href="getEmp?employee_id=${emp.employee_id }">${emp.first_name }</a><br>
	<p>사원 번호: ${emp.employee_id }</p>
	<p>이름: ${emp.last_name } ${emp.first_name}</p>
	<p>부서 이름: ${emp.department_name }</p>
	<p>직무: ${emp.job_title }</p>
	<hr>
	</div>
</c:forEach>
<my:paging paging="${paging }" jsFunc="goPage" />
<script type="text/javascript">
	function goPage(p){
		//location.href = "getSearchEmp?page="+p;
		searchFrm.page.value = p;
		searchFrm.submit();
	}
</script>
</body>
</html>