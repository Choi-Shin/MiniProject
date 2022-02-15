<%@page import="com.choi.board.common.Notice"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<%
session = request.getSession(false);
AuthUser 회원 = (AuthUser) session.getAttribute("loginUser");
Notice board = (Notice) request.getAttribute("board");
if (회원 == null) {
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
	color: gray;
}

.container {
	font-size: 1.5rem;
}

.board>a {
	width: 20%;
	float: right
}

.board-top>a {
	width: 20%;
	float: right
}

.table-bordered>.btn {
	float: right;
	width: 20%;
}

.table-bordered, .table-bordered>.btn, .table-bordered>.replyNo,
	.table-bordered>.replyWriter, .table-bordered>.replyDate {
	display: inline-block;
}

th {
	font-size: 1rem;
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
					<td colspan="2" style="font-size:1.5rem">${board.title}</td>
					<td style="font-size: 1.5rem;">${board.writer}</td>
					<td style="font-size: 1rem;"><fmt:formatDate
							value="${board.regDate}" pattern="yyyy/MM/dd HH:mm" /></td>
				</tr>
			</table>
			<div class="container p-5 my-5">${board.content}</div>
			<a class="btn" href="../notice/list">목록</a>
			<c:if test="${loginUser.id == 'admin'}">
				<a class="btn" href="../notice/modify?no=${board.no}">수정</a>
				<a class="btn" onclick="삭제하시겠습니까(${board.no})">삭제</a>
			</c:if>
		</div>
		<div class="box box-warning">
			<!-- <div class="box-header with-border">
				<a class="btn"><i class="fa fa-pencil margin-r-5"></i> 댓글 쓰기</a>
			</div> -->
			<div class="box-body">
				<c:if test="${not empty loginUser}">
					<form action="reply" method="post">
						<div class="form-group">
							<input type="hidden" name="no" value="${board.no}"> <input
								type="hidden" name="notice_no" value="${board.no}"> <input
								type="hidden" name="board" value="${board}"> <input
								type="hidden" name="row" value="${board.rownum}">
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
					<h5>로그인 한 사용자만 댓글 등록이 가능합니다.</h5>
					<a class="btn" href="../member/login"> 로그인하기 </a>
				</c:if>
				<c:forEach items="${comments}" var="r">
					<div class="table table-bordered">
						<h4 class="replyNo">${r.reply_no }</h4>
						<br>
						<div class="replyWriter"
							style="font-weight: bold; font-size: 2em;">${r.memo }</div>
						<br> 작성자: ${r.writer}<br>
						<h5 class="replyDate">
							<fmt:formatDate value="${r.regDate}"
								pattern="yyyy년 MM월 dd일 HH:mm" />
						</h5>
						<a class="btn">수정</a><a class="btn"
							onclick="댓글을삭제하시겠습니까(${board.no},${r.reply_no})">삭제</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<script type="text/javascript">
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
