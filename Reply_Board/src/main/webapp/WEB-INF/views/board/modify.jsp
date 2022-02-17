<%@page import="com.choi.board.common.Board"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
session = request.getSession(false);
Board board = (Board) request.getAttribute("board");
AuthUser loginUser = (AuthUser) session.getAttribute("loginUser");
if (loginUser == null && !board.getWriter().equals(loginUser.getId())) {
	response.sendRedirect("list");
}
%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
}

header {
	display: flex;
	justify-content: space-between;
	background: cadetblue;
	padding: 20px;
}

h1 {
	display: inline-block;
	vertical-align: middle;
	color: white;
	margin: 0.5rem;
	padding: 0;
}

li {
	display: list-item !important;
}

.container {
	display: block;
	float: right;
	width: 82vw;
}
</style>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/aside.jsp"%>
<script>
	$(document).on('click', '#btnSave', function(e) {
		e.preventDefault();
		$("#form").submit();

	});
</script>
<body>
	<article>
		<div class="container" role="main">
			<h2>board Form</h2>
			<form name="form" id="form" role="form" method="post" action="modify">
				<input type="hidden" name="no" value="${board.no}">
				<div class="mb-3">
					<label for="title">제목</label> <input type="text"
						class="form-control" name="title" value="${board.title}">
				</div>
				<div class="mb-3">
					<label for="reg_id">작성자</label> <input type="text"
						class="form-control" name="writer" value="${loginUser.id}"
						readonly="readonly">
				</div>
				<div class="mb-3">
					<label for="content">내용</label>
					<textarea id="summernote" class="form-control" rows="5"
						name="content" id="content">${board.content}</textarea>
				</div>
				<div>
					<a class="btn btn-sm btn-primary" href="../board/list">목록</a>
					<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				</div>
			</form>

		</div>
	</article>
	<script>
		$(document).ready(function() {
			$('#summernote').summernote();
		});
	</script>
</body>
</html>