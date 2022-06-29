<%-- 
    Document   : update-user
    Created on : Jun 14, 2022, 2:40:12 PM
    Author     : duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update user</title>
    </head>
    <body>
        <nav>
            <a href="index.jsp">Home</a>
        </nav>
        <a href="update-password.jsp">Change password</a>
        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td>First name</td>
                    <td><input type="text" name="txtFirstName" value="${user.firstName}" required=""/></td>
                </tr>
                <tr>
                    <td>Last name</td>
                    <td><input type="text" name="txtLastName" value="${user.lastName}"/></td>
                </tr>
                <tr>
                    <td>Phone Number</td>
                    <td><input type="text" name="txtPhoneNumber" value="${user.phoneNumber}"/></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="txtAddress" value="${user.address}"/></td>
                </tr>

                <c:if test="${not empty requestScope.warning}">
                    <tr>
                        <td colspan="2">${requestScope.warning}</td>
                    </tr>
                </c:if>

                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="UpdateUser"/>
                    </td>
                </tr>
            </table>
        </form>

    </body>
</html>
