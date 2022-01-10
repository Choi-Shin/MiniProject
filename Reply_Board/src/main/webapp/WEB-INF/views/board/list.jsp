<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<%@ include file="../include/head.jsp" %>
<body>
	<header>
		<h1>미니 프로젝트</h1>
		<nav>
			<ul>
				<u:notLogin>
					<li><a class="btn" href="#" onclick="팝업창('login')">로그인</a></li>

					<li><a class="btn" href="#" onclick="팝업창('register')">회원가입</a></li>
				</u:notLogin>
				<u:isLogin>
					<li><a class="btn" href="#" onclick="팝업창('login')">회원정보수정</a></li>

					<li><a class="btn" href="member/logout">로그아웃</a></li>
				</u:isLogin>
			</ul>
		</nav>
	</header>
	<aside>
		<div class="aside">
			<ul>
				<li style="width: 100%"><a class="btn" href="/"
					style="width: 90%">메인화면으로</a></li>
				<li style="width: 100%"><a class="btn" href="#"
					onclick="공지사항()" style="width: 90%">공지사항</a></li>
				<li style="width: 100%"><a class="btn" href="list"
					style="width: 90%">자유게시판</a></li>
				<li style="width: 100%"><a class="btn" href="#"
					onclick="참고한자료()" style="width: 90%">참고한 자료</a></li>
				<li style="width: 100%"><a class="btn"
					href="https://github.com/Choi-Shin/ToyProject" target="_blank"
					onclick="contact()" style="width: 90%">contact<br> <img
						src="http://img.shields.io/badge/-Github-655ced?style=flat&logo=github&link=https://github.com/Choi-Shin/ToyProject"
						style="height: auto;" /></a></li>
			</ul>
		</div>

	</aside>

	<section>
		<div id="board">
			<div class="board-top">
				<a class="btn" href="write">글쓰기</a>
			</div>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${board}" var="board">
						<tr class="detail">
							<td>${board.no}</td>
							<td><a href="#" onclick="글보기(${board.no})">${board.title}</a>
								<c:if test="${board.replyCnt > 0}">
									<span class="badge bg-red">${board.replyCnt}</span>
								</c:if></td>
							<td>${board.writer}</td>
							<td><fmt:formatDate value="${board.regDate}"
									pattern="yyyy년 MM월 dd일 HH:mm" /></td>
							<td>${board.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<footer>
		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="#{pageNavigator.prev}">
						<li><a href="list?page=${pageNavigator.startPage - 1}">이전</a></li>
					</c:if>
					<c:forEach begin="${pageNavigator.startPage}"
						end="${pageNavigator.endPage}" var="num">
						<li
							<c:out value="${pageNavigator.page.page == num ? 'class=active' : ''}"/>>
							<a href="list?page=${num}">${num}</a>
						</li>
					</c:forEach>
					<c:if test="${pageNavigator.next && pageNavigator.endPage > 0}">
						<li><a href="list?page=${pageNavigator.endPage + 1}">다음</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</footer>
	<script type="text/javascript">
		$(function(){
			var msg = "${msg}";
			if (msg != null){
				alert(msg);
			}
		});
		
		function 참고한자료() {
			$("#board").empty().text('동빈나 유튜브');
		}
		function 공지사항() {
			$("#board").empty().load('notice');
		}
		function 글보기(no) {
			var board = "read?no="+no;
			$("#board").empty().load(board);
		}
		
		function 팝업창(type){
			var url = "../member/"+type;
			var popupX = (document.body.offsetWidth / 2) - (200 / 2);
			var popupY= (window.screen.height / 2) - (300 / 2);
			window.open(url,'type','resizable=no width=300 height=200 left=' + popupX +', top='+ popupY +'return false');
		}
	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.js"></script>
</body>
</html>