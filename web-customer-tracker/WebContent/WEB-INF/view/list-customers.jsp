<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>

	<title>List customers</title>
	
	<!-- reference to style sheet -->
	
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relation Manager</h2>
		</div>
	</div>

	<div id="containter">
		<div id="content">
			<!-- add button  -->
			<br>
			<input type="button" value="Add customer"
					onclick="window.location.href='showFormForAdd'; return false;"	
					class="add-button"
			/>
			<br>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Edit</th>
				</tr>

				<c:forEach var="tempCustomer" items="${customers}">

				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<a href="${updateLink}">Edit</a>
							|
							<a href="${deleteLink}" 
							onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>
	</div>

</body>


</html>