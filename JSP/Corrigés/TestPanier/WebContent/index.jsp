<%@page import="business.entity.BoutiqueItem"%>
<%@page import="service.GlobalService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Panier</title>
<link rel="stylesheet" type="text/css" href="main.css">
<script>
</script>
</head>
<%
	GlobalService service = new GlobalService();
	List<BoutiqueItem> list = service.list(); 
%>
<body>
<form method="POST" action="panier.jsp" id="form1">
<p></p>
<table width="100%" border="0" cellspacing="0" cellpadding="5" class="mainTable">
<tr>
<th>Code</th><th>Libellé</th><th>Prix</th><th></th>
</tr>
<% 
for (BoutiqueItem bi:list) {
%>

<tr >
<td width="20%"><%=bi.getCode() %></td><td width="70%"><%=bi.getLabel() %></td><td width="10%"><%=bi.getPrice() %></td>
<td width="30"><a href="add.jsp?id=<%=bi.getId() %>"><img src="img/add.png" width="16" height="16" ></a></td>
</tr>
<% } %>
</table>
<p></p>
<input type="submit" name="RET" id="RET" value="Voir panier" class="button">
</form>
</body>
</html>