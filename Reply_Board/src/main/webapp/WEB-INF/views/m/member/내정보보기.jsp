<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%@include file="../include/memberheader.jsp"%>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="pwdChk">
				<h4>
					정보 조회를 원하시면 <br> 현재의 비밀번호를 입력해주세요.
				</h4>
				<label for="password">비밀번호<input type="password"
					name="password" required="required" /></label> <a class="btn"
					onclick="비밀번호확인()">비밀번호확인</a>
			</div>
			<div class="field" hidden="hidden">
				<label for="id">아이디<input type="text" value="${member.id}"
					readonly="readonly" /></label> <label for="name">이름<input
					type="text" value="${member.name}" readonly="readonly" /></label> <label
					for="email">이메일<input type="text" value="${member.email}"
					readonly="readonly" style="width: 80%" /></label> <a class="btn"
					onclick="변경폼보이게하기()">비밀번호 변경</a> <a class="btn"
					onclick="회원탈퇴하기(${member.id})">회원탈퇴</a>
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
		</div>
		<div class="col-sm-4"></div>
	</div>
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

		function 변경폼보이게하기() {
			$('.field').hide();
			$('.password').removeAttr('hidden');
		}

		function 보내기() {
			var newPassword = $('input[name=newPassword]').val();
			var pwdChk = $('input[name=pwdChk]').val();
			if (newPassword === pwdChk) {
				document.getElementById('newPwd').submit();
			} else {
				alert('입력된 비밀번호가 서로 다릅니다.');
				return false;
			}
		}
		function 회원탈퇴하기(아이디) {
			var id = 아이디;
			var 동의 = prompt("탈퇴하시려면 id를 입력해주세요.");
			if(동의 === 아이디) {
				location.href="member/withdraw?id="+아이디;
			} else {
				alert('입력되지 않았거나 id가 다릅니다.');
			}	
		}
	</script>
	<script src="/static/js/jQuery-3.6.0.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>