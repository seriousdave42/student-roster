<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student[0].firstName}"/> <c:out value="${student[0].lastName}"/></td>
					<td><c:out value="${student[0].age}"/></td>
					<td><c:out value="${student[1].address}"/></td>
					<td><c:out value="${student[1].city}"/></td>
					<td><c:out value="${student[1].state}"/></td>
				</tr>					
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/students">Add Student</a>
	<span>  |  </span>
	<a href="/contacts">Add Contact</a>
</body>
</html>