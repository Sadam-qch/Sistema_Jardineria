<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.CategoriaProducto"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    ArrayList<CategoriaProducto> categoriapros = (ArrayList<CategoriaProducto>) request.getAttribute("categoriapros");
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
                                <h2>Lista de Categoría Productos</h2>
                                <p><a href="CategoriaProductoServ?action=add" class="btn btn-primary">Agregar</a></p>
                                <div class="table-responsive table-container">
                                    <table class="table table-striped" border="1">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre</th>
                                                <th>Descripción</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${categoriapros}">
                                                <tr>
                                                    <td>${item.codigoCategoria}</td>
                                                    <td>${item.nombreCategoria}</td>
                                                    <td>${item.descripcionCategoria}</td>
                                                    <td>
                                                        <a href="CategoriaProductoServ?action=edit&id=${item.codigoCategoria}" class="btn btn-warning">Editar</a>
                                                        <a href="CategoriaProductoServ?action=delete&id=${item.codigoCategoria}" class="btn btn-danger">Eliminar</a>
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
            <strong>Copyright &copy; 2023 <b>Carlos Mamani Corina--Albert Alexander Cordero Rivera--Sadam Quispe Chino</b></strong>
            All rights reserved.
        </footer>
        <script src="js/jQuery-2.1.4.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/app.min.js"></script>
    </body>
</html>
