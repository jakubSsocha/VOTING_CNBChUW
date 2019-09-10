<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<head>
    <title>Users Menu</title>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%@ include file="header.jsp" %>
</br></br><h3>Add new user:</h3>
<form action="addUser" method="post" class="form-horizontal">
    <label for="name" class="control-label col-sm-2">User's name:</label>
    <input id= "name" type=text" name="user_username" class="form-control"></br><br>
    <label for="email" class="control-label col-sm-2">User's e-mail adress:</label>
    <input id="email" type="email" name="user_email" class="form-control"></br><br>
    <label for="password" class="control-label col-sm-2">User's password:</label>
    <input id="password" type="text" name="user_password" class="form-control"></br></br>
    <fieldset>
        <legend>Choose user status:</legend>
        <label class="control-label col-sm-2">active
            <input name="status" type="radio" value="active">
        </label>
        <label class="control-label col-sm-2">inactive
            <input name="status" type="radio" value="inactive">
        </label>
    </fieldset></br>
    <input class="btn btn-info" type='submit' value="Add user"/>
</br></br></br>
</form>
<h3>All users:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">UserName</th>
        <th scope="col">Email</th>
        <th scope="col">Password</th>
        <th scope="col">Status</th>
        <th scope="col" colspan="1">Edit</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${user.user_username}</td>
            <td>${user.user_email}</td>
            <td>${user.user_password}</td>
            <td>${user.status}</td>
            <td><a href="http://localhost:8080/voting_war_exploded/changeUserStatus?id=${user.user_id}" class="btn btn-warning" role="button">Change</a>
            <a href="#" class="btn btn-info" role="button">Change Password</a>
            <a href="http://localhost:8080/voting_war_exploded/deleteUser?id=${user.user_id}" class="btn btn-danger" role="button">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<%@ include file="footer.jsp" %>