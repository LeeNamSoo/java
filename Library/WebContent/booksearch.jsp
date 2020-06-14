<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Main Page</title>
<meta charset="utf-8">
<!--Made with love by Mutiullah Samim -->
<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {

		$("#btnSearch").click(function() { //버튼 클릭이벤트
			var word = $("#word").val(); //태그입력값
			//var price = $("#price").val();
			//var qty = $("#qty").val();

			if (word == "") { //빈값이면

				alert("검색어를 입력하세요")
				$("#word").focus(); //입력포커스 이동
				return; //함수 종료
			}


			document.form1.submit();
		});
	});
</script>

<style type="text/css">
body {
	padding-top: 70px;
}
</style>
<style>
.centered {
	display: table;
	margin-left: auto;
	margin-right: auto;
}
</style>

</head>

<body>
	<form name="form1" method="get"
		action="${pageContext.request.contextPath}/booksearch"
		id="booksearch_form_id">
		<div class="container">
			<div class="input-group mb-3">
				<input type="text" name="word" class="form-control"
					placeholder="도서명" aria-label="Recipient's username"
					aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="submit"
						id="btnSearch">찾기</button>
				</div>
			</div>
		</div>
	</form>
	<!-- navi end -->
	<div class="row my-4">
		<div class="col-8 mx-auto">
			<div class="container-fluid">
				<p class="font-weight-bolder">도서 관리</p>
			</div>
			<div class="col-8 mx-auto">
				<div class="row justify-content-end my-4">
					<div class="row">

						<div class="col-8 mx-auto">
							<c:url value="./bregister" var="url">
								<c:param name="cno" value="${pageVO.cno}" />
							</c:url>
						</div>
					</div>
				</div>
			</div>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">선택</th>
						<th scope="col">도서코드</th>
						<th scope="col">도서제목</th>
						<th scope="col">저자</th>
						<th scope="col">출판사</th>
						<th scope="col">도서위치</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${searchList}" var="book">
						<tr>
							<td>${book.code}</td>
							<td>${book.title}</td>
							<td>${book.author}</td>
							<td>${book.publisher}</td>
							<td>${book.location}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row my-4">
				<div class="col-md-auto mx-auto">
					<nav>
						<ul class="pagination">
							<c:if test="${not empty result.prevPage}">
								<li class="page-item"><a class="page-link"
									href="${result.prevPage.pageNumber + 1} ">이전
										${result.prevPage.pageNumber + 1}</a></li>
							</c:if>
							<c:forEach items="${result.pageList}" var="p">
								<c:choose>
									<c:when test="${p.pageNumber == result.currentPageNum -1}">
										<li class="page-item active"><a class="page-link"
											href="${p.pageNumber + 1}">${p.pageNumber + 1}<span
												class="sr-only">(current)</span></a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a href="${p.pageNumber +1}">${p.pageNumber + 1}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${not empty result.nextPage}">
								<li class="page-item"><a class="page-link"
									href="${result.nextPage.pageNumber + 1}">다음
										${result.nextPage.pageNumber + 1}</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
			<div class="centered">
				<form name="form2" method="post"
					action="${pageContext.request.contextPath}/booksearch"
					id="bookdelete_form_id">
					<div class="input-group mb-3">
						<div class="input-group-append">
							<button type="button" name="reserve" class="btn btn-primary">예약</button>
							<button type="submit" value="삭제" id="btnDelete"
								class="btn btn-primary"
								onclick="location.href=${pageContext.request.contextPath}/deletebb?code=${text.textID}'">삭제</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>