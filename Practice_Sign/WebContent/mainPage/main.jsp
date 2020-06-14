<!-- 15 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
모든 JSP 페이지의 Header 영역과 Footer 영역이 동일하다.
 => Header 영역과 Footer 영역이 변경될 경우 모든 JSP 페이지를 변경해야만 된다.
 => Header 영역과 Footer 영역의 내용을 외부파일로 만들어 코드 삽입(include Directive)
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MainPage</title>
</head>
<body>
	<%-- Header 영역 --%>
	<%-- <%@include file="header.jspf" %>--%>
	
	<%-- Content 영역 --%>
	<h2>여기는 메인페이지입니다.</h2>
	
	<%-- Footer 영역 --%>
	<%-- <%@include file="footer.jspf" %>--%>
</body>
</html>