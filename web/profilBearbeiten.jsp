<%-- 
    Document   : ProfilBearbeiten
    Created on : 08.12.2015, 1:06:56
    Author     : Metaxa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/normalize.css" rel="stylesheet" type="text/css">
	<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrapper-mother">
<header>
	<a href="main.jsp" class="logo-a">
		<table>
			<tr valign="top">
				<td><img src="img/postit-logo.png" width="65px"></td>
				<td>&nbsp;&nbsp;#PostIt</td>
			</tr>
		</table>
	</a>
	 <a href="Abmelden" class="abmelden">Abmelden</a>
</header>
    
<nav>
        <a href="main.jsp">Mein Profil</a>
        <a href="kontakte.jsp">Freunde</a>
	
</nav>

<div class="wrapper-main"> 
    <h3> Was m&ouml;chten Sie &auml;ndern?</h3>
	<form action="SaveNewProfil" method ="POST">
		<table class="profil-info-table">
		<tr>
			<td><h3>Vorname:</h3></td>
			<td><h3>Nachname:</h3></td>
		</tr>
		<tr>
			<td><input type="text" name="name"></td>
			<td><input type="text" name="vorname"></td>
		</tr>
		<tr>
			<td><h3>Passwort:</h3></td>
			<td><h3>Geb-Datum:</h3></td>
		</tr>
		<tr>
			<td><input type="password" name="password"></td>
			<td><input type="date" name="geburtsdatum"></td>
		</tr>
		<tr>
			<td><h3>Studium:</h3></td>
			<td><h3>Sprache:</h3></td>
		</tr>
		<tr>
			<td><input type="text" name="studium"></td>
			<td><input type="text" name="sprache"></td>
		</tr>
		<tr>
			<td><br><input type="reset" value="l&ouml;schen" class="submit-button"></td>
			<td><br><input type="submit" value="Speichern" class="submit-button"></td>
		</tr>
		
		</table>
	</form>
    
 </div><!--wrapper-main-->  
</body>    
</html>
