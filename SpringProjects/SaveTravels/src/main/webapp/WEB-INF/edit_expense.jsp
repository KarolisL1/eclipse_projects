<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h1>Edit an expense</h1>
	<p>${expense.id}</p>
	<form:form action="/expenses/{expense.id}/update" method="POST" modelAttribute="expense">
	    <p>
	        <form:label path="expense_name">Expense Name:</form:label>
	        <form:errors path="expense_name"/>
	        <form:input path="expense_name"/>
	    </p>
	    <p>
	        <form:label path="vendor">Vendor:</form:label>
	        <form:errors path="vendor"/>
	        <form:textarea path="vendor"/>
	    </p>
	    <p>
	        <form:label path="amount">Amount:</form:label>
	        <form:errors path="amount"/>
	        <form:input path="amount"/>
	    </p> 
	    <p>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
	    </p>  
	    <input type="submit" value="Submit"/>
	</form:form>    
</body>
</html>