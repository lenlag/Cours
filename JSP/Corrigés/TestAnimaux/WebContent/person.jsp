<%@page import="business.entity.User"%>
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
<script>
function submitThat(id) {
	var hidden = document.getElementById("theId");
	hidden.value = id;
	var form = document.getElementById("form1");
	form.submit();
}
function myDelete(id,name) {
	if (confirm("Etes-vous sur de vouloir détruire "+name+" ?")) {
		window.location="process.jsp?id="+id+"&cmd=DEL";
	}
}
</script>
</head>
<%
	GlobalService service = new GlobalService();
	User user = service.getUser(session);
	if (user == null) {
		response.sendRedirect("index.jsp");
		return;
	}
	boolean isAdmin = user.isAdmin();
	List<Person> listp = null;
	try {
		listp = service.listPersons();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>
<body>
<form method="POST" action="animaux.jsp" id="form1">
<table width="100%" border="0">
<tr style="border: 0;">
<td width="100%" align="right" style="border: 0;">Bonjour <%=user.getName() %><td>
<td align="right" style="border: 0;"><a href="unconnex.jsp"><img src="img/logout.jpg" width="24" height="24" /></a><td>
</tr>
</table>
<p></p>
<table width="100%" border="0" cellspacing="0" cellpadding="5" class="mainTable">
<tr>
<th>Prénom</th><th>Nom</th><th>Age</th><th>Nb Animaux</th>
<% if (isAdmin) { %>
<th></th><th></th>
<% } %>
</tr>
<% 
for (Person p:listp) {
%>

<tr >
<td width="20%"><%=p.getFirstName() %></td><td width="20%"><%=p.getLastname() %></td><td><%=p.getAge() %></td><td><a href="javascript:submitThat(<%=p.getId() %>)"><%=p.getList().size() %></a></td>
<% if (isAdmin) { %>
<td width="30"><a href="javascript:myDelete(<%=p.getId() %>,'<%=p.getLastname() %>')"><img src="img/delete.png" width="16" height="16" ></a></td>
<td width="30"><a href="createOrUpdate.jsp?id=<%=p.getId() %>"><img src="img/edit.png" width="16" height="16"></a></td>
<% }  %>
</tr>
<% } %>
</table>
<input type="hidden" id="theId" name="id" value=""/>
</form>
<p></p>
<% if (isAdmin) { %>
<form action="createOrUpdate.jsp">
<input type="submit" name="RET" id="RET" value="Créer" class="button">
</form>
<% } %>
<p></p>


</body>
</html>