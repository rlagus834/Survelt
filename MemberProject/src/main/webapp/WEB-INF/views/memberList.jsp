<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" herf="${pageConetxt.request.contextPath}/resources/css/table.css">
</head>
<body>
<table>
<c:forEach var="movie" items="${memberList}">
<tr>
<td>
${movie.id}
</td>
<td>
${movie.password}
</td>
<td>
${movie.gender}
</td>
<td>
${movie.phone}
</td>
<td>
${movie.email}
</td>
<td>
 <a href="memberUpdateSelect?id=${movie.id}">수정</a> 
</td>
<td>
 <a href="memberDelete?id=${movie.id}">삭제</a> 
</td>

</tr>

</c:forEach>
</table>

</body>
</html>