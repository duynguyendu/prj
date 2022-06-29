<%-- 
    Document   : update-password
    Created on : Jun 14, 2022, 3:09:02 PM
    Author     : duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change password</title>
    </head>
    <body>
        <nav>
            <a href="index.jsp">Home</a>
        </nav>

        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td>Old password</td>
                    <td><input type="password" name="txtOldPassword" required=""/></td>
                </tr>
                <tr>
                    <td>New password</td>
                    <td><input type="password" name="txtNewPassword" required=""/></td>
                </tr>
                <tr>
                    <td>Retype new password</td>
                    <td><input type="password" name="txtRetypeNewPassword" required=""/></td>
                </tr>
                <c:if test="${not empty requestScope.warning}">
                    <tr>
                        <td colspan="2">${requestScope.warning}</td>
                    </tr>
                </c:if>
                <tr>
                    <td colspan="2"><input type="submit" name="action" value="UpdateUserPassword"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
