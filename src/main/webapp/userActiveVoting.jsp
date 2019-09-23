<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<html>
<head>
    <title>Zagłosuj</title>
</head>
<body>
<% boolean isUserAdmin= (boolean)session.getAttribute("isUserAdmin"); %>

<% if (isUserAdmin) { %>
<%@ include file="headerAdmin.jsp" %>
<% } else {%>
<%@ include file="/jspFiles/headers/headerUser.jsp" %>
<% } %>

<h3>Oddaj głos:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Data utworzenia</th>
        <th scope="col">Tytuł</th>
        <th scope="col">Opis</th>
        <th scope="col">Oddaj głos</th>
    </tr>
    <c:forEach items="${activeResults}" var="results" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${results.created}</td>
            <td>${results.title}</td>
            <td>${results.description}</td>
            <td><a href="http://localhost:8080/voting_war_exploded/GenerateVote?vote=TAK&id=${results.id}" class="btn btn-success" role="button">TAK</a>
                <a href="http://localhost:8080/voting_war_exploded/GenerateVote?vote=NIE&id=${results.id}" class="btn btn-danger" role="button">NIE</a>
                <a href="http://localhost:8080/voting_war_exploded/GenerateVote?vote=WST&id=${results.id}" class="btn btn-warning" role="button">WSTRZYMUJĘ SIĘ</a>
        </tr>
    </c:forEach>
</table>

</body>
</html>
