<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/head.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	display: inline-block;
}

body, html {
	width: 100%;
	height: 100%;
}

.message {
	width: 90%;
	height: 90%;
	margin-left: 5%;
}

.messageDate {
	float: right;
	border-radius: 0.5rem;
	background: silver;
}

.user_data {
	position: absolute;
	z-index: 100;
	background-color: white;
	border: 1px gray solid;
	border-radius: 1rem;
}

.user_data>ul {
	margin-top: 1rem;
}
</style>
</head>
<body>
	<div class="message">
		<div>
			<h3>${message.title}</h3>
		</div>
		<br>
		<div>
			<a class="menu" onclick="메뉴보이기('${message.send_id}')">${message.send_id}</a>
			<div id="${message.send_id}" class="user_data" style="display: none"
				onmouseleave="메뉴사라지기('${message.send_id}')">
				<ul class="user_data_list">
					<li><a onclick="메시지보내기('${b.writer}')">메시지 보내기 </a></li>
					<li class="bg_grey"><a
						href="/mgallery/board/lists/?id=github&amp;s_type=search_name&amp;s_keyword=%EA%B2%8C%EC%9C%BC%EB%A5%B8%EB%91%94%EC%9E%AC">
							회원 정보 보기<em class="sp_img icon_go"></em>
					</a></li>
					<li class="bg_grey"><a href="">차단하기<em
							class="sp_img icon_go"></em></a></li>
				</ul>
			</div>
		</div>
		<div class="messageDate">
			<fmt:formatDate value="${message.date_sent}"
				pattern="yyyy년 MM월 dd일 HH:mm" />
		</div>
		<hr>
		<div>${message.note}</div>
		<a class="btn" href="/message/receiveBox">목록</a> <a class="btn"
			onclick="메시지삭제하다()">삭제</a>
	</div>
	<script>
		function 메시지삭제하다() {
			var recv_id = '${message.recv_id}';
			var send_id = '${message.send_id}';
			var no = '${message.no}'
			var id = '${loginUser.id}';
			if(id == recv_id) {
				id = "recv_del";
			} else if (id == send_id) {
				id = "sent_del";
			}
			window.location.href="/message/delete?no="+no+"&id="+id;
		}
	</script>
</body>
</html>