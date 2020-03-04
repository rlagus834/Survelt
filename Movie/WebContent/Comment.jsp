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
	<form action="boardListPaging">
		<input type="hidden" value="${requestScope.mnum}" name="mnum">
		<input type="hidden" value="베댓순" name="filters">
		<input type="submit" value="베댓">
	</form>
	<form action="boardListPaging">
		<input type="hidden" value="${requestScope.mnum}" name="mnum">
		<input type="hidden" value="최신순" name="filters">
		<input type="submit" value="최신순">
	</form>
	<br>
	<table>
		<c:if test="${!empty sessionScope.id}">
			<tr>
				<td>
					<form action="CommentWrite">
						평점:<input id="id1" name="score" readonly> <input
							type="hidden" value="${requestScope.mnum}" name="save">

						<p id="star_grade">
							<a href="#" onclick="stars('1')">★</a> <a href="#"
								onclick="stars('2')">★</a> <a href="#" onclick="stars('3')">★</a>
							<a href="#" onclick="stars('4')">★</a> <a href="#"
								onclick="stars('5')">★</a>
						</p>
						<br>
						<textarea name="text" cols="40" rows="20" value="${member.text}"></textarea>
						<input type="submit">
					</form>
				</td>

			</tr>
		</c:if>

		<c:forEach var="member" items="${select}">
			<tr>
				<td>${member.id}</td>
				<td>${member.text}</td>
				<td>${member.score}</td>
				<td>${member.cdate}</td>
				<td><a
					href="GoodPlus?bnum=${member.bnum}&page=${paging.page}&mnum=${requestScope.mnum}">좋아요${member.gcnum}</a>
					<a
					href="MinusPlus?bnum=${member.bnum}&page=${paging.page}&mnum=${requestScope.mnum}">싫어요${member.mcnum}</a>

				</td>
				<c:if test="${sessionScope.id eq member.id}">
				<td>
					<a
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
		</script>
</body>
</html>