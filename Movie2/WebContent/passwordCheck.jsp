<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style_login.css">
</head>
<body>
<div class="login-card">

    <h1>비밀번호확인</h1><br>


    <input type="password" id="password" placeholder="Password">

    <input type="button" name="login" class="login login-submit" onclick="check()">
    
    <br>

</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
<script type="text/javascript">

function check(){
	var btn=document.getElementById("password").value;
	if(btn=='${requestScope.password}'){   
		location.href="UpdateClientLoad";
	}else{
		alert('불일치합니다');
	}



	
}

</script>


</body>
</html>