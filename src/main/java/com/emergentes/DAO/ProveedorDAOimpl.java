package com.emergentes.DAO;

import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.Proveedor;
import com.emergentes.conexion.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOimpl extends ConexionDB implements ProveedorDAO {

    @Override
    public void insert(Proveedor proveedor) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into proveedor (codigo_proveedor, nombre_proveedor, contacto, telefono) "
                    + "values (?, ?, ?, ?)");
            ps.setInt(1, proveedor.getCodigoProveedor());
            ps.setString(2, proveedor.getNombreProveedor());
            ps.setString(3, proveedor.getContacto());
            ps.setString(4, proveedor.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

@Override
public void update(Proveedor proveedor) throws Exception {
    try {
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("update proveedor set nombre_proveedor=?, contacto=?, telefono=? where codigo_proveedor=?");
        ps.setString(1, proveedor.getNombreProveedor());
        ps.setString(2, proveedor.getContacto());
        ps.setString(3, proveedor.getTelefono());
        ps.setInt(4, proveedor.getCodigoProveedor());
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
            PreparedStatement ps = this.conn.prepareStatement("delete from proveedor where codigo_proveedor = ? ");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

@Override
public Proveedor getById(int id) throws Exception {
    Proveedor prove = new Proveedor();
    try {
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("select * from proveedor where codigo_proveedor =?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            prove.setCodigoProveedor(rs.getInt("codigo_proveedor"));  // Corregir nombre de columna
            prove.setNombreProveedor(rs.getString("nombre_proveedor")); // Corregir nombre de columna
            prove.setContacto(rs.getString("contacto"));
            prove.setTelefono(rs.getString("telefono"));
        }
    } catch (Exception e) {
        throw e;
    } finally {
        this.desconectar();
    }
    return prove;
}


    @Override
    public List<Proveedor> getAll() throws Exception {
        List<Proveedor> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from proveedor");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Proveedor>();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setCodigoProveedor(rs.getInt("codigo_proveedor"));
                proveedor.setNombreProveedor(rs.getString("nombre_proveedor"));
                proveedor.setContacto(rs.getString("contacto"));
                proveedor.setTelefono(rs.getString("telefono"));
                lista.add(proveedor);
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
