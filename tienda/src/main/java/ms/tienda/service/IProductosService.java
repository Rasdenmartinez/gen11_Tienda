package ms.tienda.service;

import ms.tienda.entity.Productos;
import ms.tienda.model.ResponseDelete;

import java.util.List;

public interface IProductosService {
    public List<Productos>readAll();

    public Productos readById(Double id);

    public Productos insert(Productos producto);

    public Productos update(Productos producto);

    public void delete(Double id);
}
