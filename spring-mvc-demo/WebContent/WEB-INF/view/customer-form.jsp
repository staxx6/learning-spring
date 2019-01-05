<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customer Form</title>
	<style type="text/css">
		.error {
			color: red;
		}
	</style>
</head>
<body>

	<i>Fill out the form. (*) are required.</i>

	<form:form action="processForm" modelAttribute="customer">
		
		First name: <form:input path="firstName" />
		<br />
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br />
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>