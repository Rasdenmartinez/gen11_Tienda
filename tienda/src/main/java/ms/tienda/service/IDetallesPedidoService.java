package ms.tienda.service;

import ms.tienda.entity.DetallesPedido;
import ms.tienda.entity.Productos;

import java.util.List;

public interface IDetallesPedidoService {
    public List<DetallesPedido> nomreadAll();

    public DetallesPedido readById(Long id);

    public DetallesPedido insert(DetallesPedido detallesPedido);

    public DetallesPedido update(DetallesPedido detallesPedido);

    public void delete(Long id);

}
