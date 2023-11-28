<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.emergentes.modelo.Venta"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    Venta venta = (Venta) request.getAttribute("venta");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fechaPagoFormatted = ""; // Inicializar la variable para almacenar la fecha formateada
    if (venta != null && venta.getFecha_venta() != null) {
        fechaPagoFormatted = dateFormat.format(venta.getFecha_venta()); // Formatear la fecha si existe en el objeto pago
    }
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
        <link rel="shortcut icon" href="img/favicon.ico"><style>
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
            input[type="date"],
            select {
                width: calc(100% - 20px);
                padding: 8px;
                border-radius: 3px;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            button {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
                font-size: 16px;
            }

            button:hover {
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
                                <center><h1>Formulario Venta</h1></center>
                                <div class="form-container">
                                    <form action="VentaServlet" method="post" class="form-columns">
                                        <div class="form-group">
                                            <label for="codigoVenta">Código de Venta:</label>
                                            <input type="text" class="form-control" id="codigoVenta" name="codigo_venta" value="${venta.codigo_venta}">

                                            <label for="fechaVenta">Fecha de Venta:</label>
                                            <input type="date" class="form-control" id="fechaVenta" name="fecha_venta" value="${venta.fecha_venta}">

                                            <label for="codigoCliente">Código de Cliente:</label>
                                            <select class="form-control" id="codigoCliente" name="codigo_cliente">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${lista_clientes}" var="item">
                                                    <option value="${item.codigo_cliente}" 
                                                            <c:if test="${item.codigo_cliente == venta.codigo_cliente}">
                                                                selected
                                                            </c:if>
                                                            >
                                                        ${item.nombre_cliente} 
                                                    </option>
                                                </c:forEach>
                                            </select>

                                            <label for="codigoEmpleado">Código de Empleado:</label>
                                            <select class="form-control" id="codigoEmpleado" name="codigo_empleado">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${lista_empleados}" var="item">
                                                    <option value="${item.codigo_empleado}" 
                                                            <c:if test="${item.codigo_empleado == venta.codigo_empleado}">
                                                                selected
                                                            </c:if>
                                                            >
                                                        ${item.nombre} 
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="codigoProducto">Código de Producto:</label>
                                            <input type="text" class="form-control" id="codigoProducto" name="codigo_producto" value="${venta.codigo_producto}">

                                            <label for="cantidad">Cantidad:</label>
                                            <input type="text" class="form-control" id="cantidad" name="cantidad" value="${venta.cantidad}">

                                            <label for="precioUnitario">Precio Unitario:</label>
                                            <input type="text" class="form-control" id="precioUnitario" name="precio_unitario" value="${venta.precio_unitario}">

                                            <label for="totalVenta">Total de Venta:</label>
                                            <input type="text" class="form-control" id="totalVenta" name="total_venta" value="${venta.total_venta}">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </form>
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
