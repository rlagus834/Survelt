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
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
	function pwSe() {
		var passwordCh = document.getElementById("passwordCh");
		var savePw = document.getElementById("mPw");
		var exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%#?&])[A-Za-z\d$@$!%#?&]{8,16}$/;
		if (savePw.value.match(exp)) {
			passwordCh.style.color = "green";
			passwordCh.innerHTML = "사용가능한 비밀번호입니다.";
		} else {
			passwordCh.style.color = "red";
			passwordCh.innerHTML = "대소문자,숫자,특수문자를 이용하여 작성하세요.";
		}
	}

	function pwCh() {

		var passwordChSecond = document.getElementById("passwordChSecond");
		if ($("#mPw").val() == $("#mPwSecond").val()) {
			passwordChSecond.style.color = "green";
			passwordChSecond.innerHTML = "일치합니다."
		} else {
			passwordChSecond.style.color = "red";
			passwordChSecond.innerHTML = "불일치합니다."
		}

	}

	function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.

						document.getElementById("sample4_roadAddress").value = data.zonecode
								+ roadAddr + data.jibunAddress + extraRoadAddr;

						var guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';
							guideTextBox.style.display = 'block';

						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}
					}
				}).open();
	}

	function phSe() {
		var phoneCh = document.getElementById("phoneCh");
		var savePhone = document.getElementById("mPhone");
		var exp = /^\d{11}$/;
		if (savePhone.value.match(exp)) {
			phoneCh.style.color = "green";
			phoneCh.innerHTML = "정상입니다";
		} else {
			phoneCh.style.color = "red";
			phoneCh.innerHTML = "비정상입니다";
		}

	}
	function joinCh() {

		var passwordCh = document.getElementById("passwordCh");
		var savePw = document.getElementById("mPw");
		var expPw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%#?&])[A-Za-z\d$@$!%#?&]{8,16}$/;

		var passwordChSecond = document.getElementById("passwordChSecond");
		var savePwSecond = document.getElementById("mPwSecond");
		var saveAddress = document.getElementById("address");
		var saveAddressSecond = document.getElementById("addressSecond");

		var phoneCh = document.getElementById("phoneCh");
		var savePhone = document.getElementById("mPhone");
		var expPhone = /^\d{11}$/;
		if (savePw.value.match(expPw)) {
			if ($("#mPw").val() == $("#mPwSecond").val()) {
				if (savePhone.value.match(expPhone)) {
					if ($("#sample4_roadAddress").val() != null
							&& $("#addressSecond").val() != null) {
							document.getElementById("joinForm").submit();
					} else {
						alert('빈칸을 형식에맞게ss 작성하세요');
					}

				} else {
					alert('1111빈칸을 형식에맞게 작성하세요');
				}
			} else {
				alert('빈칸을 형s식에맞게 작성하세요');
			}
		} else {
			alert('빈칸을 형식에맞게 작1성하세요');
		}

	}
</script>
</head>
<body>

	<form action="MemberUpdate" id="joinForm" method="post"
		enctype="multipart/form-data">
		<table border="1px">

			<tr>
				<td>비밀번호 <br> <input type="password" name="password"
					id="mPw" onkeyup="pwSe()" minlength="8" maxlength="16" value="${list.password}"> <br>
					<p id="passwordCh"></p>
				</td>
			</tr>
			<tr>
				<td>비밀번호 재확인 <br> <input type="password" id="mPwSecond"
					onkeyup="pwCh()"> <br>
					<p id="passwordChSecond"></p>
				</td>
			</tr>


			<tr>
				<td>생년월일 <br> <input type="date" name="birth" id="mBirth">
					<br>
					<p id="dateCh"></p>
				</td>
			</tr>
			<tr>
				<td>email <br> <input type="text" name="email" id="mEmail" value="${list.email}">
					<select name="emailSecond" >
						<option value="@naver.com">@naver.com</option>
						<option value="@nate.com">@nate.com</option>
						<option value="@gmail.com">@gmail.com</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>address <br> <input type="button"
					onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample4_roadAddress" placeholder="주소"
					name="address" value="${list.address}"> <input type="text" id="addressSecond"
					name="addressSecond" value="${list.addressSecond}" placeholder="상세주소"> <span id="guide"
					style="color: #999; display: none"></span>

				</td>
			</tr>
			<tr>
				<td>phone <br> <input type="text" name="phone" id="mPhone"
					onkeyup="phSe()" value="${list.phone}"> <br>
					<p id="phoneCh"></p>
				</td>
			</tr>
			<tr>
				<td>
					<button type="button" onclick="joinCh()">완료</button>
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>