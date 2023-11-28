package com.emergentes.DAO;

import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimp extends ConexionDB implements ClienteDAO {

    @Override
    public void insert(Cliente cliente) throws Exception {
       
            
            String sql = "INSERT INTO cliente (nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, " +
             "linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal, codigo_empleado, limite_credito) " +
             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre_cliente());
            ps.setString(2, cliente.getNombre_contacto());
            ps.setString(3, cliente.getApellido_contacto());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getFax());
            ps.setString(6, cliente.getLinea_direccion1());
            ps.setString(7, cliente.getLinea_direccion2());
            ps.setString(8, cliente.getCiudad());
            ps.setString(9, cliente.getRegion());
            ps.setString(10, cliente.getPais());
            ps.setString(11, cliente.getCodigo_postal());
            ps.setInt(12, cliente.getCodigo_empleado());
            ps.setBigDecimal(13, cliente.getLimite_credito());
            
            ps.executeUpdate();
        
            this.desconectar();
        
    }

    @Override
    public void update(Cliente cliente) throws Exception {
     
            this.conectar();
            String sql = "update cliente set nombre_cliente=?, nombre_contacto=?, apellido_contacto=?, telefono=?, fax=?, ";
             sql += "linea_direccion1=?, linea_direccion2=?, ciudad=?, region=?, pais=?, codigo_postal=?, codigo_empleado=?, limite_credito=? ";
             sql += "where codigo_cliente=?";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre_cliente());
            ps.setString(2, cliente.getNombre_contacto());
            ps.setString(3, cliente.getApellido_contacto());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getFax());
            ps.setString(6, cliente.getLinea_direccion1());
            ps.setString(7, cliente.getLinea_direccion2());
            ps.setString(8, cliente.getCiudad());
            ps.setString(9, cliente.getRegion());
            ps.setString(10, cliente.getPais());
            ps.setString(11, cliente.getCodigo_postal());
            ps.setInt(12, cliente.getCodigo_empleado());
            ps.setBigDecimal(13, cliente.getLimite_credito());
            ps.setInt(14, cliente.getCodigo_cliente());
            ps.executeUpdate();
        
            this.desconectar();
        
    }

    @Override
    public void delete(int id) throws Exception {
         try {
            this.conectar();
            String sql = "delete from cliente where codigo_cliente=?";
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
    public Cliente getById(int id) throws Exception {
        Cliente cliente = new Cliente();
        try {
            this.conectar();
            String sql = "select *from cliente where codigo_cliente=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cliente.setCodigo_cliente(rs.getInt("codigo_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                cliente.setNombre_contacto(rs.getString("nombre_contacto"));
                cliente.setApellido_contacto(rs.getString("apellido_contacto"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFax(rs.getString("fax"));
                cliente.setLinea_direccion1(rs.getString("linea_direccion1"));
                cliente.setLinea_direccion2(rs.getString("linea_direccion2"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setRegion(rs.getString("region"));
                cliente.setPais(rs.getString("region"));
                cliente.setCodigo_postal(rs.getString("codigo_postal"));
                cliente.setCodigo_empleado(rs.getInt("codigo_empleado"));
                cliente.setLimite_credito(rs.getBigDecimal("limite_credito"));
        
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        try {
            this.conectar();
            String sql = "select *from cliente";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Cliente>();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigo_cliente(rs.getInt("codigo_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                cliente.setNombre_contacto(rs.getString("nombre_contacto"));
                cliente.setApellido_contacto(rs.getString("apellido_contacto"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFax(rs.getString("fax"));
                cliente.setLinea_direccion1(rs.getString("linea_direccion1"));
                cliente.setLinea_direccion2(rs.getString("linea_direccion2"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setRegion(rs.getString("region"));
                cliente.setPais(rs.getString("region"));
                cliente.setCodigo_postal(rs.getString("codigo_postal"));
                cliente.setCodigo_empleado(rs.getInt("codigo_empleado"));
                cliente.setLimite_credito(rs.getBigDecimal("limite_credito"));
                lista.add(cliente);
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
