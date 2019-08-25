<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer CONFIRMED!</title>
</head>
<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName} 
<br>
<br>
Customer free passes: ${customer.freePasses}
<br>
<br>
Customer postal code: ${customer.postalCode}
<br>
<br>
Customer course code: ${customer.courseCode}

</body>
</html>