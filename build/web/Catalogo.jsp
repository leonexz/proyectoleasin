 
<%@page import="BE.UsuarioBE"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="Head.jsp" />
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootsnav.js"></script>
        
    </head>
    <body>
        <%
            UsuarioBE unUsuario = (UsuarioBE) request.getSession().getAttribute("unUsuario");
            if (unUsuario == null || !unUsuario.isCliente()) {
                response.sendRedirect("login.jsp");
            }
        %>
        <jsp:include page="HeaderCliente.jsp" />

        <!-- CONENIDO DE P�GINA-->  
        <form action="#" target="#" method="get" name="formularioDatosPersonales">

            <h1>CAT�LOGO </h1>


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
