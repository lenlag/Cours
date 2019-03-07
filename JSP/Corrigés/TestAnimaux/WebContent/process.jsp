<%@page import="error.ErrorEnum"%>
<%@page import="error.Error"%>
<%@page import="business.entity.Animal"%>
<%@page import="business.entity.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.GlobalService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	Error error = new Error();
	String sId = request.getParameter("id");
	long id = 0;
	if (sId != null) {
		try {
			id = Long.parseLong(sId);
		} catch (Exception ex) {
			// nada
		}
	}
	String cmd = request.getParameter("cmd");
	if (cmd == null) {
		error.addError(session, ErrorEnum.CMD_EMPTY);
		response.sendRedirect("error.jsp");
		return;
	}
	GlobalService service = new GlobalService();
	if (cmd.equals("DEL")) {
		try {
			service.delete(id);			
		} catch (Exception ex) {
			ex.printStackTrace();
			response.sendRedirect("error.jsp");
			return;
		}
	} else if (cmd.equals("UPD") || cmd.equals("CREATE")) {
		String prenom = request.getParameter("prenom");		
		String nom = request.getParameter("nom");		
		String sAge = request.getParameter("age");
		if (nom == null || prenom == null || sAge == null) {
			error.addError(session, ErrorEnum.NOM_PRENOM_AGE_EMPTY);
			response.sendRedirect("error.jsp");
			return;
		}
		if (nom.length() == 0 || prenom.length() == 0 || sAge.length() == 0) {
			error.addError(session, ErrorEnum.NOM_PRENOM_AGE_EMPTY);
			response.sendRedirect("error.jsp");
			return;
		}
		int age = 0;
		try {
			age = Integer.parseInt(sAge);			
		} catch (Exception ex) {
			error.addError(session, ErrorEnum.AGE_ERROR);
			response.sendRedirect("error.jsp");
			return;
		}
		if (cmd.equals("CREATE")) {
			try {
				Person p = new Person(0L,prenom,nom,age,new ArrayList<Animal>());
				service.create(p);			
			} catch (Exception ex) {
				ex.printStackTrace();
				response.sendRedirect("error.jsp");
				return;
			}
		} else {
			try {
				Person p = service.getPersonById(id);
				p.setFirstName(prenom);
				p.setLastname(nom);
				p.setAge(age);
				service.update(p);			
			} catch (Exception ex) {
				ex.printStackTrace();
				response.sendRedirect("error.jsp");
				return;
			}
		}
	} else {
		response.sendRedirect("error.jsp");
		return;
	}
	response.sendRedirect("person.jsp");
%>
<body>
<input type="button" onclick="javascript:window.location='person.jsp'">
</body>
</html>