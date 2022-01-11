<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<%@ include file="../include/head.jsp"%>
<body>
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/aside.jsp"%>

	<section>
		<div id="board">
			<div class="board-top">
				<a class="btn" href="write" style="margin-right: 13%">글쓰기</a>
			</div>

			<table class="table table-striped">
				<colgroup>
					<col width="10%" span="10">
				</colgroup>
				<thead>
					<tr>
						<th colspan="1">번호</th>
						<th colspan="3">제목</th>
						<th colspan="2">작성자</th>
						<th colspan="2">날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${board}" var="b">
						<tr class="detail">
							<td colspan="1">${b.no}</td>
							<td colspan="3"><a href="read?no=${b.no}">${b.title}</a> <c:if
									test="${b.replyCnt > 0}">
									<span class="badge bg-red">${b.replyCnt}</span>
								</c:if></td>
							<td colspan="2">${b.writer}</td>
							<td colspan="2"><fmt:formatDate value="${b.regDate}"
									pattern="yyyy년 MM월 dd일 HH:mm" /></td>
							<td>${b.hit}</td>
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
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.js"></script>
</body>
</html>