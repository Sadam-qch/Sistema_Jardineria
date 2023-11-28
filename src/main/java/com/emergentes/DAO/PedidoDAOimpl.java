package com.emergentes.DAO;

import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PedidoDAOimpl extends ConexionDB implements PedidoDAO {

    @Override
    public void insert(Pedido pedido) throws Exception {
        
            Cliente cliente;
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO pedido "
                    + "(codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado, comentarios, codigo_cliente) VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, pedido.getCodigoPedido());
            ps.setDate(2, new java.sql.Date(pedido.getFechaPedido().getTime()));
            ps.setDate(3, (pedido.getFechaEsperada() != null) ? new java.sql.Date(pedido.getFechaEsperada().getTime()) : null);
            ps.setDate(4, new java.sql.Date(pedido.getFechaEntrega().getTime()));
            ps.setString(5, pedido.getEstado());
            ps.setString(6, pedido.getComentarios());
            ps.setInt(7, pedido.getCodigoCliente().getCodigo_cliente());
            ps.executeUpdate();
            
            this.desconectar();
    }

    @Override
    public void update(Pedido pedido) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update pedido set fecha_pedido = ?, fecha_esperada = ?, fecha_entrega = ?, "
                    + "estado = ?, comentarios = ?, codigo_cliente = ? where codigo_pedido = ?");

            ps.setDate(1, new java.sql.Date(pedido.getFechaPedido().getTime()));
            ps.setDate(2, new java.sql.Date(pedido.getFechaEsperada().getTime()));
            ps.setDate(3, new java.sql.Date(pedido.getFechaEntrega().getTime()));
            ps.setString(4, pedido.getEstado());
            ps.setString(5, pedido.getComentarios());
            ps.setInt(6, pedido.getCodigoCliente().getCodigo_cliente());
            ps.setInt(7, pedido.getCodigoPedido());
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
            PreparedStatement ps = this.conn.prepareStatement("delete from pedido where codigo_pedido = ? ");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Pedido getById(int id) throws Exception {
        Pedido pedi = new Pedido();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from pedido where codigo_pedido=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedi.setCodigoPedido(rs.getInt("codigo_pedido"));
                pedi.setFechaPedido(rs.getDate("fecha_pedido"));
                pedi.setFechaEsperada(rs.getDate("fecha_esperada"));
                pedi.setFechaEntrega(rs.getDate("fecha_entrega"));
                pedi.setEstado(rs.getString("estado"));
                pedi.setComentarios(rs.getString("comentarios"));
                int codigoCliente = rs.getInt("codigo_cliente");

                // Crea un objeto Cliente con el código y asigna a la propiedad
                Cliente cliente = new Cliente();
                cliente.setCodigo_cliente(codigoCliente);
                pedi.setCodigoCliente(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pedi;
    }

    @Override
    public List<Pedido> getAll() throws Exception {
        List<Pedido> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM pedido");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Pedido>();
            while (rs.next()) {
                Pedido pedi = new Pedido();
                pedi.setCodigoPedido(rs.getInt("codigo_pedido"));
                pedi.setFechaPedido(rs.getDate("fecha_pedido"));
                pedi.setFechaEsperada(rs.getDate("fecha_esperada"));
                pedi.setFechaEntrega(rs.getDate("fecha_entrega"));
                pedi.setEstado(rs.getString("estado"));
                pedi.setComentarios(rs.getString("comentarios"));
                int codigoCliente = rs.getInt("codigo_cliente");
                // Crea un objeto Cliente con el código y asigna a la propiedad
                Cliente cliente = new Cliente();
                cliente.setCodigo_cliente(codigoCliente);
                pedi.setCodigoCliente(cliente);

                lista.add(pedi);
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
