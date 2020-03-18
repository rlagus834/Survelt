<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<script>

</script>
</head>
<body>
	<table>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.title}</td>
			</tr>
			<tr>
				<td>${list.text}</td>
			</tr>
			<tr>
				<c:forEach var="fileList" items="${fileList}">
					<td><img
						src="${pageContext.request.contextPath}/resources/fileUpload/${fileList.files}"
						width="300px" height="300px" ></td>
				</c:forEach>

			</tr>
			<tr>
				<c:forEach var="fileList" items="${fileList}">
					<td>${fileList.filesRealName}</td>
					<td><p>다운</p></td>
				</c:forEach>
			</tr>
		</c:forEach>
		<button onclick="location.href='BoardUpdateForm?bnum=${bnum}'"></button>
	</table>
</body>
</html>