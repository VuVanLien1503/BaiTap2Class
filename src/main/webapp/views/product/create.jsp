<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.myClass.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Product</title>
</head>
<body>
<h1>-----------------Create New Product-------------------</h1>
<form action="/ProductServlet?action=create" method="post">
    <table>
        <tr>
            <td>ID :</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Price :</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Category :</td>
            <td>
                <select name="category">
<%--                    <option value="newCategory">New Category</option>--%>
                    <c:forEach items="${category}" var="element">
                        <option><c:out value="${element.name}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
<%--        <tr>--%>
<%--            <td>Category : </td>--%>
<%--            <td>--%>
<%--                <%--%>
<%--                    ArrayList<Category> listCategory = (ArrayList<Category>) request.getAttribute("category");--%>
<%--                %>--%>
<%--                <select>--%>
<%--                    <% for (Category element : listCategory) { %>--%>
<%--                    <option><%=element.getName()  %></option>--%>
<%--                    <% } %>--%>
<%--                </select>--%>
<%--            </td>--%>
<%--        </tr>--%>
        <tr>
            <td>Quantity :</td>
            <td><input type="text" name="quantity"></td>
        </tr>
        <tr>
            <td>
                <button>Create New Product</button>
            </td>
            <td><a href="/ProductServlet">BackListProduct</a></td>
        </tr>
    </table>
</form>
</body>
</html>
