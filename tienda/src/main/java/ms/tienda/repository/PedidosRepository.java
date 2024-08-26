package ms.tienda.repository;

import ms.tienda.entity.Pedidos;
import ms.tienda.model.DeleteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
    @Query(value = "SELECT p.id, p.fecha_pedido, p.total_pedido, p.is_active, p.creacion_fecha, modificacion_fecha, p.cliente_id " +
            " FROM pedidos p "+
            "INNER JOIN clientes c on p.cliente_id = c.id ", nativeQuery = true)
    public List<Pedidos> findByPedidosDto();


}
