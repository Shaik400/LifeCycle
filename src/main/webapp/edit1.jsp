<%@page import="dto.Employee"%>
<%@page import="dao.EmployeeDAO"%>
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
EmployeeDAO dao=new EmployeeDAO();
	Employee employee=dao.getEmployeeById(id);
	%>
<form action="edit1">
Id:<input type="text" name="id" value="<%=employee.getId()%>" readonly="readonly"> <br>
Name:<input type="text" name="name" value="<% employee.getName(); %>"> <br>
Mobile:<input type="text" name="mobile" value="<% employee.getMobile(); %>"> <br>

<button type="reset">Cancel</button><button>Update</button>
</form>
</body>
</html>