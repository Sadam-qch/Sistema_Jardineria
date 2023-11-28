<%@page import="com.emergentes.modelo.Oficina"%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Empleado> empleado = (ArrayList<Empleado>) request.getAttribute("empleado");
    ArrayList<Oficina> lista_oficinas = (ArrayList<Oficina>) request.getAttribute("lista_oficinas");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>ADVentas | www.incanatoit.com</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
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
    <body  class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <jsp:include page="META-INF/listas.jsp">
                <jsp:param name="opcion" value="ventas"/>
            </jsp:include>
            <div class="content-wrapper">
                <section class="content">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="box">
                                <h1>Lista Empleado</h1>
                                <a href="EmpleadoServlet?action=add" class="btn btn-primary">Nuevo Empleado</a>
                                <div class="table-responsive table-container">
                                    <table class="table table-striped" border="1">
                                        <tr>
                                            <th>Codigo Empleado</th>
                                            <th>Nombre</th>
                                            <th>Apellido 1</th>
                                            <th>Apellido 2</th>
                                            <th>Extension</th>
                                            <th>Email</th>
                                            <th>Codigo Oficina</th>
                                            <th>Puesto</th>
                                            <th colspan="2">Acciones</th>

                                        </tr>
                                        <c:forEach var="item" items="${empleado}">
                                            <tr>
                                                <td>${item.codigo_empleado}</td>
                                                <td>${item.nombre}</td>
                                                <td>${item.apellido1}</td>
                                                <td>${item.apellido2}</td>
                                                <td>${item.extension}</td>
                                                <td>${item.email}</td>
                                                <td>${item.codigo_oficina}</td>
                                                <td>${item.puesto}</td>
                                                <td><a href="EmpleadoServlet?action=delete&codigo_empleado=${item.codigo_empleado}" class="btn btn-danger btn-eliminar">Eliminar</a></td>
                                                <td><a href="EmpleadoServlet?action=edit&codigo_empleado=${item.codigo_empleado}" class="btn btn-primary">Editar</a></td>
                                            </tr>
                                        </c:forEach>
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
