<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>proceed</title>
</head>
<body>
<h1>User name: ${User.userName}</h1>
<h1>City : ${User.city}</h1>
<h1>Number of Tickets : ${User.numberOfTickets }</h1>


<input type="submit" onclick="location.href='/payment'" value="BOOK" class="btn btn-dark">
</body>
</html>