<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
function join(){
location.href="test.jsp";	
}

</script>
</head>
<body>
<form action="login">
ID: <input type="text" name="id">
<br>
password: <input type="password" name="password">
<input type="submit">
</form>
<button onclick="join()">회원가입</button>
</body>
</html>