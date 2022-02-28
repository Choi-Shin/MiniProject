<%@page import="com.choi.board.common.AuthUser"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
String msg = (String) request.getAttribute("msg");
AuthUser loginUser = (AuthUser) request.getAttribute("loginUser");
AuthUser admin = (AuthUser) request.getAttribute("admin");
if (loginUser != null) {
	session = request.getSession();
	session.setAttribute("loginUser", loginUser);
}
if (admin != null) {
	session.setAttribute("admin", admin);
}
%>
<html>
<head>
<title>Title</title>
</head>
<body>
	<script>
		var msg = '${msg}';
		if (msg !== null && (msg == '존재하지 않는 아이디이거나 비밀번호가 틀립니다.' || msg == '아이디와 등록된 이메일이 서로 일치하지 않습니다. 다시 시도해주세요.')) {
			alert(msg);
			window.location.href="/member/login";
		} else if (msg !== null && msg == '관리자 로그인에 실패하였습니다.') {
			alert(msg);
			window.location.href="/member/admin/login";
		} else {
			alert(msg);
			selfClose();
		}
		function selfClose() {
			opener.document.location.reload();
			self.close();
		}

		/* 		selfClose(); */
		/* 		self.location = "/"; */
	</script>
</body>
</html>