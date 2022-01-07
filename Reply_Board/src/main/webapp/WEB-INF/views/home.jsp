<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 메인화면</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/bootstrap.css">
<link rel="stylesheet" href="/static/css/home.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<style type="text/css">
</style>
</head>

<body>
	<header>
<h1>안녕하세요.</h1>
		<nav>
			<ul>
				<li><a class="btn" href="login"
					onclick="window.open('login','로그인','resizable=no width=300 height=200');return false">로그인</a>
				</li>
				<li><a class="btn" href="#">메뉴 2</a></li>
				<li><a class="btn" href="#">메뉴 3</a></li>
			</ul>
		</nav>
	</header>
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h1>웹 사이트 소개</h1>
				<p>미니프로젝트 자유게시판 사이트 입니다.</p> <a class="btn" href="list"></a>
				<p>
					<a class="btn-primary btn-pull" href="#" role="button" onclick="상세설명()">자세히 알아보기</a>
				</p>
				<div id="detail"></div>
			</div>
		</div>
	</div>
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="/static/img/1.png" alt="Spring"
						style="width: auto; height: 50vh;">
				</div>

				<div class="item">
					<img src="/static/img/2.png" alt="Tomcat"
						style="width: auto; height: 50vh">
				</div>

				<div class="item">
					<img src="/static/img/3.png" alt="Bootstrap"
						style="width: auto; height: 50vh">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<script>
		function 상세설명() {
			 const element = document.getElementById('detail');
			  element.innerText 
			    = '이 게시판은 스프링, 톰캣, 부트스트랩으로 제작되었습니다.';
			} 

	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>

</html>