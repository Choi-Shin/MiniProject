<%@page import="com.choi.board.common.AuthUser"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
String fail = (String) request.getAttribute("fail");
String success = (String) request.getAttribute("success");
AuthUser loginUser = (AuthUser) request.getAttribute("loginUser");
if (loginUser != null) {
	session.setAttribute("loginUser", loginUser);
}
%>
<html>
<head>
<title>Title</title>
</head>
<body>
	<script>
		var fail = '<%=fail%>';
		var success = '<%=success%>';
		if (!fail) {
			alert(fail);
		} else if (!success) {
			alert(success);
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