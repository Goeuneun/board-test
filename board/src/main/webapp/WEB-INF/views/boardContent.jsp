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
<title>게시판 글 내용 보기</title>
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
	<div class="container mt-3">
		<a href="boardlist"><h2>Spring 게시판</h2></a>
		<div class="container p-3 my-3">
			<div class="card-header"><h4>Board Content</h4></div>
			<div class="card-body">
				<table class="table table-hover table-bordered">
					<tr>
						<td>제목</td>
						<td>${vo.title}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${vo.writer}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea class="form-control" rows="5"
								readonly="readonly">${vo.contents}</textarea></td>
					</tr>
				</table>
				<c:if test="${info.id eq vo.writer || info.id eq 'admin'}">
					<a href="boardUpdateForm?idx=${vo.idx}"><button
							class="btn btn-outline-primary btn-sm">수정</button></a>
					<a href="boardDelete?idx=${vo.idx}"><button
							class="btn btn-warning btn-sm">삭제</button></a>
				</c:if>
				<button onClick="history.back();" type="button"
					class="btn btn-outline-dark btn-sm">뒤로가기</button>


			</div>
			<div class="card-footer">게시판</div>
		</div>
	</div>
</body>
</html>