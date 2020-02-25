<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="member" items="${select}">

		<form action="UpdateText" enctype="multipart/form-data" method="post">
			글번호:<input type="text" name="boardnumber"
				value="${member.boardnumber}" readonly><br> 글제목:<input
				type="text" name="boardtitle" value="${member.boardtitle}"><br>
			작성일자:${member.dateofissue}<br> 글내용:
			<textarea name="text" cols="40" rows="20">${member.text}</textarea>
			<br> <img src="fileUpload/${member.bFile}"> 첨부파일:<input
				type="file" value="${member.bFile}" name="bFile"> <input
				type="submit">

		</form>

	</c:forEach>





</body>
</html>