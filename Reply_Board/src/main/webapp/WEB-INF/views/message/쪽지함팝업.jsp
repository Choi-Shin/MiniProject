<%@page import="java.util.ArrayList"%>
<%@page import="com.choi.board.common.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.choi.board.common.AuthUser"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.messageMenu {
	float: left;
	display: inline-block;
}

.messageNote {
	border: 1px gray solid;
	border-radius: 0.5rem;
}
</style>
</head>
<body>
	<div id="message">
		<div class="messageMenu">
			<span><a class="btn" href="/message/receiveBox">수신함</a></span> <span>
				<a class="btn" href="/message/sendBox">발신함</a>
			</span>
		</div>

		<table class="table">
			<colgroup>
				<col width="17%" span="6">
			</colgroup>
			<thead>
				<tr>
					<th colspan="3">제목</th>
					<th colspan="1">작성자</th>
					<th colspan="2">날짜</th>
				</tr>
			</thead>
			<tbody id='tbody'>
				<c:forEach items="${list}" var="b" varStatus="status">
					<tr class="detail">
						<td colspan="3" onclick="로그인유저인가('read?no=${b.no}')"><h4>${b.title}</h4>
							<c:forEach items="${loginUser.unreadMsg}" var="m" varStatus="s">
							<c:if test="${m.no eq b.no}">
								<span class="badge bg-red">읽지 않음</span>
							</c:if></c:forEach></td>
						<td colspan="1">${b.send_id}</td>
						<td colspan="2"><fmt:formatDate value="${b.date_sent}"
								pattern="yyyy년 MM월 dd일 HH:mm" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="box-footer">
		<div class="text-center">
			<ul class="pagination" style="display: inline-block;">
				<c:if test="#{pageNavigator.prev}">
					<li><a
						href="/message/main?page=${pageNavigator.startPage - 1}">이전</a></li>
				</c:if>
				<c:forEach begin="${pageNavigator.startPage}"
					end="${pageNavigator.endPage}" var="num">
					<li
						<c:out value="${pageNavigator.page.page == num ? 'class=active' : ''}"/>>
						<a href="/message/main?page=${num}" class="btn">${num}</a>
					</li>
				</c:forEach>
				<c:if test="${pageNavigator.next && pageNavigator.endPage > 0}">
					<li><a href="/message/main?page=${pageNavigator.endPage + 1}">다음</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<a class="btn" onclick="쪽지함나가기()">닫기</a>
	<script>
		function 쪽지함나가기() {
			opener.document.location.reload();
			self.close();
		}
	</script>
</body>
</html>