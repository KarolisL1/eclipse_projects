<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new ninja</title>
</head>
<body>
	<h1>New Ninja:</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
  		<form:select path="dojo" >
					<c:forEach items="${dojos}" var="i" >
						<form:option value="${i.id}">${i.dojo_name}</form:option>				
					</c:forEach>
		</form:select>
	    <p>
	        <form:label path="first_name">First Name:</form:label>
	        <form:errors path="first_name"/>
	        <form:input path="first_name"/>
	    </p>
	    <p>
	        <form:label path="last_name">Last Name:</form:label>
	        <form:errors path="last_name"/>
	        <form:input path="last_name"/>
	    </p>
	    <p>
	        <form:label path="age">Age:</form:label>
	        <form:errors path="age"/>
	        <form:input path="age"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form> 
</body>
</html>