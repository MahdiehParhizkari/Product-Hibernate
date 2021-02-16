<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: afshin
  Date: 2/4/21
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/ProductAct" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="number" name="id"></td>
        </tr>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>countryid_fk:</td>
            <td><input type="number" name="countryid_fk"></td>
        </tr>
        <tr>
            <td>count:</td>
            <td><input type="number" name="count"></td>
        </tr>
        <tr>
            <td>price:</td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td>createdate:</td>
            <td><input type="date" name="date"></td>
        </tr>
    </table>
    <input type="hidden" name="crud" value="add">
    <input type="submit" value="Add">
</form>
</body>
</html>
