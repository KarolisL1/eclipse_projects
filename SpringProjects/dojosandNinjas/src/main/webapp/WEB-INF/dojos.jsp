<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All dojos</title>
</head>
<body>
	<h1>Location ninjas</h1>
	<table>
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
        </tr>
    </thead>
    <tbody>
    <p>${dojo.dojo_name}</p>
         <!-- loop over all the books to show the details as in the wireframe! -->
         	<c:forEach var="ninja" items="${dojo.ninjas}">
			<tr>
    			<td><c:out value="${ninja.first_name}"></c:out></td>
    			<td><c:out value="${ninja.last_name}"></c:out></td>
    			<td><c:out value="${ninja.age}"></c:out></td>
    		</tr>
    	</c:forEach> 
    </tbody>
	</table>
</body>
</html>