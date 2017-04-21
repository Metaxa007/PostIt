
<%@page import="servlets.UserArrayList"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>Login</title>
        <!--<meta charset="UTF-8">-->
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

<h1>Kontakte</h1>
<fieldset>
<table class="kontakte-table">
<tr>
<% 
    
    int numInArr = 0;
    String login=(String) request.getSession().getAttribute("emailLogin");
    for(int i=0;i<UserArrayList.userListe.size();i++){
	if(login.equals(UserArrayList.userListe.get(i).getEmail())){
		numInArr=i;
	}
    }
    
    int count=0;
    //Freunde Ausgeben
    for(int i=0; i<UserArrayList.userListe.get(numInArr).friends.size(); i++){
        String email = UserArrayList.userListe.get(numInArr).friends.get(i);
        String vorname="";
        String nachname="";
        //For-Schleife, soll Name liefern
        for(int j=0;j<UserArrayList.userListe.size();j++){
            if(UserArrayList.userListe.get(j).getEmail().equals(email)){
                vorname = UserArrayList.userListe.get(j).getVorname();
                nachname = UserArrayList.userListe.get(j).getName();
            }
        }
        
        if(count%2 == 0){
            out.println("</tr><tr>");
        }
        count++;
%>
<td>
    <img src="img/test.jpg" alt="Profil Bild" width="110px">
    <a href="pageother.jsp?id=<%=email%>"><%=vorname+" "+nachname%></a>
</td>
<%
}
%>
</tr>
</table>

</fieldset>
</div><!--wrapper-main-->
</div><!--wrapper-mother-->
</body>
</html>