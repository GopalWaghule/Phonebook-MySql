<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PHONEBOOK</title>

<script>
	function confirmDelete() {
		return confirm("Are you sure, you want to delete");
	}
</script>

</head>


<body>

	<a href="getContact">+Add New Contact</a>
	<table border="1">

		<thead>
			<tr>
				<td>Name</td>
				<td>Mail</td>
				<td>Number</td>
				<td>Action</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${contacts}" var="contact">
				<tr>
					<td>${contact.name}</td>
					<td>${contact.mail}</td>
					<td>${contact.number}</td>
					<td><a href="editContact?cid=${contact.id}">Edit</a> 
					    <a
						href="deleteContact?cid=${contact.id}"
						onclick="return confirmDelete()">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>