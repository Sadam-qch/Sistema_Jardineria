package com.emergentes.controlador;

import com.emergentes.DAO.ClienteDAO;
import com.emergentes.DAO.ClienteDAOimp;
import com.emergentes.DAO.PagoDAO;
import com.emergentes.DAO.PagoDAOimp;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Pago;
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

@WebServlet(name = "PagoServlet", urlPatterns = {"/PagoServlet"})
public class PagoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pago pago = new Pago();
        PagoDAO dao = new PagoDAOimp();
        ClienteDAO daoCliente = new ClienteDAOimp();

        int id;
        List<Cliente> lista_clientes = null;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "view":
                List<Pago> lista = new ArrayList<Pago>();
                lista_clientes = new ArrayList<Cliente>();
                try {
                    lista_clientes = daoCliente.getAll();
                    lista = dao.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);

                }
                request.setAttribute("lista_clientes", lista_clientes);
                request.setAttribute("pago", lista);
                request.getRequestDispatcher("pago.jsp").forward(request, response);
                break;
            case "add":

                try {
                    lista_clientes = daoCliente.getAll();
                } catch (Exception ex) {
                    
                    Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista_clientes", lista_clientes);
                request.setAttribute("pago", pago);
                request.getRequestDispatcher("frmpago.jsp").forward(request, response);
                break;

            case "edit":

                id = Integer.parseInt(request.getParameter("id_transaccion"));
                try {
                    pago = dao.getById(id);
                } catch (Exception ex) {
                    Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    lista_clientes = daoCliente.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista_clientes", lista_clientes);
                request.setAttribute("pago", pago);
                request.getRequestDispatcher("frmpago.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id_transaccion"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect("PagoServlet");
                break;
            case "nuevo":
                request.setAttribute("pago", pago);
                request.getRequestDispatcher("frmpago.jsp").forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_transaccion = Integer.parseInt(request.getParameter("id_transaccion"));
        int id = Integer.parseInt(request.getParameter("codigo_cliente"));
        String formaPago = request.getParameter("forma_pago");
        String fechaPago = request.getParameter("fecha_pago");
        String totalStr = request.getParameter("total");

        Pago pago = new Pago();

        pago.setCodigo_cliente(id);
        pago.setForma_pago(formaPago);
        pago.setId_transaccion(id_transaccion);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaPag = null;

        if (fechaPago != null && !fechaPago.isEmpty()) {
            try {
                fechaPag = dateFormat.parse(fechaPago);
            } catch (ParseException e) {
                Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, e);
                // Manejar errores si la conversión falla
            }
        }

        java.sql.Date fechaPagoSQL = null;
        if (fechaPag != null) {
            fechaPagoSQL = new java.sql.Date(fechaPag.getTime());
        }
        pago.setFecha_pago(fechaPagoSQL);

        BigDecimal total = null;
        if (totalStr != null && !totalStr.isEmpty()) {
            try {
                total = new BigDecimal(totalStr);
            } catch (NumberFormatException e) {
                Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, e);
                // Manejar errores si la conversión falla
            }
        }
        pago.setTotal(total);

        PagoDAO dao = new PagoDAOimp();

        try {
            if (id_transaccion == 0) {
                dao.insert(pago);
            } else {
                dao.update(pago);
            }
        } catch (Exception ex) {
            Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("PagoServlet");
    }

}
