<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="fileForm" action="BoardWrite" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${sessionScope.id}">
        <input type="text" name="title">
        <input type="text" name="text">
<input type="file" multiple="multiple" name="bfile">
     
        <input type="submit" value="전송" >
    </form>





</body>
</html>