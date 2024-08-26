package ms.tienda.service;

import ms.tienda.entity.DetallesPedido;
import ms.tienda.entity.Productos;
<<<<<<< HEAD

=======
import ms.tienda.model.DetallePedidoDto;

import java.time.LocalDateTime;
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4
import java.util.List;

public interface IDetallesPedidoService {
    public List<DetallesPedido> nomreadAll();

    public DetallesPedido readById(Long id);

    public DetallesPedido insert(DetallesPedido detallesPedido);

    public DetallesPedido update(DetallesPedido detallesPedido);

    public void delete(Long id);
<<<<<<< HEAD
=======
    List<DetallePedidoDto> responseDtallePedidoDto( Double id,
    String name,
     String descripcionProducto,
     Double precio,
     LocalDateTime fechaPedido,
     Double totalPedido );
>>>>>>> 3cc2d4a95c00c2da8af68465b8b3847d44cb7ad4

}
