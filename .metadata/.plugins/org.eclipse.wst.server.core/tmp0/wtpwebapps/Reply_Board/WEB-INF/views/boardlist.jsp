<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 글목록</title>
<link rel="stylesheet" href="/static/css/bootstrap.css">
<link rel="stylesheet" href="/static/css/boardlist.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
</head>
<body>
	<header>
			<h1>미니 프로젝트</h1>
			<nav>
				<ul>
					<u:notLogin>
						<li><a class="btn" href="#" onclick="팝업창()">로그인</a></li>

						<li><a class="btn" href="#">회원가입</a></li>
					</u:notLogin>
					<u:isLogin>
						<li><a class="btn" href="member/login"
							onclick="window.open('login','로그인','resizable=no width=300 height=200');return false">회원정보수정</a></li>

						<li><a class="btn" href="member/logout">로그아웃</a></li>
					</u:isLogin>
				</ul>
			</nav>
	</header>
	<aside>
		<div class="aside">
			<ul>
				<li style="width:100%"><a class="btn" href="/" style="width:90%">메인화면으로</a></li>
				<li style="width:100%"><a class="btn" href="#" onclick="공지사항()" style="width:90%">공지사항</a></li>
				<li style="width:100%"><a class="btn" href="list" style="width:90%">자유게시판</a></li>
				<li style="width:100%"><a class="btn" href="#" onclick="참고한자료()" style="width:90%">참고한 자료</a></li>
				<li style="width:100%"><a class="btn"
					href="https://github.com/Choi-Shin/ToyProject" target="_blank"
					onclick="contact()" style="width:90%">contact<br><img
						src="http://img.shields.io/badge/-Github-655ced?style=flat&logo=github&link=https://github.com/Choi-Shin/ToyProject"
						style="height: auto;" /></a></li>
			</ul>
		</div>

	</aside>

	<section>
		<div id="board">
			<div class="board-top">
			<h1>자유게시판</h1>
				<u:isLogin>
					<a class="btn" href="/">글쓰기</a>
				</u:isLogin>
				<u:notLogin>
					<a class="btn" href="member/login">로그인</a>
				</u:notLogin>
			</div>

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
						<td>둘리</td>
						<td>2022.01.05</td>
						<td>3</td>
					</tr>
				</tbody>
			</table>
		</div>
	</section>
	<script type="text/javascript">
		function 참고한자료() {
			$("#board").empty().text('동빈나 유튜브');
		}
		function 공지사항() {
			$("#board").empty().load('notice');
		}
	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.js"></script>
</body>
</html>