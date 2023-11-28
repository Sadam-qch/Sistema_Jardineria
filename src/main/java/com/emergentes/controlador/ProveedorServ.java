
package com.emergentes.controlador;

import com.emergentes.DAO.ProveedorDAO;
import com.emergentes.DAO.ProveedorDAOimpl;
import com.emergentes.modelo.Proveedor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sadam
 */
@WebServlet(name = "ProveedorServ", urlPatterns = {"/ProveedorServ"})
public class ProveedorServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //AvisoController? action=add
            ProveedorDAO dao = new ProveedorDAOimpl();
            int id;
            Proveedor proveedor = new Proveedor();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("proveedor", proveedor);
                    request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                
                    try {
                        proveedor = dao.getById(id);
                    } catch (Exception ex) {
                        Logger.getLogger(ProveedorServ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    System.out.println(proveedor);
                    request.setAttribute("proveedor", proveedor);
                    request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                    break;


                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                
                    try {
                        dao.delete(id);
                    } catch (Exception ex) {
                        Logger.getLogger(ProveedorServ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    response.sendRedirect(request.getContextPath() + "/ProveedorServ");
                    break;


                case "view":
                    List<Proveedor> lista = new ArrayList<Proveedor>();
               
                    try {
                        lista = dao.getAll();
                    } catch (Exception ex) {
                        Logger.getLogger(ProveedorServ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("proveedores", lista);
                    request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                    
                    break;
                default:
                    break;
            }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigoProveedor"));
        String nombreProveedor = request.getParameter("nombreProveedor");
        String contacto = request.getParameter("contacto");
        String telefono = request.getParameter("telefono");

        Proveedor prove = new Proveedor();

        prove.setCodigoProveedor(id);
        prove.setNombreProveedor(nombreProveedor);
        prove.setContacto(contacto);
        prove.setTelefono(telefono);

        if (id == 0) {
            try {
                ProveedorDAO dao = new ProveedorDAOimpl();
                dao.insert(prove);
                // Redirige a la vista de proveedores después de la inserción
                response.sendRedirect(request.getContextPath() + "/ProveedorServ?action=view");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            try {
                ProveedorDAO dao = new ProveedorDAOimpl();
                dao.update(prove);
                // Redirige a la vista de proveedores después de la actualización
                response.sendRedirect(request.getContextPath() + "/ProveedorServ?action=view");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }

    }

}
