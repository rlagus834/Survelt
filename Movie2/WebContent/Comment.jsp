<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/bad24df0ae.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#id1 td,th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

#star_grade a {
	text-decoration: none;
	color: gray;
}

#star_grade a.on {
	color: red;
}
</style>

</head>
<body>

	<c:if test="${!empty sessionScope.id}">
		<table>
			<tr>
				<td>
					<form action="CommentWrite" id="ComCheck">
						<input id="id1" name="score" readonly h type="hidden"> <input
							type="hidden" value="${requestScope.mnum}" name="save">

						<p id="star_grade">
							<a href="#" onclick="stars('1')">★</a> <a href="#"
								onclick="stars('2')">★</a> <a href="#" onclick="stars('3')">★</a>
							<a href="#" onclick="stars('4')">★</a> <a href="#"
								onclick="stars('5')">★</a>
						</p>
				</td>
				<td>
						<textarea minlength="5" style="resize:none" name="text" cols="65" rows="3" value="${member.text}"></textarea>
</td>
<td>					
						<input type="button" onclick="CommentCheck()">
					</form>
	</td>			
<br>
<p id="ComChecks"></p>

<table>
<tr>
<td>
</td>
<td>
</td>
</tr>
</table>
	</c:if>
	<table table id="id1">
		<c:forEach var="member" items="${select}">
			<tr>
				<td>${member.id}<br> ${member.text}
				</td>
				<td>${member.score}</td>
				<td>${member.cdate}</td>
				<td><a
					href="GoodPlus?bnum=${member.bnum}&page=${paging.page}&mnum=${requestScope.mnum}">좋아요${member.gcnum}</a>
					<a
					href="MinusPlus?bnum=${member.bnum}&page=${paging.page}&mnum=${requestScope.mnum}">싫어요${member.mcnum}</a>

				</td>
				<c:if test="${sessionScope.id eq member.id}">
					<td><a
						href="CommentDelete?bnum=${member.bnum}&page=${paging.page}&mnum=${requestScope.mnum}">삭제</a>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>



	<div id="pageOrder">
		<!-- 페이징 처리 -->
		<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
		<c:if test="${paging.page>1}">
			<a
				href="boardListPaging?page=${paging.page-1}&filters=${requestScope.filters}&search=${requestScope.search}&mnum=${requestScope.mnum}">[이전]</a>&nbsp;
	</c:if>
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
			step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
			${i}
		</c:when>
				<c:otherwise>
					<a
						href="boardListPaging?page=${i}&filters=${requestScope.filters}&search=${requestScope.search}&mnum=${requestScope.mnum}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.page>=paging.maxPage}">
[다음]
</c:if>
		<c:if test="${paging.page<paging.maxPage}">
			<a
				href="boardListPaging?page=${paging.page+1}&filters=${requestScope.filters}&search=${requestScope.search}&mnum=${requestScope.mnum}">[다음]</a>
		</c:if>
		<form action="boardListPaging">
			<select name="filters">
				<option value="작성자">작성자</option>
				<option value="글내용">글내용</option>
			</select><input type="text" name="search"> <input type="hidden"
				name="mnum" value="${requestScope.mnum}" readonly> <input
				type="submit">
		</form>





		<script>
			var save = 0;
			function stars(s) {
				save = s;
				document.getElementById("id1").value = save;
			}

			$('#star_grade a').click(function() {

				$(this).parent().children("a").removeClass("on"); /* 별점의 on 클래스 전부 제거 */
				$(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
				return false;
			});
			
		 	function CommentCheck(){
		 	if(save!=0){
		 		document.getElementById("ComCheck").submit();
		 	}else{
		 		document.getElementById("ComChecks").innerHTML = "평점을 매겨주세요"

		 	}	
		 	}
			
		</script>
</body>
</html>