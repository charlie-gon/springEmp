<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertOrder.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		// 상품추가
		$('#addPr').on('click', function(){
				$("tr:last").clone().appendTo($("tbody"));
 				var trCnt = $('tr').index();
				var plus_num = parseInt(trCnt)+1;
				$('input').attr('name',plus_num);
				$('input').attr('name','ords[].cnt');
			
		});
		// 상품취소
		$('#cancelPr').on('click', function(){
			if($('table tr').length < 4)return alert("모든 상품을 취소하셨습니다.");
			$('table tr:last').remove();
		});
			
		
	});
</script>
</head>
<body>
<button type="button" id="addPr">상품추가</button>
<button type="button" id="cancelPr">상품취소</button>
<form action="insertOrder" method="post">
	 
	<table border="1">
		<tr>
			<td>이름</td>
			<td><input name="name"></td>
		</tr>
		<tr>
			<td>배송지</td>
			<td><input name="addr"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input name="tel"></td>
		</tr>
		<tr>
			<td><input name="ords[0].no"></td>
			<td><input name="ords[0].cnt"></td>
		</tr>
		<tr>
			<td><input name="ords[1].no"></td>
			<td><input name="ords[1].cnt"></td>
		</tr>
		<tr>
			<td><input name="ords[2].no"></td>
			<td><input name="ords[2].cnt"></td>
		</tr>
	</table>
	
	<button>주문하기</button>
</form>
</body>
</html>