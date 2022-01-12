<%@page import="com.choi.board.common.AuthUser"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
String msg = (String) request.getAttribute("msg");
AuthUser loginUser = (AuthUser) request.getAttribute("loginUser");
AuthUser admin = (AuthUser) request.getAttribute("admin");
if (loginUser != null) {
	session =request.getSession();
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
		if (msg !== null) {
			alert(msg);
		}
		selfClose();

		function selfClose() {
			opener.document.location.reload();
			self.close();
		}

		/* 		selfClose(); */
		/* 		self.location = "/"; */
	</script>
</body>
</html>