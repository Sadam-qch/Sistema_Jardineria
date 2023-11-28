<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Oficina"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Empleado"%>
<%
    Empleado empleado = (Empleado) request.getAttribute("empleado");
    List<Oficina> lista_oficinas = (List<Oficina>) request.getAttribute("lista_oficinas");
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
                                <center><h1>Formulario Empleado</h1></center>
                                <div class="form-container">
                                    <form action="EmpleadoServlet" method="post" class="form-columns">
                                        <div class="form-group">
                                            <input type="hidden" name="codigo_empleado" value="${empleado.codigo_empleado}">

                                            <label for="nombre">Nombre:</label>
                                            <input type="text" name="nombre" value="${empleado.nombre}">

                                            <label for="apellido1">Apellido 1:</label>
                                            <input type="text" name="apellido1" value="${empleado.apellido1}">

                                            <label for="apellido2">Apellido 2:</label>
                                            <input type="text" name="apellido2" value="${empleado.apellido2}">

                                            <label for="extension">Extensión:</label>
                                            <input type="text" name="extension" value="${empleado.extension}">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email:</label>
                                            <input type="text" name="email" value="${empleado.email}">

                                            <label for="codigo_oficina">Código de Oficina:</label>
                                            <select name="codigo_oficina">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${lista_oficinas}" var="item">
                                                    <option value="${item.codigo_oficina}" 
                                                            <c:if test="${item.codigo_oficina == empleado.codigo_oficina}">
                                                                selected
                                                            </c:if>
                                                            >
                                                        ${item.codigo_oficina} 
                                                    </option>
                                                </c:forEach>
                                            </select>

                                            <label for="puesto">Puesto:</label>
                                            <input type="text" name="puesto" value="${empleado.puesto}">

                                            <input type="submit" value="Enviar">
                                        </div>
                                    </form>
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

