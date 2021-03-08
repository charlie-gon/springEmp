<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<div>
<h3>메인 페이지</h3>
<c:if test="${! empty sessionScope.loginId }">
	${sessionScope.loginId }님 
	<a href="logout">로그아웃</a>
	<a href="changePwd">패스워드 변경</a>
</c:if>
<c:if test="${empty sessionScope.loginId }">
	<a href="login">로그인</a>
</c:if>
<p>
<img src="resources/images/welsh.jpg">
<a href="getSearchEmp">사원 조회</a>
<a href="getSearchDept">부서 조회</a>
<a href="insertEmp">사원 등록</a>
<a href="insertDept">부서 등록</a>
</div>
</body>
</html>