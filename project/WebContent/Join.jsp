<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://kit.fontawesome.com/bad24df0ae.js" crossorigin="anonymous"></script>
    
    <link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


    <style>
       
    </style>

<script src="js/joinForm.js"></script>
<link rel="stylesheet" type="text/css" href="css/joinform.css">
<script>

</script>
</head>
<body>
<form action="join" enctype="multipart/form-data" method="Post">
    <table>
 <caption>회원가입</caption>
 
 <tr>

 <td>
<i class="fas fa-id-card"></i>아이디 
<br><input type="text" id="idForm" minlength="6" maxlength="10" name="id" onkeyup="id1()" onblur="checkreset('idSelect')">
<br> 
<span id="idSelect">
    <br>  
</td>
</tr>
<tr><td>
<i class="fas fa-key"></i>비밀번호
<br><input type="password" name="password" onkeyup="pa1()" id="pass1"onblur="checkreset('passSe')"  placeholder="최소8자리 이상,숫자,문자"  minlength="6" maxlength="12">
<br><span id="passSe"></span>
<br>
</td>
</tr>
<tr><td><i class="fas fa-check"></i>비밀번호확인
<br><input type="password"   id="pass2" onkeyup="pa2()" onblur="checkreset('passCh')">
<br><span id="passCh" ></span>
<br>
</td></tr>
<tr><td>
<i class="fas fa-user-edit"></i>이름
<br><input type="text" name="name">
 
</td></tr>
<tr><td>
<i class="fas fa-birthday-cake"></i>생년월일
<br><input type="date" name="birth">
</td></tr>
<tr>
<td>
<select name="gender" >
    <option value="">성별</option>
    <option value="남자">남자</option>
    <option value="여자">여자</option>
</select>
</td>
</tr>
<tr>
    <td>
    주소
       <input type="text" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address1">
<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address2">
<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address3">
<input type="text" id="sample4_extraAddress" placeholder="참고항목" name="address4">
    </td>
</tr>
<tr><td>
<i class="far fa-envelope"></i>이메일<br>
<input type="text" id="email" name="email1">
<input type="text" id="emails" name="email2" placeholder="                     직접입력">
<select  id="emailSe" onchange="email()" >
    <option value="">직접입력</option>
    <option value="@naver.com" >@naver.com</option>
<option value="@daum.com">@daum.com</option>
<option value="@gmail.com">@gmail.com</option>
</select>
</td></tr>
<tr><td><i class="fas fa-mobile-alt"></i>휴대폰번호<br><input type="text" name="phone" id="phone" onkeyup="phoneCheck()"onblur="checkreset('phoneCh')" ><br><span id="phoneCh"></span>
<br></td>
<tr>
<td>
프로필:<input type="file" name="photo">
</td>
</tr>
</tr>
 <tr>
 <td>
<input type="submit" id="join" value="가입하기">
</td>
</tr>
</table>
</form>
</body>
</html>