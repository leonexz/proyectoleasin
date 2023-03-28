<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BE.UsuarioBE"%>
<%@page import="DAO.UsuarioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="Head.jsp" />
        <link href="CSS/estilosLogin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
        <%
            if (request.getParameter("btnIngresar") != null) {
                UsuarioBE unUsuario = new UsuarioBE();
                unUsuario.setNom_usu(request.getParameter("txtusuario"));
                unUsuario.setContrasenha(request.getParameter("txtpass"));
                unUsuario = UsuarioDAO.iniciarSesion(unUsuario);
                if (unUsuario.tieneID()) {
                    request.getSession().setAttribute("unUsuario", unUsuario);
                }
            }
            UsuarioBE unUsuario = (UsuarioBE) request.getSession().getAttribute("unUsuario");
            if (unUsuario != null) {
                if (unUsuario.isAdmin()) {
                    response.sendRedirect("InicioAdmin.jsp");
                } else if (unUsuario.isCliente()) {
                    response.sendRedirect("Inicio.jsp");
                }
            }
        %>
        <form method="POST" name="formularioDatosPersonales">
            <p align="center"><img src="Imagenes/1.JPG" alt=""/></p>
            <br>
            <label for="nombre">Usuario:</label>
            <input type="text" name="txtusuario" id="txtusuario" />
            <br>
            <br>
            <label for="contraseña">Contraseña:</label>
            <input type="password" name="txtpass" id="txtpass"/>
            <br>
            <br>
            <input type="submit" name="btnIngresar"  value="INGRESAR"/>
            <br>
            <br> 
        </form>
    </body>
</html>
