<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit-Product</title>
</head>
<body>
<h1>---------------EditProduct-----------------</h1>
<form action="/ProductServlet?action=edit&index=${product.id}" method="post">
    <table>
        <tr>
            <th>ID:</th>
            <td><input type="text" name="id" value="${product.id}"></td>
        </tr>
        <tr>
            <th>Name:</th>
            <td><input type="text" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <th>Price:</th>
            <td><input type="text" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <th>Quantity:</th>
            <td><input type="text" name="quantity" value="${product.quantity}"></td>
        </tr>
        <tr>
            <th>Category:</th>
            <td> ${product.category.name}
                <select name="category">
                    <%--                    <option value="newCategory">New Category</option>--%>
                    <c:forEach items="${category}" var="element">
                        <option><c:out value="${element.name}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button>Edit</button>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
