package ms.tienda.service;

import ms.tienda.entity.Pedidos;
import ms.tienda.entity.Productos;
import ms.tienda.model.PedidosDto;

import java.util.List;

public interface IPedidosService {
    public List<Pedidos> nomreadAll();

    public Pedidos readById(Double id);

    public Pedidos insert(Pedidos pedidos);

    public Pedidos update(Pedidos pedidos);

  //  public void delete(Double id); Mensaje DTO
  public String pedidoDeleteDto(Double id);

    public List<PedidosDto> findByPedidosDto();

    public List<PedidosDto> findClienteById(Long id);
}
