<%@page import="entity.PanierItem"%>
<%@page import="service.PanierService"%>
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
	PanierService service = new PanierService();
	List<PanierItem> list = service.list(session); 
%>
<body>
<form method="GET" action="index.jsp" id="form1">
<p></p>
<table width="100%" border="0" cellspacing="0" cellpadding="5" class="mainTable">
<tr>
<th>Code</th><th>Libellé</th><th>Quantité</th><th>Prix</th>
</tr>
<% 
int idx = 0;
for (PanierItem pi:list) {
%>

<tr >
<td width="20%"><%=pi.getCode() %></td><td width="70%"><%=pi.getLabel() %></td><td><%=pi.getNb() %> 
</td>
<td width="5%"><%=pi.getPrice() %></td>
</tr>
<%
idx++;
} 
%>
</table>
<p></p>
<b>Prix Total = <%=service.grandTotal(session) %></b>
<p></p>
<input type="submit" name="MAJ" id="MAJ" value="Retour site" class="button">
<% if (list.size() > 0 ) { %>
<a href="cb.jsp"><input type="button" name="RET" id="RET" value="Payer" class="button"></a>
<% } %>
</form>
</body>
</html>