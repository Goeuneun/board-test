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
					<c:set var="rowNo" value="${pg.rowNo }"></c:set>
					<c:forEach var="vo" items="${list}" varStatus="i">
						<tr>
							<td>${rowNo}</td>
							<td><a href="boardContent?idx=${vo.idx}">${vo.title}</a></td>
							<td>${vo.writer}</td>
							<td>${vo.count}</td>
							<td>${vo.indate}</td>
						</tr>
						<c:set var="rowNo" value="${rowNo-1 }"></c:set>
					</c:forEach>
				</table>
			</div>
			<div class="form-group row justify-content-center">
				<div style="float: center;">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#"
							onClick="fn_prev('${pg.viewPage}','${pg.range }','${pg.viewPageCnt }')">Previous</a></li>

						<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
							<li
								class="page-item <c:out value="${pg.viewPage == i ? 'active' : ''}"/> "><a
								class="page-link" href="boardlist?viewPage=${i }"
								onClick="fn_pagination('${i}', '${pg.range}', '${pg.viewPageCnt}')">
									${i } </a></li>
						</c:forEach>
						<c:if test="${pg.next}"></c:if>
						<li class="page-item"><a class="page-link" href="#"
							onClick="fn_next('${pg.range}', '${pg.range}', '${pg.viewPageCnt}')">Next</a></li>
					</ul>
				</div>

				<!-- 검색 -->

				<div class="form-group row justify-content-center">
					<div class="w100" style="padding-right: 10px">
						<select class="form-control form-control-sm" name="searchType"
							id="searchType">
							<option value="title">제목</option>
							<option value="contents">본문</option>
							<option value="writer">작성자</option>
						</select>
					</div>
					<div class="w300" style="padding-right: 10px">
						<input type="text" class="form-control form-control-sm"
							name="keyword" id="keyword">
					</div>
					<div>
						<button class="btn btn-sm btn-primary" name="btnSearch"
							id="btnSearch" >검색</button>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
<script>


	$(document).on('click', '#btnSearch', function(e){
		e.preventDefault();			// a태그나 submit과같은 동작을 중단시킴 
		var url = "${pageContext.request.contextPath}/boardlist";
		url = url + "?searchType=" + $('#searchType').val();
		url = url + "&keyword=" + $('#keyword').val();
		location.href = url;
		console.log(url);
	});	
	
	
	
	//이전 버튼 이벤트
	function fn_prev(viewPage, range, viewPageCnt) {
		var viewPage = ((range - 2) * viewPageCnt) + 1;
		var range = range - 1;
		var url = "${pageContext.request.contextPath}/boardlist";
		url = url + "?viewPage=" + viewPage;
		url = url + "&range=" + range;
		location.href = url;
	}

	//페이지 번호 클릭
	function fn_pagination(viewPage, range, viewPageCnt, searchType, keyword) {
		var url = "${pageContext.request.contextPath}/boardlist";
		url = url + "?viewPage=" + viewPage;
		url = url + "&range=" + range;
		location.href = url;
	}

	//다음 버튼 이벤트
	function fn_next(viewPage, range, viewPageCnt) {
		var viewPage = parseInt((range * viewPageCnt)) + 1;
		var range = parseInt(range) + 1;
		var url = "${pageContext.request.contextPath}/boardlist";
		url = url + "?viewPage=" + viewPage;
		url = url + "&range=" + range;
		location.href = url;
	}
</script>
</html>