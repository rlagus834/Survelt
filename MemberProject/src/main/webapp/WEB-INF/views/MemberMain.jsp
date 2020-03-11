<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" 
        uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${sessionScope.id}님 환영
<c:if test="${sessionScope.id eq 'admin'}">
   
   <a href="memberList">회원목록</a>
   
   
</c:if>

</body>
</html>