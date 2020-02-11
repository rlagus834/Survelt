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
	function NoticeBoard() {

		location.href = "UpdateSelect";

	}

	
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
작성자:<a href="MemberWritingSelect?resultParam=${member.id}">${member.id}</a>
				<br>
작성일자:${member.dateofissue}<br>
작성글:${member.text}<br>
				<button onclick="NoticeBoard()">나가기</button>				
				<a href="PasswordCheck?resultParam2=${member.boardnumber}">수정하기</button>				
				<a href="BoardTextDelete?resultParam2=${member.boardnumber}">삭제하기</button>				
			</c:forEach>
		</table>
	</div>

</body>
</html>