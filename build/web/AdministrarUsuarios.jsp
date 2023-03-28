 
<%@page import="DAO.EmpresaDAO"%>
<%@page import="BE.EmpresaBE"%>
<%@page import="DAO.ResponsableDAO"%>
<%@page import="BE.ResponsableBE"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="BE.RolBE"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.RolDAO"%>
<%@page import="BE.UsuarioBE"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="Head.jsp" />  
    </head>
    <body >
        <%
            UsuarioBE unUsuario = (UsuarioBE) request.getSession().getAttribute("unUsuario");
            if (unUsuario == null || !unUsuario.isAdmin()) {
                response.sendRedirect("login.jsp");
            }
            if (request.getParameter("btnRegistrarCliente") != null) {
                ResponsableBE unResponsable = new ResponsableBE();
                unResponsable.setNombre(request.getParameter("nombre"));
                unResponsable.setApellido(request.getParameter("apellido"));
                unResponsable.setDni(request.getParameter("dni"));
                unResponsable.setId_empresa(request.getParameter("id_empresa"));

                UsuarioBE unUser = new UsuarioBE();
                unUser.setNom_usu(request.getParameter("nom_usu"));
                unUser.setContrasenha(request.getParameter("contrasenha"));
                unUser.setId_rol(Integer.parseInt(request.getParameter("id_rol")));
                if ((ResponsableDAO.registrarResponsable(unResponsable) > 0) && (UsuarioDAO.registrarUsuario(unUser) > 0) ) { %>
                <script>
                    Swal.fire({
                        icon: 'success',
                        title: 'Hecho',
                        text: 'Se registro correctamente el responsable',
                    })
                </script>
                <%} else {%>
                <script>
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'No se pudo registrar el responsable ',
                    })
                </script>
                <%
                }
            }
        %>
        <jsp:include page="HeaderAdmin.jsp" />
        <div>
            <h1><strong>Usuarios</strong></h1>
        </div>
        <div class="container-md"> 
            <p>
                <button  class="btn btn-dark"  data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Agregar Usuario    
                </button>
            </p>
          
            <!-- Stop Formoid form-->

            <table class="table table-scriped table-borded table-hover p-2" border="2" style="width: border-box">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Usuario</th>
                        <th>Contrasenha</th>
                        <th>Personal</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<UsuarioBE> usuarios = UsuarioDAO.listarUsuario();
                        for (UsuarioBE usuario : usuarios) {
                    %>
                    <tr>
                        <td><%= usuario.getId_usuario()%></td>
                        <td><%= usuario.getNom_usu()%></td>
                        <td><%= usuario.getContrasenha()%></td>
                        <td><%= usuario.getId_rol()%></td>
                    </tr> 
                    <%
                        }
                    %> 
                </tbody> 
            </table>
            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form class="modal-content" method="post" autocomplete="off">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">NUEVO RESPONSABLE</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">  
                            <input type="text" name="nombre" required="" placeholder="Ingrese nombre del responsable" class="form-control" autocomplete="off"><br>
                            <input type="text" name="apellido" required="" placeholder="Ingrese apellido del responsable" class="form-control" autocomplete="off"><br>
                            <input type="text" name="dni" required="" placeholder="Ingrese dni del responsable" class="form-control" autocomplete="off"><br>
                            <input type="text" name="nom_usu" required="" placeholder="Ingrese usuario" class="form-control" autocomplete="off"><br>
                            <input type="password" name="contrasenha" required="" placeholder="Ingrese una contraseña" class="form-control" autocomplete="off"><br> 
                            <select name="id_empresa" class="form-select"> 
                                <%
                                    ArrayList<EmpresaBE> empresa = EmpresaDAO.listarEmpresa();
                                    for (EmpresaBE unaEmpresa : empresa) {
                                %>
                                <option value="<%= unaEmpresa.getId_empresa()%>"><%= unaEmpresa.getRazonSocial()%></option>
                                <%
                                    }
                                %>  
                            </select><br> 
                            <select name="id_rol" class="form-select"> 
                                <%
                                    ArrayList<RolBE> roles = RolDAO.listarRol();
                                    for (RolBE unRol : roles) {
                                %>
                                <option value="<%= unRol.getId_rol()%>"><%= unRol.getNom_rol()%></option>
                                <%
                                    }
                                %>  
                            </select>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            <button type="submit" name="btnRegistrarCliente" value="btnRegistrarCliente" class="btn btn-primary">Registrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <br> 
        <jsp:include page="Footer.jsp" />

    </body> 
</html>
