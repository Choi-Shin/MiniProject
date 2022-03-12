<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/memberheader.jsp" %>
	<div class="row">
		<form action="/member/login" method="post">
			<label for="id">아이디<input type="text" name="id"
				required="required" /></label><br> <label for="password">비밀번호<input
				type="password" name="password" required="required" /></label>
			<button class="btn big-login" type="submit">로그인</button>
		</form>
	</div>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>