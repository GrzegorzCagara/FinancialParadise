<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Financial Paradise</title>
    <jsp:include page="../resources/js/scripts.js"/>
    <jsp:include page="../resources/img/admin-panel.png"/>
    <jsp:include page="../resources/img/add-user.png"/>
    <jsp:include page="../resources/img/details.png"/>
    <jsp:include page="../resources/img/logout.png"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script type="text/javascript" src="/js/scripts.js"></script>
    <style>
        .jumbotron a {
            color: #1e1e1e;
            text-decoration: none;
        }

        .card img {
            width: 50%;
            margin: 10% auto;
        }

        .no-underline:hover {
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="jumbotron jumbotron-fluid bg-warning">
    <div class="container">
        <div class="row">
            <div class="col text-center">
                <h1 class="display-3"><a href = "/">Financial Paradise</a></h1>
                <p class="lead">A dream place for your money</p>
            </div>
            <!-- <div class="col"><a class="btn btn-info" href ="/customers/find/all">Admin panel</a></div>
            <div class="col"><a href="/login">Login</a> / <a href="/customers/register">Register</a></div> -->
        </div>
    </div>
</div>
<div class="container text-muted">
    <div class="row text-center">
        <div class="col-md-3">
            <a class="text-muted no-underline" href="/admin/find/all">
                <div class="card">
                    <img class="card-img-top img-fluid" src="/img/admin-panel.png" />

                    <div class="card-block">
                        <h3 class="card-title">Admin panel</h3>
                        <p>Manage customers accounts</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-3">
            <a class="text-muted no-underline" href="/register">
                <div class="card">
                    <img class="card-img-top img-fluid" src="/img/add-user.png" />
                    <div class="card-block">
                        <h3 class="card-title">Add user</h3>
                        <p>Add new customer</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-3">
            <a class="text-muted no-underline" href="/admin/customer-details">
                <div class="card">
                    <img class="card-img-top img-fluid" src="/img/details.png" />
                    <div class="card-block">
                        <h3 class="card-title">Customer details</h3>
                        <p>back to main page</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-3">
            <a class="text-muted no-underline" href="<c:url value="/logout" />">
                <div class="card">
                    <img class="card-img-top img-fluid" src="/img/logout.png" />
                    <div class="card-block">
                        <h3 class="card-title">Logout</h3>
                        <p>back to main page</p>
                    </div>
                </div>
            </a>
        </div>

    </div>
</div>

<%--<div class="top-line">--%>
<%--<div class="top-left-side"><span class="logo"><a href = "/">Financial Paradise</a></span></div>--%>
<%--<div class="top-center-side"><a href ="/customers/find/all"><span class="button">Admin panel</span></a></div>--%>
<%--<div class="top-right-side"><a href="/login">Login</a> / <a href="/customers/customer">Register</a></div>--%>
<%--</div>--%>

<%--<div class="content">--%>

<%--</div>--%>

<%--<footer>--%>
<%--<div id="js-test"></div>--%>
<%--</footer>--%>
</body>
</html>