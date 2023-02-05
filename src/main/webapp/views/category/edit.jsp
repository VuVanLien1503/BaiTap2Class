<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditCategory</title>
</head>
<body>
<h1>----------------------EditCategory-----------------</h1>
<form action="/CategoryServlet?action=edit&id=${category.id}&name=${category.name}" method="post">
<table border="1">
  <tr>
    <th>ID</th>
    <td><input type="text"name="idNew" value="${category.id}"></td>
  </tr>
  <tr>
    <th>Name</th>
    <td><input type="text"name="nameNew" value="${category.name}"></td>
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
