<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Pago"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Pago> pago = (ArrayList<Pago>) request.getAttribute("pago");
    List<Cliente> lista_clientes = (List<Cliente>) request.getAttribute("lista_clientes");
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
                <jsp:param name="opcion" value="ventas"/>
            </jsp:include>
            <div class="content-wrapper">
                <section class="content">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="box">
                                <h1>Lista de Pago</h1>
                                <a href="PagoServlet?action=add" class="btn btn-primary">Nuevo Pago</a><br><br>
                                <div class="table-responsive table-container">
                                <table class="table table-striped" border="1">
                                    <thead>
                                        <tr>
                                            <th>Codigo Cliente</th>
                                            <th>Forma Pago</th>
                                            <th>Id Transaccion</th>
                                            <th>Fecha Pago</th>
                                            <th>Total</th>
                                            <th colspan="2">Acciones</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${pago}">
                                            <tr>
                                                <td>
                                                    <c:forEach var="cliente" items="${lista_clientes}">
                                                        <%-- Si el código de cliente del pago es igual al código de cliente en la lista --%>
                                                        <c:if test="${item.codigo_cliente == cliente.codigo_cliente}">
                                                            ${cliente.nombre_cliente}
                                                        </c:if>
                                                    </c:forEach>
                                                </td>
                                                <td>${item.forma_pago}</td>
                                                <td>${item.id_transaccion}</td>
                                                <td>${item.fecha_pago}</td>
                                                <td>${item.total}</td>
                                                <td><a href="PagoServlet?action=delete&id_transaccion=${item.id_transaccion}" class="btn btn-danger btn-eliminar">Eliminar</a></td>
                                                <td><a href="PagoServlet?action=edit&id_transaccion=${item.id_transaccion}" class="btn btn-primary">Editar</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div><!-- /.box -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
</div>



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
