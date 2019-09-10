<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="css/DocumentVotingResult.css">
<html>
<head>
    <title>Voting Result</title>
</head>
<body>
<%@ include file="header.jsp" %>
</br>
<img src="images/logoCNBCh.jpg"></br></br>
<p>Wyniki głosowania uchwały Rady Naukowej CNBCh UW nr:</p></br>
<h3>${voting.voting_title}</h3></br>
<p>Dotyczącej:</p></br>
<h3>${voting.voting_description}</h3></br></br>
<p>to:</p></br></br>
<div>Za:</div>
<div>Przeciw:</div>
<div>Wstrzymujących się:</div></br>
</body>
</html>
