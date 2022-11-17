<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
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
		<a href="listPage"><h2>Spring 게시판</h2></a>
		<h4>로그인 창</h4>
		<p>로그인 하시려면 아이디와 비밀번호를 입력해주세요</p>
		<form action="loginSelect" class="was-validated" method="post">
			<div class="form-group">
				<label for="uname">Id:</label> <input type="text"
					class="form-control" id="uname" placeholder="Id를 입력하세요" name="id"
					required>
				<div class="invalid-feedback">입력되지 않았습니다.</div>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Password를 입력하세요"
					name="pw" required>
				<div class="invalid-feedback">입력되지 않았습니다.</div>
			</div>
			<button id="login" type="submit" class="btn btn-primary">로그인</button>
			<a href="join"><button type="button" class="btn btn-warning">회원가입</button></a>
			<button onClick="history.back();" type="button"
				class="btn btn-outline-dark">뒤로가기</button>

		</form>
	</div>
</body>

	<script>
	
/* 	$(document).ready(
		$('#login').click(function(){
			$.ajax({
				url : "loginSelect",
				type : "post",
				dataType : "text",
				success : function(res){
					if(res != null){
						alert(res); 	
					} else {
						alert("로그인 실패!"); 		
					}
				},
				error : function(res){
					console.log(res);
				}
			});
		});
	); */
	
	
	</script>
</html>