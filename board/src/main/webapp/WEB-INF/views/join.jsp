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
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

</head>
<body>
	<div class="container p-3 my-3">
		<a href="listPage"><h3 style="text-align:center;">Spring 게시판</h3></a>
		<h4>회원가입</h4>
		<p>회원가입을 위한 정보를 입력해주세요</p>
		<form action="joinInsert" class="was-validated" method="post">
			<div class="form-group">
				<label for="id">Id:</label> <input type="text" class="form-control"
					id="id" placeholder="아이디를 입력하세요" name="id" required="required"
					maxlength="10">
				<button type="button" id="idCheck" class="btn btn-warning btn-sm">중복체크</button>
				<div class="valid-feedback">
					<span id="idValid"> </span>
				</div>
				<div class="invalid-feedback">최대 10자리까지 가능합니다.</div>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control chk" readonly="readonly" id="pwd"
					placeholder="비밀번호를 입력하세요" name="pw" required maxlength="10">
				<div class="valid-feedback">입력값이 유효합니다.</div>
				<div class="invalid-feedback">최대 10자리까지 가능합니다.</div>
			</div>
			<div class="form-group">
				<label for="nick">Nick name:</label> <input type="text"
					class="form-control chk" id="nick" readonly="readonly"
					placeholder="닉네임을 입력하세요" name="nick" required maxlength="10">
				<div class="valid-feedback">입력값이 유효합니다.</div>
				<div class="invalid-feedback">최대 10자리까지 가능합니다.</div>
			</div>
			<div class="form-group">
				<label for="phone">Phone Number:</label> <input type="text"
					class="form-control chk" id="phone" readonly="readonly"
					placeholder="000-0000-0000" name="phone" required >
				<div class="valid-feedback"><span id="phoneVal"></span></div>
				<div class="invalid-feedback">형식에 맞는 번호를 입력하세요</div>
			</div>
			<button id="sub" type="submit" class="btn btn-primary">회원가입</button>
			<button type="reset" class="btn btn-warning btn-sm">초기화</button>
			<button onClick="history.back();" type="button"
				class="btn btn-outline-dark btn-sm">뒤로가기</button>

		</form>
	</div>
</body>
<script>



	$("#phone").keyup(function(){
		const regex = /\d{3}-\d{4}-\d{4}/; 
		let phone = $(this).val();
		console.log(phone);
		if(phone.match(regex)==null){
			$('#phoneVal').text('잘못된 번호형식입니다.');
			$('#phoneVal').css('color', 'red');
			$("#sub").attr("disabled", true);
		} else {
			$('#phoneVal').text('올바른 번호형식입니다.');
			$('#phoneVal').css('color', 'green');
			$("#sub").attr("disabled", false);
			
			
		}

	});

	
	$('.chk').click(function() {
		if (this.getAttribute('readonly') == 'readonly') {
			alert('아이디 중복체크를 먼저 해주세요');
		}
	});

	/* 	if ($('#id').val > 10 ){
	 $('#idValid').text('글자수 초과 입니다.');

	 } */

	/* 	$('#sub').click(function(){
	 alert("회원가입 되었습니다!");
	 }); 
	 */

	$('#idCheck').click(function() {
		let id = $('#id').val();
		$.ajax({
			url : "idCheck",
			type : "post",
			data : {
				"id" : id
			},
			success : idcheckJson, //함수호출
			error : function(e) {
				console.log(e);
			}
		});
	});

	function idcheckJson(data) {
		console.log(data.id);
		if (data.id == undefined) { // 값이 null일때 
			console.log("아이디사용 가능");
			$('.chk').removeAttr('readonly');
			$('#idValid').text('사용 가능한 아이디입니다.');
			$('#idValid').css('color', 'blue');
		} else {
			console.log("아이디사용 불가능");
			$('.chk').attr('readonly', true);
			$('#idValid').text('중복된 아이디입니다.');
			$('#idValid').css('color', 'red');
		}

	};

/* 	$('.chk').on('keyup', function() {
		validate($(this));
	});

	function validate(t) {
		var data = join.tag_status(t);
		display_status(t.siblings('valid-feedback'), data);
	}
	//siblings 형제요소 찾는 함수 

	function display_status(div, data) {
		div.text(data.desc);
		div.addClass(data.code);
	} */
</script>
</html>