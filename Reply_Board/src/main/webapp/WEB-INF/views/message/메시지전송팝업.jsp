<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/head.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.sendMessage {
		text-align: center;
	}
</style>
</head>
<body>
	<div class="sendMessage">
		<form action="/message/send" method="post">
			<input type="hidden" name="recv_id" value="${MessageDuo.recv_id}">
			<input type="hidden" name="send_id" value="${MessageDuo.send_id}">
			<div id="receiver"><h5>받는 사람: ${MessageDuo.recv_id}</h5> </div>
			<div id="sender"><h5>보내는 사람: ${MessageDuo.send_id}</h5></div>
			<div id="title">제목<input type="text" style="width:90%" name="title" /></div>
			<div id="note">내용<textarea rows="4" style="width:90%" name="note"></textarea></div>
			<input class="btn" type="submit" value="보내기"/>
		</form>
	</div>
</body>
</html>