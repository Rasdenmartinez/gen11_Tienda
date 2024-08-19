package ms.tienda.service;

import ms.tienda.entity.Pedidos;
import ms.tienda.entity.Productos;

import java.util.List;

public interface IPedidosService {
    public List<Pedidos> nomreadAll();

    public Pedidos readById(Long id);

    public Pedidos insert(Pedidos pedidos);

    public Pedidos update(Pedidos pedidos);

    public void delete(Long id);
}
