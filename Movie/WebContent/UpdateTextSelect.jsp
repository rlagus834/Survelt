<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<script src="js/joinForm.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="member" items="${select}">
		<form action="UpdateText" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${member.boardnumber}" name="mnum">
			영화제목:<input type="text" name="mname" value="${member.boardtitle}"><br>
			 가격:<input type="number" minlength="2" maxlength="9" name="price"
				value="${member.price}"> <br>
			<textarea name="text" cols="40" rows="20" value="${member.text}"></textarea>
			<br> <img src="fileUpload/${member.photo}" width="100"
				height="100"> <br> 사진1:<input type="file" name="bFile1">
			<img src="fileUpload/${member.photo1}" width="100" height="100">
			<br> 사진2:<input type="file" name="bFile2"> <img
				src="fileUpload/${member.photo2}" width="100" height="100"> <br>
			사진3:<input type="file" name="bFile3"> <img
				src="fileUpload/${member.photo3}" width="100" height="100"> <br>
			사진4:<input type="file" name="bFile4"> <img
				src="fileUpload/${member.photo4}" width="100" height="100"> <br>
			사진5:<input type="file" name="bFile5"> <img
				src="fileUpload/${member.photo5}" width="100" height="100"> <br>
			사진6:<input type="file" name="bFile6"><br> <input
				type="submit">





		</form>
	</c:forEach>







</body>
</html>