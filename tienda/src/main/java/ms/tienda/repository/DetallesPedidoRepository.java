package ms.tienda.repository;

import ms.tienda.entity.DetallesPedido;
import ms.tienda.entity.Pedidos;
import ms.tienda.entity.Productos;
import ms.tienda.model.DetallePedidoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetallesPedidoRepository extends JpaRepository<DetallesPedido, Double> {

  /* @Query(value = "select dp.id,  dp.creacion_fecha, dp.cantidad, p.id, p.descripcion_producto " +
             " from detalles_pedido dp\n" +
             " inner join productos p on dp.producto_id = p.id \n" +
             " where dp.id = :id and p.producto = :name ", nativeQuery = true)
  List<DetallesPedido> findByIdDetallesPedidoAndNameProductos(Double id, String name);*/

    @Query(value = "SELECT detalles_pedido.id,  detalles_pedido.precio_unitario,\n" +
            "       detalles_pedido.pedido_id, detalles_pedido.producto_id, detalles_pedido.is_active,\n" +
            "       detalles_pedido.creacion_fecha, detalles_pedido.modificacion_fecha\n" +
            " FROM detalles_pedido\n" +
            " INNER JOIN productos p ON detalles_pedido.producto_id = p.id\n" +
            " INNER JOIN pedidos pe ON detalles_pedido.pedido_id = pe.id " , nativeQuery = true)
    List<DetallesPedido> findDetallesPedidoProductoDto();
    @Query(value = "SELECT detalles_pedido.id, detalles_pedido.cantidad, detalles_pedido.precio_unitario,\n" +
            "       detalles_pedido.pedido_id, detalles_pedido.producto_id, detalles_pedido.is_active,\n" +
            "       detalles_pedido.creacion_fecha, detalles_pedido.modificacion_fecha\n" +
            " FROM detalles_pedido\n", nativeQuery = true)
    List<DetallesPedido> finDetallesSimple();



}
