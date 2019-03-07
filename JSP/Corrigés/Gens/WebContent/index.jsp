<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Les gens</title>
<script>
function mySubmit() {
	var name = document.getElementById("name").value;
	window.location="add_name.jsp?name="+name;
}
</script>
</head>
<h2>Entrez un nom</h2>
<body>
<form id="form1" action="list.jsp">
<input type="text" name="name" id="name"/>
<p></p>
<input type="button" name="sub" value="ok" class="button" onClick="mySubmit()">&nbsp;<input type="submit" name="voir" value="Voir liste" class="button">
</form>
</body>
</html>