<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="service.PanierService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String cb = request.getParameter("cb");
	if (cb == null) {
		cb = "";
	}
	if (cb.equals("0123456789")) {
		response.sendRedirect("index.jsp");
	} else {
		Integer countError = (Integer)session.getAttribute("CB_ERROR");
		if (countError == null) {
			countError = 0;
		}
		if (countError >= 2) {
			System.out.println("3 erreurs de CB -> On sort");
			PanierService service = new PanierService();
			service.clearPanier(session);
			response.sendRedirect("index.jsp");
		} else {
			session.setAttribute("CB_ERROR", ++countError);			
			response.sendRedirect("payer.jsp");
		}
	}
		
%>
<body>

</body>
</html>