<%@page import="com.choi.board.common.PageNavigator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
PageNavigator pageNav = (PageNavigator)request.getAttribute("pageNavigator");
int p = (pageNav.getPage().getPage()*10)-10;
int row_ = pageNav.getTotalCount()%10;
int	row = row_ + p;
%>
<html>
<%@ include file="../include/head.jsp"%>
<style>
.table {
	width: 78vw;
	font-size: 14px;
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
	<c:set var="row" value="<%=row%>"></c:set>
	<section>
		<div id="board">
			<h2>자유게시판</h2>
			<div class="board-top">
				<a class="btn" style="margin-right: 5%" onclick="로그인유저인가('write')">글쓰기</a>
			</div>

			<table class="table table-striped">
				<colgroup>
					<col width="12.5%" span="8">
				</colgroup>
				<thead>
					<tr>
						<th colspan="1">번호</th>
						<th colspan="3">제목</th>
						<th colspan="1">작성자</th>
						<th colspan="2">날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boards}" var="b" varStatus="status">
						<tr class="detail">
							<td colspan="1">${row}</td> 
							<td colspan="3"><a onclick="로그인유저인가('read?no=${b.no}&row=${row}')">${b.title}</a>
								<c:if test="${b.replyCnt > 0}">
									<span class="badge bg-red">${b.replyCnt}</span>
								</c:if></td>
							<td colspan="1">${b.writer}</td>
							<td colspan="2"><fmt:formatDate value="${b.regDate}"
									pattern="yyyy년 MM월 dd일 HH:mm" /></td>
							<td>${b.hit}</td><c:set var="row" value="${row - 1}"></c:set>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<footer>
		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination" style="display: inline-block;">
					<c:if test="#{pageNavigator.prev}">
						<li><a href="list?page=${pageNavigator.startPage - 1}">이전</a></li>
					</c:if>
					<c:forEach begin="${pageNavigator.startPage}"
						end="${pageNavigator.endPage}" var="num">
						<li
							<c:out value="${pageNavigator.page.page == num ? 'class=active' : ''}"/>>
							<a href="list?page=${num}" class="btn">${num}</a>
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