function searchFor(suchbegriff){
			var xmlHttp = null;
			// Mozilla, Opera, Safari sowie Internet Explorer 7
			if (typeof XMLHttpRequest != 'undefined') {
				xmlHttp = new XMLHttpRequest();
			}
			if (!xmlHttp) {
				// Internet Explorer 6 und �lter
				try {
					xmlHttp  = new ActiveXObject("Msxml2.XMLHTTP");
				} catch(e) {
					try {
						xmlHttp  = new ActiveXObject("Microsoft.XMLHTTP");
					} catch(e) {
						xmlHttp  = null;
					}
				}
			}
			// Wenn das Objekt erfolgreich erzeugt wurde			
			if (xmlHttp) {
				var url = "inc/suche.inc.jsp";
				var params = "suchbegriff="+suchbegriff;
				
				xmlHttp.open("POST", url, true);
				
				//Headerinformationen f�r den POST Request
				xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xmlHttp.setRequestHeader("Content-length", params.length);
				xmlHttp.setRequestHeader("Connection", "close");					
			
				xmlHttp.onreadystatechange = function () {
					if (xmlHttp.readyState == 4) {
						// Zur�ckgeliefertes Ergebnis wird in den DIV "ergebnis" geschrieben
						document.getElementById("ergebnis").innerHTML = xmlHttp.responseText;
					}
				};				
				xmlHttp.send(params);
			}			
		}
