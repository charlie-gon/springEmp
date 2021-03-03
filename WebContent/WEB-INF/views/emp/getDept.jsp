<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getDept.jsp</title>
</head>
<body>
<div class="divCenter">
<h3>부서 단건 조회 페이지</h3>
<p>사번: ${dept.department_id }</p>
<p>성: ${dept.department_name }</p>
<p>이름: ${dept.manager_id }</p>
<p>이메일: ${dept.location_id }</p>

<a href="getSearchDept">목록으로 이동</a><br>
<a href="deleteDept?department_id=${dept.department_id }">삭제</a><br>
<button id="btnUpd">수정</button>
</div>
</body>
</html>