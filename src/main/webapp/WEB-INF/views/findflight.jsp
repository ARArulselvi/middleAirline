<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find flights</title>
</head>
<body>
<div class="container">
<form:form action="findMyFlight" method="POST">
<label>Source</label>
<form:input path="source"/>

<label>Destination</label>
<form:input path="destination"/>

<input type="submit" value="ADD">
</form:form>
</div>
</body>
</html>