<!-- 10.1 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scope</title>
</head>
<body>
	<h1>Scope 속성값 사용</h1>
	<hr>
	<%
		String pageName = (String)pageContext.getAttribute("pageName");
		String requestName = (String)request.getAttribute("requestName");
		String sessionName = (String)session.getAttribute("sessionName");
		String applicationName = (String)application.getAttribute("applicationName");
	%>
	<ul>
		<li>page Scope 속성값 = <%=pageName %></li>
		<li>request Scope 속성값 = <%=requestName %></li>
		<li>session Scope 속성값 = <%=sessionName %></li>
		<li>application Scope 속성값 = <%=applicationName %></li>
	</ul>
	<a href="scope.jsp">scope.jsp 페이지 이동</a>
</body>
</html>