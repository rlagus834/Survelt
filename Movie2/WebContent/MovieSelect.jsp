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
	<form action="SelectMovie">
		<select >
			<option value="영화이름">영화이름</option>			
		</select> <input type="text" name="search"> <input type="submit">
	</form>
<br>
<c:if test="${not empty requestScope.select}" >	
	<table>
		<c:forEach var="movie" items="${select}">
			<tr>
				<td>${movie.boardnumber}</td>
				<td>${movie.boardtitle}</td>
				<td>${movie.text}</td>
				<td>${movie.price}</td>
				<td><a href="BoardTextDelete?mnum=${movie.boardnumber}">삭제</a>
				<td><a href="UpdateTextSelect?mnum=${movie.boardnumber}">수정</a>
				
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