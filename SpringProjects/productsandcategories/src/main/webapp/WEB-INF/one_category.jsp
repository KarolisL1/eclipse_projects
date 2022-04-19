<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>
	<h1>${category.name}</h1>
 	<form action="/categories/${category.id}/withProduct" method="post">
	    <select name="product_id">
			<c:forEach items="${Products}" var="product">
				<option value="${product.id}">${product.name}</option>
			</c:forEach>
		</select>
	    <input type="submit" value="Submit"/>
	</form>
</body>
</html>

