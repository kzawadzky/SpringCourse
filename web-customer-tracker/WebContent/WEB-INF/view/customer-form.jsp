<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relation Manager</h2>
		</div>
	</div>

	<div id="containter">
		<h3>Save customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<table>
				<tbody>
				<tr>
					<td><label>First name:</label></td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td><label>Last name:</label></td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"></td>
				</tr>
				
				</tbody>
			
			</table>
		
		</form:form>
	<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
	
	</div>

</body>
</html>





