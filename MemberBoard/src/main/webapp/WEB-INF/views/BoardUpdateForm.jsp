<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var jbAry = new Array();
	function FileDelete(save,fnum) {
		console.log(jbAry);
		console.log(save);
		console.log(fnum);		
		$("#"+fnum).remove();
	var html="";
	html="<input type='hidden' name='deleteFiles' value='"+save+"'>";
	$("#deleteAr").append(html);
	}
</script>


</head>
<body>
<form action="BoardUpdate">
	<table id="table">
		<c:forEach var="list" items="${list}" >
			<input name="bnum" type="hidden" value="${list.bnum}">
			<tr>
				<td><input name="title" type="text" value="${list.title}"></td>
			</tr>
			<tr>
				<td><input name="text" type="text" value="${list.text}"></td>
			</tr>
			<tr>
				<td><input name="bfile" type="file" multiple="multiple" name="bfile">
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit">
				</td>
			</tr>
		</c:forEach>
	</table>
				<c:forEach var="fileList" items="${fileList}">
					<div id="${fileList.fnum}">
					${fileList.filesRealName}
					<button onclick="FileDelete('${fileList.files}',${fileList.fnum})">삭제</button>
					</div>
			</c:forEach>
			<div id="deleteAr">
			
			</div>

</form>
</body>
</html>