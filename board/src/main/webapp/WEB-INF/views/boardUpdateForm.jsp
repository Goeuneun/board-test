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
		<a href="listPage"><h2>Spring 게시판</h2></a>
		<div class="container p-3 my-3">
			<div class="card-header">
				<h4>게시판 수정 폼입니다.</h4>
			</div>
			<div class="card-body">
				<form id = "updateForm" action="boardUpdate" method="post">
					<input type="hidden" name="pageNum" value="${cri.pageNum }" /> 
					<input type="hidden" name="amount" value="${cri.amount}" /> 
					<input type="hidden" name="idx" value="${vo.idx }" />
					<table class="table table-hover table-bordered">
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
					<button type="submit"  id="update_btn"
						class="btn btn-outline-primary btn-sm" data-oper="modify">제출하기</button>
					<button type="button" id ="delete_btn" class="btn btn-warning btn-sm" data-oper="reset">삭제하기</button>
					<button type="button" id ="list_btn" 
						class="btn btn-outline-dark btn-sm" data-oper="list">목록 페이지</button>
				</form>
				
				<form id="infoForm" action="boardUpdate" method="get">
					<input type="hidden" id="bno" name="bno" value='<c:out value="${vo.idx}"/>'>
					<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
					<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>	
				</form>

			</div>
			<div class="card-footer">게시판</div>
		</div>
	</div>


	<script type="text/javascript">
	
	
	
	let form = $("#infoForm");
	let updateForm = $("#updateForm");
	
	//목록 페이지
	$("#list_btn").on("click", function(e){
		form.find("#bno").remove();
		form.attr("action", "listPage");
		form.submit();
	});
	
	// 수정 하기 버튼
	$("#update_btn").on("click", function(e){
		updateForm.submit();
	});
	
	// 삭제 버튼
	$("#delete_btn").on("click", function(e){
		form.attr("action", "boardDelete");
		form.attr("method", "post");
		form.submit();
	});	
	
	
	
	
/* 	$(document).ready(function(){
		
		let form = $("form");
		
		$('button').on("click", function(e){
			e.preventDefault();
			let oper = $(this).data("oper"); 	//data-xxx 속성값 가져오기
			console.log(oper);
			if(oper === 'remove'){
				form.attr("action", "boardDelete");
			} else if(oper === 'list'){
				self.location = "listPage";			//다른 url 이동
				return;
			} 
			form.submit();
		});
		
	}); */
	
	
	
	
/* 		$('#sub').click(function() {
			alert("게시글이 등록되었습니다!");
		}); */
	</script>
</body>
</html>