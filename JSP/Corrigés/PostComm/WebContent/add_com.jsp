<%@page import="entity.Comm"%>
<%@page import="service.PostService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	PostService ps = new PostService();
	String text = request.getParameter("text");
	if (text != null && text.length() != 0) {
		String sid = request.getParameter("id");
		Comm comm = new Comm(text);
		ps.addComm(session, Integer.parseInt(sid),comm);
	}
	response.sendRedirect("index.jsp");
%>
<body>

</body>
</html>