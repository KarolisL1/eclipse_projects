<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new book</title>
</head>
<body>
	<h1>Add a Book to Your Shelf!</h1>
	<p><a href="/books">back to the shelves</a></p>
	<form:form action="/books/new" method="post" modelAttribute="book">
		<form:input type="hidden" path="user" value="${user_id}" />
	    <p>
	        <form:label path="title">Title:</form:label>
	        <form:errors path="title"/>
	        <form:input path="title"/>
	    </p>
	    <p>
	        <form:label path="author_name">Author</form:label>
	        <form:errors path="author_name"/>
	        <form:input path="author_name"/>
	    </p>
	    	    <p>
	        <form:label path="thoughts">My thoughts</form:label>
	        <form:errors path="thoughts"/>
	        <form:input path="thoughts"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form> 
</body>
</html>