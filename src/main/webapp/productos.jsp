<%@page import="com.emergentes.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
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
        .table-container {
            max-height: 400px; /* Ajusta esta altura según tus necesidades */
            overflow-y: auto; /* Agrega una barra de desplazamiento vertical si es necesario */
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <jsp:include page="META-INF/listas.jsp">
            <jsp:param name="opcion" value="ventas"/>
        </jsp:include>
        <div class="content-wrapper">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box">
                            <h2>Lista de Productos</h2>
                            <p><a href="ProductoServ?action=add" class="btn btn-primary">Agregar Producto</a></p>
                            <div class="table-responsive table-container">
                                <table class="table table-striped" border="1">
                                    <tr>
                                        <th>Código Producto</th>
                                        <th>Nombre</th>
                                        <th>Dimensiones</th>
                                        <th>Proveedor</th>
                                        <th>Descripción</th>
                                        <th>Cantidad en Stock</th>
                                        <th>Precio Venta</th>
                                        <th>Precio Decimal</th>
                                        <th>Categoría</th>
                                        <th colspan="2">Acciones</th>
                                    </tr>
                                    <% if (productos != null) { %>
                                        <% for (Producto producto : productos) { %>
                                            <tr>
                                                <td><%= producto.getCodigoProducto()%></td>
                                                <td><%= producto.getNombre()%></td>
                                                <td><%= producto.getDimensiones()%></td>
                                                <td><%= producto.getProveedor()%></td>
                                                <td><%= producto.getDescripcion()%></td>
                                                <td><%= producto.getCantidadStock()%></td>
                                                <td><%= producto.getPrecioVenta()%></td>
                                                <td><%= producto.getPrecioDecimal()%></td>
                                                <td><%= producto.getCodigoCategoria().getCodigoCategoria()%></td>
                                                <td>
                                                    <a href="ProductoServ?action=edit&id=<%= producto.getCodigoProducto()%>" class="btn btn-primary">Editar</a>
                                                </td>
                                                <td><a href="ProductoServ?action=delete&id=<%= producto.getCodigoProducto()%>"  class="btn btn-danger btn-eliminar">Eliminar</a></td>
                                            </tr>
                                        <% } %>
                                    <% } else { %>
                                        <tr>
                                            <td colspan="9">No hay productos disponibles</td>
                                        </tr>
                                    <% } %>
                                </table>
                            </div>
                        </div><!-- /.box -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </section><!-- /.content -->
        </div><!-- /.content-wrapper -->
    </div><!-- /.wrapper -->

    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.2.0
        </div>
        <strong>Copyright &copy;2023 <b><p>Carlos Mamani Corina--Albert Alexander Cordero Rivera--Sadam Quispe Chino</p></b></strong>   All rights reserved.
    </footer>

    <script src="js/jQuery-2.1.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/app.min.js"></script>
</body>
</html>
