<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script >
function check(){
	var btn=document.getElementById("password").value;
	if(btn=='${requestScope.select}'){   
		location.href="UpdateTextSelect?resultParam2=${requestScope.num}";
	}else{
		alert('불일치합니다');
	}



	
}
</script>
</head>
<body>

비밀번호:<input type="password" name="password" id="password">
<button onclick="check()">확인</button>

</body>
</html>