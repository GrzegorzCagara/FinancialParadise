<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <a href="<c:url value="/customers/panel/payment"/>" class="btn btn-primary">Send a transfer</a>
    <a href="<c:url value="/"/>" class="btn btn-primary">Log off</a>
    <a href="<c:url value="/customers/panel/history"/>" class="btn btn-primary">History transfer</a>
    <a href="<c:url value="/customers/panel/messages"/>" class="btn btn-primary">Messages</a>

    Your account balance:
    Your account number:



</body>
</html>