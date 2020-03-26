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
<p>글쓴갯수:${count}</p>
<a href="MemberUpdateSelect">수정</a>
<c:forEach var="list" items="${list}" >
    이름 : ${list.title}
    <br>
</c:forEach>


</body>
</html>