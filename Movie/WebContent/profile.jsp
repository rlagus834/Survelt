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
	작성자:${requestScope.id}
	<br> 전체글갯수:${requestScope.listCount}
	<br>
	<c:if test="${requestScope.id eq sessionScope.id}">
		<a href="UpdateTextload?boardnumber=${member.boardnumber}">수정하기</a>
	</c:if>
</body>
</html>