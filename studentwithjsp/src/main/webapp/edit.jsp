<%@page import="studentwithjsp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Student student=(Student)request.getAttribute("student"); %>
<form action="edit" method="post"> 
Id:<input type="number" name="id" value="<%=student.getId()%>" readonly="readonly"><br><br>
Name:<input type="text" name="name" value="<%=student.getName()%>"><br><br>
ADDRESS:<input type="text" name="address"><br><br>
EMAIL:<input type="text" name="email"><br><br>
PASSWORD:<input type="password" name="password"><br><br>
PHONE:<input type="number" name="phone"><br><br>
<input type="submit" value="EDIT">

</form>
</body>
</html>