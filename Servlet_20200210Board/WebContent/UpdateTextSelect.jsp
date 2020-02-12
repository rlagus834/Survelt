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

<c:forEach var="member" items="${select}">

<form action="UpdateText">
글번호:<input type="text" name="boardnumber" value="${member.boardnumber}" readonly><br>
글제목:<input type="text" name="boardTitle" value="${member.boardtitle}"><br>
작성자:${member.id}<br>
작성일자:${member.dateofissue}<br>
글내용:<textarea name="text" cols="40" rows="20">${member.text}</textarea>
비밀번호:<input type="password" name="password" value="${member.password}"><br>
파일:<img src="fileUpload/${member.bfile}" width="200px" >
파일명${member.bfile}
<input type="submit">
</form>

</c:forEach>





</body>
</html>