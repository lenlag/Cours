<%@page import="javax.websocket.SendResult"%>
<%@page import="service.ListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	ListService ls = new ListService();
	String name = request.getParameter("name");
	if (name == null || name.isEmpty()) {
		response.sendRedirect("index.jsp");
		return;
	}
	ls.add(session, name);
	response.sendRedirect("list.jsp");
%>
<body>

</body>
</html>