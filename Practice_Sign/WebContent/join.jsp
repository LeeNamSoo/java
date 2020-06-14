<!-- 8.1 -->
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- form.jsp 페이지에서 입력하여 전달되는 회원정보를 얻어와 화면에 출력하는 페이지 --%>
<%
	if(request.getMethod().equals("GET")) {
		String msg = "join.jsp 페이지는 GET 방식 요청은 처리하지 않습니다.";
		//response.sendRedirect() 메소드 호출시 QueryString의 한글데이터를 인식하지 못한다.
		// => URLEncoder.encode() 메소드를 호출하여 GueryString의 한글데이터를 
		//    인식할 수 있도록 URL주소의 인코딩 방식 변경
		// => IE 6.0 이하버전 웹브라우저는 GET 방식에 대한 한글을 인식하지 못한다.
		//    해결) server.xml => 63line
		//          <Connector connectionTimeout="20000" port="8000" protocol="HTTP/1.1" redirectPort="8443"/>
		//          Connector 엘리먼트에 URIEncoding="UTF-8" 속성 및 속성값 추가 
		msg = URLEncoder.encode(msg, "UTF-8");
		response.sendRedirect("form.jsp?msg="+msg);
		return;
	}

	//입력데이터에 대한 인코딩 방식 변경
	request.setCharacterEncoding("UTF-8");
	
	//입력데이터를 반환받아 저장
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String sex = request.getParameter("sex");
	String job = request.getParameter("job");
	String[] hobby = request.getParameterValues("hobby");
	String profile = request.getParameter("profile");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
</head>
<body>
	<h1>입력정보 확인</h1>
	<hr>
	<p>아이디 : <%=id %></p>
	<p>이름 : <%=name %></p>
	<p>주소 : <%=addr %></p>
	<p>성별 : <%=sex %></p>
	<p>직업 : <%=job %></p>
	<% if(hobby.length == 0) { %>
		<p>취미 : 없음</p>
	<%}	else {%>
		<p>취미 : 
			<% for(String str:hobby) { %>
				<%= str %>&nbsp;&nbsp;
			<% } %>
		</p>
	<% }%>
	<p>자기소개 : <%=profile %></p>
</body>
</html>