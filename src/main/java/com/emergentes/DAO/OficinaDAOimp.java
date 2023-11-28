
package com.emergentes.DAO;

import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.Oficina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAOimp extends ConexionDB implements OficinaDAO{

    @Override
    public void insert(Oficina oficina) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO oficina (ciudad,pais,region,codigo_postal,telefono,linea_direccion1,linea_direccion2)";
            sql += "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, oficina.getCiudad());
            ps.setString(2, oficina.getPais());
            ps.setString(3, oficina.getRegion());
            ps.setString(4, oficina.getCodigo_postal());
            ps.setString(5, oficina.getTelefono());
            ps.setString(6, oficina.getLinea_direccion1());
            ps.setString(7, oficina.getLinea_direccion2());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Oficina oficina) throws Exception {

            this.conectar();
            String sql = "UPDATE oficina set ciudad=?,pais=?,region=?,codigo_postal=?,telefono=?,linea_direccion1=?,linea_direccion2=? where codigo_oficina=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, oficina.getCiudad());
            ps.setString(2, oficina.getPais());
            ps.setString(3, oficina.getRegion());
            ps.setString(4, oficina.getCodigo_postal());
            ps.setString(5, oficina.getTelefono());
            ps.setString(6, oficina.getLinea_direccion1());
            ps.setString(7, oficina.getLinea_direccion2());
            ps.setInt(8, oficina.getCodigo_oficina());
            ps.executeUpdate();

            this.desconectar();

    }

    @Override
    public void delete(int id) throws Exception {
         try {
            this.conectar();
            String sql = "delete from oficina where codigo_oficina=?";
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
    public Oficina getById(int id) throws Exception {
      Oficina oficina = new Oficina();
      try {
            this.conectar();
            String sql = "select *from oficina where codigo_oficina=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                oficina.setCodigo_oficina(rs.getInt("codigo_oficina"));
                oficina.setCiudad(rs.getString("ciudad"));
                oficina.setPais(rs.getString("pais"));
                oficina.setRegion(rs.getString("region"));
                oficina.setCodigo_postal(rs.getString("codigo_postal"));
                oficina.setTelefono(rs.getString("telefono"));
                oficina.setLinea_direccion1(rs.getString("linea_direccion1"));
                oficina.setLinea_direccion2(rs.getString("linea_direccion2"));
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            
        }
      this.desconectar();
      return oficina;
    }

    @Override
    public List<Oficina> getAll() throws Exception {
          List<Oficina> lista = null;
          try {
            this.conectar();
            String sql = "select *from oficina";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Oficina>();
            
            while(rs.next()){
                Oficina of = new Oficina();
                of.setCodigo_oficina(rs.getInt("codigo_oficina"));
                of.setCiudad(rs.getString("ciudad"));
                of.setPais(rs.getString("pais"));
                of.setRegion(rs.getString("region"));
                of.setCodigo_postal(rs.getString("codigo_postal"));
                of.setTelefono(rs.getString("telefono"));
                of.setLinea_direccion1(rs.getString("linea_direccion1"));
                of.setLinea_direccion2(rs.getString("linea_direccion2"));
                lista.add(of);
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
