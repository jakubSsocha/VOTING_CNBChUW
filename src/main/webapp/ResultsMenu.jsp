<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<head>
    <title>Results Menu</title>
</head>
<body>
<%@ include file="headerAdmin.jsp" %>
<h3>Wyniki aktywnych głosowań:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Nazwa Głosowania</th>
        <th scope="col">Nazwa Użytkownika</th>
        <th scope="col">Głos</th>
        <th scope="col">Status</th>
        <th scope="col">Edycja</th>
    </tr>
    <c:forEach items="${results}" var="result" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <c:forEach items="${votings}" var="voting">
                <c:if test="${result.voting_id == voting.id}">
                    <td>${voting.title}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${users}" var="user">
                <c:if test="${result.user_id == user.id}">
                    <td>${user.username}</td>
                </c:if>
            </c:forEach>
            <td>${result.vote}</td>
            <td>${result.isActive ? "aktywne" : "nieaktywne"}</td>
            <td><a href="http://localhost:8080/voting_war_exploded/admin/changeResultStatus?id=${result.id}" class="btn btn-warning" role="button">Change</a>
            <a href="http://localhost:8080/voting_war_exploded/admin/deleteResult?id=${result.id}" class="btn btn-danger" role="button">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<%@ include file="footer.jsp" %>


</body>

