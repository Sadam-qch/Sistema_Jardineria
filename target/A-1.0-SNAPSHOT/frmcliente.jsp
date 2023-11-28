<%@page import="com.emergentes.modelo.Cliente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            /* Estilos para el formulario */
            .form-container {
                max-width: 800px;
                margin: 0 auto;
                padding: 20px;
                background-color: #f9f9f9;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .form-columns {
                display: flex;
                justify-content: space-between;
                flex-wrap: wrap;
            }

            .form-group {
                width: calc(50% - 10px);
                margin-bottom: 15px;
            }

            label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            input[type="text"],
            select {
                width: calc(100% - 20px);
                padding: 8px;
                border-radius: 3px;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            input[type="submit"] {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
                font-size: 16px;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }

            @media (max-width: 768px) {
                .form-group {
                    width: 100%;
                }
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
                                <center><h1>Formulario Cliente</h1></center>
                                <div class="form-container">
                                    <form action="ClienteServlet" method="post" class="form-columns">
                                        <div class="form-group">
                                            <input type="hidden" class="form-control" id="nombreCliente" name="codigo_cliente" value="${cliente.codigo_cliente}">

                                            <label for="nombreCliente">Nombre Cliente:</label>
                                            <input type="text" class="form-control" id="nombreCliente" name="nombre_cliente" value="${cliente.nombre_cliente}">

                                            <label for="nombreContacto">Nombre Contacto:</label>
                                            <input type="text" class="form-control" id="nombreContacto" name="nombre_contacto" value="${cliente.nombre_contacto}">

                                            <label for="apellidoContacto">Apellido Contacto:</label>
                                            <input type="text" class="form-control" id="apellidoContacto" name="apellido_contacto" value="${cliente.apellido_contacto}">

                                            <label for="telefono">Teléfono:</label>
                                            <input type="text" class="form-control" id="telefono" name="telefono" value="${cliente.telefono}">

                                            <label for="lineaDireccion1">Línea Dirección 1:</label>
                                            <input type="text" class="form-control" id="lineaDireccion1" name="linea_direccion1" value="${cliente.linea_direccion1}">

                                            <label for="ciudad">Ciudad:</label>
                                            <input type="text" class="form-control" id="ciudad" name="ciudad" value="${cliente.ciudad}">

                                            <label for="pais">País:</label>
                                            <input type="text" class="form-control" id="pais" name="pais" value="${cliente.pais}">
                                        </div>

                                        <div class="form-group">
                                            <label for="codigoEmpleado">Código Empleado:</label>
                                            <select name="codigo_empleado">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${lista_empleados}" var="item">
                                                    <option value="${item.codigo_empleado}" 
                                                            <c:if test="${item.codigo_empleado == cliente.codigo_empleado}">
                                                                selected
                                                            </c:if>>
                                                        ${item.nombre} 
                                                    </option>
                                                </c:forEach>
                                            </select><br>

                                            <label for="limiteCredito">Límite Crédito:</label>
                                            <input type="text" class="form-control" id="limiteCredito" name="limite_credito" value="${cliente.limite_credito}">

                                            <label for="fax">Fax:</label>
                                            <input type="text" class="form-control" id="fax" name="fax" value="${cliente.fax}">

                                            <label for="lineaDireccion2">Línea Dirección 2:</label>
                                            <input type="text" class="form-control" id="lineaDireccion2" name="linea_direccion2" value="${cliente.linea_direccion2}">

                                            <label for="region">Región:</label>
                                            <input type="text" class="form-control" id="region" name="region" value="${cliente.region}">

                                            <label for="codigoPostal">Código Postal:</label>
                                            <input type="text" class="form-control" id="codigoPostal" name="codigo_postal" value="${cliente.codigo_postal}">

                                            <button type="submit" class="btn btn-primary">Enviar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
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
