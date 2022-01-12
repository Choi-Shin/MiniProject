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

.pwdChk {
	text-align: center;
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
			<div class="pwdChk">
				<h5>정보 변경을 원하시면 <br>
				현재의 비밀번호를 입력해주세요.</h5>
				<label for="password">비밀번호<input type="password"
					name="password" required="required" /></label> <a class="btn" onclick="비밀번호확인()">비밀번호확인</a>
			</div>
			<form action="modify" method="post">
				<div class="field" hidden="hidden">
					<label for="newPassword">새로운 비밀번호<input type="password"
						name="newPassword" required="required" /></label> <label for="newEmail">새로운 이메일주소<input
						type="email" name="newEmail" required="required" /></label><br>
					<button type="submit" class="btn">변경하기</button>
				</div>
			</form>
		</div>
		<div class="col-sm-4"></div>
	</div>
	<script type="text/javascript">
		function 비밀번호확인() {
			var password = $('input[name=password]').val();
			if (password === '${loginUser.password}') {
				$('.pwdChk').hide();
				$('.field').removeAttr('hidden');
			} else {
				alert("비밀번호가 다릅니다.");
				$('input[name=password]').val('');
			}
		}
	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>