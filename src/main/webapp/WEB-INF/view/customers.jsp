<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../resources/css/styles.css"/>
    <jsp:include page="../resources/js/scripts.js"/>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/scripts.js"></script>
    <title>All clients</title>
</head>
<body>

<div class="top-line">
    <div class="top-left-side"><span class="logo"><a href = "/">Financial Paradise</a></span></div>
    <div class="top-center-side"><a href ="/customers/find/all"><span class="button">Admin panel</span></a></div>
    <div class="top-right-side"><a href="/login">Login</a> / <a href="/customers/register">Register</a></div>
</div>

<div class="content">
    <div class="top-center-side"><a href ="/customers/register"><span class="button">Add Customer</span></a></div>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Pesel</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    <c:forEach var="tempCustomer" items="${customers}">
        <tr>
            <c:url var="updateLink" value="/customers/update">
                <c:param name="customerId" value="${tempCustomer.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/admin/deleteClient">
                <c:param name="customerId" value="${tempCustomer.id}"/>
            </c:url>
            <td>${tempCustomer.firstName}</td>
            <td>${tempCustomer.lastName}</td>
            <td>${tempCustomer.pesel}</td>
            <td>${tempCustomer.email}</td>
            <td>${tempCustomer.password}</td>
            <td><a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</div>
<%--<p> Add new customer:</p><br>--%>
<%--<form:form action="/addCustomer" method="post">--%>
    <%--<div align="center">--%>
        <%--First Name: <input name="firstName" type="text"/><br>--%>
        <%--Last Name: <input name="lastName" type="text"/><br>--%>
        <%--Pesel: <input name="pesel" type="text"/><br>--%>
        <%--<form:errors path="pesel"/>--%>
        <%--Email: <input name="email" type="text"/><br>--%>
        <%--Password: <input name="password" type="text"/><br>--%>
        <%--<input type="submit">--%>
    <%--</div>--%>
<%--</form:form>--%>

</body>
</html>