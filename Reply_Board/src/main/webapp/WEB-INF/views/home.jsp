<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="include/head.jsp"%>
<style>
.btn {
	display: inline-block;
}
</style>
<body>
	<div id="container">
	<%@ include file="include/header.jsp"%>
		<div class="container" align="center">
			<div class="jumbotron">
				<div class="container" align="center">
					<h1>웹 사이트 소개</h1>
					<p align="center">자유게시판 사이트 입니다.</p>
					<a class="btn btn-primary btn-block" href="board/list?page=1">게시판</a>
					<p>
						<a class="btn btn-primary btn-block" onclick="상세설명()">자세히 알아보기</a>
					</p>
					<div id="detail"></div>
				</div>
			</div>
		</div>
		<div class="container" align="center">
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
							style="width: auto; height: auto;">
					</div>

					<div class="item">
						<img src="/static/img/2.png" alt="Tomcat"
							style="width: auto; height: auto">
					</div>

					<div class="item">
						<img src="/static/img/3.png" alt="Bootstrap"
							style="width: auto; height: 50vh">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<%@ include file="include/footer.jsp"%>
	<script>
		function 상세설명() {
			const element = document.getElementById('detail');
			element.innerText = '이 게시판은 스프링, 톰캣, 부트스트랩으로 제작되었습니다.';
		}
	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>