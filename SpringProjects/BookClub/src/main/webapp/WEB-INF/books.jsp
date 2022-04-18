<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>  
<h1>All Books</h1>
<table>
	<h1>Welcome, ${user}</h1>
	<p>Books from everyone's shelves:</p>
	<p><a href="/logout">Logout</a></p>
	<p><a href="/books/new">+ Add a to my shelf</a></p>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author Name</th>
            <th>Posted by</th>
        </tr>
    </thead>
    <tbody>
         <!-- loop over all the books to show the details as in the wireframe! -->
         <c:forEach var="oneBook" items="${book}">
			<tr>
    			<td><c:out value="${oneBook.id}"></c:out></td>
    			<td><a href="/books/${oneBook.id}"><c:out value="${oneBook.title}"></c:out></a></td>
    			<td><c:out value="${oneBook.author_name}"></c:out></td>
    			<td><c:out value="${oneBook.user.name}"></c:out></td>
    		</tr>
    	</c:forEach>
    </tbody>
</table>