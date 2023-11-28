<%@page import="com.emergentes.modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Pedido"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getAttribute("clientes");
    ArrayList<Pedido> pedidos = (ArrayList<Pedido>) request.getAttribute("pedidos");
%>
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
                max-height: 400px; /* Cambia este valor según el tamaño fijo que desees */
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
                                <h2>Lista de Pedidos</h2>
                                <p><a href="PedidoServ?action=add" class="btn btn-primary">Agregar Nuevo Pedido</a></p>
                                <div class="table-responsive table-container">
                                    <table class="table table-striped" border="1">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Fecha Pedido</th>
                                                <th>Fecha Esperada</th>
                                                <th>Fecha Entrega</th>
                                                <th>Estado</th>
                                                <th>Comentarios</th>
                                                <th>Código Cliente</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="pedido" items="${pedidos}">
                                                <tr>
                                                    <td>${pedido.codigoPedido}</td>
                                                    <td>${pedido.fechaPedido}</td>
                                                    <td>${pedido.fechaEsperada}</td>
                                                    <td>${pedido.fechaEntrega}</td>
                                                    <td>${pedido.estado}</td>
                                                    <td>${pedido.comentarios}</td>
                                                    <td>${pedido.codigoCliente.codigo_cliente}</td>
                                                    <td>
                                                        <a href="PedidoServ?action=edit&id=${pedido.codigoPedido}" class="btn btn-warning">Editar</a>
                                                        <a href="PedidoServ?action=delete&id=${pedido.codigoPedido}" class="btn btn-danger">Eliminar</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
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

