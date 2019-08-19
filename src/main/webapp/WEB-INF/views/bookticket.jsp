<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Book tickets now</title>
</head>
<body>
<h3>book now</h3>
<div class="container">

<table class="table table-striped">
<tr>
		<th>flightNumber</th>
        <th>flightName</th>
        <th>price</th>
        <th>source</th>
        <th>destination</th>
        <th>travelTime</th>  
        <th>availableSeats</th> 
</tr>
<c:forEach items="${flightlist}" var="eachFlight">


    <tr>      
    	<td name="flightNumber">${eachFlight.flightNumber}</td>
        <td>${eachFlight.flightName}</td>
        <td>${eachFlight.price}</td>
        <td>${eachFlight.source}</td>
        <td>${eachFlight.destination}</td>
        <td>${eachFlight.travelTime}</td>  
        <td>${eachFlight.availableSeats}</td> 
        
       <!-- <td><input type="submit" onclick="location.href='/enterDetails'" value="BOOK" class="btn btn-dark"></td> -->
        <td><input type="submit" onclick="location.href='/showDetails/${eachFlight.flightNumber}'" value="BOOK" class="btn btn-dark"></td>
    </tr>
     
   
</c:forEach>
 </table>

</div>
<%-- <p>${flightlist}</p> --%>
</body>
</html>