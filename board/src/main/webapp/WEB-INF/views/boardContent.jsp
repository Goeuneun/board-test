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
					<a id="modify"><button type="button"
							class="btn btn-outline-primary btn-sm" >수정</button></a>
					<a href="boardDelete?idx=${vo.idx}" id="list_delete"><button
							class="btn btn-warning btn-sm">삭제</button></a>
				</c:if>
				<a id = "list_btn"><button  type="button"
					class="btn btn-outline-dark btn-sm">목록페이지</button></a>
			</div>
			<div class="card-footer">게시판</div>
			
			<form id="infoForm" action="boardUpdateForm" method="get">
				<input type="hidden" id="idx" name="idx" value="${vo.idx}"/>
				<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
				<input type="hidden" name="amount" value="${cri.amount}"/>
				<input type="hidden" name="keyword" value="${cri.keyword }"/>
			</form>
		</div>
	</div>
	
	
	
	<script>
	
	let form = $("#infoForm");
	
	// 목록버튼 이벤트 -> idx 지우고 매핑 listPage
	$("#list_btn").on("click",function(e){
		form.find("#idx").remove();
		form.attr("action", "listPage");
		form.submit();
		
	});
	
	
	// 수정버튼 이벤트 -> 현재페이지와 개수 정보, idx 컨트롤러로보냄
	$("#modify").on("click",function(e){
		form.attr("action", "boardUpdateForm");
		form.submit();
		
	});
	
	
	
	</script>
</body>
</html>