<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

</script>
<style>
td{
width:150px;
height:100px;
border:1px solid black;
}

</style>
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
<td>
<a href="clientSelect">조회</a>
</td>
<td>
<a href="delete">조회</a>
</td>
</tr>
<br>
</c:forEach>
</table>


</body>
</html>