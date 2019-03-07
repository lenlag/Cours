<%@page import="java.util.List"%>
<%@page import="entity.Post"%>
<%@page import="entity.Comm"%>
<%@page import="service.PostService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<%
	PostService ps = new PostService();
	if (ps.getPosts(session) == null) {
		Post post = new Post("post1");
		ps.addPost(session, post);
		Comm comm = new Comm("com1-1");
		ps.addComm(session, post.getId(), comm);
		comm = new Comm("com1-2");
		ps.addComm(session, post.getId(), comm);

		post = new Post("post2");
		ps.addPost(session, post);
		comm = new Comm("com2-1");
		ps.addComm(session, post.getId(), comm);

		post = new Post("post3");
		ps.addPost(session, post);
		comm = new Comm("com3-1");
		ps.addComm(session, post.getId(), comm);
		comm = new Comm("com3-2");
		ps.addComm(session, post.getId(), comm);
		comm = new Comm("com3-3");
		ps.addComm(session, post.getId(), comm);
	}
	
	List<Post> list = ps.list(session);
	int a = 0;
%>
<body>
<h2>Forum</h2>
<table width="100%" border="1" class="mainTable">
<% for (Post p:list) { %>
	<tr><td width="40%"><%=p.getText() %></td><td width="40"><a href="com.jsp?postId=<%=p.getId() %>"><img src="img/add.png" width="16" height="16"/></a><a href="del_post.jsp?pid=<%=p.getId() %>"><img src="img/delete.png" width="16" height="16"/></a></td><td></td><td></td></tr>
	<% for (Comm c:p.getComms()) { %>
	<tr><td></td><td></td><td><%=c.getText() %></td><td><a href="del_com.jsp?cid=<%=c.getId() %>&pid=<%=p.getId() %>"><img src="img/delete.png" width="16" height="16"/></a></td></tr>
	<% } %>
<% } %>
</table>
<p></p>
<input type="button" value="Ajouter post" onClick="javascript:window.location='post.jsp'" class="button"/>
</body>
</html>