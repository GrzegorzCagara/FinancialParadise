<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../resources/js/scripts.js"/>
    <jsp:include page="../resources/img/admin-panel.png"/>
    <jsp:include page="../resources/img/add-user.png"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script type="text/javascript" src="/js/scripts.js"></script>
    <title>All clients</title>
    <style>
        .panel {
            height: 70px;
            line-height: 50px;
            vertical-align: middle;
            background: #ffc107;
        }

        .fp-logo {
            color: #1e1e1e;
            background: #ffc107;
            border: 2px solid #1e1e1e;
            font-weight: bold;
        }

        .fp-logo:hover {
            color: #1e1e1e;
            text-decoration: none;
        }

        .panel-button img {
            height: 25px;
        }

        .main-container {
            margin-top: 50px;
        }

        .customer-table {
            word-break: break-all;
        }

        .circle {
            width: 200px;
            height: 200px;
            line-height: 200px;
            vertical-align: middle;
            border: 2px solid #ffc107;
            border-radius: 50%;
            margin: auto;
        }
    </style>
</head>
<body>

<!-- CUSTOMER TOP-LINE -->
<div class="panel panel-default">
    <div class="container">
        <div class="d-flex justify-content-end">
            <div class="mr-auto p-2"><a class="btn fp-logo" href="/customers/panel">FP</a></div>
            <div class="p-2"><c:if test="${pageContext.request.userPrincipal.name != null}">${pageContext.request.userPrincipal.name}</c:if></div>
            <div class="p-2"><a class="btn panel-button" href="<c:url value="/logout" />"><img class="img-fluid" src="/img/logout.png" alt="logout"/></a></div>
        </div>
    </div>
</div>


<div class="container main-container">
    <div class="row text-center">
        <div class="col-md-3">
            <a href="<c:url value="/customers/panel/payment"/>" class="btn btn-warning">Send a transfer</a>
            <br><br>
            <a href="<c:url value="/customers/panel/history"/>" class="btn btn-warning">History transfer</a>
        </div>
        <div class="col-md-9">
            <b>Your account number:</b><br>
            ${account.bankAccountNumber}
            <br><br>
            <div class="circle">
                <b>Balance:
                    ${account.balance}</b>
            </div>
        </div>
    </div>
</div>


</body>
</html>