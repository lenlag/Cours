<%@page import="service.GlobalService"%>
<%@page import="error.ErrorEnum"%>
<%@page import="error.Error"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	GlobalService service = new GlobalService();
	Error err = new Error();
	String login = request.getParameter("login");
	if (login == null || login.length() == 0) {
		err.addError(session, ErrorEnum.LOGIN_PWD_EMPTY);
		response.sendRedirect("error.jsp");
		return;
	}
	String pwd = request.getParameter("pwd");
	if (pwd == null || pwd.length() == 0) {
		err.addError(session, ErrorEnum.LOGIN_PWD_EMPTY);
		response.sendRedirect("error.jsp");
		return;
	}
	if (!service.checkPwd(session,login, pwd)) {
		err.addError(session, ErrorEnum.LOGIN_PWD_BAD);
		response.sendRedirect("error.jsp");
		return;
	}
	response.sendRedirect("person.jsp");
	
%>
</body>
</html>