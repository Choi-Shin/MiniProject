<%@page import="com.choi.board.common.AuthUser"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
h3 {
	color: white;
	margin-top: 12px;
}

.head {
	position: absolute;
	z-index: 2;
	background-color: white;
	border: 1px gray solid;
	border-radius: 0.5rem;
	top: 9%;
}
</style>
<header>
	<h1>
		<span onclick="location.href='/'">미니 프로젝트</span>
	</h1>
	<nav>
		<ul>
			<u:notLogin>
				<li><a class="btn" onclick="팝업창('login')">로그인</a></li>

				<li><a class="btn" onclick="팝업창('register')">회원가입</a></li>
			</u:notLogin>
			<u:isLogin>
				<li><h3>${loginUser.id}님의</h3></li>
				<li><a class="btn" onclick="메뉴보이기('${loginUser.id}')">myPage</a>
					<div id="${loginUser.id}" class="head" style="display: none"
						onmouseleave="메뉴사라지기('${loginUser.id}')">
						<ul class="user_data_list">
							<li><a href="//gallog.dcinside.com/engmatpro/posting">쪽지함</a></li>
							<li class="bg_grey"><a href="../member/modify"> 회원정보
									수정하기 </a></li>
						</ul>
					</div></li>

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
	
	function 메뉴보이기(id) {
		var link = document.getElementById(id);
		if (link.style.display == 'none') {
			link.style.display = 'block';
		} else {
			link.style.display = 'none';
		}
	}
	function 메뉴사라지기(id) {
		var link = document.getElementById(id);
		link.style.display = 'none';
	}
	</script>
</header>
