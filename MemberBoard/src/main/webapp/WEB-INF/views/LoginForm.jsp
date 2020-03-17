<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<script>
	$(document)
			.ready(
					function() {
						$("#complete")
								.click(
										function() {
											$
													.ajax({
														type : "post",
														url : "LoginCheck",
														data : "id="
																+ $("#lId")
																		.val()
																+ "&password="
																+ $("#lPw")
																		.val(),
														dataType : "text",
														success : function(
																result) {
															if (result == "NO") {
																document
																		.getElementById("check").innerHTML = "아이디또는 비밀번호가 틀립니다.";
															} else {
																location.href = "Main";

															}
														},
														error : function() {

														}

													});
										});
					});
</script>
</head>
<body>
	<input type="text" name="id" id="lId">
	<br>
	<input type="password" name="password" id="lPw">
	<br>
	<button type="button" id="complete">Login</button>
	<button type="button" onclick="location.href='joinForm'">회원가입</button>
	<br>
	<p id="check"></p>

</body>
</html>