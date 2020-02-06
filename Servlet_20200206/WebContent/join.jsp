<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="join" method="POST">
    <br>
<br>
아이디
<br>
<input type="text" name="id" placeholder="                        @naver.com"><br>
<br>
비밀번호
<br>
<input type="password"name="password" placeholder="                                  자물쇠"><br>
<br>

이름

<input type="text"placeholder="" name="name"><br>
<br>
생년월일
<br>
<input type="date" name="birth">
성별
<br>
<select name="gender">
    <option value="">성별</option>
    <option value="남자">남자</option>
    <option value="여자">여자</option>
</select><br>
<br>
본인 확인 이메일<small>(선택)</small>
<br>
<input type="text"placeholder="                              선택입력" name="email"><br>
<br>


<input type="submit" value="가입하기">
</form>

</body>
</html>