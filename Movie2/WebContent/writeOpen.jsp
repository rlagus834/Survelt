<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<style>
table {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	margin: 20px 10px;
}

tr {
	width: 50px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

td {
	width: 100px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="movie" items="${select}">
		<table>
			<tr>
				<td>
					<form action="UpdateText" method="post"
						enctype="multipart/form-data">영화제목
				</td>
				<td><input type="text" name="mname" value="${movie.boardtitle}"><br></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" minlength="2" maxlength="9"
					name="price" value="${movie.price}"></td>

			</tr>
			<tr>
				<td>설명</td>
				<td><textarea name="text" cols="40" rows="20"
						value="${movie.text}"></textarea></td>
			</tr>
			<tr>
				<td>사진첨부</td>
				<td>사진 <br> <input type="file" name="bFile1"
					value="${movie.photo}"> <br> 사진2 <input type="file"
					name="bFile2" value="${movie.photo1}"> <br> 사진3 <input
					type="file" name="bFile3" value="${movie.photo2}"> <br>
					사진4 <input type="file" name="bFile4" value="${movie.photo3}">
					<br> 사진5 <input type="file" name="bFile5"
					value="${movie.photo4}"> <br> 사진6 <input type="file"
					name="bFile6" value="${movie.photo5}"> <br>
				</td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
			</form>
			<tr>
			<td>
			<button onclick="location.href='MovieSelect.jsp'">취소</button>
			</td>
			</tr>
		</table>
	</c:forEach>






</body>
</html>