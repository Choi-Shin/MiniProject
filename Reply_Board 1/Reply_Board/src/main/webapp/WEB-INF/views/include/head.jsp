<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>미니 프로젝트 게시판</title>
<!-- <link rel="stylesheet" href="/static/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="/static/css/bootstrap.css">
<link rel="stylesheet" href="/static/css/boardlist.css">
<link rel="stylesheet"
	href="/static/fonts/glyphicons-halflings-regular.woff2">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<script type="text/javascript" src="/static/js/custom.js"></script>
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