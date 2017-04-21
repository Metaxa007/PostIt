<%@page import="java.io.PrintWriter"%>
<%@page import="servlets.UserArrayList"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
    HttpSession ses = request.getSession();
    String emailOther = request.getParameter("id");
    int numInArr = 0;
    int fake=-1;
    for(int i=0;i<UserArrayList.userListe.size();i++){
        if(emailOther.equals(UserArrayList.userListe.get(i).getEmail())){
            numInArr = i;
        }
    }               

    boolean areFriends = false;
    int myNumInArr=0;
    int otherNumInArr=0;
    String myEmail=(String)request.getSession().getAttribute("emailLogin");

    for(int i=0;i<UserArrayList.userListe.size();i++){
        if(myEmail.equals(UserArrayList.userListe.get(i).getEmail()))
            myNumInArr=i;
    }
    //??? Zeile 9!
    for(int i=0;i<UserArrayList.userListe.size();i++){
        if(emailOther.equals(UserArrayList.userListe.get(i).getEmail()))
            otherNumInArr=i;
    }
    
    //Schau ob in meiner Freundeliste ist
    for(int i =0; i<UserArrayList.userListe.get(myNumInArr).friends.size(); i++){
        if(emailOther.equals(UserArrayList.userListe.get(myNumInArr).friends.get(i))){
            areFriends = true;
        }
    }
%>

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
<div class="profil-info-container group">
	<div class="profil-info-links">
		<img src="img/test.jpg">
	</div>
	<div class="profil-info-rechts">
            <br>
            <br>
		<table class="profil-info-table">
			<tr>
				<td><h3>Vorname:</h3></td>
				<td><h3>Nachname:</h3></td>
			</tr>
			<tr>
				<td><%=UserArrayList.userListe.get(numInArr).getVorname()%></td>
				<td><%=UserArrayList.userListe.get(numInArr).getName()%></td>
			</tr>
			<tr>
				<td><h3>E-Mail:</h3></td>
				<td><h3>Geb-Datum:</h3></td>
			</tr>
			<tr>
				<td><%=UserArrayList.userListe.get(numInArr).getEmail()%></td>
				<td><%=UserArrayList.userListe.get(numInArr).getGebDatum()%></td>
			</tr>
			<tr>
				<td><h3>Studium:</h3></td>
				<td><h3>Sprache:</h3></td>
			</tr>
			<tr>
				<td><%=UserArrayList.userListe.get(numInArr).getStudium()%></td>
				<td><%=UserArrayList.userListe.get(numInArr).getSprache()%></td>
			</tr>
		</table>

</div><!--Profil-inof-rechts-->
</div><!--Profil-inof-container-->
<nav>
        <a href="main.jsp">Mein Profil</a>
	<a href="kontakte.jsp">Freunde</a>
        <%if(!areFriends){
            out.println("<a href='AddFriend?id="+emailOther+"&myNumInArr="+myNumInArr+"&otherNumInArr="+otherNumInArr+"'>Hinzuf&uuml;gen</a>");
        }
        %>
        
        <%  
            if(UserArrayList.userListe.get(myNumInArr).getAdmin()){
            out.println("<a href='UserBlock?id="+emailOther+"' style='color: red;'>User blockieren</a>");
        }
        %>
</nav>

<div class="wrapper-main">
    <fieldset>
    <%    
    if(areFriends){
     %>
	<table class="pinnwand-table">
		<form action="PinnwandSpeichern" method ="POST">
			<tr valign="top">
				<td><textarea name="eintrag" ></textarea></td>
				<td><input type="hidden" name="otherInArr" value="<%=otherNumInArr%>"></td>
				<td><input type="hidden" name="numInArr" value="<%=fake%>"></td>
				<td><input type="hidden" name="myNumInArr" value="<%=myNumInArr%>"></td>
				<td><input type="submit" value="#PostIt" class="submit-button"></td>
			</tr>
		</form>
	</table>
     <%
	  
        for(int i=(UserArrayList.userListe.get(otherNumInArr).eintragListe.size())-1;i>=0;i--){
            if(UserArrayList.userListe.get(myNumInArr).getAdmin()){
                out.println("<a href='PostDelete?id="+otherNumInArr+"&nrOfPost="+i+"&emailOther="+emailOther+"' style='color:red;'><strong>X</strong></a>");
            }
            out.println("<h4>"+UserArrayList.userListe.get(otherNumInArr).eintragListe.get(i).getVorname() + " " + UserArrayList.userListe.get(numInArr).eintragListe.get(i).getName()+ "</h4>");
            out.println("<p>"+UserArrayList.userListe.get(otherNumInArr).eintragListe.get(i).getEintrag()+ "</p><hr>");
        }
    }   
    %>
</fieldset>
	
</div><!--wrapper-main-->
</div><!--wrapper-mother-->
</body>
</html>