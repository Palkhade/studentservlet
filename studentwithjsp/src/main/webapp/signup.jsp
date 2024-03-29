<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message");%>
<% if(message!=null){%>
<h1><%=message %></h1><%}else{ %>
<h1><%="WELCOME to signup page" %></h1><%} %>


<form action="signup" method="post">
NAME:<input type="text" name="name"><br><br>
ADDRESS:<input type="text" name="address"><br><br>
EMAIL:<input type="text" name="email"><br><br>
PASSWORD:<input type="password" name="password"><br><br>
PHONE:<input type="number" name="phone"><br><br>
<input type="submit" value="SUBMIT">
</form>
</body>
</html>