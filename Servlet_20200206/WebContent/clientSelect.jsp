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

<table border="1">
<tr>
<th>ID</th><th>PASSWORD</th><th>NAME</th><th>BIRTH</th><th>GENDER</th><th>EMAIL</th>
</tr>
<c:forEach var="member" items="${select}">

<tr>
<td>
${member.id};
</td>
<td>
${member.password};
</td>
<td>
${member.name};
</td>
<td>
${member.birth};
</td>
<td>
${member.gender};
</td>
<td>
${member.email};
</td>
</tr>
<br>
</c:forEach>


</body>
</html>