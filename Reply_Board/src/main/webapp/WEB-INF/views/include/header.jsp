<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<h1>미니 프로젝트</h1>
	<nav>
		<ul>
			<u:notLogin>
				<li><a class="btn" href="#" onclick="팝업창('login')">로그인</a></li>

				<li><a class="btn" href="#" onclick="팝업창('register')">회원가입</a></li>
			</u:notLogin>
			<u:isLogin>
				<li><a class="btn" href="#"
					onclick="팝업창('register');return false">회원정보수정</a></li>

				<li><a class="btn" href="member/logout">로그아웃</a></li>
			</u:isLogin>
		</ul>
	</nav>
</header>
