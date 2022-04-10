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
	<h1>Here's your Omikuji!</h1>
	<p>In <c:out value="${number}"></c:out> years, you will<br>
	 live in <c:out value="${city}"></c:out> with<br>
	 <c:out value="${name}"></c:out> as your<br> roommate, <c:out value="${hobby}"></c:out>
	  for a living.<br> the next time you<br> see a <c:out value="${thing}"></c:out>,
	   you will<br> have good luck. Also, <c:out value="${something}"></c:out>.</p>
	<a href="http://localhost:8080/">Go Back</a>
</body>
</html>