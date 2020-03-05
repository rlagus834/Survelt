<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#id1 td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

</style>


</head>
<body>
	<form action="SelectClient">
		<select name="filters">
			<option value="아이디">아이디</option>
			<option value="주민번호">주민번호</option>

		</select> <input type="text" name="search"> <input type="submit">
	</form>
<br>
<c:if test="${not empty requestScope.select}" >	
	<table>
		<c:forEach var="member" items="${select}">
			<tr>
				<td>${member.id}</td>
				<td>${member.password}</td>
				<td>${member.name}</td>
				<td>${member.birth}</td>
				<td>${member.gender}</td>
				<td>${member.email}</td>
				<td>${member.address}</td>
				<td>${member.acnum}</td>
				<td>${member.phone}</td>
				<td><a href="DeleteClient?id=${member.id}">삭제</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
		<td>
		
		</button>
		</td>
		</tr>
	</table>
	</c:if>
</body>
</html>