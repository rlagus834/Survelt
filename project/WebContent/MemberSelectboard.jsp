<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<script>
	function write() {

		location.href = "write.jsp";
	}
	function writes() {

		location.href = "writeFile.jsp";
	}

	function selectUpdate() {

		location.href = "UpdateSelect";

	}
</script>
<style>
div {
	width: 100%;
	float: left;
	display: auto;
}

td {
	width: 150px;
	height: 100px;
	border: 1px solid black;
}

#table {
	height: 700px;
}

#button {
	background-color: aqua;
	height: 300px;
}

#writeButton {
	background-color: aqua;
}
</style>

</head>
<body>

	<br>
	<div id="table">
		<table>

			<caption>
				<h1>게시글목록</h1>
			</caption>
			<tr>
				<th>회원아이디</th>
				<th>삭제</th>
				<th>정보수정</th>

			</tr>
			<c:forEach var="member" items="${select}">

				<tr>

					<td>${member.id}</td>
					<td><a href="DeleteClient?id=${member.id}">삭제</a></td>
					<td><a href="UpdateClientLoad?id=${member.id}">수정</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<div>
		<!-- 페이징 처리 -->
		<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
		<c:if test="${paging.page>1}">
			<a href="SelectClient?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
			step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
			${i}
		</c:when>
				<c:otherwise>
					<a href="SelectClient?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${paging.page>=paging.maxPage}">
[다음]
</c:if>
		<c:if test="${paging.page<paging.maxPage}">
			<a href="SelectClient?page=${paging.page+1}">[다음]</a>
		</c:if>
	</div>
	</div>
</body>
</html>