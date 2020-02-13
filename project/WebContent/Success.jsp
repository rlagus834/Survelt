<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${sessionScope.id}님 환영합니다

프로필:<img src="fileUpload/${sessionScope.photo}" >

<c:if test="${sessionScope.id eq 'admin'}">
<button onclick="">고객목록조회</button>

</c:if>







</body>
</html>