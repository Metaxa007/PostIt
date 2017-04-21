<%@page import="servlets.Scientist"%>
<%@page import="servlets.UserArrayList"%>
<%
    int userAnzahl = Scientist.usersAnzahl();
    int postAnzahl = Scientist.postAnzahl();
    double postsDurchschnitt = Math.round(100.0*((double)Scientist.postAnzahl()/Scientist.usersAnzahl()))/100.0;
    double freundeDruchschnitt = Scientist.freundeDurchschnitt();
    double maxPosts = Scientist.maxPosts();
    double minPosts = Scientist.minPosts();
    double maxFreunde = Scientist.maxFreunde();
    double minFreunde = Scientist.minFreunde();
%>
<!DOCTYPE HTML>
<html>
<head>
	<title>Login</title>
        <!--<meta charset="UTF-8">-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/normalize.css" rel="stylesheet" type="text/css">
	<link href="css/style.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["User", "Anzahl", { role: "style" } ],
        ["User", <%=userAnzahl%>, "#4363a9"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Anzahl an Usern",
        width: 400,
        height: 300,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values_users"));
      chart.draw(view, options);
  }
 </script>
 <script type="text/javascript">
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Posts", "Anzahl", { role: "style" } ],
        ["Posts", <%=postAnzahl%>, "orange"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Anzahl an Posts",
        width: 400,
        height: 300,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values_posts"));
      chart.draw(view, options);
  }
 </script>
 <script type="text/javascript">
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Posts", "Wert", { role: "style" } ],
        ["Min", <%=minPosts%>, "#f1595f"],
        ["Durchschnitt", <%=postsDurchschnitt%>, "#79c36a"],
        ["Max", <%=maxPosts%>, "#599ad3"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Anzahl an Posts - Vergleich",
        width: 400,
        height: 300,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.BarChart(document.getElementById("post_durchschnitt"));
      chart.draw(view, options);
  }
  </script>
  <script type="text/javascript">
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Freunde", "Wert", { role: "style" } ],
        ["Min", <%=minFreunde%>, "#f9a65a"],
        ["Durchschnitt", <%=freundeDruchschnitt%>, "#CCFF99"],
        ["Max", <%=maxFreunde%>, "#99FFCC"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Anzahl an Freunden - Vergleich",
        width: 400,
        height: 300,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.BarChart(document.getElementById("freunde_durchschnitt"));
      chart.draw(view, options);
  }
  </script>
  
</head>
<body>
  </script>
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

<h1>Statistik</h1>

<br>
<br>
<center>
<table class="scientist_table">
    <tr>
        <td>Anzahl an Usern: </td>
        <td><div id="columnchart_values_users"></div></td>
    </tr>
    <tr>
        <td>Anzahl an Posts: </td>
        <td><div id="columnchart_values_posts"></div></td>
    </tr>
    <tr>
        <td>Anzahl an Posts - Vergleich:</td>
        <td><div id="post_durchschnitt"></div></td>
    </tr>
    <tr>
        <td>Anzahl an Freunden - Vergleich:</td>
        <td><div id="freunde_durchschnitt"></div></td>
    </tr>
</table>
</center>
<br>
<br>
<br>
<br>
<br>
</div><!--wrapper-main-->
</div><!--wrapper-mother-->
</body>
</html>
