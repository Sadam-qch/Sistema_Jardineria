package com.emergentes.DAO;

import com.emergentes.conexion.ConexionDB;
import com.emergentes.modelo.CategoriaProducto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaProductoDAOimpl extends ConexionDB implements CategoriaProductoDAO {

    @Override
    public void insert(CategoriaProducto categoriaProducto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO categoria_producto (codigo_categoria, nombre_categoria, descripcion_categoria)\n" +
"VALUES (?, ?, ?)");
            ps.setInt(1, categoriaProducto.getCodigoCategoria());
            ps.setString(2, categoriaProducto.getNombreCategoria());
            ps.setString(3, categoriaProducto.getDescripcionCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(CategoriaProducto categoriaProducto) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update categoria_producto set nombre_categoria=?, descripcion_categoria=? where codigo_categoria=?");
            ps.setString(1, categoriaProducto.getNombreCategoria());
            ps.setString(2, categoriaProducto.getDescripcionCategoria());
            ps.setInt(3, categoriaProducto.getCodigoCategoria());
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
            PreparedStatement ps = this.conn.prepareStatement("delete from categoria_producto where codigo_categoria = ? ");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public CategoriaProducto getById(int id) throws Exception {
        CategoriaProducto categoriaProducto = new CategoriaProducto();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from categoria_producto where codigo_categoria =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categoriaProducto.setCodigoCategoria(rs.getInt("codigo_categoria"));  // Corregir nombre de columna
                categoriaProducto.setNombreCategoria(rs.getString("nombre_categoria")); // Corregir nombre de columna
                categoriaProducto.setDescripcionCategoria(rs.getString("descripcion_categoria"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return categoriaProducto;
    }

    @Override
    public List<CategoriaProducto> getAll() throws Exception {
        List<CategoriaProducto> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from categoria_producto");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<CategoriaProducto>();
            while (rs.next()) {
                CategoriaProducto categoriaProducto = new CategoriaProducto();
                categoriaProducto.setCodigoCategoria(rs.getInt("codigo_categoria"));
                categoriaProducto.setNombreCategoria(rs.getString("nombre_categoria"));
                categoriaProducto.setDescripcionCategoria(rs.getString("descripcion_categoria"));
                lista.add(categoriaProducto);
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
