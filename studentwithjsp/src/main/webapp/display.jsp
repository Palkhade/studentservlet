<%@page import="studentwithjsp.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String name=(String)request.getAttribute("name"); %>
<%if(name!=null){ %>
<h1><%="Changed By:"+name %></h1>
<%} %>

<%List<Student> list=(List)request.getAttribute("list");%>

<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Address</th>
<th>Email</th>
<th>Password</th>
<th>Phone Number</th>
<th>Fees</th>
<th>Delete</th>
<th>Update</th>
</tr>

<%for(Student student:list){ %>
<tr>
<td><%=student.getId()%></td>
<td><%=student.getName()%></td>
<td><%=student.getAddress()%></td>
<td><%=student.getEmail()%></td>
<td><%=student.getPassword()%></td>
<td><%=student.getPhone()%></td>
<td><%=student.getFees()%></td>
<td><a href="delete?id=<%=student.getId()%>">delete</a></td>
<td><a href="update?id=<%=student.getId()%>">update</a></td>
</tr>
<%} %>
</table>
</body>
</html>