<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 2/4/21
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Product</title>
</head>
<body>
<div>
    <form action="ProductAct" method="post">

        Enter Id: <input type="number" name="id">
        <input type="submit" value="Show Product" name="showpro">
        <input type="hidden" name="crud" value="read">
    </form>
    <form action="/ProductAct" method="get">
        <input type="submit" value="Add" name="add">
        <input type="hidden" name="crud" value="dispatcher">
        <input type="hidden" name="able" value="Add">
    </form>
    <form action="/ProductAct" method="get">
        <input type="submit" value="Report">
        <input type="hidden" name="crud" value="report">
    </form>
</div>
<div>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Country_id</td>
            <td>Count</td>
            <td>Price</td>
            <td>CreateDate</td>
            <td>Delete</td>
            <td>Edit</td>
        </tr>
        <c:forEach items="${requestScope.products}" var="pro">
            <tr>
                <td><c:out value="${pro.id}"></c:out></td>
                <td><c:out value="${pro.name}"></c:out></td>
                <td><c:out value="${pro.countryid_fk}"></c:out></td>
                <td><c:out value="${pro.count}"></c:out></td>
                <td><c:out value="${pro.price}"></c:out></td>
                <td><c:out value="${pro.createdate}"></c:out></td>
                <td><a href="/ProductAct?id=${pro.id}&crud=delete">Delete</a></td>
                <td><a href="/ProductAct?id=${pro.id}&crud=edit">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
