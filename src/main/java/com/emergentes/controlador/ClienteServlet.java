package com.emergentes.controlador;

import com.emergentes.DAO.ClienteDAO;
import com.emergentes.DAO.ClienteDAOimp;
import com.emergentes.DAO.EmpleadoDAO;
import com.emergentes.DAO.EmpleadoDAOimp;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Empleado;
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

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cliente = new Cliente();
        ClienteDAO dao = new ClienteDAOimp();
        EmpleadoDAO daoEmpleado = new EmpleadoDAOimp();

        int id;
        List<Empleado> lista_empleados = null;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "view":
                List<Cliente> lista = new ArrayList<Cliente>();
                lista_empleados = new ArrayList<Empleado>();

                try {
                    lista_empleados = daoEmpleado.getAll();
                    lista = dao.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista_empleados", lista_empleados);
                request.setAttribute("cliente", lista);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                break;
            case "add":
                lista_empleados = new ArrayList<Empleado>();
                try {
                    lista_empleados = daoEmpleado.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista_empleados", lista_empleados);
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                break;

            case "edit":
                id = Integer.parseInt(request.getParameter("codigo_cliente"));

                try {
                    cliente = dao.getById(id);
                } catch (Exception ex) {
                    Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    lista_empleados = daoEmpleado.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("lista_empleados", lista_empleados);
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("codigo_cliente"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("ClienteServlet");
                break;
            case "nuevo":
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigo_cliente"));
        String nombre_cliente = request.getParameter("nombre_cliente");
        String nombre_contacto = request.getParameter("nombre_contacto");
        String apellido_contacto = request.getParameter("apellido_contacto");
        String telefono = request.getParameter("telefono");
        String fax = request.getParameter("fax");
        String linea_direccion1 = request.getParameter("linea_direccion1");
        String linea_direccion2 = request.getParameter("linea_direccion2");
        String ciudad = request.getParameter("ciudad");
        String region = request.getParameter("region");
        String pais = request.getParameter("pais");
        String codigo_postal = request.getParameter("codigo_postal");
        int codigo_empleado = Integer.parseInt(request.getParameter("codigo_empleado"));
        String limite_credito = request.getParameter("limite_credito");

        Cliente cliente = new Cliente();
        cliente.setCodigo_cliente(id);
        cliente.setNombre_cliente(nombre_cliente);
        cliente.setNombre_contacto(nombre_contacto);
        cliente.setApellido_contacto(apellido_contacto);
        cliente.setTelefono(telefono);
        cliente.setFax(fax);
        cliente.setLinea_direccion1(linea_direccion1);
        cliente.setLinea_direccion2(linea_direccion2);
        cliente.setCiudad(ciudad);
        cliente.setRegion(region);
        cliente.setPais(pais);
        cliente.setCodigo_postal(codigo_postal);
        cliente.setCodigo_empleado(codigo_empleado);

        BigDecimal total = null;
        if (limite_credito != null && !limite_credito.isEmpty()) {
            try {
                total = new BigDecimal(limite_credito);
            } catch (NumberFormatException e) {
                Logger.getLogger(PagoServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        cliente.setLimite_credito(total);

        ClienteDAO dao = new ClienteDAOimp();

        if (id == 0) {
            try {
                dao.insert(cliente);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                dao.update(cliente);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect("ClienteServlet");

    }
}
