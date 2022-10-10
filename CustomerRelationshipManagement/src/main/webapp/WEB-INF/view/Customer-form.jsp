<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer</title>
</head>

<body>

	<div class="container">

		<h3>Customer Relationship Management Directory</h3>
		<hr>

		<p class="h4 mb-4">Customer</p>

		<form action="/CustomerRelationshipManagement/customer/save"
			method="POST">

			
			<input type="hidden" name="id" value="${customerEntity.id}" />

			<div class="form-inline">
				<input type="text" name="firstName"
					value="${customerEntity.firstName}" class="form-control mb-4 col-4"
					placeholder="FirstName">



			</div>

			<div class="form-inline">

				<input type="text" name="lastName"
					value="${customerEntity.lastName}" class="form-control mb-4 col-4"
					placeholder="LastName">



			</div>

			<div class="form-inline">

				<input type="text" name="email" value="${customerEntity.email}"
					class="form-control mb-4 col-4" placeholder="Email">



			</div>
			>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/CustomerRelationshipManagement/customer/list">Back to
			Customers List</a>

	</div>
</body>

</html>








