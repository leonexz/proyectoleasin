 
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
        <!-- CONENIDO DE PÁGINA-->  
        <form action="#" target="#" method="get" name="formularioDatosPersonales">

            <h1>CATÁLOGO </h1>


            <input type="text" name="producto" id="producto" placeholder="Buscar por Marca o Modelo, Disponibles" />

            <input type="submit" name="buscar" value="BUSCAR"/>
            <br>
            <br>
            <br>
        </form>
        <section class="slider"> <!-- IMAGEN DE CONTENIDO-->
            <img src="Imagenes/imagCatalogo.png" alt=""/>
        </section>
        <jsp:include page="Footer.jsp" />
    </body>
</html>
