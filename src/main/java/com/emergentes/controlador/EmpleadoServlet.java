package com.emergentes.controlador;

import com.emergentes.DAO.EmpleadoDAO;
import com.emergentes.DAO.EmpleadoDAOimp;
import com.emergentes.DAO.OficinaDAO;
import com.emergentes.DAO.OficinaDAOimp;
import com.emergentes.modelo.Empleado;
import com.emergentes.modelo.Oficina;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado empleado = new Empleado();
        EmpleadoDAO dao = new EmpleadoDAOimp();
        OficinaDAO daoOficina = new OficinaDAOimp();
        int id;

        List<Oficina> lista_oficinas = null;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "view":
                List<Empleado> lista = new ArrayList<Empleado>();

                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("empleado", lista);
                request.getRequestDispatcher("empleado.jsp").forward(request, response);
                break;
            case "add":
                lista_oficinas = new ArrayList<Oficina>();

                try {
                    lista_oficinas = daoOficina.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista_oficinas", lista_oficinas);
                request.setAttribute("empleado", empleado);
                request.getRequestDispatcher("frmempleado.jsp").forward(request, response);
                break;

            case "edit":
                id = Integer.parseInt(request.getParameter("codigo_empleado"));

                try {
                    empleado = dao.getById(id);
                } catch (Exception ex) {
                    Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                try {
                    lista_oficinas = daoOficina.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                
                request.setAttribute("lista_oficinas", lista_oficinas);
                request.setAttribute("empleado", empleado);
                request.getRequestDispatcher("frmempleado.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("codigo_empleado"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("EmpleadoServlet");
                break;
            case "nuevo":
                request.setAttribute("empleado", empleado);
                request.getRequestDispatcher("frmempleado.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigo_empleado"));
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String extension = request.getParameter("extension");
        String email = request.getParameter("email");
        int codigo_oficina = Integer.parseInt(request.getParameter("codigo_oficina"));
        String puesto = request.getParameter("puesto");

        Empleado empleado = new Empleado();

        empleado.setCodigo_empleado(id);
        empleado.setNombre(nombre);
        empleado.setApellido1(apellido1);
        empleado.setApellido2(apellido2);
        empleado.setExtension(extension);
        empleado.setEmail(email);
        empleado.setCodigo_oficina(codigo_oficina);
        empleado.setPuesto(puesto);

        EmpleadoDAO dao = new EmpleadoDAOimp();

        if (id == 0) {
            try {
                dao.insert(empleado);
            } catch (Exception ex) {
                Logger.getLogger(OficinaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                dao.update(empleado);
            } catch (Exception ex) {
                Logger.getLogger(OficinaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect("EmpleadoServlet");
    }

}
