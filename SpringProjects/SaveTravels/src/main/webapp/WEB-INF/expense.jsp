<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Expense details</h1>
	<p><a href="/expenses">Go Back</a></p>
	<p>Expense Name: ${expense.expense_name}</p>
	<p>Expense Description: ${expense.description}</p>
	<p>Vendor: ${expense.vendor}</p>
	<p>Amount Spent: $${expense.amount}</p>
</body>
</html>