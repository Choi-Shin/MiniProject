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
			<form action="/member/login" method="post">
				<label for="id">아이디<input type="text" name="id" required="required"/></label><br> <label
					for="password">비밀번호<input type="password" name="password" required="required"/></label>
				<button class="btn big-login" type="submit">로그인</button>
			</form>
		</div>
		<div class="col-sm-4"></div>
	</div>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>