<%@page import="java.util.List"%>
<%@page import="service.ListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Les gens</title>
</head>
<%
	ListService ls = new ListService();
	List<String> list = ls.list(session);
%>
<body>
<h2>Liste des noms</h2>
<table class="mainTable" width="50%">
<%
int idx = 0;
for (String name:list) { %>
<tr><td width="100%"><%=name %></td><td width="20"><a href="delete_name.jsp?idx=<%=idx %>"><img src="img/delete.png" width="16" height="16"/></a></td></tr>
<%
idx++;
} %>
</table>
<p></p>
<form action="index.jsp">
<input type="submit" name="sub" value="Retour" class="button"/>
</form>
</body>
</html>