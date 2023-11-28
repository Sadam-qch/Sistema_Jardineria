
package com.emergentes.DAO;

import com.emergentes.modelo.Pago;
import java.util.List;

public interface PagoDAO {
    public void insert(Pago pago) throws Exception;
    public void update(Pago pago) throws Exception;
    public void delete(int id)throws Exception;
    public Pago getById(int id) throws Exception;
    public List<Pago> getAll() throws Exception;
}
