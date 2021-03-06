<%@page import="com.choi.board.common.AuthUser"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<%
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
<c:set var="path" value="${pageContext.request.contextPath}" />
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1,user-scalable=0">
<title>미니 프로젝트 게시판</title>
<!-- <link rel="stylesheet" href="/static/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="/static/css/m/bootstrap.css">
<link rel="stylesheet" href="/static/css/m/boardlist.css">
<link rel="stylesheet"
	href="/static/fonts/glyphicons-halflings-regular.woff2">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<script
	src="https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		if ('${msg}') {
			alert('${msg}');
		}
	});
	function 로그인유저인가(link) {
		if ('${loginUser}') {
			location.href = link;
		} else {
			alert("로그인이 필요합니다.");
			location.href = "list";
		}
	}
	function 관리자인가(link) {
		if ('${admin}') {
			location.href = link;
		} else {
			alert("관리자 권한이 필요합니다.");
			location.href = "list";
		}
	}
	
</script>
</head>