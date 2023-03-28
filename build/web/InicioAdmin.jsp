<%@page import="BE.UsuarioBE"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="Head.jsp" />  
    </head>
    <body> 
        <%
            UsuarioBE unUsuario = (UsuarioBE) request.getSession().getAttribute("unUsuario");
            if (unUsuario == null || !unUsuario.isAdmin()) {%> 
        <% response.sendRedirect("login.jsp");
            }
        %>
        <jsp:include page="HeaderAdmin.jsp" />

        <section class="slider"> <!-- IMAGEN DE CONTENIDO-->
            <img src="Imagenes/imageninicio.png" alt="" width="100%"/>
        </section> 

        <jsp:include page="Footer.jsp" />
    </body> 
</html>
