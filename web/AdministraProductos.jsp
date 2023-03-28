 
<%@page import="DAO.MemoriaRamDAO"%>
<%@page import="BE.MemoriaRamBE"%>
<%@page import="DAO.SistemaOperativoDAO"%>
<%@page import="BE.SistemaOperativoBE"%>
<%@page import="DAO.ProcesadorDAO"%>
<%@page import="BE.ProcesadorBE"%>
<%@page import="DAO.MarcaDAO"%>
<%@page import="BE.MarcaBE"%>
<%@page import="DAO.ModeloDAO"%>
<%@page import="BE.ModeloBE"%>
<%@page import="DAO.ProductoDAO"%>
<%@page import="BE.ProductoBE"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BE.UsuarioBE"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="Head.jsp" />  
    </head>
    <body>
        <%
            UsuarioBE unUsuario = (UsuarioBE) request.getSession().getAttribute("unUsuario");
            if (unUsuario == null || !unUsuario.isAdmin()) { 
                response.sendRedirect("login.jsp");
            }
            
            if (request.getParameter("btnRegistrarProducto") != null) {
                ProductoBE unProducto = new ProductoBE();
                unProducto.setId_pro(request.getParameter("id_pro"));
                unProducto.setNom_pro(request.getParameter("nom_pro"));
                unProducto.setFoto(request.getParameter("foto"));
                unProducto.setSku(request.getParameter("sku"));
                unProducto.setValor_referencial(Float.parseFloat(request.getParameter("valor_referencial")));
                unProducto.setColor(request.getParameter("color"));
                unProducto.setId_modelo(Integer.parseInt(request.getParameter("id_modelo")));
                unProducto.setId_marca(Integer.parseInt(request.getParameter("id_marca")));
                unProducto.setId_procesador(Integer.parseInt(request.getParameter("id_procesador")));
                unProducto.setId_sistema_operativo(Integer.parseInt(request.getParameter("id_sistema_operativo")));
                unProducto.setId_memoria_ram(Integer.parseInt(request.getParameter("id_memoria_RAM")));
                if(ProductoDAO.registrarProducto(unProducto) > 0){%>
                <script>
                    Swal.fire({
                        icon: 'success',
                        title: 'Hecho',
                        text: 'Se registro correctamente el Producto', 
                      })
                </script>
                <%}else{%>
                <script>
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'No se pudo registrar el producto', 
                      })
                </script>
                <%}
                
            }
        %>
        <jsp:include page="HeaderAdmin.jsp" />
        <div>
            <h1><strong>Productos</strong></h1>
        </div>
        <br>
        <br>
        <div class="container-md">
            <p>
                <button  class="btn btn-dark"  data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Agregar Producto    
                </button>
            </p>                
            <table class="table table-scriped table-borded table-hover" border="2">
                <thead>
                    <tr>
                        <th>Codigo Prod.</th>
                        <th>Nombre Prod.</th>
                        <th>Sku</th>
                        <th>Foto</th>
                        <th>Valor referencial</th>
                        <th>Color</th>
                        <th>Id modelo</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<ProductoBE> productos = ProductoDAO.listarProducto();
                        for (ProductoBE unProducto : productos) {
                    %>
                    <tr>
                        <td><%= unProducto.getId_pro()%></td>
                        <td><%= unProducto.getNom_pro()%></td>
                        <td><%= unProducto.getSku()%></td>
                        <td><img src="<%= unProducto.getFoto()%>" style="max-width: 50px" alt="foto producto"/></td> 
                        <td><%= unProducto.getValor_referencial()%></td>
                        <td><%= unProducto.getColor()%></td>
                        <td><%= unProducto.getId_modelo()%></td> 
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
                            <h5 class="modal-title" id="exampleModalLabel">NUEVO PRODUCTO</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">  
                                <input type="text" name="id_pro" required="" placeholder="Ingrese ID del Producto" class="form-control" autocomplete="off"><br>
                                <input type="text" name="nom_pro" required="" placeholder="Ingrese Nombre del Producto" class="form-control" autocomplete="off"><br>
                                <input type="text" name="foto" required="" placeholder="URL foto del Producto" class="form-control" autocomplete="off"><br>
                                <input type="text" name="sku" required="" placeholder="Ingrese SKU del Producto" class="form-control" autocomplete="off"><br>
                                <input type="number" name="valor_referencial" required="" placeholder="Ingrese Valor Referencial del Producto" class="form-control" autocomplete="off"><br>
                                <input type="text" name="color" required="" placeholder="Ingrese Color del Producto" class="form-control" autocomplete="off"><br>
                                <select name="id_modelo" class="form-select"> 
                                    <%
                                        ArrayList<ModeloBE> modelos = ModeloDAO.listarModelo();
                                        for (ModeloBE unModelo : modelos) {
                                    %>
                                    <option value="<%= unModelo.getId_modelo() %>"><%= unModelo.getTipo_modelo()%></option>
                                    <%
                                        }
                                    %>  
                                </select>
                                <br>
                                <select name="id_marca" class="form-select">
                                    <%
                                        ArrayList<MarcaBE> marca = MarcaDAO.listarMarca();
                                        for (MarcaBE unMarca : marca) {
                                    %>
                                    <option value="<%= unMarca.getId_marca()%>"><%= unMarca.getTipo_marca()%></option>
                                    <%
                                        }
                                    %>  
                                </select>
                                <br>
                                <select name="id_procesador" class="form-select">
                                    <%
                                        ArrayList<ProcesadorBE> procesador = ProcesadorDAO.listarProcesador();
                                        for (ProcesadorBE unProcesador : procesador) {
                                    %>
                                    <option value="<%= unProcesador.getId_procesador()%>"><%= unProcesador.getTipo_procesador()%></option>
                                    <%
                                        }
                                    %>  
                                </select>
                                <br>
                                <select name="id_sistema_operativo" class="form-select">
                                    <%
                                        ArrayList<SistemaOperativoBE> sisoppe = SistemaOperativoDAO.listarSisope();
                                        for (SistemaOperativoBE unSisope : sisoppe) {
                                    %>
                                    <option value="<%= unSisope.getId_sistema_operativo()%>"><%= unSisope.getTipo_sistema_operativo()%></option>
                                    <%
                                        }
                                    %>  
                                </select>
                                <br>
                                <select name="id_memoria_RAM" class="form-select">
                                    <%
                                        ArrayList<MemoriaRamBE> mmram = MemoriaRamDAO.listarMemoriaRam();
                                        for (MemoriaRamBE unaMram : mmram) {
                                    %>
                                    <option value="<%= unaMram.getId_memoria_ram()%>"><%= unaMram.getTipo_memoria_ram()%></option>
                                    <%
                                        }
                                    %>  
                                </select>
                                <br>  
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            <button type="submit" name="btnRegistrarProducto" value="btnRegistrarProducto" class="btn btn-primary">Registrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <br>
        <br>
        <jsp:include page="Footer.jsp" />
    </body>
</html>
