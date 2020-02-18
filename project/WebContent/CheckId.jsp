<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function idCheck(){
	
	window.opener.idCheckHide('hallow');
	
	self.close()	
}


</script>
</head>
<body>
<c:choose>
<c:when test="${requestScope.result eq null}"> 
사용가능 아이디입니다.
<input type="button" value="창닫기" onclick="idCheck()">
 </c:when>
<c:otherwise>
중복입니다.
<input type="button" value="창닫기" onclick="idCheck()">

</c:otherwise>

</c:choose>

	
</body>
</html>