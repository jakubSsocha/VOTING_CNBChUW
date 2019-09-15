<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<head>
    <title>Merge User to Voting</title>
</head>
<body>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%@ include file="headerAdmin.jsp" %>
<form action="createResult" method="post">
<input type="hidden" value="${voting.id}" name="voting_id">
<h3>Dodaj użytkowników do głosowania</h3>
    <div><h4>Tytuł głosowania:</h4> ${voting.title}</div>
    <div><h4>Opis głosowania:</h4> ${voting.description}</div>
    <div><h4>Utworzone w dniu:</h4> ${voting.created}</div>
<h3>Aktywni użytkownicy:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Nazwa użytkownika</th>
        <th scoop="col">Dodaj do głosowania</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${user.username}</td>
            <td>
            <input name="added" type="checkbox" value=${user.id}>
            </td>
        </tr>
    </c:forEach>
</table>
    <input type="submit" value="Wyslij" class="btn btn-info" role="button>
</form>
<%@ include file="footer.jsp" %>
</body>
