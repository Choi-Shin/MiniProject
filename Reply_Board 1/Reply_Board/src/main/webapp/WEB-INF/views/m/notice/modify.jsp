<%@page import="com.choi.board.common.Notice"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
session = request.getSession(false);
Notice board = (Notice)request.getAttribute("board");
AuthUser 회원 = (AuthUser) session.getAttribute("loginUser");
if (회원 == null && !board.getWriter().equals("admin")) {
	response.sendRedirect("list");
}
%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
}

li {
	display: list-item !important;
}

.container {
	display: block;
	float: right;
	width: 100vw;
}

.btn-primary {
	width: 20%;
	display: inline-block;
	float: right;
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

					<textarea class="form-control" rows="5" name="content" id="content"
						>${board.content}</textarea>

				</div>



			</form>

			<div>
				<a class="btn btn-sm btn-primary" id="btnSave">저장</a>
				<a class="btn btn-sm btn-primary" href="../notice/list">목록</a>
			</div>

		</div>

	</article>
	<script type="text/javascript">
		$(function() {
			if ('${msg}') {
				alert('${msg}');
			}
		});
	</script>
	<script src="/static/js/ckeditor.js"></script>
</body>
</html>