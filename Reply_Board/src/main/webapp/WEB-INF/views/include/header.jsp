<%@page import="com.choi.board.common.AuthUser"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
h3 {
	color: white;
	margin-top: 12px;
}
</style>
<header>
	<h1>미니 프로젝트</h1>
	<nav>
		<ul>
			<u:notLogin>
				<li><a class="btn" onclick="팝업창('login')">로그인</a></li>

				<li><a class="btn" onclick="팝업창('register')">회원가입</a></li>
			</u:notLogin>
			<u:isLogin>
				<li><h3>${loginUser.id}님의</h3></li>
				<li><a class="btn" onclick="팝업창('modify')">회원정보수정</a></li>

				<li><a class="btn" href="../member/logout">로그아웃</a></li>
			</u:isLogin>
		</ul>
	</nav>
	<script type="text/javascript">
	function 팝업창(type){
		var url = "../member/"+type;
		var popupX = (document.body.offsetWidth / 2) - (200 / 2);
		var popupY= (window.screen.height / 2) - (300 / 2);
		if (type == 'modify' || type == 'register') {
			window.open(url,type,'resizable=no width=300 height=300 left=' + popupX +', top='+ popupY +'return false');
		} else {
			window.open(url,type,'resizable=no width=300 height=200 left=' + popupX +', top='+ popupY +'return false');	
		}
	}
	</script>
</header>
