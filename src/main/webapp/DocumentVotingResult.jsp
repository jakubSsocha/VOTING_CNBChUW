<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="css/DocumentVotingResult.css">

<html>

<head>
    <title>Wyniki głosowania:</title>
</head>

<body>
</br>
<img src="images/logoCNBCh.jpg"></br>
<p>Wyniki głosowania uchwały Rady Naukowej CNBCh UW nr:</p></br>
<h3>${voting.title}</h3></br>
<p>z dnia ${voting.created}</p></br>
<p>dotyczącej:</p></br>
<p><b>${voting.description}</b></p></br>
<p>to:</p></br>
<p>Za: <b>${vR.TAK}</b></p>
<p>Przeciw: <b>${vR.NIE}</b></p>
<p>Wstrzymujących się: <b>${vR.WST}</b></p></br></br>
<p>Oddanych głosów: <b>${vR.votes}</b></p>
<p>Uprawnionych do głosowania: <b>${vR.ableToVotes}</b></p>
<p>Wymagane kworum: <b>${vR.quorum}</b></p>
<p>Uchwała ważna: <b>${vR.valid ? "TAK" : "NIE"}</b></p>
</br></br>
<p>Głosowanie zakończono dnia: ${voting.closedDate}</p>

</body>

</html>
