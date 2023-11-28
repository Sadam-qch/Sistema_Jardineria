/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.DAO;

import com.emergentes.modelo.CategoriaProducto;
import java.util.List;

/**
 *
 * @author Sadam
 */
public interface CategoriaProductoDAO {
    public void insert(CategoriaProducto categoriaProducto) throws Exception;

    public void update(CategoriaProducto categoriaProducto) throws Exception;

    public void delete(int id) throws Exception;

    public CategoriaProducto getById(int id) throws Exception;

    public List<CategoriaProducto> getAll() throws Exception;

}
