<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
</head>
<body>


	<h3>Add Contact Here</h3>
	<font color="green">${success}</font>
	<font color="red">${error}</font>
	<form:form action="saveContact?id=${contact.id}"
		modelAttribute="contact" method="POST">

		<table>

			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td>e-Mail:</td>
				<td><form:input path="mail" /></td>
			</tr>

			<tr>
				<td>Number:</td>
				<td><form:input path="number" /></td>
			</tr>

			<tr>
				<td><input type="submit" name="ok"></td>
			</tr>
		</table>

	</form:form>
	<a href="viweContacts">View All Contacts</a>
</body>
</html>