<%-- 
    Document   : register
    Created on : Jun 14, 2022, 9:07:44 AM
    Author     : duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <nav>
            <a href="index.jsp">Home</a>
            <a href="login.jsp">Login</a>
        </nav>
        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="txtEmail" required=""/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="txtPassword" required=""/></td>
                </tr>
                <tr>
                    <td>Retype password</td>
                    <td><input type="password" name="txtRetypePassword" required=""/></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="txtFirstName"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="txtLastName" required=""/></td>
                </tr>
                <tr>
                    <td>Phone Number</td>
                    <td><input type="text" name="txtPhoneNumber"/></td>
                </tr>
                <c:if ${not empty requestScope.warning}>
                    <tr>
                        <td colspan="2">${requestScope.warning}</td>
                    </tr>
                </c:if>
                <tr>
                    <td colspan="2"><input type="submit" name="action" value="Register"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
