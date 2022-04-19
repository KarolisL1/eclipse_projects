<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New category</title>
</head>
<body>
<!-- 	<h1>Add a Book to Your Shelf!</h1>
	<p><a href="/books">back to the shelves</a></p> -->
	<form:form action="/categories/new" method="post" modelAttribute="category">
<%-- 		<form:input type="hidden" path="user" value="${user_id}" /> --%>
	    <p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form> 
</body>
</html>