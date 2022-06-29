<%-- 
    Document   : authorization-fail
    Created on : Jun 16, 2022, 2:16:26 PM
    Author     : duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <nav>
            <a href="index.jsp">Home</a>
        </nav>

    <c:if test="${not empty requestScope.warning}">
        ${requestScope.warning}
    </c:if>
</body>
</html>
