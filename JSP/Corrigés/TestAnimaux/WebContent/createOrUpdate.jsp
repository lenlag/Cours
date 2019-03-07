<%@page import="business.entity.User"%>
<%@page import="service.GlobalService"%>
<%@page import="business.entity.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="business.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<%
	GlobalService service = new GlobalService();
	User user = service.getUser(session);
	if (user == null) {
		response.sendRedirect("index.jsp");
		return;
	}
	String sId = request.getParameter("id");
	long id = 0;
	if (sId != null) {
		try {
			id = Long.parseLong(sId);
		} catch (Exception ex) {
			// nada
		}
	}
	Person person = null;
	String age = "";
	String cmd = "CREATE";
	if (id == 0) {
		person = new Person(0L,"","",0,new ArrayList<Animal>());
	} else {
		try {
			person = service.getPersonById(id);
			age = ""+person.getAge();
		} catch (Exception ex) {
			ex.printStackTrace();
			response.sendRedirect("error.jsp");
			return;
		}
		cmd = "UPD";
	}
%>
<body>
<table width="100%" border="0">
<tr style="border: 0;">
<td width="100%" align="right" style="border: 0;">Bonjour <%=user.getName() %><td>
<td align="right" style="border: 0;"><a href="unconnex.jsp"><img src="img/logout.jpg" width="24" height="24" /></a><td>
</tr>
</table>
<p></p>
<% if (id == 0) { %>
<h2>Créer un utilisateur</h2>
<% } else { %> 
<h2>Modifier un utilisateur</h2>
<% } %> 
<form action="process.jsp">
<table>
<tr><td>Prénom personne : </td><td><input type="text" name="prenom" value="<%=person.getFirstName() %>"></td></tr>
<tr><td>Nom personne : </td><td><input type="text" name="nom" value="<%=person.getLastname() %>"></td></tr>
<tr><td>Age personne : </td><td><input type="text" name="age" value="<%=age %>"></td></tr>
</table>
<p></p>
<input type="hidden" name="id" value="<%=id %>"/>
<input type="hidden" name="cmd" value="<%=cmd %>"/>
<input type="submit" value="Ok" class="button"/>&nbsp;&nbsp;
<input type="button" value="Annuler" class="button" onclick="javascript:window.location='person.jsp'"/>
</form>
</body>
</html>