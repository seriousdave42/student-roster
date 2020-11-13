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
	<h2>Student Roster</h2>
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
	<br>
	<h2>Dorm List</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dorms}" var="dorm">
				<tr>
					<td><a href="/dorms/${dorm.id}"><c:out value="${dorm.name}"/></a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/dorms">Add Dorm</a>
</body>
</html>