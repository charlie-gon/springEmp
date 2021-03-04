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
		$('#getBtn').on('click', function(){
			location.href = "getDept?manager_id=${dept.manager_id}";
		});
	});
</script>
<style>

img:hover{
	transform: scale(1.3);
}
img{
	width: 250px;
	height: 200px
}
</style>
</head>
<body>

<c:forEach var="dept" items="${list }"> 
	<img src="./resources/images/welsh.png" id="getBtn" title="단건 조회"><p>${dept }</p>
</c:forEach>

</body>
</html>