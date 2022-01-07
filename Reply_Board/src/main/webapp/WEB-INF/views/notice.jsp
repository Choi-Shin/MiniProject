<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/boardlist.css">
</head>
<body>
	<u:isAdmin>
		<div class="board-top">
		<h1>공지사항</h1>
			<a class="btn" href="/">글쓰기</a>
		</div>
	</u:isAdmin>
	<u:notAdmin>
		<div class="board-top">
		<h1>공지사항</h1>
			<a class="btn" href="/">관리자로그인</a>
		</div>
	</u:notAdmin>

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
			<tr class="detail" style="cursor: pointer;"
				onClick=" location.href='/'">
				<td>1</td>
				<td>ㅎㅇ</td>
				<td>관리자</td>
				<td>2022.01.05</td>
				<td>3</td>
			</tr>
		</tbody>
	</table>
</body>
</html>