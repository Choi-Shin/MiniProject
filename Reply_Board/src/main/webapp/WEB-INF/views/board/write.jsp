<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
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

	$(document)
			.on(
					'click',
					'#btnList',
					function(e) {
						e.preventDefault();
						location.href = "board/list";
					});
</script>
<body>

	<article>

		<div class="container" role="main">

			<h2>board Form</h2>

			<form name="form" id="form" role="form" method="post"
				action="write">

				<div class="mb-3">

					<label for="title">제목</label> <input type="text"
						class="form-control" name="title" id="title"
						placeholder="제목을 입력해 주세요">

				</div>



				<div class="mb-3">

					<label for="reg_id">작성자</label> <input type="text"
						class="form-control" name="reg_id" id="reg_id"
						placeholder="이름을 입력해 주세요">

				</div>



				<div class="mb-3">

					<label for="content">내용</label>

					<textarea class="form-control" rows="5" name="content" id="content"
						placeholder="내용을 입력해 주세요"></textarea>

				</div>



				<div class="mb-3">

					<label for="tag">TAG</label> <input type="text"
						class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">

				</div>



			</form>

			<div>
				<a class="btn btn-sm btn-primary" href="list">목록</a>
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>


			</div>

		</div>

	</article>
	<script src="static/js/ckeditor.js"></script>
</body>
</html>