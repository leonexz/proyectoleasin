 
<%@page import="DAO.DetalleDAO"%>
<%@page import="DAO.AlquilerDAO"%>
<%@page import="BE.AlquilerBE"%>
<%@page import="DAO.ProductoDAO"%>
<%@page import="BE.UsuarioBE"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="Head.jsp" />  
    </head>
    <body>
        <%
            UsuarioBE unUsuario = (UsuarioBE) request.getSession().getAttribute("unUsuario");
            if (unUsuario == null || !unUsuario.isCliente()) {
                response.sendRedirect("login.jsp");
            }
            if (request.getParameter("btnAlquilar") != null) {
                String[] idsProducto = request.getParameterValues("productos[]");
                
                out.print("<script>let xd = "+(request.getParameter("productos") == null)+"</script>");
                if (idsProducto != null && idsProducto.length > 0) {
                    AlquilerBE unAlquiler = new AlquilerBE();
                    unAlquiler.setId_responsable(unUsuario.getId_usuario());
                    unAlquiler.setTiempo_prestamo(Integer.parseInt(request.getParameter("tiempo_prestamo")));
                    unAlquiler.setPrecio_alquiler(Double.parseDouble(request.getParameter("precio_alquiler")));
                    unAlquiler.setCantidad_equipos(idsProducto.length);
                    unAlquiler.setDescuento(0d);
                    unAlquiler.setEstado("Alquilado");
                    if (AlquilerDAO.registrarAlquiler(unAlquiler) > 0) {
                        DetalleDAO.registrarDetalleEnLote(AlquilerDAO.ultimoID(), idsProducto);%>
                        <script>
                            localStorage.clear();
                            Swal.fire({
                                icon: 'success',
                                title: 'Hecho',
                                text: 'Se registro correctamente el alquiler',
                            })
                        </script> 
                    <%} else {%>
                    <script>
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: 'No se pudo registrar el alquiler',
                        })
                    </script> 
                    <%}
                } else {
                %>
                <script>
                    Swal.fire({
                        icon: 'error',
                        title: 'Error',
                        text: 'Ningun producto seleccionado',
                    })
                </script> 
                <%}
            }
        %>
        <jsp:include page="HeaderCliente.jsp" /> 
        <div class="container"> 
            <center>
                <h2>CARRITO DE ALQUILER</h2>
            </center> 
            <div class="row">
                <!-- Elementos generados a partir del JSON -->
                <main id="items" class="col-sm-8 row"></main>
                <!-- Carrito -->
                <aside class="col-sm-4">
                    <h2>Carrito</h2>
                    <!-- Elementos del carrito -->
                    <ul id="carrito" class="list-group"></ul>
                    <hr>
                    <!-- Precio total -->
                    <p class="text-right">Total: S/.<span id="total"></span></p>
                    <button id="boton-vaciar" class="btn btn-danger">Vaciar</button> 
                    <button type="button" class="btn btn-primary" id="boton-alquilar"  data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Alquilar
                    </button> 
                </aside>
            </div>
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form method="POST" id="frmAlquilar" class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Registrar Alquiler</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body"> 
                            <select id="productos" readonly name="productos[]" value="" class="d-none" multiple>  
                            </select> 
                            <div class="mb-3">
                                <label class="form-label">Tiempo de Prestamo (Dias):</label>
                                <input type="number" min="1" value="1" class="form-control" name="tiempo_prestamo" id="tiempo_prestamo">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Precio del Alquiler:</label>
                                <input type="text" readonly class="form-control" name="precio_alquiler" id="precio_alquiler">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Cantidad Equipos:</label>
                                <input type="text" readonly class="form-control" name="cantidad_equipos" id="cantidad_equipos">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            <button type="submit" class="btn btn-primary" name="btnAlquilar" value="btnAlquilar">Alquilar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp" />

        <script>

            // Variables
            const productos = <%= ProductoDAO.listarProductoDisponiblesJson()%>;
            const form = $("form#frmAlquilar");
            const slcProductos = $("#productos");

            let carrito = [];
            let total = 0;
            const DOMitems = document.querySelector('#items');
            const DOMcarrito = document.querySelector('#carrito');
            const DOMtotal = document.querySelector('#total');
            const DOMbotonVaciar = document.querySelector('#boton-vaciar');
            const miLocalStorage = window.localStorage;

            // Funciones

            /**
             * Dibuja todos los productos a partir de la base de datos. No confundir con el carrito
             */
            function renderizarProductos() {
                DOMitems.textContent = "";
                productos.forEach((info) => {
                    // Estructura
                    const miNodo = document.createElement('div');
                    miNodo.classList.add('card', 'col-sm-4');
                    // Body
                    const miNodoCardBody = document.createElement('div');
                    miNodoCardBody.classList.add('card-body');
                    // Titulo
                    const miNodoTitle = document.createElement('h4');
                    miNodoTitle.classList.add('card-title');
                    miNodoTitle.textContent = info.nombre;
                    // Imagen
                    const miNodoImagen = document.createElement('img');
                    miNodoImagen.classList.add('img-fluid');
                    miNodoImagen.setAttribute('src', info.imagen);
                    // Precio
                    const miNodoPrecio = document.createElement('p');
                    miNodoPrecio.classList.add('card-text');
                    miNodoPrecio.textContent = 'S./' + info.precio;
                    // Boton  
                    const miNodoBoton = document.createElement('button');
                    miNodoBoton.classList.add('btn', 'btn-primary');
                    miNodoBoton.textContent = '+ Agregar';
                    miNodoBoton.setAttribute('marcador', info.id);
                    miNodoBoton.disabled = (carrito.findIndex((elemento) => elemento === info.id) != -1);
                    miNodoBoton.addEventListener('click', anyadirProductoAlCarrito);
                    // Insertamos
                    miNodoCardBody.appendChild(miNodoImagen);
                    miNodoCardBody.appendChild(miNodoTitle);
                    miNodoCardBody.appendChild(miNodoPrecio);
                    miNodoCardBody.appendChild(miNodoBoton);
                    miNodo.appendChild(miNodoCardBody);
                    DOMitems.appendChild(miNodo);
                });
            }

            /**
             * Evento para a�adir un producto al carrito de la compra
             */
            function anyadirProductoAlCarrito(evento) {
                // Anyadimos el Nodo a nuestro carrito
                carrito.push(evento.target.getAttribute('marcador'));
                this.disabled = true;
                // Calculo el total
                calcularTotal();
                // Actualizamos el carrito 
                renderizarCarrito();
                // Actualizamos el LocalStorage
                guardarCarritoEnLocalStorage();
            }

            /**
             * Dibuja todos los productos guardados en el carrito
             */
            function renderizarCarrito() {
                // Vaciamos todo el html
                DOMcarrito.textContent = '';
                // Quitamos los duplicados
                const carritoSinDuplicados = [...new Set(carrito)];
                // Generamos los Nodos a partir de carrito
                carritoSinDuplicados.forEach((item) => {
                    // Obtenemos el item que necesitamos de la variable base de datos
                    const miItem = productos.filter((unProducto) => {
                        // �Coincide las id? Solo puede existir un caso
                        return unProducto.id === item;
                    });
                    // Cuenta el n�mero de veces que se repite el producto
                    const numeroUnidadesItem = carrito.reduce((total, itemId) => {
                        // �Coincide las id? Incremento el contador, en caso contrario no mantengo
                        return itemId === item ? total += 1 : total;
                    }, 0);
                    // Creamos el nodo del item del carrito
                    const miNodo = document.createElement('li');
                    miNodo.classList.add('list-group-item', 'text-right', 'mx-2');
                    miNodo.textContent = numeroUnidadesItem + ` ` + miItem[0].nombre + ` - S/. ` + miItem[0].precio;
                    // Boton de borrar
                    const miBoton = document.createElement('button');
                    miBoton.classList.add('btn', 'btn-danger', 'mx-2');
                    miBoton.textContent = 'X Eliminar';
                    miBoton.style.marginLeft = '1rem';
                    miBoton.dataset.item = item;
                    miBoton.addEventListener('click', borrarItemCarrito);
                    // Mezclamos nodos
                    miNodo.appendChild(miBoton);
                    DOMcarrito.appendChild(miNodo);
                });
            }

            /**
             * Evento para borrar un elemento del carrito
             */
            function borrarItemCarrito(evento) {
                // Obtenemos el producto ID que hay en el boton pulsado
                const id = evento.target.dataset.item;
                // Borramos todos los productos
                carrito = carrito.filter((carritoId) => {
                    return carritoId !== id;
                });

                renderizarProductos();

                // volvemos a renderizar
                renderizarCarrito();
                // Calculamos de nuevo el precio
                calcularTotal();
                // Actualizamos el LocalStorage
                guardarCarritoEnLocalStorage();

            }

            /**
             * Calcula el precio total teniendo en cuenta los productos repetidos
             */
            function calcularTotal() {
                // Limpiamos precio anterior
                total = 0;
                // Recorremos el array del carrito
                carrito.forEach((item) => {
                    // De cada elemento obtenemos su precio
                    const miItem = productos.filter((unProducto) => {
                        return unProducto.id === item;
                    });
                    total = total + miItem[0].precio;
                });
                // Renderizamos el precio en el HTML
                DOMtotal.textContent = total.toFixed(2);
            }

            function guardarCarritoEnLocalStorage() {
                miLocalStorage.setItem('carrito', JSON.stringify(carrito));
            }

            function cargarCarritoDeLocalStorage() {
                // �Existe un carrito previo guardado en LocalStorage?
                if (miLocalStorage.getItem('carrito') !== null) {
                    // Carga la informaci�n
                    carrito = JSON.parse(miLocalStorage.getItem('carrito'));
                }
            }

            productos.forEach((unProducto) => {
                slcProductos.append('<option value="' + unProducto["id"] + '" >' + unProducto["id"] + '</option>')
            })

            // Eventos
            DOMbotonVaciar.addEventListener('click', function () {
                // Limpiamos los productos guardados
                carrito = [];
                // Renderizamos los cambios
                renderizarProductos();
                renderizarCarrito();
                calcularTotal();
                // Borra LocalStorage
                localStorage.clear();

            });

            $("#boton-alquilar").click(function () {
                slcProductos.val(carrito).trigger("change");
                $("#precio_alquiler").val($("#total").text());
                $("#cantidad_equipos").val(carrito.length + (carrito.length != 1 ? " Laptops" : " Laptop"));
            })

            // Inicio
            cargarCarritoDeLocalStorage();
            renderizarProductos();
            calcularTotal();
            renderizarCarrito();
        </script>
    </body>
</html>
