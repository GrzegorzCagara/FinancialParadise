<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>All clients</title>
</head>
<body>
<input type="button" value="Add Customer" onclick="window.location.href='addClient'; return false;"
       class="add-button"/>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Pesel</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    <c:forEach var="tempClient" items="${customers}">
        <tr>
            <c:url var="updateLink" value="/admin/updateClient">
                <c:param name="clientId" value="${tempClient.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/admin/deleteClient">
                <c:param name="clientId" value="${tempClient.id}"/>
            </c:url>
            <td>${tempClient.firstName}</td>
            <td>${tempClient.lastName}</td>
            <td>${tempClient.pesel}</td>
            <td>${tempClient.email}</td>
            <td>${tempClient.password}</td>
            <td><a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

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