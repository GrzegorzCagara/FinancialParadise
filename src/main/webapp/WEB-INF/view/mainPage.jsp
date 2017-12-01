<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Financial Paradise</title>
    <jsp:include page="../resources/css/styles.css"/>
    <jsp:include page="../resources/js/scripts.js"/>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/scripts.js"></script>
</head>
<body>
    <div class="top-line">
        <div class="top-left-side"><span class="logo"><a href = "/">Financial Paradise</a></span></div>
        <div class="top-center-side"><a href ="/customers/find/all"><span class="button">Admin panel</span></a></div>
        <div class="top-right-side"><a href="/login">Login</a> / <a href="/customers/customer">Register</a></div>
    </div>

    <div class="content">

    </div>

    <footer>
        <div id="js-test"></div>
    </footer>
</body>
</html>