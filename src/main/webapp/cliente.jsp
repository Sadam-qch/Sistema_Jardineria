
<%@page import="com.emergentes.modelo.Empleado"%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Cliente> cliente = (ArrayList<Cliente>) request.getAttribute("cliente");
    ArrayList<Empleado> lista_empleados = (ArrayList<Empleado>) request.getAttribute("lista_empleados");

%>
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
    .table-responsive {
        overflow-x: auto;
        width: 100%;
        margin-bottom: 15px;
    }
    .table-container {
            max-height: 400px; /* Ajusta esta altura según tus necesidades */
            overflow-y: auto; /* Agrega una barra de desplazamiento vertical si es necesario */
        }

    /* Estilos para tu tabla (puedes mantener tus estilos existentes aquí) */
    .table {
        width: 100%;
        max-width: 100%;
        margin-bottom: 20px;
    }
table th:nth-child(13),
    table td:nth-child(13) {
        min-width: 150px; /* Ancho mínimo para la columna */
        max-width: 200px; /* Ancho máximo para la columna */
        word-break: break-all; /* Romper palabras largas */
    }
    /* ... Otros estilos de tabla existentes ... */
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
        <h1>Lista de Clientes</h1>
        <a href="ClienteServlet?action=add" class="btn btn-primary">Nuevo Cliente</a>
        <div class="table-responsive table-container">
            <table class="table table-striped" border="1">
            <tr>
                <th>Codigo Cliente</th>
                <th>Nombre Cliente</th>
                <th>Nombre Contacto</th>
                <th>Apellido Contacto</th>
                <th>Telefono</th>
                <th>Fax</th>
                <th>linea Direccion 1</th>
                <th>linea Direccion 2</th>
                <th>Ciudad</th>
                <th>Region</th>
                <th>Pais</th>
                <th>Codigo Postal</th>
                <th>Codigo Empleado REP VENTAS</th>
                <th>Limite Credito</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${cliente}">
                <tr>
                    <td>${item.codigo_cliente}</td>
                    <td>${item.nombre_cliente}</td>
                    <td>${item.nombre_contacto}</td>
                    <td>${item.apellido_contacto}</td>
                    <td>${item.telefono}</td>
                    <td>${item.fax}</td>
                    <td>${item.linea_direccion1}</td>
                    <td>${item.linea_direccion2}</td>
                    <td>${item.ciudad}</td>
                    <td>${item.region}</td>
                    <td>${item.pais}</td>
                    <td>${item.codigo_postal}</td>
                    <td>
                        <c:forEach var="empleado" items="${lista_empleados}">
                            <%-- Si el código de cliente del pago es igual al código de cliente en la lista --%>
                            <c:if test="${item.codigo_empleado == empleado.codigo_empleado}">
                                ${empleado.nombre}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${item.limite_credito}</td>
                    <td><a href="ClienteServlet?action=edit&codigo_cliente=${item.codigo_cliente}" class="btn btn-danger btn-eliminar">Editar</a></td>

                    <td><a href="ClienteServlet?action=delete&codigo_cliente=${item.codigo_cliente}" onclick="return(confirm('Eliminar??'))" class="btn btn-primary">Eliminar</a></td>
                </tr>
            </c:forEach>


        </table>
        </div>
   </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->

                </section><!-- /.content -->
                </div><!-- /.content-wrapper -->
            </div>
        </div><!-- /.content-wrapper -->

        <div>
            <div class="wrapper">
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