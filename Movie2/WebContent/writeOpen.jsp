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
	
	
</script>

</head>
<body>

	<br>
	<div id="table">
		<table>

			<c:forEach var="member" items="${select}">


글번호:${member.boardnumber}<br>
제목:${member.boardtitle}<br>
조회수:${member.count}<br>
작성자:${member.id}
				<br>
작성일자:${member.dateofissue}<br>
작성글:${member.text}<br>
<c:if test="${member.bFile}!=null">						
파일:<img src="fileUpload/${member.bFile}" ><br>
<a href="FileDownload?bfile=${member.bFile}">파일다운</a>
파일명${member.bFile}
</c:if>
<br>
				<button onclick="location.href = 'boardListPaging?page=${requestScope.paging}'">나가기</button>				
<c:if test="${sessionScope.id eq member.id || sessionScope.id eq 'admin'}">				

				<a href="BoardTextDelete?resultParam2=${member.boardnumber}&page=${requestScope.paging}">삭제하기</a>				
<c:if test="${sessionScope.id eq member.id}">
						<a href="UpdateTextSelect?boardnumber=${member.boardnumber}&page=${requestScope.paging}">수정하기</a>
					</c:if>					
</c:if>					
				
		


			</c:forEach>
		</table>
	</div>

</body>
</html>