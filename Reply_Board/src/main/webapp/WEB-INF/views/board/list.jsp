<%@page import="com.choi.board.common.PageNavigator"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
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

.user_data {
	position: absolute;
	z-index: 100;
	background-color: white;
	border: 1px gray solid;
	border-radius: 1rem;
}

.user_data>ul {
	margin-top: 1rem;
}

.wrapper {
	width: 1250px;
}

</style>
<body>
<div class="wrapper">
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/aside.jsp"%>
	
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
				<tbody id='tbody'>
					<c:forEach items="${boards}" var="b" varStatus="status">
						<tr class="detail">
							<td colspan="1">${b.rownum}</td>
							<td colspan="3" onclick="로그인유저인가('read?no=${b.no}')">${b.title}
								<c:if test="${b.replyCnt > 0}">
									<span class="badge bg-red">${b.replyCnt}</span>
								</c:if>
							</td>
							<td colspan="1"><c:choose><c:when test="${loginUser.id != b.writer}"><a class="menu"
								onclick="메뉴보이기('${b.writer}${b.rownum}')">${b.writer}</a></c:when><c:otherwise>${b.writer }</c:otherwise></c:choose>
								<div id="${b.writer}${b.rownum}" class="user_data"
									style="display: none"
									onmouseleave="메뉴사라지기('${b.writer}${b.rownum}')">
									<ul class="user_data_list">
										<li><a href="/board/search?id=${b.writer}&page=1">작성글
												보기 </a></li>
										<li><a onclick="메시지보내기('${b.writer}')">메시지
												보내기 </a></li>
										<li class="bg_grey"><a
											href="/mgallery/board/lists/?id=github&amp;s_type=search_name&amp;s_keyword=%EA%B2%8C%EC%9C%BC%EB%A5%B8%EB%91%94%EC%9E%AC">
												회원 정보 보기<em class="sp_img icon_go"></em>
										</a></li>
										<li class="bg_grey"><a
											href="//gallog.dcinside.com/engmatpro">차단하기<em
												class="sp_img icon_go"></em></a></li>
									</ul>
								</div></td>
							<td colspan="2"><fmt:formatDate value="${b.regDate}"
									pattern="yyyy년 MM월 dd일 HH:mm" /></td>
							<td>${b.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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
		<%@include file="../include/footer.jsp"%>
	</section></div>
	<script>
		function 메뉴보이기(menu) {
			var link = document.getElementById(menu);
			if (link.style.display == 'none') {
				link.style.display = 'block';
			} else {
				link.style.display = 'none';
			}
		}

		function 메뉴사라지기(menu) {
			var link = document.getElementById(menu);
			link.style.display = 'none';
		}
		
		function 메시지보내기(id) {
			var url = "/message/send?id=" + id;
			var x = document.body.offsetWidth/2;
			var y = window.screen.height/2;
			var popupX = (document.body.offsetWidth / 2) - (500 / 2);
			var popupY= (window.screen.height / 2) - (300 / 2);
			window.open(url,'메시지 보내기','resizable=no width=500 height=300 left=' + popupX +', top='+ popupY +'return false');
		}
	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.js"></script>

</body>
</html>