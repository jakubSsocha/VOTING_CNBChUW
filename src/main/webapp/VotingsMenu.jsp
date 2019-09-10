<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<head>
    <title>Votings Menu</title>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%@ include file="headerAdmin.jsp" %>
</br></br><h3>Add new voting:</h3>
<form action="addVoting" method="post" class="form-horizontal">
    <label for="name" class="control-label col-sm-2">Voting's title:</label>
    <input id= "name" type=text" name="voting_title" class="form-control" required></br></br>
    <label for="description" class="control-label col-sm-2">Voting's description:</label>
    <input id="description" type="text" name="voting_description" class="form-control" required></br></br>
    <fieldset>
        <legend>Choose voting status:</legend>
        <label class="control-label col-sm-2">active
            <input name="status" type="radio" value="active">
        </label>
        <label class="control-label col-sm-2">inactive
            <input name="status" type="radio" value="inactive">
        </label>
    </fieldset></br>
    <input class="btn btn-info" type='submit' value="Add voting"/>
    </br></br></br>
</form>
<h3>All votings:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Voting Title</th>
        <th scope="col">Voting Description</th>
        <th scope="col">Status</th>
        <th scope="col">Edit</th>
    </tr>
    <c:forEach items="${votings}" var="voting" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${voting.voting_title}</td>
            <td>${voting.voting_description}</td>
            <td>${voting.voting_status}</td>
            <c:if test="${voting.voting_status ne \"closed\"}">
            <td><a href="http://localhost:8080/voting_war_exploded/changeVotingStatus?id=${voting.voting_id}" class="btn btn-warning" role="button">Change</a>
            <a href="http://localhost:8080/voting_war_exploded/closeVoting?id=${voting.voting_id}" class="btn btn-success" role="button">Close</a>
            <a href="http://localhost:8080/voting_war_exploded/mergeUserWithVoting?id=${voting.voting_id}" class="btn btn-info" role="button">Add Users</a>
            </c:if>
            <c:if test="${voting.voting_status eq \"closed\"}">
            <td><a href="http://localhost:8080/voting_war_exploded/generateResult?id=${voting.voting_id}" class="btn btn-primary" role="button">Show Results</a>
            </c:if>
            <a href="http://localhost:8080/voting_war_exploded/deleteVoting?id=${voting.voting_id}" class="btn btn-danger" role="button">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<%@ include file="footer.jsp" %>