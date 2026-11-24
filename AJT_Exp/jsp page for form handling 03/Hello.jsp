
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Form Handling</title>
</head>
<body>
    <h2>Student Form</h2>

    <form method="post" action="hello.jsp">
        Enter Name:
        <input type="text" name="username" required>
        <br><br>

        Enter Age:
        <input type="number" name="age" required>
        <br><br>

        <input type="submit" value="Submit">
    </form>

    <%
        String name = request.getParameter("username");
        String age = request.getParameter("age");

        if (name != null && age != null) {
    %>
        <h3>Submitted Details</h3>
        <p>Name: <%= name %></p>
        <p>Age: <%= age %></p>
    <%
        }
    %>
</body>
</html>
