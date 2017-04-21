<%@page import="servlets.UserArrayList"%>
<%
    HttpSession ses = request.getSession();
    String suchbegriff = request.getParameter("suchbegriff");
    out.println("<table cellspacing='0' cellpadding='0'>");
    for(int i=0;i<UserArrayList.userListe.size();i++){
        if(suchbegriff != "" && UserArrayList.userListe.get(i).getName().toLowerCase().contains(suchbegriff)){
            String nachname = UserArrayList.userListe.get(i).getName();
            String vorname = UserArrayList.userListe.get(i).getVorname();
            String email = UserArrayList.userListe.get(i).getEmail();
            out.println("<tr>");
            if(ses.getAttribute("emailLogin").equals(email)){
 %>
                <td><a href="main.jsp"><%=vorname+" "+nachname%></a></td>
 <%
            } else {         
 %>
                <td><a href="pageother.jsp?id=<%=email%>"><%=vorname+" "+nachname%></a></td>
<%
            }
            out.println("</tr>");
        }
    }
    out.println("</table>");
%>