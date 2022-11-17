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
		<a href="listPage"><h2>Spring 게시판</h2></a>
		<div class="container p-3 my-3">
			<div class="card-header">
				<h4>Board List</h4>
				<c:choose>
					<c:when test="${not empty info}">
						<h5>${info.nick}</h5> 님 환영합니다.
						<div style="float: right;">
							<a href="boardInsertForm"><button
									class="btn btn-outline-primary btn-sm">글쓰기</button></a> <a
								href="logout"><button type="button"
									class="btn btn-outline-primary btn-sm">로그아웃</button></a> <a
								href="memUpdateForm"><button type="button"
									class="btn btn-warning btn-sm">회원정보수정</button></a>
						</div>
					</c:when>
					<c:otherwise>
						<a href="login"><button type="button"
								class="btn btn-outline-primary btn-sm">로그인</button></a>
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
					<c:set var="rowNo" value="${pageMaker.total }"></c:set>
					<c:forEach var="vo" items="${list}" varStatus="i">
						<tr>
							<td>${rowNo}</td>
							<td><a class="move" href="${vo.idx}"> ${vo.title}</a></td>
							<td>${vo.writer}</td>
							<td>${vo.count}</td>
							<td>${vo.indate}</td>
						</tr>
						<c:set var="rowNo" value="${rowNo-1 }"></c:set>
					</c:forEach>
				</table>

			</div>
			<div class="pageInfo_wrap">
				<div class="pageInfo_area">
					<ul class="pagination" style="float: center;">
						<c:if test="${pageMaker.prev}">
							<li class="page-item"><a class="page-link"
								href="${pageMaker.startPage-1}">Previous</a></li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}" var="num">
							<li
								class="page-item ${pageMaker.cri.pageNum == num ? 'active' : '' } ">
								<a class="page-link" href="${num }"> ${num} </a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next }">
							<li class="page-item"><a class="page-link"
								href="${pageMaker.endPage +1}">Next</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<form id="actionForm" action="listPage" method="get">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}" />
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}" />
			</form>
			<span>로그인한 회원만 글쓰기가 가능합니다.</span>
		</div>
	</div>
<script>

		// document.ready 는  페이지 로딩 시 반드시 실행이 되는
	$(document).ready(function() {
		let result = '<c:out value = "${result}"/>'
		checkAlert(result);
		console.log(result);
		
		function checkAlert(result){
			if(result === ''){
				return;
			}
			if(result === "enrol success"){
				alert("등록이 완료되었습니다.");
			}
			
			if(result === "modify success"){
				alert("수정이 완료되었습니다.");
			}
			
			if(result === "delete success"){
				alert("삭제가 완료되었습니다.");
			}
		}
		 
	});	 
		let actionForm = $("#actionForm");
		
		 // 페이징 안에서 a태그 찾기
		$(".page-item a").on("click", function(e) {
			e.preventDefault(); // page-item클래스의 a태그 페이지이동속성 없애는 작업
			console.log('click');
		 // form 태그 내부 pageNum과 관련된 input태그의 value 속성을 클릭한 a 태그의 페이지 번호를 삽입 
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		 // =>  form태그 서버 전송
			actionForm.submit();
		});
		
		 
		 
		//제목을 클릭하면 idx값전송하기위해 폼에 input태그 추가하고 action의 url을boardContent 변경 
		//-> 클릭했을 때 pageNum, amount,idx를 보내게됨
		
		$(".move").on("click", function(e){
			e.preventDefault();
			actionForm.append("<input type='hidden' name = 'idx' value= ' " + $(this).attr("href") + " '>");
			actionForm.attr("action", "boardContent");
			actionForm.submit();
		});

</script>
</body>
</html>