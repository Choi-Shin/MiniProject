<%@page import="com.choi.board.common.AuthUser"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
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
				<li><a class="btn" onclick="팝업창('../member/login')">로그인</a></li>

				<li><a class="btn" onclick="팝업창('../member/register')">회원가입</a></li>
			</u:notLogin>
			<u:isLogin>
				<li><h3>${loginUser.id}님의</h3></li>
				<li><a class="btn" onclick="메뉴보이기('${loginUser.id}')">myPage</a>
					<div id="${loginUser.id}" class="head" style="display: none"
						onmouseleave="메뉴사라지기('${loginUser.id}')">
						<ul class="user_data_list">
							<li><a
								onclick="팝업창('../message/receiveBox')">쪽지함<c:if
										test="${fn:length(loginUser.unreadMsg) > 0}">
										<span class="badge bg-red">${fn:length(loginUser.unreadMsg)}</span>
									</c:if></a></li>
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
		var url = type;
		var x = document.body.offsetWidth/2;
		var y = window.screen.height/2;
		var popupX;
		var popupY;
		var slice;
		if(url.indexOf('member') > 0) {
			slice = url.split('/')[2];
			switch (slice) {
			case 'register':
			popupX = x - (300/2);
			popupY = y - (600/2);
			window.open(url,'회원가입','resizable=no width=300 height=600 left=' + popupX +', top='+ popupY +'return false');
			break;
			case 'login':
			popupX = x - (300/2);
			popupY = y - (200/2);
			window.open(url,'로그인','resizable=no width=300 height=200 left=' + popupX +', top='+ popupY +'return false');	
			}
		} else if (url.indexOf('message') > 0) {
			slice = url.split('/')[2];
			switch (slice) {
			case 'receiveBox':
			popupX = x - (500 / 2);
			popupY= (window.screen.height / 2) - (500 / 2);
			window.open(url,'쪽지함','resizable=no width=500 height=500 left=' + popupX +', top='+ popupY +'return false');	
			break;
			}
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
