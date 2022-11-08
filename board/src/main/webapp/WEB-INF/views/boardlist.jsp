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
<title>게시판 목록</title>
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
			<div class="card-header" >
				<h4>Board List</h4>
				<c:choose>
					<c:when test="${not empty info}">
						${info.nick} 님 환영합니다.
						<a href="logout"><button type="button"
								class="btn btn-outline-primary btn-sm"
								>로그아웃</button></a>
						<a href="memUpdateForm"><button type="button"
								class="btn btn-warning btn-sm"
								>회원정보수정</button></a>
					</c:when>
					<c:otherwise>
						<a href="login" style="display: block" ><button type="button"
								class="btn btn-outline-primary btn-sm" >로그인</button></a>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="card-body">
				<table class="table table-hover">
					<tr class="active">
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>조회수</td>
						<td>작성일</td>
					</tr>

					<c:forEach var="vo" items="${list}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td><a href="boardContent?idx=${vo.idx}">${vo.title}</a></td>
							<td>${vo.writer}</td>
							<td>${vo.count}</td>
							<td>${vo.indate}</td>
						</tr>
					</c:forEach>
				</table>
				<a href="boardInsertForm"><button
						class="btn btn-outline-primary btn-sm">글쓰기</button></a>

			</div>
			<div class="card-footer">게시판</div>
		</div>
	</div>
</body>
</html>