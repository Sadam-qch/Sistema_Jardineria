/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.DAO;

import com.emergentes.modelo.DetallePedido;
import java.util.List;

/**
 *
 * @author Sadam
 */
public interface DetallePedidoDAO {
     public void insert(DetallePedido detallePedido) throws Exception;

    public void update(DetallePedido detallePedido) throws Exception;

    public void delete(int id) throws Exception;

    public DetallePedido getById(int id) throws Exception;

    public List<DetallePedido> getAll() throws Exception;

}
