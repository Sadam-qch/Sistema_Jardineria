<%@page import="com.emergentes.modelo.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Pedido pedido = (Pedido) request.getAttribute("pedido");
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
        input[type="number"],
        input[type="date"] {
            width: 100%;
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
                            <center> <h1>
                                <% if (pedido.getCodigoPedido() == 0) { %>
                                    Nuevo Pedido
                                <% } else { %>
                                    Editar Pedido
                                <% } %>
                            </h1></center>
                            <div style="padding: 20px;" class="form-container">
                                <form action="PedidoServ" method="post">
                                    <table>
                                        <tr>
                                            <td>Código del Pedido:</td>
                                            <td><input type="number" name="codigoPedido" value="<%= pedido.getCodigoPedido() %>" /></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha del Pedido:</td>
                                            <td><input type="date" name="fechaPedido" value="<%= pedido.getFechaPedido() != null ? pedido.getFechaPedido() : "" %>" required /></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha Esperada:</td>
                                            <td><input type="date" name="fechaEsperada" value="<%= pedido.getFechaEsperada() != null ? pedido.getFechaEsperada() : "" %>" /></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha de Entrega:</td>
                                            <td><input type="date" name="fechaEntrega" value="<%= pedido.getFechaEntrega() != null ? pedido.getFechaEntrega() : "" %>" required /></td>
                                        </tr>
                                        <tr>
                                            <td>Estado:</td>
                                            <td><input type="text" name="estado" value="<%= pedido.getEstado() %>" required /></td>
                                        </tr>
                                        <tr>
                                            <td>Comentarios:</td>
                                            <td><input type="text" name="comentarios" value="<%= pedido.getComentarios() %>" required /></td>
                                        </tr>
                                        <tr>
                                            <td>Código del Cliente:</td>
                                            <td><input type="number" name="codigoCliente" value="<%= pedido.getCodigoCliente() != null ? pedido.getCodigoCliente().getCodigo_cliente() : 0 %>" required /></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td><input type="submit" value="Guardar" /></td>
                                        </tr>
                                    </table>
                                </form>
                            </div><!-- /.box-body -->
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
        <strong>Copyright &copy;2023 <b><p>Carlos Mamani Corina--Albert Alexander Cordero Rivera--Sadam Quispe Chino</p></b></strong>
        All rights reserved.
    </footer>

    <script src="js/jQuery-2.1.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/app.min.js"></script>
</body>
</html>
