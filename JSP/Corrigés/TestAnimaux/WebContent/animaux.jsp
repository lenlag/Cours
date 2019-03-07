<%@page import="business.entity.User"%>
<%@page import="business.entity.Animal"%>
<%@page import="business.entity.Person"%>
<%@page import="service.GlobalService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Animaux</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<%
	GlobalService service = new GlobalService();
	User user = service.getUser(session);
	if (user == null) {
		response.sendRedirect("index.jsp");
		return;
	}
	long id = 0L;
	String sId = request.getParameter("id");
	if (sId != null) {
		try {
			id = Long.parseLong(sId);
		} catch (Exception e) {
			// nada
		}
	}
	List<Animal> lista = service.listAnimauxByPersonId(id);
%>
<body>
<table width="100%" border="0">
<tr style="border: 0;">
<td width="100%" align="right" style="border: 0;">Bonjour <%=user.getName() %><td>
<td align="right" style="border: 0;"><a href="unconnex.jsp"><img src="img/logout.jpg" width="24" height="24" /></a><td>
</tr>
</table>
<p></p>
<form action="person.jsp" method="get" id="mainForm">
<table width="100%" border="0" cellspacing="0" cellpadding="5" class="mainTable">
<tr>
<th>Nom</th><th>Couleur pelage</th><th>Sexe</th><th>Espèce</th>
</tr>
<% 
for (Animal a:lista) {
%>

<tr >
<td width="20%"><%=a.getName() %></td><td width="20%"><%=a.getColor() %></td><td><%=a.getSex() %></td><td><%=a.getSpecie().getCommonName() %></td>
</tr>
<% } %>
</table>
<p/>
<input type="submit" name="RET" id="RET" value="Fermer" class="button">
</form>
</body>
</html>