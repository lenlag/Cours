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
%>
<body>
<form method="GET" action="redirect_paie.jsp" id="form1">
<p></p>
<table>
<tr><td>Numéro carte bleue : </td><td><input type="text" name="cb" id="cb" value=""/></td></tr>
<tr><td>Date d'expiration : </td><td>
<select>
<option>01 - Jan</option>
<option>02 - Fev</option>
<option>03 - Mar</option>
<option>04 - Avr</option>
<option>05 - Mai</option>
<option>06 - Jui</option>
<option>07 - Jul</option>
<option>08 - Aou</option>
<option>09 - Sep</option>
<option>10 - Oct</option>
<option>11 - Nov</option>
<option>12 - Dec</option>
</select>
&nbsp;&nbsp;
<select>
<option>2018</option>
<option>2019</option>
<option>2020</option>
<option>2021</option>
<option>2022</option>
<option>2023</option>
<option>2024</option>
<option>2025</option>
<option>2026</option>
</select>
</td></tr>
<tr><td>Code à 3 chiffres : </td><td><input type="text" name="code" value=""/></td></tr>
</table>
<p></p>
<a href="index.jsp"><input type="button" name="MAJ" id="MAJ" value="Retour" class="button"></a>
<input type="submit" name="RET" id="RET" value="Proceder" class="button">
</form>
</body>
</html>