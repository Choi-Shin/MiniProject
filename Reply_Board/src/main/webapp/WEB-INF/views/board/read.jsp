<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-12">
		<div class="box box-primary">
			<div class="box-header with-border">
				<h3 class="box-title">글제목 : ${board.title}</h3>
			</div>
			<div class="box-body" style="height: 700px">${board.content}</div>
			<div class="box-footer">
				<div class="user-block">
					<img class="img-circle img-bordered-sm"
						src="/dist/img/user1-128x128.jpg" alt="user image"> <span
						class="username"> <a href="#">${board.writer}</a>
					</span> <span class="description"><fmt:formatDate
							pattern="yyyy-MM-dd a HH:mm" value="${board.regDate}" /></span>
				</div>
			</div>
			<div class="box-footer">
				<form role="form" method="post">
					<input type="hidden" name="articleNo" value="${board.no}">
				</form>
				<button type="submit" class="btn btn-primary listBtn">
					<i class="fa fa-list"></i> 목록
				</button>
				<div class="pull-right">
					<button type="submit" class="btn btn-warning modBtn">
						<i class="fa fa-edit"></i> 수정
					</button>
					<button type="submit" class="btn btn-danger delBtn">
						<i class="fa fa-trash"></i> 삭제
					</button>
				</div>
			</div>
		</div>
	</div>

	<section class="content container-fluid">
		<div class="col-lg-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">댓글 작성</h3>
				</div>
				<div class="box-body">
					<div class="form-group">
						<label for="newReplyText">댓글 내용</label> <input
							class="form-control" id="newReplyText" name="replyText"
							placeholder="댓글 내용을 입력해주세요">
					</div>
					<div class="form-group">
						<label for="newReplyWriter">댓글 작성자</label> <input
							class="form-control" id="newReplyWriter" name="replyWriter"
							placeholder="댓글 작성자를 입력해주세요">
					</div>
				</div>
				<div class="box-footer">
					<ul id="replies">

					</ul>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination pagination-sm no-margin">

						</ul>
					</div>
				</div>
			</div>
		</div></section>
</body>
</html>