<%@page import="com.choi.board.common.AuthUser"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
h3 {
	color: white;
	margin-top: 12px;
	font-size: 1.5rem;
}
h1{
	font-size: 3rem;
	vertical-align: middle !important;
	margin-top: 4rem;
	padding: 0 !important;
	margin-left: 1rem;
}

</style>
<header>
	<h1><span onclick="location.href='/'">미니 프로젝트 </span></h1>
	<nav>
		<ul>
			<u:notLogin>
				<h3>이 웹사이트에</h3>
				<li><a class="btn" href="../member/login">로그인</a></li>

				<li><a class="btn" href="../member/register">회원가입</a></li>
			</u:notLogin>
			<u:isLogin>
				<h3>${loginUser.id}님의</h3>
				<li><a class="btn" href="../member/modify">내 정보 보기</a></li>

				<li><a class="btn" href="../member/logout">로그아웃</a></li>
			</u:isLogin>
		</ul>
	</nav>
	<script type="text/javascript">
	</script>
</header>
