<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<c:choose>
    <c:when test="${empty sessionScope}">
<a href="loginForm">로그인</a>
    </c:when>
    <c:otherwise>
<a href="logout">로그아웃</a>   
    </c:otherwise>
</c:choose>
<h3>카카오로 회원가입</h3>
<a href="KakaoJoin">
<img src="${pageContext.request.contextPath}/resources/img/kakao_account_login_btn_large_narrow.png">
</a>
<h3>카카오로 로그인</h3>
<a href="Kakaologin">
<img src="${pageContext.request.contextPath}/resources/img/kakao_account_login_btn_large_narrow.png">
</a>
<h3>네이버로 회원가입</h3>
<a href="naverJoin">
<img width="200px" height="100px" src="${pageContext.request.contextPath}/resources/img/네이버 아이디로 로그인_축약형_Green.PNG">
</a>
<h3>네이버로 로그인</h3>
<a href="Naverlogin">
<img width="200px" height="100px" src="${pageContext.request.contextPath}/resources/img/네이버 아이디로 로그인_축약형_Green.PNG">
</a>

<a href="joinform">회원가입</a>

</body>
</html>
