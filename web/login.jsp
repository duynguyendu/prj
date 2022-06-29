<%-- 
    Document   : login.jsp
    Created on : Jun 14, 2022, 8:52:55 AM
    Author     : duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
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
                <c:if ${not empty requestScope.warning}>
                    <tr>
                        <td colspan="2">${requestScope.warning}</td>
                    </tr>
                </c:if>
                <tr>
                    <td colspan="2"><input type="submit" name="action" value="Login"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
