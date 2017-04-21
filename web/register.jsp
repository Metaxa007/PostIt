<!DOCTYPE HTML>
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
	<a href="index.html" class="logo-a">
		<table>
			<tr valign="top">
				<td><img src="img/postit-logo.png" width="65px"></td>
				<td>&nbsp;&nbsp;#PostIt</td>
			</tr>
		</table>
	</a>
</header>
<div class="wrapper-main">

<h1>Registrieren</h1>

<form method="post" action="RegisterServlet" class="register-form">
	<table class="register-table">
		<tr>
			<td>Vorname:</td>
			<td><input type="text" name="vorname" id="vorname" class="input-text"></td>
		</tr>
		<tr>
			<td>Nachname:</td>
			<td><input type="text" name="nachname" id="nachname" class="input-text"></td>
		</tr>
		<tr>
			<td>E-Mail:</td>
			<td><input type="email" name="email" id="email" class="input-text"></td>
		</tr>
		<tr>
			<td>Passwort:</td>
			<td><input type="password" name="password1" id="password1" class="input-text"></td>
		</tr>
		<tr>
			<td>Passwort wiederholen:</td>
			<td><input type="password" name="password2" id="password2" class="input-text"></td>
                       
		</tr>
                
		<tr>
			<td><input type="reset" value="l&ouml;schen" class="submit-button"></td>
			<td><button type="submit" class="submit-button">Registrieren</button></td>
		</tr>
	</table>
</form>
	
</div><!--wrapper-main-->
<footer>
	<p><table><tr valign="top"><td><img src="img/postit-logo.png" width="20px"></td><td>&nbsp;&nbsp;&copy; PostIt 2015</td></tr></table></p>
</footer>
</div><!--wrapper-mother-->
</body>
</html>



