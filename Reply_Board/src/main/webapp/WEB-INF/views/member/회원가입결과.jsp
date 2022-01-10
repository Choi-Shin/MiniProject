<%@page import="com.choi.board.common.AuthUser"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
String msg = (String) request.getAttribute("msg");
%>

<html>
<head>
<title>Title</title>
</head>
<body>
	<script>
		function selfClose() {
			opener.document.location.reload();
			self.close();
		}
		var msg = '${msg}';
		if (msg !== null) {
			alert(msg);
		}
		selfClose();
		/* 		selfClose(); */
		/* 		self.location = "/"; */
	</script>
</body>
</html>