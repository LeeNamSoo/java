<!-- 12 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//입력데이터에 대한 인코딩 방식을 변경
	// => 포함되는 JSP 페이지에서 인코딩 방식을 변경해도 적용되지 않는다.
	//request.setCharacterEncoding("UTF-8");
	
	String master = request.getParameter("master");
%>
<hr>
<p>Copyrightⓒ 2016. <b>JYDevelopment</b> All Rights Reserved.</p>
<%-- <p>Master : 홍길동(hong@jydev.net)</p> --%>
<p>Master : <%=master %></p>