<%@page import="servlets.Admin"%>
<%@page import="servlets.Scientist"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="servlets.UserArrayList"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>

<!DOCTYPE HTML>
<html>
<head>
	<title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/normalize.css" rel="stylesheet" type="text/css">
	<link href="css/style.css" rel="stylesheet" type="text/css">
        <script src="js/suche.js" language="JavaScript" type="text/javascript"></script>
</head>
<body>
<div class="wrapper-mother">
<header>
        <a href="Abmelden" class="abmelden">Abmelden</a>
	<a href="main.jsp" class="logo-a">
		<table>
			<tr valign="top">
				<td><img src="img/postit-logo.png" width="65px"></td>
				<td>&nbsp;&nbsp;#PostIt</td>
			</tr>
		</table>
	</a>
        <table class="table_suche" cellspacing="0" cellpadding="0">
	<tr bgcolor="white">
		<td><input type="text" placeholder="Ergebnis suchen..." onkeyup="searchFor(this.value);" class="suche_input"></td>
	</tr>
	<th colspan="2" id="ergebnis">
		
	</th>
        </table>
</header>
<div class="profil-info-container group">
	<div class="profil-info-links">
		<img src="img/test.jpg">
	</div>
       
	<div class="profil-info-rechts">
		<table class="profil-info-table">
<%      
HttpSession ses = request.getSession();
boolean sessionGilt=false;
int numInArr=0;
int fake=-1;
String login=(String) ses.getAttribute("emailLogin");

for(int i=0;i<UserArrayList.userListe.size();i++){
	if(login.equals(UserArrayList.userListe.get(i).getEmail())){
		numInArr=i;
	}
}
    
for(int i=0;i<UserArrayList.userListe.size();i++){
	if(login.equals(UserArrayList.userListe.get(i).getEmail())){
		%>
		<tr>
			<td><h3>Vorname:</h3></td>
			<td><h3>Nachname:</h3></td>
		</tr>
		<tr>
			<td><%=UserArrayList.userListe.get(i).getVorname()%></td>
			<td><%=UserArrayList.userListe.get(i).getName()%></td>
		</tr>
		<tr>
			<td><h3>E-Mail:</h3></td>
			<td><h3>Geb-Datum:</h3></td>
		</tr>
		<tr>
			<td><%=UserArrayList.userListe.get(i).getEmail()%></td>
			<td><%=UserArrayList.userListe.get(i).getGebDatum()%></td>
		</tr>
		<tr>
			<td><h3>Studium:</h3></td>
			<td><h3>Sprache:</h3></td>
		</tr>
		<tr>
			<td><%=UserArrayList.userListe.get(i).getStudium()%></td>
			<td><%=UserArrayList.userListe.get(i).getSprache()%></td>                       
		</tr>
	<% }
           }
        %>	


</table>
	</div>
</div>
<nav>
	<a href="profilBearbeiten.jsp">Profil Bearbeiten</a>
	<a href="kontakte.jsp">Freunde</a>
        <%if(UserArrayList.userListe.get(numInArr).getScientist()==true){
            out.println("<a href='statistic.jsp'>Statitic</a>");
        }
        %>
</nav>

<div class="wrapper-main">
   
    
    <table class="pinnwand-table">
        <form action="PinnwandSpeichern" method ="POST">
        <tr valign="top">
            <td><textarea name="eintrag" ></textarea></td>
            <td><input type="hidden" name="numInArr" value="<%=numInArr%>"></td>
            <td><input type="hidden" name="otherInArr" value="<%=fake%>"></td>
            <td><input type="submit" value="#PostIt" class="submit-button"></td>
        </form>
    </table>

     
<fieldset>
<%  
    
    
    for(int i=(UserArrayList.userListe.get(numInArr).eintragListe.size())-1;i>=0;i--){
         
        out.println("<h4>"+UserArrayList.userListe.get(numInArr).eintragListe.get(i).getVorname() + " " + UserArrayList.userListe.get(numInArr).eintragListe.get(i).getName()+ "</h4>");
        out.println("<p>"+UserArrayList.userListe.get(numInArr).eintragListe.get(i).getEintrag()+ "</p><hr>");
        
       
}
%>
</fieldset>

</div><!--wrapper-main-->
<footer>
	<p><table><tr valign="top"><td><img src="img/postit-logo.png" width="20px"></td><td>&nbsp;&nbsp;&copy; PostIt 2015</td></tr></table></p>
</footer>
</div><!--wrapper-mother-->
</body>
</html>