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
<script>
	

</script>

<body>


<c:forEach var="member" items="${select}">
<form action="infoUpdate">

아이디:<input type="text" value="${member.id}" name="id" readonly>
<br>
비밀번호:<input type="text" value="${member.password}" name="password">
<br>
이름:<input type="text" value="${member.name}" name="name">
<br>
이메일:<input type="text" value="${member.email}" name="email">
<br>
<input type="submit">
</form>
</c:forEach>


</body>
</html>