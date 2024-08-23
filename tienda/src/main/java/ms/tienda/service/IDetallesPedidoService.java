package ms.tienda.service;

import ms.tienda.entity.DetallesPedido;
import ms.tienda.entity.Productos;
import ms.tienda.model.DetallePedidoDto;

import java.time.LocalDateTime;
import java.util.List;

public interface IDetallesPedidoService {
    public List<DetallesPedido> nomreadAll();

    public DetallesPedido readById(Long id);

    public DetallesPedido insert(DetallesPedido detallesPedido);

    public DetallesPedido update(DetallesPedido detallesPedido);

    public void delete(Long id);
    List<DetallePedidoDto> responseDtallePedidoDto( Double id,
    String name,
     String descripcionProducto,
     Double precio,
     LocalDateTime fechaPedido,
     Double totalPedido );

}
