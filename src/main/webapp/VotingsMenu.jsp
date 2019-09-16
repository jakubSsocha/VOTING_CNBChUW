<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<head>
    <title>Votings Menu</title>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%@ include file="headerAdmin.jsp" %>
</br><h3>Dodaj nowe głosowanie:</h3>
<form action="addVoting" method="post" class="form-horizontal">
    <label for="name" class="control-label col-sm-2">Tytuł głosowania:</label>
    <input id= "name" type=text" name="title" class="form-control" required></br></br>
    <label for="description" class="control-label col-sm-2">Opis głosowania:</label>
    <input id="description" type="text" name="description" class="form-control" required></br></br>
    <input class="btn btn-info" type='submit' value="Utwórz głosowanie"/>
    </br></br>
</form>

<h3>Nowe głosowania:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Tytuł</th>
        <th scope="col">Opis</th>
        <th scope="col">Status</th>
        <th scope="col">Data utworzenia</th>
        <th scope="col" colspan="2">Edytuj</th>
    </tr>
    <c:forEach items="${votingsNew}" var="voting" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${voting.title}</td>
            <td>${voting.description}</td>
            <td>${voting.isActive ? "aktywne" : "nieaktywne"}</td>
            <td>${voting.created}</td>
            <td><a href="http://localhost:8080/voting_war_exploded/changeVotingStatus?id=${voting.id}" class="btn btn-warning" role="button">Zmień status</a>
            <a href="http://localhost:8080/voting_war_exploded/deleteVoting?id=${voting.id}" class="btn btn-danger" role="button">Usuń</a></td>
        </tr>
    </c:forEach>
</table></br></br>

<h3>Głosowania w toku:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Tytuł</th>
        <th scope="col">Opis</th>
        <th scope="col">Status</th>
        <th scope="col">Data utworzenia</th>
        <th scope="col" colspan="4">Edytuj</th>
    </tr>
    <c:forEach items="${votingsOld}" var="voting" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${voting.title}</td>
            <td>${voting.description}</td>
            <td>${voting.isActive ? "aktywne" : "nieaktywne"}</td>
            <td>${voting.created}</td>
            <td><a href="http://localhost:8080/voting_war_exploded/changeVotingStatus?id=${voting.id}" class="btn btn-warning" role="button">Zmień status</a>
            <a href="http://localhost:8080/voting_war_exploded/closeVoting?id=${voting.id}" class="btn btn-success" role="button">Zakończ</a>
            <a href="http://localhost:8080/voting_war_exploded/mergeUserWithVoting?id=${voting.id}" class="btn btn-info" role="button">Dodaj użytkowników</a>
            <a href="http://localhost:8080/voting_war_exploded/deleteVoting?id=${voting.id}" class="btn btn-danger" role="button">Usuń</a></td>
        </tr>
    </c:forEach>
</table></br></br>

<h3>Zamknięte głosowania:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Tytuł</th>
        <th scope="col">Opis</th>
        <th scope="col">Data utworzenia</th>
        <th scope="col">Data zamknięcia</th>
        <th scope="col" colspan="2">Edytuj</th>
    </tr>
    <c:forEach items="${votingsClosed}" var="voting" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${voting.title}</td>
            <td>${voting.description}</td>
            <td>${voting.created}</td>
            <td>${voting.closedDate}</td>
            <td><a href="http://localhost:8080/voting_war_exploded/generateResult?id=${voting.id}" class="btn btn-primary" role="button">Pokaż wyniki</a>
            <td><a href="http://localhost:8080/voting_war_exploded/deleteVoting?id=${voting.id}" class="btn btn-danger" role="button">Usuń</a></td>
        </tr>
    </c:forEach>
</table></br></br>

<%@ include file="footer.jsp" %>