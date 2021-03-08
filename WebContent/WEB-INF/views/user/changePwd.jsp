<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.error{color:red}
</style>
</head>
<body>

	<form:form action="changePwd" method="post" modelAttribute="userVO">
			현재 패스워드: <form:input path="oldPwd" /><br>
			<form:errors path="oldPwd" cssClass="error" />
			변경 패스워드: <form:input path="password" />
			<form:errors path="password" cssClass="error" /> <br>
			변경 패스워드 확인: <form:input path="newPwd" />
			<form:errors path="newPwd" cssClass="error" /> <br>
		<p>
		<button>패스워드 변경</button>&nbsp;&nbsp;
	</form:form>

</body>
</html>