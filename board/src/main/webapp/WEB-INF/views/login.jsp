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
		<a href="listPage"><h3 style="text-align:center;">Spring 게시판</h3></a>
		<h6>로그인 창</h6>
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
<script>
	
$(document).ready(function() {
 		let result = '<c:out value = "${result}"/>'
 		checkAlert(result);
 		console.log(result);
 		function checkAlert(result){
 			if(result === ''){
 	 			return;
 	 		}if (result === "join success") {
				alert("회원가입이 완료되었습니다.");
			}
 		}
}); 
	
	
	</script>
</body>

</html>