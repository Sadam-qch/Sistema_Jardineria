package com.emergentes.controlador;

import com.emergentes.DAO.OficinaDAO;
import com.emergentes.DAO.OficinaDAOimp;
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

@WebServlet(name = "OficinaServlet", urlPatterns = {"/OficinaServlet"})
public class OficinaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Oficina oficina = new Oficina();
        OficinaDAO dao = new OficinaDAOimp();
        int id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "view":
                List<Oficina> lista = new ArrayList<Oficina>();

                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(OficinaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("oficina", lista);
                request.getRequestDispatcher("oficina.jsp").forward(request, response);
                break;
            
            case "add":
                request.setAttribute("oficina", oficina);
                request.getRequestDispatcher("frmoficina.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("codigo_oficina"));

                try {
                    oficina = dao.getById(id);
                } catch (Exception ex) {
                    Logger.getLogger(OficinaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("oficina", oficina);
                request.getRequestDispatcher("frmoficina.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("codigo_oficina"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(OficinaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect("OficinaServlet");
                break;
            case "nuevo":
                request.setAttribute("oficina", oficina);
                request.getRequestDispatcher("frmoficina.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigo_oficina"));
        String ciudad = request.getParameter("ciudad");
        String pais = request.getParameter("pais");
        String region = request.getParameter("region");
        String codigo_postal = request.getParameter("codigo_postal");
        String telefono = request.getParameter("telefono");
        String direccion1 = request.getParameter("linea_direccion1");
        String direccion2 = request.getParameter("linea_direccion2");

        Oficina of = new Oficina();

        of.setCodigo_oficina(id);
        of.setCiudad(ciudad);
        of.setPais(pais);
        of.setRegion(region);
        of.setCodigo_postal(codigo_postal);
        of.setTelefono(telefono);
        of.setLinea_direccion1(direccion1);
        of.setLinea_direccion2(direccion2);

        OficinaDAO dao = new OficinaDAOimp();

        if (id == 0) {
            try {
                dao.insert(of);
            } catch (Exception ex) {
                Logger.getLogger(OficinaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                dao.update(of);
            } catch (Exception ex) {
                Logger.getLogger(OficinaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect("OficinaServlet");
    }

}
