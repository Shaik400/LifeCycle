<%@page import="dto.Student"%>
<%@page import="dao.studentdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("id")); %>

<%
studentdao dao=new studentdao();
	Student student=dao.fetch(id);
	%>
<form action="edit">
Id:<input type="text" name="id" value="<%=student.getId()%>" readonly="readonly"> <br>
Name:<input type="text" name="name" value="<% student.getName(); %>"> <br>
Mobile:<input type="text" name="mobile" value="<% student.getNumber(); %>"> <br>
Email:<input type="text" name="email" value="<% student.getEmail(); %>"> <br>
Password<input type="text" name="password" value="<% student.getPassword(); %>"> <br>
<button type="reset">Cancel</button><button>Update</button>
</form>
</body>
</html>