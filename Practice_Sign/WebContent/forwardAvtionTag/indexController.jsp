<!-- 14 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//제어권이 이동된 JSP 페이지에서의 입력데이터(문자열)에 대한 인코딩 방식 변경
	request.setCharacterEncoding("UTF-8");

	String cmd = request.getParameter("cmd");
	//index.jsp 요청에 의해 실행된 경우가 아닌 indexController.jsp를
	//직접 요청하여 실행된 경우에 대한 초기값 설정
	if(cmd==null) cmd="main";
	
	//cmd에 저장된 값에 따라 서로 다른 파일명을 저장
	String actionFile = "";
	//cmd에 저장된 값에 따라 서로 다른 데이터를 저장
	String msg = "";
	if(cmd.equals("main")) {
		actionFile="actionMain.jsp";
		msg="여기는 메인페이지입니다.";
	} else if(cmd.equals("list")) {
		actionFile="actionList.jsp";
		msg="[홍길동,임꺽정,전우치,일지매]";
	} else if(cmd.equals("view")) {
		actionFile="actionView.jsp";
		msg="홍길동님 회원정보를 출력합니다.";
	} else if(cmd.equals("login")) {
		actionFile="actionLogin.jsp";
		msg="로그인 입력 페이지입니다.";
	} else {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	//request 내장객체를 이용하여 속성값 저장 : request Scope 객체
	// => 현재 페이지 및 제어권이 이동된 페이지에서 공유되어 사용 가능한 속성값(객체)	
	request.setAttribute("msg", msg);
%>
<%-- 다른 JSP 페이지로 제어권 이동 => 제어권이 이동된 JSP 페이지의 결과 출력 (현재 페이지의 결과는 출력되지 않는다.) --%>
<%-- param 액션태그를 이용하여 제어권이 이동된 JSP 페이지에 데이터(문자열) 전달 --%>
<%--
<jsp:forward page="<%=actionFile%>">
	<jsp:param value="<%=msg%>" name="msg" />
</jsp:forward>
--%>

<<jsp:forward page="<%=actionFile %>"></jsp:forward>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>