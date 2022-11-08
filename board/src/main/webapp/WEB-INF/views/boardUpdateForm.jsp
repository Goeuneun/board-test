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
<title>게시판 글 수정 페이지</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-3">
		<a href="boardlist"><h2>Spring 게시판</h2></a>
		<div class="container p-3 my-3">
			<div class="card-header"><h4>게시판 수정 폼입니다.</h4></div>
			<div class="card-body">
				<form action="boardUpdate" method="post">
					<table class="table table-hover table-bordered">
					<input type="hidden" name="idx" value=${vo.idx } />
						<tr>
							<td>제목</td>
							<td><input class="form-control" type="text" name="title"
								value="${vo.title}" /></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input class="form-control" type="text" name="writer"
								value="${vo.writer }" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea class="form-control" name="contents" rows="5">${vo.contents }</textarea></td>
						</tr>
					</table>
					<button type="submit" class="btn btn-outline-primary btn-sm">제출</button>
					<button type="reset" class="btn btn-warning btn-sm">초기화</button>
					<button onClick="history.back();" type="button"
						class="btn btn-outline-dark btn-sm">뒤로가기</button>
				</form>

			</div>
			<div class="card-footer">게시판</div>
		</div>
	</div>
</body>
</html>