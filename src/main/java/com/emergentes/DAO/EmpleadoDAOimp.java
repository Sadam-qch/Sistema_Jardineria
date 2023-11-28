package com.emergentes.DAO;

import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOimp extends ConexionDB implements EmpleadoDAO {

    @Override
    public void insert(Empleado empleado) throws Exception {
        try {
            String sql = "insert into empleado (nombre, apellido1, apellido2, extension, email, codigo_oficina, puesto)values(?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setString(4, empleado.getExtension());
            ps.setString(5, empleado.getEmail());
            ps.setInt(6, empleado.getCodigo_oficina());
            ps.setString(7, empleado.getPuesto());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Empleado empleado) throws Exception {
        try {
            String sql = "update empleado set nombre=?, apellido1=?, apellido2=?, extension=?, email=?, codigo_oficina=?, puesto=? where codigo_empleado=?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setString(4, empleado.getExtension());
            ps.setString(5, empleado.getEmail());
            ps.setInt(6, empleado.getCodigo_oficina());
            ps.setString(7, empleado.getPuesto());
            ps.setInt(8, empleado.getCodigo_empleado());
            ps.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from empleado where codigo_empleado=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public Empleado getById(int id) throws Exception {
        Empleado empleado = new Empleado();
        try {
            String sql = "select *from empleado where codigo_empleado=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empleado.setCodigo_empleado(rs.getInt("codigo_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido1(rs.getString("apellido1"));
                empleado.setApellido2(rs.getString("apellido2"));
                empleado.setExtension(rs.getString("extension"));
                empleado.setEmail(rs.getString("email"));
                empleado.setCodigo_oficina(rs.getInt("codigo_oficina"));
                empleado.setPuesto(rs.getString("puesto"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
        }
        this.desconectar();
        return empleado;
    }

    @Override
    public List<Empleado> getAll() throws Exception {
        List<Empleado> lista = null;
        String sql = "select *from empleado";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Empleado>();
        while (rs.next()) {
            Empleado empleado = new Empleado();
            empleado.setCodigo_empleado(rs.getInt("codigo_empleado"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido1(rs.getString("apellido1"));
            empleado.setApellido2(rs.getString("apellido2"));
            empleado.setExtension(rs.getString("extension"));
            empleado.setEmail(rs.getString("email"));
            empleado.setCodigo_oficina(rs.getInt("codigo_oficina"));
            empleado.setPuesto(rs.getString("puesto"));
            lista.add(empleado);
        }
        this.desconectar();
        return lista;
    }

}
