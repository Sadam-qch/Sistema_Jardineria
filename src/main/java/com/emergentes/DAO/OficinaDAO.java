
package com.emergentes.DAO;

import com.emergentes.modelo.Oficina;
import java.util.List;

public interface OficinaDAO {
    public void insert(Oficina oficina) throws Exception;
    public void update(Oficina oficina) throws Exception;
    public void delete(int id)throws Exception;
    public Oficina getById(int id) throws Exception;
    public List<Oficina> getAll() throws Exception;
}
