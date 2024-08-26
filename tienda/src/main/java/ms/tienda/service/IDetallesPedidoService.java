package ms.tienda.service;

import ms.tienda.entity.DetallesPedido;
import ms.tienda.entity.Productos;
import ms.tienda.model.DetallePedidoDto;
import ms.tienda.model.DetallesSinJoin;

import java.time.LocalDateTime;
import java.util.List;

public interface IDetallesPedidoService {
    public List<DetallesPedido> nomreadAll();

    public DetallesPedido readById(Integer id);

    public DetallesPedido insert(DetallesPedido detallesPedido);

    public DetallesPedido update(DetallesPedido detallesPedido);

    public void delete(Integer id);

    List<DetallePedidoDto> responseDtallePedidoDto();

    List<DetallesSinJoin> findDettalleSmple();





}
