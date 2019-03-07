<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<h2>Nouveau Post</h2>
<form action="add_post.jsp" method="get">
<textarea rows="20" cols="50" name="text"></textarea>
<p></p>
<input type="submit" value="Envoyer" class="button">&nbsp;<input type="button" value="Annuler" onClick="javascript:window.location='index.jsp'" class="button">
</form>
</body>
</html>