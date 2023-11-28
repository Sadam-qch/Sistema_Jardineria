<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.emergentes.modelo.Pago"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
    Pago pago = (Pago) request.getAttribute("pago");
    ArrayList<Cliente> lista_clientes = (ArrayList<Cliente>) request.getAttribute("lista_clientes");
    //List<Cliente> cliente = (List<Cliente>) request.getAttribute("cliente");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fechaPagoFormatted = ""; // Inicializar la variable para almacenar la fecha formateada
    if (pago != null && pago.getFecha_pago() != null) {
        fechaPagoFormatted = dateFormat.format(pago.getFecha_pago()); // Formatear la fecha si existe en el objeto pago
    }
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

            .form-group {
                margin-bottom: 20px;
            }

            label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            input[type="text"],
            input[type="date"],
            select {
                width: 100%;
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
                                <center><h1>Formulario Pago</h1></center>
                                <div style="padding: 20px;" class="form-container">
                                    <form action="PagoServlet" method="post">
                                        <input type="hidden" name="id_transaccion" value="${pago.id_transaccion}">

                                        <div class="form-group">
                                            <label for="formaPago">Forma de Pago</label>
                                            <input type="text" class="form-control" id="formaPago" name="forma_pago" value="${pago.forma_pago}">
                                        </div>

                                        <div class="form-group">
                                            <label for="codigoCliente">Código de Cliente</label>
                                            <select class="form-control" id="codigoCliente" name="codigo_cliente">
                                                <option value="">--Seleccione--</option>
                                                <c:forEach items="${lista_clientes}" var="item">
                                                    <option value="${item.codigo_cliente}" 
                                                            <c:if test="${item.codigo_cliente == pago.codigo_cliente}">
                                                                selected
                                                            </c:if>
                                                            >
                                                        ${item.nombre_cliente} 
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label for="fechaPago">Fecha de Pago</label>
                                            <input type="date" class="form-control" id="fechaPago" name="fecha_pago" value="${pago.fecha_pago}">
                                        </div>

                                        <div class="form-group">
                                            <label for="total">Total</label>
                                            <input type="text" class="form-control" id="total" name="total" value="${pago.total}">
                                        </div>

                                        <button type="submit" class="btn btn-primary">Enviar</button>
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

