<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>
	<h1>${product.name}</h1>
 	<form action="/products/${product.id}/withCategory" method="post">
	    <select name="category_id">
			<c:forEach items="${Categories}" var="category">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select>
	    <input type="submit" value="Submit"/>
	</form>
</body>
</html>

