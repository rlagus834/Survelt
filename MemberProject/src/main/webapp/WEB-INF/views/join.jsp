<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<script>
	function idOverlap() {
		var inputId = document.getElementById("id").value;
		var CheckId = document.getElementById("idcheck");

		//ajax(Asynchronous(비동기) javascript and XML) 사용
		//서버로 데이터 전송 시 JSON(JavaScript Object Notation) 사용
		$.ajax({
			type : "post",//전송방식   value
			url : "idoverlap",//서버주소  key   ,꼭써야함
			data : {
				"id" : inputId
			}, //보낼데이터세팅    2개이상을쓸때는 {"id":inputId,"id":inputId} dto필드값이랑같게 파라미터이름정하면 편함
			dataType : "text", //text or json이라 보낼수있음 (보내는데이터의타입)
			success : function(result) { //성공해야만 result(리턴)값이오므로  성공시에만 받게끔함
				console.log("통신 성공??");
				console.log("통신 성공??" + result);
				if (result == "OK") {
					CheckId.style.color = "green";
					CheckId.innerHTML = "사용가능";

				} else {

					CheckId.style.color = "red";
					CheckId.innerHTML = "사용불가능";

				}

			}, //성공시 실행할것
			error : function() {
				console.log("통신 실패??");
				//실패시 실행할것
			}

		});

	}
</script>
</head>
<body>
	<form action="memberJoin" method="post">
		카카오 아이디: ${kakaoId}
		<c:choose>
			<c:when test="${kakaoId ne null}">
    아이디:<input type="text" name="id" id="id" onkeyup="idOverlap()">
				<span id="idcheck"></span>
				<input type="hidden" name="kakaoId" id="kakaoId" value="${kakaoId}">
				<br> 성별:<input type="text" name="gender">
				<br> 핸드폰:<input type="text" name="phone">
				<br> 이메일:<input type="text" name="email">
				<br>
				<input type="submit">
			</c:when>
			<c:when test="${naverId ne null}">
    
     아이디: <input type="text" name="id" id="id" onkeyup="idOverlap()">
				<span id="idcheck"></span>
				<input type="hidden" name="naverId" id="naverId" value="${naverId} ">
				<br> 성별:<input type="text" name="gender">
				<br> 핸드폰:<input type="text" name="phone">
				<br> 이메일:<input type="text" name="email">
				<br>
				<input type="submit">
			</c:when>

			<c:otherwise>
아이디: <input type="text" name="id" id="id" onkeyup="idOverlap()">
				<span id="idcheck"></span>
   비밀번호: <input type="password" name="password" id="password">
				<br> 성별:<input type="text" name="gender">
				<br> 핸드폰:<input type="text" name="phone">
				<br> 이메일:<input type="text" name="email">
				<br>
				<input type="submit">


			</c:otherwise>
		</c:choose>


	</form>

</body>
</html>