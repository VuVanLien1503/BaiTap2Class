
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ListProduct</title>
</head>
<body>
<h1>-----------------------ListProduct-------------------------</h1>
<table border="1" style="margin-left: 250px ; border-collapse: collapse;width:600px">
  <tr>
    <td colspan="7">
      <form action="/ProductServlet?action=find" style="margin: 0px">
        <input type="text" name="find" placeholder="Find Product By NameCategory"style="width: 400px">
        <button>Search</button>
      </form>
    </td>
  </tr>
  <tr style="text-align: right">
    <td colspan="7">
      <a  href="/ProductServlet?action=create">Create New Product</a>
    </td>
  </tr>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Category</th>
    <th>Quantity</th>
    <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${product}" var="element">
    <tr>
      <td>${element.id}</td>
      <td>${element.name}</td>
      <td>${element.price}</td>
      <td>${element.category.name}</td>
      <td>${element.quantity}</td>
      <td><a href="/ProductServlet?action=edit&id=${element.id}">Edit</a></td>
      <td><a href="/ProductServlet?action=delete&id=${element.id}">delete</a></td>
    </tr>
  </c:forEach>
</table>
<a href="/CategoryServlet">CategoryServlet</a>
</body>
</html>
