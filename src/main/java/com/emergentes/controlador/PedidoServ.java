package com.emergentes.controlador;

import com.emergentes.DAO.ClienteDAO;
import com.emergentes.DAO.ClienteDAOimp;
import com.emergentes.DAO.PedidoDAO;
import com.emergentes.DAO.PedidoDAOimpl;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Pedido;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PedidoServ", urlPatterns = {"/PedidoServ"})
public class PedidoServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PedidoDAO dao = new PedidoDAOimpl();
        ClienteDAO daocli = new ClienteDAOimp();
        int id;
        Pedido pedido = new Pedido();
        List<Cliente> clientes = new ArrayList<Cliente>(); // Supongo que tendrás un DAO de Cliente también

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        switch (action) {
            case "add":
                try {
                    clientes = daocli.getAll();// Llama al método correspondiente de tu DAO de Cliente para obtener la lista de clientes
                            // por ejemplo: ClienteDAOimpl().getAll();
                } catch (Exception ex) {
                    Logger.getLogger(PedidoServ.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("clientes", clientes);
                request.setAttribute("pedido", pedido);
                request.getRequestDispatcher("frmpedido.jsp").forward(request, response);
                break;

            case "edit":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    pedido = dao.getById(id);
                    clientes = daocli.getAll();// Llama al método correspondiente de tu DAO de Cliente para obtener la lista de clientes
                            // por ejemplo: ClienteDAOimpl().getAll();
                    request.setAttribute("clientes", clientes);
                } catch (Exception ex) {
                    Logger.getLogger(PedidoServ.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("pedido", pedido);
                request.getRequestDispatcher("frmpedido.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(PedidoServ.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect(request.getContextPath() + "/PedidoServ");
                break;

            case "view":
                List<Pedido> pedidos = new ArrayList<Pedido>();
                try {
                    pedidos = dao.getAll();
                    request.setAttribute("pedidos", pedidos);
                } catch (Exception ex) {
                    Logger.getLogger(PedidoServ.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.getRequestDispatcher("pedidos.jsp").forward(request, response);
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigoPedido"));
        String fechaPedidoStr = request.getParameter("fechaPedido");
        String fechaEsperadaStr = request.getParameter("fechaEsperada");
        String fechaEntregaStr = request.getParameter("fechaEntrega");
        String estado = request.getParameter("estado");
        String comentarios = request.getParameter("comentarios");
        int codigoCliente = Integer.parseInt(request.getParameter("codigoCliente"));

        Pedido pedido = new Pedido();
        pedido.setCodigoPedido(id);
        pedido.setEstado(estado);
        pedido.setComentarios(comentarios);

        // Convertir las cadenas de fecha a objetos Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (fechaPedidoStr != null && !fechaPedidoStr.isEmpty()) {
                Date fechaPedido = dateFormat.parse(fechaPedidoStr);
                pedido.setFechaPedido(fechaPedido);
            }

            if (fechaEsperadaStr != null && !fechaEsperadaStr.isEmpty()) {
                Date fechaEsperada = dateFormat.parse(fechaEsperadaStr);
                pedido.setFechaEsperada(fechaEsperada);
            }

            if (fechaEntregaStr != null && !fechaEntregaStr.isEmpty()) {
                Date fechaEntrega = dateFormat.parse(fechaEntregaStr);
                pedido.setFechaEntrega(fechaEntrega);
            }
        } catch (ParseException e) {
            Logger.getLogger(PedidoServ.class.getName()).log(Level.SEVERE, null, e);
        }

        Cliente cliente = new Cliente();
        cliente.setCodigo_cliente(codigoCliente);
        pedido.setCodigoCliente(cliente);

        PedidoDAO dao = new PedidoDAOimpl();

        if (id == 0) {
            try {
                dao.insert(pedido);
                // Redirige a la vista de pedidos después de la inserción
                response.sendRedirect(request.getContextPath() + "/PedidoServ");
            } catch (Exception ex) {
                Logger.getLogger(PedidoServ.class.getName()).log(Level.SEVERE, null, ex);
                // Maneja el error, por ejemplo, redirige a una página de error
                
            }
        } else {
            try {
                dao.update(pedido);
                // Redirige a la vista de pedidos después de la actualización
                response.sendRedirect(request.getContextPath() + "/PedidoServ");
            } catch (Exception ex) {
                Logger.getLogger(PedidoServ.class.getName()).log(Level.SEVERE, null, ex);
                // Maneja el error, por ejemplo, redirige a una página de error
                
            }
        }
    }
}
