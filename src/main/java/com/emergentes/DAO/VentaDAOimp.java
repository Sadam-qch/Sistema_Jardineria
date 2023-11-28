package com.emergentes.DAO;

import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimp extends ConexionDB implements VentaDAO {

    @Override

    public void insert(Venta venta) throws Exception {
        this.conectar();
        String sql = "INSERT INTO venta (fecha_venta, codigo_cliente, codigo_empleado, codigo_producto, cantidad, precio_unitario, total_venta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setDate(1, venta.getFecha_venta());
        ps.setInt(2, venta.getCodigo_cliente());
        ps.setInt(3, venta.getCodigo_empleado());
        ps.setInt(4, venta.getCodigo_producto());
        ps.setInt(5, venta.getCantidad());
        ps.setBigDecimal(6, venta.getPrecio_unitario());
        ps.setBigDecimal(7, venta.getTotal_venta());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Venta venta) throws Exception {

        this.conectar();
        String sql = "update venta set fecha_venta=?, codigo_cliente=?, codigo_empleado=?, codigo_producto=?, cantidad=?, precio_unitario=? ,total_venta=? where codigo_venta=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setDate(1, venta.getFecha_venta());
        ps.setInt(2, venta.getCodigo_cliente());
        ps.setInt(3, venta.getCodigo_empleado());
        ps.setInt(4, venta.getCodigo_producto());
        ps.setInt(5, venta.getCantidad());
        ps.setBigDecimal(6, venta.getPrecio_unitario());
        ps.setBigDecimal(7, venta.getTotal_venta());
        ps.setInt(8, venta.getCodigo_venta());
        ps.executeUpdate();

        this.desconectar();

    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM venta where codigo_venta=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Venta getById(int id) throws Exception {
        Venta venta = new Venta();
        try {
            this.conectar();
            String sql = "select *from venta where codigo_venta=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                venta.setCodigo_venta(rs.getInt("codigo_venta"));
                venta.setFecha_venta(rs.getDate("fecha_venta"));
                venta.setCodigo_cliente(rs.getInt("codigo_cliente"));
                venta.setCodigo_empleado(rs.getInt("codigo_empleado"));
                venta.setCodigo_producto(rs.getInt("codigo_producto"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setPrecio_unitario(rs.getBigDecimal("precio_unitario"));
                venta.setTotal_venta(rs.getBigDecimal("total_venta"));

            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return venta;
    }

    @Override
    public List<Venta> getAll() throws Exception {
        List<Venta> lista = null;

        String sql = "select *from venta";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Venta>();

        while (rs.next()) {
            Venta venta = new Venta();
            venta.setCodigo_venta(rs.getInt("codigo_venta"));
            venta.setFecha_venta(rs.getDate("fecha_venta"));
            venta.setCodigo_cliente(rs.getInt("codigo_cliente"));
            venta.setCodigo_empleado(rs.getInt("codigo_empleado"));
            venta.setCodigo_producto(rs.getInt("codigo_producto"));
            venta.setCantidad(rs.getInt("cantidad"));
            venta.setPrecio_unitario(rs.getBigDecimal("precio_unitario"));
            venta.setTotal_venta(rs.getBigDecimal("total_venta"));

            lista.add(venta);
        }
        this.desconectar();
        return lista;

    }

}
