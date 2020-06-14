<!-- 14 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//param 액션태그에 의해 전달된 데이터(문자열)를 반환받아 저장
	//String msg = request.getParameter("msg");

	//request 내장객체에 의해 저장된 속성값을 변환받아 사용
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1>
	<hr>
	<p><%=msg %></p>
	<hr>
	<a href="index.jsp">홈 화면으로 이동</a>
</body>
</html>