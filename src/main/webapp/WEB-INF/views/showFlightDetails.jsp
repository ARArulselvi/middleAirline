<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<h4>success</h4>
<h2>Flight Name: ${selectedFlight.flightName}</h2>
<h2>Price: ${selectedFlight.price}</h2>
<h2>Travel time: ${selectedFlight.travelTime}</h2>
<h2>Available Seats: ${selectedFlight.availableSeats}</h2>
<button onclick="location.href='/enterUserDetails'">pay and book</button>
</body>
</html>