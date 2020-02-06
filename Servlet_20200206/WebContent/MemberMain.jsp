<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function update(){
		
}
function logout(){
	
	location.href="Login.jsp";
}

</script>
</head>
<body>
${sessionScope.select}님 환영합니다.
<br>
<c:if test="${sessionScope.select eq 'admin'}">
<a href="memberList">회원목록조회</a>
</c:if>

<button onclick="update()">회원정보수정</button>
<button onclick="logout()">로그아웃</button>



</body>
</html>