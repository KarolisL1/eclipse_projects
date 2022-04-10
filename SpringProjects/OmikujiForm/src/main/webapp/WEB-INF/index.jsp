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
	<h1>Send an Omikuji!</h1>
		<form action="/send" method="post">
			<label>Pick any number from 5 to 25</label>
			<select id="number" name="number">
			  <option value=5>5</option>
			  <option value=10>10</option>
			  <option value=15>15</option>
			  <option value=20>20</option>
			  <option value=25>25</option>
			</select><br>
			<label>Enter the name of any city:</label>
		    <input type="text" name="city"><br>
		    <label>Enter the name of any real person:</label>
		    <input type='text' name='name'><br>
		    <label>Enter professional endeavor or hobby:</label>
		    <input type='text' name='hobby'><br>
		    <label>Enter any type of living thing.</label>
		    <input type='text' name='thing'><br>
		    <label>Say something nice to someone</label>
		    <input type='text' name='somethingnice'><br>
		    <label>Send and show a friend</label><br>
		    <input type="submit" value='Send'>
	    </form>
</body>
</html>