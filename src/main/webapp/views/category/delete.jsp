<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/CategoryServlet?action=delete&id=${category.id}&name=${category.name}" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td>${category.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${category.name}</td>
        </tr>
        <tr>
            <td><button>Delete</button></td>
            <td><a href="/CategoryServlet">Back</a></td>
        </tr>
    </table>
</form>

</body>
</html>
