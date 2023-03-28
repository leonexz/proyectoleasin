 
<%@page import="BE.UsuarioBE"%> 
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="Head.jsp" />  
    </head>
    <body> 
        <%
            request.getSession().setAttribute("unUsuario", null);
            response.sendRedirect("login.jsp");
        %> 
    </body>
</html>
