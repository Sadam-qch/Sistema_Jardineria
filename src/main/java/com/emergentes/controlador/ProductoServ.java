package com.emergentes.controlador;

import com.emergentes.DAO.CategoriaProductoDAO;
import com.emergentes.DAO.CategoriaProductoDAOimpl;
import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimpl;
import com.emergentes.modelo.CategoriaProducto;
import com.emergentes.modelo.Producto;
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

/**
 *
 * @author Sadam
 */
@WebServlet(name = "ProductoServ", urlPatterns = {"/ProductoServ"})
public class ProductoServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaProductoDAO daoct = new CategoriaProductoDAOimpl();
        ProductoDAO dao = new ProductoDAOimpl();
        int id;
        Producto producto = new Producto();
        List<CategoriaProducto> categorias = new ArrayList<CategoriaProducto>(); // Assuming you have a method in your DAO to get all categories

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        switch (action) {
            case "add": {
                try {
                    categorias = daoct.getAll(); // Replace with the actual method to get categories
                } catch (Exception ex) {
                    Logger.getLogger(ProductoServ.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.setAttribute("categorias", categorias);
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
            break;

            case "edit":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    producto = dao.getById(id);
                    categorias = daoct.getAll(); // Replace with the actual method to get categories
                    request.setAttribute("categorias", categorias);
                } catch (Exception ex) {
                    Logger.getLogger(ProductoServ.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("producto", producto);
                request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));

                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    Logger.getLogger(ProductoServ.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect(request.getContextPath() + "/ProductoServ");
                break;

            case "view":

                List<Producto> lista = new ArrayList<Producto>();
                try {
                    lista = dao.getAll();
                    request.setAttribute("productos", lista);
                } catch (Exception ex) {
                    Logger.getLogger(ProductoServ.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("productos.jsp").forward(request, response);
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codigoProducto"));
        String nombre = request.getParameter("nombre");
        String dimensiones = request.getParameter("dimensiones");
        String proveedor = request.getParameter("proveedor");
        String descripcion = request.getParameter("descripcion");
        int cantidadStock = Integer.parseInt(request.getParameter("cantidadStock"));
        BigDecimal precioVenta = new BigDecimal(request.getParameter("precioVenta"));
        BigDecimal precioDecimal = new BigDecimal(request.getParameter("precioDecimal"));
        int codigoCategoria = Integer.parseInt(request.getParameter("codigoCategoria"));

        Producto producto = new Producto();
        producto.setCodigoProducto(id);
        producto.setNombre(nombre);
        producto.setDimensiones(dimensiones);
        producto.setProveedor(proveedor);
        producto.setDescripcion(descripcion);
        producto.setCantidadStock(cantidadStock);
        producto.setPrecioVenta(precioVenta);
        producto.setPrecioDecimal(precioDecimal);
        CategoriaProducto categoria = new CategoriaProducto(codigoCategoria);
        producto.setCodigoCategoria(categoria);
        
        ProductoDAO dao = new ProductoDAOimpl();
        System.out.println("codigodeproducto"+producto.getCodigoProducto());
        if (producto.getCodigoProducto() == 0) {
            
                
            try {
                dao.insert(producto);
            } catch (Exception ex) {
                Logger.getLogger(ProductoServ.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                dao.update(producto);
                
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
        response.sendRedirect(request.getContextPath() + "/ProductoServ");
    }
}
