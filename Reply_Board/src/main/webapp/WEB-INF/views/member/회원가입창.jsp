<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/bootstrap.css">
<link rel="stylesheet" href="/static/css/home.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<style>
form {
	text-align: center;
}

.btn, .btn:active {
	margin: 0 auto;
}

label {
	display: inline-block;
	width: 50%;
}

.id_ok {
	color: blue;
	display: none;
}

.id_already {
	color: red;
	display: none;
}

.row {
	overflow-x: hidden;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<form action="/member/register" enctype="multipart/form-data"
				method="post" id='frm'>
				<label for="id">아이디<input type="text" name="id" id="id" /></label>
				<button class="btn" onclick="중복확인();return false;">아이디 중복확인</button>
				<span class=id_already>중복된 ID입니다.</span> <span class="id_ok">사용
					가능한 ID입니다.</span><br> <label for="profile"> 프로필사진<img
					id="profile" src="/static/img/no_image.jpeg" width="100px"
					height="auto" /> <br> <input type="file" name="profileFile"
					id="profileFile" />
				</label><br> <label for="name">이름<input type="text" name="name" /></label>
				<label for="password">비밀번호<input type="password"
					id="password" name="password" />
				</label><br> <label for="pwdChk">비밀번호 확인<input type="password"
					name="pwdChk" id="pwdChk" /></label> <label for="email">이메일<input
					type="email" name="email" id="email" /></label>
				<button class="btn big-login" onclick="검증후전송();return false;">회원가입</button>
			</form>
		</div>
		<div class="col-sm-4"></div>
	</div>
	<script>
		function 검증후전송() {
			var password = $('#password').val();
			var pwdChk = $('#pwdChk').val();
			if (password != pwdChk) {
				alert('비밀번호가 서로 다릅니다.');
				$('#pwdChk').val('');
				return false;
			}
			var regExp = /^[a-z]+[a-z0-9]{5,19}$/g;
			if(!id.match(regExp)) {
				alert("영문자로 시작하는 6~20자 영문자 또는 숫자여야합니다.");
				return false;
			}
			var email = $('#email').val();
			var regex = /^([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
			if (!email.match(regex)) {
				alert('이메일 형식에 맞게 입력해주세요.');
				$('#email').val('');
				return false;
			}
			return $('#frm').submit();
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

		function 중복확인() {
			var id = $('#id').val();
			$.ajax({
				url : '/member/idCheck',
				type : 'post',
				data : {
					id : id
				},
				success : function(result) { //컨트롤러에서 넘어온 cnt값을 받는다 
					if (result == "0") { //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
						$('.id_ok').css("display", "inline-block");
						$('.id_already').css("display", "none");
					} else { // cnt가 1일 경우 -> 이미 존재하는 아이디
						$('.id_already').css("display", "inline-block");
						$('.id_ok').css("display", "none");
					}
				},
				error : function() {
					alert("에러입니다");
				}
			});
		};
	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>