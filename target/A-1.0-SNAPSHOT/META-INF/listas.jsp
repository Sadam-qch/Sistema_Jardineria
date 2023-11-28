<%
    String opcion = request.getParameter("listas");
%>
<!-- Tu código HTML existente -->

<!-- Agrega una sección de estilos para los elementos con colores predeterminados -->
<style>
  .selected {
    background-color: #337ab7; /* Cambia esto al color deseado */
    color: white;
  }
</style>

<!-- JavaScript para cambiar el color al hacer clic y almacenar la preferencia -->
<script>
  // Función para cambiar el color y guardar la preferencia
  function cambiarColor(elemento) {
    var elementos = document.querySelectorAll('.sidebar-menu > li');
    
    // Eliminar la clase 'selected' de todos los elementos
    elementos.forEach(function(el) {
      el.classList.remove('selected');
    });

    // Agregar la clase 'selected' solo al elemento clicado
    elemento.classList.add('selected');

    // Obtener el texto o identificador único del elemento clicado para guardar la preferencia
    var opcionSeleccionada = elemento.textContent.trim(); // Puedes usar un identificador único aquí
    localStorage.setItem('opcionSeleccionada', opcionSeleccionada);
  }

  // Función para cargar la preferencia almacenada y aplicarla al cargar la página
  function cargarColor() {
    var opcionGuardada = localStorage.getItem('opcionSeleccionada');
    if (opcionGuardada) {
      var elementos = document.querySelectorAll('.sidebar-menu > li');
      elementos.forEach(function(el) {
        if (el.textContent.trim() === opcionGuardada) {
          el.classList.add('selected');
        }
      });
    }
  }

  // Llamar a la función cargarColor al cargar la página para aplicar la preferencia guardada
  cargarColor();
</script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="wrapper">
    <header class="main-header">
        <a href="index2.html" class="logo">
            <span class="logo-mini"><b>AD</b>V</span>
            <span class="logo-lg"><b>ADVentas</b></span>
        </a>
        <nav class="navbar navbar-static-top" role="navigation">
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Navegación</span>
            </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="hidden-xs">Jardineria El Corazón Verde</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-header">
                                <p>
                                    www.incanatoit.com - Desarrollando Software
                                    <small>www.youtube.com/jcarlosad7</small>
                                </p>
                            </li>
                            <li class="user-footer">

                                <div class="pull-right">
                                    <a href="#" class="btn btn-default btn-flat">Cerrar</a>
                                </div>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>

        </nav>
    </header>
    <aside class="main-sidebar">
        <section class="sidebar">
                    <ul class="sidebar-menu">
                        <li class="header"></li><br>

                        <!-- Menu Items ------------------------------------------------------------>
                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="ProductoServ" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-plus-fill" viewBox="0 0 16 16">
                                <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0m7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0M9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0"/>
                                </svg>
                                <span class="li" >PRODUCTOS</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            
                        </li>

                        <!-- Nuevas secciones para cada tabla -->
                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="CategoriaProductoServ" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clipboard-data-fill" viewBox="0 0 16 16">
                                <path d="M6.5 0A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0zm3 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5z"/>
                                <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1A2.5 2.5 0 0 1 9.5 5h-3A2.5 2.5 0 0 1 4 2.5zM10 8a1 1 0 1 1 2 0v5a1 1 0 1 1-2 0zm-6 4a1 1 0 1 1 2 0v1a1 1 0 1 1-2 0zm4-3a1 1 0 0 1 1 1v3a1 1 0 1 1-2 0v-3a1 1 0 0 1 1-1"/>
                                </svg>
                                <span class="li">CAT. DE PRODUCTOS</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>

                        </li>

                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="ProveedorServ" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-video3" viewBox="0 0 16 16">
                                <path d="M14 9.5a2 2 0 1 1-4 0 2 2 0 0 1 4 0m-6 5.7c0 .8.8.8.8.8h6.4s.8 0 .8-.8-.8-3.2-4-3.2-4 2.4-4 3.2"/>
                                <path d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h5.243c.122-.326.295-.668.526-1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v7.81c.353.23.656.496.91.783.059-.187.09-.386.09-.593V4a2 2 0 0 0-2-2z"/>
                                </svg>
                                <span class="li">PROVEEDORES</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                        </li>

                        <!-- Nuevas secciones para cada tabla -->
                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="EmpleadoServlet" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-add" viewBox="0 0 16 16">
                                <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0m-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0M8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4"/>
                                <path d="M8.256 14a4.474 4.474 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10c.26 0 .507.009.74.025.226-.341.496-.65.804-.918C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4s1 1 1 1z"/>
                                </svg>
                                <span class="li">EMPLEADOS</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                           
                        </li>

                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="ClienteServlet" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-arms-up" viewBox="0 0 16 16">
                                <path d="M8 3a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3"/>
                                <path d="m5.93 6.704-.846 8.451a.768.768 0 0 0 1.523.203l.81-4.865a.59.59 0 0 1 1.165 0l.81 4.865a.768.768 0 0 0 1.523-.203l-.845-8.451A1.492 1.492 0 0 1 10.5 5.5L13 2.284a.796.796 0 0 0-1.239-.998L9.634 3.84a.72.72 0 0 1-.33.235c-.23.074-.665.176-1.304.176-.64 0-1.074-.102-1.305-.176a.72.72 0 0 1-.329-.235L4.239 1.286a.796.796 0 0 0-1.24.998l2.5 3.216c.317.316.475.758.43 1.204Z"/>
                                </svg>
                                <span class="li">CLIENTES</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                        </li>
                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="OficinaServlet" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-houses-fill" viewBox="0 0 16 16">
                                <path d="M7.207 1a1 1 0 0 0-1.414 0L.146 6.646a.5.5 0 0 0 .708.708L1 7.207V12.5A1.5 1.5 0 0 0 2.5 14h.55a2.51 2.51 0 0 1-.05-.5V9.415a1.5 1.5 0 0 1-.56-2.475l5.353-5.354z"/>
                                <path d="M8.793 2a1 1 0 0 1 1.414 0L12 3.793V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v3.293l1.854 1.853a.5.5 0 0 1-.708.708L15 8.207V13.5a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 4 13.5V8.207l-.146.147a.5.5 0 1 1-.708-.708z"/>
                                </svg>
                                <span class="li">OFICINAS</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                        </li>

                        <!-- Nuevas secciones para cada tabla -->
                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="PedidoServ" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bag-check-fill" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M10.5 3.5a2.5 2.5 0 0 0-5 0V4h5zm1 0V4H15v10a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V4h3.5v-.5a3.5 3.5 0 1 1 7 0m-.646 5.354a.5.5 0 0 0-.708-.708L7.5 10.793 6.354 9.646a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z"/>
                                </svg>
                                <span class="li">PEDIDO</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                        </li>

                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="DetallePedidoServ" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-activity" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M6 2a.5.5 0 0 1 .47.33L10 12.036l1.53-4.208A.5.5 0 0 1 12 7.5h3.5a.5.5 0 0 1 0 1h-3.15l-1.88 5.17a.5.5 0 0 1-.94 0L6 3.964 4.47 8.171A.5.5 0 0 1 4 8.5H.5a.5.5 0 0 1 0-1h3.15l1.88-5.17A.5.5 0 0 1 6 2"/>
                                </svg>
                                <span class="li">DETALLE DE PEDIDOS</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                        </li>

                        <!-- Nuevas secciones para cada tabla -->
                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="PagoServlet" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-dollar" viewBox="0 0 16 16">
                                <path d="M4 10.781c.148 1.667 1.513 2.85 3.591 3.003V15h1.043v-1.216c2.27-.179 3.678-1.438 3.678-3.3 0-1.59-.947-2.51-2.956-3.028l-.722-.187V3.467c1.122.11 1.879.714 2.07 1.616h1.47c-.166-1.6-1.54-2.748-3.54-2.875V1H7.591v1.233c-1.939.23-3.27 1.472-3.27 3.156 0 1.454.966 2.483 2.661 2.917l.61.162v4.031c-1.149-.17-1.94-.8-2.131-1.718H4zm3.391-3.836c-1.043-.263-1.6-.825-1.6-1.616 0-.944.704-1.641 1.8-1.828v3.495l-.2-.05zm1.591 1.872c1.287.323 1.852.859 1.852 1.769 0 1.097-.826 1.828-2.2 1.939V8.73l.348.086z"/>
                                </svg>
                                <span class="li">PAGOS</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                        </li>

                        <li class="treeview" onclick="cambiarColor(this)">
                            <a href="VentaServlet" class="sub">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-gift-fill" viewBox="0 0 16 16">
                                <path d="M3 2.5a2.5 2.5 0 0 1 5 0 2.5 2.5 0 0 1 5 0v.006c0 .07 0 .27-.038.494H15a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h2.038A2.968 2.968 0 0 1 3 2.506zm1.068.5H7v-.5a1.5 1.5 0 1 0-3 0c0 .085.002.274.045.43a.522.522 0 0 0 .023.07M9 3h2.932a.56.56 0 0 0 .023-.07c.043-.156.045-.345.045-.43a1.5 1.5 0 0 0-3 0zm6 4v7.5a1.5 1.5 0 0 1-1.5 1.5H9V7zM2.5 16A1.5 1.5 0 0 1 1 14.5V7h6v9z"/>
                                </svg>
                                <span class="li">VENTAS</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                        </li>
                        <!-- Rest of the menu items -->
                        <!-- ... -->
                    </ul>
                </section>
    </aside>    