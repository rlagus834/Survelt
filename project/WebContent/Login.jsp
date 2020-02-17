<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>

</head>
<body>
	<form action="login">
		ID: <input type="text" name="id"> <br> password: <input
			type="password" name="password"> <input type="submit">
	</form>
	<button onclick="location.href='Join.jsp'">회원가입</button>
	<c:if test="${requestScope.fail eq 'fail'}">
		<h4>아이디또는 비밀번호가 불일치합니다.</h4>
	</c:if>

</body>
</html>