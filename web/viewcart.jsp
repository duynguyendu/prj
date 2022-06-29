<%-- 
    Document   : viewcart
    Created on : Jun 14, 2022, 9:04:10 AM
    Author     : duy
--%>

<%@page import="java.util.Map"%>
<%@page import="dto.ProductDTO"%>
<%@page import="utils.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <nav>
            <a href="index.jsp">Home</a>
            <a href="MainController?action=Search&txtSearchKey=">Search</a>
        </nav>

        <table>
            <tr>
                <th>Product name</th>
                <th>Price</th>
                <th>Quanity</th>
                <th>Sum</th>
                <th>Action</th>
            </tr>
            <c:set var="total" value="${0}"/>
            <c:forEach items="${requestScope.productMap}" var="entry">
                <c:set var="product" value="${entry.key}"/>
                <c:set var="quanity" value="${entry.value}"/>
                <c:set var="total" value="${total + quanity * product.price}"/>
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${quanity}</td>
                    <td>${quanity * product.price}</td>
                    <td><a href="MainController?action=UpdateCart&productID=${product.productID}">Update</a> | 
                        <a href="MainController?action=DeleteCart&productID=${product.productID}">Delete</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4">Total: ${total}</td>
            </tr>
        </table>
    </body>
</html>
