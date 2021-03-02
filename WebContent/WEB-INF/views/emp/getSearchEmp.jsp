<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{padding: 15px;}
</style>
</head>
<body>
<!-- Controller = Service - DAO -->
<h3>사원 목록</h3>
<c:forEach var="emp" items="${list }">
		<table border="1">
			<tr>
				<td>${emp }</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>