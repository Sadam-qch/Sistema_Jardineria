
<%@page import="com.emergentes.modelo.CategoriaProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CategoriaProducto categoriapro = (CategoriaProducto) request.getAttribute("categoria");
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
                                <center> <h1>
                                    <% if (categoriapro.getCodigoCategoria() == 0) { %>
                                    Nuevo Categoria Producto
                                    <% } else { %>
                                    Editar Categoria Producto
                                    <% }%>
                                </h1></center>
                                <div style="padding: 20px;" class="form-container">
                                </h1>
                                    <form action="CategoriaProductoServ" method="post">
                                        <div class="form-group">
                                            <label for="codigoCategoria">ID:</label>
                                            <input type="number" class="form-control" id="codigoCategoria" name="codigoCategoria" value="<%= categoriapro.getCodigoCategoria()%>" />
                                        </div>
                                        <div class="form-group">
                                            <label for="nombreCategoria">Nombre de la categoría:</label>
                                            <input type="text" class="form-control" id="nombreCategoria" name="nombreCategoria" value="<%= categoriapro.getNombreCategoria()%>" required />
                                        </div>
                                        <div class="form-group">
                                            <label for="descripcionCategoria">Descripción:</label>
                                            <input type="text" class="form-control" id="descripcionCategoria" name="descripcionCategoria" value="<%= categoriapro.getDescripcionCategoria()%>" required />
                                        </div>
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                    </form>
                                </div>
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

