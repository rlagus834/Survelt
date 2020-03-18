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
	<c:forEach var="list" items="${list}">
		<tr>
			<td><input type="text" value="${list.title}"></td>
		</tr>
		<tr>
			<td><input type="text" value="${list.text}"></td>
		</tr>
			<c:forEach var="fileList" items="${fileList}">
		<tr>

				<td>${fileList.filesRealName}</td>
	
				<td><p>삭제</p></td>
</tr>
			</c:forEach>
	</tr>
	</c:forEach>




</body>
</html>