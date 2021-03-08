<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인 페이지</title>
<style>
	#frm{
		text-align:center
		margin-left:auto;
		margin-right:auto
</style>
</head>
<body>

	<form action="login" method="post" id="frm">
			아이디: <input type="text" name="id">
			비밀번호: <input type="text" name="password">
		<p>
		<button>로그인</button>&nbsp;&nbsp;
		<button>취소</button>
	</form>

</body>
</html>