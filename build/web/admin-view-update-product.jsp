<%-- 
    Document   : admin-view-update-product
    Created on : Jun 16, 2022, 3:15:21 PM
    Author     : duy
--%>

<%@page import="java.util.Map"%>
<%@page import="dto.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Product</title>
    </head>
    <body>
        <nav>
            <a href="index.jsp">Home</a>
        </nav>
        <c:set var="product" value="${requestScope.product}"/>
        <form action="MainController" method="POST">
            <input type="hidden" name="txtProductID" value="${product.productID}"/>

            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="txtName" value="${product.name}" required=""/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="number" name="txtPrice" value="${product.price}" required=""/></td>
                </tr>
                <tr>
                    <td>Quanity</td>
                    <td><input type="number" name="txtQuanity" value="${product.quanity}" required=""/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="txtDescription" value="${product.description}"/></td>
                </tr>
                <tr>
                    <td>Category</td>
                    <td>
                        <select name="txtCategoryID">
                            <c:forEach items="${requestScope.categoryMap}" var="entry">
                                <c:if test="${entry.key eq product.categoryID}">
                                    <option value="${entry.key}" selected="selected">${entry.value}</option>
                                </c:if>
                                <c:if test="${entry.key ne product.categoryID}">
                                    <option value="${entry.key}">${entry.value}</option>
                                </c:if>
                            </c:forEach>1
                        </select>
                    </td>
                </tr>
                <c:if test="${not empty requestScope.warning}">
                    <tr><td>${requestScope.warning}<td></tr>
                </c:if>
                <tr><td colspan="2"><input type="submit" name="action" value="UpdateProduct"/></td></tr>
            </table>
        </form>
    </body>
</html>
