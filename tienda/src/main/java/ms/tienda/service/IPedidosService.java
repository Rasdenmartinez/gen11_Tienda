package ms.tienda.service;

import ms.tienda.entity.Pedidos;
import ms.tienda.entity.Productos;
import ms.tienda.model.PedidosDto;

import java.util.List;

public interface IPedidosService {
    public List<Pedidos> nomreadAll();

    public Pedidos readById(Integer idPedido);

    public Pedidos insert(Pedidos pedidos);

    public Pedidos update(Pedidos pedidos);

    public void delete(Integer idPedido);

    public List<PedidosDto> findByPedidosDto();
}
