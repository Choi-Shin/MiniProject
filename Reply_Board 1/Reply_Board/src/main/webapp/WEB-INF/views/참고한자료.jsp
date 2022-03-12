<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.css, .spring, .aws {
	text-align: center;
	height: 500px;
}

</style>

</head>
<body>
	<div class="wrapper">
		<%@ include file="include/header.jsp"%>
		<%@ include file="include/aside.jsp"%>
		<section>
			<div class="css">
				<h2 style="color: gray">css 참고자료</h2>
				<iframe width="90%" height="70%"
					src="https://www.youtube.com/embed/sFqx8zbPjEE"
					title="YouTube video player" frameborder="0"
					style="border-radius: 1rem"
					allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
			</div>
			<hr>
			<div class="spring">
				<h2 style="color: gray">스프링 참고자료</h2>
				<iframe width="90%" height="70%"
					src="https://freehoon.tistory.com/category/%EA%B0%9C%EB%B0%9C/Spring%20%20%EB%B8%94%EB%A1%9C%EA%B7%B8%20%EB%A7%8C%EB%93%A4%EA%B8%B0?page=3"
					title="스프링 참고자료" frameborder="1" style="border-radius: 1rem"
					allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
			</div>
			<hr>
			<div class="aws">
				<h2 style="color: gray">AWS 참고자료</h2>
				<span>AWS는 아마존 웹서비스를 지칭합니다.</span>
				<iframe width="90%" height="80%"
					src="https://study-ce.tistory.com/45?category=895850"
					title="AWS 참고자료" frameborder="1" style="border-radius: 1rem"
					allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
			</div>
			<%@ include file="include/footer.jsp"%>
		</section>
	</div>
</body>
</html>