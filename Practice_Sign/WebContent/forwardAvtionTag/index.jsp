<!-- 13 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Standard Action</title>
</head>
<body>
	<h1>forward 액션태그</h1>
	<hr>
	<p>현재 페이지에서 다른 페이지로 제어권을 이동하여 결과를 출력시키는 태그</p>
	<p> - 요청 URL 주소의 변화 없이 다른 JSP 페이지의 결과가 출력</p>
	<p> 형식) &lt;jsp:forward page="XXX.jsp"/&gt;</p>
	<hr>
	<a href="indexController.jsp?cmd=main">메인페이지</a>&nbsp;&nbsp;
	<a href="indexController.jsp?cmd=list">회원전체보기</a>&nbsp;&nbsp;
	<a href="indexController.jsp?cmd=view">회원상세보기</a>&nbsp;&nbsp;
	<a href="indexController.jsp?cmd=login">로그인</a>
</body>
</html>