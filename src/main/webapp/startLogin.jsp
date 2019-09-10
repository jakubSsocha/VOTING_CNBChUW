<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>Create New User</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
<%@ include file="/jspFiles/headers/headerStart.jsp" %>


<form class="form-horizontal" action="Logger" method="post">
    <div class="form-group">
        <label class="control-label col-sm-2" for="email">Email:</label>
        <div class="col-sm-10">
            <input type="email" class="form-control" id="email" placeholder="Podaj adres e-mail:" required name="email">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="password">Hasło:</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="password" placeholder="Podaj hasło:" required name="password">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</form>

</body>
</html>
