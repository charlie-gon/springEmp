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
		$('#getBtn').on('click', function(){
			location.href = "getDept?manager_id="+${dept.manager_id};
		});
	});
</script>
<style>

img:hover{
	transform: scale(1.3);
}
img{
	width: 150px;
	height: 100px;
	cursor:pointer
}

</style>
</head>
<body>
<h3>부서 조회</h3>

<form action="getSearchDept" name="searchFrm">
	<input type="hidden" name="page" value="1">
	last_name <input name="last_name" value="${deptSearchVO.last_name }">
	department_name <input name="department_name" value="${deptSearchVO.department_name }">
	city <input name="city" value="${deptSearchVO.city }">
	<button>검색</button>
	<p>
</form>
<c:forEach var="dept" items="${list }"> 
	<img src="./resources/images/welsh.png" id="getBtn" title="단건 조회">
	<p>이름 ${dept.last_name }</p>
	<p>부서 ${dept.department_name }</p>
	<p>매니저ID ${dept.manager_id }</p>
	<p>도시 ${dept.city }</p>
	<hr>
</c:forEach>
<my:paging paging="${paging }" jsFunc="goPage" />
<script type="text/javascript">
	function goPage(p){
		searchFrm.page.value = p;
		searchFrm.submit();
	}
</script>
</body>
</html>