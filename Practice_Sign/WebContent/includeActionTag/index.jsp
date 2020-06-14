<!-- 11 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- category에 따라 header 및 footer를 다르게 출력하는 페이지 --%>
<%
	//현재 페이지 및 포함 페이지에서 사용될 입력데이타 인코딩 방식을 변경
	request.setCharacterEncoding("UTF-8");

	String category=request.getParameter("category");
	//category 파라메터명이 존재하지 않을 경우
	if(category==null) category="main";
	
	String actionHeaderFile="";
	String masterName="";
	if(category.equals("main")) {
		actionHeaderFile="actionMainHeader.jsp";
		masterName="홍길동(hong@jydev.net)";
	} else if(category.equals("blog")) {
		actionHeaderFile="actionBlogHeader.jsp";
		masterName="임꺽정(lim@jydev.net)";
	} else if(category.equals("cafe")) {
		actionHeaderFile="actionCafeHeader.jsp";
		masterName="전우치(jeon@jydev.net)";
	} else {
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
		return;
	}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Standard Action</title>
</head>
<body>
	<h1>include 액션태그</h1>
	<hr>
	<p>다른 JSP 페이지의 실행 결과를 포함시키는 액션태그</p>
	<p> - 현재 JSP 페이지의 제어권을 다른 JSP 페이지로 이동하여 실행 후 
	결과만을 가지고 와서 포함시키는 기능을 구현한 태그</p>
	<%-- <jsp:include page="XXX.jsp"></jsp:include>  => <jsp:include page="XXX.jsp"/> --%>
	<p>형식) &lt;jsp:include page="XXX.jsp"/&gt;</p>
	<hr>
	<%-- Header 영역 --%>
	<%--
	1.include Directive : 외부에 존재하는 웹문서의 내용(코드)를 삽입하는 기능(정적페이지) 
	  => 외부 웹문서를 변경할 경우 현재 페이지가 다시 컴파일하여 사용된다.
	  => 외부 웹문서와 현재 페이지는 서로 데이타를 공유하여 사용할 수 없다.
	  => 외부 웹문서의 파일명 대신 표현식(Expression)을 사용할 수 없다.  
	--%>
	<%-- <h2>JSP 스터디 사이트에 오신것을 환영합니다.</h2> --%>
	<%-- <%@include file="actionHeader.jsp" %> --%>
	
	<%--
	2.include ActionTag : 다른 JSP 페이지의 결과를 포함 시키는 기능(동적페이지)
	  => 다른 JSP 페이지를 변경해도 현재 페이지를 컴파일 시킬 필요가 없다.
	  => 다른 JSP 페이지와 데이타를 공유하여 사용할 수 있다.(request Scope)
	  => 다른 JSP 페이지의 파일명 대신 표현식을 사용할 수 있다.
	--%>
	<%-- <jsp:include page="actionHeader.jsp"/> --%>
	<jsp:include page="<%=actionHeaderFile%>"/>
	<a href="index.jsp?category=main">메인</a>&nbsp;&nbsp;&nbsp;
	<a href="index.jsp?category=blog">블로그</a>&nbsp;&nbsp;&nbsp;
	<a href="index.jsp?category=cafe">카페</a>&nbsp;&nbsp;&nbsp;
	
	<%-- Content 영역 --%>
	<ul>
		<li>웹사이트의 내용이 출력됩니다.</li>
		<li>웹사이트의 내용이 출력됩니다.</li>
		<li>웹사이트의 내용이 출력됩니다.</li>
		<li>웹사이트의 내용이 출력됩니다.</li>
		<li>웹사이트의 내용이 출력됩니다.</li>
		<li>웹사이트의 내용이 출력됩니다.</li>
		<li>웹사이트의 내용이 출력됩니다.</li>
		<li>웹사이트의 내용이 출력됩니다.</li>
		<li>웹사이트의 내용이 출력됩니다.</li>
	</ul>
	
	<%-- Footer 영역 --%>
	<%--
	<hr>
	<p>Copyrightⓒ 2016. <b>JYDevelopment</b> All Rights Reserved.</p>
	<p>Master : 홍길동(hong@jydev.net)</p>
	--%>
	<%-- 
	param액션태그 : include ActionTag 또는 forward ActionTag 에서 사용하는 태그
	 => 제어권이 이동하는 파일에 GET 방식으로 데이터를 전달하는 역할 수행 태그 
	--%>
	<jsp:include page="actionFooter.jsp">
		<jsp:param value="<%=masterName %>" name="master" />
	</jsp:include>
</body>
</html>