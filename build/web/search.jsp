<%-- 
    Document   : search
    Created on : Jun 14, 2022, 3:34:44 PM
    Author     : duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <nav>
        <a href="index.jsp">Home</a>
        <a href="MainController?action=ViewCart">View cart</a>
    </nav>
    <form action="MainController" method="POST">
        Search: <input type="text" name="txtSearchKey" value="${requestScope.searchKey}"/>
        <input type="submit" name="action" value="Search"/>
    </form>

    <c:if test="${not empty requestScope.productList}">
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${requestScope.productList}" var="prod">
                <tr>
                    <td>${prod.name}</td>
                    <td>${prod.price}</td>
                    <td>${prod.description}</td>
                    <td><a href="MainController?action=AddToCart&productID=${prod.productID}">Add to cart</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty requestScope.productList}">
        <p>Empty</p>
    </c:if>

</html>
