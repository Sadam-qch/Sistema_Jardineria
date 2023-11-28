package com.emergentes.DAO;

import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.DetallePedido;
import com.emergentes.modelo.Pedido;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetallePedidoDAOimpl extends ConexionDB implements DetallePedidoDAO {

    @Override
    public void insert(DetallePedido detallePedido) throws Exception {
        
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO detalle_pedido "
                    + "(codigo_producto, cantidad, precio_unidad, numero_linea,  codigo_pedidos, codigo_proveedor) VALUES "
                    + "( ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, detallePedido.getCodigoProducto().getCodigoProducto());
            ps.setInt(2, detallePedido.getCantidad());
            ps.setBigDecimal(3, detallePedido.getPrecioUnidad());
            ps.setInt(4, detallePedido.getNumeroLinea());
            ps.setInt(5, detallePedido.getCodigoPedidos().getCodigoPedido());
            ps.setInt(6, detallePedido.getCodigoProveedor().getCodigoProveedor());

            ps.executeUpdate();
        
            this.desconectar();
        
    }

    @Override
    public void update(DetallePedido detallePedido) throws Exception {
        
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE detalle_pedido SET "
                    + "codigo_producto = ?, cantidad = ?, precio_unidad = ?, numero_linea = ?, codigo_pedidos = ?, codigo_proveedor = ? "
                    + "WHERE codigo_pedido = ?");

            ps.setInt(1, detallePedido.getCodigoProducto().getCodigoProducto());
            ps.setInt(2, detallePedido.getCantidad());
            ps.setBigDecimal(3, detallePedido.getPrecioUnidad());
            ps.setInt(4, detallePedido.getNumeroLinea());
            ps.setInt(5, detallePedido.getCodigoPedidos().getCodigoPedido());
            ps.setInt(6, detallePedido.getCodigoProveedor().getCodigoProveedor());
            ps.setInt(7, detallePedido.getCodigoPedido());

            ps.executeUpdate();
        
            this.desconectar();
        
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM detalle_pedido WHERE codigo_pedido = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public DetallePedido getById(int id) throws Exception {
        DetallePedido detallePedido = new DetallePedido();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM detalle_pedido WHERE codigo_pedido = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                detallePedido.setCodigoPedido(rs.getInt("codigo_pedido"));
                detallePedido.setCantidad(rs.getInt("cantidad"));
                detallePedido.setPrecioUnidad(rs.getBigDecimal("precio_unidad"));
                detallePedido.setNumeroLinea(rs.getInt("numero_linea"));

                // Obtén los códigos de producto, pedido y proveedor como enteros
                int codigoProducto = rs.getInt("codigo_producto");
                int codigoPedidos = rs.getInt("codigo_pedidos");
                int codigoProveedor = rs.getInt("codigo_proveedor");

                // Crea objetos Producto, Pedido y Proveedor con los códigos y asígnalos a las propiedades
                Producto producto = new Producto();
                producto.setCodigoProducto(codigoProducto);
                detallePedido.setCodigoProducto(producto);

                Pedido pedido = new Pedido();
                pedido.setCodigoPedido(codigoPedidos);
                detallePedido.setCodigoPedidos(pedido);

                Proveedor proveedor = new Proveedor();
                proveedor.setCodigoProveedor(codigoProveedor);
                detallePedido.setCodigoProveedor(proveedor);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return detallePedido;
    }

    @Override
    public List<DetallePedido> getAll() throws Exception {
        List<DetallePedido> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM detalle_pedido");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<>();

            while (rs.next()) {
                DetallePedido detallePedido = new DetallePedido();
                detallePedido.setCodigoPedido(rs.getInt("codigo_pedido"));
                detallePedido.setCantidad(rs.getInt("cantidad"));
                detallePedido.setPrecioUnidad(rs.getBigDecimal("precio_unidad"));
                detallePedido.setNumeroLinea(rs.getInt("numero_linea"));

                // Obtén los códigos de producto, pedido y proveedor como enteros
                int codigoProducto = rs.getInt("codigo_producto");
                int codigoPedidos = rs.getInt("codigo_pedidos");
                int codigoProveedor = rs.getInt("codigo_proveedor");

                // Crea objetos Producto, Pedido y Proveedor con los códigos y asígnalos a las propiedades
                Producto producto = new Producto();
                producto.setCodigoProducto(codigoProducto);
                detallePedido.setCodigoProducto(producto); 

                Pedido pedido = new Pedido();
                pedido.setCodigoPedido(codigoPedidos);
                detallePedido.setCodigoPedidos(pedido);

                Proveedor proveedor = new Proveedor();
                proveedor.setCodigoProveedor(codigoProveedor);
                detallePedido.setCodigoProveedor(proveedor);

                lista.add(detallePedido);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
