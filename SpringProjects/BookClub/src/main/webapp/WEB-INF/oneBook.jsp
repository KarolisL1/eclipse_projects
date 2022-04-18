<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>  
<table>
	<h1>${booktest.title}</h1>
	<p><a href="/books">back to the shelves</a></p>
 	<c:if test="${booktest.user.id == user_id}">
 		<p>You read ${booktest.title} by ${booktest.author_name}.</p>
 		<p>Here are your thoughts:</p>
 	</c:if>
 	<c:if test="${booktest.user.id != user_id}">
		<p>${booktest.user.name} read ${booktest.title} by ${booktest.author_name}.</p>
		<p>Here are ${booktest.user.name}'s thoughts:</p>
	</c:if>
	<hr>
	<p>${booktest.thoughts}</p>
	<hr>
	<c:if test="${booktest.user.id == user_id}">
		<a href="/books/${booktest.id}/edit">edit</a>
	</c:if>
</table>