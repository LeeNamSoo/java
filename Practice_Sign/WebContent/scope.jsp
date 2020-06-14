<!-- 10 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- scope(범위) : JSP 페이지에서 공유한 객체를 다른 JSP 페이지에서 공유하여 사용할 수 있는 범위 --%>
<%-- 객체 공유 방법 : 내장객체의 속성정보를 이용하여 속성값을 저장 
<%--  => 사용 내장객체에 따라 공유 범위가 다르다. --%>
<%-- 형식) 내장객체.setAttribute(Key, Value); => Key:문자열(중복불가) Value:공유객체--%>
<%
	//1. page Scope : pageContext 내장객체를 이용하여 객체 공유
	// => 객체를 공유한 JSP 페이지에서만 반환 받아 사용 가능
	pageContext.setAttribute("pageName", "홍길동");
	
	//2. request Scope : request 내장객체를 이용하여 객체 공유
	// => 객체를 공유한 JSP 페이지 및 제어권을 이동한 JSP 페이지에서 사용 가능
	// => 제어권 이동 : include ActionTag 또는 forward ActionTag에 의해 다른 JSP 페이지로 스레드 변경
	request.setAttribute("requestName", "임꺽정");
	
	//3. session Scope : session 내장객체를 이용하여 객체 공유
	// => Context에 존재하는 모든 JSP 페이지에서 반환 받아 사용 가능
	// => session 속성값은 30분(지속시간) 또는 웹브라우저가 실행되어 있는 동안
	session.setAttribute("sessionName", "전우치");
	
	//4. application Scope : application 내장객체를 이용하여 객체 공유
	// => Context에 존재하는 모든 JSP 페이지에서 반환 받아 사용 가능
	// => application 속성값은 서버가 중지되기 전까지 속성값 유지
	application.setAttribute("applicationName", "일지매");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scope</title>
</head>
<body>
	<h1>Scope 속성 저장 및 사용</h1>
	<hr>
	<%-- 공유된 객체를 반환받는 방법 --%>
	<%--  => 공유 객체는 Object 객체로 반환 - 객체 형변환 후 사용 가능 --%>
	<%--  => Key에 대한 공유 객체가 존재하지 않을 경우 null 반환 --%>
	<%-- 형식) 내장객체.getAttribute(Key) : Key를 이용하여 Value(공유객체) --%>
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
	<a href="scopeUse.jsp">scopeUse.jsp 페이지 이동</a>
</body>
</html>