<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new dojo</title>
</head>
<body>
	<h1>New Dojo:</h1>
	<form:form action="/dojos/new" method="post" modelAttribute="dojo">
	    <p>
	        <form:label path="dojo_name">Dojo Name:</form:label>
	        <form:errors path="dojo_name"/>
	        <form:input path="dojo_name"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form> 
</body>
</html>