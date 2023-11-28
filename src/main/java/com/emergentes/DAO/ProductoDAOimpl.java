package com.emergentes.DAO;

import com.emergentes.modelo.CategoriaProducto;
import com.emergentes.modelo.Producto;
import com.emergentes.conexion.ConexionDB;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimpl extends ConexionDB implements ProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(
                    "INSERT INTO producto (nombre, dimensiones, proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor, codigo_categoria) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDimensiones());
            ps.setString(3, producto.getProveedor());
            ps.setString(4, producto.getDescripcion());
            ps.setInt(5, producto.getCantidadStock());
            ps.setBigDecimal(6, producto.getPrecioVenta());
            ps.setBigDecimal(7, producto.getPrecioDecimal());
            ps.setInt(8, producto.getCodigoCategoria().getCodigoCategoria());
            ps.executeUpdate();
            
            this.desconectar();
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(
                    "UPDATE producto SET nombre=?, dimensiones=?, proveedor=?, descripcion=?, cantidad_en_stock=?, "
                            + "precio_venta=?, precio_proveedor=?, codigo_categoria=? WHERE codigo_producto=?"
            );
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDimensiones());
            ps.setString(3, producto.getProveedor());
            ps.setString(4, producto.getDescripcion());
            ps.setInt(5, producto.getCantidadStock());
            ps.setBigDecimal(6, producto.getPrecioVenta());
            ps.setBigDecimal(7, producto.getPrecioDecimal());
            ps.setInt(8, producto.getCodigoCategoria().getCodigoCategoria());
            ps.setInt(9, producto.getCodigoProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM producto WHERE codigo_producto = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto producto = new Producto();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM producto WHERE codigo_producto = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto.setCodigoProducto(rs.getInt("codigo_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDimensiones(rs.getString("dimensiones"));
                producto.setProveedor(rs.getString("proveedor"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidadStock(rs.getInt("cantidad_en_stock"));
                producto.setPrecioVenta(rs.getBigDecimal("precio_venta"));
                producto.setPrecioDecimal(rs.getBigDecimal("precio_proveedor"));

                // Assuming CategoriaProducto has a constructor that takes codigoCategoria as a parameter
                producto.setCodigoCategoria(new CategoriaProducto(rs.getInt("codigo_categoria")));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return producto;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        List<Producto> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM producto");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Producto>();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigoProducto(rs.getInt("codigo_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDimensiones(rs.getString("dimensiones"));
                producto.setProveedor(rs.getString("proveedor"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidadStock(rs.getInt("cantidad_en_stock"));
                producto.setPrecioVenta(rs.getBigDecimal("precio_venta"));
                producto.setPrecioDecimal(rs.getBigDecimal("precio_proveedor"));

                // Assuming CategoriaProducto has a constructor that takes codigoCategoria as a parameter
                producto.setCodigoCategoria(new CategoriaProducto(rs.getInt("codigo_categoria")));

                lista.add(producto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
