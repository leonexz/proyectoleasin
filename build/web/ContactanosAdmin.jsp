 
<%@page import="BE.UsuarioBE"%>
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
        <!-- CONENIDO DE P�GINA-->  

        <section class="slider"> <!-- IMAGEN DE CONTENIDO-->
            <center>
                <img src="Imagenes/contactenos 1.jpeg" alt="" width="1000px"/>
            </center>

        </section>
        <br>
        <jsp:include page="Footer.jsp" />
    </body>
</html>
