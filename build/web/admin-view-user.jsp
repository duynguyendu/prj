<%-- 
    Document   : admin-view-product
    Created on : Jun 16, 2022, 2:13:46 PM
    Author     : duy
--%>

<%@page import="dto.UserDTO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>
        <nav>
            <a href="index.jsp">Home</a>
        </nav>
        <h3>User List</h3>
        <form action="MainController" method="POST">

            <table>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                </tr>
                <c:forEach items="${requestScope.userList}" var="user">
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.phoneNumber}</td>
                        <td>${user.address}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
