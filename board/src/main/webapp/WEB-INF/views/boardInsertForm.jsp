<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kr.web.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 작성페이지</title>
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
	<c:choose>
		<c:when test="${empty info}">
			<script>
			let yesNo = confirm("로그인 해주세요");
			if (yesNo){
				location = 'login';
			}else {
				location = 'listPage';
			}
			</script>
		</c:when>
		<c:otherwise>
			<div class="container mt-3">
				<a href="boardlist"><h2>Spring 게시판</h2></a>
				<div class="container p-3 my-3">
					<div class="card-header">
						<h4>글 작성 폼입니다</h4>
					</div>
					<div class="card-body">
						<form action="boardInsert" method="post">
							<table class="table table-hover table-bordered">
								<tr>
									<td>제목</td>
									<td><input class="form-control" type="text" name="title" />
									</td>
								</tr>
								<tr>
									<td>작성자</td>
									<c:choose>
										<c:when test="${not empty info.id }">
											<td><input class="form-control" type="text"
												name="writer" value="${info.id }" readonly="readonly" /></td>
										</c:when>
										<c:otherwise>
											<td><input class="form-control" type="text"
												name="writer" /></td>

										</c:otherwise>

									</c:choose>
								</tr>
								<tr>
									<td>내용</td>
									<td><textarea class="form-control" name="contents"
											rows="5"></textarea></td>
								</tr>
							</table>
							<button id="sub" type="submit"
								class="btn btn-outline-primary btn-sm">제출</button>
							<button type="reset" class="btn btn-warning btn-sm">초기화</button>
							<button onClick="history.back();" type="button"
								class="btn btn-outline-dark btn-sm">뒤로가기</button>
						</form>
					</div>
					<div class="card-footer">게시판</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<script>
		$('#sub').click(function() {
			alert("게시글이 등록되었습니다!");
		});
	</script>
</body>
</html>