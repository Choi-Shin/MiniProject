<%@page import="com.choi.board.common.Member"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp"%>
<%
session = request.getSession(false);
AuthUser loginUser = (AuthUser) session.getAttribute("loginUser");
if (loginUser == null) {
	response.sendRedirect("../board/list");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.pwdChk>label {
	display: inline-block;
	float: left;
	margin-top: 1.5%;
}

label {
	display: block;
}

.pwdChk>.btn {
	float: left !important;
	margin-bottom: 5px;
}

.pwdChk {
	margin-top: 3%;
}

.field>label {
	display: block;
}

#img {
	display: block;
	float: left;
}

.bottom, .bottom>a {
	display: block;
	float: left;
}

div {
	width: 100%;
}
</style>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<%@include file="../include/aside.jsp"%>
	<section>
		<div class="pwdChk">
			<h4>
				정보의 수정을 원하시면 <br> 현재의 비밀번호를 입력해주세요.
			</h4>
			<label for="password">비밀번호<input class="check"
				type="password" name="password" required="required" /></label> <a
				class="btn sm" onclick="비밀번호확인()">비밀번호확인</a>
		</div>
		<div class="field" hidden="hidden">
			<label for="id">아이디<input type="text" value="${member.id}"
				readonly="readonly" /></label> <label for="name">이름<input
				type="text" value="${member.name}" readonly="readonly" /></label>
			<form action="profile" enctype="multipart/form-data" method="post">
				<div id="img">
					<label for="profile">프로필사진<u:hasProfile>
							<img id="profile" src="data:image/png;base64,${profile}" width="300px"
								height="300px" />
							<br>
						</u:hasProfile> <u:nullProfile>
							<img src="/static/img/no_image.jpeg" width="100px"
								height="auto" />
						</u:nullProfile><input type="file" name="profileFile" id="profileFile" /> <br>
						<input class="btn" type="submit" value="사진 변경하기"></label>
				</div>
			</form>
			<form action="email" method="post">
				<label for="email">이메일<input type="text"
					value="${member.email}" name="email" /><input class="btn"
					type="submit" value="이메일 변경"></label>
			</form>
			<div class="bottom">
				<a class="btn sm" onclick="변경폼보이게하기()">비밀번호 변경</a><a class="btn"
					onclick="회원탈퇴하기('${member.id}')">회원탈퇴</a>
			</div>
		</div>
		<form action="modify" method="post" id="newPwd">
			<div class="password" hidden="hidden">
				<label for="newPassword">새로운 비밀번호<input type="password"
					name="newPassword" required="required" /></label> <label for="pwdChk">새로운
					비밀번호 확인<input type="password" name="pwdChk" required="required" />
				</label><br>
				<button type="button" class="btn" onclick="return 보내기()">변경하기</button>
			</div>
		</form>
		
	</section>
	<script type="text/javascript">
		function 비밀번호확인() {
			var password = $('input[name=password]').val();
			if (password === '${loginUser.password}') {
				$('.pwdChk').hide();
				$('.field').removeAttr('hidden');
			} else {
				alert("비밀번호가 다릅니다.");
				$('input[name=password]').val('');
			}
		}

		function 그림파일읽어출력하기(이벤트) {
			var fileInput = 이벤트.target;
			//change이벤트.target(대상)은 <input type="file" name="profileFile" id="profileFile"/>
			var 선택된그림파일관리객체 = fileInput.files[0];
			var 선택된그림size = 선택된그림파일관리객체.size;
			/*
			if(선택된그림size > 1024*10){
			alert("10K 요량초과!");
			fileInput.value="";
			return ;
			}
			 */
			if (!선택된그림파일관리객체.type.match('image.*')) {
				alert("욱! 그림이 아니예요!");
				fileInput.value = "";
				return;
			}
			var 파일리더 = new FileReader();
			파일리더.onload = function(선택된그림파일관리객체) {
				var imgProfile = document.getElementById("profile");
				imgProfile.src = 선택된그림파일관리객체.currentTarget.result;
			};
			파일리더.readAsDataURL(선택된그림파일관리객체);
			return;
		}
		document.querySelector("#profileFile").addEventListener("change",
				그림파일읽어출력하기, false);
	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<%@include file="../include/footer.jsp"%>
</body>
</html>