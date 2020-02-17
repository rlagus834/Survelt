<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

location.href="CheckId?id=opener.document.getElementById("idForm").value";

</script>
</head>
<body>
<c:choose>
<c:when test="${result eq null}"> 
사용가능 아이디입니다.
<input type="button" value="창닫기" onclick="window.close()">

 </c:when>
<c:otherwise>
중복입니다.
<input type="button" value="창닫기" onclick="window.close()">

</c:otherwise>

</c:choose>

	
</body>
</html>