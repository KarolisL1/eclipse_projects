<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New product</title>
</head>
<body>
<!-- 	<h1>Add a Book to Your Shelf!</h1>
	<p><a href="/books">back to the shelves</a></p> -->
	<form:form action="/products/new" method="post" modelAttribute="product">
<%-- 		<form:input type="hidden" path="user" value="${user_id}" /> --%>
	    <p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description"/>
	        <form:input path="description"/>
	    </p>
	    	    <p>
	        <form:label path="price">Price</form:label>
	        <form:errors path="price"/>
	        <form:input path="price"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form> 
</body>
</html>