<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<style>
.table {
	width: 78vw;
}

h2 {
	text-align: center;
	margin-right: 15%;
	color: gray;
}
</style>
<body>
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/aside.jsp"%>
	<section>
		<div id="board">
			<h2>공지사항</h2>
			<u:isAdmin>
				<div class="board-top">
					<a class="btn" href="/write" style="margin-right: 5%">글쓰기</a>
				</div>
			</u:isAdmin>
			<u:notAdmin>

				<div class="board-top">

					<a class="btn" href="/" style="margin-right: 5%">관리자로그인</a>
				</div>
			</u:notAdmin>

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
					<tr class="detail" style="cursor: pointer;"
						onClick=" location.href='/'">
						<td>1</td>
						<td>ㅎㅇ</td>
						<td>관리자</td>
						<td>2022.01.05</td>
						<td>3</td>
					</tr>
				</tbody>
			</table></div>
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
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.js"></script>
</body>
</html>