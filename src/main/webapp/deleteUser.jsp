<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="delete" method="post">
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String uname = request.getParameter("username");
String pswd = request.getParameter("password");
%>

User Id <input type="text" name="id" value="<%=id%>" readonly><br>
User Name <input type="text" name="name" value="<%=name%>"readonly><br>
User Email <input type="text" name="email" value="<%=email%>"readonly><br>
User Phone <input type="text" name="phone" value="<%=phone%>"readonly><br>
User UserName <input type="text" name="usn" value="<%=uname%>"readonly><br>
<input type="submit" name="submit" value="Delete Account">
</form>
</body>
</html>