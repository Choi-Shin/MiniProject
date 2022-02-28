/**
 *
 */

function 메뉴보이기(menu) {
	var link = document.getElementById(menu);
	if (link.style.display == "none") {
		link.style.display = "block";
	} else {
		link.style.display = "none";
	}
}

function 메뉴사라지기(menu) {
	var link = document.getElementById(menu);
	link.style.display = "none";
}
function 메시지보내기(id) {
	var url = "/message/send?id=" + id;
	var x = document.body.offsetWidth / 2;
	var y = window.screen.height / 2;
	var popupX = document.body.offsetWidth / 2 - 500 / 2;
	var popupY = window.screen.height / 2 - 300 / 2;
	window.open(
		url,
		"메시지 보내기",
		"resizable=no width=500 height=300 left=" +
		popupX +
		", top=" +
		popupY +
		"return false"
	);
}

function 변경폼보이게하기() {
	$('.field').hide();
	$('.password').removeAttr('hidden');
}

function 보내기() {
	var newPassword = $('input[name=newPassword]').val();
	var pwdChk = $('input[name=pwdChk]').val();
	if (newPassword === pwdChk) {
		document.getElementById('newPwd').submit();
	} else {
		alert('입력된 비밀번호가 서로 다릅니다.');
		return false;
	}
}

function 회원탈퇴하기(아이디) {
	var id = 아이디;
	var 동의 = prompt("탈퇴하시려면 id를 입력해주세요.");
	if (동의 == id) {
		location.href = "/member/withdraw?id=" + 아이디;
	} else {
		alert('입력되지 않았거나 id가 다릅니다.');
	}
}
function 그림파일읽어출력하기(이벤트) {
	var fileInput = 이벤트.target;
	//change이벤트.target(대상)은 <input type="file" name="profileFile" id="profileFile"/>
	var 선택된그림파일관리객체 = fileInput.files[0];
	var 선택된그림size = 선택된그림파일관리객체.size;
	/*
	if(선택된그림size > 1024*10){
	alert("10K 요량초과!");
	fileInput.value="";
	return ;
	}
	 */
	if (!선택된그림파일관리객체.type.match('image.*')) {
		alert("욱! 그림이 아니예요!");
		fileInput.value = "";
		return;
	}
	var 파일리더 = new FileReader();
	파일리더.onload = function(선택된그림파일관리객체) {
		var imgProfile = document.getElementById("profile");
		imgProfile.src = 선택된그림파일관리객체.currentTarget.result;
	};
	파일리더.readAsDataURL(선택된그림파일관리객체);
	return;
}
document.querySelector("#profileFile").addEventListener("change",
	그림파일읽어출력하기, false);
