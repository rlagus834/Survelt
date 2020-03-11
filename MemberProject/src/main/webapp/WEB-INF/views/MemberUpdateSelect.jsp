<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="movie" items="${memberList}">
    
<form action="memberUpdate" method="POST">
아이디:<input type="text" name="id" value="${movie.id}">
<br>
비밀번호:<input type="text" name="password" value="${movie.password}">
<br>
성별:<input type="text" name="gender" value="${movie.gender}">
<br>
핸드폰:<input type="text" name="phone" value="${movie.phone}">
<br>
이메일:<input type="text" name="email" value="${movie.email}">
<br>
<input type="submit" >
</form>
</c:forEach>
</body>
</html>