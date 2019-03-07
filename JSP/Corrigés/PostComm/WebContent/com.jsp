<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<h2>Nouveau Commentaire</h2>
<form action="add_com.jsp" method="get">
<textarea rows="20" cols="50" name="text"></textarea>
<input type ="hidden" name="id" value='<%=request.getParameter("postId") %>'/>
<p></p>
<input type="submit" value="Envoyer" class="button">&nbsp;<input type="button" value="Annuler" onClick="javascript:window.location='index.jsp'" class="button">
</form>
</body>
</html>