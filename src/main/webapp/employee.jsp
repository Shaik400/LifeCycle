<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
</head>
<body>
    <h1>Employee List</h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Mobile Number</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="employee" items="${employee}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.mobile}</td>
                <td>
                    <form action="employee" method="GET">
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="id" value="${employee.id}">
                        <button type="submit">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="employee" method="GET">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${employee.id}">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <hr>

    <h2>Add Employee</h2>
    <form action="employee" method="POST">
        <input type="hidden" name="action" value="save">
        ID: <input type="text" name="id"><br>
        Name: <input type="text" name="name"><br>
        Mobile: <input type="text" name="mobile"><br>
        <button type="submit">Save</button>
    </form>
    
    <hr>
    
    <h2>Search Employees</h2>
    <form action="employee" method="POST">
        <input type="hidden" name="action" value="search">
        Search By:
        <select name="searchType">
            <option value="name">Name</option>
            <option value="id">ID</option>
        </select>
        <input type="text" name="searchValue">
        <button type="submit">Search</button>
    </form>
</body>
</html>
