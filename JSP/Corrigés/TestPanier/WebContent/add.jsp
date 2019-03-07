<%@page import="service.PanierService"%>
<%@page import="service.GlobalService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	PanierService service = new PanierService();
	String sId = request.getParameter("id");
	if (sId == null) {
		response.sendRedirect("error.jsp");
		return;
	}
	long id = 0L;
	try {
		id = Long.parseLong(sId);
	} catch (Exception ex) {
		response.sendRedirect("error.jsp");
		return;
	}
	try {
		service.addInPanier(session, id);
	} catch (Exception ex) {
		response.sendRedirect("error.jsp");
		return;
	}
	response.sendRedirect("panier.jsp");
%>
<body>

</body>
</html>