<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%@page import="com.emergentes.modelo.CategoriaProducto"%>

<% Producto producto = (Producto) request.getAttribute("producto"); %>
<% List<CategoriaProducto> categorias = (List<CategoriaProducto>) request.getAttribute("categorias");%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>ADVentas | www.incanatoit.com</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="css/AdminLTE.min.css">
        <link rel="stylesheet" href="css/_all-skins.min.css">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="shortcut icon" href="img/favicon.ico">
        <link rel="stylesheet" href="css/style-tabla.css">
        <style>
            /* Estilos para el formulario */
            .form-container {
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                background-color: #f9f9f9;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .form-group {
                margin-bottom: 20px;
            }

            label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            input[type="text"],
            input[type="date"],
            select {
                width: 100%;
                padding: 8px;
                border-radius: 3px;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            button {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
                font-size: 16px;
            }

            button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <jsp:include page="META-INF/listas.jsp">
                <jsp:param name="opcion" value="listas"/>
            </jsp:include>
            <div class="content-wrapper">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="box">
                                <center><h2>Formulario de Producto</h2></center>
                               <div class="form-container">
    <form method="post" action="ProductoServ" class="form">
        <input type="hidden" name="codigoProducto" value="<%= producto.getCodigoProducto()%>">
        
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" class="form-control" name="nombre" value="<%= producto.getNombre()%>">
                </div>
                <div class="form-group">
                    <label>Dimensiones:</label>
                    <input type="text" class="form-control" name="dimensiones" value="<%= producto.getDimensiones()%>">
                </div>
                <div class="form-group">
                    <label>Proveedor:</label>
                    <input type="text" class="form-control" name="proveedor" value="<%= producto.getProveedor()%>">
                </div>
                <div class="form-group">
                    <label>Descripción:</label>
                    <input type="text" class="form-control" name="descripcion" value="<%= producto.getDescripcion()%>">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label>Cantidad en Stock:</label>
                    <input type="text" class="form-control" name="cantidadStock" value="<%= producto.getCantidadStock()%>">
                </div>
                <div class="form-group">
                    <label>Precio Venta:</label>
                    <input type="text" class="form-control" name="precioVenta" value="<%= producto.getPrecioVenta()%>">
                </div>
                <div class="form-group">
                    <label>Precio D:</label>
                    <input type="text" class="form-control" name="precioDecimal" value="<%= producto.getPrecioDecimal()%>">
                </div>
                <div class="form-group">
                    <label>Categoría:</label>
                    <select name="codigoCategoria" class="form-control">
                        <% for (CategoriaProducto categoria : categorias) {%>
                        <option value="<%= categoria.getCodigoCategoria()%>" <% if (categoria.getCodigoCategoria() == producto.getCodigoCategoria().getCodigoCategoria()) { %>selected<% }%>><%= categoria.getNombreCategoria()%></option>
                        <% }%>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <input type="submit" value="Guardar" class="btn btn-primary">
            </div>
        </div>
    </form>
    <br>
    <a href="ProductoServ?action=view">Volver a la Lista de Productos</a>
</div><!-- /.form-container -->

                            </div>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </section><!-- /.content -->
            </div><!-- /.content-wrapper -->

            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 1.2.0
                </div>
                <strong>Copyright &copy;2023 <b><p>Carlos Mamani Corina--Albert Alexander Cordero Rivera--Sadam Quispe Chino</p></b></strong>
                All rights reserved.
            </footer>
            <script src="js/jQuery-2.1.4.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/app.min.js"></script>
        </div><!-- /.wrapper -->
    </body>
</html>
