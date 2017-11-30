<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Customer</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Add Customer</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="add" modelAttribute="customer" method="POST">
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
                        <td><form:input path="pesel"/></td>
                        <form:errors path="pesel"/>
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
