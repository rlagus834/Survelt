<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script>

    	     
function selectUpdate(){
	
	location.href="UpdateSelect";   	
	
}
    </script>
    <style>
        div{
float: left;
        }
        td{
width:150px;
height:100px;
border:1px solid black;
}

#table{
    background-color: aqua;
height: 300px;    
}
#button{
    background-color: aqua;

    height: 300px;    

}
#writeButton{
    background-color: aqua;
    
}

    </style>

</head>
<body >

<br>
<div id="table" >
    <table>
  
  <caption><h1>게시글목록</h1></caption>      
<tr>
<th>글번호</th><th>제목</th><th><a href="UpdateSelectAsc">조회수</a></th>
<th>작성자</th><th>작성일</th>
</tr>
<c:forEach var="member" items="${select}">

<tr>

<td>${member.boardnumber}</td>
<td><a href="writeOpen?resultParam=${member.id}&page=${paging.page}&boardnumber=${member.boardnumber}">${member.boardtitle}</a></td>
<td>${member.count}</td>
<td><a href="MemberWritingSelect?resultParam=${member.id}">${member.id}</a></td>
<td>${member.dateofissue}</td>
</tr>
</c:forEach>
</table>
</div>
<div>
	<!-- 페이징 처리 -->
	<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
	<c:if test="${paging.page>1}">
		<a href="boardListPaging?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
			${i}
		</c:when>
			<c:otherwise>
				<a href="boardListPaging?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.page>=paging.maxPage}">
[다음]
</c:if>
	<c:if test="${paging.page<paging.maxPage}">
		<a href="boardListPaging?page=${paging.page+1}">[다음]</a>
</c:if>
<button onclick="location.href='boardListPaging'">업데이트</button>

<br>
<c:if test="${empty sessionScope.id}">
<button onclick="location.href='Login.jsp'">로그인</button>
</c:if>
<c:if test="${!empty sessionScope.id}">
<button onclick="location.href='BoardFileLoad'">작성하기</button>	
	<div>${sessionScope.id}님 환영합니다
프로필:<img src="fileUpload/${sessionScope.photo}" >

<c:if test="${sessionScope.id eq 'admin'}">
<button onclick="location.href='SelectClient'">고객목록조회</button>

</c:if>
</div>
</c:if>
	
</body>
</html>