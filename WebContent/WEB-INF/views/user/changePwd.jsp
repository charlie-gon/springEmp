<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="changePwd" method="post" id="frm">
			현재 패스워드: <input type="text" name="oldPwd"><br>
			변경 패스워드: <input type="text" name="password"><br>
			변경 패스워드 확인: <input type="text" name="newPwd">
		<p>
		<button>패스워드 변경</button>&nbsp;&nbsp;
	</form>

</body>
</html>