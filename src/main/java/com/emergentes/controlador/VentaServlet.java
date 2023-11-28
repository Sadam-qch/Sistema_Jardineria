package com.emergentes.controlador;

import com.emergentes.DAO.ClienteDAO;
import com.emergentes.DAO.ClienteDAOimp;
import com.emergentes.DAO.EmpleadoDAO;
import com.emergentes.DAO.EmpleadoDAOimp;
import com.emergentes.DAO.VentaDAO;
import com.emergentes.DAO.VentaDAOimp;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Empleado;
import com.emergentes.modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "VentaServlet", urlPatterns = {"/VentaServlet"})
public class VentaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venta venta = new Venta();
        VentaDAO dao = new VentaDAOimp();
        ClienteDAO daoCliente = new ClienteDAOimp();
        EmpleadoDAO daoEmpleado = new EmpleadoDAOimp();

        int id;
        List<Cliente> lista_clientes = null;
        List<Empleado> lista_empleados = null;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "view":
                List<Venta> lista = new ArrayList<Venta>();
                lista_clientes = new ArrayList<Cliente>();
                lista_empleados = new ArrayList<Empleado>();
                try {
                    lista = dao.getAll();
                    lista_clientes = daoCliente.getAll();
                    lista_empleados = daoEmpleado.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista_empleados", lista_empleados);
                request.setAttribute("lista_clientes", lista_clientes);
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("venta.jsp").forward(request, response);
                break;
            case "add":
                lista_clientes = new ArrayList<Cliente>();
                lista_empleados = new ArrayList<>();

                try {
                    lista_clientes = daoCliente.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    lista_empleados = daoEmpleado.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista_empleados", lista_empleados);
                request.setAttribute("lista_clientes", lista_clientes);
                request.setAttribute("venta", venta);
                request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                break;

            case "edit":
                id = Integer.parseInt(request.getParameter("codigo_venta"));

                try {
                    venta = dao.getById(id);
                } catch (Exception ex) {
                    Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                try {
                    lista_clientes =daoCliente.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                try {
                    lista_empleados =daoEmpleado.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                request.setAttribute("lista_empleados", lista_empleados);
                request.setAttribute("lista_clientes", lista_clientes);
                request.setAttribute("venta", venta);
                request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("codigo_venta"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect("VentaServlet");
                break;
            case "nuevo":
                request.setAttribute("venta", venta);
                request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigo_venta"));
        String fecha_venta = request.getParameter("fecha_venta");
        int codigo_cliente = Integer.parseInt(request.getParameter("codigo_cliente"));
        int codigo_empleado = Integer.parseInt(request.getParameter("codigo_empleado"));
        int codigo_producto = Integer.parseInt(request.getParameter("codigo_producto"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String precio_unitario = request.getParameter("precio_unitario");
        String total_venta = request.getParameter("total_venta");

        Venta venta = new Venta();

        venta.setCodigo_venta(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaPag = null;

        if (fecha_venta != null && !fecha_venta.isEmpty()) {
            try {
                fechaPag = dateFormat.parse(fecha_venta);
            } catch (ParseException e) {
                Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, e);
                // Manejar errores si la conversión falla
            }
        }

        java.sql.Date fechaPagoSQL = null;
        if (fechaPag != null) {
            fechaPagoSQL = new java.sql.Date(fechaPag.getTime());
        }
        venta.setFecha_venta(fechaPagoSQL);
        venta.setCodigo_cliente(codigo_cliente);
        venta.setCodigo_empleado(codigo_empleado);
        venta.setCodigo_producto(codigo_producto);
        venta.setCantidad(cantidad);
        BigDecimal precio_uni = null;
        if (precio_unitario != null && !precio_unitario.isEmpty()) {
            try {
                precio_uni = new BigDecimal(precio_unitario);
            } catch (NumberFormatException e) {
                Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, e);
                // Manejar errores si la conversión falla
            }
        }
        venta.setPrecio_unitario(precio_uni);

        BigDecimal total_ven = null;
        if (total_venta != null && !total_venta.isEmpty()) {
            try {
                total_ven = new BigDecimal(total_venta);
            } catch (NumberFormatException e) {
                Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, e);
                // Manejar errores si la conversión falla
            }
        }
        venta.setTotal_venta(total_ven);
        VentaDAO dao = new VentaDAOimp();
        if (id == 0) {
            try {
                dao.insert(venta);
            } catch (Exception ex) {
                Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                dao.update(venta);
            } catch (Exception ex) {
                Logger.getLogger(VentaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("VentaServlet");
    }

}
