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
	<label>Your Gold: ${gold}</label>
	
	<div class="container">
		<form action="/find" method="post">
			<p>Farm</p><br>
			<p>(earns 10 - 20 gold)</p>
			<input type="submit" value="Find Gold!">
			<input type="hidden" name="location" value="farm" />
		</form>
	</div>
	
 	<div class="container">
			<form action="/find" method="post">
			<p>Cave</p><br>
			<p>(earns 10 - 20 gold)</p>
			<input type="submit" value="Find Gold!">
			<input type="hidden" name="location" value="cave" />
		</form>
	</div>
	
	<div class="container">
			<form action="/find" method="post">
			<p>House</p><br>
			<p>(earns 10 - 20 gold)</p>
			<input type="submit" value="Find Gold!">
			<input type="hidden" name="location" value="house" />
		</form>
	</div>
	
	<div class="container">
			<form action="/find" method="post">
			<p>Quest</p><br>
			<p>(earns/takes 0 - 50 gold)</p>
			<input type="submit" value="Find Gold!">
			<input type="hidden" name="location" value="quest" />
		</form>
	</div>
	
	<div>
		<textarea id="w3review" name="w3review" rows="10" cols="60">
			<c:forEach items="${stories}" var="story" >
				${story}
			</c:forEach>
	  	</textarea>
	</div>
	<a href="/reset">Reset button</a>
</body>
</html>