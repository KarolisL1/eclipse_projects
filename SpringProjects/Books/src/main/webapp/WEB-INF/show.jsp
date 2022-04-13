<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One book</title>
</head>
<body>
	<h1>${booktest.title}</h1>
	<p>Description: ${booktest.description}</p>
	<p>Language: ${booktest.language}</p>
	<p>Number of pages: ${booktest.numberOfPages}</p>	
</body>
</html>