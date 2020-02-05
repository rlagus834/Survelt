<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

function selectDB(){
	location.href="selectDB";//해당주소로 가게끔함
	
}

//
</script>
</head>
<body>
<form action="inputs"> 
<input type="text" name="data1">
<input type="text" name="data2">
<input type="submit">
</form>

<h2>DB 내용 조회하기</h2>
<a href="selectDB" id="id1">DB 조회링크</a>
<button onclick="selectDB()">조회</button>

</body>       
</html>