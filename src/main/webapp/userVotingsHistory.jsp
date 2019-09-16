<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<html>
<head>
    <title>Historia Głosowań</title>
</head>
<body>
<%@ include file="/jspFiles/headers/headerUser.jsp" %>

<h3>Zamknięte głosowania:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Tytuł</th>
        <th scope="col">Opis</th>
        <th scope="col">Data utworzenia</th>
        <th scope="col">Data zamknięcia</th>
        <th scope="col">Wyniki</th>
    </tr>
    <c:forEach items="${votingsClosed}" var="voting" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${voting.title}</td>
            <td>${voting.description}</td>
            <td>${voting.created}</td>
            <td>${voting.closedDate}</td>
            <td><a href="http://localhost:8080/voting_war_exploded/generateResult?id=${voting.id}" class="btn btn-primary" role="button">Pokaż wyniki</a>
        </tr>
    </c:forEach>
</table></br></br>

</body>
</html>
