<%@page import="DAO.EmpresaDAO"%>
<%@page import="BE.EmpresaBE"%> 
<%@page import="DAO.HistorialDAO"%>
<%@page import="BE.HistorialBE"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BE.UsuarioBE"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="Head.jsp" />  
    </head>
    <body>
        <div class="container">
            <%
                UsuarioBE unUsuario = (UsuarioBE) request.getSession().getAttribute("unUsuario");
                if (unUsuario == null || !unUsuario.isCliente()) {
                    response.sendRedirect("login.jsp");
                } else {
            %>
            <jsp:include page="HeaderCliente.jsp" />



            <div class="container-md">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <th>ID ALQUILER</th>
                    <th>T.PRESTAMO</th>
                    <th>CANT.EQUIP</th>
                    <th>RAZON SOCIAL</th>
                    <th>RUC</th> 
                    <th>ESTADO</th>
                    <th>NOMBRE</th>
                    <th>PR.ALQUILER</th>
                    <th>DESCUENTO</th>
                    <th>F.ENTREGA</th>
                    <th>F.DEVOLUCION</th>
                    </thead>
                    <tbody> 
                        <%
                            ArrayList<HistorialBE> historiales = HistorialDAO.listarHistorialDeUnUsuario(unUsuario.getId_usuario());
                            for (HistorialBE unHistorial : historiales) {
                        %>
                        <tr>
                            <td><%= unHistorial.getId_alquiler()%></td>
                            <td><%= unHistorial.getTiempo_prestamo()%></td>
                            <td><%= unHistorial.getCantidad_equipos()%></td>
                            <td><%= unHistorial.getRazonSocial()%></td>
                            <td><%= unHistorial.getRuc()%></td> 
                            <td><%= unHistorial.getEstado()%></td>
                            <td><%= unHistorial.getNombre()%></td>
                            <td><%= unHistorial.getPrecio_alquiler()%></td>
                            <td><%= unHistorial.getDescuento()%></td>
                            <td><%= unHistorial.getFechaEntrega()%></td>
                            <td><%= (unHistorial.getFechaDevolucion() == null ? "No Devuelto" : unHistorial.getFechaDevolucion())%></td> 
                        </tr> 
                        <%
                            }
                        %> 
                    </tbody>                
                </table>
            </div>
            <jsp:include page="Footer.jsp" />

        </div>

        <%
            }
        %>

    </body>
</html>
