<%@page import="com.choi.board.common.Board"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
session = request.getSession(false);
AuthUser loginUser = (AuthUser) session.getAttribute("loginUser");
if (loginUser == null) {
	response.sendRedirect("list");
}
%>
<style>
textarea {
	width: 78vw;
	height: 150px;
	padding: 12px 20px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	background-color: #f8f8f8;
	font-size: 16px;
	resize: none;
}

textarea:focus {
	outline: none;
}

h2 {
	text-align: center;
	margin-right: 15%;
}

.table-bordered {
	margin-top: 6%;
}
.reply > button {
	width:99%;
}
.form-group {
	margin-bottom: 0;
}


</style>
<body>
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/aside.jsp"%>

	<section>
		<div id="board" class="board">
			<h2>게시글보기</h2>
			<div class="board-top">
				<a class="btn" style="margin-right: 5%" onclick="로그인유저인가('write')">글쓰기</a>
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
					<td>${board.rownum}</td>
					<td colspan="2">${board.title}</td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.regDate}"
							pattern="yyyy년 MM월 dd일 HH:mm" /></td>
				</tr>
			</table>
			<div class="container p-5 my-5">${board.content}</div>
			<a class="btn" href="../board/list?page=1">목록</a>
			<c:if test="${loginUser.id == board.writer || loginUser.id == 'admin'}">
				<a class="btn" href="../board/modify?no=${board.no}">수정</a>
				<a class="btn" href="../board/delete?no=${board.no}">삭제</a>
			</c:if>
		</div>
		<div class="box box-warning">
			<!-- <div class="box-header with-border">
				<a class="btn"><i class="fa fa-pencil margin-r-5"></i> 댓글 쓰기</a>
			</div> -->
			<div class="box-body">
				<c:if test="${not empty loginUser}">
					<form action="reply" method="post" class="reply">
						<div class="form-group">
							<input type="hidden" name="no" value="${board.no}"> <input
								type="hidden" name="board_no" value="${board.no}"> <input
								type="hidden" name="board" value="${board}">
							<textarea class="form-control" name="memo" rows="3"
								placeholder="댓글내용..." style="resize: none"></textarea>
						</div>
						<div class="col-sm-2" hidden=>
							<input class="form-control" name="writer" type="text"
								value="${loginUser.id}" readonly>
						</div>
						<button type="submit"
							class="btn btn-default btn-block replyAddBtn">댓글 저장</button>
					</form>
				</c:if>
				<c:if test="${empty loginUser}">
					<a class="btn" onclick="팝업창('login')"> 로그인 한 사용자만 댓글 등록이 가능합니다.
					</a>
				</c:if>
			</div>
		</div>
		<c:forEach items="${comments}" var="r">
			<div class="table table-bordered">
				<a class="btn">수정</a><a class="btn" onclick="댓글을삭제하시겠습니까(${board.no},${r.reply_no})">삭제</a>
				<div style="font-weight:bold; font-size:2em;">${r.memo }</div>
				작성자: ${r.writer}
				<h5><fmt:formatDate value="${r.regDate}"
							pattern="yyyy년 MM월 dd일 HH:mm" /></h5>

			</div>
		</c:forEach>
	</section>
	<script type="text/javascript">
	function 팝업창(type){
		var url = "../member/"+type;
		var popupX = (document.body.offsetWidth / 2) - (200 / 2);
		var popupY= (window.screen.height / 2) - (300 / 2);
		window.open(url,'type','resizable=no width=300 height=200 left=' + popupX +', top='+ popupY +'return false');
	}
	
	function 삭제하시겠습니까(번호){
		var no = 번호;
		if(confirm('게시글을 삭제하시겠습니까?') === true) {
			location.href = "/notice/delete?no="+no;
		} else {
			return false;
		}
	}
	
	function 댓글을삭제하시겠습니까(글번호, 댓글번호){
		var no = 글번호;
		var rno = 댓글번호;
		if(confirm('댓글을 삭제하시겠습니까?') === true) {
			location.href = "/notice/replyDelete?no="+no+"&replyNo="+rno;
		} else {
			return false;
		}
	}
	</script>
</body>
</html>
