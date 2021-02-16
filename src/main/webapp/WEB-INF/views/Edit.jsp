<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 2/4/21
  Time: 4:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/ProductAct" method="post">
    <table>
        <tr>
            <td><input type="hidden" value="${requestScope.pro.id}" name="id"></td>
        </tr>
        <tr>
            <td>name:</td>
            <td><input type="text" value="${requestScope.pro.name}" name="name"></td>
        </tr>
        <tr>
            <td>countryid_fk:</td>
            <td><input type="number" value="${requestScope.pro.countryid_fk}" name="countryid_fk"></td>
        </tr>
        <tr>
            <td>count:</td>
            <td><input type="number" value="${requestScope.pro.count}" name="count"></td>
        </tr>
        <tr>
            <td>price:</td>
            <td><input type="number" value="${requestScope.pro.price}" name="price"></td>
        </tr>
        <tr>
            <td>createdate:</td>
            <td><input type="date" value="${requestScope.pro.createdate}" name="date"></td>
        </tr>
    </table>
    <input type="submit" value="Update">
    <input type="hidden" value="update" name="crud">
</form>
</body>
</html>
