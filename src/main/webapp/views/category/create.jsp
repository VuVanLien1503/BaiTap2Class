<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Category</title>
</head>
<body>
<h1>------------------Create New Category------------------</h1>
<form action="/CategoryServlet?action=create"method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" placeholder="Enter number"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"placeholder="Enter Name Category"></td>
        </tr>
        <tr>
            <td colspan="2"><button>Create</button></td>
        </tr>
    </table>
</form>
</body>
</html>
