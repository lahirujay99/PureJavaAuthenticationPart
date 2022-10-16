<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateData" method="post">
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String uname = request.getParameter("username");
String pswd = request.getParameter("password");
%>

User Id <input type="text" name="id" value="<%=id%>" readonly><br>
User Name <input type="text" name="name" value="<%=name%>"><br>
User Email <input type="text" name="email" value="<%=email%>"><br>
User Phone <input type="text" name="phone" value="<%=phone%>"><br>
User UserName <input type="text" name="usn" value="<%=uname%>"><br>
User Password <input type="text" name="pwd" value="<%=pswd%>"><br>
<input type="submit" name="submit" value="Update Details">
</form>

</body>
</html>