<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		<br />
		Last name: <form:input path="lastName" />
		<br />
		Country: 
		<form:select path="country">
		
			<form:options items="${student.countryOptions}" />
			<!--
			<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />
			<form:option value="India" label="India" />
			 -->
		</form:select>
		<br />
		
		Favorite Language: 
		Java<form:radiobutton path="favoriteLanguage" value="Java" />
		| C++<form:radiobutton path="favoriteLanguage" value="C++" />
		| PHP<form:radiobutton path="favoriteLanguage" value="PHP" />
		| JS<form:radiobutton path="favoriteLanguage" value="JS" />
		<br />
		
		Operating Systems:
		Linux<form:checkbox path="operatingSystems" value="linux" />
		| MacOS<form:checkbox path="operatingSystems" value="MacOS" />
		| Windows<form:checkbox path="operatingSystems" value="Windows" />
		
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>