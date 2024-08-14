package ms.tienda.service;

import ms.tienda.entity.Inventario;

import java.util.List;

public interface IInventarioService {
    public List<Inventario> readAll();

    public Inventario readById(Long id);

    public Inventario insert(Inventario inventario);

    public Inventario update(Inventario inventario);

    public void delete(Long id);

}
