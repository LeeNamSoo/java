<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
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

			/*if (price == 0) {

				alert("가격을 입력하세요")
				$("#price").focus();
				return;

			}*/

			/* 폼에 입력한 데이터를 서버로 전송 */
			document.form1.submit();
		});
	});
</script>
<script >
$(document).ready(function() {
	$("#btnInsert").click(function() {
		document.form2.submit()
	});
});
</script>
<style type="text/css">
body {
	padding-top: 70px;
}
</style>
</head>

<body>

	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-primary">
		<a class="navbar-brand" href="${url}index"> <img id="main-logo"
			src="${url}static/img/logo-wcs.svg" width="40" height="40" alt="WCS">
		</a>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="${url}dailynews/dnlist">게시판</a></li>
			</ul>
			<span class="navbar-text mx-2"> <a href='${url}signin'>김종현님
					환영합니다.</a>
			</span>
			<form class="form-inline mt-2 mt-md-0">
				<a class="btn btn-outline-light my-2 my-sm-0" href='${url}signin'>My
					Page</a>
				<!-- <c:choose>
                            <c:when test="${principal eq 'anonymousUser'}">
                                <c:set var="uid" value="" />
                                <a class="btn btn-outline-light my-2 my-sm-0" href='${url}signin'>Log In</a>
                            </c:when>
                            <c:otherwise>
                                <c:set var="uid" value="${principal.member.uid}" />
                                <a id="outBtn"class="btn btn-outline-light my-2 my-sm-0" href='#'>Log Out</a>
                            </c:otherwise>
                        </c:choose> -->
			</form>
			<!-- <form id="logoutform" method="post"> -->
			<!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> -->
			<!-- </form> -->
		</div>
	</nav>
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
	<div class="container justify-content-center" width="400" height="400">
		<div class="row align-items-center justify-content-center">
			<div class="col-sm-8">
				<div class="row justify-content-center">
					<div class="col-4">
						<form name="form2" method="get"
							action="${pageContext.request.contextPath}/bookinsert"
							id="booksearch_form_id">
							<button type="button" id="btnInsert" class="btn btn-primary">도서추가</button>
						</form>
					</div>
					<div class="col-4">
						<button type="button" class="btn btn-primary">그룹 학습실 예약</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- <nav class="navbar fixed-top navbar-expand-md flex-nowrap navbar-new-top">
               <a href="/" class="navbar-brand"><img src="#" alt=""/>MY LIBRARY</a>
               <ul class="nav navbar-nav mr-auto"></ul>
               <ul class="navbar-nav flex-row">
                   <li class="nav-item">
                       <a class="nav-link px-2">@@�� ȯ���մϴ�</a>
                   </li>
                   <li class="nav-item">
                       <button type="button"  class="header-btn">����������</button>
                   </li>
               </ul>
               <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbar2">
                   <span class="navbar-toggler-icon"></span>
               </button>
           </nav>
           <nav class="navbar fixed-top navbar-expand-md navbar-new-bottom">
               <div class="navbar-collapse collapse pt-2 pt-md-0" id="navbar2">
   
                   <ul class="navbar-nav w-100 justify-content-left px-3">
                       <li class="nav-item active">
                           <a class="nav-link" href="#">�Խ���</a>
                       </li>
                   </ul>
         <div class="container" id="searchbox">
            <div class="row">
              <div id="custom-search-input">
                    <div class="input-group col-md-12">
                         <input type="text" class="search-query form-control" placeholder="������ �Է��� �ּ���" />
                              <span class="input-group-btn">
                                  <button class="btn btn-danger" type="button">
                                      <span class=" glyphicon glyphicon-search"></span>
                                   </button>
                              </span>
                     </div>
               </div>
            </div>
      </div>   
               </div>
           </nav>
<div/>
   <div class = "container">
      <div class = "row">
         <button> ���������� </button>
         <span> <button> �ڸ����� </button> </span>
      </div>
   </div>
</div>    -->
</body>