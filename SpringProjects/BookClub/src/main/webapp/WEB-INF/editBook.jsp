<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a book</title>
</head>
<body>
	<h1>Change your Entry</h1>
	<p><a href="/books">back to the shelves</a></p>
 	<form:form action="/books/${booktest.id}/update" method="post" modelAttribute="booktest">
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