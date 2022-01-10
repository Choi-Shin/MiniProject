<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside>
	<div class="aside">
		<ul>
			<li style="width: 100%"><a class="btn" href="/"
				style="width: 90%">메인화면으로</a></li>
			<li style="width: 100%"><a class="btn" href="#" onclick="공지사항()"
				style="width: 90%">공지사항</a></li>
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
	<script type="text/javascript">
		function 참고한자료() {
			$("#board").empty().text('동빈나 유튜브');
		}
		function 공지사항() {
			$("#board").empty().load('notice');
		}
	</script>

</aside>