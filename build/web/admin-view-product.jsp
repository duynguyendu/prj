<%-- 
    Document   : admin-view-product
    Created on : Jun 16, 2022, 2:13:46 PM
    Author     : duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Map"%>
<%@page import="dto.CategoryDTO"%>
<%@page import="dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h3>Product List</h3>
        <form action="MainController" method="POST">

            <table>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quanity</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Action</th>
                </tr>
                <%  List<ProductDTO> productList = (List<ProductDTO>) request.getAttribute("productList");
                    Map<Integer, String> categoryMap = (Map<Integer, String>) request.getAttribute("categoryMap");
                    for (ProductDTO product : productList) {
                %>
                <c:forEach items="${requestScope.productList}" var="product">
                    <tr>
                    <input type="hidden" name="txtProductID" value="${product.productID}"/>
                    <td>$product.name}</td>
                    <td>{product.price}</td>
                    <td>{product.quanity}</td>
                    <td>{product.description}</td>
                    <td><%= categoryMap.get(product.getCategoryID())%></td>
                    <td>
                        <a href="MainController?action=ViewUpdateProduct&productID=${product.productID}">Update</a> | <a href="MainController?action=DeleteProduct&productID=<%= product.getProductID()%>">Delete</a>
                    </td>
                    </tr>
                    <%
                        }
                    %>
                </c:forEach>
                <tr>
                    <td><input type="text" name="txtName" required=""/></td>
                    <td><input type="number" name="txtPrice" required=""/></td>
                    <td><input type="number" name="txtQuanity" required=""/></td>
                    <td><input type="text" name="txtDescription"/></td>
                    <td>
                        <select name="txtCategoryID">
                            <% for (Map.Entry<Integer, String> entry : categoryMap.entrySet()) {
                            %>
                            <option value="<%= entry.getKey()%>"><%= entry.getValue()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <c:if test="${not empty requestScope.warning}">
                    <tr>
                        <td>${requestScope.warning}</td>
                    </tr> 
                </c:if>
                <tr>
                    <td><input type="submit" name="action" value="AddProduct"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
