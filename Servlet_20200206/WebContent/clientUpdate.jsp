<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/joinForm.js"></script>
 <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<script>
	

</script>

<body>


<c:forEach var="member" items="${select}">
<form action="infoUpdate">

아이디:<input type="text" value="${member.id}" name="id" readonly  >
<br>
비밀번호:<input type="text" value="${member.password}" name="password" onkeyup="pa1()" id="pass1"> 
<br>
이름:<input type="text" value="${member.name}" readonly>
<br>
생년월일:<input type="date" value="${member.birth}" name="birth">
<br>
성별:<input type="text" value="${member.gender}" readonly>
<br>
 주소
<input type="text" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address1">
<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address2">
<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address3">
<input type="text" id="sample4_extraAddress" placeholder="참고항목" name="address4">
<br>
이메일:<input type="text" value="${member.email}" name="email">
<br>
전화번호:<input type="text" value="${member.phone}" name="phone">
<br>


<input type="submit">

</form>
</c:forEach>


</body>
</html>