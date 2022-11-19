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
	<div class="container-md ">
		<div class="container-md p-3 mt-3">
			<div class="card-header">
				<c:choose>
					<c:when test="${not empty info}">
						<div class="row">
							<div class="col">
								<h5 style="display: inline;">${info.nick}</h5>
								<span>님 환영합니다.</span>
							</div>
							<div class="col">
								<a href="logout"><button type="button"
										class="btn btn-outline-primary btn-sm" style="float: right;">로그아웃</button></a>
								<a href="memUpdateForm"><button type="button"
										class="btn btn-warning btn-sm"
										style="float: right; margin-right: 10px;">회원정보수정</button></a> <a
									href="boardInsertForm"><button
										class="btn btn-outline-primary btn-sm"
										style="float: right; margin-right: 10px;">글쓰기</button></a>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="row">
							<div class="col">
								<a href="login"><button type="button"
										class="btn btn-outline-primary btn-sm" style="float: right;">로그인</button></a>
								<a href="join"><button type="button"
										class="btn btn-outline-primary btn-sm" style="float: right; margin-right: 10px;">회원가입</button></a>
								<h6 style="text-align: center; display: inline;">로그인한 회원만 글
									작성이 가능합니다.</h6>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="container p-3 my-3 border text-center">
				<a href="listPage"><h3>Spring 게시판</h3></a>
			</div>
			<!-- 검색 -->



			<div class="card-body">
				<div class="search_area">
					<div class="row">
						<div class="col-6">
							<select class="" style="float: right;" name="type"
								id="searchType">
								<option value=""
									<c:out value="${pageMaker.cri.type == null?'selected':'' }"/>>선택</option>
								<option value="T"
									<c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>제목</option>
								<option value="C"
									<c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>내용</option>
								<option value="W"
									<c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>작성자</option>
								<option value="TC"
									<c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>제목+내용</option>
								<option value="TW"
									<c:out value="${pageMaker.cri.type eq 'TW'?'selected':'' }"/>>제목+작성자</option>
								<option value="TCW"
									<c:out value="${pageMaker.cri.type eq 'TCW'?'selected':'' }"/>>제목+내용+작성자</option>
							</select>
						</div>
						<div class="col-5">
							<input type="text" class="form-control form-control-sm"
								name="keyword" value="${pageMaker.cri.keyword }" id="keyword" />
						</div>
						<div class="col-1">
							<button class="btn btn-sm btn-primary" name="btnSearch"
								id="btnSearch" style="float: right;">검색</button>
						</div>
					</div>
				</div>
			</div>
			<div class="card-body">
				<table class="table table-hover">
					<tr class="active">
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
					<c:set var="rowNum" value="${pageMaker.rowNum }"></c:set>
					<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="5" style="text-align: center;"><span>
										만족하는 검색 결과가 없습니다. </span></td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="vo" items="${list}" varStatus="i">
								<tr>
									<td>${rowNum}</td>
									<td><a class="move" href="${vo.idx}"> ${vo.title}</a></td>
									<td>${vo.writer}</td>
									<td>${vo.indate}</td>
									<td>${vo.count}</td>
								</tr>
								<c:set var="rowNum" value="${rowNum-1 }"></c:set>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>

			</div>

		</div>
		<!-- 페이징 -->
		<div class="card-footer">
			<div class="container-sm text-center" style="float: center;">
				<div class="pageInfo_area">
					<ul class="pagination" style="display: inline-flex">
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
				<input type="hidden" name="keyword"
					value="${pageMaker.cri.keyword }"> <input type="hidden"
					name="type" value="${pageMaker.cri.type }">

			</form>
		</div>
	</div>
	<script>
		// document.ready 는  페이지 로딩 시 반드시 실행이 되는
		$(document).ready(function() {
			let result = '<c:out value = "${result}"/>'
			checkAlert(result);
			console.log(result);

			function checkAlert(result) {
				if (result === '') {
					return;
				}
				if (result === "enrol success") {
					alert("등록이 완료되었습니다.");
				}

				if (result === "modify success") {
					alert("수정이 완료되었습니다.");
				}

				if (result === "delete success") {
					alert("삭제가 완료되었습니다.");
				}
				if (result === "login succsess") {
					alert("로그인 되었습니다.");
				}
				if (result === "login fail") {
					alert("로그인 실패했습니다.");

				}
				if (result === "logout succsess") {
					alert("로그아웃 되었습니다.");
				}
				if (result === "update succsess") {
					alert("회원정보가 수정 되었습니다.");
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
			actionForm.attr("action", "listPage");
			actionForm.submit();
		});

		//제목을 클릭하면 idx값전송하기위해 폼에 input태그 추가하고 action의 url을boardContent 변경 
		//-> 클릭했을 때 pageNum, amount,idx를 보내게됨

		$(".move")
				.on(
						"click",
						function(e) {
							e.preventDefault();
							actionForm
									.append("<input type='hidden' name = 'idx' value= ' "
											+ $(this).attr("href") + " '>");
							actionForm.attr("action", "boardContent");
							actionForm.submit();
						});

		$(".search_area button").on("click", function(e) {
			e.preventDefault();
			let keyword = $("#keyword").val(); //입력받은 키워드값 (id)
			let type = $(".search_area select").val(); //select 중하나 담음

			if (!type) {
				alert("검색할 종류를 선택하세요!")
				return false;
			}
			if (!keyword) {
				alert("검색어를 입력하세요!")
				return false;
			}
			actionForm.find("input[name='type']").val(type);
			actionForm.find("input[name='keyword']").val(keyword); //폼에 값 지정
			actionForm.find("input[name='pageNum']").val(1);
			// 검색을 통해 목록를 이동했을 때 1페이지로 이동을 지정
			actionForm.submit();
			// 검색 후 경로는 그대로  listPage 이므로 그대로 둠
		});
	</script>
</body>
</html>