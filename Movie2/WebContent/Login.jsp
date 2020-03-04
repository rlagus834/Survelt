<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style_login.css">
</head>
<body>
<div class="login-card">

    <h1>Log-in</h1><br>

  <form action="login" method="post">

    <input type="text" name="id" placeholder="Username">

    <input type="password" name="password" placeholder="Password">

    <input type="submit" name="login" class="login login-submit" value="login">
    <c:if test="${requestScope.fail eq 'fail'}">
		<h4>아이디또는 비밀번호가 불일치합니다.</h4>
	</c:if>
    
    <br>
    <button onclick="location.href='Join.jsp'">회원가입</button>

  </form>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>



</body>
</html>