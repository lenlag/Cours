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
	PanierService service = new PanierService();
	int i = 0;
	List<Integer> nbs = new ArrayList<>();
	while(true) {
		String sId = request.getParameter("nb_"+i);
		if (sId == null || sId.length() == 0) {
			break;
		}
		nbs.add(Integer.parseInt(sId));
		i++;
	}
	if (nbs.size() != 0) {
		try {
			service.globalUpdatePanier(session, nbs);
		} catch (Exception ex) {
			response.sendRedirect("error.jsp");
			return;
		}
	}  
	response.sendRedirect("panier.jsp");
%>
<body>

</body>
</html>