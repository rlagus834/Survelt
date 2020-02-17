<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<script src="https://kit.fontawesome.com/bad24df0ae.js"
	crossorigin="anonymous"></script>

<link href="https://fonts.googleapis.com/css?family=Jua&display=swap"
	rel="stylesheet">
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<style>
</style>

<script src="js/joinForm.js"></script>
<link rel="stylesheet" type="text/css" href="css/joinform.css">
<script>
	
</script>
</head>
<body>

	<c:forEach var="member" items="${select}">


		<form action="UpdateClient" enctype="multipart/form-data"
			method="Post">
			<table>
				<caption>정보수정</caption>

				<tr>

					<td><i class="fas fa-id-card"></i>아이디 <br>
					<input type="text" name="id" value=${member.id } readonly>
						<br> <span id="idSelect"> <br></td>
				</tr>
				<tr>
					<td><i class="fas fa-key"></i>비밀번호 <br>
					<input type="password" name="password" onkeyup="pa1()" id="pass1"
						onblur="checkreset('passSe')" value="${member.password}"
						minlength="6" maxlength="12"> <br>
					<span id="passSe"></span> <br></td>
				</tr>
				<tr>
					<td><i class="fas fa-check"></i>비밀번호확인 <br>
					<input type="password" id="pass2" onkeyup="pa2()"
						onblur="checkreset('passCh')" value="${member.password}">
						<br>
					<span id="passCh"></span> <br></td>
				</tr>
				<tr>
					<td><i class="fas fa-user-edit"></i>이름 <br>
					<input type="text" name="name" value="${member.name}"></td>
				</tr>

				<tr>
					<td><input type="button" onclick="sample4_execDaumPostcode()"
						value="우편번호 찾기"><br> <input type="text"
						id="sample4_roadAddress" placeholder="주소" name="address"
						value="${member.address}"> <span id="guide"
						style="color: #999; display: none"></span></td>
				</tr>
				<tr>
					<td><i class="far fa-envelope"></i>이메일<br> <input
						type="text" id="email" name="email1" value="${member.email}">
						<input type="text" id="emails" name="email2"
						placeholder="                     직접입력"> <select
						id="emailSe" onchange="email()">
							<option value="">직접입력</option>
							<option value="@naver.com">@naver.com</option>
							<option value="@daum.com">@daum.com</option>
							<option value="@gmail.com">@gmail.com</option>
					</select></td>
				</tr>
				<tr>
					<td><i class="fas fa-mobile-alt"></i>휴대폰번호<br>
					<input type="text" value="${member.phone}" name="phone" id="phone"
						onkeyup="phoneCheck()" onblur="checkreset('phoneCh')"><br>
					<span id="phoneCh"></span> <br></td>
				<tr>
					<td>프로필:<input type="file" name="photo"
						value="${member.photo}">
					</td>
				</tr>
				</tr>
				<tr>
					<td><input type="submit" id="join" value="가입하기"></td>
				</tr>
			</table>
		</form>
	</c:forEach>

</body>
</html>