package com.emergentes.controlador;

import com.emergentes.DAO.CategoriaProductoDAO;
import com.emergentes.DAO.CategoriaProductoDAOimpl;
import com.emergentes.modelo.CategoriaProducto;
import com.emergentes.modelo.Proveedor;
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

@WebServlet(name = "CategoriaProductoServ", urlPatterns = {"/CategoriaProductoServ"})
public class CategoriaProductoServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaProductoDAO dao = new CategoriaProductoDAOimpl();
        int id;
        CategoriaProducto categoriapro = new CategoriaProducto();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        switch (action) {
            case "add":
                request.setAttribute("categoria", categoriapro);
                request.getRequestDispatcher("frmcategoriapro.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    categoriapro = dao.getById(id);
                } catch (Exception ex) {
                    Logger.getLogger(ProveedorServ.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("categoria", categoriapro);
                request.getRequestDispatcher("frmcategoriapro.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(ProveedorServ.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect(request.getContextPath() + "/CategoriaProductoServ");
                break;

            case "view":
                List<CategoriaProducto> categoriapros = new ArrayList<CategoriaProducto>();

                try {
                    categoriapros = dao.getAll();
                } catch (Exception ex) {
                    Logger.getLogger(CategoriaProductoServ.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("categoriapros", categoriapros);
                request.getRequestDispatcher("categoriapro.jsp").forward(request, response);
                break;

            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        int id = Integer.parseInt(request.getParameter("codigoCategoria"));
        String nombreCategoria = request.getParameter("nombreCategoria");
        String descripcionCategoria = request.getParameter("descripcionCategoria");

        CategoriaProducto categoria = new CategoriaProducto();

        categoria.setCodigoCategoria(id);
        categoria.setNombreCategoria(nombreCategoria);
        categoria.setDescripcionCategoria(descripcionCategoria);
        
        if (categoria.getCodigoCategoria() == 0) {
            try {
                CategoriaProductoDAO dao = new CategoriaProductoDAOimpl();
                dao.insert(categoria);
                // Redirige a la vista de proveedores después de la inserción
                response.sendRedirect(request.getContextPath() + "/CategoriaProductoServ?action=view");
            } catch (Exception ex) {
                System.out.println("Error: "+ ex.getMessage());
            }
        } else{
            try {
                CategoriaProductoDAO dao = new CategoriaProductoDAOimpl();
                dao.update(categoria);
                // Redirige a la vista de proveedores después de la actualización
                response.sendRedirect(request.getContextPath() + "/CategoriaProductoServ?action=view");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }

    }

}
