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
</style>
</head>
<body>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<form action="/member/register" enctype="multipart/form-data"
				method="post">
				<label for="id">아이디<input type="text" name="id" /></label> <label
					for="profile"> 프로필사진<img id="profile"
					src="/static/img/no_image.jpeg" width="100px" height="auto" /> <br>
					<input type="file" name="profileFile" id="profileFile" />
				</label><br>
				<label for="name">이름<input type="text" name="name" /></label> <label
					for="password">비밀번호<input type="password" name="password" /></label>
				<label for="email">이메일<input type="email" name="email" /></label>
				<button class="btn big-login" type="submit">회원가입</button>
			</form>
		</div>
		<div class="col-sm-4"></div>
	</div>
	<script>
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
	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>