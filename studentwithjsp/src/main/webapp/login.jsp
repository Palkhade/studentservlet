<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<h1><%=message %></h1><%}else{ %>
<h1><%="WelCome to Login Page"%></h1><%} %>
<form action="login" method="post">
EMAIL:<input type="text" name="email"><br><br>
PASSWORD:<input type="password" name="password"><br><br>
<input type="submit" value="SUBMIT">
</form>
</body>
</html>