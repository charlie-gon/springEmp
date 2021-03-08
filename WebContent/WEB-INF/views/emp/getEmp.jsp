<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.divCenter{margin: 250px}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function (){
		$('#btnUpd').on('click', function(){
			//location.href = "updateEmp?employee_id=${emp.employee_id }"
			location.assign("updateEmp?employee_id=${emp.employee_id }");
		});
	});
</script>
</head>
<body>
파라미터(커맨드 객체는 따로 저장하지 않아도 자동으로 저장됨(앞자리 소문자로)) 
<br>
${empVO }
<hr>
<div class="divCenter">
<h3>사원 단건 조회 페이지</h3>
<p>사번: ${emp.employee_id }</p>
<p>성: ${emp.last_name }</p>
<p>이름: ${emp.first_name }</p>
<p>이메일: ${emp.email }</p>
<p>전화번호: ${emp.phone_number }</p>
<p>입사일: ${emp.hire_date }</p>
<p>급여: ${emp.salary }</p>

<a href="getSearchEmp">목록으로 이동</a><br>
<a href="deleteEmp?employee_id=${emp.employee_id }">삭제</a><br>
<button type="button" id="btnUpd">수정</button>
</div>
</body>
</html>