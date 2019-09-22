<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<head>
    <title>Users Menu</title>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%@ include file="headerAdmin.jsp" %>
</br><h3>Dodaj nowego użytkownika:</h3>
<form action="addUser" method="post" class="form-horizontal">
    <label for="name" class="control-label col-sm-2">Nazwa użytkownika:</label>
    <input id= "name" type=text" name="name" class="form-control" required></br><br>
    <label for="email" class="control-label col-sm-2">E-mail:</label>
    <input id="email" type="email" name="email" class="form-control" required></br><br>
    <label for="password" class="control-label col-sm-2">Hasło:</label>
    <input id="password" type="text" name="password" class="form-control" required></br></br>
    <input class="btn btn-info" type='submit' value="Dodaj użytkownika"/>
</br></br>
</form>
<h3>Nowi użytkownicy:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Użytkownik</th>
        <th scope="col">Adres e-mail</th>
        <th scope="col">Hasło</th>
        <th scope="col">Data rejestracji</th>
        <th scope="col">Status</th>
        <th scope="col" colspan="1">Edytuj</th>
    </tr>
    <c:forEach items="${usersNew}" var="user" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.added}</td>
            <td>${user.isActive ? "aktywne" : "nieaktywne"}</td>
            <td><a href="http://localhost:8080/voting_war_exploded/admin/changeUserStatus?id=${user.id}" class="btn btn-warning" role="button">Zmień status</a>
                <a href="http://localhost:8080/voting_war_exploded/admin/deleteUser?id=${user.id}" class="btn btn-danger" role="button">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</br></br>
<h3>Zarejestrowani użytkownicy:</h3>
<table class="table table-condensed">
    <tr>
        <th scope="col">Lp.</th>
        <th scope="col">Użytkownik</th>
        <th scope="col">Adres e-mail</th>
        <th scope="col">Hasło</th>
        <th scope="col">Data rejestracji</th>
        <th scope="col">Status</th>
        <th scope="col">Admin</th>
        <th scope="col" colspan="1">Edytuj</th>
    </tr>
    <c:forEach items="${usersOld}" var="user" varStatus="theCount">
        <tr>
            <td>${theCount.count}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.added}</td>
            <td>${user.isActive ? "aktywne" : "nieaktywne"}</td>
            <td><font color="#dc143c">${user.isAdmin ? "tak" : "nie"}</font></td>
            <td><a href="http://localhost:8080/voting_war_exploded/admin/changeUserStatus?id=${user.id}" class="btn btn-warning" role="button">Zmień status</a>
            <a href="#" class="btn btn-info" role="button">Zmień hasło</a>
            <a href="http://localhost:8080/voting_war_exploded/admin/changeAdminStatus?id=${user.id}" class="btn btn-primary" role="button">Admin status</a>
            <a href="http://localhost:8080/voting_war_exploded/admin/deleteUser?id=${user.id}" class="btn btn-danger" role="button">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
<%@ include file="footer.jsp" %>