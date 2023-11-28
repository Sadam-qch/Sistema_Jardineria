<%@page import="com.emergentes.modelo.Empleado"%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@page import="com.emergentes.modelo.Venta"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Venta> lista = (ArrayList<Venta>) request.getAttribute("lista");
    ArrayList<Cliente> lista_clientes = (ArrayList<Cliente>) request.getAttribute("lista_clientes");
    ArrayList<Empleado> lista_empleados = (ArrayList<Empleado>) request.getAttribute("lista_empleados");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <jsp:param name="opcion" value="listas"/>
            </jsp:include>
            <div class="content-wrapper">
                <section class="content">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="box">
                                <h1>Lista Venta</h1>
                                <a href="VentaServlet?action=add" class="btn btn-primary">Nueva Venta</a>
                                <div class="table-responsive table-container">
                                    <table class="table table-striped" border="1">
                                        <tr>
                                            <th>Codigo Venta</th>
                                            <th>Fecha Venta</th>
                                            <th>Codigo Cliente</th>
                                            <th>Codigo Empleado</th>
                                            <th>Codigo Producto</th>
                                            <th>Cantidad</th>
                                            <th>Precio Unitario</th>
                                            <th>Total Venta</th>
                                            <th colspan="2">Acciones</th>  
                                        </tr>
                                        <c:forEach var="item" items="${lista}">
                                            <tr>
                                                <td>${item.codigo_venta}</td>
                                                <td>${item.fecha_venta}</td>
                                                <td>
                                                    <c:forEach var="empleado" items="${lista_empleados}">
                                                        <%-- Si el código de cliente del pago es igual al código de cliente en la lista --%>
                                                        <c:if test="${item.codigo_empleado == empleado.codigo_empleado}">
                                                            ${empleado.nombre}
                                                        </c:if>
                                                    </c:forEach>
                                                </td>
                                                <td>
                                                    <c:forEach var="cliente" items="${lista_clientes}">
                                                        <%-- Si el código de cliente del pago es igual al código de cliente en la lista --%>
                                                        <c:if test="${item.codigo_cliente == cliente.codigo_cliente}">
                                                            ${cliente.nombre_cliente}
                                                        </c:if>
                                                    </c:forEach>
                                                </td>
                                                <td>${item.codigo_producto}</td>
                                                <td>${item.cantidad}</td>
                                                <td>${item.precio_unitario}</td>
                                                <td>${item.total_venta}</td>
                                                <td><a href="VentaServlet?action=delete&codigo_venta=${item.codigo_venta}" class="btn btn-danger btn-eliminar">Eliminar</a></td>
                                                <td><a href="VentaServlet?action=edit&codigo_venta=${item.codigo_venta}" class="btn btn-primary">Editar</a></td>
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