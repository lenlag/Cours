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
</script>
</head>
<%
	List<Person> listp = new GlobalService().listPersons();
%>
<body>
<form method="POST" action="animaux.jsp" id="form1">
<img src="img/chat.png" width="200" height="150" />
<table width="100%" border="0" cellspacing="0" cellpadding="5" class="mainTable">
<tr>
<th>Prénom</th><th>Nom</th><th>Age</th><th>Nb Animaux</th>
</tr>
<% 
for (Person p:listp) {
%>

<tr >
<td width="20%"><%=p.getFirstName() %></td><td width="20%"><%=p.getLastname() %></td><td><%=p.getAge() %></td><td><a href="javascript:submitThat(<%=p.getId() %>)"><%=p.getList().size() %></a></td>
</tr>
<% } %>
</table>
<input type="hidden" id="theId" name="id" value=""/>
</form>
<p></p>


</body>
</html>