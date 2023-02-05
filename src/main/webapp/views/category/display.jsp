<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DisplayCategory</title>
</head>
<body>
<h1>----------------------ListCategory---------------------</h1>
    <table border="1" style="margin-left: 200px;border-collapse: collapse">
        <tr>
            <td colspan="2">
                <form action="/CategoryServlet?action=find" style="margin: 0px">
                    <input type="text" name="find" placeholder="Find By Name category">
                    <button>Search</button>
                </form>
            </td>
        </tr>
        <tr style="text-align: right">
            <td colspan="2">
                <a  href="/views/category/create.jsp">Create New Category</a>
            </td>
        </tr>
        <tr style="width: 20px">
            <th>ID</th>
            <th style="width: 300px">Name</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${category}" var="element">
            <tr style="text-align: center">
                <td>${element.getId()}</td>
                <td>${element.getName()}</td>
                <td><a href="/CategoryServlet?action=edit&id=${element.id}">Edit</a></td>
                <td><a href="/CategoryServlet?action=delete&id=${element.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
<a href="/ProductServlet">ProductServlet</a>
</body>
</html>
