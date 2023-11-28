
package com.emergentes.DAO;

import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.Pago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PagoDAOimp extends ConexionDB implements  PagoDAO{

    @Override
    public void insert(Pago pago) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO pago (codigo_cliente, forma_pago, fecha_pago, total)VALUES (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, pago.getCodigo_cliente());
            ps.setString(2, pago.getForma_pago());
            ps.setDate(3, pago.getFecha_pago());
            ps.setBigDecimal(4, pago.getTotal());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Pago pago) throws Exception {
         try {
            this.conectar();
            String sql = "update pago set codigo_cliente=?, forma_pago=?, fecha_pago=?, total=? where id_transaccion=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, pago.getCodigo_cliente());
            ps.setString(2, pago.getForma_pago());
            ps.setDate(3, pago.getFecha_pago());
            ps.setBigDecimal(4, pago.getTotal());
            ps.setInt(5, pago.getId_transaccion());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
         try {
            this.conectar();
            String sql = "DELETE FROM pago where id_transaccion=?";
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
    public Pago getById(int id) throws Exception {
        Pago pago = new Pago();
        try {
            this.conectar();
            String sql = "select *from pago where id_transaccion=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                pago.setCodigo_cliente(rs.getInt("codigo_cliente"));
                pago.setForma_pago(rs.getString("forma_pago"));
                pago.setId_transaccion(rs.getInt("id_transaccion"));
                pago.setFecha_pago(rs.getDate("fecha_pago"));
                pago.setTotal(rs.getBigDecimal("total"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return pago;
    }

    @Override
    public List<Pago> getAll() throws Exception {
        List<Pago> lista = null;
        try {
            this.conectar();
            String sql = "select *from pago";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Pago>();
            
            while(rs.next()){
                Pago pa = new Pago();
                pa.setCodigo_cliente(rs.getInt("codigo_cliente"));
                pa.setForma_pago(rs.getString("forma_pago"));
                pa.setId_transaccion(rs.getInt("id_transaccion"));
                pa.setFecha_pago(rs.getDate("fecha_pago"));
                pa.setTotal(rs.getBigDecimal("total"));
                lista.add(pa);
            }
            rs.close();
            ps.close();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
