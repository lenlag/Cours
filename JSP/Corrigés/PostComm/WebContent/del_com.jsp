<%@page import="entity.Comm"%>
<%@page import="service.PostService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	PostService ps = new PostService();
	String pid = request.getParameter("pid");
	String cid = request.getParameter("cid");
	if (pid != null && !pid.isEmpty() && cid != null && !cid.isEmpty()) {
		ps.delComm(session, Integer.parseInt(pid), Integer.parseInt(cid));		
	}
	response.sendRedirect("index.jsp");
%>
<body>

</body>
</html>