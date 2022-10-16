<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<c:forEach var="cus" items="${cusDetails}">
	
	<c:set var="id" value="${cus.id}"/>
	<c:set var="name" value="${cus.name}"/>
	<c:set var="email" value="${cus.email}"/>
	<c:set var="phone" value="${cus.phone}"/>
	<c:set var="usn" value="${cus.uname}"/>
	<c:set var="pwd" value="${cus.upass}"/>
	
	<tr>
		<td>Customer ID: </td>
		<td>${cus.id}</td>
	</tr>
	<tr>
		<td>Customer Name: </td>
		<td>${cus.name}</td>
	</tr>
	<tr>
		<td>Customer Email: </td>
		<td>${cus.email}</td>
	</tr>
	<tr>
		<td>Customer Phone: </td>
		<td>${cus.phone}</td>
	</tr>
	<tr>
		<td>Customer User Name: </td>
		<td>${cus.uname}</td>
	</tr>

	</c:forEach>
	</table>

	<c:url value="updateCustomer.jsp" var="cusUpdate">
	<c:param  name="id" value="${id}"/>
	<c:param  name="name" value="${name}"/>
	<c:param  name="email" value="${email}"/>
	<c:param  name="phone" value="${phone}"/>
	<c:param  name="username" value="${usn}"/>
	<c:param  name="password" value="${pwd}"/>
	</c:url>
	<a href="${cusUpdate}"><input type="button" name="update" value="Update My Data"/></a><br>
	
	<c:url value="deleteUser.jsp" var="cusDelete">
	<c:param  name="id" value="${id}"/>
	<c:param  name="name" value="${name}"/>
	<c:param  name="email" value="${email}"/>
	<c:param  name="phone" value="${phone}"/>
	<c:param  name="username" value="${usn}"/>
	<c:param  name="password" value="${pwd}"/>
	</c:url>	
	<a href="${cusDelete}" ><input type ="button" name="delete" value="Delete Account"></a>
</body>
</html>