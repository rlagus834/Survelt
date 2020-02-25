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
	<form action="BoardFile" method="post" enctype="multipart/form-data">
		영화제목:<input type="text" name="mname"><br> 내용:
		가격:<input type="number" minlength="2" maxlength="9" name="price" >

<br>
		<textarea name="text" cols="40" rows="20"></textarea>

		<br> 사진1:<input type="file" name="bFile[0]">
			
		<br> 사진2:<input type="file" name="bFile[1]">
			
		<br> 사진3:<input type="file" name="bFile[2]">
		
		<br> 사진4:<input type="file" name="bFile[3]">
		
		<br> 사진5:<input type="file" name="bFile[4]">
		
		<br> 사진6:<input type="file" name="bFile[5]"><br> <input
			type="submit">
			
			
			
			
			
	</form>








</body>
</html>