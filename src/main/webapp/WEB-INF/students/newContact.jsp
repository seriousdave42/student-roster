<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add a New Contact</h2>
	<br>
	<form:form action="/contacts" method="post" modelAttribute="contact">
		<p>
			<form:label path="student">Student</form:label>
			<form:errors path="student"/>
			<form:select path="student">
				<c:forEach items="${eligibles}" var="student">
					<form:option value="${student}">${student.firstName} ${student.lastName}</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="address">Address</form:label>
			<form:errors path="address"/>
			<form:input path="address"/>
		</p>
		<p>
			<form:label path="city">City</form:label>
			<form:errors path="city"/>
			<form:input path="city"/>
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:errors path="state"/>
			<form:input path="state"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>