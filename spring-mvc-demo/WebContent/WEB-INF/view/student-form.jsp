<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student registration form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">

		First name: <form:input path="firstName" />
		<br>
		<br>
		Last name: <form:input path="lastName" />
		<br>
		<br>
		Country: 
		<form:select path="country">
			<form:options items="${student.countryOptions}" />


		</form:select>

		<br>
		<br>
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		
		<br>
		<br>
		
		Operating System:
		Windows<form:checkbox path="operatingSystem" value="Windows"/>
		Linux<form:checkbox path="operatingSystem" value="Linux"/>
		Mac OS<form:checkbox path="operatingSystem" value="Mac OS"/>	
		
		<br>
		<br>
		<input type="submit" value="Submit" />

	</form:form>






</body>
</html>