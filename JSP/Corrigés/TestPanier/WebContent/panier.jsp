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
<form method="GET" action="update.jsp" id="form1">
<p></p>
<table width="100%" border="0" cellspacing="0" cellpadding="5" class="mainTable">
<tr>
<th>Code</th><th>Libellé</th><th>Quantité</th><th>Prix</th><th></th>
</tr>
<% 
int idx = 0;
for (PanierItem pi:list) {
%>

<tr >
<td width="20%"><%=pi.getCode() %></td><td width="70%"><%=pi.getLabel() %></td><td><input Type="text" size="3" name="nb_<%=idx %>" value="<%=pi.getNb() %>" /> 

</td>
<td width="5%"><%=pi.getPrice() %></td>
<td width="30"><a href="delete.jsp?id=<%=pi.getId() %>"><img src="img/delete.png" width="16" height="16" ></a></td>
</tr>
<%
idx++;
} 
%>
</table>
<p></p>
<b>Prix Total = <%=service.grandTotal(session) %></b>
<p></p>
<input type="submit" name="MAJ" id="MAJ" value="Mise à jour" class="button">
<a href="index.jsp"><input type="button" name="RET" id="RET" value="Continuer achats" class="button"></a>
<% if (list.size() > 0 ) { %>
<a href="payer.jsp"><input type="button" name="PAY" id="PAY" value="Payer" class="button"></a>
<% } %>
</form>
</body>
</html>