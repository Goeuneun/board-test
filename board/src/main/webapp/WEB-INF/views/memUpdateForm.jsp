<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container p-3 my-3">
		<a href="boardlist"><h2>Spring 게시판</h2></a>
		<h4>회원정보수정</h4>
		<p>회원가입을 위한 정보를 입력해주세요</p>
		<form action="updateInfo" class="was-validated" method="post">
			<div class="form-group">
				<label for="id">Id:</label> <input type="text" class="form-control"
					id="uname" placeholder="아이디를 입력하세요" name="id" value="${info.id}"
					readonly="readonly" required>
				<div class="invalid-feedback">입력되지 않았습니다.</div>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="비밀번호를 입력하세요" name="pw"
					value="${info.pw}" required>
				<div class="valid-feedback">입력값이 유효합니다.</div>
				<div class="invalid-feedback">입력되지 않았습니다.</div>
			</div>
			<div class="form-group">
				<label for="nick">Nick name:</label> <input type="text"
					class="form-control" id="nick" placeholder="닉네임을 입력하세요" name="nick"
					value="${info.nick}" required>
				<div class="valid-feedback">입력값이 유효합니다.</div>
				<div class="invalid-feedback">입력되지 않았습니다.</div>
			</div>
			<div class="form-group">
				<label for="phone">Phone Number:</label> <input type="text"
					class="form-control" id="phone" placeholder="휴대전화번호를 입력하세요"
					name="phone" value="${info.phone}" required>
				<div class="valid-feedback">입력값이 유효합니다.</div>
				<div class="invalid-feedback">입력되지 않았습니다.</div>
			</div>
			<button type="submit" class="btn btn-primary">수정완료</button>
			<button type="reset" class="btn btn-warning btn-sm">초기화</button>
			<button onClick="history.back();" type="button"
				class="btn btn-outline-dark btn-sm">뒤로가기</button>

		</form>
	</div>
</body>
</html>