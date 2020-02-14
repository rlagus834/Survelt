<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="BoardFile"
enctype="multipart/form-data" method="post">
작성자<input type="text" name="id" value="${sessionScope.id}" readonly ><br>
글제목:<input type="text" name="boardTitle"><br>
내용:<textarea name="text" cols="40" rows="20"></textarea><br>
첨부파일:<input type="file" name="bFile"><br>
<input type="submit">
</form>








</body>
</html>