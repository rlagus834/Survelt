function id1() {

	var exp = /^(?=.*[a-z])(?=.*\d)[a-z\d]{6,10}$/;
	var saveId = document.getElementById("idForm");

	if (saveId.value.match(exp)) {
		document.getElementById("idSelect").style.color = "blue";
		document.getElementById("idSelect").innerHTML = "사용가능 아이디입니다."

	} else {
		document.getElementById("idSelect").style.color = "red";

		document.getElementById("idSelect").innerHTML = "소문자와 숫자만을이용하여 작성하세요."
	}
}
function pa1() {
	var pass = document.getElementById("pass1");
	// 정규식(형식을지정해놓는것)
	var exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%#?&])[A-Za-z\d$@$!%#?&]{8,16}$/;
	if (pass.value.match(exp)) {
		document.getElementById("passSe").innerHTML = "정상입니다";

	} else {
		document.getElementById("passSe").innerHTML = "대,소문자,숫자,특수문자를 이용하여 작성하세요. ";
	}
}
function checkreset(reset1) {

	document.getElementById(reset1).innerHTML = "";

}
function pa2() {
	var ps1 = document.getElementById("pass1").value;
	var ps2 = document.getElementById("pass2").value;
	if (ps1 == ps2) {
		document.getElementById("passCh").style.color = "blue";
		document.getElementById("passCh").innerHTML = "일치";
	} else {
		document.getElementById("passCh").style.color = "red";
		document.getElementById("passCh").innerHTML = "불일치";
	}
}
function phoneCheck() {
	var exp = /^\d{3}-\d{4}-\d{4}$/;
	var phoneSave = document.getElementById("phone");
	if (phoneSave.value.match(exp)) {
		document.getElementById("phoneCh").style.color = "blue";
		document.getElementById("phoneCh").innerHTML = "정상적";
	} else {
		document.getElementById("phoneCh").style.color = "red";
		document.getElementById("phoneCh").innerHTML = "비정상적";
	}
}
function emailSelect() {
	var email = document.getElementById("emailSe").value;
	document.getElementById("email2").value = email;

}
// 본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
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
						var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
						guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr
								+ ')';
						guideTextBox.style.display = 'block';

					} else if (data.autoJibunAddress) {
						var expJibunAddr = data.autoJibunAddress;
						guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr
								+ ')';
						guideTextBox.style.display = 'block';
					} else {
						guideTextBox.innerHTML = '';
						guideTextBox.style.display = 'none';
					}
				}
			}).open();
}

function checkSign() {
	var exp1 = /^(?=.*[a-z])(?=.*\d)[a-z\d]{6,10}$/;
	var saveId = document.getElementById("idForm");
	var pass = document.getElementById("pass1");
	var exp2 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%#?&])[A-Za-z\d$@$!%#?&]{8,16}$/;
	var ps1 = document.getElementById("pass1").value;
	var ps2 = document.getElementById("pass2").value;
	var exp3 = /^\d{3}-\d{4}-\d{4}$/;
	var phoneSave = document.getElementById("phone");
	var address1 =document.getElementById("sample4_roadAddress").value;
	
	if (saveId.value.match(exp1)&& pass.value.match(exp2) && ps1 == ps2 &&phoneSave.value.match(exp3)
			&& address1 !=null) {
					document.getElementById("joinForm").submit();
				}else{
			alert('표시형식에 맞게 작성하여 주십시오.');
			}	
}


	




	
