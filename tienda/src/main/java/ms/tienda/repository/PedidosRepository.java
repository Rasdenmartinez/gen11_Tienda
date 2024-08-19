package ms.tienda.repository;

import ms.tienda.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
