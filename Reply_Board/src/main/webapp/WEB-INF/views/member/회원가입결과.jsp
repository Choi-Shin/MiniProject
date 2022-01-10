<%@page import="com.choi.board.common.AuthUser"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
String fail = (String) request.getAttribute("fail");
String success = (String) request.getAttribute("success");
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
		var fail = '<%=fail%>';
		var success = '<%=success%>';
		if (fail !== null) {
			alert(fail);
		} else if (success !== null) {
			alert(success);
		}
		selfClose();
		/* 		selfClose(); */
		/* 		self.location = "/"; */
	</script>
</body>
</html>