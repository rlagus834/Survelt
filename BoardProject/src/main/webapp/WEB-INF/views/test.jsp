<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$.ajax({
		type : "GET",
		url : "board",
		dataType : "json",
		success : function(result) {
			var length = result.length;
			var tb = "";
			tb += "<table border='px'>";
			for (var i = 0; i < length; i++) {
				tb += "<tr>";
				tb += "<td>" + result[i].bnum + "</td>";
				tb += "<td>" + result[i].id + "</td>";
				tb += "<td>" + result[i].title + "</td>";
				tb += "<td>" + result[i].text + "</td>";
				tb += "</tr>";
			}
			;

			tb += "</table>";
			$("#search").html(tb);
		},
		error : function() {
		}
	});
	
	
	
	@Repository

	jsp
					<div id="pageOrder">
						<!-- 페이징 처리 -->
						<c:if test="${select.page<=1}">
		[이전]&nbsp;
		</c:if>
						<c:if test="${paging.page>1}">
							<a href="Movies?page=${paging.page-1}&mname=${requestScope.mname}">[이전]</a>&nbsp;
		</c:if>
						<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
							var="i" step="1">
							<c:choose>
								<c:when test="${i eq paging.page}">
				${i}
			</c:when>
								<c:otherwise>
									<a href="Movies?page=${i}&mname=${requestScope.mname}">${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${paging.page>=paging.maxPage}">
	[다음]
	</c:if>
						<c:if test="${paging.page<paging.maxPage}">
							<a href="Movies?page=${paging.page+1}&mname=${requestScope.mname}">[다음]</a>
						</c:if>
					</div>
</script>
</head>
<body>
	<div id="search"></div>
	<button onclick="location.href='boardWrite'">글쓰기</button>






</body>
</html>