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
	
	
	<c:choose>
    <c:when test="${!empty sessionScope}">
    <button onclick="location.href='LogOut'">로그아웃</button>
    <button onclick="location.href='BoardList'">게시글로가기</button>

	</c:when>
	
	      
    <c:otherwise>
    	<button onclick="location.href='LoginForm'">로그인</button>   
    </c:otherwise>


</c:choose>



</body>
</html>