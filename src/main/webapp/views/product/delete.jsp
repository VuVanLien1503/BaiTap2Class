<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete-Product</title>
</head>
<body>
<h1>-------------Delete-----------</h1>
<%--<script>--%>
<%--    function confirm() {--%>
<%--        return confirm("Bạn có chắc chắn muốn Xóa"+ ${product.name});--%>
<%--    }--%>
<%--</script>--%>
<form action="/ProductServlet?action=delete&id=${product.id}" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td>${product.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Category</td>
            <td>${product.category.name}</td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td>${product.quantity}</td>
        </tr>
        <tr>
            <td><button>Delete</button></td>
            <td><a href="/ProductServlet">Back</a></td>
        </tr>
    </table>
</form>
</body>
</html>
