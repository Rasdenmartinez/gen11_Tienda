package ms.tienda.service;

import ms.tienda.entity.Inventario;
import ms.tienda.model.ResponseDelete;
import ms.tienda.model.ResponseInventario;

import java.util.List;

public interface IInventarioService {
    public List<ResponseInventario> readAll();

    public ResponseInventario readById(Double id);

    public Inventario insert(Inventario inventario);

    public Inventario update(Inventario inventario);

    public ResponseDelete delete(Double id);

}
