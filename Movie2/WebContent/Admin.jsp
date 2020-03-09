<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>관리자</h1>
<button onclick="location.href='search.jsp'">메인으로</button>
<br>
<br>
<h2>회원관리</h2>
<iframe src="ClientSelect.jsp" width="100%" height="200px">
</iframe>
<h2>게시영화관리</h2><button onclick="location.href='write.jsp'">영화게시글 작성</button>
<iframe src="MovieSelect.jsp" width="100%" height="500px">
</iframe>





</body>
</html>