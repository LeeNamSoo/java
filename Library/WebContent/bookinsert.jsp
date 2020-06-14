<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE  >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서추가</title>

<script src="http://code.jquery.com/jquery-3.1.0.js">
	
</script>

<script>
	$(document).ready(function() {

		$("#btnAdd").click(function() { //버튼 클릭이벤트
			var publisher = $("#publisher").val();
			var code = $("#code").val();
			var title = $("#title").val(); //태그입력값
			var author = $("#author").val();
			var location = $("#location").val();
			//var price = $("#price").val();
			//var qty = $("#qty").val();
			if (publisher == "") { //빈값이면

				alert("도서코드을 입력하세요")
				$("#publisher").focus(); //입력포커스 이동
				return; //함수 종료

			}
			if (code == "") { //빈값이면

				alert("도서코드을 입력하세요")
				$("#code").focus(); //입력포커스 이동
				return; //함수 종료

			}
			if (title == "") { //빈값이면

				alert("도서명을 입력하세요")
				$("#title").focus(); //입력포커스 이동
				return; //함수 종료

			}

			if (author == "") {

				alert("저자명을 입력하세요")
				$("#author").focus();
				return;

			}
			if (location == "") { //빈값이면

				alert("도서코드을 입력하세요")
				$("#location").focus(); //입력포커스 이동
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

</head>
<body>
	<!-- request.getContextPath() = 컨택스트 페스를 리턴함 -->
	a
	<!-- ction ="/컨텍스트/가상디렉토리 / 서블릿 url" -->
	<!-- id 는 jsp에서 쓸 것이고 name은 서블릿에서 사용할 것이다. -->
	<h2>도서 정보 등록</h2>

	<form name="form1" method="post"
		action="${pageContext.request.contextPath}/bookinsert"
		id="bookinsert_form_id">

		<table border="1">
			<tr>
				<td>도서코드</td>
				<td><input type="text" name="code"></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><input name="title" name="title"></td>
			</tr>

			<tr>
				<td>저자</td>
				<td><input type="text" name="author" id="author"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="publisher" id="publisher"></td>
			</tr>
			<tr>
				<td>도서위치</td>
				<td><input type="text" name="location"></td>
			</tr>


			<tr>
				<td colspan="2" align="center"><input type="button" id="btnAdd"
					value="확인"> <input type="reset" value="취소"></td>
			</tr>


		</table>

	</form>

</body>
</html>


