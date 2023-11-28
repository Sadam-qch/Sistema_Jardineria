package com.emergentes.controlador;

import com.emergentes.DAO.CategoriaProductoDAO;
import com.emergentes.DAO.CategoriaProductoDAOimpl;
import com.emergentes.DAO.DetallePedidoDAO;
import com.emergentes.DAO.DetallePedidoDAOimpl;
import com.emergentes.DAO.PedidoDAO;
import com.emergentes.DAO.PedidoDAOimpl;
import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimpl;
import com.emergentes.DAO.ProveedorDAO;
import com.emergentes.DAO.ProveedorDAOimpl;
import com.emergentes.modelo.CategoriaProducto;
import com.emergentes.modelo.DetallePedido;
import com.emergentes.modelo.Pedido;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DetallePedidoServ", urlPatterns = {"/DetallePedidoServ"})
public class DetallePedidoServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductoDAO daoProducto = new ProductoDAOimpl();
        PedidoDAO daoPedido = new PedidoDAOimpl();
        ProveedorDAO daoProveedor = new ProveedorDAOimpl();
        DetallePedidoDAO daoDetallePedido = new DetallePedidoDAOimpl();

        int id;
        DetallePedido detallePedido = new DetallePedido();
        List<Pedido> pedido = new ArrayList<Pedido>();
        List<Proveedor> proveedor = new ArrayList<Proveedor>();
        List<Producto> producto = new ArrayList<Producto>();

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        switch (action) {
            case "add":
            try {
                pedido = daoPedido.getAll();
            } catch (Exception ex) {
                Logger.getLogger(DetallePedidoServ.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                proveedor = daoProveedor.getAll();
            } catch (Exception ex) {
                Logger.getLogger(DetallePedidoServ.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                producto = daoProducto.getAll();
            } catch (Exception ex) {
                Logger.getLogger(DetallePedidoServ.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("pedido", pedido);
            request.setAttribute("proveedor", proveedor);
            request.setAttribute("producto", producto);
            request.setAttribute("detallePedido", detallePedido);
            
            request.getRequestDispatcher("frmdetallepedido.jsp").forward(request, response);
            break;

            case "edit":
                id = Integer.parseInt(request.getParameter("codigoPedidos"));

                try {
                    detallePedido = daoDetallePedido.getById(id);
                    producto = daoProducto.getAll(); // Replace with the actual method to get categories
                    proveedor = daoProveedor.getAll(); // Replace with the actual method to get categories
                    pedido = daoPedido.getAll(); // Replace with the actual method to get categories
                    request.setAttribute("pedido", pedido);
                    request.setAttribute("proveedor", proveedor);
                    request.setAttribute("producto", producto);
                } catch (Exception ex) {
                    Logger.getLogger(DetallePedidoServ.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("detallePedido", detallePedido);
                request.getRequestDispatcher("frmdetallepedido.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("codigoPedidos"));

                try {
                    daoDetallePedido.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(DetallePedidoServ.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect(request.getContextPath() + "/DetallePedidoServ?action=view");
                break;
            case "view":
                List<DetallePedido> lista = new ArrayList<DetallePedido>();
                try {
                    lista = daoDetallePedido.getAll();
                    request.setAttribute("detallesPedido", lista);
                } catch (Exception ex) {
                    Logger.getLogger(DetallePedidoServ.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("detallespedidos.jsp").forward(request, response);
                break;

            default:
                break;
        }
    }
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // Obtener parámetros de la solicitud
    int id = parseParameterToInt(request.getParameter("codigoPedidos"));
    int codigoProducto = parseParameterToInt(request.getParameter("codigoProducto"));
    int cantidad = parseParameterToInt(request.getParameter("cantidad"));
    BigDecimal precioUnidad = parseParameterToBigDecimal(request.getParameter("precioUnidad"));
    int numeroLinea = parseParameterToInt(request.getParameter("numeroLinea"));
    int codigoPedidos = parseParameterToInt(request.getParameter("codigoPedidos"));
    int codigoProveedor = parseParameterToInt(request.getParameter("codigoProveedor"));

    DetallePedido detallePedido = new DetallePedido();

    // Configurar objeto DetallePedido
    detallePedido.setCodigoPedido(id);

    Producto producto = new Producto();
    producto.setCodigoProducto(codigoProducto);
    detallePedido.setCodigoProducto(producto);

    detallePedido.setCantidad(cantidad);
    detallePedido.setPrecioUnidad(precioUnidad);
    detallePedido.setNumeroLinea(numeroLinea);

    Pedido pedido = new Pedido();
    pedido.setCodigoPedido(codigoPedidos);
    detallePedido.setCodigoPedidos(pedido);

    Proveedor proveedor = new Proveedor();
    proveedor.setCodigoProveedor(codigoProveedor);
    detallePedido.setCodigoProveedor(proveedor);

    DetallePedidoDAO dao = new DetallePedidoDAOimpl();
    try {
        if (detallePedido.getCodigoPedido() == 0) {
            dao.insert(detallePedido);
        } else {
            dao.update(detallePedido);
        }
    } catch (Exception ex) {
        Logger.getLogger(DetallePedidoServ.class.getName()).log(Level.SEVERE, null, ex);
    }

    response.sendRedirect(request.getContextPath() + "/DetallePedidoServ");
}

// Método para convertir parámetros String a int de manera segura
private int parseParameterToInt(String param) {
    int result = 0;
    if (param != null && !param.isEmpty()) {
        try {
            result = Integer.parseInt(param);
        } catch (NumberFormatException ex) {
            // Manejar la excepción si la conversión falla
            Logger.getLogger(DetallePedidoServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return result;
}

// Método para convertir parámetros String a BigDecimal de manera segura
private BigDecimal parseParameterToBigDecimal(String param) {
    BigDecimal result = BigDecimal.ZERO;
    if (param != null && !param.isEmpty()) {
        try {
            result = new BigDecimal(param);
        } catch (NumberFormatException ex) {
            // Manejar la excepción si la conversión falla
            Logger.getLogger(DetallePedidoServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return result;
}

}
