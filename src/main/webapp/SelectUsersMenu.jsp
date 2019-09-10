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
<input type="hidden" value="${voting.voting_id}" name="voting_id">
<h3>Dodaj użytkowników do głosowania</h3>
    <div><h4>Tytuł głosowania:</h4> ${voting.voting_title}</div>
    <div><h4>Opis głosowania:</h4> ${voting.voting_description}</div>
<h3>All Active users:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">UserName</th>
        <th scoop="col">Add to Voting</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${user.user_username}</td>
            <td>
            <input name="added" type="checkbox" value=${user.user_id}>
            </td>
        </tr>
    </c:forEach>
</table>
    <input type="submit" value="Wyslij" class="btn btn-info" role="button>
</form>
<%@ include file="footer.jsp" %>
</body>
