<%-- 
    Document   : index
    Created on : Jun 14, 2022, 7:41:22 AM
    Author     : duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <c:if test="${sessionScope.userID != null}">
            <nav>
                <a href="MainController?action=ViewUpdateUser">${sessionScope.fullname}</a>
                <a href="MainController?action=Logout">Log out</a>
                <c:if test="${sessionScope.role eq 2}">
                    <a href="MainController?action=AdminViewProduct">View product</a>
                    <a href="MainController?action=AdminViewOrder">View order</a>
                    <a href="MainController?action=AdminViewUser">Manage user</a>
                </c:if>
            </nav>
        </c:if>
        <c:if test="${sessionScope.userID == null}">
            <nav>
                <a href="register.jsp">Register</a>
                <a href="login.jsp">Log in</a>
            </nav>
        </c:if>

        <h1>Welcome to Bubble Tea</h1>
        <a href="MainController?action=Search&txtSearchKey=">Search</a>
        <a href="MainController?action=ViewCart">View Cart</a>
    </body>
</html>
