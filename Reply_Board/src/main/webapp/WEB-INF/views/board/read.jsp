<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<body>
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/aside.jsp"%>
	<section>
		<div id="board">
			<div class="board-top">
				<a class="btn" href="write">글쓰기</a>
			</div>
			<table class="table table-striped">
				<colgroup>
					<col width="16%" span="5">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th colspan="2">제목</th>
						<th>작성자</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tr>
					<td>${board.no}</td>
					<td colspan="2">${board.title}</td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.regDate}"
							pattern="yyyy년 MM월 dd일 HH:mm" /></td>
				</tr>
				<tr>
					<td colspan="5"><div>${board.content}</div></td>
				</tr>
			</table>
			<a class="btn" href="board/list">목록</a>
			<c:if test="${loginUser.id == board.writer}">
				<a class="btn" href="board/modify?no=${board.no}">수정</a>
				<a class="btn" href="board/delete?no=${board.no}">삭제</a>
			</c:if>
		</div>
		<div class="box box-warning">
			<div class="box-header with-border">
				<a class="btn"><i class="fa fa-pencil margin-r-5"></i>
					댓글 쓰기</a>
			</div>
			<div class="box-body">
				<c:if test="${not empty loginUser}">
					<form>
						<div class="form-group">
							<textarea class="form-control" id="newReplyText" rows="3"
								placeholder="댓글내용..." style="resize: none"></textarea>
						</div>
						<div class="col-sm-2" hidden=>
							<input class="form-control" id="newReplyWriter" type="text"
								value="${loginUser.id}" readonly>
						</div>
						<button type="button"
							class="btn btn-default btn-block replyAddBtn">
							<i class="fa fa-save"></i> 댓글 저장
						</button>
					</form>
				</c:if>
				<c:if test="${empty loginUser}">
					<a class="btn" onclick="팝업창('login')"> 로그인 한 사용자만 댓글 등록이 가능합니다. </a>
				</c:if>
			</div>
		</div>
	</section>
	<script type="text/javascript">
	function 팝업창(type){
		var url = "../member/"+type;
		var popupX = (document.body.offsetWidth / 2) - (200 / 2);
		var popupY= (window.screen.height / 2) - (300 / 2);
		window.open(url,'type','resizable=no width=300 height=200 left=' + popupX +', top='+ popupY +'return false');
	}
	</script>
</body>
</html>