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
    <title>Save Customer</title>
</head>
<body>
<div class="top-line">
    <div class="top-left-side"><span class="logo"><a href = "/">Financial Paradise</a></span></div>
    <div class="top-center-side"><a href ="/customers/find/all"><span class="button">Admin panel</span></a></div>
    <div class="top-right-side"><a href="/login">Login</a> / <a href="/customers/register">Register</a></div>
</div>

    <div id="wrapper">
        <div id="header">
            <h2>Add Customer</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="/customers/customer" modelAttribute="customer" method="PUT">
            <form:hidden path="id"/>
            <table>
                <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>
                    <tr>
                        <td><label>Last name:</label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>
                    <tr>
                        <td><label>Pesel:</label></td>
                        <td><form:input path="pesel"/>
                            <form:errors path="pesel" cssClass="error"/>
                        </td>

                    </tr>
                    <tr>
                        <td><label>Email:</label></td>
                        <td><form:input path="email"/></td>
                        <form:errors path="lastName" cssClass="error"/>

                    </tr>
                    <tr>
                        <td><label>Password:</label></td>
                        <td><form:input path="password"/></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear: both;"></div>
        <p>
            <a href="${pageCOntext.request.contextPath}/customers/find/all">Back to List</a>
        </p>
    </div>

</body>
















</html>
