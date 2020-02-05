<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>
hello world
</h2>
<!-- EL태그를ㄹ 이용하여 Request 영역에 저장된 값 출력 -->
reqdata1에저장된값:${requestScope.reqData1}<br>
reqdata2에저장된값:${requestScope.reqData2}<br>
<!-- EL태그를ㄹ 이용하여 session 영역에 저장된 값 출력 -->
seData1에 저장된값${sessionScope.seData1 }<br>
seData2에 저장된값${sessionScope.seData2 }<br>
<br>

</body>
</html>