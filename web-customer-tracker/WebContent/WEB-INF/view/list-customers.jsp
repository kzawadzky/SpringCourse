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

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>

				<c:forEach var="tempCustomer" items="${customers}">

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>

				</c:forEach>

			</table>

		</div>
	</div>

</body>


</html>