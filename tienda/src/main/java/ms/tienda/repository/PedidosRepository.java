package ms.tienda.repository;

import ms.tienda.entity.Pedidos;
import ms.tienda.model.DeleteDto;
import ms.tienda.model.PedidosDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedidos, Double> {
    @Query(value = "SELECT p.id_pedido, p.fecha_pedido, p.total_pedido, p.is_active, p.creacion_fecha, modificacion_fecha, p.cliente_id, p.cantidad " +
            " FROM pedidos p "+
            "INNER JOIN clientes c on p.cliente_id = c.id ", nativeQuery = true)
    public List<Pedidos> findByPedidosDto();
    @Query(value = "SELECT p.id_pedido, p.fecha_pedido, p.total_pedido, p.is_active, p.creacion_fecha, modificacion_fecha, p.cliente_id, p.cantidad " +
            " FROM pedidos p "+
            "INNER JOIN clientes c on p.cliente_id = c.id "+
            "where c.id = :id", nativeQuery = true)
    public List<Pedidos> findByClienteId(Long id);


}
