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
	long id = 0L;
	String sId = request.getParameter("id");
	if (sId != null) {
		try {
			id = Long.parseLong(sId);
		} catch (Exception e) {
			// nada
		}
	}
	List<Animal> lista = new GlobalService().listAnimauxByPersonId(id);
%>
<body>
<form action="index.jsp" method="get" id="mainForm">
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