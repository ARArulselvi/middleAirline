<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter user details</title>
</head>
<body>

<form:form action="enterCardDetails" method="POST">
<label>Name</label>
<form:input path="userName"/>

<label>City</label>
<form:input path="city"/>

<label>Number of tickets</label>
<form:input path="numberOfTickets"/>

<input type="submit" value="SUBMIT">
</form:form>

</body>
</html>