<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrazione-consultazione esami</title>
        <%
            Cookie[] usercookies = request.getCookies();
            if (usercookies != null)
            {
                for (int i = 0; i < usercookies.length; i++)
                    if (usercookies[i].getName().compareTo("registrazione&consultazione%esami") == 0)
                    {
        %>
        <meta http-equiv="REFRESH" CONTENT="0; URL=ok.html">
        <%
                        break;
                    }
                    else
                    {
        %>
         <meta http-equiv="REFRESH" CONTENT="0; URL=login.html">
         <%
                    }
            }
            else
            {
        %>
        <meta http-equiv="REFRESH" CONTENT="0; URL=login.html">
        <%
            }
        %>
    </head>
</html>
