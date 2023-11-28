<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.DetallePedido"%>
<%@page import="com.emergentes.modelo.Pedido"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%@page import="com.emergentes.modelo.Proveedor"%>

<% DetallePedido detallePedido = (DetallePedido) request.getAttribute("detallePedido"); %>
<% List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedido"); %>
<% List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedor"); %>
<% List<Producto> productos = (List<Producto>) request.getAttribute("producto");%>

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

            .form-container h2 {
                margin-top: 0;
                margin-bottom: 20px;
            }

            .form-container input[type="number"],
            .form-container input[type="text"],
            .form-container select {
                width: 100%;
                padding: 8px;
                border-radius: 3px;
                border: 1px solid #ccc;
                box-sizing: border-box;
                margin-bottom: 10px;
            }

            .form-container input[type="submit"] {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
                font-size: 16px;
            }

            .form-container input[type="submit"]:hover {
                background-color: #0056b3;
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
                                <center><h2>Formulario de Detalle de Pedido</h2></center>
                                <div class="form-container">
                                    
                                    <form method="post" action="DetallePedidoServ">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="codigoProducto">Código Producto:</label>
                                                    <input type="number" id="codigoProducto" name="codigoProducto" value="<%= (detallePedido.getCodigoProducto() != null && !detallePedido.getCodigoProducto().equals("")) ? detallePedido.getCodigoProducto().getCodigoProducto() : 0%>">
                                                </div>
                                                <div class="form-group">
                                                    <label for="cantidad">Cantidad:</label>
                                                    <input type="number" id="cantidad" name="cantidad" value="<%= detallePedido.getCantidad()%>">
                                                </div>
                                                <div class="form-group">
                                                    <label for="precioUnidad">Precio Unitario:</label>
                                                    <input type="text" id="precioUnidad" name="precioUnidad" value="<%= detallePedido.getPrecioUnidad()%>">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="numeroLinea">Número de Línea:</label>
                                                    <input type="text" id="numeroLinea" name="numeroLinea" value="<%= detallePedido.getNumeroLinea()%>">
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigoProductoSelect">Código Producto:</label>
                                                    <select id="codigoProductoSelect" name="codigoProducto">
                                                        <% for (Producto prod : productos) {%>
                                                        <option value="<%= prod.getCodigoProducto()%>">
                                                            <%= prod.getCodigoProducto()%>
                                                        </option>
                                                        <% }%>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="codigoProveedor">Código Proveedor:</label>
                                                    <input type="text" id="codigoProveedor" name="codigoProveedor" value="<%= (detallePedido.getCodigoProveedor().getCodigoProveedor())%>">
                                                </div>
                                            </div>
                                        </div>
                                        <input type="submit" value="Guardar">
                                    </form>
                                </div>

                            </div><!-- /.box-body -->
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
    <strong>Copyright &copy;2023 <b><p>Carlos Mamani Corina--Albert Alexander Cordero Rivera--Sadam Quispe Chino</p></b></strong>
    All rights reserved.
</footer>
<script src="js/jQuery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/app.min.js"></script>
</body>
</html>
