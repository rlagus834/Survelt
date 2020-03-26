<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function MyPage(){
	
}


</script>
<body>
	
	
	<c:choose>
    <c:when test="${!empty sessionScope}">
    <button onclick="location.href='LogOut'">로그아웃</button>
    <button onclick=" window.open('MyPage', 'MyPage', 'width=500,height=500')">마이페이지</button>
    <button onclick="location.href='BoardListForm'">게시글로가기</button>
    <button onclick="location.href='BoardWriteForm'">글쓰기</button>
    <c:if test="${sessionScope.id eq 'rlagus2259'}">
    <button onclick="location.href='Admin'">관리자기능</button> 
	</c:if>
	</c:when>
		
	      
    <c:otherwise>
    	<button onclick="location.href='LoginForm'">로그인</button>   
    </c:otherwise>


</c:choose>



</body>
</html>