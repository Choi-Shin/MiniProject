<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 글목록</title>
<link rel="stylesheet" href="/static/css/bootstrap.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Noto Sans KR', sans-serif;
}

#header {
	width: 100%;
	height: 100px;
	background-color: #0d82eb;
}

#freeBoard {
	
	font-size : 30px;
	color: white;
}
</style>
</head>
<body>
	<header>
		<div id="header">
			<span id="freeBoard">자유게시판</span>
		</div>
	</header>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>ㅎㅇ</td>
				<td>둘리</td>
				<td>2022.01.05</td>
				<td>3</td>
			</tr>
		</tbody>
	</table>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.js"></script>
</body>
</html>