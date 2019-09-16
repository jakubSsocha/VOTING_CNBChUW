<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="css/DocumentVotingResult.css">
<html>
<head>
    <title>Voting Result</title>
</head>
<body>
</br>
<img src="images/logoCNBCh.jpg"></br></br>
<p>Wyniki głosowania uchwały Rady Naukowej CNBCh UW nr:</p></br>
<h3>${voting.title}</h3></br>
<p>z dnia ${voting.created}</p></br>
<p>Dotyczącej:</p></br>
<h4>${voting.description}</h4></br></br>
<p>to:</p></br></br>
<p>Za: ${TAK}</p>
<p>Przeciw: ${NIE}</p>
<p>Wstrzymujących się: ${WST}</p></br></br></br>
<p>Głosowanie zakończono dnia: ${voting.closedDate}</p>
</body>
</html>
